package com.echalan.page;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.echalan.base.Runner;
import com.echalan.utility.UtilPage;

public class Challan_History {
	
	    public WebDriver driver=Runner.MainDriver;
		ExtentReports challanHistoryExtent=Runner.extent;
		ExtentTest challanHistoryTest=Runner.logger;
	
	Select role,paymentType,challanSource;
	JavascriptExecutor js;
	
	
	@FindBy(xpath="//i[ text()='add']")
	private WebElement add_icon;
	
	@FindBy(xpath="//a[@href='http://164.100.161.91/echallan/history']")
	private WebElement challanHisory_icon;
	
	@FindBy(xpath="//a[@title='Show/Hide Filter Panel']")
	private WebElement filter_icon;
	
	@FindBy(xpath="//select[@ng-model='newFilter']")
	private WebElement challanNO_filter; 
	
	@FindBy(xpath="//select[@ng-model='filters.officer_id']")
	private WebElement officers_dropdown;
	
	@FindBy(xpath="//select[@ng-model='filters.payment_type']")
	private WebElement payment_type_list;
	
	@FindBy(xpath="//select[@ng-model='filters.challanType']")
	private WebElement challanSource_list;
	
	@FindBy(xpath="//select[@ng-model='filters.gender']")
	private WebElement gender;
	
	@FindBy(xpath="//input[@ng-model='filters.emp_id']")
	private WebElement employeeId_tb;
	
	@FindBy(xpath="//input[@placeholder='Enter challan number']")
	private WebElement challan_tB;  
	
	@FindBy(xpath="//a[@ng-click='searchByFilters()']")
	private WebElement search; 
	
	@FindBy(xpath="//input[@id='datepicker_start_payment']")
	private WebElement start_date;
	
	@FindBy(xpath="//input[@id='datepicker_end_payment']")
	private WebElement End_date;
	
	@FindBy(xpath="//input[@id='datepicker_start']")
	private WebElement start_date2;
	
	@FindBy(xpath="//input[@id='datepicker_end']")
	private WebElement End_date2;
	
	@FindBy(xpath="//button[@class='xdsoft_prev']")
	private WebElement Prev_button;
	
	@FindBy(xpath="//div[@data-hour='1']")
	private WebElement hour1;
	
	@FindBy(xpath="/html/body/div[5]/div[2]/div/div[1]/div[2]")
	private WebElement hour2;
	
	@FindBy(xpath="//input[@placeholder='Enter Vehicle Number']")
	private WebElement VehicleNO_TB;
	
	 public Challan_History(){
		 
			
	        PageFactory.initElements(driver,this);
	       
	 }		
	 

		
		
