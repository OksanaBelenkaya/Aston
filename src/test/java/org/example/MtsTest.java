package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTest {

private WebDriver driver;
private MainPage homePage;
private PaymentPage paymentPage;

@BeforeEach
public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://mts.by");
	
	homePage = new MainPage(driver);
	paymentPage = new PaymentPage(driver);
}

@Test
public void testCheckTitle() {
	homePage.acceptCookies();
	
	String expectedTitle = "МТС – мобильный оператор в Беларуси";
	String actualTitle = driver.getTitle();
	assertEquals(expectedTitle, actualTitle, "Название страницы не совпадает.");
}

@Test
public void testCheckBlockTitle() {
	homePage.acceptCookies();
	
	homePage.openDropdown();
	homePage.selectServiceOption("Услуги связи");
	
	String actualPhonePlaceholder = paymentPage.getPhonePlaceholderText();
	String actualSumPlaceholder = paymentPage.getSumPlaceholderText();
	String actualEmailPlaceholder = paymentPage.getEmailPlaceholderText();
	
	assertEquals("Номер телефона", actualPhonePlaceholder, "Плейсхолдер поля телефона не совпадает.");
	assertEquals("Сумма", actualSumPlaceholder, "Плейсхолдер поля суммы не совпадает.");
	assertEquals("E-mail для отправки чека", actualEmailPlaceholder, "Плейсхолдер поля email не совпадает.");
}

@Test
public void testOnlinePaymentFlow() {
	homePage.acceptCookies();
	homePage.openDropdown();
	homePage.selectServiceOption("Услуги связи");
	
	String phoneNumber = "297777777";
	String amount = "77";
	
	paymentPage.fillPaymentForm(phoneNumber, amount, "mail@mail.ru");
	paymentPage.clickSubmitButton();
	
	assertTrue(paymentPage.isPaymentDetailsWindowDisplayed(), "Окно подтверждения оплаты не отображается.");
	
	paymentPage.switchToPaymentFrame();
	
	assertEquals(formatPhoneNumber(phoneNumber), paymentPage.getDisplayedPhone(), "Номер телефона отображается неверно.");
	assertEquals(formatAmount(amount), paymentPage.getDisplayedSum(), "Сумма отображается неверно.");
	assertTrue(paymentPage.getPaymentButtonText().contains(amount), "Текст на кнопке неверен.");
	assertTrue(paymentPage.isGooglePayButtonDisplayed(), "Кнопка Google Pay не отображается.");
	assertTrue(paymentPage.isYandexPayButtonDisplayed(), "Кнопка Yandex Pay не отображается.");
	
	paymentPage.switchToDefaultContent();
}

@AfterEach
public void tearDown() {
	if (driver != null) {
		driver.quit();
	}
}

private String formatPhoneNumber(String phoneNumber) {
	return "Оплата: Услуги связи Номер:375" + phoneNumber;
}

private String formatAmount(String amount) {
	if (!amount.contains(".")) {
		amount += ".00";
	}
	return amount + " BYN";
}
}