import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class Main {
public static void main (String [] args){
	System.setProperty("webdriver.chrome.driver", "../chromedriver-win64/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("https://mts.by/");
}
}
