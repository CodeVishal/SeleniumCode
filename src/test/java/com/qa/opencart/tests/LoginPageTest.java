package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class LoginPageTest  extends BaseTest{
	
	@Test(priority = 1)
	public void loginPageTitle() {
	   Assert.assertEquals(Constants.LOGIN_PAGE_TITLE, loginPage.getLoginPageTitle());
	   
	}
	
	@Test(priority =2)
	public void loginPageUrlTest() {
		

		Assert.assertEquals(Constants.LOGIN_PAGE_URL_FRACTION, loginPage.getLoginPageUrl());
		
	}
	
	@Test(priority = 3)
	public void forgotPasswordLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
		
	}
	
	@Test(priority = 4)
	public void registerLinkTest() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());
		
	}

	@Test(priority = 5)
	public void LoginTest() {
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
}
