package com.comcast.crm.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {


	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgImg;

	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[3]/a")
	private List<WebElement>  orgList;
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[1]")
	private WebElement checkBoxToDel;
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteBtn;
	@FindBy(name="search_text")
	private WebElement searchTxtEdt;
	@FindBy(name="submit")
	private WebElement searchBtn;
	@FindAll({@FindBy(id="bas_searchfield"),@FindBy(name="search_field")})
	private WebElement searchDD;
	
	
	

	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	public WebElement getSearchTxtEdt() {
		return searchTxtEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}

	public List<WebElement> getOrgList() {
		return orgList;
	}
	public WebElement getCheckBoxToDel() {
		return checkBoxToDel;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}



	}
