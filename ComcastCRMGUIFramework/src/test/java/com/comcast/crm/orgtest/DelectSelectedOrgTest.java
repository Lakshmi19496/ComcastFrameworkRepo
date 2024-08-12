package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
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
import com.comcast.crm.pom.CreatingNewOrganizationPage;
import com.comcast.crm.pom.HomePage;
import com.comcast.crm.pom.LoginPage;
import com.comcast.crm.pom.OrganizationInfoPage;
import com.comcast.crm.pom.OrganizationsPage;

public class DelectSelectedOrgTest extends BaseClass {
@Test
	public void deleteSeletedOrgTest() throws Throwable{

		
		//get data from excel file

		String org = eLib.getDataFromExcelFile("org", 1, 2)+jLib.getRandomNum();

		//get common data from property file

		

		//click on organisation
		HomePage h=new HomePage(driver);
		h.getOrgLink().click();

		//create organisation
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrgImg().click();

		CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver);
		cno.createOrg(org);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String headText=oip.getOrgInfoHeader().getText();

		//verify org name in header
		if(headText.contains(org))
			System.out.println(org+" is created sucessfully and pass");
		else
			System.out.println(org+" is not created and fail");
		//verify org in info
		String actorg =oip.getOrgName().getText();
		
		if(actorg.trim().equals(org))
			System.out.println(org+" is verified and pass");
		else 
			System.out.println(org+" is not verified and fail");
		//go back to organizations page
		
		
		h.getOrgLink().click();;
	
		
		
		op.getSearchTxtEdt().sendKeys(org);
		wLib.handlingDropDown(op.getSearchDD(), "Organization Name");
		
		op.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+org+"']/parent::td/parent::tr/td[last()]/a[text()='del']")).click();
		driver.switchTo().alert().accept();
		
		//logout

		
	}

}
