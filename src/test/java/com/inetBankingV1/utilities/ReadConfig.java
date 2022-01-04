package com.inetBankingV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		File src=new File("./Configuration//Config.properties");
		try {
			FileInputStream fis= new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
			
		}catch(Exception e){
			System.out.println("Exception is " + e.getMessage());
			
		}
		
	}
	public String getApplicationURL() 
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() 
	{
		String usrname=pro.getProperty("username");
		return usrname;
	}
	
	public String getPassword() 
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	/*
	 * public String getTitle() { String ttl=pro.getProperty("title"); return ttl; }
	 */
	
	public String getChromeDriverPath() {
		String chromepath=pro.getProperty("ChromeDriver");
		return chromepath;
	}
	
	public String getFirefoxDriverPath() {
		String chromepath=pro.getProperty("FirefoxDriver");
		return chromepath;
	}
}
