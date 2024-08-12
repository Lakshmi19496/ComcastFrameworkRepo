package com.comcast.crm.pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewContactPage {
	WebDriver driver=null;
 	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	@FindBy(id="jscal_field_support_start_date")
	private WebElement startDateEdt;
	@FindBy(id="jscal_field_support_end_date")
	private WebElement endDateEdt;
	


	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img")
	private WebElement addOrgBtn;
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBtn;
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchtxtBox;
	
	
	
	public CreateNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}


	public WebElement getStartDateEdt() {
		return startDateEdt;
	}


	public WebElement getEndDateEdt() {
		return endDateEdt;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getAddOrgBtn() {
		return addOrgBtn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public WebElement getSearchtxtBox() {
		return searchtxtBox;
	}
	//bussiness libraries
	public void createContact(String lName)
	{
		lastNameEdt.sendKeys(lName);
		saveBtn.click();
	}
	public void createContact(String lName,String startDate,String endDate)
	{
		lastNameEdt.sendKeys(lName);
		startDateEdt.clear();
		startDateEdt.sendKeys(startDate);
		endDateEdt.clear();
		endDateEdt.sendKeys(endDate);
		saveBtn.click();
	}
	public void createContacts(String lName,String org) throws InterruptedException
	{
		lastNameEdt.sendKeys(lName);
		getAddOrgBtn().click();
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> i1=set1.iterator();
		//WebDriverUtility wLib=new WebDriverUtility();
		//wLib.switchToWindowByURL(driver, "Accounts&action");
		String pwh=i1.next();  String cwh=i1.next();
		driver.switchTo().window(cwh);
		//	
		searchtxtBox.sendKeys(org);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+org+"']")).click();

		driver.switchTo().window(pwh);
		//wLib.switchToWindowByURL(driver, "Contacts&action");
		getSaveBtn().click();
		
	}
	
	
	
	
	

}
