package com.selenium.hardik.seleniumpro;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class googlesearch1 {
	WebDriver webDriver ;
	WebElement element;
	
	@Test(description="This test Case will open chrome and search you name in google.com")
	public void namefinder() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver");	
		webDriver = new ChromeDriver();
		 webDriver.manage().window().maximize();
		webDriver.get("http://www.google.com");	
		element = webDriver.findElement(By.id("lst-ib"));
		element.sendKeys("Hardik Ranjan");
		webDriver.findElement(By.id("_fZl")).click();
		Thread.sleep(5000);
		webDriver.close();
	}	
}