		public void AllMethod() throws InterruptedException, IOException{
		
			  
	    	ByInvalid_Valid_ChallanNo_TC002_003_TC004();
	    	by_officer_TC005();
	    	by_PaymentDate_TC006();
	    	withoutAny_paymentType_TC007();
	    	by_paymentType_Onspot_TC008();
	    	by_paymentType_PaymentInOffice_TC009();
	    	by_paymentType_Online_TC010();
	    	by_paymentType_ByCard_TC011();  
	    	by_ChallanSource_DeviceChallan_TC012();
	    	by_ChallanSource_CCTVChallan_TC013();
	    	by_ChallanSource_ManualChallan_TC014();
	    	by_date_TC015();
	    	by_Invalid_vehicleNO_TC016();
	    	by_vehicleNO_TC017();
	    	by_userID_TC018();
	    	by_EmployeeID_TC019();
			by_genderMale_TC020();
			by_genFemale_TC021();
	      
		   
	}  
		
		
		public void ByInvalid_Valid_ChallanNo_TC002_003_TC004() throws InterruptedException, IOException{
			
			 Actions act=new Actions(driver);
			    act.moveToElement(add_icon).build().perform();
			    Thread.sleep(1000);
				challanHisory_icon.click();
			
			Thread.sleep(2000);
			
			challanHistoryTest=challanHistoryExtent.createTest("ByInvalid_Valid_ChallanNo_TC002_003_TC004");
			challanHistoryTest.log(Status.INFO,"tc002--clicked on filter icon successfully");
			challanHistoryTest.log(Status.INFO,"tc003---enter an invalid chalan no");
		    challanHistoryTest.log(Status.INFO,"it is showing data after enter an Invalid challan(ab123) no So it is bug");
		    challanHistoryTest.log(Status.INFO,"tc004--enter an valid chalan no");
			
			filter_icon.click();
			Thread.sleep(1000);
			 role=new Select(challanNO_filter);
	        Thread.sleep(1000);
	        role.selectByVisibleText("Challan No");
	        Thread.sleep(2000);
	        
	        String chalan1=getDataFromRegExcel("Challan1");
			challan_tB.sendKeys(chalan1);
	        search.click();
	        System.out.println("one challan data is showing");
	        Thread.sleep(5000);
	        filter_icon.click();
	        Thread.sleep(2000);
	        challan_tB.clear();
	        String chalan2=getDataFromRegExcel("Challan2");
			challan_tB.sendKeys(chalan2);
	        search.click();
	        Thread.sleep(5000);
	        System.out.println("second challan data is showing");
	        challanHistoryTest.log(Status.INFO,"you checked by an valid challan(GJ5383200202132417) no successfully");
	        filter_icon.click();
	        Thread.sleep(1000);
	        challan_tB.clear();
	        
	        String chalan3=getDataFromRegExcel("Challan3");
			challan_tB.sendKeys(chalan3);
	        search.click();
	        Thread.sleep(2000);
	        System.out.println("third challan data is showing");
	        filter_icon.click();
	        Thread.sleep(1000);
	        challan_tB.clear();
	        
	        String chalan4=getDataFromRegExcel("Challan4");
			challan_tB.sendKeys(chalan4);
	        search.click();
	        Thread.sleep(2000);
	        System.out.println("fourth challan data is showing");
	        filter_icon.click();
	        Thread.sleep(1000);
	        challan_tB.clear();
	        
	        String chalan5=getDataFromRegExcel("Challan5");
			challan_tB.sendKeys(chalan5);
	        search.click();
	        Thread.sleep(2000);
	        System.out.println("fifth challan data is showing");
	        filter_icon.click();
	        Thread.sleep(1000);
	        challan_tB.clear();
		}
		
		public void by_officer_TC005() throws InterruptedException{
			challanHistoryTest=challanHistoryExtent.createTest("by_officer_TC005");
	        challanHistoryTest.log(Status.INFO,"checked challan by officers");
	        
			driver.navigate().refresh();
			Thread.sleep(2000);
			filter_icon.click();
			Thread.sleep(1000);
			role=new Select(challanNO_filter);
	        role.selectByVisibleText("Officer");
	        Thread.sleep(1000);
			Select officer=new Select(officers_dropdown);
			officer.selectByValue("37866");
			Thread.sleep(2000);
			 js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",search);
			Thread.sleep(3000);
			challanHistoryTest.log(Status.INFO,"chalan is showing successfully");
			
		}  
		
		public void by_PaymentDate_TC006() throws InterruptedException{
			
			challanHistoryTest=challanHistoryExtent.createTest("by_PaymentDate_TC006");
	        challanHistoryTest.log(Status.INFO,"checked challan by Payment Date");
	        challanHistoryTest.log(Status.INFO,"enter starting and end date");
	        
			driver.navigate().refresh();
	    	filter_icon.click();
			Thread.sleep(1000);
		    role=new Select(challanNO_filter);
	        role.selectByVisibleText("Payment Date");
	        Thread.sleep(2000);
	        start_date.sendKeys("2020/06/04");
	        End_date.sendKeys("2020/06/04 02:00");
	        Thread.sleep(1000);  
	        search.click();
	        challanHistoryTest.log(Status.INFO,"chalan is showing successfully");
			
		}
		
		 public void withoutAny_paymentType_TC007() throws InterruptedException{
			
			 challanHistoryTest=challanHistoryExtent.createTest("withoutAny_paymentType_TC007");
		        challanHistoryTest.log(Status.INFO,"do not select any payment type");
		        
			    driver.navigate().refresh();
				Thread.sleep(2000);
				filter_icon.click();
				Thread.sleep(1000);
		        role.selectByVisibleText("Payment Type");
		        Thread.sleep(1000);
		        js.executeScript("arguments[0].click();",search);
				Thread.sleep(5000);
				challanHistoryTest.log(Status.INFO,"chalan is showing,it is bug");
		 }
		
