package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class AddEmploy extends TestBase{
	
	@FindBy(xpath="//input[@id='txtEmpLastName']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='txtEmpFirstName']")
	WebElement fistname;
	
	@FindBy(xpath="//input[@id='txtEmpMiddleName']")
	WebElement middlename;
	
	@FindBy(xpath="//input[@id='txtEmpNickName']")
	WebElement nickname;
	
	@FindBy(xpath="//input[@id='photofile']")
	WebElement photo;
	
	@FindBy(xpath="//input[@id='btnEdit']")
	WebElement save;
	
	public AddEmploy() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void addEmploy(String ftname,String ltname,String mdlname,String nkname,String picpath ) {
		driver.switchTo().frame("rightMenu");
		fistname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		middlename.sendKeys(mdlname);
		nickname.sendKeys(nkname);
		photo.sendKeys(picpath);
		save.click();
	}
	
	
	
}
