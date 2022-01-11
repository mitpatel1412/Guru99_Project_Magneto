package com.magneto.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.magneto.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"/Users/mit/Desktop/QA/QA/Selenium_Workspace/Guru99Magneto/src/main/java/com/magneto/qa/config/config.properties");
		prop.load(ip);
	}

	public void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/mit/Desktop/QA/QA/SeleniumJars/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/mit/Desktop/QA/QA/SeleniumJars/geckodriver");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.safari.driver", "/Users/mit/Desktop/QA/QA/SeleniumJars/safaridriver");
			driver = new SafariDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICITY_WAIT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
