package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.utils.TestUtils;
import com.utils.WebEventListener;

public class TestBase {
//*************************Kranthi***********************//
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		//Created TestBase Constructor to load the properties file.
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("F:\\Automation\\NaveenPOM_Streams\\src\\main\\java\\com\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void initialization() {
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browsername.equals("Firefox")) {
			System.out.println("firefox Browser");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver =e_driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.implicit_wit_timeout, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
