package basics.JUNe_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","resources\\chromedriver.exe");
		driver=new ChromeDriver();  // to open the browser
		
		driver.manage().window().maximize(); // to maximize the window
		driver.get("https://www.seleniumhq.org"); // to open url
		Thread.sleep(5000);
		driver.close(); // to close
	}

}