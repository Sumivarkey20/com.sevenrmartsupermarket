package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class LoginTest extends Base{
	
	LoginPage loginpage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();
	@Test(groups="regression")
	 
	public void verifyLogin()
	{
		excelreader.setExcelFile("LoginData","InvalidCredentials");
		loginpage=new LoginPage(driver);
		String userName=excelreader.getCellData(0, 1);
		String password=excelreader.getCellData(1, 1);
		System.out.println(userName);
		System.out.println(password);
		homepage=loginpage.logIn();
		String expectedProfileName = "admin";
		String actualProfileName= homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}

}
