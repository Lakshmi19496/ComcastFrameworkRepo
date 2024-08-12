package com.comcast.crm.leadsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.pom.CreateNewLeadPage;
import com.comcast.crm.pom.HomePage;
import com.comcast.crm.pom.LeadsInfoPage;
import com.comcast.crm.pom.LeadsPage;
import com.comcast.crm.pom.LoginPage;

public class CreateLeadTest extends BaseClass {
@Test
	public void createLeadTest() throws Throwable {
		
		//get data from excel file

		String lastName = eLib.getDataFromExcelFile("leads", 1, 2)+jLib.getRandomNum();
		String company = eLib.getDataFromExcelFile("leads",1, 3)+jLib.getRandomNum();

		//get common data from property file

	
		//click on organisation
		HomePage h=new HomePage(driver);
		h.getLeadsLink().click();
		
		LeadsPage lp=new LeadsPage(driver);
		lp.getCreateLeadImg().click();
		
		CreateNewLeadPage cnl=new CreateNewLeadPage(driver);
		cnl.createLead(lastName, company);
		LeadsInfoPage lip=new LeadsInfoPage(driver);
		String actLead = lip.getLastName().getText();
		String actCompany = lip.getCompanyName().getText();
		String leadHeader = lip.getLeadsHeader().getText();
		//header validation
		if(leadHeader.contains(lastName))
			System.out.println(lastName+" is verified & pass");
		else
			System.out.println(lastName+" is not verified and fail");
		//lastname validation
		if(actLead.equals(lastName))
			System.out.println(lastName+" is verified & pass");
		else
			System.out.println(lastName+" is not verified asnd fail");
		
		//company validation
		if(actLead.equals(lastName))
			System.out.println(lastName+" is verified & pass");
		else
			System.out.println(lastName+" is not verified and fail");
		
		
		

	}

}
