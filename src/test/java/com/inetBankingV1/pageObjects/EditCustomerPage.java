package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

	WebDriver ldriver;

	public EditCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[3]/a")
	@CacheLookup
	WebElement lnkEditCustomer;

	@FindBy(name = "cusid")
	@CacheLookup
	WebElement txtCustomerId;

	@FindBy(name = "AccSubmit")
	@CacheLookup
	WebElement clkSubmit;

	@FindBy(name = "state")
	@CacheLookup
	WebElement txtState;

	@FindBy(name = "sub")
	@CacheLookup
	WebElement clickEditSubmit;

	public void clickEditCustomer() {
		lnkEditCustomer.click();
	}
	
	public void sendCustomerId(String id)
	{
		txtCustomerId.sendKeys(id);
	}
	
	public void clickCustIdSubmit()
	{
		clkSubmit.click();
	}
	public void sendStateName(String statename)
	{
		txtState.clear();
		txtState.sendKeys(statename);
	}
	
	public void clickEditSubmit()
	{
		clickEditSubmit.click();
		
	}

}
