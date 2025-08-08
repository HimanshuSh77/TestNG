package com.factory;

import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.stat.ranking.TiesStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(String browser) {

		System.out.println(browser);

		if (browser.equals("chrome")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Please Pass correct browser value: "+ browser);
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