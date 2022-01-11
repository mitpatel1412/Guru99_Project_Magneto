package com.magneto.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.magneto.qa.base.TestBase;

public class MobilePage extends TestBase {

	@FindBy(xpath = "//select[@title='Sort By']")
	WebElement sortBy;

	@FindBy(xpath = "//a[@title='List']")
	WebElement listBtn;

	@FindBy(xpath = "(//div[@class='price-box'])[2]")
	WebElement sonyExperiaGridPage;

	@FindBy(xpath = "(//span[@class='price'])[1]")
	WebElement sonyExperiaListPage;

	public MobilePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String getMobilePageTitle() {
		return driver.getTitle();
	}

	public List sortByNameOption() {
		Select s = new Select(sortBy);
		s.selectByVisibleText("Name");
		List<WebElement> sortByOption = driver.findElements(By.xpath("//select[@title='Sort By']"));
		return sortByOption;
	}

	public List beforeSortByList() {
		List<WebElement> BeforeSortBy = driver.findElements(By.xpath("//div[@class='category-products']/ul[1]/li/a"));
		List<String> BeforeSortByList = new ArrayList<>();
		for (WebElement a : BeforeSortBy) {
			BeforeSortByList.add(a.getAttribute("title"));
		}
		Collections.sort(BeforeSortByList);
		return BeforeSortByList;
	}

	public List aftersortByList() {
		sortByNameOption();
		List<WebElement> AfterSortBy = driver.findElements(By.xpath("//div[@class='category-products']/ul[1]/li/a"));
		List<String> AfterSortByList = new ArrayList<>();
		for (WebElement a : AfterSortBy) {
			AfterSortByList.add(a.getAttribute("title"));
		}
		return AfterSortByList;
	}

	public void listView() {
		listBtn.click();
	}

	public String sonyExpPriceInGridPage() {
		String sonyExperiaPriceGridPage = sonyExperiaGridPage.getText();
		return sonyExperiaPriceGridPage;
	}

	public String sonyExpPriceInListPage() {
		String sonyExperiaPriceListPage = sonyExperiaListPage.getText();
		return sonyExperiaPriceListPage;
	}

}
