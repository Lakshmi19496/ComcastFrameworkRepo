package com.comcast.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadPage {
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	@FindBy(name="company")
	private WebElement companyEdt;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	
	public CreateNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}



	public WebElement getCompanyEdt() {
		return companyEdt;
	}



	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createLead(String lName,String company)
	{
		lastNameEdt.sendKeys(lName);
		companyEdt.sendKeys(company);
		saveBtn.click();
	}
	
	
	
	
	

}
