package com.comcast.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	@FindBy(className="dvHeaderText")
	private WebElement orgInfoHeader;
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgName;
	@FindBy(id="mouseArea_Type")
	private WebElement typeName;
	@FindBy(id="mouseArea_Industry")
	private WebElement industryName;
	@FindBy(id="dtlview_Phone")
	private WebElement phone;
	



	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getOrgInfoHeader() {
		return orgInfoHeader;
	}
	public WebElement getOrgName() {
		return orgName;
	}
	public WebElement getTypeName() {
		return typeName;
	}
	public WebElement getIndustryName() {
		return industryName;
	}
	public WebElement getPhone() {
		return phone;
	}
	
	
	
	

}
