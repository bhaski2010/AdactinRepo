package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseAdactin.BaseClass;

public class searchHotel extends BaseClass{
	public searchHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="location")
	private WebElement locationdrpdn;
	
	@FindBy(id="hotels")
	private WebElement hotelsdrpdn;
	
	@FindBy(id="room_type")
	private WebElement roomtypedrpdn;
	
	@FindBy(id="room_nos")
	private WebElement numberofroomsdrpdn;
	
	@FindBy(id="datepick_in")
	private WebElement datecheckIn;
	
	@FindBy(id="datepick_out")
	private WebElement datecheckOut;
	
	@FindBy(id="adult_room")
	private WebElement adultsperroomdrpdn;
	
	@FindBy(id="child_room")
	private WebElement childperroomdrpdn;
	
	@FindBy(id="Submit")
	private WebElement searchbtn;
	
	@FindBy(xpath="//input[@id='Submit']/following::input[1]")
	private WebElement resetbtn;
	
	@FindBy(xpath="//input[@id=\"username_show\"]/following::a[1]")
	private WebElement searchhotellink;
	
	@FindBy(xpath="//input[@id=\"username_show\"]/following::a[2]")
	private WebElement bookeditinerarylink;
	
	@FindBy(xpath="//input[@id=\"username_show\"]/following::a[3]")
	private WebElement changepasswordlink;
	
	@FindBy(xpath="//input[@id=\"username_show\"]/following::a[4]")
	private WebElement logoutlink;
	
	@FindBy(xpath="//h4[contains(text(), 'Adactin Hotel Mobile App')]/following::a")
	private WebElement mobileAppDownloadlink;
	
	@FindBy(xpath="//h4[contains(text(), 'HotelApp Web Services ')]/following::a[1]")
	private WebElement hotelwebAppServicelink;
	
	@FindBy(xpath="//h4[contains(text(), 'HotelApp Web Services ')]/following::a[2]")
	private WebElement sampleTClink;

	@FindBy(xpath="//h4[contains(text(), 'HotelApp Web Services ')]/following::a[3]")
	private WebElement knownDefectsDownloadlink;
	
	@FindBy(xpath="//h4[contains(text(), 'HotelApp Web Services ')]/following::a[4]")
	private WebElement aboutAdactinlink;
	
	@FindBy(xpath="(//input[@name='datepick_in']//following::span)[1]")
	private static  WebElement checkInErrorMessage;
	
	
	public String selectLocation(int index) {
		String givenlocation = "";
		drpdwnSelByIndex(locationdrpdn, index);
		givenlocation = locationdrpdn.getAttribute("value");
		return givenlocation;
	}
	
	public void selectHotel(int index) {
		drpdwnSelByIndex(hotelsdrpdn, index);
		}
	
	public void selectRoom(String roomtype) {
		drpdwnSelByvisibleText(roomtypedrpdn, roomtype);
	}
	
	public int selectNumberofRooms(int noofrooms) {
		drpdwnSelByIndex(numberofroomsdrpdn, noofrooms);
		return noofrooms;
	}
	
	public String inputCheckInDate(String date) {
		sendText(datecheckIn, date);
		return date;
	}
	
	public String inputCheckOutDate(String date) {
		sendText(datecheckOut, date);
		return date;
	}
	
	public void selectAdultsPerRoom(int index) {
		drpdwnSelByIndex(adultsperroomdrpdn, index);
	}
	
	public void selectChildPerRoom(int index) {
		drpdwnSelByIndex(childperroomdrpdn, index);
	}
	
	public void clickSearchbtn() {
		clickbtn(searchbtn);
	}
	
	public String selectedRoomNosValue() {
		return numberofroomsdrpdn.getAttribute("value");
	}
	
	public String selectedRoomTypeValue() {
		return roomtypedrpdn.getAttribute("value");
	}
}
