package com.factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.stat.ranking.TiesStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(String browser, boolean isRemote) {

		System.out.println("Browser Name is " + browser + " on remote :" + isRemote);

		try {

			if (browser.equalsIgnoreCase("chrome")) {

				
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized");
				chromeOptions.addArguments("--disable-notifications");

				if (isRemote) {
					tldriver.set(new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), // Your Grid hub URL
							chromeOptions));
				} else {
					WebDriverManager.chromedriver().setup();
					tldriver.set(new ChromeDriver(chromeOptions));
				}
			} else if (browser.equalsIgnoreCase("firefox")) {
				
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addArguments("--start-maximized");
				firefoxOptions.addArguments("--disable-notifications");

				if (isRemote) {
					tldriver.set(new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), // Your Grid hub URL
							firefoxOptions));
				} else {
					WebDriverManager.firefoxdriver().setup();
					tldriver.set(new FirefoxDriver());
				}
			} else {
				System.out.println("Please Pass correct browser value: " + browser);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().getPageLoadTimeout();
		return getDriver();
	}

	public static WebDriver getDriver() {
		return tldriver.get();
	}
}