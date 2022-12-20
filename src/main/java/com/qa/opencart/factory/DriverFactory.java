package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	
	/*
	 * This method is used to initialize the webdriver
	 * @param browserName
	 * @return this will return driver
	 */
	public WebDriver setup(Properties prop) {
		
		String browserName = prop.getProperty("browser").trim();
		System.out.println("browser name is :" +browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if(browserName.equalsIgnoreCase("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("please pass right browser:" + browserName);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		return driver;
		
		
	}
	
	/*
	 * this method  used to initialized the  properties
	 * @return this will return properties prop properties
	 * 
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
		FileInputStream ip = new FileInputStream("./src/test/resource/config/config.properties");
		prop.load(ip);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}