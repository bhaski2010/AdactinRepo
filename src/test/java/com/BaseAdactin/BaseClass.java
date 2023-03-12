package com.BaseAdactin;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static JavascriptExecutor js = (JavascriptExecutor)driver;
	
	// this is a method to launch the Chrome browser
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	}
	
	// this is a method to launch the firefox browser
	public static void launchFirefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		}

	// this is a method to launch the Edge browser
	public static void launchEdge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	}

	// this is a method to click a link/button
	public static void clickbtn(WebElement refName) {
		refName.isDisplayed();
		refName.isEnabled();
		refName.click();
	}
	// this is a method to send an input text to input field
	public static void sendText(WebElement refName, String text) {
		refName.clear();
		refName.sendKeys(text);
	}

	// this is a method to launch the webpage
	public static void launchURL(String url) {
		driver.get(url);
	}
	
	// this is a method to het the Title of the WebPage
	public static void getWebPageTitle() {
		String currentpagetitle = driver.getTitle();
		System.out.println(currentpagetitle);
	}
	
	// this is a method to get the URL info of the WebPage which is opened
	public static void getPageURL() {
		String currentpageurl = driver.getCurrentUrl();
		System.out.println(currentpageurl);
	}
	
	// this is a method to get the text available on page
	public static String getpageText(WebElement refName) {
		return refName.getText();
	}
	
	// this is a method to get the value of given attribute
	public static String getAttributeValue(WebElement refName, String att) {
		 return refName.getAttribute(att);
		
	}
	
	// this is a method to accept the alert
	public static void alertAccept() {
		driver.switchTo().alert().accept();
	}
	
	// this is a method to dismiss the alert
	public static void alertDismiss() {
		driver.switchTo().alert().dismiss();
	}
	
	// this is a method to send text to the input field available in the alert
	public static void alertInput(String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	
	// this is a method to get the text available in the alert
	public static void getAlertText() {
		driver.switchTo().alert().getText();
	}
	
	// this is a method to send text to input field using javascript
	public static void javascriptinput(String text, WebElement refName) {
		refName.clear();
		js.executeScript("arguments.setAttribute('value', '" + text + "')", refName);
	}
	
	// this is a method to click a link or button using javascript
	public static void javascriptclick(WebElement refName) {
		refName.isDisplayed();
		refName.isEnabled();
		js.executeAsyncScript("arguments[0].click", refName);
	}
	
	// this is a method to get the value of given attribute using javascript
	public static void javascriptgetattri(WebElement refName) {
		Object attvalue = js.executeScript("arguments.getAttribute('value')", refName);
		System.out.println(attvalue);
	}

	// this is a method to scrolldown
	public static void scrollDownview(WebElement refName) {
//		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", refName);
	}

	// this is a method to scrollup
	public static void scrollUpview(WebElement refName) {
//		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", refName);
	}
	
	// this is a method to switch to frame based on ID
	public static void switchFrameID(String id) {
		driver.switchTo().frame(id);
	}
	
	// this is a method to switch to frame based on name attribute
	public static void swicthFrameName(String name) {
		driver.switchTo().frame(name);
	}
	
	// this is a method to switch to frame based xpath
	public static void switchFrameWebEle(WebElement ele) {
		driver.switchTo().frame(ele);
	}
	
	// this is a method to switch to frame based on Index number
	public static void switchFrameIndex(int index) {
		driver.switchTo().frame(index);
	}
	
	// this is a method to come out of Frame
	public static void switchOutOfFrame() {
		driver.switchTo().defaultContent();
	}
	
	// this is a method to switch to Parent frame
	public static void switchParentFrame() {
		driver.switchTo().parentFrame();
	}

	//this is to select the value from Dropdown using the value available in code
	public static void drpdwnSelByValue(WebElement refName, String selvalue) {
		Select s = new Select(refName);
		s.selectByValue(selvalue);
	}

	//this is to select the value from Dropdown using Index
	public static void drpdwnSelByIndex(WebElement refName, int index) {
		Select s = new Select(refName);
		s.selectByIndex(index);
	}
	
	//this is to select the value from Dropdown using index and return the same using variable
	public static String retdrpdwnSelByIndex(WebElement refName, int index) {
		Select s = new Select(refName);
		String selectedvalue = "";
		s.selectByIndex(index);
		return selectedvalue;

	}

	
	//this is to select the value from Dropdown using the visible text
	public static void drpdwnSelByvisibleText(WebElement refName, String text) {
		Select s = new Select(refName);
		s.selectByVisibleText(text);
	}

	//this is to deselect the value from Dropdown using the value available in code
	public static void drpdwnDeSelByValue(WebElement refName, String deselvalue) {
		Select s = new Select(refName);
		s.deselectByValue(deselvalue);
	}
	
	//this is to deselect the value from Dropdown using Index
	public static void drpdwnDeSelByIndex(WebElement refName, int index) {
		Select s = new Select(refName);
		s.deselectByIndex(index);
	}
	
	//this is to deselect the value from Dropdown using the visible text
	public static void drpdwnDeSelByvisibleText(WebElement refName, String text) {
		Select s = new 	Select(refName);
		s.deselectByVisibleText(text);
	}
	
	//this is to check if we can select multiple value from the dropdown
	public static  void drpdwnIsMultiple(WebElement refName) {
		Select s = new Select(refName);
		boolean ismulti = s.isMultiple();
		System.out.println(ismulti);
	}
	
	//this is to get all the options available in the dropdown list
	public static void drpdownGetOptions(WebElement refName) {
		Select s = new Select(refName);
		List<WebElement> drpoptions = s.getOptions();
		for (WebElement drplist : drpoptions) {
			String drpvalue = drplist.getText();
			System.out.println(drpvalue);
		}
	}
	
	//this to see the selected option in dropdown
	public static void drpSelectedOpts(WebElement refName) {
		Select s = new Select(refName);
		List<WebElement> allselctopts = s.getAllSelectedOptions();
		for (WebElement allselctd : allselctopts) {
			String selctedvalue = allselctd.getText();
			System.out.println(selctedvalue);
		}
	}
	
	//this to see the 1st selected option in dropdown
	public static void drpfstseloption(WebElement refName) {
		Select s = new Select(refName);
		WebElement fstsells = s.getFirstSelectedOption();
		String fstselval = fstsells.getText();
		System.out.println(fstselval);
	}
	
	//this to deselect all values in the dropdown
	public static void drpDeSelAll(WebElement refName) {
		Select s = new Select(refName);
		s.deselectAll();	
	}
	
	//this is to check if the webElement is displayed or not
	public static void visiblityDisplayed(WebElement refName) {
		boolean webEleDisplayed = refName.isDisplayed();
		System.out.println(webEleDisplayed);
	}
	
	//this is to check if the webElement is selected or not
	public static void visiblitySelected(WebElement refName) {
		boolean webEleSelected = refName.isSelected();
		System.out.println(webEleSelected);
	}
	
	//this is to check if the webElement is enabled or not
	public static void visiblityEnabled(WebElement refName) {
		boolean webEleEnabled = refName.isEnabled();
		System.out.println(webEleEnabled);
	}
	
	//this is to close the current browser tab
	public static void browserClose() {
		driver.close();
	}
	
	//this is to close all the tabs in the browser
	public static void browserQuit() {
		driver.quit();
	}
	
	//this is to read data from excel sheet
	public static String readingFromExcel(String excelname, String sheetname, int rownumber, int cellnumber) throws IOException {
		File f = new File("src\\test\\resources\\Excel\\"+ excelname+".xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet(sheetname);
		Row r = s.getRow(rownumber);
		Cell c = r.getCell(cellnumber);

		CellType celltype = c.getCellType();
		System.out.println(celltype);
		String value = "";
		
		switch(celltype) {
		case STRING:
			value = c.getRichStringCellValue().getString();
			System.out.println(value);
			break;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(c)) {
				Date dateCellValue = c.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-YYYY");
				value = sdf.format(dateCellValue);
				System.out.println(value);
			}
			else
			{
				double numericellvalue = c.getNumericCellValue();
				long l = (long)numericellvalue;
				value = String.valueOf(l);
				System.out.println(value);
			}
		default:
			break;
			
		}
		return value;
	}
	
	public static void WaitClickable(WebElement refName, Duration i) {
		WebDriverWait wait = new WebDriverWait(driver, i);
		wait.until(ExpectedConditions.elementToBeClickable(refName));
	}
	
}
