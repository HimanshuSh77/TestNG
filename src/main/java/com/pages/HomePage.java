package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath="//ff-banner[@class='MAIN_PROMO_RES_BANNER ng-star-inserted']//img")
	WebElement homeBanner;
	
	public HomePage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@Step(value = "Home Banner Validation")
	public boolean isHomeBannerDisplayed() {
		
		return homeBanner.isDisplayed();
	}



}
