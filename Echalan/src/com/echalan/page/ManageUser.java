package com.echalan.page;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.echalan.base.Runner;
import com.echalan.utility.UtilPage;

import bsh.This;

public class ManageUser {

	WebDriver Manageuser_driver=Runner.MainDriver;
	ExtentReports Manageuser_Extent=Runner.extent;
	ExtentTest Manageuser_Test=Runner.logger;

	@FindBy(xpath="//i[ text()='add']")
	private WebElement add_icon;
	
	@FindBy(xpath="//li/a[@class='btn-floating red']")
	private WebElement manageUser_icon;
	
	@FindBy(xpath="//div[@class='margin-bottom-xxl']/span/strong")
	private WebElement totalUser_available;
	
	@FindBy(xpath="//div/a[@id='newUser']")
	private WebElement addNewUser;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	private WebElement fistName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@placeholder='Employee ID']")
	private WebElement empID;
	
	@FindBy(id="official_email_id")
	private WebElement official_Email;
	
	@FindBy(xpath="//a[contains(text(),'Generate')]")
	private WebElement generate_loginID;
			
	@FindBy(xpath="(//input[@id='rto_code'])[2]")
	private WebElement RtoCode_tb;
	
	@FindBy(xpath="(//select[@id='user_type3'])[2]")
	private WebElement select_userType; 
	
	@FindBy(xpath="//button[text()='Generate']")
	private WebElement generate_button;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement pwd;
	
	@FindBy(xpath="//input[@placeholder='Confirm Password']")
	private WebElement confirm_pwd;
	
	@FindBy(xpath="//select[@id='userType']")
	private WebElement userType;
	
	@FindBy(xpath="//select[@id='role']")
	private WebElement roletype;
	
	@FindBy(xpath="//select[@id='designation']")
	private WebElement designation;
	
	@FindBy(xpath="//input[@placeholder='Mobile Number']")
	private WebElement mobile;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	private WebElement email;
	
	@FindBy(xpath="//button[@name='action']")
	private WebElement submit;
	
	@FindBy(xpath="//button[@ng-click='suspendedUser()']")
	private WebElement suspend_User;
	
	@FindBy(xpath="//button[@ng-click='blockedUser()']")
	private WebElement Blocked_User;
	
	@FindBy(xpath="//button[@ng-click='sendSms()']")
	private WebElement send_sms;
	
	@FindBy(xpath="//button[@ng-click='toggleDropdown()']")
	private WebElement selectUser_type;
	
	@FindBy(xpath="//li[@role='presentation'][1]")
	private WebElement select_one_user;
	
	@FindBy(xpath="//li[@role='presentation'][2]")
	private WebElement choose_second_user;
	
	@FindBy(xpath="//li[@role='presentation'][3]")
	private WebElement choose_third_user;
	
	@FindBy(xpath="//*[@id='sendSMS']/div/div/div[2]/div/div/form/div[3]")
	private WebElement ClickBlank; 
	
	@FindBy(xpath="//textarea[@name='message']")
	private WebElement Text_message; 
	
	@FindBy(xpath="//button[@class='waves-effect waves-light btn']")
	private WebElement send_button; 
	
	@FindBy(xpath="//input[@id='search_user']")
	private WebElement search_user;
	
	@FindBy(xpath="//button[@ng-click='searchUserList()']")
	private WebElement search_button; 
	
	@FindBy(xpath="//div/a[@class='text-lg text-medium ng-binding']")
	private WebElement clickON_search_user;
	
	
	
	
	 public ManageUser(){
		 
	        PageFactory.initElements(Manageuser_driver,this);
			
		}

				
	 @Test
		public void userPage() throws InterruptedException, IOException{
			Manageuser_Test=Manageuser_Extent.createTest("Manage User");
			Manageuser_Test.log(Status.INFO,"Create a user");
			PageFactory.initElements(Manageuser_driver,this);
			 Actions act=new Actions(Manageuser_driver);
			    act.moveToElement(add_icon).build().perform();
			    Thread.sleep(1000);
			
			 System.out.println("userpage method is calling in class app ");

			manageUser_icon.click();
			Thread.sleep(2000);
			String totalUser=totalUser_available.getText();
			System.out.println("otal users are available---"+totalUser);
			Thread.sleep(1000);
			addNewUser.click();
			
			String firstname=getDataFromRegExcel("First_name");
	        fistName.sendKeys(firstname);
	        Thread.sleep(1000);
	        String lastnam=getDataFromRegExcel("Last_name");
	        lastname.sendKeys(lastnam);
	        Thread.sleep(1000);
	        String employeeId=getDataFromRegExcel("Emp_id");
	        empID.sendKeys(employeeId);
	        Thread.sleep(1000);
	        String official_email=getDataFromRegExcel("email");
	        official_Email.sendKeys(official_email);
	        Thread.sleep(1000);
	        generate_loginID.click();
	        Thread.sleep(3000);
	        UtilPage.getScreenshot("generate login id");
	        String code=getDataFromRegExcel("Rto_code");
	        RtoCode_tb.sendKeys(code);
	        Thread.sleep(1000);
	        Select user=new Select(select_userType);
	        Thread.sleep(1000);
	        user.selectByIndex(1);
	        Thread.sleep(1000);
	        generate_button.click();
	        Thread.sleep(1000);
	        String pasword=getDataFromRegExcel("password");
	        pwd.sendKeys(pasword);
	        Thread.sleep(1000);
	        String confirmPWD=getDataFromRegExcel("confirm_pwd");
	        confirm_pwd.sendKeys(confirmPWD);
	        
	        Select sel=new Select(userType);
	        Thread.sleep(1000);
	        sel.selectByIndex(1);
	        Thread.sleep(1000);
	        Select role=new Select(roletype);
	        Thread.sleep(1000);
	        role.selectByIndex(1);
	        Thread.sleep(1000);
	        Select design=new Select(designation);
	        Thread.sleep(1000);
	        design.selectByIndex(1);
	        Thread.sleep(1000);
	        String mobile_no=getDataFromRegExcel("mobile");
	        mobile.sendKeys(mobile_no);
//	        Thread.sleep(1000);
//	        String email_ID=getDataFromRegExcel("email");    this functionality is remove after update
//	        email.sendKeys(email_ID);
	        UtilPage.getScreenshot("new user");
	        Thread.sleep(1000);
	        submit.click();
	        Thread.sleep(2000);
	        Manageuser_Test.log(Status.INFO,"Click on suspend user button");
	        suspend_User.click();
	        Thread.sleep(1000);
	        Manageuser_Test.log(Status.INFO,"click on blocked user button");
	        Blocked_User.click();
	        Thread.sleep(1000);
	        Manageuser_Test.log(Status.INFO,"click on Send sms button");
	        send_sms.click();
	        Thread.sleep(2000);
	        selectUser_type.click();
	        Thread.sleep(1000);
	        select_one_user.click();
	        Thread.sleep(1000);
	        choose_second_user.click();
	        Thread.sleep(1000);
	        choose_third_user.click();
	        ClickBlank.click();
	        Thread.sleep(1000);
	        String msg=getDataFromRegExcel("Message");
	        Text_message.sendKeys(msg);
	        Thread.sleep(1000);
	        send_button.click();
	        Thread.sleep(2000);
//	        UtilPage.getScreenshot("message status");
	        System.out.println("message line is run");
	        Thread.sleep(1000);
	        Manageuser_Test.log(Status.INFO,"check functionality of search button");
	        search_user.sendKeys(firstname);
	        search_button.click();
	        Thread.sleep(1000);
	        clickON_search_user.click();
	        System.out.println("you clicked on seraching user sucessfully");
	        
		}
		
		public static Map<String,String> Read_RegExcel() throws IOException {
			
			Workbook bb=new XSSFWorkbook("D:\\Nic_work\\Desktop\\AllClasses_data\\Manage_user_data.xlsx");
			Sheet shet=bb.getSheet("ManageUser");
			Map<String,String> mp=new HashMap<String,String>();
			Row row=shet.getRow(0);
			int totalcell=row.getLastCellNum();
				for(int j=0;j<totalcell;j++) {
				String key=	shet.getRow(1).getCell(j).getStringCellValue();
				String value=shet.getRow(3).getCell(j).getStringCellValue();
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
