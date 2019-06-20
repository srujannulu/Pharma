package com.cognizant.Pharmacy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class fieldLevelValidation {

	WebDriver driver;
	@BeforeTest
    public void launchDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation\\Driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
	
	@BeforeMethod
	public void launchBrowser() {
		driver.get("http://ctsc00849530701:9000/Pharma/");
	}
	
	@Test (priority = 0)
	public void loginDetails() throws Exception {
		File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
        FileInputStream fis=new FileInputStream(src);
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sh1=wb.getSheetAt(4);
        ArrayList<WebElement>loginPageFields=(ArrayList<WebElement>) driver.findElements(By.xpath("//table//tbody//tr//th"));
        for(int i = 0; i<loginPageFields.size(); i++)
        {
        	if(i==0){
        		Assert.assertEquals(loginPageFields.get(i).getText(), sh1.getRow(0).getCell(0).getStringCellValue());
        		System.out.println(loginPageFields.get(i).getText());
        	}
        	if(i==1){
        		Assert.assertEquals(loginPageFields.get(i).getText(), sh1.getRow(0).getCell(1).getStringCellValue());
        		System.out.println(loginPageFields.get(i).getText());
        	}
	    
        }
	}
	
	@Test (priority = 1)
	public void addNewBatchDetails() throws Exception {
		File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
	    FileInputStream fis=new FileInputStream(src);
	    XSSFWorkbook wb=new XSSFWorkbook(fis);
	    XSSFSheet sh1=wb.getSheetAt(4);
	    driver.findElement(pageObject.uname).click();
	    driver.findElement(pageObject.uname).sendKeys("admin");
		driver.findElement(pageObject.pwd).click();
		driver.findElement(pageObject.pwd).sendKeys("admin");
		driver.findElement(pageObject.login).click();
		Thread.sleep(3000);
	    driver.findElement(pageObject.addBatch).click();
	    ArrayList<WebElement>BatchDetails=(ArrayList<WebElement>) driver.findElements(By.xpath("//table//tbody//tr//th"));
		for(int i = 0; i<BatchDetails.size(); i++)
		{
			if(i==0){
				Assert.assertEquals(BatchDetails.get(i).getText(), sh1.getRow(1).getCell(0).getStringCellValue());
				System.out.println(BatchDetails.get(i).getText());
		    }
		    if(i==1){
		    	Assert.assertEquals(BatchDetails.get(i).getText(), sh1.getRow(1).getCell(1).getStringCellValue());
		    	System.out.println(BatchDetails.get(i).getText());
		    }
		    if(i==2){
		    	Assert.assertEquals(BatchDetails.get(i).getText(), sh1.getRow(1).getCell(2).getStringCellValue());
		    	System.out.println(BatchDetails.get(i).getText());
		    }
		    if(i==3){
		    	Assert.assertEquals(BatchDetails.get(i).getText(), sh1.getRow(1).getCell(3).getStringCellValue());
		    	System.out.println(BatchDetails.get(i).getText());
		    }
		    if(i==4){
		    	Assert.assertEquals(BatchDetails.get(i).getText(), sh1.getRow(1).getCell(4).getStringCellValue());
		    	System.out.println(BatchDetails.get(i).getText()); 
		    }
		    if(i==5){
			    Assert.assertEquals(BatchDetails.get(i).getText(), sh1.getRow(1).getCell(5).getStringCellValue());
			    System.out.println(BatchDetails.get(i).getText());  
		    }
		 }
	}
	
	@Test (priority = 2)
	public void searchBatchDetails() throws Exception {
		File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(4);
		driver.findElement(pageObject.uname).click();
		driver.findElement(pageObject.uname).sendKeys("admin");
		driver.findElement(pageObject.pwd).click();
		driver.findElement(pageObject.pwd).sendKeys("admin");
		driver.findElement(pageObject.login).click();
        Thread.sleep(3000);
        driver.findElement(pageObject.searchBatch).click();
		ArrayList<WebElement>SearchDetails=(ArrayList<WebElement>) driver.findElements(By.xpath("//table//tbody//tr//th"));
		for(int i = 0; i<SearchDetails.size(); i++)
		{
			if(i==0){
				Assert.assertEquals(SearchDetails.get(i).getText(), sh1.getRow(2).getCell(0).getStringCellValue());
			    System.out.println(SearchDetails.get(i).getText());
			}
		}
	}
			 
	@Test (priority = 3)
	public void deleteBatchDetails() throws Exception {
		File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(4);
		driver.findElement(pageObject.uname).click();
		driver.findElement(pageObject.uname).sendKeys("admin");
		driver.findElement(pageObject.pwd).click();
		driver.findElement(pageObject.pwd).sendKeys("admin");
		driver.findElement(pageObject.login).click();
        Thread.sleep(3000);
        driver.findElement(pageObject.delete).click();
		ArrayList<WebElement>DeleteDetails=(ArrayList<WebElement>) driver.findElements(By.xpath("//table//tbody//tr//th"));
		for(int i = 0; i<DeleteDetails.size(); i++)
		{
			if(i==0){
				Assert.assertEquals(DeleteDetails.get(i).getText(), sh1.getRow(3).getCell(0).getStringCellValue());
				System.out.println(DeleteDetails.get(i).getText());
			}
		}	 
	}
	
	@AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
    	if (testResult.getStatus() == ITestResult.FAILURE) {
    		System.out.println(testResult.getStatus());
    	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	    FileUtils.copyFile(scrFile, new File("C:\\Users\\776492\\Documents\\FailedTestCases\\fieldLevelValidation\\" + testResult.getName() + ".jpg"));
	    }        
	}
   
    @AfterTest
    public void TearDown() {
    	driver.quit();
    }
	
}
