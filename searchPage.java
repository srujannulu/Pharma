package com.cognizant.Pharmacy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class searchPage {
	
	WebDriver driver;
    @BeforeTest
    public void launchDriver() {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation\\Driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ctsc00849530701:9000/Pharma/");
        driver.findElement(pageObject.uname).click();
        driver.findElement(pageObject.uname).sendKeys("admin");
        driver.findElement(pageObject.pwd).click();
        driver.findElement(pageObject.pwd).sendKeys("admin");
        driver.findElement(pageObject.login).click();
    }
    
    @BeforeMethod
    public void search() {
   	 	driver.findElement(pageObject.searchBatch).click();
        driver.findElement(pageObject.batchCode).click();
    }
      
    @Test(priority=0)
    public void SearchPageTest0() throws Exception {
    	File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
  		FileInputStream fis=new FileInputStream(src);
  		XSSFWorkbook wb=new XSSFWorkbook(fis);
  		XSSFSheet sh1=wb.getSheetAt(1);
  		int bc = (int) sh1.getRow(0).getCell(0).getNumericCellValue();
  		driver.findElement(pageObject.batchCode).sendKeys(String.valueOf(bc));
  		Thread.sleep(2000);	            
        driver.findElement(pageObject.searchBtn).click(); 
          
        Integer xlWeight = (int) sh1.getRow(1).getCell(0).getNumericCellValue(); 
  		String webWeight = driver.findElement(pageObject.weight).getAttribute("value");
  		Integer resultweight = Integer.valueOf(webWeight);
  		Assert.assertEquals(resultweight,xlWeight);
  		 
  		Integer xlprice = (int) sh1.getRow(1).getCell(1).getNumericCellValue();
  		String webprice = driver.findElement(pageObject.price).getAttribute("value");
  		Integer resultPrice = Integer.valueOf(webprice);
  		Assert.assertEquals(resultPrice,xlprice);
  		   
  		Integer xlmedicine = (int) sh1.getRow(1).getCell(2).getNumericCellValue();
  		String webMedicine = driver.findElement(pageObject.medicineCode).getAttribute("value");
  		Integer resultmedicine = Integer.valueOf(webMedicine);
  		Assert.assertEquals(resultmedicine,xlmedicine);
  		   
  		String xlmedicinetype = sh1.getRow(1).getCell(3).getStringCellValue();
  		WebElement webmedicinetype = driver.findElement(pageObject.medicineType); 
  		Select select = new Select(webmedicinetype);
  		WebElement tmp = select.getFirstSelectedOption();
  		String resultmt = tmp.getText();
  		Assert.assertEquals(resultmt,xlmedicinetype);
  		   
      }
   
      @Test(priority=1)
      public void SearchPageTest1() throws Exception {
    	  File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
	   	  FileInputStream fis=new FileInputStream(src);
	   	  XSSFWorkbook wb=new XSSFWorkbook(fis);
	   	  XSSFSheet sh1=wb.getSheetAt(1);
	   	  int bc = (int) sh1.getRow(0).getCell(1).getNumericCellValue();
	   	  driver.findElement(pageObject.batchCode).sendKeys(String.valueOf(bc));
	   	  Thread.sleep(2000);
          driver.findElement(pageObject.searchBtn).click();
          Thread.sleep(3000);
          String expectedBcodeMsg = "The batch code not present in system";
          String actualBcodeMsg = driver.findElement(pageObject.bCodeMsg).getText();
          Assert.assertEquals(actualBcodeMsg,expectedBcodeMsg);
      
      
      }
	
      @Test(priority=2)
      public void SearchPageTest2() throws Exception {
    	  File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
    	  FileInputStream fis=new FileInputStream(src);
    	  XSSFWorkbook wb=new XSSFWorkbook(fis);
    	  XSSFSheet sh1=wb.getSheetAt(1);
    	  String bc = sh1.getRow(0).getCell(2).getStringCellValue();
    	  driver.findElement(pageObject.batchCode).sendKeys(bc);
    	  Thread.sleep(2000);       
    	  //driver.findElement(PageObject.sBatchCode).sendKeys(" ");        
    	  driver.findElement(pageObject.searchBtn).click();
          Thread.sleep(3000); 
          String emsg="Please enter batch code";
	      Alert alert=driver.switchTo().alert();
	      String msg=alert.getText();
	      alert.accept();
	      Assert.assertEquals(msg, emsg);
      }
      
      @Test(priority=3)
      public void SearchPageTest3() throws Exception {
    	  File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
    	  FileInputStream fis=new FileInputStream(src);
    	  XSSFWorkbook wb=new XSSFWorkbook(fis);
    	  XSSFSheet sh1=wb.getSheetAt(1);
    	  int bc = (int) sh1.getRow(0).getCell(3).getNumericCellValue();
    	  driver.findElement(pageObject.batchCode).sendKeys(String.valueOf(bc));
          //driver.findElement(PageObject.sBatchCode).sendKeys("879827");          
          driver.findElement(pageObject.searchBtn).click();
          Thread.sleep(3000);   
          String emsg="Batch Code value must be less then 5 digits";
          Alert alert=driver.switchTo().alert();
          String msg=alert.getText();
          alert.accept();
          Assert.assertEquals(msg, emsg);
      }
   
      @AfterMethod
  	  public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
    	  if (testResult.getStatus() == ITestResult.FAILURE) {
    		  System.out.println(testResult.getStatus());
  			  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  			  FileUtils.copyFile(scrFile, new File("C:\\Users\\776492\\Documents\\FailedTestCases\\searchPage\\" + testResult.getName() + ".jpg"));
  	      }        
  	  }
      
      @AfterTest
      public void TearDown() {
    	  driver.quit();
      }
	
}
