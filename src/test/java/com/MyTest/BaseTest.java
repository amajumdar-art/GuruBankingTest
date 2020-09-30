package com.MyTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.myPages.BasePage;

import com.myPages.Page;

public class BaseTest {
	
	WebDriver driver;
	Properties prop;
	public Page page;
	
	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/aritramajumdar/eclipse-workspace/GuruBankingTest/src/main/java/com/Properties/config.properties");
			prop.load(ip);	
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	@Parameters(value = {"browser"})
	public void setUpTest(String browser) {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/aritramajumdar/eclipse/chromedriver");
			driver = new ChromeDriver();
		} 
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/aritramajumdar/eclipse/geckodriver");
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("No browser is defined in testng.xml file");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
		
		page = new BasePage(driver);
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
