package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementsUtils;

public class LoginPage {
	// 1.Declare private driver
	private WebDriver driver;
	private ElementsUtils eleUtil;
	
	// 2. Create Constructor of Login Page
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementsUtils(driver);
	}
	
	// 3.By locators
	
	private By emailId = By.id("input-email");
	private By passwordEle = By.id("input-password");
	private By loginBtn = By.xpath("//button[@type='submit']");
	private By registerLink = By.linkText("Register");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	
	
	//4.Page Actions
	public String getLoginPageTitle() {
		
		return eleUtil.waitForTitleContains(Constants.LOGIN_PAGE_TITLE, Constants.DEFAUTL_TIME_OUT);
	}
	
	public String getLoginPageUrl() {
		return eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION ,Constants.DEFAUTL_TIME_OUT);
		
	}
	
	public boolean isForgotPwdLinkExist() {
		return eleUtil.doIsDisplayed(forgotPwdLink);
		
	}
	public boolean isRegisterLinkExist() {
		return eleUtil.doIsDisplayed(registerLink);
		
		
	}
	
	public void doLogin(String username ,String password) {
		System.out.println("login with :" + username + ":" + password);
		eleUtil.doSendKeys(emailId, password);
		eleUtil.doSendKeys(passwordEle, password);
		eleUtil.doClick(loginBtn);
		
	}
	
	
	
}
