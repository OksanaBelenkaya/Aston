package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MtsTest {

	public static void main (String [] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Оксана\\Desktop\\driver\\chrome-win64\\chrome_proxy.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.mts.by");
	}
}