package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.ElementUtil;

import io.qameta.allure.Step;

public class BedRoomMattresses {
	
	WebDriver driver;
	ElementUtil util;
	Actions act;
	
	@FindBy(xpath="//h1[text()='Bedroom & Mattresses']")
	WebElement categoty;
	
	@FindBy(xpath="//nav[@aria-label='menuItem']//a[text()=' Bedroom & Mattresses ']")
	WebElement bedroom_matresses;
	
	@FindBy(xpath="//div[contains(@class,'desktop-submenu')]//a[text()='King Beds']")
	WebElement kids_beds;
	
	public BedRoomMattresses(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		util= new ElementUtil(driver);
		act = new Actions(driver);
		}
	
	@Step(value = "Home Child Category Validation")
	public String getCategory() throws InterruptedException {
		bedroom_matresses.click();
		Thread.sleep(5000);
		return categoty.getText();
		
	}

	@Step(value = "Home Child Option Validation")
    public boolean checkChildOptionIsPresent() throws InterruptedException {
    	Thread.sleep(5000);
    	act.moveToElement(bedroom_matresses).perform();
    	Thread.sleep(5000);
    	return kids_beds.isDisplayed();
    	
    }
	
}
