package com.cognizant.Pharmacy;

import org.openqa.selenium.By;

public class pageObject {
	
	public static final By uname = By.name("username");
	public static final By iuname = By.xpath("//span[contains(.,'UserName is Invalid')]");
	public static final By ipwd = By.xpath("//span[contains(.,'UserName and Password does not match')]");
	public static final By pwd = By.name("password");
	public static final By login = By.xpath("(//*[@onclick='return validate()'])");
	public static final By addBatch = By.xpath("(//*[@href='newbatch'])");
	public static final By batchCode = By.xpath("(//*[@id='batchcode'])");
	public static final By medicineCode = By.xpath("(//*[@id='medicinecode'])");
	public static final By weight = By.xpath("(//*[@id='weight'])");
	public static final By price = By.xpath("(//*[@id='price'])");
	public static final By medicineType = By.xpath("(//*[@name='medicinetype'])");
	public static final By refrigerationRequired = By.xpath("(//*[@name='refrigeration'])");
	public static final By add = By.xpath("(//*[@onclick='return validateBatch()'])");
	public static final By help = By.linkText("Help");
	public static final By helpMsg = By.xpath("//div[contains(.,'Please click the below link to see the user manual for the site.')]");
	public static final By userManual = By.linkText("User Manual");
	public static final By iweight = By.xpath("//span[contains(.,'Batch Weight Should be greater than 100')]");
	public static final By addMsg = By.xpath("//span[contains(.,'Batch details added successfully')]");
	public static final By delete=By.xpath("//*[text()='Delete Batch']");
	public static final By BatchCode=By.xpath("//*[@id='batchcode']");
	public static final By deletebutton=By.xpath("//*[@value='Delete']");
	public static final By idelete1 = By.xpath("//span[contains(.,'The batch details deleted successfully')]");
	public static final By idelete2 = By.xpath("//span[contains(.,'The batch code not present in system')]");
}
