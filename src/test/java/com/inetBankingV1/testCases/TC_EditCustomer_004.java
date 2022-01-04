package com.inetBankingV1.testCases;

import org.openqa.selenium.NoAlertPresentException;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.EditCustomerPage;
import com.inetBankingV1.pageObjects.LoginPage;

public class TC_EditCustomer_004 extends BaseClass{
	
	//WebDriver driver;
	
	@Test
	public void editExistCustomer() {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		EditCustomerPage ecp = new EditCustomerPage(driver);
		
		ecp.clickEditCustomer();
		
		ecp.sendCustomerId("812");
		ecp.clickCustIdSubmit();
		logger.info("Customer ID has been provided");
		
		ecp.sendStateName("Goa");
		logger.info("state has been changed");
		ecp.clickEditSubmit();
		logger.info("clicked submit");
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Edit is successful");
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

}
