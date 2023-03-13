package com.libraries;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.libraries.Utilities.Browser;

public class Base {
	public WebDriver driver;
	public Utilities myUtils=new Utilities();
	
	@BeforeClass
	public void beforeAllTest() {
		System.out.println("Running before all the tests...");
	}
	@AfterClass
	public void afterAllTest() {
		System.out.println("Running after all the tests........");
	}
	@BeforeMethod
	public void setUp() {
		driver=myUtils.startABrowser(Browser.CHROME);
	}
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus()) {
			myUtils.takeScreenshot(result.getName());
		}
		myUtils.tearDown();
		
	}
	

}
