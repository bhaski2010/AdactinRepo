package com.tests;

import org.testng.annotations.DataProvider;

public class DataProviderDetails {
	@DataProvider (name = "loginData")
	private Object [] [] getData1(){
		return new Object [] [] {
			{"bh@ski2010", "Mah!mads"},
			{"bh@ski2010", "sSUhamads"},
			{"BHAS2010", "!@#$%^&*()"},
			{"buskoi1020,", "jvasd"},
			{"Bhaski2010", "Bhaski89"},
			{"hbaski2010", "Bh@ski89"},
			{"Bhaski2010", "Bh@ski89"}
		};
	}
	
	@DataProvider (name = "searchHotelData")
	private Object [] [] getData2() {
		return new Object[] [] {
			{1, 1, "Standard", 1, "02/03/2023", "01/03/2023", 1, 1},
			{2, 2, "Double", 2, "02/04/2023", "02/03/2023", 2, 2},
			{3, 3, "Deluxe", 3, "01/04/2023", "04/03/2023", 3, 3},
			{4, 4, "Super Deluxe", 4, "01/02/2023", "04/02/2023", 4, 4},
			{5, 1, "Standard", 5, "01/04/2022", "04/04/2022", 1, 1},
			{6, 2, "Double", 6, "01/04/2029", "04/04/2028", 2, 2},
			{7, 3, "Deluxe", 7, "-02/04/2023", "03/04/2023", 3, 3},
			{8, 4, "Super Deluxe", 8, "00/00/2028", "00/00/2029", 4, 4},
			{1, 4, "Standard", 9, "00/04/0000", "00/04/0000", 3, 3},
			{2, 3, "Double", 10, "-01/04/2028", "04/04/2029", 2, 2},
		};
	}
}
