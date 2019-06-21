package testngFeatures;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssertion {
	@Test
	public void demo() {
		SoftAssert sa= new SoftAssert();
		System.out.println("demo checking 1st test");
		sa.assertEquals(10,12);

		System.out.println("demo checking 2nd test");
		sa.assertEquals("hello","hi");

		sa.assertAll();

	}
}
