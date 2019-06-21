package demoWebdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DemoNavigation {
	WebDriver driver;
	@Test
	public void f() throws InterruptedException {
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		driver.navigate().to("https://www.seleniumhq.org/");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		System.out.println("the page title is:" +driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Google");
		System.out.println("page url is:" +driver.getCurrentUrl());
		driver.navigate().forward();
		Thread.sleep(3000);
		System.out.println("the page title is:" +driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Selenium - Web Browser Automation");
		System.out.println("page url is:" +driver.getCurrentUrl());
		driver.navigate().refresh();
		System.out.println("page is refreshed");


	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","resources/chromedriver1.exe");
		driver=new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
	}

}
