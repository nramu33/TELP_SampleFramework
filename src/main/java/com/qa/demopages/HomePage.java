package com.qa.demopages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{
	//Page factory
	@FindBy(linkText = "Demo Home")
	WebElement demoHomeLink;
	@FindBy(xpath = "//img[@alt='Selenium Easy']")
	WebElement seleniumEasyLogo;
	@FindBy(xpath = "//a[@class='dropdown-toggle'][contains(text(),'Input Forms')]")
	WebElement inputFormsDropdown;
	@FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'Simple Form Demo')]")
	WebElement simpleFormDemoLink;
	@FindBy(xpath = "//a[@class='dropdown-toggle'][contains(text(),'Date pickers')]")
	WebElement datepickersDropdown;
	@FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'Bootstrap Date Picker')]")
	WebElement bootstrapDatePickerLink;
	@FindBy(id = "at-cv-lightbox")
	WebElement seleniumEasyPopup;
	@FindBy(linkText = "No, thanks!")
	WebElement noThanksButton;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public String getTitleOfHomePage() {
		return driver.getTitle();
	}
	public boolean verifyseleniumEasyLogo() {
		return seleniumEasyLogo.isDisplayed();
	}
	public InputElementsPage navigateToSipleFormDemoPg() {
		inputFormsDropdown.click();
		dismissPopupIfDisplayed();
		simpleFormDemoLink.click();
		return new InputElementsPage(driver);
	}
	public DatePickersPage navigateToDatePickersPg() throws Exception {
		datepickersDropdown.click();
		dismissPopupIfDisplayed();
		bootstrapDatePickerLink.click();
		
		return new DatePickersPage(driver);
	}
	private void dismissPopupIfDisplayed() {
		if(seleniumEasyPopup.isDisplayed())
			noThanksButton.click();
		
	}
}
