package com.comcast.crm.contacttest;

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
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.pom.ContactsInfopage;
import com.comcast.crm.pom.ContactsPage;
import com.comcast.crm.pom.CreateNewContactPage;
import com.comcast.crm.pom.CreatingNewOrganizationPage;
import com.comcast.crm.pom.HomePage;
import com.comcast.crm.pom.LoginPage;
import com.comcast.crm.pom.OrganizationInfoPage;
import com.comcast.crm.pom.OrganizationsPage;

public class CreateContactTest extends com.comcast.crm.baseutility.BaseClass {
	@Test(groups="smokeTest")
	public void createContactTest() throws Throwable  {
		

		String lastName = eLib.getDataFromExcelFile("contact", 1, 2)+jLib.getRandomNum();

		//get common data from property file

		//click on organisation
		HomePage h=new HomePage(driver);
		h.getContactLink().click();

		//create contact
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactImg().click();
		CreateNewContactPage cnc=new CreateNewContactPage(driver);
		cnc.createContact(lastName);

		//verify header of contacts
		ContactsInfopage cip=new ContactsInfopage(driver);

		String headCon =cip.getContactInfoHeader().getText();
		SoftAssert soft=new SoftAssert();
		boolean status = headCon.contains(lastName);
		soft.assertTrue(status);
		
		//verify last name

		String actLastName = cip.getLastname().getText();
		
		soft.assertEquals(actLastName.trim(), lastName);
		soft.assertAll();
		//logout



	}
	@Test(groups = "regressionTest")
	public void createContactWithOrg() throws Throwable {
		//get data from excel file
		String org = eLib.getDataFromExcelFile("contact", 7, 2)+jLib.getRandomNum();
		String lastName = eLib.getDataFromExcelFile("contact", 7, 3)+jLib.getRandomNum();
		//get common data from property file


		//click on organisation
		HomePage h=new HomePage(driver);
		h.getOrgLink().click();


		//create organisation
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrgImg().click();

		CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver);
		cno.createOrg(org);


		//verify org in info
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);

		String actorg = oip.getOrgName().getText();
		if(actorg.trim().equals(org))
			System.out.println(org+" is verified and pass");
		else 
			System.out.println(org+" is not verified and fail");
		h.getContactLink().click();
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactImg().click();
		CreateNewContactPage cnc=new CreateNewContactPage(driver);

		cnc.createContacts(lastName, org);

		//verify last name
		ContactsInfopage cip =new ContactsInfopage(driver);


		String actlastName = cip.getLastname().getText();
		if(lastName.equals(actlastName.trim()))
			System.out.println(lastName+" is verified and pass");
		else
			System.out.println(lastName+" is not verified and fail");

		//verify organisation
		String actOrg =cip.getActOrgname().getText();
		if(actOrg.trim().equals(org))
			System.out.println(org+" is verified and pass");
		else
			System.out.println(org+" is not verified and fail");
		//logout




	}
	@Test(groups = "regressionTest")
	public void createContactSupportDateTest() throws Throwable {

		//get data from excel file

		String lastName = eLib.getDataFromExcelFile("contact", 4, 2)+jLib.getRandomNum();
		//date

		String startDate = jLib.getSystemDateYYYYMMDD();


		String endDate = jLib.getRequiredDateYYYYMMDD(30);


		//get common data from property file

		//click on organisation
		HomePage h=new HomePage(driver);
		h.getContactLink().click();

		//create contact
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactImg().click();

		CreateNewContactPage cnc=new CreateNewContactPage(driver);
		cnc.createContact(lastName, startDate, endDate);



		//verify header of contacts
		ContactsInfopage cip=new ContactsInfopage(driver);

		String actStartDate = cip.getStartDate().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actStartDate.trim(), startDate);
	
		//verify last name

		String actEndDate =cip.getEndDate().getText();
		
		soft.assertEquals(actEndDate.trim(), endDate);
	soft.assertAll();
		//logout
		

	}



}
