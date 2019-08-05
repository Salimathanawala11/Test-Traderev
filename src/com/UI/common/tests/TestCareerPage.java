package com.UI.common.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.UI.common.pages.HomePage;
import com.UI.common.pages.JobsPage;
import com.UI.common.pages.WorkPage;
import com.UI.framework.base.BaseTest;


public class TestCareerPage extends BaseTest {

	private static HomePage homepage;
	private static WorkPage workpage;
	private static JobsPage jobpage;
	List<String> handlesList ;

	@BeforeMethod
	public void Initialise()
	{
		driver.get("https://www.traderev.com/en-ca/");
		
		Log.info("Initialise " + getClass());
		homepage=new HomePage(driver);
		workpage=new WorkPage(driver);
		jobpage=new JobsPage(driver);

	}

	@Test
	public void testCareerPage()throws InterruptedException   {

		Assert.assertTrue( homepage.verifyPage().contains(" Revolutionizing Automotive Sales"));
		Log.info("Verify home page");
		homepage.clickCareerLink();
		Log.info("home page : career link");

		handlesList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(handlesList.get(0));
		Log.info("closed Window "+  handlesList.get(0));
		closeWindow();
		driver.switchTo().window(handlesList.get(1));
		Log.info("New Window "+  handlesList.get(1));

		maximisePage();
		Assert.assertTrue(workpage.verifyCanadianOpp());
		Log.info("Work Page : verify work page");
		workpage.clickCanadianOpp();
		handlesList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(handlesList.get(0));
		Log.info("closed Window "+  handlesList.get(0));
		closeWindow();
		driver.switchTo().window(handlesList.get(1));
		Log.info("New Window "+  handlesList.get(1));
		
		maximisePage();
		Assert.assertTrue( jobpage.verifyPage().contains("TradeRev"));
		Log.info("Job Page : Verify Job Filter page");


	}
}
