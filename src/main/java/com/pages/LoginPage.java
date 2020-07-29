package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="txtUserName")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(name="Submit")
	WebElement login_btn;
	
	@FindBy(xpath="//img[@src='themes/orange/pictures/orange_new_02.gif']")
	WebElement crmlogo;
	
	public LoginPage() {
		//Created LoginPage constructor to to initialize elements with the 
		//help of pagefactory by using initElement method. 
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginpageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatecrmlogo() {
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		login_btn.click();
		return new HomePage();
	}
	
	
	
	
}
