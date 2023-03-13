package com.pages;

import org.openqa.selenium.WebDriver;

import com.libraries.Base;

public class HomePage extends Base{
	
	String url="https://www.kayak.com/";
	
	public WebDriver driver;
	public HomePage(WebDriver _driver) {
		this.driver=_driver;
		
		
	}
	public HomePage goToHomePage() {
		driver.get(url);
		return this;
	}
	
	
	

}
