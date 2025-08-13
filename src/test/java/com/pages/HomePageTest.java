package com.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.factory.DriverFactory;
import com.util.ConfigReader;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class HomePageTest extends DriverFactory {
	private WebDriver driver;
	Properties prop;
	HomePage hp;

	@Parameters({"browser","isRemote"})
	@BeforeTest
	public void lauchBrowser(String browser, String isRemote) {
		prop = new ConfigReader().init_prop();
		driver = init_driver(browser, Boolean.valueOf(isRemote));
		driver.get(prop.getProperty("url"));

	}

	@Description(value = "This is Home Page Banner Validation")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void validateHomeScreenBanner() {
		hp = new HomePage(driver);
		Assert.assertEquals(hp.isHomeBannerDisplayed(), true);

	}

	@Description(value = "This is Home Page Title Validation")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void getLoginPageTitle() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, prop.getProperty("pageTitle"));

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
