package demoWebdriver;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DemoUrlandSource {
	WebDriver driver;
	@Test
	public void f() {
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		System.out.println("title is: "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Wikipedia, the free encyclopedia");

		driver.findElement(By.linkText("History")).click();
		System.out.println("title is: "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Portal:History - Wikipedia");

		String url=driver.getCurrentUrl();
		System.out.println("current page is:" +url);

		System.out.println("page source is :" +driver.getPageSource());

	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver1.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
	}

}
