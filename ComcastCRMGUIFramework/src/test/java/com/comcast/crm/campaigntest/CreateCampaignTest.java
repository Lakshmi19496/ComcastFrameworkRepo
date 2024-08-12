package com.comcast.crm.campaigntest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.pom.CampaignInfoPage;
import com.comcast.crm.pom.CampaignPage;
import com.comcast.crm.pom.CreateNewCampaignPage;
import com.comcast.crm.pom.HomePage;
import com.comcast.crm.pom.LoginPage;

public class CreateCampaignTest extends com.comcast.crm.baseutility.BaseClass{
@Test
	public void createCampaignTest() throws Throwable {
		
		//get data from excel file

		String campName = eLib.getDataFromExcelFile("campaign", 1, 2)+jLib.getRandomNum();

		

		
		HomePage h=new HomePage(driver);
		h.getCampaign(wLib);
		CampaignPage cp=new CampaignPage(driver);
		cp.getCreateCampaignImg().click();
		CreateNewCampaignPage cnc=new CreateNewCampaignPage(driver);
		cnc.createCampaign(campName);
		CampaignInfoPage cip=new CampaignInfoPage(driver);
		String actCamp = cip.getCampInfoHeader().getText();
		if(actCamp.contains(campName))
			System.out.println(campName+" is verified and pass");
		else
			System.out.println(campName+" is not verified and fail");
		
		String actCampName = cip.getCampaignName().getText();
		if(actCampName.trim().equals(campName))
			System.out.println(campName+" is verified and pass");
		else
			System.out.println(campName+" is not verified and fail");
		
		
	}
	

}
