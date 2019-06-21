package testngFeatures;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoAssertEquals {
	@Test
	public void test1() {
		int exp =50;
		int actual =50;
	
		Assert.assertEquals(actual, exp, "error-not equal");
		
	}
	@Test
	public void test2() {
		Assert.assertEquals("hello","hi","error-msg");
	}
	@Test
	public void test3() {
		Object test=null;
		Assert.assertNull(test,"not null");
	}
	@Test
	public void test4() {
		Assert.fail("failing the test");
	}
}
