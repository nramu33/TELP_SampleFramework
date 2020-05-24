package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.TestBase;


public class DummyTestClass1 extends TestBase {
	@Test(priority = 2)
	public void dummyOne_PassTest() {
		Assert.assertEquals(true, true);
	}
	@Test(priority = 1)
	public void dummyOne_FailTest() {
		Assert.fail("Failed");
	}
}
