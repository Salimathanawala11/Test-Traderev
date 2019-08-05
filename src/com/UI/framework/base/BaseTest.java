package com.UI.framework.base;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;



public class BaseTest {
	protected static WebDriver driver;
	protected static Logger Log = Logger.getLogger(Logger.class.getName());
	@BeforeClass
	public void setUp() throws MalformedURLException,InterruptedException{
		  try {
			  DOMConfigurator.configure("log4j.xml");
			  Log.info("Webdriver instantiated");
			  System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
			  driver =new ChromeDriver();
			  Log.info("implicitly Wait");
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  
			  
		  }
		  catch (Exception ex)
		  {
			  Log.info(ex);
		  }
	}
	
	protected void maximisePage()
	{
		driver.manage().window().maximize();
	}
	
	protected void closeWindow()
	{
		driver.close();
	}



	@AfterClass
	public void teardown(){
		if(null != driver) {
          driver.close();
           driver.quit();
        }
		Log.info("teardown");
	}
	

}
