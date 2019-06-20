package com.cognizant.Pharmacy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class updatePage {

	WebDriver driver;     
    @BeforeTest
    public void launchBrowser() throws Exception {
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
    	Thread.sleep(3000);
	}
    
    @BeforeMethod
    public void search() throws Exception {
    	File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
   		FileInputStream fis=new FileInputStream(src);
   		XSSFWorkbook wb=new XSSFWorkbook(fis);
   		XSSFSheet sh1=wb.getSheetAt(2);
   		int bc = (int) sh1.getRow(0).getCell(0).getNumericCellValue();
   		driver.findElement(pageObject.searchBatch).click();
        driver.findElement(pageObject.batchCode).click();
        driver.findElement(pageObject.batchCode).sendKeys(String.valueOf(bc));
        driver.findElement(pageObject.searchBtn).click();
    }

    @Test(priority = 0)
    public void updatePageTest1() throws Exception {
    	File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh2=wb.getSheetAt(2);
		int bc1 = (int) sh2.getRow(0).getCell(1).getNumericCellValue();
		int bc2 = (int) sh2.getRow(0).getCell(2).getNumericCellValue();
		int bc3 = (int) sh2.getRow(0).getCell(3).getNumericCellValue();
		String bc4 = sh2.getRow(0).getCell(4).getStringCellValue();
		   
	    driver.findElement(pageObject.medicineCode).click();
	    Select medCode = new Select(driver.findElement(pageObject.medicineCode));
	    medCode.selectByVisibleText(String.valueOf(bc1));
        driver.findElement(pageObject.weight).clear();
	    driver.findElement(pageObject.weight).click();
        driver.findElement(pageObject.weight).sendKeys(String.valueOf(bc2));
        driver.findElement(pageObject.price).clear();
	    driver.findElement(pageObject.price).click();
        driver.findElement(pageObject.price).sendKeys(String.valueOf(bc3));
        driver.findElement(pageObject.medicineType).click();
        Select medtyp = new Select(driver.findElement(pageObject.medicineType));
        medtyp.selectByVisibleText(bc4);
        driver.findElement(pageObject.refrigerationNo).click();
	    driver.findElement(pageObject.refrigerationNo).isSelected();
	    driver.findElement(pageObject.updateBtn).click();
	   
	    XSSFSheet sh1=wb.getSheetAt(0);
	    sh1.getRow(0).createCell(1).setCellValue(bc1);
	    sh1.getRow(0).createCell(2).setCellValue(bc2);
	    sh1.getRow(0).createCell(3).setCellValue(bc3);
	    sh1.getRow(0).createCell(4).setCellValue(bc4);
	   
	    FileOutputStream fout=new FileOutputStream(new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx"));
	    wb.write(fout);
	    fout.close();
	}

    @Test(priority = 1)
    public void updatePageTest2() throws InterruptedException, IOException{
    	File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(2);
		int bc = (int) sh1.getRow(1).getCell(1).getNumericCellValue();
		int bc1 = (int) sh1.getRow(1).getCell(2).getNumericCellValue();
		int bc2 = (int) sh1.getRow(1).getCell(3).getNumericCellValue();
		String bc3 =  sh1.getRow(1).getCell(4).getStringCellValue();
		   
	    driver.findElement(pageObject.medicineCode).click();
	    Select medCode = new Select(driver.findElement(pageObject.medicineCode));
	    medCode.selectByVisibleText(String.valueOf(bc));
	    driver.findElement(pageObject.weight).clear();
	    driver.findElement(pageObject.weight).click();
        driver.findElement(pageObject.weight).sendKeys(String.valueOf(bc1));
	    driver.findElement(pageObject.price).clear();
	    driver.findElement(pageObject.price).click();
        driver.findElement(pageObject.price).sendKeys(String.valueOf(bc2));
	    driver.findElement(pageObject.medicineType).click();
	    Select medtyp = new Select(driver.findElement(pageObject.medicineType));
        medtyp.selectByVisibleText(bc3);
	    driver.findElement(pageObject.refrigerationNo).click();
	    driver.findElement(pageObject.refrigerationNo).isSelected();
	    driver.findElement(pageObject.updateBtn).click();
	    Thread.sleep(3000);
	    String eAlert="Weight must be a positive number";
	    Alert alert=driver.switchTo().alert();
	    String arrivedAlert=alert.getText();
	    alert.dismiss();
	    Assert.assertEquals(arrivedAlert,eAlert);
    }

    @Test(priority = 2)
    public void updatePageTest3() throws InterruptedException, IOException{
    	File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(2);
		int bc = (int) sh1.getRow(2).getCell(1).getNumericCellValue();
		int bc1 = (int) sh1.getRow(2).getCell(2).getNumericCellValue();
		int bc2 = (int) sh1.getRow(2).getCell(3).getNumericCellValue();
		String bc3 = sh1.getRow(2).getCell(4).getStringCellValue();
	    
        driver.findElement(pageObject.medicineCode).click();
        Select medCode = new Select(driver.findElement(pageObject.medicineCode));
	    medCode.selectByVisibleText(String.valueOf(bc));
        driver.findElement(pageObject.weight).clear();
        driver.findElement(pageObject.weight).click();
        driver.findElement(pageObject.weight).sendKeys(String.valueOf(bc1));
        driver.findElement(pageObject.price).clear();
        driver.findElement(pageObject.price).click();
        driver.findElement(pageObject.price).sendKeys(String.valueOf(bc2));
        driver.findElement(pageObject.medicineType).click();
        Select medtyp = new Select(driver.findElement(pageObject.medicineType));
        medtyp.selectByVisibleText(bc3);
        driver.findElement(pageObject.refrigerationNo).click();
        driver.findElement(pageObject.refrigerationNo).isSelected();
        driver.findElement(pageObject.updateBtn).click();
        Thread.sleep(3000);
        String einvalidBcode = "Batch Weight Should be greater than 100";
        String invalidBcode = driver.findElement(pageObject.iweight).getText();
        Assert.assertEquals(invalidBcode,einvalidBcode);
    }

    @Test(priority = 3)
    public void updatePageTest4() throws InterruptedException, IOException{
    	File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(2);
		int bc = (int) sh1.getRow(3).getCell(1).getNumericCellValue();
		int bc1 = (int) sh1.getRow(3).getCell(2).getNumericCellValue();
		int bc2 = (int) sh1.getRow(3).getCell(3).getNumericCellValue();
		String bc3 = sh1.getRow(3).getCell(4).getStringCellValue();
		   
        driver.findElement(pageObject.medicineCode).click();
        Select medCode = new Select(driver.findElement(pageObject.medicineCode));
	    medCode.selectByVisibleText(String.valueOf(bc));
        driver.findElement(pageObject.weight).clear();
        driver.findElement(pageObject.weight).click();
        driver.findElement(pageObject.weight).sendKeys(String.valueOf(bc1));
        driver.findElement(pageObject.price).clear();
        driver.findElement(pageObject.price).click();
        driver.findElement(pageObject.price).sendKeys(String.valueOf(bc2));
        driver.findElement(pageObject.medicineType).click();
        Select medtyp = new Select(driver.findElement(pageObject.medicineType));
        medtyp.selectByVisibleText(bc3);
        driver.findElement(pageObject.refrigerationNo).click();
        driver.findElement(pageObject.refrigerationNo).isSelected();
        driver.findElement(pageObject.updateBtn).click();
    	Thread.sleep(3000);
    	String eAlert="Price must be a number";
    	Alert alert=driver.switchTo().alert();
    	String arrivedAlert=alert.getText();
    	alert.dismiss();
    	Assert.assertEquals(arrivedAlert,eAlert);

    }
    
    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
    	if (testResult.getStatus() == ITestResult.FAILURE) {
    		System.out.println(testResult.getStatus());
    	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	    FileUtils.copyFile(scrFile, new File("C:\\Users\\776492\\Documents\\FailedTestCases\\updatePage\\" + testResult.getName() + ".jpg"));
	    }        
	}
   
    @AfterTest
    public void TearDown() {
    	driver.quit();
    }
	
}
