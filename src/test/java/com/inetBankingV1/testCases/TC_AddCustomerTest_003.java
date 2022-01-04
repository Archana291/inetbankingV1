package com.inetBankingV1.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.AddCustomerPage;
import com.inetBankingV1.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	//WebDriver driver;
	
	@Test
	public void addNewCustomer() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();

		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		logger.info("Providing customer details...");
		
		addcust.clickAddNewCustomer();
		
		addcust.custName("Archu");
		addcust.custgender("female");
		addcust.custdob("12", "29", "1997");
		addcust.custaddress("INDIA");
		addcust.custcity("DVG");
		addcust.custstate("DVG");
		addcust.custpinno("577005");
		addcust.custtelephoneno("9964472922");
		
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		logger.info("validation started...!");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed");
		}
		else
		{
			
			captureScreenshot(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
		
	}
	
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}

	public static String  randomName() {
		String generatedstring2= RandomStringUtils.randomAlphabetic(4);
		return (generatedstring2);
		
	}
}
