package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BaseAdactin.BaseClass;
import com.pageobjects.AdactinLoginPage1;
import com.pageobjects.AdactinLoginPage2;
import com.pageobjects.searchHotel;
import com.pageobjects.selectHotelPage;

public class Adactin extends BaseClass{
	
	@BeforeClass
	@Parameters({"url", "broswer"})
	public void browserLaunch(String url, String name) {
		launchChrome();
		launchURL(url);
		Assert.assertSame(driver.getCurrentUrl(), "https://adactinhotelapp.com/");
		AdactinLoginPage1 al1= new AdactinLoginPage1();
		al1.build2();		
	}
		
	// to verify To verify invalid & valid logindetails using DataProvider;
	@Test (dataProvider ="loginData", dataProviderClass = DataProviderDetails.class)
	public void TC101(String unameDP, String passDP) {
		AdactinLoginPage2 al2= new AdactinLoginPage2();
		al2.uninput(unameDP);
		al2.pwinput(passDP);
		al2.lgnclick();		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
	}
	
	//To verify whether the check-out date field accepts a later date than check-in date using DataProvider.		
	@Test (dataProvider = "searchHotelData", dataProviderClass = DataProviderDetails.class)
	public void TC102(int loc, int hotel, String roomtype, int noofroom, String checkIn, String checkout, int adultcount, int childcount) {
	//	AdactinLoginPage2 al2= new AdactinLoginPage2();
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
		searchHotel sh = new searchHotel();
		selectHotelPage sho = new selectHotelPage();
		sh.selectLocation(loc);
		sh.selectHotel(hotel);
		sh.selectRoom(roomtype);
		sh.selectNumberofRooms(noofroom);
		sh.inputCheckInDate(checkIn);
		sh.inputCheckOutDate(checkout);
		sh.selectAdultsPerRoom(adultcount);
		sh.selectChildPerRoom(childcount);
		sh.clickSearchbtn();
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Select Hotel");
		if(driver.getTitle()=="Adactin.com - Select Hotel") 
		WaitClickable(selectHotelPage.cancelbtn, null);
		{
			sho.clickCancel();
		}
	}
	
	//to check if error is displayed when date field is in the past
	@Test()
	public void TC103() {
		searchHotel sh = new searchHotel();
		sh.selectLocation(1);
		sh.selectHotel(1);
		sh.selectRoom("Standard");
		sh.selectNumberofRooms(1);
		sh.inputCheckInDate("18/02/2023");
		sh.inputCheckOutDate("22/02/2023");
		sh.selectAdultsPerRoom(2);
		sh.selectChildPerRoom(1);
		sh.clickSearchbtn();
		WebElement err = driver.findElement(By.xpath("//input[@name='datepick_in']//following::span[1]"));
		String message = err.getText();
		Assert.assertEquals(message, "Check-In Date should be either Today or Later Date");
	}
	
	//To verify whether locations in Select Hotel page are displayed according to the location selected in Search Hotel
	@Test
	public void TC104() {
		searchHotel sh = new searchHotel();
		String givenlocation = sh.selectLocation(1);
		sh.selectHotel(1);
		sh.selectRoom("Standard");
		sh.selectNumberofRooms(1);
		sh.inputCheckInDate("24/02/2024");
		sh.inputCheckOutDate("25/02/2024");
		sh.selectAdultsPerRoom(2);
		sh.selectChildPerRoom(1);
		sh.clickSearchbtn();
		WebElement locselected = driver.findElement(By.id("location_0"));
		String actloc = getAttributeValue(locselected, "value");
		Assert.assertEquals(actloc, givenlocation);
	}
	
	//To verify date and Check Out date are being displayed in Select Hotel Page according to the dates selected in search Hotel.
	@Test
	public void TC105() {
		selectHotelPage sho = new selectHotelPage();
		sho.clickCancel();
		searchHotel sh = new searchHotel();
		sh.selectLocation(1);
		sh.selectHotel(1);
		sh.selectRoom("Standard");
		sh.selectNumberofRooms(1);
		String checkinDate = sh.inputCheckInDate("24/02/2024");
		String checkoutDate = sh.inputCheckOutDate("25/02/2024");
		sh.selectAdultsPerRoom(2);
		sh.selectChildPerRoom(1);
		sh.clickSearchbtn();
		WebElement indateact = driver.findElement(By.id("arr_date_0"));
		WebElement outdateact = driver.findElement(By.id("dep_date_0"));
		String DateIn = getAttributeValue(indateact, "value");
		String DateOut = getAttributeValue(outdateact, "value");
		Assert.assertEquals(DateIn, checkinDate);
		Assert.assertEquals(DateOut, checkoutDate);
	}
	
	//To verify whether no. of rooms entry in Select Hotel page is same as the Number of rooms selected in search hotel page
	@Test
	public void TC106() {
		selectHotelPage sho = new selectHotelPage();
		sho.clickCancel();
		searchHotel sh = new searchHotel();
		sh.selectLocation(1);
		sh.selectHotel(1);
		sh.selectRoom("Standard");
		sh.selectNumberofRooms(3);
		String exptdroomcount = sh.selectedRoomNosValue();
		sh.inputCheckInDate("24/02/2024");
		sh.inputCheckOutDate("25/02/2024");
		sh.selectAdultsPerRoom(4);
//		sh.selectChildPerRoom(1);
		sh.clickSearchbtn();
		WebElement noofroom = driver.findElement(By.id("rooms_0"));
		String actroomcount = noofroom.getAttribute("value");	
		Assert.assertTrue(actroomcount.contains(exptdroomcount));
	}
	
	//To verify whether Room Type in Select Hotel page is same as Room type selected in search hotel page
	@Test
	public void TC107() {
		selectHotelPage sho = new selectHotelPage();
		sho.clickCancel();
		searchHotel sh = new searchHotel();
		sh.selectLocation(1);
		sh.selectHotel(1);
		sh.selectRoom("Deluxe");
		String selectedRoomValue = sh.selectedRoomTypeValue(); 
		sh.selectNumberofRooms(1);
		sh.inputCheckInDate("24/02/2024");
		sh.inputCheckOutDate("25/02/2024");
		sh.selectAdultsPerRoom(1);
//		sh.selectChildPerRoom(1);
		sh.clickSearchbtn();
		WebElement roomType = driver.findElement(By.id("room_type_0"));
		String typeofRoom = roomType.getAttribute("value");
		Assert.assertEquals(typeofRoom, selectedRoomValue, "The room type displayed is matching with the selected hotel");
	}
	
	@AfterClass
	public void closeBrowser() {
		browserClose();
	}
}
