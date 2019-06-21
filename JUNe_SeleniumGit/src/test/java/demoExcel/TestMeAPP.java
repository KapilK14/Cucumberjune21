package demoExcel;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TestMeAPP {
	WebDriver driver;
	WebDriverWait wait;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
  @Test(dataProvider = "credentials")
  public void TestMeApp(String username, String password, String bankname, String bankusername, String bankpassword, String transactionpw) throws InterruptedException {
	  
	  logger = extent.createTest("passTest");
	  
	  driver.get("http://10.232.237.143:443/TestMeApp");
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("Login")).click();
		WebElement SB=driver.findElement(By.xpath("//input[@id='myInput']"));
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		act.keyDown(SB, Keys.SHIFT).perform();
		act.sendKeys("h").pause(3000).sendKeys("e").pause(3000).sendKeys("a").perform();
		
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"myInputautocomplete-list\"]")));
		driver.findElement(By.xpath("//*[@id=\"myInputautocomplete-list\"]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
		driver.findElement(By.xpath("//a[contains(.,'Add to cart')]")).click();
		driver.findElement(By.xpath("//a[contains(@style,'color:green')]")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-block']")).click();
		driver.findElement(By.xpath("//input[contains(@value,'Proceed to Pay')]")).click();
		Thread.sleep(3000);
		
		switch(bankname) {
		case("Andhra Bank"):
			driver.findElement(By.xpath("//label[contains(text(),'Andhra Bank')]")).click();
			driver.findElement(By.xpath("//a[contains(.,'Continue')]")).click();
			makepayment(bankusername, bankpassword, transactionpw);
			
		case("HDFC Bank"):
			driver.findElement(By.xpath("//label[contains(text(),'HDFC Bank')]")).click();
			driver.findElement(By.xpath("//a[contains(.,'Continue')]")).click();
			makepayment(bankusername, bankpassword, transactionpw);
			
		case("IDBI Bank"):
			driver.findElement(By.xpath("//label[contains(text(),'IDBI Bank')]")).click();
			driver.findElement(By.xpath("//a[contains(.,'Continue')]")).click();
			makepayment(bankusername, bankpassword, transactionpw);
			
		case("UCO Bank"):
			driver.findElement(By.xpath("//label[contains(text(),'UCO Bank')]")).click();
			driver.findElement(By.xpath("//a[contains(.,'Continue')]")).click();
			makepayment(bankusername, bankpassword, transactionpw);
									
			}
	
		}
	
	@Test(priority=2)
	public void makepayment(String bank_user, String bank_pass, String trans_pw) {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(bank_user);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(bank_pass);
		driver.findElement(By.xpath("//input[contains(@value,'LOGIN')]")).click();
		driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys(trans_pw);
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignOut")));
		driver.findElement(By.linkText("SignOut")).click();
		
		logger.log(Status.PASS, MarkupHelper.createLabel("test case passed is Pass test", ExtentColor.GREEN));
  
  }

  @DataProvider(name="credentials")
  public Object[][] getData() throws IOException{
    return CaseStudyone.ReadData();
//      new Object[] { 1, "a" },
//      new Object[] { 2, "b" },
//    };
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "resources/chromedriver1.exe");
		driver = new ChromeDriver();
		wait= new WebDriverWait(driver,30);
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") 
				+ "/extent-reports/" + new SimpleDateFormat("hh-mm-ss-ms-dd-MM-yyyy")
				.format(new Date()) + ".html");
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "GFT NexGen Testing Stream");
		extent.setSystemInfo("Environment", "Automation Testing Selenium");
		extent.setSystemInfo("User Name", "xyz");

		htmlReporter.config().setDocumentTitle("Extent report of TestMeAppLogin");
		htmlReporter.config().setReportName("Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
	  driver.close();
  }

}
