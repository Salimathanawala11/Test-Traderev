package com.UI.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.UI.common.pages.*;
import com.UI.framework.base.BasePage;


public class HomePage  extends BasePage{
	
//	
	private String career_link="Careers";

	public HomePage(WebDriver driver)
	{

		super(driver);
	}

	public String verifyPage()
	{
		//System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	
	public void clickCareerLink()
	{
		if (waitForElementToAppear((By.partialLinkText(career_link))))
		{
		driver.findElement(By.partialLinkText(career_link)).click();
		}
	}
	  

}
