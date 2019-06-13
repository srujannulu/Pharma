package com.cognizant.Pharmacy;

import org.openqa.selenium.By;

public class pageObject {
	
	public static final By uname = By.name("username");
	public static final By iuname1 = By.xpath("//span[contains(.,'UserName is Invalid')]");
	public static final By iuname2 = By.xpath("//span[contains(.,'UserName and Password does not match')]");
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
}
