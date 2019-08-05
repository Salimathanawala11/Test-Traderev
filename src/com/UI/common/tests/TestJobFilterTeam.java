package com.UI.common.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.UI.common.pages.HomePage;
import com.UI.common.pages.JobsPage;
import com.UI.framework.base.BaseTest;


public class TestJobFilterTeam extends BaseTest {

private static JobsPage jobpage;
	

	@BeforeMethod
	public void Initialise()
	{
		driver.get("https://jobs.lever.co/traderev");
		maximisePage();
		Log.info("Initialise " + getClass());
		jobpage=new JobsPage(driver);
		
	}
	
	@Test
	public void testCareerPage()throws InterruptedException   {

		Assert.assertTrue( jobpage.verifyPage().contains("TradeRev"));
		Log.info("Verify Job Filter page");
		int tot_jobs=jobpage.getTotalJobPosts();
		System.out.println(tot_jobs);
		jobpage.selectCity("Toronto, Ontario, Canada");
		Log.info("City Selected");
		jobpage.selectTeam("Engineering");
		Log.info("Team Selected");
		System.out.println(jobpage.getTotalJobPosts());
		Assert.assertTrue(jobpage.getTotalJobPosts()<=tot_jobs);
		Log.info("Total job Posts:: "+ jobpage.getTotalJobPosts());
		
	}
}
