package testngFeatures;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DemoDataProvider {
	@Test(dataProvider = "credentials")
	public void f(String user, String pass) {
		System.out.println("user is : " +user);
		System.out.println("pass is : " +pass);
	}

	@DataProvider(name="credentials")
	public Object[][] dp() {
		return new Object[][] {
			new Object[] { "abc", "abc1" },
			new Object[] { "cde", "cde1b" },
			new Object[] { "uvw", "abc2" },
		};
	}
}
