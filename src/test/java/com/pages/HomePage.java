package com.pages;

import org.openqa.selenium.WebDriver;

import com.libraries.Base;

public class HomePage extends Base{
	private WebDriver driver;
	
	public HomePage(WebDriver _driver) {
		driver=_driver;
	}
	public HomePage gotoCrownHomePage() {
		String webUrl="https://www.crown.com/en-us.html";
		driver.get(webUrl);
		return this;
		
	}
	
	

}
