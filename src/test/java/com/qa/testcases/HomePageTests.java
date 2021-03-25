package com.qa.testcases;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.demopages.HomePage;
import com.qa.util.Log;


public class HomePageTests extends TestBase {
	HomePage homePage ;
//	public HomePageTests() {
//		super();
//	}
	@BeforeClass
	public void setUpClass() {
		homePage = new HomePage(driver);
	}
	@Test(testName="homePageTitleTest",priority = 2)
	public void homePageTitleTest() {
		Log.info("homePageTitleTest is started");
		String title = homePage.getTitleOfHomePage();
		Assert.assertEquals("Selenium Easy - Best Demo website to practice Selenium Webdriver Online", title,"Home Page title is not matched");
	}
	@Test(priority = 1)
	public void seleniumEasyLogoTest() {
		Assert.assertTrue(homePage.verifyseleniumEasyLogo());
		
	}
}
