package com.sevenrmartsupermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.constants.Constants;

public class PageUtility {

	WebDriver driver;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	public void selectByIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	public void scrollAndClick(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("arguments[0].click();", element);
	}
	
	public void uploadImage(WebElement element, String imageName)
	{
		element.sendKeys(Constants.IMAGE_FILE_PATH+imageName+".jpg");
	}

}
