package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.BaseAdactin.BaseClass;
import com.pageobjects.AdactinLoginPage1;
import com.pageobjects.AdactinLoginPage2;
import com.pageobjects.searchHotel;



public class DummyClasstoValidateBaseClass extends BaseClass {
	
	public static void main(String[] args) {
		
//		readingFromExcel("Test_Data", "Adactin", 3, 1);
		launchChrome();
		launchURL("https://adactinhotelapp.com/");
		AdactinLoginPage1 al1= new AdactinLoginPage1();
		AdactinLoginPage2 al2= new AdactinLoginPage2();
		al1.build2();
		al2.uninput("bhaski2010");
		al2.pwinput("Bh@ski89");
		al2.lgnclick();
//		searchHotel sh = new searchHotel();
//		sh.selectLocation(1);
//		sh.selectHotel(1);
//		sh.selectRoom("Standard");
//		sh.selectNumberofRooms(1);
//		sh.inputCheckInDate("24/02/2023");
//		sh.inputCheckOutDate("25/02/2023");
//		sh.selectAdultsPerRoom(2);
//		sh.selectChildPerRoom(1);
//		sh.clickSearchbtn();
//		selectHotelPage selh = new selectHotelPage();
//		selh.selectedlocaition();
//		WebElement selectedhotel = driver.findElement(By.id("location_0"));	
//		String valattri = selectedhotel.getAttribute("value");
//		System.out.println(valattri);
		
//		WebElement err = driver.findElement(By.xpath("//input[@name='datepick_in']//following::span[1]"));
//		String message = err.getText();
//		System.out.println(message);
		
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
		String loc = getAttributeValue(locselected, "value");
		System.out.println(loc);
		System.out.println(givenlocation);
		
	}

}
