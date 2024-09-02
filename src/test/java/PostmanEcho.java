import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class PostmanEcho {

public static RequestSpecification requestSpec;
public static ResponseSpecification responseSpec;

static {
	LoggerFactory.getLogger(PostmanEcho.class);
}

@BeforeAll
public static void setRequestSpec() {
	requestSpec = given()
			              .baseUri("https://postman-echo.com")
			              .headers("User-Agent", "PostmanRuntime/7.39.0",
					              "Accept", "*/*",
					              "Accept-Encoding", "gzip, deflate, br",
					              "Connection", "keep-alive");
}

@BeforeAll
public static void setResponseSpec() {
	responseSpec = expect()
			               .statusCode(200)
			               .body("headers.x-forwarded-proto", equalTo("http"),
					               "headers.host", equalTo("postman-echo.com"),
					               "headers.accept", equalTo("*/*"),
					               "headers.accept-encoding", equalTo("gzip, deflate, br"),
					               "headers.user-agent", equalTo("PostmanRuntime/7.39.0"),
					               "headers.x-forwarded-port", equalTo("443"));
}

@Test
@DisplayName("Get Request Woops")
public void get_request_test() {
	given().log().headers().spec(requestSpec)
			.queryParam("foo1", "bar1")
			.queryParam("foo2", "bar2")
			.when()
			.get("/get")
			.then().log().body().spec(responseSpec)
			.body(
					"args.foo1", equalTo("bar1"),
					"args.foo2", equalTo("bar2"),
					"url", equalTo("http://postman-echo.com/get?foo1=bar1&foo2=bar2"),
					"headers.x-forwarded-proto", equalTo("http"));
}

@Test
@DisplayName("POST Raw Test")
public void post_request_raw_test() {
	given().log().body().spec(requestSpec)
			.headers("Content-Type", "text/plain")
			.body("some string")
			.when()
			.post("/post")
			.then().log().body()
			.spec(responseSpec)
			.body(
					"data", equalTo("some string"),
					"headers.content-length", equalTo("11"),
					"headers.content-type", equalTo("text/plain; charset=ISO-8859-1"),
					"json", equalTo(null),
					"url", equalTo("http://postman-echo.com/post")
			);
}

@Test
@DisplayName("POST Form Data")
public void post_request_data_test() {
	given().log().body().spec(requestSpec)
			.headers("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
			.formParams("foo1", "bar1", "foo2", "bar2")
			.when()
			.post("/post")
			.then().log().body()
			.spec(responseSpec)
			.body(
					"form.foo1", equalTo("bar1"),
					"form.foo2", equalTo("bar2"),
					"headers.content-length", equalTo("19"),
					"headers.content-type", equalTo("application/x-www-form-urlencoded; charset=UTF-8"),
					"json.foo1", equalTo("bar1"),
					"json.foo2", equalTo("bar2"),
					"url", equalTo("http://postman-echo.com/post"));
}

@Test
@DisplayName("PUT request")
public void put_request_tests() {
	given().log().body().spec(requestSpec)
			.headers("Content-Type", "text/plain")
			.body("This is expected to be sent back as part of response body.")
			.when()
			.put("/put")
			.then().log().body()
			.spec(responseSpec)
			.body(
					"data", equalTo("This is expected to be sent back as part of response body."),
					"headers.content-length", equalTo("58"),
					"headers.content-type", equalTo("text/plain; charset=ISO-8859-1"),
					"json", equalTo(null),
					"url", equalTo("http://postman-echo.com/put"));
}

@Test
@DisplayName("PATCH request")
public void patch_request_test() {
	given().log().body().spec(requestSpec)
			.headers("Content-Type", "text/plain")
			.body("This is expected to be sent back as part of response body.")
			.when()
			.patch("/patch")
			.then().log().body()
			.spec(responseSpec)
			.body(
					"data", equalTo("This is expected to be sent back as part of response body."),
					"headers.content-length", equalTo("58"),
					"headers.content-type", equalTo("text/plain; charset=ISO-8859-1"),
					"json", equalTo(null),
					"url", equalTo("http://postman-echo.com/patch"));
}

@Test
@DisplayName("PUT request")
public void put_request_test() {
	given().log().body().spec(requestSpec)
			.headers("Content-Type", "text/plain")
			.body("This is expected to be sent back as part of response body.")
			.when()
			.put("/put")
			.then().log().body()
			.spec(responseSpec)
			.body(
					"data", equalTo("This is expected to be sent back as part of response body."),
					"headers.content-length", equalTo("58"),
					"headers.content-type", equalTo("text/plain; charset=ISO-8859-1"),
					"json", equalTo(null),
					"headers.x-forwarded-proto", equalTo("http"),
					"url", equalTo("http://postman-echo.com/put"));
}
}