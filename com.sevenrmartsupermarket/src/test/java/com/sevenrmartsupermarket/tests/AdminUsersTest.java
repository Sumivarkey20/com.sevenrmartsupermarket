package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;


public class AdminUsersTest extends Base{
	
	LoginPage loginpage;
	HomePage homepage;
	AdminUsersPage adminuserspage;
	
	@Test
	public void verifyAdminUserHeader()
	{				
		loginpage=new LoginPage(driver);
		homepage =loginpage.logIn();
		adminuserspage=homepage.clickOnAdminUsers();
		String actualHeader=adminuserspage.getAdminPageHeader();
		String expectedHeader = "Admin Users";
		Assert.assertEquals(actualHeader, expectedHeader);
		
	}
	
	@Test
	 
	public void verifyNewButtonText()
	{
		loginpage=new LoginPage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginpage.logIn();
		adminuserspage =homepage.clickOnAdminUsers();
		adminuserspage.clickOnNewButton();
		String actualNewButtonText= adminuserspage.getNewButtonText();
		String expectedNewButtonText = "Admin Users Informations";
		Assert.assertEquals(actualNewButtonText, expectedNewButtonText);
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
		public void verifyAddUserStatus()
	{	
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginpage.logIn();
		homepage.clickOnAdminUsers();
		adminuserspage.clickOnNewButton();
		adminuserspage.addNewUser("super1", "User123","Admin");
		String actualSuccessText = adminuserspage.getSaveButtonText();
		System.out.println(actualSuccessText);
		String expectedSuccessText = "User Created Successfully";
		Assert.assertEquals(actualSuccessText, expectedSuccessText);
	}

}
