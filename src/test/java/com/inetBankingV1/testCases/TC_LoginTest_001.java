package com.inetBankingV1.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		
		
		logger.info("URL has opened");
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Username entered");
		
		lp.setPassword(password);
		logger.info("Password entered");
		
		lp.clickSubmit();
		logger.info("Clicked on login");
		
		
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			System.out.println(driver.getTitle());
			logger.info("Login test passed");
		}
		else
		{
			captureScreenshot(driver,"loginTest");
			Assert.assertTrue(false,"Title didn't match");
			System.out.println(driver.getTitle());
			logger.info("Login test failed");
		}
		
	}
	
	
	
}
