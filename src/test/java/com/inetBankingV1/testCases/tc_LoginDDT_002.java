package com.inetBankingV1.testCases;

import java.io.IOException;


import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.LoginPage;
import com.inetBankingV1.utilities.XLUtils;

public class tc_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String username,String password) {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username Provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Invalid  username or password");
			
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();	
			driver.switchTo().defaultContent();
			logger.info("Valid username and password");
			
		}
		
		
	}
	
	public boolean isAlertPresent() {
		try 
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) 
		{
			return false;
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBankingV1/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", rownum);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
		
	}

}
