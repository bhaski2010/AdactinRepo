package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseAdactin.BaseClass;

public class selectHotelPage extends BaseClass{
	
	public selectHotelPage() {
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id="radiobutton_0")
	private WebElement selecthotelradiobtn;
	
	@FindBy(id="hotel_name_0")
	private WebElement hotelname;
	
	@FindBy(id="location_0")
	private WebElement location;

	@FindBy(id="cancel")
	public static	WebElement cancelbtn;

	public void selectHotelRadioBtn( ) {
		clickbtn(selecthotelradiobtn);
	}
	
	public String selectedlocation() {
		String selectedloc = "";
		selectedloc = getAttributeValue(location, "value");
		return selectedloc;
	}
	
	public void selectedHotelName() {
		getAttributeValue(hotelname, "Value");
	}
	
	public void clickCancel() {
		clickbtn(cancelbtn);
	}
	

}
