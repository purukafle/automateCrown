package com.libraries;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utilities {
	private WebDriver driver;
	private static int waitTimesec=30;
	
	public WebDriver getDriver() {
		return driver;
		
	}
	public void setDriver(WebDriver _driver) {
		this.driver=_driver;
	}
	public enum Browser{
		CHROME, FIREFOX, SAFARI, EDGE_CHROMIUM
		
	}
	public WebDriver startDriver(Browser browser) {
		try {
			switch (browser) {
			case CHROME:
				driver=startChromeDriver();
				break;
			case FIREFOX:
				driver=startFirefoxDriver();
				break;
			case SAFARI:
				driver=startSafariDriver();
				break;
			case EDGE_CHROMIUM:
				driver=startEdge_ChromiumDriver();
				break;
			default: 
				System.out.println("Does not supports the browser....");
				System.out.println("by default chrome will be open");
				driver=startChromeDriver();
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals(true,false);
		}
		return driver;
		
		
	}
	
	
	private WebDriver startChromeDriver() {
		try {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals(true,false);
		}
		return driver;
	}
	private WebDriver startFirefoxDriver() {
		try {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals(true,false);
		}
		
		return driver;
	}
	private WebDriver startEdge_ChromiumDriver() {
		// TODO Auto-generated method stub
		return null;
	}
	private WebDriver startSafariDriver() {
		// TODO Auto-generated method stub
		return null;
	}
	public void pageSync() {
		customWait(5);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimesec));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(waitTimesec));
		
	}
	public void tearDown() {
		try {
			customWait(5);
			driver.close();
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals(true,false);
		}
		
	}
	
	//Helper Methods================================
	public void customWait(double inSeconds) {
		try {
		long Seconds=(long) (inSeconds*1000);		
			Thread.sleep(Seconds);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			assertEquals(true,false);
		}
		
		
	}
	
	
	


}
