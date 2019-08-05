package com.UI.common.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.UI.common.pages.*;
import com.UI.framework.base.BaseTest;


public class TestJobFilter extends BaseTest {

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
	public void testJobFilter()throws InterruptedException   {

		//System.out.print(jobpage.verifyPage());
		Assert.assertTrue( jobpage.verifyPage().contains("TradeRev"));
		Log.info("Verify Job Filter page");
		int tot_jobs=jobpage.getTotalJobPosts();
		System.out.println(tot_jobs);
		jobpage.selectCity("Toronto, Ontario, Canada");
		Log.info("Select City");
		System.out.println(jobpage.getTotalJobPosts());
		Assert.assertTrue(jobpage.getTotalJobPosts()<=tot_jobs);
		Log.info("Total job Posts:: "+ jobpage.getTotalJobPosts());

		
		
	}
}
