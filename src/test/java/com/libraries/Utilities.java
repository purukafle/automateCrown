package com.libraries;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utilities {
	private static int waitTimesec=30;
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}	
	
	public enum Browser{
		CHROME, FIREFOX, SAFARI, EDGE_CHROMIUM
		
	}
	public WebDriver startABrowser(Browser browser) {
		try {
			switch (browser) {
			case CHROME:
				driver=startChromeBrowser();
				break;
			case FIREFOX:
				driver=startFirefoxBrowser();
				break;
			case SAFARI:
				driver=startSafariBrowser();
				break;
			case EDGE_CHROMIUM:
				driver=startEdge_ChromiumBrowser();
				break;
			default: 
				System.out.println("Does not supports the browser....");
				System.out.println("by default chrome will be open");
				driver=startChromeBrowser();
				break;
			
			}
			driver.manage().deleteAllCookies();
			
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals(true,false);
		}
		return driver;
		
		
	}
	
	
	private WebDriver startChromeBrowser() {
		try {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			pageSync();
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals(true,false);
		}
		return driver;
	}
	private WebDriver startFirefoxBrowser() {
		try {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			pageSync();
			
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals(true,false);
		}
		
		return driver;
	}
	private WebDriver startEdge_ChromiumBrowser() {
		// TODO Auto-generated method stub
		return null;
	}
	private WebDriver startSafariBrowser() {
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
	public String takeScreenshot(String screenshotname) {
		String finalScreenshotPath=null;
		try {
			String fileLocation="target/"+screenshotname+ "_" +getCurrentTime()+".png";
			File filePath=new File(fileLocation);
			String newPath=filePath.getAbsolutePath();
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(srcFile, new File(newPath));
			finalScreenshotPath=newPath;
			System.out.println("screen shot location ---->"+newPath);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals(true,false);
		}
		return finalScreenshotPath;
		
		
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
	private String getCurrentTime() {
		String finalTimeStamp=null;
		try {
			Date date=new Date();
			System.out.println("current date: "+date);
			String tempTime=new Timestamp(date.getTime()).toString();
			finalTimeStamp=tempTime;
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals(true,false);
			
		}
		return finalTimeStamp;
		
	}
	
	
	
	


}
