package com.MyTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myPages.HomePage;
import com.myPages.LoginPage;

public class LoginTest extends BaseTest {
	
	HomePage homePage;
	
	//LoginPage login = new LoginPage(driver);
	
	@Test
	public void verifyLoginPageTitleTest() {
		//String title = login.getLoginPageTitle();
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		Assert.assertEquals(title, "Guru99 Bank Home Page");
	}
	
	@Test
	public void verifyLoginPageHeader() {
		//String loginHead = login.getLoginPageHeader();
		String loginHead = page.getInstance(LoginPage.class).getLoginPageHeader();
		Assert.assertEquals(loginHead, "Guru99 Bank");
	}
	
	@Test
	public void doLoginTest() {
		//homePage = login.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
		HomePage homePage = page.getInstance(LoginPage.class).doLogin(prop.getProperty("un"), prop.getProperty("pw"));
		String homeTitle = homePage.getHomePageTitle();
		Assert.assertEquals(homeTitle, "Guru99 Bank Manager HomePage");
	}
	
	
	

}
