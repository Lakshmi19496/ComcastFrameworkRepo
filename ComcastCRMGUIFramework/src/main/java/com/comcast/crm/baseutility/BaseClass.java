package com.comcast.crm.baseutility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.pom.HomePage;
import com.comcast.crm.pom.LoginPage;

public class BaseClass {
	public DataBaseUtility dLib=new DataBaseUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriver driver=null;
	//public static WebDriver edriver=null;
	public ExcelUtility eLib=new ExcelUtility();
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void confBeforeSuite() throws SQLException
	{
		System.out.println("====connect to db, generate report====");
		dLib.getdbConnection();
		
	}
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void confAfterSuite() throws Throwable
	{
		System.out.println("===disconnect to db, report backup====");
		//dLib.closedbConnection();
		
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
public void configBeforeMethod() throws Throwable {
	System.out.println("==login==");
	LoginPage lp=new LoginPage(driver);
	//String URL = fLib.getDataFromPropertiesFile("url");
	//String username =fLib.getDataFromPropertiesFile("username");
	//String Password = fLib.getDataFromPropertiesFile("password");
	String URL =System.getProperty("url", fLib.getDataFromPropertiesFile("url"));
	String username =System.getProperty("username",fLib.getDataFromPropertiesFile("username"));
	String Password = System.getProperty("password",fLib.getDataFromPropertiesFile("password"));
	lp.getLogin(URL, username, Password);
	
}
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAfterMethod() {
		System.out.println("==logout==");
		HomePage hp=new HomePage(driver);
		hp.setSignOut(wLib);
	}
//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBeforeclass() throws Throwable {
		System.out.println("===launch browser===");
		//String BROWSER=fLib.getDataFromPropertiesFile("Browser");//browser;
		String BROWSER=System.getProperty("browser", fLib.getDataFromPropertiesFile("Browser"));
				//fLib.getDataFromPropertiesFile("Browser");

		if(BROWSER.equals("chrome"))
			driver=new ChromeDriver();
		else if(BROWSER.equals("firefox"))
			driver=new FirefoxDriver();
		else if(BROWSER.equals("edge"))
			driver=new EdgeDriver();
		else {
			driver=new EdgeDriver();}
		
		
		UtilityClassObject.setDriver(driver);
	}
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAfterclass() {
		System.out.println("==close browser===");
		driver.quit();
	}
}
