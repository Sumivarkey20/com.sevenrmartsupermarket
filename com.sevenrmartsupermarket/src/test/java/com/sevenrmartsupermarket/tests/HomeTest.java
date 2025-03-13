package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class HomeTest extends Base{
	
	HomePage homepage;
	LoginPage loginpage;
	
	@Test
	 
	public void verifyAdminLogo()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.logIn("sumiv","sumiv");
		Assert.assertTrue(homepage.IsAdminLogoDisplayed());
}
	
	@Test(groups={"smoke","regression"})
	 
	public void isAdminLogoEnable()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.logIn("sumiv","sumiv");
		Assert.assertTrue(homepage.IsAdminLogoEnabled());
}
	@Test(groups="smoke")
	 
	public void verifyAdminUserInfo()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.logIn();
		homepage.clickOnAdminUsers();
		
	}
	
	
	
	

}
