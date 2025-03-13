package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage {

	WebDriver driver;
	Properties properties = new Properties();

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userName_Field;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password_Field;
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement sigIn_Button;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {

			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public void enterUserName(String userName)
	{
		userName_Field.sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		password_Field.sendKeys(password);
	}
	
	public void clickOnSignInButton()
	{
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.waitForClickable(sigIn_Button,30);
		sigIn_Button.click();
	}
	
	public HomePage logIn(String userName,String password)
	{
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
		return new HomePage(driver);
	}
		
	public HomePage logIn()
	{
		String userName=properties.getProperty("username");
		String password=properties.getProperty("password");
		logIn(userName, password);
		return new HomePage(driver);
	}
}
