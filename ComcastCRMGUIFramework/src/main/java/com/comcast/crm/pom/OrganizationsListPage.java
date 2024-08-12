package com.comcast.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsListPage {
	@FindBy(id="search_txt")
	private WebElement searchBtn;
	@FindBy(name="search")
	private WebElement searchtxtBox;
	
	
	public OrganizationsListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public WebElement getSearchtxtBox() {
		return searchtxtBox;
	}
	
	
	
	


}
