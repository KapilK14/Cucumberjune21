package basics.JUNe_Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class MercuryTours {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("http://newtours.demoaut.com/");
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();
  }

}