		 public void by_paymentType_Onspot_TC008() throws InterruptedException{
			
			 challanHistoryTest=challanHistoryExtent.createTest("by_paymentType_Onspot_TC008");
		        challanHistoryTest.log(Status.INFO,"please select OnSpot in payment type");
		        
				Thread.sleep(2000);
				filter_icon.click();
				Thread.sleep(1000);
			    paymentType=new Select(payment_type_list);
				paymentType.selectByIndex(1);
				Thread.sleep(2000);
				js.executeScript("arguments[0].click();",search);
				Thread.sleep(5000);
				challanHistoryTest.log(Status.INFO,"chalan is showing successfully");
		 }
		 
		 public void by_paymentType_PaymentInOffice_TC009() throws InterruptedException{
			
			 challanHistoryTest=challanHistoryExtent.createTest("by_paymentType_PaymentInOffice_TC009");
		        challanHistoryTest.log(Status.INFO,"please select PaymentInOffice in payment type");
		        
				Thread.sleep(2000);
				filter_icon.click();
				Thread.sleep(1000);
				paymentType.selectByIndex(2);
				Thread.sleep(2000);
				js.executeScript("arguments[0].click();",search);
				Thread.sleep(5000);
				challanHistoryTest.log(Status.INFO,"chalan is showing successfully");
		 }
		 
		 public void by_paymentType_Online_TC010() throws InterruptedException{
			
			 challanHistoryTest=challanHistoryExtent.createTest("by_paymentType_Online_TC010");
		        challanHistoryTest.log(Status.INFO,"please select online in payment type");
		        
				Thread.sleep(2000);
				filter_icon.click();
				Thread.sleep(1000);
				paymentType.selectByIndex(3);
				Thread.sleep(2000);
				js.executeScript("arguments[0].click();",search);
				Thread.sleep(5000);
				challanHistoryTest.log(Status.INFO,"chalan is showing successfully");
		 }
		 
		 
		 public void by_paymentType_ByCard_TC011() throws InterruptedException{
			
			 challanHistoryTest=challanHistoryExtent.createTest("by_paymentType_ByCard_TC011");
		        challanHistoryTest.log(Status.INFO,"please select card in payment type");
		        
				Thread.sleep(2000);
				filter_icon.click();
				Thread.sleep(1000);
				paymentType.selectByIndex(6);
				Thread.sleep(2000);
				js.executeScript("arguments[0].click();",search);
				Thread.sleep(5000);
				challanHistoryTest.log(Status.INFO,"chalan is showing successfully");
		 }
		 
		 public void by_ChallanSource_DeviceChallan_TC012() throws InterruptedException{
			
			 challanHistoryTest=challanHistoryExtent.createTest("by_ChallanSource_DeviceChallan_TC012");
		        challanHistoryTest.log(Status.INFO,"please select Device chalan in chalan type ");
		        driver.navigate().refresh();
				Thread.sleep(2000);
				filter_icon.click();
				Thread.sleep(1000);
			    role.selectByVisibleText("Challan Source");
			    Thread.sleep(2000);
			    Select challanSource=new Select(challanSource_list);
			    challanSource.selectByIndex(1);
			    Thread.sleep(1000);
			    js.executeScript("arguments[0].click();",search);
				Thread.sleep(5000);
				challanHistoryTest.log(Status.INFO,"chalan is showing successfully");
		 }
		 
		 public void by_ChallanSource_CCTVChallan_TC013() throws InterruptedException{
			
			 challanHistoryTest=challanHistoryExtent.createTest("by_ChallanSource_CCTVChallan_TC013");
		        challanHistoryTest.log(Status.INFO,"please select CCTV chalan in chalan type ");
		        
				Thread.sleep(2000);
				filter_icon.click();
				Thread.sleep(1000);
				Select challanSource=new Select(challanSource_list);
				challanSource.selectByIndex(2);
				Thread.sleep(1000);
				js.executeScript("arguments[0].click();",search);
				Thread.sleep(5000);
				challanHistoryTest.log(Status.INFO,"chalan is showing successfully");
		 }
		 
