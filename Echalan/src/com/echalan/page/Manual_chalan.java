package com.echalan.page;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.echalan.base.Runner;
import com.echalan.utility.Screenshot;
import com.echalan.utility.UtilPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Manual_chalan {

	public  WebDriver ManualDriver=Runner.MainDriver;
	
	 
	 ExtentReports manualExtent=Runner.extent;
	 ExtentTest manualTest=Runner.logger;

	@FindBy(xpath = "//button[@type='button']")
	private WebElement popup;

	@FindBy(xpath = "//input[@id='userName']")
	private WebElement username;

	@FindBy(xpath = "//span[@id='next']")
	private WebElement next;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@name='login']")
	private WebElement login;

	@FindBy(xpath = "//i[ text()='add']")
	public static WebElement add_icon;

	@FindBy(xpath = "//a[@href='http://164.100.161.91/echallan/challan']")
	public static WebElement Manual_Challan_icon;

	@FindBy(xpath = "//span[@class='select2-selection select2-selection--single']")
	public static WebElement bookNO_dropdown;

	@FindBy(xpath = "//ul[@id='select2-book1-results']/li")
	public static WebElement bookNO;

	@FindBy(xpath = "//input[@name='rc_number']")
	public static WebElement vehicle_tb;

	@FindBy(xpath = "//*[@id='locationvehicleClass1']/div[1]/span/span[1]/span")
	public static WebElement vehicleCLASS;

	@FindBy(xpath = "//button[text()='Get Vehicle Details']")
	public static WebElement veh_detail_button;

	@FindBy(id = "engine_no")
	public static WebElement engine_no;
	
	@FindBy(id= "chasis_no")
	public static WebElement chasis_no;
	
	@FindBy(xpath = "//label[@for='owner']")
	public static WebElement accuse_type_OWNER;
	
	@FindBy(xpath = "//label[@for='driver']") 
	public static WebElement accuse_type_driver;
	
	@FindBy(id = "driver_name")
	public static WebElement driver_name;
	
	@FindBy(id = "driver_father")
	public static WebElement fatherName;
	
	@FindBy(id = "driver_address")
	public static WebElement driver_address;

	@FindBy(xpath = "//label[@for='no_dl']")
	public static WebElement no_dl_box;

	@FindBy(xpath = "//input[@id='challan_time']")
	public WebElement challan_time_tb;

	@FindBy(xpath = "(//div[@class='xdsoft_time xdsoft_current'])[3]")
	public static WebElement select_time;

	@FindBy(xpath = "//input[@id='challan_time']")
	public static WebElement challan_time;

	@FindBy(xpath = "//ul[@id='select2-vehicleClass1-results']/li[4]")
	public static WebElement select_vehicle_class;

	@FindBy(xpath = "//input[@placeholder='Challan Address']")
	public static WebElement chalan_address;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	public static WebElement select_offence;

	@FindBy(xpath = "//ul[@id='select2-offences-results']/li")
	public static WebElement select_offenceName;

	@FindBy(xpath = "//label[@for='impound_document1']")
	public static WebElement impound_document;

	@FindBy(xpath = "//input[@id='goods_description']")
	public static WebElement goods_des;
	
	@FindBy(xpath = "//label[@for='witness1']")
	public static WebElement witness;	
	
	@FindBy(xpath = "//label[@for='court']")
	public static WebElement court;

	@FindBy(xpath = "//span[@id='select2-courtId-container']")
	public static WebElement court_list;

	@FindBy(xpath = "//ul[@id='select2-courtId-results']/li")
	public static WebElement select_court;

	@FindBy(id = "hearing_date")
	public static WebElement hearing_date;
	
	@FindBy(id = "remarks")
	public static WebElement Remark;

	@FindBy(xpath = "//button[@id='submit']")
	public static WebElement submit;

	@FindBy(xpath = "//button[text()='No']")
	public static WebElement confirm_No;

	@FindBy(xpath = "//button[text()='Yes']")
	public static WebElement confirm_yes;

