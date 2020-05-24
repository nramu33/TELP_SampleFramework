package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.demopages.DatePickersPage;
import com.qa.demopages.HomePage;

public class DatePickersPageTests extends TestBase {
	HomePage homePage ;
	DatePickersPage datePickersPage;
//	public DatePickersPageTests() {
//		super();
//	}
	@BeforeClass
	public void setUpClass() {
		homePage = new HomePage(driver);
		datePickersPage =  new DatePickersPage(driver);
		
	}
	@Test(priority = 1)
	public void datePickersPageTitleTest() throws Exception {
		Assert.assertTrue(homePage.navigateToDatePickersPg().verifyBootStrapDatePickersHeader());
	}
	@Test(priority = 2)
	public void seleniumEasyLogoTest() {
		Assert.assertTrue(homePage.verifyseleniumEasyLogo());
	}
}
