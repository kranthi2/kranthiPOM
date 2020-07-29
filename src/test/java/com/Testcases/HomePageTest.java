package com.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.AddEmploy;
import com.pages.HomePage;
import com.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	AddEmploy addemploypage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		 loginpage = new LoginPage();
		 homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void HomePagetitleTest() {
		String title= homepage.HomepageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void searchuserTest() {
		homepage.searchByDropdown();
		homepage.searchfor(prop.getProperty("searchforname1"));
		homepage.verifysearchforvalue();
	}
	
	@Test(priority=3)
	public void clickonGeneralPageTest() throws InterruptedException {
		addemploypage= homepage.clickonAddEmploy();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
