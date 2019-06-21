package demoExcel;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class EndtoEnd {
	WebDriver driver;
	@Test
	public void f() throws InterruptedException {
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.findElement(By.xpath("//a[contains(.,'SignIn')]")).click();
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Lalitha");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String str= driver.findElement(By.xpath("//ul[contains(.,'Hi, Lalitha     \n" + 
				"								\n" + 
				"								\n" + 
				"									 SignOut')]")).getText();
		Assert.assertTrue(str.contains("Lalitha"));
		driver.findElement(By.xpath("//input[@id='myInput']")).sendKeys("Headphone");
//		WebElement SB= driver.findElement(By.xpath("//input[@id='myInput']"));
//		Thread.sleep(3000);
//
//		Actions act= new Actions(driver);
//		act.sendKeys("Head");
//		Thread.sleep(3000);
//		act.moveToElement(driver.findElement(By.xpath("(//div[contains(.,'Headphone')])[4]"))).click();


		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Add to cart')]")).click();
		driver.findElement(By.xpath("//a[contains(@style,'color:green')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Checkout')]")).click();
		
		
		
		driver.findElement(By.xpath("//input[contains(@value,'Proceed to Pay')]")).click();Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'Andhra Bank')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Continue')]")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Pass@456");
		driver.findElement(By.xpath("//input[contains(@value,'LOGIN')]")).click();
		driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("Trans@456");
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		String string= driver.findElement(By.xpath("//p[contains(.,'Your order has been confirmed')]")).getText();
		Assert.assertTrue(string.contains("confirmed"));
		
	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","resources/chromedriver1.exe");
		driver=new ChromeDriver();
		//driver.manage().window().maximize();


	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