		 public void by_ChallanSource_ManualChallan_TC014() throws InterruptedException{
			
			    challanHistoryTest=challanHistoryExtent.createTest("by_ChallanSource_ManualChallan_TC014");
		        challanHistoryTest.log(Status.INFO,"please select manual chalan in chalan type ");
		        	
			    Thread.sleep(2000);
				filter_icon.click();
				Thread.sleep(2000);
				Select challanSource=new Select(challanSource_list);
				challanSource.selectByIndex(3);
				Thread.sleep(1000);
				js.executeScript("arguments[0].click();",search);
				Thread.sleep(5000);
				challanHistoryTest.log(Status.INFO,"chalan is showing successfully");
		 }
		
	        public void by_date_TC015() throws InterruptedException{
	   		 
	        	challanHistoryTest=challanHistoryExtent.createTest("by_challanDate_TC015");
		        challanHistoryTest.log(Status.INFO,"checked challan by challan date");
		        
	        	System.out.println("challan_history_by_date method is running ");
	        	driver.navigate().refresh();
	        	filter_icon.click();
	    		Thread.sleep(1000);
	            role.selectByVisibleText("Challan Date");
	            Thread.sleep(2000);
	            start_date2.sendKeys("2020/06/04");
	            End_date2.sendKeys("2020/06/04 02:00");
	            Thread.sleep(1000);  
	            search.click();
	            Thread.sleep(5000);
	            challanHistoryTest.log(Status.INFO,"chalan is showing successfully");
	        
	}
	        public void by_Invalid_vehicleNO_TC016() throws InterruptedException, IOException{
	        	
	        	challanHistoryTest=challanHistoryExtent.createTest("by_Invalid_vehicleNO_TC016");
		        challanHistoryTest.log(Status.INFO,"checked challan by Invalid vehicleNO");
		        
	        	driver.navigate().refresh();
	        	filter_icon.click();
	    		Thread.sleep(1000);
	            role.selectByVisibleText("Vehicle Number");
	            Thread.sleep(2000);
	            VehicleNO_TB.sendKeys("0000");
	            Thread.sleep(1000);
	            search.click();
	            challanHistoryTest.log(Status.INFO,"chalan is showing ,it is Bug");
	            Thread.sleep(5000);
	            
	        }

	        
	        public void by_vehicleNO_TC017() throws InterruptedException, IOException{
	        	
	        	challanHistoryTest=challanHistoryExtent.createTest("by_vehicleNO_TC017");
		        challanHistoryTest.log(Status.INFO,"checked challan by vehicle no");
		        
	        	System.out.println("challan_history_by_vehicle number is running ");
	            filter_icon.click();
	            Thread.sleep(2000);
	            VehicleNO_TB.clear();
	            Thread.sleep(1000);
	            String vehicleNO=getDataFromRegExcel("vehicle_no");
	            VehicleNO_TB.sendKeys(vehicleNO);
	            Thread.sleep(1000);
	            search.click();
	            Thread.sleep(5000);
	            challanHistoryTest.log(Status.INFO,"chalan is showing successfully");
	        }
	        
	        public void by_userID_TC018() throws InterruptedException{
	        	
	        	challanHistoryTest=challanHistoryExtent.createTest("by_userID_TC018");
		        challanHistoryTest.log(Status.INFO,"checked challan by user Id");
		        challanHistoryTest.log(Status.INFO,"select a user id");
		        challanHistoryTest.log(Status.INFO,"chalan is showing successfully");
		        
	        	System.out.println("challan_history_by_userid is running ");
	        	driver.navigate().refresh();
	        	filter_icon.click();
	    		Thread.sleep(1000);
	            role.selectByVisibleText("User Id");
	            Thread.sleep(2000);
	            search.click();
	            Thread.sleep(5000);

	        }
	        
