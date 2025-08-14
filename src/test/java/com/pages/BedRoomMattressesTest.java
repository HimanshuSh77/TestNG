package com.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.factory.DriverFactory;
import com.listeners.Retry;
import com.listeners.RetryListener;
import com.util.ConfigReader;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class BedRoomMattressesTest extends DriverFactory {
	private WebDriver driver;
	Properties prop;
	BedRoomMattresses bd;

	@BeforeMethod
	@Parameters({"browser","isRemote"})
	public void lauchBrowser(String browser, String isRemote) {
		prop = new ConfigReader().init_prop();
		driver = init_driver(browser, Boolean.valueOf(isRemote));
		driver.get(prop.getProperty("url"));

	}

	@Description(value = "This is category Validation")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void validateCategory() throws InterruptedException {
		bd = new BedRoomMattresses(driver);
		Assert.assertEquals(bd.getCategory(), "Bedroom & Mattresses");
	}

	@Description(value = "This is ChildOption Validation")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void validateChildOptionAvailable() throws InterruptedException {
		bd = new BedRoomMattresses(driver);
		Assert.assertEquals(bd.checkChildOptionIsPresent(), true);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
