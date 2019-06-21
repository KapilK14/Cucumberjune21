package demoWebdriver;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class casestudy3 {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("http://10.232.237.143:443/TestMeApp");
	  driver.findElement(By.xpath("//a[contains(.,'SignUp')]")).click();
	  driver.findElement(By.xpath("//input[contains(@name,'userName')]")).sendKeys("kapilk");
	  Actions act = new Actions(driver);
	  act.moveToElement(driver.findElement(By.xpath("//input[contains(@name,'firstName')]"))).click().perform();
	  String str= driver.findElement(By.xpath("//*[@id=\"err\"]")).getText();
	  Assert.assertTrue(str.contains("Available"));
	  driver.findElement(By.xpath("//input[contains(@name,'firstName')]")).sendKeys("kapil");
	  driver.findElement(By.xpath("//input[contains(@name,'lastName')]")).sendKeys("kukade");
	  driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("kukade123");
	  driver.findElement(By.xpath("//input[@type='password'][contains(@id,'confirmation')]")).sendKeys("kukade123");
	  driver.findElement(By.xpath("//input[contains(@value,'Male')]")).click();
	  driver.findElement(By.xpath("//input[contains(@name,'emailAddress')]")).sendKeys("kukade123@gmail.com");
	  driver.findElement(By.xpath("//input[contains(@name,'mobileNumber')]")).sendKeys("7845912145");
	  driver.findElement(By.xpath("//input[contains(@placeholder,'Date of Birth- mm/dd/yyyy')]")).sendKeys("04/14/1997");
	  driver.findElement(By.xpath("//textarea[@name='address'][contains(.,'Address')]")).sendKeys("chadrapur");
	  driver.findElement(By.xpath("//input[contains(@name,'answer')]")).sendKeys("chandrapur");
	  
	  boolean user= driver.findElement(By.xpath("//input[contains(@name,'userName')]")).isDisplayed();
	  if(user==true){
		  Assert.assertTrue(user);
		  System.out.println("username is available");
	  }
	  else {
		  Assert.assertFalse(user);
		  System.out.println("username is already exist");
		  driver.findElement(By.xpath("//*[@id=\"err\"]")).click();
		  
	  }
  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "resources/chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
