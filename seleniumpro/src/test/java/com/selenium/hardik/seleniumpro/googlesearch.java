package com.selenium.hardik.seleniumpro;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;
import Util.*;

public class googlesearch{
	WebDriver webDriver ;
	WebElement element;
	Properties properties = new Properties();
	FileInputStream fileInput;
	String fileName = "config.properties";
	
	@Test
	public void namefinder() throws InterruptedException, IOException{
		Reporter.log("Reading File");
		fileInput = Detail.readFile(fileName);
		properties.load(fileInput);
		
		System.setProperty(properties.getProperty("driverName"),properties.getProperty("driverPath"));	
		Reporter.log("Open Browser");
		webDriver = Detail.getDriver();
		
		Reporter.log("Open Website");
		Detail.openWebsite(properties.getProperty("website"));
		//webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Reporter.log("Enter Name");
		element = Detail.findByXpath(properties.getProperty("searchXpath"));
		Reporter.log("Assetion if found then continue");
		Assert.assertTrue(element.isDisplayed(),"Element Not Present");
		Detail.enter(element, properties.getProperty("name"));
		
		
		Reporter.log("Search Name");
		element = Detail.findByXpath(properties.getProperty("searchButtonXpath"));
		
		element.click();
		
		
		
		Reporter.log("Browser close after 5 seconds");
		Thread.sleep(5000);
		webDriver.close();
	}	
}
