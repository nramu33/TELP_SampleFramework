package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

//@Listeners({ExtentITestListenerClassAdapter.class})
public class DummyTestClass2 extends TestBase {
	@Test(priority = 2)
	public void dummyTwo_PassTest() {
		Assert.assertEquals(true, true);
	}
	@Test(priority = 1)
	public void dummyTwo_FailTest() {
		Assert.fail("Failed");
	}
}
