package com.cognizant.Pharmacy;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
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


public class loginPage {
	
	WebDriver driver;
	@BeforeTest
	public void launchDriver(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\776492\\Documents\\Testing\\Selenium\\Codes\\Test_Automation\\Driver\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void launchBrowser(){
		driver.get("http://ctsc00849530701:9000/Pharma/");
	}
	
	@Test (priority = 0)
	public void loginPageTest0(){
		driver.findElement(pageObject.uname).click();
		driver.findElement(pageObject.uname).sendKeys("admin");
		driver.findElement(pageObject.pwd).click();
		driver.findElement(pageObject.pwd).sendKeys("admin");
		driver.findElement(pageObject.login).click();
	}
	
	@Test (priority = 1)
	public void loginPageTest1(){
		driver.findElement(pageObject.uname).click();
		driver.findElement(pageObject.uname).sendKeys("adam");
		driver.findElement(pageObject.pwd).click();
		driver.findElement(pageObject.pwd).sendKeys("admin");
		driver.findElement(pageObject.login).click();
		
		String einvaliduname = "UserName is Invalid";
		String invaliduname = driver.findElement(pageObject.iuname1).getText();
		Assert.assertEquals(invaliduname,einvaliduname);
	}
	
	@Test (priority = 2)
	public void loginPageTest2(){
		driver.findElement(pageObject.uname).click();
		driver.findElement(pageObject.uname).sendKeys("admin");
		driver.findElement(pageObject.pwd).click();
		driver.findElement(pageObject.pwd).sendKeys("adam");
		driver.findElement(pageObject.login).click();
		
		String einvaliduname = "UserName and Password does not match";
		String invaliduname = driver.findElement(pageObject.iuname2).getText();
		Assert.assertEquals(invaliduname,einvaliduname);
	}
	
	@Test (priority = 3)
	public void loginPageTest3(){
		driver.findElement(pageObject.uname).click();
		driver.findElement(pageObject.uname).sendKeys("adam");
		driver.findElement(pageObject.pwd).click();
		driver.findElement(pageObject.pwd).sendKeys("adam");
		driver.findElement(pageObject.login).click();
		
		String einvaliduname = "UserName is Invalid";
		String invaliduname = driver.findElement(pageObject.iuname1).getText();
		Assert.assertEquals(invaliduname,einvaliduname);
	}
	
	@Test (priority = 4)
	public void loginPageTest4(){
		driver.findElement(pageObject.uname).click();
		driver.findElement(pageObject.uname).sendKeys(" ");
		driver.findElement(pageObject.pwd).click();
		driver.findElement(pageObject.pwd).sendKeys("admin");
		driver.findElement(pageObject.login).click();
		
		String eAlert="Please enter user id";
		Alert alert=driver.switchTo().alert();
		String arrivedAlert=alert.getText();
		alert.dismiss();
		Assert.assertEquals(arrivedAlert,eAlert);
	}
	
	@Test (priority = 5)
	public void loginPageTest5(){
		driver.findElement(pageObject.uname).click();
		driver.findElement(pageObject.uname).sendKeys("admin");
		driver.findElement(pageObject.pwd).click();
		driver.findElement(pageObject.pwd).sendKeys(" ");
		driver.findElement(pageObject.login).click();
		
		String eAlert="Please enter passsword";
		Alert alert=driver.switchTo().alert();
		String arrivedAlert=alert.getText();
		alert.dismiss();
		Assert.assertEquals(arrivedAlert,eAlert);
	}
	
	@Test (priority = 6)
	public void loginPageTest6(){
		driver.findElement(pageObject.uname).click();
		driver.findElement(pageObject.uname).sendKeys(" ");
		driver.findElement(pageObject.pwd).click();
		driver.findElement(pageObject.pwd).sendKeys(" ");
		driver.findElement(pageObject.login).click();
		
		String eAlert="Please enter user id";
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
			FileUtils.copyFile(scrFile, new File("C:\\Users\\776492\\Documents\\FailedTestCases\\LoginPage\\" + testResult.getName() + ".jpg"));
	   }        
	}
	
	@AfterTest
	public void TearDown(){
		driver.quit();
	}
		
}
