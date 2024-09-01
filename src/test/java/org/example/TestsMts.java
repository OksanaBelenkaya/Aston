package org.example;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class TestsMts {
public static WebDriver driver;

@BeforeClass
public void setUp() {
	
	driver = new ChromeDriver();
	driver.get("https://www.mts.by/");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cookie__buttons']/button[@id='cookie-agree']")));
	button.click();
}

@Test
public void connection() {
	WebElement selectElement = driver.findElement(By.xpath("//select[@id='pay']"));
	WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Услуги связи')]"));
	
	Actions builder = new Actions(driver);
	builder
			.click(selectElement)
			.click(selectElement2)
			.build()
			.perform();
	
	List<WebElement> elementsConnection = driver.findElements(By.xpath("//form[@id='pay-connection']/descendant::input"));
	LinkedList<String> expectedText = new LinkedList<>();
	expectedText.add(0, "Номер телефона");
	expectedText.add(1, "Сумма");
	expectedText.add(2, "E-mail для отправки чека");
	LinkedList<String> actualText = new LinkedList<>();
	for (WebElement element : elementsConnection) {
		actualText.add(element.getAttribute("placeholder"));
	}
	Assertions.assertEquals(actualText, expectedText);
	System.out.println("Надписи соответствуют полям");
}

@Test
public void internetConnection() {
	WebElement selectElement = driver.findElement(By.xpath("//select[@id='pay']"));
	WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Домашний интернет')]"));
	
	Actions builder = new Actions(driver);
	builder
			.click(selectElement)
			.click(selectElement2)
			.build()
			.perform();
	
	List<WebElement> elementsInternet = driver.findElements(By.xpath("//form[@id='pay-internet']/descendant::input"));
	LinkedList<String> expectedText = new LinkedList<>();
	expectedText.add(0, "Номер абонента");
	expectedText.add(1, "Сумма");
	expectedText.add(2, "E-mail для отправки чека");
	LinkedList<String> actualText = new LinkedList<>();
	for (WebElement element : elementsInternet) {
		actualText.add(element.getAttribute("placeholder"));
	}
	Assertions.assertEquals(actualText, expectedText);
	System.out.println("Надписи соответствуют полям");
}

@Test
public void connectionTwo() {
	WebElement selectElement = driver.findElement(By.xpath("//select[@id='pay']"));
	WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Рассрочка')]"));
	
	Actions builder = new Actions(driver);
	builder
			.click(selectElement)
			.click(selectElement2)
			.build()
			.perform();
	
	List<WebElement> elementsInstalment = driver.findElements(By.xpath("//form[@id='pay-instalment']/descendant::input"));
	LinkedList<String> expectedText = new LinkedList<>();
	expectedText.add(0, "Номер лицевого счета");
	expectedText.add(1, "Сумма");
	expectedText.add(2, "E-mail для отправки чека");
	LinkedList<String> actualText = new LinkedList<>();
	for (WebElement element : elementsInstalment) {
		actualText.add(element.getAttribute("placeholder"));
	}
	Assertions.assertEquals(actualText, expectedText);
}

@Test
public void arrears() {
	WebElement selectElement = driver.findElement(By.xpath("//select[@id='pay']"));
	WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Задолженность')]"));
	
	Actions builder = new Actions(driver);
	builder
			.click(selectElement)
			.click(selectElement2)
			.build()
			.perform();
	
	List<WebElement> elementsArrears = driver.findElements(By.xpath("//form[@id='pay-arrears']/descendant::input"));
	LinkedList<String> expectedText = new LinkedList<>();
	expectedText.add(0, "Номер лицевого счета");
	expectedText.add(1, "Сумма");
	expectedText.add(2, "E-mail для отправки чека");
	LinkedList<String> actualText = new LinkedList<>();
	for (WebElement element : elementsArrears) {
		actualText.add(element.getAttribute("placeholder"));
	}
	Assertions.assertEquals(actualText, expectedText);
}

@Test
public void Connection3() {
	String sum = "1";
	String phone = "297777777";
	Duration timeout = Duration.ofSeconds(10);
	WebDriverWait wait = new WebDriverWait(driver, timeout);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-payment-container/descendant::*[contains(text(),'297777777')]")));
	WebElement selectElement = driver.findElement(By.xpath("//select[@id='pay']"));
	WebElement selectElement2 = driver.findElement(By.xpath("//div[@class='select']/descendant::p[contains(text(),'Услуги связи')]"));
	
	Actions builder = new Actions(driver);
	builder
			.click(selectElement)
			.click(selectElement2)
			.build()
			.perform();
	
	
	WebElement inputPhone = driver.findElement(By.xpath("//input[@id='connection-phone']"));
	inputPhone.sendKeys(phone);
	WebElement inputSum = driver.findElement(By.xpath("//input[@id='connection-sum']"));
	inputSum.sendKeys(sum);
	WebElement buttonSubmit = driver.findElement(By.xpath("//form[@id='pay-connection']/button"));
	buttonSubmit.click();
	
	List<WebElement> elementsSum = driver.findElements(By.xpath("//app-payment-container/descendant::*[contains(text(),'" + sum + "')]"));
	for (WebElement elementSum : elementsSum) {
		String digitText = elementSum.getAttribute("innerHTML").replaceAll("[^.\\d]", "");
		Assertions.assertEquals(Double.parseDouble(digitText), Double.parseDouble(sum));
	}
	
	WebElement elementPhone = driver.findElement(By.xpath("//app-payment-container/descendant::*[contains(text(),'" + phone + "')]"));
	String phoneText = elementPhone.getAttribute("innerHTML").replaceAll("[^.\\d]", "");
	Assertions.assertEquals(phoneText, "375" + phone);
	System.out.println("Значение номера телефона совпадает с заданным: " + phoneText);
	
	List<WebElement> elementsInput = driver.findElements(By.xpath("//app-payment-container/descendant::input/following-sibling::label"));
	LinkedList<String> expectedText = new LinkedList<>();
	expectedText.add(0, "Номер карты");
	expectedText.add(1, "Срок действия");
	expectedText.add(2, "CVC");
	expectedText.add(3, "Имя держателя (как на карте)");
	LinkedList<String> actualText = new LinkedList<>();
	for (WebElement element : elementsInput) {
		actualText.add(element.getAttribute("innerHTML"));
	}
	Assertions.assertEquals(actualText, expectedText);
	
	List<WebElement> images = driver.findElements(By.xpath("//app-payment-container/descendant::input[@id='cc-number']/parent::*/following::img"));
	for (int i = 0; i < images.size(); i++) {
		String url = images.get(i).getAttribute("src");
		Assertions.assertNotNull(url, "URL картинок пусты");
		double height = images.get(i).getSize().height;
		double width = images.get(i).getSize().width;
		Assertions.assertTrue(height > 0);
		System.out.println("Высота картинки " + url + " равна " + height);
		Assertions.assertTrue(width > 0);
		System.out.println("Ширина картинки " + url + " равна " + width);
	}
}

@AfterClass
public void tearDown() {
	if (driver != null) {
		driver.quit();
	}
}

}