package com.qa.demopages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class DatePickersPage extends TestBase{
	//Page factory
	@FindBy(linkText = "Demo Home")
	WebElement demoHomeLink;
	@FindBy(xpath = "//img[@alt='Selenium Easy']")
	WebElement seleniumEasyLogo;
	@FindBy(xpath = "//h1[.='Bootstrap Date Pickers Example']")
	WebElement bootStrapDatePickersHeader;
	public DatePickersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyBootStrapDatePickersHeader() {
		return bootStrapDatePickersHeader.isDisplayed();
	}
}