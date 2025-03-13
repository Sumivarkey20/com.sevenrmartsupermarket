package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	WebDriver driver;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement new_Button;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement search_Button;
	
	@FindBy(xpath = "//input[@placeholder='Category']")
	private WebElement categoryText_Element;
	
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement categoryTextSearch_Button;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[3]")
	private WebElement categoryTextStatus_Element;
	
	@FindBy(xpath = "//h3[contains(text(),'Enter Category Informations')]")
	private WebElement newButtonClick_Text;
	
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFile_Element;
	
	public CategoryPage(WebDriver driver)
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
	
	public String verifySearchButtonFunction(String text)
	{
		search_Button.click();
		categoryText_Element.sendKeys(text + Keys.ENTER);
		return categoryText_Element.getAttribute("value");
	}
	
	public void categoryTextSearchClick()
	{
		categoryTextSearch_Button.click();
	}
	
	public String getCategoryTextStatus(String status)
	{
		return categoryTextStatus_Element.getText();
	}

}
