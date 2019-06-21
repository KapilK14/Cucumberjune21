package demoActions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DemoSearch {
	WebDriver driver;
	@Test
	public void f() throws InterruptedException {
		driver.get("http://10.232.237.143:443/TestMeApp");
		WebElement searchBX=driver.findElement(By.xpath("//input[contains(@id,'myInput')]"));
		Thread.sleep(3000);

		Actions act = new Actions(driver);

		act.keyDown(searchBX, Keys.SHIFT).perform();
		act.sendKeys("b").pause(3000).sendKeys("a").pause(3000).sendKeys("g").perform();

		Thread.sleep(3000);
		act.moveToElement(driver.findElement(By.xpath("(//div[contains(.,'Hand bag')])[4]"))).click();
		driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
		String text= driver.findElement(By.xpath("//h4[contains(.,'Hand bag')]")).getText();

		Assert.assertTrue(text.contains("Hand"));
	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "resources\\geckodriver1.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
