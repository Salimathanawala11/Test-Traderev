package com.UI.common.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.UI.common.pages.*;
import com.UI.framework.base.BasePage;


public class WorkPage  extends BasePage{

	
	private String canadianopp="Canadian Opportunities";
	
	
	public WorkPage(WebDriver driver)
	{

		super(driver);
	}

	public String verifyPage()
	{
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	
	public boolean verifyCanadianOpp()
	{
		
		return driver.findElement(By.partialLinkText(canadianopp)).isDisplayed();
		
		
	}
	
	public void clickCanadianOpp()
	{
		if (waitForElementToAppear((By.partialLinkText(canadianopp))))
		{
		driver.findElement(By.partialLinkText(canadianopp)).click();
		}
		
	}
	
	

}
