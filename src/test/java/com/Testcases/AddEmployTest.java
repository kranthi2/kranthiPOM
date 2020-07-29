package com.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.AddEmploy;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.TestUtils;

public class AddEmployTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	AddEmploy addemp;
	
	public AddEmployTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		 loginpage = new LoginPage();
		 homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 homepage.clickonAddEmploy();
	}
	
	@DataProvider
	public Object[][] getempdata() {
		Object data[][]= TestUtils.getTestData("Sheet1");
		return data;
	}
	
	@Test(dataProvider="getempdata")
	public void VerifyAddEmploy(String firstname,String lastname,String middlename,String nickname,String photo) {
	 addemp = new AddEmploy();
//	 addemp.addEmploy("Sachin", "Tendulkar", "ramesh", "master", "C:\\Users\\mamid\\Desktop\\Gluster.png");
	 addemp.addEmploy(firstname, lastname, middlename, nickname, photo);
	
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
