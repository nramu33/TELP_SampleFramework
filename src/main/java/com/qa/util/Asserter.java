package com.qa.util;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;

public class Asserter{
	static SoftAssert sa;
	public static void assertValues(Object actual,Object expected, boolean AbortIfFails) {
		if(!AbortIfFails) {
			if(sa==null) {
				sa = new SoftAssert();
			}
			sa.assertEquals(actual, expected);
			Log.error("Actual:"+actual+" expected:"+expected);
		}
		else {
			try {
				Assert.assertEquals(actual, expected);
				Log.info("Actual:"+actual+" expected:"+expected);
			}
			catch (AssertionError e) {
				Log.error("Actual:"+actual+" expected:"+expected);
				Assert.fail(e.getMessage());
			}
		}
	}

	public static void assertAll() {
		if(sa!=null) {
			sa.assertAll();
		}
	}
}
