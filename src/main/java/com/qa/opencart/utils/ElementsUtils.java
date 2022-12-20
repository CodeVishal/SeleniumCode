package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ElementsUtils {


	private WebDriver driver;
	
	public ElementsUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
		
	}
	
	public WebElement getElement(By locator,int timeOut) {
		return doPresenceofElementLocated(locator, timeOut);	
	}
	
	public  List<WebElement>getElements(By Locator) {
		return driver.findElements(Locator);
		
	}
	
	public  int getElementsCount(By locator) {
		 return getElements(locator).size();
	}
	
	public  boolean isElementexists(By locator) {
    	int elementCount = getElementsCount(locator);
    	System.out.println("total elements found:" + elementCount);
    	if(elementCount >=1) {
    		System.out.println("element is found.." +locator);
    		return true;
    	} else {
    		System.out.println("element is not found");
    		return false;
    	}
    
    }
	public  List<String>getElementsText(By locator){
		List<WebElement> elementsList = getElements(locator);
		List<String>elemenTextList = new ArrayList<String>();
		for(WebElement e :elementsList) {
			String eleText = e.getText();
			if(!eleText.isEmpty()) {
				elemenTextList.add(eleText);
			}
			
		}
		return elemenTextList;
	}
	
	public  List<String> getAttributeList(By locator, String attributeValue) {
		List<WebElement>eleList = getElements(locator);
		List<String>attrList = new ArrayList<String>();
		for(WebElement e: eleList) {
			String attrValue = e.getAttribute(attributeValue);
			attrList.add(attrValue);
		}
		return attrList;
	}
	public static void printElementValues(List<String>eleList) {
		for(String s: eleList) {
			System.out.println(s);
		}
	}
	
	
	
	
	public WebElement getElement(String locatorValue,String locatorType) {
		return driver.findElement(getBy(locatorType ,locatorValue));
	}
	
	public void doSendKeys(By locator ,String  value) {
		getElement(locator).sendKeys(value);
	}
	
	public void doSendKeys(String locatorValue ,String locatorType, String value ) {
		getElement(locatorValue,locatorType).sendKeys(value);
	}
	
	
	public  void  doSendKeys(By locator,String value,int timeOut) {
		doPresenceofElementLocated(locator, timeOut).sendKeys(value);
	}
	
	
	
	
	public  void doClick(By locator) {
		 getElement(locator).click();
	 }
	
	public  void doClick(String locatorValue,String locatorType ) {
		 getElement(locatorValue,locatorType).click();
	 }
	
	public  void doClick(By locator,int timeOut ) {
		doPresenceofElementLocated(locator, timeOut).click();
	 }
	
	
	
	
	public String doGetText(By locator) {
		 return getElement(locator).getText();
	}
	
	public  String getAttributeValue(By locator ,String attrName) {
		String attrValue= getElement(locator).getAttribute(attrName);
		System.out.println(attrValue);
		return attrValue;
		
	}
	
	/******Drop Down Utils*****************************/
	
	public  void doDropDownSelectByIndex(By locator ,int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public  void doDropDownSelectByText(By locator ,String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public  void doDropDownSelectByValue(By locator ,String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);;
	}
	
	public  void doSelectDropDownValue(By locator ,String value) {
		 Select select = new Select(getElement(locator));
		 List<WebElement>optionsList = select.getOptions();
		 for(WebElement e: optionsList) {
			 String text = e.getText();
			 System.out.println(text);
			 if(text.equals(value)) {
				 e.click();
				 break;
			 }
		 }
	}

	public  void selectDropDownValueithoutSelect(By locator,String value) {
		 List<WebElement> optionsList= getElements(locator);
		   System.out.println(optionsList.size());
		   for(WebElement e : optionsList) {
			   String text = e.getText();
			   if(text.equals(value)) {
				   e.click();
				   break;
			   }
		   }
		   
	 }
	
	/*******Wait Utils*****************************/
	public  WebElement doPresenceofElementLocated(By locator ,int timeOut) {
		 WebDriverWait wait = new WebDriverWait(driver,timeOut);
		 return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		 
		 
	}
	
	public  WebElement doPresenceofElementLocated(By locator ,int timeOut,int intervalTime) {
		 WebDriverWait wait = new WebDriverWait(driver,timeOut,intervalTime);
		 return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		 
		 
	}
	
	/***** FrameUtils *****/
	public  void waitForFrameByNameorID(String nameOrID , int timeOut) {
		WebDriverWait  wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID));
		
	}
	
	public  void waitForFramByIndex(int frameIndex , int timeOut) {
		WebDriverWait  wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
		
	}
	
	public  void waitForFramByLocator(By frameLocator , int timeOut) {
		WebDriverWait  wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		
	}
	
	public  void waitForFrameByElement(WebElement frameElement ,int timeOut) {
		WebDriverWait  wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	
	public  WebElement waitForElement(By locator ,int timeOut,int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait
        .pollingEvery(Duration.ofSeconds(pollingTime))
        .ignoring(NoSuchElementException.class)
        .ignoring(StaleElementReferenceException.class)
        .withMessage(Error.ELEMENT_NOT_FOUND_ERROR_MESSAGE);
 
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
			
		}
	
	public  WebElement waitForElementPresentUsingFluentWait(By locator,int timeOut,int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage(Error.ELEMENT_NOT_FOUND_ERROR_MESSAGE);
         
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
public  WebElement retryElement(By locator,int timeOut) {
		
		WebElement element = null;
		int attempts = 0;
		
		while(attempts < timeOut) {
			try {
			element = getElement(locator);
			break;
			} catch(NoSuchElementException e) {
				System.out.println("element is not found in attempt:"+attempts + ":" +locator);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		if(element == null) {
			try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
			} catch(Exception e) {
				System.out.println("element not found --tried for :" + timeOut + " with intervals of :"+ attempts);
			}
		}
		return element;
	}
	
public  WebElement retryElement(By locator,int timeOut ,long pollingTime) {
		
		WebElement element = null;
		int attempts = 0;
		
		while(attempts < timeOut) {
			try {
			element = getElement(locator);
			break;
			} catch(NoSuchElementException e) {
				System.out.println("element is not found in attempt:"+attempts + ":" +locator);
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		if(element == null) {
			try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
			} catch(Exception e) {
				System.out.println("element not found --tried for :" + timeOut + " with intervals of :"+ pollingTime +"ms");
			}
		}
		return element;
	}


	
	public  boolean doIsDisplayed(By locator) {
		 return getElement(locator).isDisplayed();
	}
	

	
	public By getBy(String locatorType ,String locatorValue ) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id" :
			 locator = By.id(locatorValue);
			break;
		case "name" :
			 locator = By.id(locatorValue);
			break;
		case "classname" :
			 locator = By.id(locatorValue);
			break;
		case "xpath" :
			 locator = By.id(locatorValue);
			break;	
		case "cssSelector" :
			 locator = By.id(locatorValue);
			break;
		case "linktext" :
			 locator = By.id(locatorValue);
			break;	
		default :
			System.out.println("Please pass right locator type and value");
			break;
		}
	return locator;	
	}
	
}
