package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUsersPage {
	
	WebDriver driver;
	@FindBy(xpath = "//h1[text()='Admin Users']")
	private WebElement adminHeader_Text;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement new_Button;
	
	@FindBy(xpath = "//h3[contains(text(),'Admin Users Informations')]")
	private WebElement newButtonClick_Text;
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userId_Field;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password_Field;
	
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement UserType_Field;
	
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement save_Button;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement saveSuccess_Message;
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void clickOnNewButton()
	{
		new_Button.click();
	}
	
	public String getNewButtonText()
	{
		return newButtonClick_Text.getText();
	}
	
	public void enterUserName(String userName)
	{
		userId_Field.sendKeys(userName);
	}
	public void enterPassword(String password)
	{
		password_Field.sendKeys(password);
	}
	
	public void enterUserType(String userType)
	{
		UserType_Field.sendKeys(userType);
	}
	
	public void clickOnSaveButton()
	{
		save_Button.click();
	}
	public String getSaveButtonText()
	{
		return  saveSuccess_Message.getText();
	}
	
	public void addNewUser(String userName,String password,String userType)
	{
		enterUserName(userName);
		enterPassword(password);
		enterUserType(userType);
		clickOnSaveButton();
	}
	
	public String getAdminPageHeader()
	{
		return adminHeader_Text.getText() ;
	}
}
