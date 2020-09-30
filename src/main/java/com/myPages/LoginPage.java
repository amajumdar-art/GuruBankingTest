package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	//page locators:
	private By username = By.name("uid");
	private By password = By.name("password");
	private By loginBtn = By.name("btnLogin");
	private By loginHeader = By.xpath("//h2[contains(text(),'Guru99 Bank')]");
	

	public LoginPage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);
		
	}

	//Getters:
	public WebElement getUsername() {
		return getElement(username);
	}


	public WebElement getPassword() {
		return getElement(password);
	}

	
	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}


	public WebElement getLoginHeader() {
		return getElement(loginHeader);
	}
	
	//Methods:
	public String getLoginPageTitle() {
		return getPageTitle();
	}
	
	public String getLoginPageHeader() {
		return getPageHeader(loginHeader);
	}
	
	public HomePage doLogin(String uname, String pwd) {
		getUsername().sendKeys(uname);
		getPassword().sendKeys(pwd);
		getLoginBtn().click();
		
		return getInstance(HomePage.class);
	}
	
	public void doLogin() {
		getUsername().sendKeys("");
		getPassword().sendKeys("");
		getLoginBtn().click();
	}
	
	public void doLogin(String uname) {
		getUsername().sendKeys(uname);
		getPassword().sendKeys("");
		getLoginBtn().click();
	}
}
