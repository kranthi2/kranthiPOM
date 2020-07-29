package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[text()='PIM']")
	WebElement PIM;
	
	@FindBy(xpath="//span[text()='Add Employee']")
	WebElement AddEmploy;
	
	@FindBy(xpath="//select[@id='loc_code']")
	WebElement searchBydropdown;
	
	@FindBy(xpath="//input[@id='loc_name']")
	WebElement searchForinput;
	
	@FindBy(xpath="//input[@value='Search']")
	WebElement search_btn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String HomepageTitle() {
		return driver.getTitle();
	}

	public void searchByDropdown() {
		driver.switchTo().frame("rightMenu");
		Select dropdown = new Select(searchBydropdown);
		dropdown.selectByVisibleText("Emp. First Name");
	}

	public void searchfor(String searchname) {
		searchForinput.sendKeys(searchname);
		search_btn.click();
	}
	
	public void verifysearchforvalue() {
		 String searchVerify = driver.findElement(By.xpath("//a[@target='_self']")).getText();
		 System.out.println(searchVerify);
		 if(searchVerify.contains(prop.getProperty("searchforname1"))) {
			 System.out.println("Search verified");
		 }
			 else {
				 System.out.println("Verification failed");
			 }
		
	}
	

	public AddEmploy clickonAddEmploy() {
		Actions action = new Actions(driver);
		action.moveToElement(PIM).build().perform();
		AddEmploy.click();
		return new AddEmploy();
	}
}

