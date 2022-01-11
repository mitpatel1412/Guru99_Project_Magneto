package com.magneto.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magneto.qa.base.TestBase;
import com.magneto.qa.pages.HomePage;
import com.magneto.qa.pages.MobilePage;

public class MobilePageTest extends TestBase {

	MobilePage mobilePage;
	HomePage homePage;

	public MobilePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		homePage = new HomePage();
		homePage.navigateToMobilePage();
		mobilePage = new MobilePage();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test(priority = 1)
	public void verifyMobilePageTitle() {
		String actualTitle = "Mobile";
		String expectedTitle = mobilePage.getMobilePageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 2)
	public void verifySortBySelected() {

		List<WebElement> sortByList = mobilePage.sortByNameOption();
		for (WebElement a : sortByList) {
			if (a.getText().equals("Name")) {
				Assert.assertTrue(a.isSelected());
			}
		}
	}

	@Test(priority = 3)
	public void verifyListSorted() {
		List beforeSortList = mobilePage.beforeSortByList();
		List afterSortList = mobilePage.aftersortByList();
		Assert.assertEquals(beforeSortList, afterSortList);
	}

	@Test(priority = 4)
	public void verifySonyExperiaPrice() {
		String sonyExpPriceInGridPage = mobilePage.sonyExpPriceInGridPage();
		mobilePage.listView();
		String sonyExpPriceInListPage = mobilePage.sonyExpPriceInListPage();
		Assert.assertEquals(sonyExpPriceInGridPage, sonyExpPriceInGridPage);
	}

}
