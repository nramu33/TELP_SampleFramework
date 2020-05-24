package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.demopages.HomePage;
import com.qa.demopages.InputElementsPage;


public class InputElementsPageTests extends TestBase {
	HomePage homePage;
	InputElementsPage inputElementsPage ;
//	public InputElementsPageTests() {
//		super();
//	}
	@BeforeClass
	public void setUpClass() {
		homePage = new HomePage(driver);
		inputElementsPage = new InputElementsPage(driver);
	}
	@Test(priority = 1)
	public void navigateToinputElementsPageTest() {
		homePage.navigateToSipleFormDemoPg();
	}
	@Test(priority = 2)
	public void inputElementsPageTitleTest() {
		String title = inputElementsPage.getTitleOfInputElementsPage();
		Assert.assertEquals("Selenium Easy Demo - Simple Form to Automate using Selenium", title);
	}
}
