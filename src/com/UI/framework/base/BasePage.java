package com.UI.framework.base;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {

	private static final int TIMEOUT = 5;
	private static final int POLLING = 100;

	protected WebDriver driver;
	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);

	}

	protected boolean waitForElementToAppear(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		}
		catch (TimeoutException e) {
			System.out.print(e);
			return false;

		}
		catch (NoSuchElementException e) {
			System.out.print(e);
			return false;
		}
	}

	protected boolean waitForElementToDisappear(By locator) {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			return true;
		}
		catch (Exception e) {
			System.out.print(e);
			return false;

		}

	}
	

	protected boolean waitForTextToDisappear(By locator, String text) {
		try {
			wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
			return true;
		}
		catch (Exception e) {
			System.out.print(e);
			return false;

		}

	}
}
