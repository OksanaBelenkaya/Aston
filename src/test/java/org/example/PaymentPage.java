package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {
private final WebDriver driver;
private final WebDriverWait wait;

private final By phoneInput = By.id("connection-phone");
private final By sumInput = By.id("connection-sum");
private final By emailInput = By.id("connection-email");
private final By submitButton = By.cssSelector("#pay-connection .button__default");

private final By phonePlaceholder = By.id("connection-phone");
private final By sumPlaceholder = By.id("connection-sum");
private final By emailPlaceholder = By.id("connection-email");

private final By paymentIFrame = By.xpath("//iframe[@class='bepaid-iframe']");

private final By displayedPhone = By.cssSelector(".pay-description__text span");
private final By displayedSum = By.cssSelector(".pay-description__cost span");
private final By paymentButton = By.cssSelector(".colored");

private final By googlePayButton = By.id("gpay-button-online-api-id");
private final By yandexPayButton = By.id("yandex-button");

public PaymentPage(WebDriver driver) {
	this.driver = driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}

public void fillPaymentForm(String phone, String sum, String email) {
	wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput)).sendKeys(phone);
	wait.until(ExpectedConditions.visibilityOfElementLocated(sumInput)).sendKeys(sum);
	wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
}

public void clickSubmitButton() {
	wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
}

public String getPhonePlaceholderText() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(phonePlaceholder)).getAttribute("placeholder");
}

public String getSumPlaceholderText() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(sumPlaceholder)).getAttribute("placeholder");
}

public String getEmailPlaceholderText() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(emailPlaceholder)).getAttribute("placeholder");
}

public boolean isPaymentDetailsWindowDisplayed() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentIFrame)).isDisplayed();
}

public void switchToPaymentFrame() {
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentIFrame));
}

public void switchToDefaultContent() {
	driver.switchTo().defaultContent();
}

public String getDisplayedPhone() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(displayedPhone)).getText();
}

public String getDisplayedSum() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(displayedSum)).getText();
}

public String getPaymentButtonText() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentButton)).getText();
}

public boolean isGooglePayButtonDisplayed() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(googlePayButton)).isDisplayed();
}

public boolean isYandexPayButtonDisplayed() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(yandexPayButton)).isDisplayed();
}
}