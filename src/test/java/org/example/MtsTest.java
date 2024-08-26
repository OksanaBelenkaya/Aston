package org.example;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class MtsTest {
public static WebDriver driver;

@AfterClass
public static void tearDown() {
	if (driver != null) {
		driver.quit();
	}
}

@BeforeClass
public void setUp() {
	
	driver = new ChromeDriver();
	driver.get("https://www.mts.by/");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cookie__buttons']/button[@id='cookie-agree']")));
	button.click();
}

@Test(description = "Онлайн пополнение без комиссии")
public void blockTitleTest() {
	String expectedText = "Онлайн пополнение без комиссии";
	String actualText = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2")).getText().replaceAll("\\n", " ");
	assertEquals(expectedText, actualText, "Название блока неверное");
}

@Test(description = "Наличие логотипов платежных систем")
public void logosTest() {
	List<WebElement> images = driver.findElements(By.xpath("//div[@class='pay__partners']/descendant::img"));
	
	int expectedNumberOfLogos = 5;
	assertEquals(expectedNumberOfLogos, images.size(), "Количество логотипов платёжных систем должно быть " + expectedNumberOfLogos);
	
	for (WebElement image : images) {
		String url = image.getAttribute("src");
		assertTrue(url != null && !url.isEmpty(), "URL калоготипа не должен быть пустым");
		double height = image.getSize().height;
		double width = image.getSize().width;
		assertTrue(height > 0, "Высота картинки " + url + " должна быть больше 0");
		assertTrue(width > 0, "Ширина картинки " + url + " должна быть больше 0");
	}
}

@Test(description = "Проверка ссылки «Подробнее о сервисе»")
public void linkTest() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Подробнее о сервисе")));
	String expectedUrl = link.getAttribute("href");
	link.click();
	
	wait.until(ExpectedConditions.urlContains(expectedUrl));
	String actualUrl = driver.getCurrentUrl();
	assertTrue(actualUrl.contains(expectedUrl), "Ссылка переводит на другую страницу");
	
	driver.navigate().back();
}

@Test(description = "Тест кнопки «Продолжить» ")
public void submitTest() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	WebElement buttonSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='pay-connection']")));
	WebElement inputPhone = driver.findElement(By.xpath("//input[@id='connection-phone']"));
	inputPhone.sendKeys("88005553535");
	WebElement inputSum = driver.findElement(By.xpath("//input[@id='connection-sum']"));
	inputSum.sendKeys("200");
	buttonSubmit.click();
}
}