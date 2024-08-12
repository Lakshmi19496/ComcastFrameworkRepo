package com.comcast.crm.orgtest;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

import com.comcast.crm.pom.HomePage;
import com.comcast.crm.pom.LoginPage;
import com.comcast.crm.pom.OrganizationsPage;

public class PrintOrgListTest extends BaseClass{
@Test
	public void printOrgListTest() throws Throwable{
		

		//get data from excel file

		String org = eLib.getDataFromExcelFile("org", 1, 2)+jLib.getRandomNum();

		//get common data from property file


		//click on organisation
		HomePage h=new HomePage(driver);
		h.getOrgLink().click();
		
		
		OrganizationsPage op=new OrganizationsPage(driver);
		
		List<WebElement> orgList = op.getOrgList();
		
		for(WebElement ele:orgList)
		{
			String text = ele.getText();
			System.out.println(text);
		}
		
		
	}

}
