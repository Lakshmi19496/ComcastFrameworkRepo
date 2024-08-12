package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.pom.CreatingNewOrganizationPage;
import com.comcast.crm.pom.HomePage;
import com.comcast.crm.pom.LoginPage;
import com.comcast.crm.pom.OrganizationInfoPage;
import com.comcast.crm.pom.OrganizationsPage;
/**
 * Crrate organisation test case
 * 
 */
@Listeners(com.comcast.crm.listenerutility.ListenerImplementation.class)
public class CreateOrganisationTest extends BaseClass {
@Test(groups = "smokeTest")
	public void createOrgTest() throws Throwable {
	
		//get data from excel file
	UtilityClassObject.getTest().log(Status.INFO, "get data from excel file");

		String org = eLib.getDataFromExcelFile("org", 1, 2)+jLib.getRandomNum();

		//get common data from property file

		

		//click on organisation
		UtilityClassObject.getTest().log(Status.INFO, "click on organisation");
		HomePage h=new HomePage(driver);
		h.getOrgLink().click();

		//create organisation
		UtilityClassObject.getTest().log(Status.INFO, "create organisation");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrgImg().click();

		CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver);
		cno.createOrg(org);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String headText=oip.getOrgInfoHeader().getText();

	//verify org name in header
		UtilityClassObject.getTest().log(Status.INFO, "verify org name in header");
		SoftAssert soft=new SoftAssert();
		
		boolean status = headText.contains(org);
		soft.assertTrue(status);
		
		//verify org in info
		UtilityClassObject.getTest().log(Status.INFO, "verify org in info");
		String actorg =oip.getOrgName().getText();
		soft.assertEquals(actorg.trim(), org);
		soft.assertAll();
		//logout

	}
@Test(groups = "regressionTest")
public void createOrgWithIndAndType() throws Throwable {

	//get data from excel file

	String org = eLib.getDataFromExcelFile("org", 1, 2)+jLib.getRandomNum();
	String industry= eLib.getDataFromExcelFile("org", 4, 4);
	String type= eLib.getDataFromExcelFile("org", 4, 5);

	//get common data from property file


	//click on organisation
	HomePage h=new HomePage(driver);
	h.getOrgLink().click();

	//create organisation
	OrganizationsPage op=new OrganizationsPage(driver);
	op.getCreateOrgImg().click();

	CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver);
	cno.createOrg(org, industry, type, wLib);

	OrganizationInfoPage oip=new OrganizationInfoPage(driver);

	String actIndustry = oip.getIndustryName().getText();
	String actType = oip.getTypeName().getText();
	//verify industry 
	SoftAssert soft=new SoftAssert();
	soft.assertEquals(actType, type);

	//verify type
soft.assertEquals(actIndustry, industry);
	soft.assertAll();


}
@Test(groups = "regressionTest")
public void createOrgWithPhone() throws Throwable {
	
	
	//get data from excel file
	
	String org = eLib.getDataFromExcelFile("org", 1, 2)+jLib.getRandomNum();
	String phone = eLib.getDataFromExcelFile("org", 7, 4);
	
	//get common data from property file

	
	//click on organisation
	HomePage h=new HomePage(driver);
	h.getOrgLink().click();
	//create organisation
	OrganizationsPage op=new OrganizationsPage(driver);
	op.getCreateOrgImg().click();

	CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver);
	cno.createOrg(org, phone);
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	
	String actPhone = oip.getPhone().getText();
	
	//verify phone
	SoftAssert soft=new SoftAssert();
	soft.assertEquals(actPhone, phone);
	soft.assertAll();
	
	//logout

}


}
