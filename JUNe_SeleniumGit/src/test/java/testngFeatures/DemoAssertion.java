package testngFeatures;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoAssertion {
	@Test
	public void test1() {
		System.out.println("test1 started");
		Assert.assertTrue(20>18, "error msg-is less than 20");
		System.out.println("test1 completed");
	}
	@Test
	public void test2() {
		System.out.println("test2 started");
		Assert.assertTrue(20<18, "error msg-is less than 20");
		System.out.println("test2 completed");
	}
	@Test
	public void test3() {
		System.out.println("test 3 started");
		Assert.assertFalse("hello".equals("hi"), "error msg- both are different");
		System.out.println("test 3 completed");
	}
}
