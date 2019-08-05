package com.UI.common.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.UI.common.pages.*;
import com.UI.framework.base.BasePage;


public class JobsPage  extends BasePage{

	private String team="(//div[@class='filter-popup'])[2]//a";
	private String worktype="(//div[@class='filter-popup'])[3]//a";
	private String title="a.posting-title";

	private String city="(//div[@class='filter-popup'])[1]//a";
	
	public JobsPage(WebDriver driver)
	{

		super(driver);
	}

	public String verifyPage()
	{
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	
	public void selectCity(String cityname)
	{
		WebElement citylink=driver.findElement(By.xpath(city+"[contains(text(),'"+cityname+"')]"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", citylink );
		
	}
	
	public void selectTeam(String teamdata)
	{
		
		WebElement teamlink=driver.findElement(By.xpath(team+"[contains(text(),'"+teamdata+"')]"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", teamlink );
		
	}
	
	
	
	public int getTotalJobPosts()
	{
		List<WebElement> list=driver.findElements(By.cssSelector(title));
		//list.
		//System.out.println(list.size());
		return list.size();
		
	}
	  

}
