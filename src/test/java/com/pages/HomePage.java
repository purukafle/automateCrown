package com.pages;

import org.openqa.selenium.WebDriver;

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
	
	
	

}
