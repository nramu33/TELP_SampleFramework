package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.demopages.HomePage;


public class HomePageTests extends TestBase {
	HomePage homePage ;
//	public HomePageTests() {
//		super();
//	}
	@BeforeClass
	public void setUpClass() {
		homePage = new HomePage(driver);
	}
	@Test(priority = 2)
	public void homePageTitleTest() {
		String title = homePage.getTitleOfHomePage();
		Assert.assertEquals("Selenium Easy - Best Demo website to practice Selenium Webdriver Online", title,"Home Page title is not matched");
	}
	@Test(priority = 1)
	public void seleniumEasyLogoTest() {
		Assert.assertTrue(homePage.verifyseleniumEasyLogo());
		
	}
}
