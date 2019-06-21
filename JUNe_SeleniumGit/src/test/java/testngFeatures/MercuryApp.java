package testngFeatures;

import org.testng.annotations.Test;

public class MercuryApp {
  @Test(priority=1)
  public void openBrowser() {
	  System.out.println("This is openBrowser");
  }
  @Test(priority=2)
  public void OpenURL() {
	  System.out.println("This is openURL");
  }
  @Test(priority=3)
  public void login() {
	  System.out.println("This is Login");
  }
  @Test(priority=4)
  public void searchFlight() {
	  System.out.println("This is searcgFlight");
  }
  @Test(priority=5)
  public void bookFlight() {
	  System.out.println("This is bokkFlight");
  }
  @Test(priority=6)
  public void logout(){
	  System.out.println("This is logout");
	   }
  @Test(priority=7)
  public void closeBrowser() {
	  System.out.println("This is closeBrowser");
  }
}
