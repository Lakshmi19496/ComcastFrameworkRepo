package com.comcast.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewOrganizationPage {

	
		@FindBy(name="accountname")
		private WebElement orgNameEdt;
		@FindBy(id="phone")
		private WebElement phoneEdt;
		@FindBy(name="accounttype")
		private WebElement typeDropdown;
		@FindBy(name="industry")
		private WebElement industryDropDown;
		
		@FindBy(className="crmbutton")
		private WebElement saveBtn;
		public CreatingNewOrganizationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		public WebElement getOrgNameEdt() {
			return orgNameEdt;
		}
		public WebElement getPhoneEdt() {
			return phoneEdt;
		}
		public WebElement getTypeDropdown() {
			return typeDropdown;
		}
		public WebElement getIndustryDropDown() {
			return industryDropDown;
		}
		public WebElement getSaveBtn() {
			return saveBtn;
		}
		public void createOrg(String org)
		{
			orgNameEdt.sendKeys(org);
			saveBtn.click();
		}
		public void createOrg(String org,String industry,String type,WebDriverUtility wLib) {
		orgNameEdt.sendKeys(org);
		wLib.dropDown(industryDropDown).selectByVisibleText(industry);
		wLib.dropDown(typeDropdown).selectByVisibleText(type);
			
			saveBtn.click();
		}
		public void createOrg(String org,String phone)
		{
			orgNameEdt.sendKeys(org);
			phoneEdt.sendKeys(phone);
			saveBtn.click();
		}
		
		
		
		

	

}
