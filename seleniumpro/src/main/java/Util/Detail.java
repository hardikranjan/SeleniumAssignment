package Util;
import java.util.*;
import java.io.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Detail {
	public static WebDriver driver = null; 
	public static FileInputStream fileInput;
	public static WebElement element;
	
	public static WebDriver getDriver(){
		driver = new ChromeDriver();
		return driver;
	}
	
	public static void openWebsite(String url){
		driver.navigate().to(url);
	}
	
	public static FileInputStream readFile(String fileName) throws FileNotFoundException{
		fileInput = new FileInputStream(new File(fileName));
		return fileInput;
	}
	
	public static WebElement findByXpath(String id){
		element =  driver.findElement(By.xpath(id));
		return element;
	}
	
	public static void enter(WebElement elem,String name){
		elem.sendKeys(name);
	}
	

}
	

