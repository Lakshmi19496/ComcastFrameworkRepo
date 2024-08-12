package com.comcast.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfopage {
	@FindBy(className="dvHeaderText")
	private WebElement contactInfoHeader;
	@FindBy(id="mouseArea_Last Name")
	private WebElement lastname;
	@FindBy(id="mouseArea_Support Start Date")
	private WebElement startDate;
	@FindBy(id="mouseArea_Support End Date")
	private WebElement endDate;
	


	@FindBy(id="mouseArea_Organization Name")
	private WebElement actOrgname;
	
	
	
	public ContactsInfopage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public WebElement getContactInfoHeader() {
		return contactInfoHeader;
	}


	public WebElement getLastname() {
		return lastname;
	}



	public WebElement getStartDate() {
		return startDate;
	}



	public WebElement getEndDate() {
		return endDate;
	}
	public WebElement getActOrgname() {
		return actOrgname;
	}

	
	

}
