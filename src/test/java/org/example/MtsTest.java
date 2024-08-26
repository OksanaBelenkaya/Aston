package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MtsTest {
public static WebDriver driver;

public static void main(String[] args) {
//	driver = new ChromeDriver();
//	driver.get("https://www.mts.by/");
	System. setProperty ("webdriver.chrome.driver", "src/main/resources/chromedriver");
	WebDriver driver = new ChromeDriver () ;
	driver. get ("https://www.mts.by/");
	
}
}
