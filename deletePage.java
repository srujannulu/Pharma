package com.cognizant.Pharmacy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class deletePage {
	
	WebDriver driver;
	@BeforeTest()
	public void LaunchBrowser()
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation\\Driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("http://ctsc00849530701:9000/Pharma/login.jsp");
		    driver.findElement(pageObject.uname).click();
			driver.findElement(pageObject.uname).sendKeys("admin");
			driver.findElement(pageObject.pwd).click();
			driver.findElement(pageObject.pwd).sendKeys("admin");
			driver.findElement(pageObject.login).click();
	}
	
	@BeforeMethod()
	public void openDelete()
	{
		driver.findElement(pageObject.delete).click();
		
	}
	
    @Test (priority = 0)
    public void deletePageTest1() throws IOException, InterruptedException
    {
    	File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(0);

		int bc = (int) sh1.getRow(0).getCell(0).getNumericCellValue();
		driver.findElement(pageObject.batchCode).sendKeys(String.valueOf(bc));
		Thread.sleep(2000);
    	//driver.findElement(pageObject.batchCode).sendKeys("d25");
		driver.findElement(pageObject.deletebutton).click();
		String einvaliduname = "The batch details deleted successfully";
		String invaliduname = driver.findElement(pageObject.idelete1).getText();
		Assert.assertEquals(invaliduname,einvaliduname);
		
    }
    
    @Test (priority = 1)
    public void deletePageTest2() throws IOException, InterruptedException
    {

    	File src=new File("C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation_Inheritance\\ExcelFiles\\Pharmacy.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(0);

		int bc = (int) sh1.getRow(1).getCell(0).getNumericCellValue();
		driver.findElement(pageObject.batchCode).sendKeys(String.valueOf(bc));
		Thread.sleep(2000);
    	//driver.findElement(pageObject.batchCode).sendKeys("852");
		driver.findElement(pageObject.deletebutton).click();
		String einvaliduname = "The batch code not present in system";
		String invaliduname = driver.findElement(pageObject.idelete2).getText();
		Assert.assertEquals(invaliduname,einvaliduname);
    }
    
    @AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			
			System.out.println(testResult.getStatus());
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\Users\\776492\\Documents\\FailedTestCases\\deletePage\\" + testResult.getName() + ".jpg"));
	   }        
		
	}
    
    @AfterTest
    public void TearDown()
    {
    	driver.quit();
    }
    
}
