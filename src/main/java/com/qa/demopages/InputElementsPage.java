package com.qa.demopages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class InputElementsPage extends TestBase{
	//Page factory
	@FindBy(linkText = "Demo Home")
	WebElement demoHomeLink;
	@FindBy(xpath = "//img[@alt='Selenium Easy']")
	WebElement seleniumEasyLogo;
	@FindBy(xpath = "//a[@class='dropdown-toggle'][contains(text(),'Input Forms')]")
	WebElement inputFormsLink;
	@FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'Simple Form Demo')]")
	WebElement simpleFormDemoLink;
	public InputElementsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public String getTitleOfInputElementsPage() {
		return driver.getTitle();
	}
}