package com.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() {
		//Create a constructor of loginpageTest to call super class constructor for not facing the null pointer
		//Exception, bcoz we initialize the properties filr in the parent class constructor
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void LoginPagetitleTest() {
		String title = loginpage.validateLoginpageTitle();
		Assert.assertEquals(title, "OrangeHRM - New Level of HR Management");
	}
	
	@Test(priority=2)
	public void LogoTest() {
		boolean flag = loginpage.validatecrmlogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void LoginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
