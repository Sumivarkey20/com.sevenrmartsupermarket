package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.CategoryPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class CategoryTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	CategoryPage categorypage;

	@Test
	public void verifyNewButtonText() {
		homepage = new HomePage(driver);
		categorypage = new CategoryPage(driver);
		homepage=loginpage.logIn();
		homepage.clickOnCategory();
		categorypage.clickOnNewButton();
		String actualNewButtonText = categorypage.getNewButtonText();
		String expectedNewButtonText = "Enter Category Informations";
		Assert.assertEquals(actualNewButtonText, expectedNewButtonText);
	}

	@Test
	public void verifySearchCategoryTextStatus() {
		homepage = new HomePage(driver);
		categorypage = new CategoryPage(driver);
		homepage=loginpage.logIn();
		homepage.clickOnCategory();
		String text = "Bags";
		categorypage.verifySearchButtonFunction(text);
		categorypage.categoryTextSearchClick();
		String actualStatus=categorypage.getCategoryTextStatus(text);
		String expectedStatus="Active";
		Assert.assertEquals(actualStatus, expectedStatus);
		
		
	}
}
