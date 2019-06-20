package com.cognizant.Pharmacy;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class logoutPage {
	
	WebDriver driver;
	@BeforeTest
	public void LaunchDriver(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation\\Driver\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    driver.get("http://ctsc00849530701:9000/Pharma/");
	}
	
	@BeforeMethod
	public void LaunchBrowser(){
		driver.findElement(pageObject.uname).click();
		driver.findElement(pageObject.uname).sendKeys("admin");
		driver.findElement(pageObject.pwd).click();
		driver.findElement(pageObject.pwd).sendKeys("admin");
		driver.findElement(pageObject.login).click();
	}
	
	@Test
	public void logoutPageTest(){
		driver.findElement(pageObject.logout).click();
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println(testResult.getStatus());
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\Users\\776492\\Documents\\FailedTestCases\\logoutPage\\" + testResult.getName() + ".jpg"));
	   }        
	}
	
	@AfterTest
	public void TearDown(){
		driver.quit();
	}
	
}
