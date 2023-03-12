package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseAdactin.BaseClass;


public class AdactinLoginPage2 extends BaseClass{
	
	public AdactinLoginPage2() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="username")
	private WebElement loginname;
	
	@FindBy (id="password")
	private WebElement pwd;
	
	@FindBy(id="login")
	private WebElement lgnbtn;
	
	@FindBy(xpath="//div[@class='login_forgot']/child::a")
	private WebElement forgotpw;
	
	@FindBy(xpath="//td[@class='login_register']/child::a")
	private WebElement registerhere;
	
	@FindBy(xpath = "//strong[text()='Go to Build 1']")
	private WebElement gotobuild1;
	
	@FindBy(xpath="//a[contains(text(), 'info@adactin.com')]")
	private WebElement infoemail;
	
	public void build1() {
		clickbtn(gotobuild1);
	}
	
	public void uninput(String text1) {
		sendText(loginname, text1);
	}
	
	public void pwinput(String text2) {
		sendText(pwd, text2);
	}
	
	public void lgnclick() {
		clickbtn(lgnbtn);
	}
	
	public void forgotpw() {
		clickbtn(forgotpw);
	}
	
	public void regisHere() {
		clickbtn(registerhere);
	}
	
	public void sendeMail() {
		clickbtn(infoemail);
	}

}
