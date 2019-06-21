package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginTest {
	WebDriver driver;

	@Given("user is on home page")
	public void user_is_on_home_page() {
		System.setProperty("webdriver.chrome.driver","Resources\\chromedriver1.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		System.out.println("user on home page");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		LoginOR repositary= new LoginOR(driver);
		System.out.println("user enters username & password");
		repositary.usern.sendKeys("tomsmith");
		repositary.passw.sendKeys("SuperSecretPassword!");
		repositary.Login.click();
	}

	@Then("user logged in successfully")
	public void user_logged_in_successfully() {
		System.out.println("user logged in successfully");
	}

}
