package com.magneto.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magneto.qa.base.TestBase;
import com.magneto.qa.pages.HomePage;
import com.magneto.qa.pages.MobilePage;

public class HomePageTest extends TestBase {

	HomePage homePage;
	MobilePage mobilePage;

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		homePage = new HomePage();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test(priority = 1)
	public void verifyHomePageTitle() {
		String actualTitle = "Home page";
		Assert.assertEquals(homePage.getHomePageTitle(), actualTitle);
	}

	@Test(priority = 2)
	public void verifyDemoText() {
		String actualText = "THIS IS DEMO";
		String expectedText = homePage.getDemoText();
		Assert.assertTrue(expectedText.contains(actualText));
	}

	@Test(priority = 3)
	public void clickOnMobileBtn() {
		homePage.navigateToMobilePage();

	}

	public HomePageTest() throws IOException {
		super();
	}

}
