package com.comcast.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInfoPage {
	@FindBy(className="dvHeaderText")
	private WebElement leadsHeader;
	@FindBy(id="dtlview_Last Name")
	private WebElement lastName;
	@FindBy(id="dtlview_Company")
	private WebElement companyName;
	@FindBy(linkText="Convert Lead")
	private WebElement convertLeadLink;
	
	
	
	public LeadsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public WebElement getLeadsHeader() {
		return leadsHeader;
	}



	public WebElement getLastName() {
		return lastName;
	}



	public WebElement getCompanyName() {
		return companyName;
	}



	public WebElement getConvertLeadLink() {
		return convertLeadLink;
	}
	
	
	
	
	
	

}
