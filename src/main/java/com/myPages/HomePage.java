package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	
	private By homeHeader = By.xpath("//marquee[contains(text(),'Welcome To Manager's Page of Guru99 Bank')]");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public WebElement getHomeHeader() {
		return getElement(homeHeader);
	}
	
	public String getHomePageTitle() {
		return getPageTitle();
	}
	
	public String getHomePageHeader() {
		return getPageHeader(homeHeader);
	}

}
