package com.qa.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DropDownWithSelect {
	static WebDriver driver;
	public static void main(String [] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    
	   // driver.get("https://www.orangehrm.com/contact-sales");
	   driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
	   By dropDown = By.id("select-demo");
	   // By dropDown = By.id("Form_getForm_Country");
	    //By dropDownOptions = By.xpath("//select[@id='Form_getForm_Country']/option");
	  
	    Select select = new Select(getWebElement(dropDown));
	    
	    // Select by Index
	    select.selectByIndex(3);
	    select.selectByValue("India");
	    //select.selectByVisibleText("Bahrain");
	    //doSelectDropDownValue(dropDown, "United States");
	   // doSelectWithoutSelect(dropDownOptions,"India");
	   
	    
	}
	
	public static WebElement getWebElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static  void doSelectDropDownValue(By locator , String value) {
		Select select = new Select(getWebElement(locator));
		List<WebElement>options = select.getOptions();
		for(WebElement e: options) {
			if(e.getText().equals(value)) {
				e.click();
				break;
			}
		}
		 
	
		
	}
	
	public static void doSelectWithoutSelect(By locator ,String value) {
		List<WebElement>listOptions = driver.findElements(locator);
		System.out.println(listOptions.size());
		for(WebElement e : listOptions) {
			System.out.println(e.getText());
			e.getText();
			if(e.getText().equals(value)) {
				e.click();
			}
		}
		
	}
	
	
}
