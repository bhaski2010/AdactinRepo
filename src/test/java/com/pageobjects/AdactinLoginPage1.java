package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseAdactin.BaseClass;


public class AdactinLoginPage1 extends BaseClass{
	
	public AdactinLoginPage1() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement uname;
	
	@FindBy(name="password")
	private WebElement pw;
	
	@FindBy(id="login")
	private WebElement lgnbtn;
	
	@FindBy(xpath="//div[@class='login_forgot']/child::a")
	private WebElement forgotpw;
	
	@FindBy(xpath="//td[@class=\"login_register\"]/child::a")
	private WebElement registerhere;
	
	@FindBy(xpath="//strong[text() = 'Go to Build 2 ']")
	private WebElement gotobuild2;
	
	public void build2() {
		clickbtn(gotobuild2);	
	}
	

}