//	public Manual_chalan(){
//		PageFactory.initElements(ManualDriver, this);
//	}

	@Test
	public void submit_without_Fill() throws IOException, InterruptedException {
		PageFactory.initElements(ManualDriver, this);
		
		 Actions act = new Actions(ManualDriver);
		 act.moveToElement(add_icon).build().perform();
		WebDriverWait w = new WebDriverWait(ManualDriver, 5);
		w.until(ExpectedConditions.visibilityOf(Manual_Challan_icon));
		Manual_Challan_icon.click();
		Thread.sleep(3000);
		submit.click();
		
	}

	@Test
	public void challan_without_engineNO_005() throws IOException, InterruptedException {

		
		try {
//			PageFactory.initElements(ManualDriver, this);
//			WebDriverWait w = new WebDriverWait(ManualDriver, 5);
//			w.until(ExpectedConditions.visibilityOf(Manual_Challan_icon));
//			Manual_Challan_icon.click();
			Thread.sleep(3000);
			manualTest=manualExtent.createTest("testcase005");
			manualTest.log(Status.INFO, "fill all the field except engine no");
			vehicle_tb.sendKeys("GJ12Z1119");                     //  13 may TC
			Thread.sleep(2000);
			veh_detail_button.click();
			Thread.sleep(2000);
			vehicleCLASS.click();
			Thread.sleep(2000);
			select_vehicle_class.click();
			Thread.sleep(1000);
			engine_no.clear();
			Thread.sleep(1000);
			accuse_type_OWNER.click();
			Thread.sleep(1000);
			no_dl_box.click();
			Thread.sleep(1000);
			challan_time.click();
			Thread.sleep(2000);
			select_time.click();
			Thread.sleep(1000);
			chalan_address.sendKeys("xyz");
			Thread.sleep(1000);
			select_offence.click();
			Thread.sleep(2000);
			select_offenceName.click();
			submit.click();
			Thread.sleep(2000);
			UtilPage.getScreenshot("without_fill_engine_no");
			confirm_No.click();
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	@Test
	public void challan_without_chasisNO_006() throws IOException, InterruptedException {
		

		try {
			manualTest=manualExtent.createTest("testcase 006");
			manualTest.log(Status.INFO, "fill all the field except chasis no");
			ManualDriver.navigate().refresh();      //  13 may TC
			Thread.sleep(3000);
			Thread.sleep(2000);
			vehicle_tb.sendKeys("GJ12Z1119");
			Thread.sleep(2000);
			veh_detail_button.click();
			Thread.sleep(2000);
			vehicleCLASS.click();
			Thread.sleep(2000);
			select_vehicle_class.click();
			Thread.sleep(1000);
			chasis_no.clear();
			Thread.sleep(1000);
			accuse_type_OWNER.click();
			Thread.sleep(1000);
			no_dl_box.click();
			Thread.sleep(1000);
			challan_time.click();
			Thread.sleep(2000);
			select_time.click();
			Thread.sleep(1000);
			chalan_address.sendKeys("xyz");
			Thread.sleep(1000);
			select_offence.click();
			Thread.sleep(2000);
			select_offenceName.click();
			submit.click();
			Thread.sleep(2000);
			UtilPage.getScreenshot("without_fill_the_chasis_no");
			Thread.sleep(1000);
			confirm_No.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void challan_without_ImpoundDocument_017() throws IOException, InterruptedException {
		

		try {
			manualTest=manualExtent.createTest("testcase 017");
			manualTest.log(Status.INFO, "fill all the field except impound document");   //  13 may TC
			ManualDriver.navigate().refresh();
			Thread.sleep(1000);
			vehicle_tb.sendKeys("GJ12Z1119");
			Thread.sleep(2000);
			veh_detail_button.click();
			Thread.sleep(2000);
			vehicleCLASS.click();
			Thread.sleep(2000);
			select_vehicle_class.click();
			Thread.sleep(1000);
			accuse_type_OWNER.click();
			Thread.sleep(1000);
			no_dl_box.click();
			Thread.sleep(1000);
			challan_time.click();
			Thread.sleep(2000);
			select_time.click();
			Thread.sleep(1000);
			chalan_address.sendKeys("xyz");
			Thread.sleep(1000);
			impound_document.click();
			Thread.sleep(1000);
			impound_document.click();
			select_offence.click();
			Thread.sleep(2000);
			select_offenceName.click();
			submit.click();
			Thread.sleep(2000);
//			UtilPage.getScreenshot("without select impound document");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	  
	           
	@Test       
 public void challan_without_selectAccusedType_009() throws IOException, InterruptedException {
	

	try {
		manualTest=manualExtent.createTest("testcase 009");
		manualTest.log(Status.INFO, "fill all the field except accused type");
		ManualDriver.navigate().refresh();
		Thread.sleep(4000);
		vehicle_tb.sendKeys("GJ12Z1119");          //   14 may task
		veh_detail_button.click();
		Thread.sleep(2000);
		vehicleCLASS.click();
		Thread.sleep(1000);
		select_vehicle_class.click();
		Thread.sleep(1000);
		no_dl_box.click();
		Thread.sleep(1000);
		challan_time.click();
		Thread.sleep(2000);
		select_time.click();
		Thread.sleep(1000);
		chalan_address.sendKeys("xyz");
		Thread.sleep(1000);
		select_offence.click();
		Thread.sleep(2000);
		select_offenceName.click();
		submit.click();
		Thread.sleep(2000);
		scroll_till_element();
		Thread.sleep(2000);
//		UtilPage.getScreenshot("without_accused_type");
		Thread.sleep(1000);
		confirm_No.click();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
	
	@Test	
public void challan_without_driverName_010() throws IOException, InterruptedException {
		
	    try {
	    	manualTest=manualExtent.createTest("testcase 010");
			manualTest.log(Status.INFO, "fill all the field except chasis no");
			ManualDriver.navigate().refresh();
			Thread.sleep(4000);
			vehicle_tb.sendKeys("GJ12Z1119");         //   14 may task
			Thread.sleep(2000);
			veh_detail_button.click();
			Thread.sleep(2000);
			vehicleCLASS.click();
			Thread.sleep(2000);
			select_vehicle_class.click();
			Thread.sleep(1000);
			accuse_type_driver.click();
			Thread.sleep(1000);
			driver_name.sendKeys("abc");
			Thread.sleep(1000);
			fatherName.sendKeys("abcd");
			Thread.sleep(1000);
			driver_address.sendKeys("abcde");
			Thread.sleep(1000);
			driver_name.clear();
			Thread.sleep(1000);
			no_dl_box.click();
			Thread.sleep(1000);
			challan_time.click();
			Thread.sleep(2000);
			select_time.click();
			Thread.sleep(1000);
			chalan_address.sendKeys("xyz");
			Thread.sleep(1000);
			select_offence.click();
			Thread.sleep(2000);
			select_offenceName.click();
			submit.click();
			Thread.sleep(2000);
//			UtilPage.getScreenshot("without_driverName");
			Thread.sleep(1000);
			confirm_No.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	   
	@Test
public void without_fatherName_011() throws IOException, InterruptedException {
	
    try {
//    	PageFactory.initElements(ManualDriver, this);
//		WebDriverWait w = new WebDriverWait(ManualDriver, 5);
//		w.until(ExpectedConditions.visibilityOf(Manual_Challan_icon));
//		Manual_Challan_icon.click();
    	
    	manualTest=manualExtent.createTest("testcase 011");
		manualTest.log(Status.INFO, "fill all the field except father name");
		ManualDriver.navigate().refresh();
		Thread.sleep(4000);
		vehicle_tb.sendKeys("GJ12Z1119");         //   14 may task but complete on 15 may
		Thread.sleep(2000);
		veh_detail_button.click();
		Thread.sleep(2000);
		vehicleCLASS.click();
		Thread.sleep(2000);
		select_vehicle_class.click();
		Thread.sleep(1000);
		accuse_type_driver.click();
		Thread.sleep(1000);
		driver_name.sendKeys("abc");
		Thread.sleep(1000);
		fatherName.sendKeys("abcd");
		Thread.sleep(1000);
		driver_address.sendKeys("abcde");
		Thread.sleep(1000);
		fatherName.clear();
		Thread.sleep(1000);
		no_dl_box.click();
		Thread.sleep(1000);
		challan_time.click();
		Thread.sleep(2000);
		select_time.click();
		Thread.sleep(1000);
		chalan_address.sendKeys("xyz");
		Thread.sleep(1000);
		select_offence.click();
		Thread.sleep(2000);
		select_offenceName.click();
		submit.click();
		Thread.sleep(4000);
//		UtilPage.getScreenshot("without_fatherName_11");
		Thread.sleep(3000);
		confirm_No.click();
	} catch (Exception e) {
		e.printStackTrace();
		manualTest.log(Status.FAIL, "it is fail because you have not enter father name");
	}
}

	@Test
public void without_courtAndDate_019() throws IOException, InterruptedException {
	
	try {
		
		manualTest=manualExtent.createTest("testcase 019");
		manualTest.log(Status.INFO, "fill all the field except court and Date");
		ManualDriver.navigate().refresh();      //   15 may task
		Thread.sleep(4000);
		vehicle_tb.sendKeys("GJ12Z1119");
		Thread.sleep(2000);
		veh_detail_button.click();
		Thread.sleep(2000);
		vehicleCLASS.click();
		Thread.sleep(2000);
		select_vehicle_class.click();
		Thread.sleep(1000);
		accuse_type_driver.click();
		Thread.sleep(1000);
		driver_name.sendKeys("abc");
		Thread.sleep(1000);
		fatherName.sendKeys("abcd");
		Thread.sleep(1000);
		driver_address.sendKeys("abcde");
		Thread.sleep(1000);
		no_dl_box.click();
		Thread.sleep(1000);
		challan_time.click();
		Thread.sleep(2000);
		select_time.click();
		Thread.sleep(1000);
		chalan_address.sendKeys("xyz");
		Thread.sleep(1000);
		court.click();
		Thread.sleep(1000);
		select_offence.click();
		Thread.sleep(2000);
		select_offenceName.click();
		submit.click();
		Thread.sleep(2000);
//		UtilPage.getScreenshot("without_courtAndDate_019");
	} catch (Exception e) {
		e.printStackTrace();
	}
}

	@Test
public void without_court_020() throws IOException, InterruptedException {
	try {
		manualTest=manualExtent.createTest("testcase 020");
		manualTest.log(Status.INFO, "fill all the field without select court");
		ManualDriver.navigate().refresh();
		Thread.sleep(4000);
		vehicle_tb.sendKeys("GJ12Z1119");      //   15 may task
		Thread.sleep(2000);
		veh_detail_button.click();
		Thread.sleep(2000);
		vehicleCLASS.click();
		Thread.sleep(2000);
		select_vehicle_class.click();
		Thread.sleep(1000);
		accuse_type_driver.click();
		Thread.sleep(1000);
		driver_name.sendKeys("abc");
		Thread.sleep(1000);
		fatherName.sendKeys("abcd");
		Thread.sleep(1000);
		driver_address.sendKeys("abcde");
		Thread.sleep(1000);
		no_dl_box.click();
		Thread.sleep(1000);
		challan_time.click();
		Thread.sleep(2000);
		select_time.click();
		Thread.sleep(1000);
		chalan_address.sendKeys("xyz");
		Thread.sleep(1000);
		court.click();
		Thread.sleep(2000);
		hearing_date.sendKeys("2020/05/15 12:00");
		select_offence.click();
		Thread.sleep(2000);
		select_offenceName.click();
		submit.click();
		Thread.sleep(2000);
//		UtilPage.getScreenshot("without_court_020");
	} catch (Exception e) {
		e.printStackTrace();
	}      
	   
	}   
	

	
	
	
	@Test
	public void ImppoundDocument_with_witness_025() throws IOException, InterruptedException {
		try {
			manualTest=manualExtent.createTest("testcase 025");
			manualTest.log(Status.INFO, "select Impound document and witness");
			ManualDriver.navigate().refresh();
			Thread.sleep(4000);
			vehicle_tb.sendKeys("GJ12Z1119");      //   15 may task
			Thread.sleep(2000);
			veh_detail_button.click();
			Thread.sleep(2000);
			vehicleCLASS.click();
			Thread.sleep(2000);
			select_vehicle_class.click();
			Thread.sleep(1000);
			accuse_type_driver.click();
			Thread.sleep(1000);
			driver_name.sendKeys("abc");
			Thread.sleep(1000);
			fatherName.sendKeys("abcd");
			Thread.sleep(1000);
			driver_address.sendKeys("abcde");
			Thread.sleep(1000);
			no_dl_box.click();
			Thread.sleep(1000);
			challan_time.click();
			Thread.sleep(2000);
			select_time.click();
			Thread.sleep(1000);
			chalan_address.sendKeys("xyz");
			Thread.sleep(1000);
			impound_document.click();
			Thread.sleep(1000);
			witness.click();
			goods_des.click();
			Thread.sleep(1000);
			UtilPage.getScrenshot("ImppoundDocument_with_witness_025");
			select_offence.click();
			Thread.sleep(2000);
			select_offenceName.click();
			submit.click();
			Thread.sleep(2000);
	//		UtilPage.getScreenshot("ImppoundDocument_with_witness_025");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
		
		@Test
		public void witnessAnd_sentToCourt_026() throws IOException, InterruptedException {
			
				manualTest=manualExtent.createTest("testcase 026");
				manualTest.log(Status.INFO, "select witness and court");
				ManualDriver.navigate().refresh();
				Thread.sleep(4000);
				vehicle_tb.sendKeys("GJ12Z1119");      //   15 may task
				Thread.sleep(2000);
				veh_detail_button.click();
				Thread.sleep(2000);
				vehicleCLASS.click();
				Thread.sleep(2000);
				select_vehicle_class.click();
				Thread.sleep(1000);
				accuse_type_driver.click();
				Thread.sleep(1000);
				driver_name.sendKeys("abc");
				Thread.sleep(1000);
				fatherName.sendKeys("abcd");
				Thread.sleep(1000);
				driver_address.sendKeys("abcde");
				Thread.sleep(1000);
				no_dl_box.click();
				Thread.sleep(1000);
				challan_time.click();
				Thread.sleep(2000);
				select_time.click();
				Thread.sleep(1000);
				chalan_address.sendKeys("xyz");
				witness.click();
				Thread.sleep(1000);
				court.click();
				Thread.sleep(2000);
				hearing_date.click();
//				UtilPage.getScrenshot("witnessAnd_sentToCourt_026");
				Thread.sleep(1000);
				Assert.assertEquals(true, false);
				select_offenceName.click();
				submit.click();
				Thread.sleep(2000);
			//	UtilPage.getScreenshot("without_court_020");
			
		}	
		
		@Test
		public void submitAndNo_027() throws IOException, InterruptedException
		
		{
			
		PageFactory.initElements(ManualDriver, this);
		WebDriverWait w = new WebDriverWait(ManualDriver, 5);
		w.until(ExpectedConditions.visibilityOf(Manual_Challan_icon));
		Manual_Challan_icon.click();
		Thread.sleep(3000);
		manualTest = manualExtent.createTest("testcase 027");
		manualTest.log(Status.INFO, "fill all the required field");
		ManualDriver.navigate().refresh();
		Thread.sleep(4000);
		vehicle_tb.sendKeys("GJ12Z1119");               // 21 may task
		Thread.sleep(2000);
		veh_detail_button.click();
		Thread.sleep(2000);
		vehicleCLASS.click();
		Thread.sleep(2000);
		select_vehicle_class.click();
		Thread.sleep(1000);
		accuse_type_driver.click();
		Thread.sleep(1000);
		driver_name.sendKeys("abc");
		Thread.sleep(1000);
		fatherName.sendKeys("abcd");
		Thread.sleep(1000);
		driver_address.sendKeys("abcde");
		Thread.sleep(1000);
		no_dl_box.click();
		Thread.sleep(1000);
		challan_time.click();
		Thread.sleep(2000);
		select_time.click();
		Thread.sleep(1000);
		chalan_address.sendKeys("xyz");
		witness.click();
		Thread.sleep(1000);
		select_offence.click();
		Thread.sleep(2000);
		select_offenceName.click();
		Remark.sendKeys("this is valid");
		manualTest.log(Status.INFO, "click on submit button");
		submit.click();
		Thread.sleep(2000);
//		UtilPage.getScreenshot("Submit after fill ");
		
		}	

		
		@Test
		public void slectNoAfterSubmit_028() throws IOException, InterruptedException {
			
			
			manualTest = manualExtent.createTest("testcase 028");
			manualTest.log(Status.INFO, "fill all the required field");
			ManualDriver.navigate().refresh();
			Thread.sleep(4000);
			vehicle_tb.sendKeys("GJ12Z1119");               // 21 may task
			Thread.sleep(2000);
			veh_detail_button.click();
			Thread.sleep(2000);
			vehicleCLASS.click();
			Thread.sleep(2000);
			select_vehicle_class.click();
			Thread.sleep(1000);
			accuse_type_driver.click();
			Thread.sleep(1000);
			driver_name.sendKeys("abc");
			Thread.sleep(1000);
			fatherName.sendKeys("abcd");
			Thread.sleep(1000);
			driver_address.sendKeys("abcde");
			Thread.sleep(1000);
			no_dl_box.click();
			Thread.sleep(1000);
			challan_time.click();
			Thread.sleep(2000);
			select_time.click();
			Thread.sleep(1000);
			chalan_address.sendKeys("xyz");
			witness.click();
			Thread.sleep(1000);
			select_offence.click();
			Thread.sleep(2000);
			select_offenceName.click();
			Remark.sendKeys("this is valid");
			manualTest.log(Status.INFO, "click on submit button");
			submit.click();
			Thread.sleep(2000);
			manualTest.log(Status.INFO, "click on NO to remove popup");
			confirm_No.click();
//			UtilPage.getScreenshot("click No after submit");
			
		}	


	


public void scroll_till_element() throws InterruptedException{
	JavascriptExecutor js = (JavascriptExecutor) ManualDriver;
	 js.executeScript("arguments[0].scrollIntoView();",accuse_type_OWNER);
	 Thread.sleep(3000);
}
	public void m() throws IOException, InterruptedException{
		
		manualTest=manualExtent.createTest("testcase005");
		manualTest.log(Status.INFO, "fill all the field except engine no");
		vehicle_tb.sendKeys("GJ12Z1119");                     //  13 may TC
		Thread.sleep(2000);
		veh_detail_button.click();
		Thread.sleep(2000);
		vehicleCLASS.click();
		Thread.sleep(2000);
		select_vehicle_class.click();
		Thread.sleep(1000);
		engine_no.clear();
		Thread.sleep(1000);
		accuse_type_OWNER.click();
		Thread.sleep(1000);
		no_dl_box.click();
		Thread.sleep(1000);
		challan_time.click();
		Thread.sleep(2000);
		select_time.click();
		Thread.sleep(1000);
		chalan_address.sendKeys("xyz");
		Thread.sleep(1000);
		select_offence.click();
		Thread.sleep(2000);
		select_offenceName.click();
		submit.click();
		Thread.sleep(2000);
		UtilPage.getScreenshot("without_fill_engine_no");
		engine_no.sendKeys("90M60000000");                    // engine no clear
		chasis_no.clear();
		submit.click();
		UtilPage.getScreenshot("without_fill_engine_no");
		chasis_no.sendKeys("MAT448000000000000");             // chasis no clear
		impound_document.click();
		Thread.sleep(1000);
		impound_document.click();                          // impound document clear
		submit.click();
		Thread.sleep(1000);
		confirm_No.click();
		challan_without_selectAccusedType_009();
		accuse_type_OWNER.click();
		driver_name.clear();
		submit.click();
		Thread.sleep(1000);
		UtilPage.getScreenshot("without_fill_engine_no");
		accuse_type_driver.click();
		fatherName.clear();
		Thread.sleep(1000);
		driver_name.sendKeys("Rohit");
		submit.click();
		Thread.sleep(1000);
		fatherName.sendKeys("abcd");
		Thread.sleep(1000);
		impound_document.click();
		witness.click();
		Thread.sleep(1000);
		court.click();
		submit.click();
		Thread.sleep(1000);
		confirm_No.click();
		
		
		
		
		
		
		
	}

}
