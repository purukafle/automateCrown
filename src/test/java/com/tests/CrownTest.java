package com.tests;

import org.testng.annotations.Test;

import com.libraries.Base;
import com.pages.HomePage;

public class CrownTest extends Base {
	@Test
	public void homePageTest() {
		HomePage page=new HomePage(driver);
		page.gotoCrownHomePage();
		
		
	}

}
