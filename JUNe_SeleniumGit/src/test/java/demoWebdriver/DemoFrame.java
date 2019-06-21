package demoWebdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DemoFrame {
	WebDriver driver;
	@Test
	public void f() throws InterruptedException {
		driver.get("https://seleniumhq.github.io/selenium/docs/api/java/index.html");
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(.,'org.openqa.selenium.chrome')]")).click();
		System.out.println("page title :" +driver.getTitle());

		driver.switchTo().defaultContent();  Thread.sleep(3000);
		driver.switchTo().frame("packageFrame"); Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='ChromeDriver.html']")).click();
		System.out.println("page title :" +driver.getTitle());

		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame("classFrame");   Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(.,'HasCapabilities')]")).click();
		System.out.println("page title :" +driver.getTitle());
	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
