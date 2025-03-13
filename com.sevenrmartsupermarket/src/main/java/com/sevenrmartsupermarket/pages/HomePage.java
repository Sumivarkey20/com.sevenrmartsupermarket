package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
WebDriver driver;
	
	@FindBy(xpath = "//div[@class='user-panel mt-3 pb-3 mb-3 d-flex']//a")
	private WebElement profileName_Element;
	@FindBy(xpath = "//div[@class='row']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	private WebElement adminUsers_Element;
	@FindBy(xpath = "//div[@class='row']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")
	private WebElement category_Element;
	
	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']      ")
	private WebElement adminLogo_Element;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public String getProfileName()
	{
		return profileName_Element.getText();
	}
	
	public AdminUsersPage clickOnAdminUsers()
	{
		adminUsers_Element.click();
		return new AdminUsersPage(driver);
	}
	
	public boolean IsAdminLogoDisplayed()
	{
		return adminLogo_Element.isDisplayed();
	}
	
	public boolean IsAdminLogoEnabled()
	{
		return adminLogo_Element.isEnabled();
	}
	
	public void clickOnCategory()
	{
		category_Element.click();
	}
	
}
