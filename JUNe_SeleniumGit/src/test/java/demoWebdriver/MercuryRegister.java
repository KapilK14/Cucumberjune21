package demoWebdriver;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class MercuryRegister {
	WebDriver driver;

	@Test
	public void Register() {
		String homeTitle= driver.getTitle();
		System.out.println("home page title is:" + homeTitle);
		Assert.assertEquals(homeTitle, "Welcome: Mercury Tours");

		driver.findElement(By.partialLinkText("GIS")).click();
		System.out.println("Register Page link:" +driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Register: Mercury Tours");

		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("abcde");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("abcde");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("7245168210");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("abjbsjfkvgvvhkd");
		driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("pune");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("PUNE");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("MH");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("454215");
//		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc@gmail.com");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abc@123");
//		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("abc@123");
//		driver.findElement(By.name("register")).click();

		Select countryname= new Select(driver.findElement(By.name("country")));
		countryname.selectByValue("92");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abc@123");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("abc@123");
		driver.findElement(By.name("register")).click();
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver1.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
	}


	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}

}
