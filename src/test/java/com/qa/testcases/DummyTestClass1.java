package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.Asserter;


public class DummyTestClass1 extends TestBase {
	@Test(priority = 2)
	public void dummyOne_PassTest() {
//		Assert.assertEquals(true, true);
		Asserter.assertValues("Soft", "Assert", false);
		Asserter.assertValues(true, true, false);
	}
	@AfterMethod
	void assertAll() {
		Asserter.assertAll();
	}
	@Test(priority = 1)
	public void dummyOne_FailTest() {
		//Assert.fail("Failed");
		Asserter.assertValues("actual", "expected", true);
	}
}
