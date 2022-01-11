package com.magneto.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magneto.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(linkText = "MOBILE")
	WebElement mobileBtn;

	@FindBy(xpath = "//h2[contains(text(),'This is demo site for')]")
	WebElement demoText;

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public void navigateToMobilePage() {
		mobileBtn.click();
	}

	public String getDemoText() {
		return demoText.getText();
	}

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

}
