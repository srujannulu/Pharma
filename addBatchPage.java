package com.cognizant.Pharmacy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class addBatchPage {
	
	WebDriver driver;
	@BeforeTest
	public void launchBrowser(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation\\Driver\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    driver.get("http://ctsc00849530701:9000/Pharma/");
		driver.findElement(pageObject.uname).click();
		driver.findElement(pageObject.uname).sendKeys("admin");
		driver.findElement(pageObject.pwd).click();
		driver.findElement(pageObject.pwd).sendKeys("admin");
		driver.findElement(pageObject.login).click();
	}
	
	@BeforeMethod
	public void launchAddBatch(){
		driver.findElement(pageObject.addBatch).click();
	}
	
	@Test (priority = 0)
	public void addBatchTest1() throws Exception{
		driver.findElement(pageObject.batchCode).click();
		File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(0);

		int bc = (int) sh1.getRow(0).getCell(0).getNumericCellValue();
		driver.findElement(pageObject.batchCode).sendKeys(String.valueOf(bc));
		int mc = (int) sh1.getRow(0).getCell(1).getNumericCellValue();
		Select bd = new Select(driver.findElement(pageObject.medicineCode));
		bd.selectByVisibleText(String.valueOf(mc));
		int wt = (int) sh1.getRow(0).getCell(2).getNumericCellValue();
		driver.findElement(pageObject.weight).clear();
		driver.findElement(pageObject.weight).sendKeys(String.valueOf(wt));
		int pr = (int) sh1.getRow(0).getCell(3).getNumericCellValue();
		driver.findElement(pageObject.price).clear();
		driver.findElement(pageObject.price).sendKeys(String.valueOf(pr));
		String mt = sh1.getRow(0).getCell(4).getStringCellValue();
		Select medtyp = new Select(driver.findElement(pageObject.medicineType));
		medtyp.selectByVisibleText(mt);
		String ref = sh1.getRow(0).getCell(5).getStringCellValue();
		if(ref == "yes") {
			driver.findElement(pageObject.refrigerationYes).click();
		}
		else {
			driver.findElement(pageObject.refrigerationNo).click();
		}
		
		driver.findElement(pageObject.add).click();
		
		String emsg = "The batch code already added.";
		String msg = driver.findElement(pageObject.addPresentMsg).getText();
		Assert.assertEquals(msg,emsg);
		
		/*String emsg = "Batch details added successfully";
		String msg = driver.findElement(pageObject.addMsg).getText();
		Assert.assertEquals(msg,emsg);*/
	}
	
	@Test (priority = 1)
	public void addBatchTest2() throws Exception{
		driver.findElement(pageObject.batchCode).click();
		File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(0);

		String bc = sh1.getRow(1).getCell(0).getStringCellValue();
		driver.findElement(pageObject.batchCode).sendKeys(bc);
		int mc = (int) sh1.getRow(1).getCell(1).getNumericCellValue();
		Select bd = new Select(driver.findElement(pageObject.medicineCode));
		bd.selectByVisibleText(String.valueOf(mc));
		int wt = (int) sh1.getRow(1).getCell(2).getNumericCellValue();
		driver.findElement(pageObject.weight).clear();
		driver.findElement(pageObject.weight).sendKeys(String.valueOf(wt));
		int pr = (int) sh1.getRow(1).getCell(3).getNumericCellValue();
		driver.findElement(pageObject.price).clear();
		driver.findElement(pageObject.price).sendKeys(String.valueOf(pr));
		String mt = sh1.getRow(1).getCell(4).getStringCellValue();
		Select medtyp = new Select(driver.findElement(pageObject.medicineType));
		medtyp.selectByVisibleText(mt);
		String ref = sh1.getRow(1).getCell(5).getStringCellValue();
		if(ref == "yes") {
			driver.findElement(pageObject.refrigerationYes).click();
		}
		else {
			driver.findElement(pageObject.refrigerationNo).click();
		}
				
		driver.findElement(pageObject.add).click();
		
		String eAlert="Batch code must be a number";
		Alert alert=driver.switchTo().alert();
		String arrivedAlert=alert.getText();
		alert.dismiss();
		Assert.assertEquals(arrivedAlert,eAlert);
	}
	
	@Test (priority = 2)
	public void addBatchTest3() throws Exception{
		driver.findElement(pageObject.batchCode).click();
		File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(0);

		int bc = (int) sh1.getRow(2).getCell(0).getNumericCellValue();
		driver.findElement(pageObject.batchCode).sendKeys(String.valueOf(bc));
		int mc = (int) sh1.getRow(2).getCell(1).getNumericCellValue();
		Select bd = new Select(driver.findElement(pageObject.medicineCode));
		bd.selectByVisibleText(String.valueOf(mc));
		int wt = (int) sh1.getRow(2).getCell(2).getNumericCellValue();
		driver.findElement(pageObject.weight).clear();
		driver.findElement(pageObject.weight).sendKeys(String.valueOf(wt));
		int pr = (int) sh1.getRow(2).getCell(3).getNumericCellValue();
		driver.findElement(pageObject.price).clear();
		driver.findElement(pageObject.price).sendKeys(String.valueOf(pr));
		String mt = sh1.getRow(2).getCell(4).getStringCellValue();
		Select medtyp = new Select(driver.findElement(pageObject.medicineType));
		medtyp.selectByVisibleText(mt);
		String ref = sh1.getRow(2).getCell(5).getStringCellValue();
		if(ref == "yes") {
			driver.findElement(pageObject.refrigerationYes).click();
		}
		else {
			driver.findElement(pageObject.refrigerationNo).click();
		}
				
		driver.findElement(pageObject.add).click();
		
		String einvalidwt = "Batch Weight Should be greater than 100";
		String invalidwt = driver.findElement(pageObject.iweight).getText();
		Assert.assertEquals(invalidwt,einvalidwt);
	}
	
	@Test (priority = 3)
	public void addBatchTest4() throws Exception{
		driver.findElement(pageObject.batchCode).click();
		File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(0);

		int bc = (int) sh1.getRow(3).getCell(0).getNumericCellValue();
		driver.findElement(pageObject.batchCode).sendKeys(String.valueOf(bc));
		int mc = (int) sh1.getRow(3).getCell(1).getNumericCellValue();
		Select bd = new Select(driver.findElement(pageObject.medicineCode));
		bd.selectByVisibleText(String.valueOf(mc));
		int wt = (int) sh1.getRow(3).getCell(2).getNumericCellValue();
		driver.findElement(pageObject.weight).clear();
		driver.findElement(pageObject.weight).sendKeys(String.valueOf(wt));
		int pr = (int) sh1.getRow(3).getCell(3).getNumericCellValue();
		driver.findElement(pageObject.price).clear();
		driver.findElement(pageObject.price).sendKeys(String.valueOf(pr));
		String mt = sh1.getRow(3).getCell(4).getStringCellValue();
		Select medtyp = new Select(driver.findElement(pageObject.medicineType));
		medtyp.selectByVisibleText(mt);
		String ref = sh1.getRow(3).getCell(5).getStringCellValue();
		if(ref == "yes") {
			driver.findElement(pageObject.refrigerationYes).click();
		}
		else {
			driver.findElement(pageObject.refrigerationNo).click();
		}
				
		driver.findElement(pageObject.add).click();
		
		String eAlert="Weight must be a positive number"; 
		Alert alert=driver.switchTo().alert();
		String arrivedAlert=alert.getText();
		alert.dismiss();
		Assert.assertEquals(arrivedAlert,eAlert);
	}
	
	@Test (priority = 4)
	public void addBatchTest5() throws Exception{
		driver.findElement(pageObject.batchCode).click();
		File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(0);

		int bc = (int) sh1.getRow(4).getCell(0).getNumericCellValue();
		driver.findElement(pageObject.batchCode).sendKeys(String.valueOf(bc));
		int mc = (int) sh1.getRow(4).getCell(1).getNumericCellValue();
		Select bd = new Select(driver.findElement(pageObject.medicineCode));
		bd.selectByVisibleText(String.valueOf(mc));
		int wt = (int) sh1.getRow(4).getCell(2).getNumericCellValue();
		driver.findElement(pageObject.weight).clear();
		driver.findElement(pageObject.weight).sendKeys(String.valueOf(wt));
		int pr = (int) sh1.getRow(4).getCell(3).getNumericCellValue();
		driver.findElement(pageObject.price).clear();
		driver.findElement(pageObject.price).sendKeys(String.valueOf(pr));
		
		String mt = sh1.getRow(4).getCell(4).getStringCellValue();
		Select medtyp = new Select(driver.findElement(pageObject.medicineType));
		medtyp.selectByVisibleText(mt);
		String ref = sh1.getRow(4).getCell(5).getStringCellValue();
		if(ref == "yes") {
			driver.findElement(pageObject.refrigerationYes).click();
		}
		else {
			driver.findElement(pageObject.refrigerationNo).click();
		}
				
		driver.findElement(pageObject.add).click();
		
		String eAlert="Price must be a number";
		Alert alert=driver.switchTo().alert();
		String arrivedAlert=alert.getText();
		alert.dismiss();
		Assert.assertEquals(arrivedAlert,eAlert);
		
		int pr1 = (int) sh1.getRow(4).getCell(6).getNumericCellValue();
		driver.findElement(pageObject.price).clear();
		driver.findElement(pageObject.price).sendKeys(String.valueOf(pr1));
		
		driver.findElement(pageObject.add).click();
		
		String emsg = "The batch code already added.";
		String msg = driver.findElement(pageObject.addPresentMsg).getText();
		Assert.assertEquals(msg,emsg);
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println(testResult.getStatus());
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\Users\\776492\\Documents\\FailedTestCases\\addBatchPage\\" + testResult.getName() + ".jpg"));
	   }        
	}
	
	@AfterTest
	public void TearDown(){
		driver.quit();
	}
	
}
