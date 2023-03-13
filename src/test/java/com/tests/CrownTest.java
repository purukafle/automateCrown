package com.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.libraries.Base;
import com.pages.HomePage;

public class CrownTest extends Base {
	@Test
	public void homePageTest() {
		HomePage page=new HomePage(driver);
		page.goToHomePage();
		String title=driver.getTitle();	
		System.out.println(title);
		String expected="Crown Equipment Corporation | USA | Material Handling";
		assertEquals(title, expected);		
	}
	

}
