package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.libraries.Base;

public class HomePage extends Base{
	
	String url="https://www.crown.com/en-us.html";
	public WebDriver driver;
	public HomePage(WebDriver _driver) {
		this.driver=_driver;
		
		
	}
	public HomePage goToHomePage() {
		driver.get(url);
		return this;
	}
	public void myCrownButton() {
		System.out.println("need to be implement");
		
		myUtils.customWait(10);
	}
	
	
	

}