	        public void by_EmployeeID_TC019() throws InterruptedException{
	        
	        	challanHistoryTest=challanHistoryExtent.createTest("by_EmployeeID_TC019");
		        challanHistoryTest.log(Status.INFO,"checked challan by employee Id");
		        
	        	System.out.println("challan_history_by_Employee id is running ");
	        	driver.navigate().refresh();
	        	filter_icon.click();
	    		Thread.sleep(1000);
	            role.selectByVisibleText("Employee Id");
	            Thread.sleep(2000);
	            employeeId_tb.sendKeys("bsbs2323");
	            search.click();
	            System.out.println("Employee-id  completed successfully");
	            challanHistoryTest.log(Status.INFO,"sorry,you have no employee Id");

	        }
	        
	        public void by_genderMale_TC020() throws InterruptedException{
	        	
	        	challanHistoryTest=challanHistoryExtent.createTest("by_male_TC020");
		        challanHistoryTest.log(Status.INFO,"enter employee id");
		        challanHistoryTest.log(Status.INFO,"enter challan date");
		        challanHistoryTest.log(Status.INFO,"select male in gender");
		        	        	
	        	System.out.println("by_gender male is running ");
	        	driver.navigate().refresh();
	        	filter_icon.click();
	    		Thread.sleep(1000);
	    		role.selectByVisibleText("Challan Date");
	            Thread.sleep(2000);
	            role.selectByVisibleText("Employee Id");
	            Thread.sleep(2000);
	            role.selectByVisibleText("Gender");
	            Thread.sleep(2000);
	            js.executeScript("window.scrollBy(0,300)","");
	            Thread.sleep(2000);
	            start_date2.sendKeys("2020/06/04");
	            End_date2.sendKeys("2020/06/04 02:00");
	            Thread.sleep(1000);
	            employeeId_tb.click();
	            employeeId_tb.sendKeys("Rohit007");
	            Thread.sleep(2000);
	            Select gender2=new Select(gender);
	            gender2.selectByVisibleText("Male");
	            Thread.sleep(3000);
	            search.click();
	            Thread.sleep(5000);
	        }
	        
	        public void by_genFemale_TC021() throws InterruptedException{
	        	
	        	challanHistoryTest=challanHistoryExtent.createTest("by_Female_TC021");
		        challanHistoryTest.log(Status.INFO,"enter employee id");
		        challanHistoryTest.log(Status.INFO,"enter challan date");
		        challanHistoryTest.log(Status.INFO,"select female in gender");
		        
	        	System.out.println("by_gender female is running ");
	        	driver.navigate().refresh();
	        	filter_icon.click();
	    		Thread.sleep(1000);
	    		role=new Select(challanNO_filter);
	    		role.selectByVisibleText("Challan Date");
	            Thread.sleep(2000);
	            role.selectByVisibleText("Employee Id");
	            Thread.sleep(2000);
	            role.selectByVisibleText("Gender");
	            Thread.sleep(2000);
	            js.executeScript("window.scrollBy(0,300)","");
	            Thread.sleep(2000);
	            start_date2.sendKeys("2020/06/04");
	            End_date2.sendKeys("2020/06/04 02:00");
	            Thread.sleep(1000);
	            employeeId_tb.click();
	            employeeId_tb.sendKeys("Naina001");
	            Thread.sleep(2000);
	            Select gender2=new Select(gender);
	            gender2.selectByVisibleText("Female");
	            Thread.sleep(3000);
	            search.click();
	            Thread.sleep(5000);
	        }
		
		public static Map<String,String> Read_RegExcel() throws IOException {
			
			Workbook bb=new XSSFWorkbook("D:\\Nic_work\\Desktop\\AllClasses_data\\Chalan_History_data.xlsx");
			Sheet shet=bb.getSheet("Challan_History");
			Map<String,String> mp=new HashMap<String,String>();
			Row row=shet.getRow(0);
			int totalcell=row.getLastCellNum();
				for(int j=0;j<totalcell;j++) {
				String key=	shet.getRow(0).getCell(j).getStringCellValue();
				String value=shet.getRow(2).getCell(j).getStringCellValue();
				mp.put(key, value);
				}
				
			return mp;
		}
		public static String getDataFromRegExcel(String key) throws IOException {
			
			Map<String,String> data=Read_RegExcel();
			String value=data.get(key);
			return value;

		}
}
  
