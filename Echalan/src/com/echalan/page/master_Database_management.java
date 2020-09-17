package com.echalan.page;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.echalan.base.Runner;
import com.echalan.utility.UtilPage;

public class master_Database_management {
	
	WebDriver driver=Runner.MainDriver;
	ExtentReports masterExtent=Runner.extent;
	ExtentTest masterTest=Runner.logger;
	
	String name,email,pwd1,pwd2;
	JavascriptExecutor js;
	Select sel;

   
	
	@FindBy(xpath="//a[@href='http://164.100.161.91/echallan/circle']")
	private WebElement master_db_MGMT_icon;
	
	@FindBy(xpath="//a[@id='newUser']")
	private WebElement addUser;
	
	@FindBy(xpath="//input[@placeholder='Area']")
	private WebElement Area_tb;  
	
	@FindBy(xpath="//input[@placeholder='Address']")
	private WebElement Address;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submit;
	
	@FindBy(xpath="//a[@class='edit']")
	private WebElement edit;
	
	@FindBy(xpath="//input[@ng-model='circleEdit.circle']")
	private WebElement edit_Area_tb;  
	
	@FindBy(xpath="//input[@ng-model='circleEdit.address']")
	private WebElement edit_Address;
	
	@FindBy(xpath="//*[@id='mainContainer']/div[1]/section[3]/div/div[2]/div/div/form/div[3]/button")
	private WebElement edit_submit;
	
	@FindBy(xpath="//div/div/div[@class='text-xs-left']")
	private WebElement total;
	
	@FindBy(xpath="//i[ text()='add']")
	private WebElement add_icon;
	

	@FindBy(xpath="//a[@href='courts']")      //  court
	private WebElement court;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	private WebElement name_TB;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	private WebElement email_TB;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement pwd1_TB;
	
	@FindBy(xpath="//input[@placeholder='Confirm Password']")
	private WebElement pwd2_TB;
	
	@FindBy(xpath="//input[@placeholder='Address']")
	private WebElement address;
	
	@FindBy(xpath="//select[@ng-model='userForm.rto']")
	private WebElement Location;
	
	@FindBy(xpath="//button[@ng-click='toggleDropdown()']")
	private WebElement select_area;
	
	@FindBy(xpath="//a[@role='menuitem']")
	private WebElement AreaName; 
	
	@FindBy(xpath="//div[@class='row']/div[@class='col s12']")
	private WebElement blank_click;
	
	@FindBy(xpath="//div/button[@type='submit']")
	private WebElement court_submit;
	
	@FindBy(xpath="//i[@class='fa fa-remove fa-2x text-warning']")
	private WebElement court_delete;
	
	@FindBy(xpath="//a[@href='designation']")    // designation
	private WebElement Designation;
	
	@FindBy(xpath="//input[@id='designation']")
	private WebElement Designation_TB;
	
	@FindBy(xpath="//button[@ng-disabled='isEmailExist']")
	private WebElement Designation_submit;
	
	@FindBy(xpath="//i[@class='fa fa-remove fa-2x text-warning']")
	private WebElement Designation_delete;        
	
	@FindBy(xpath="//a[@href='officers']")   // officer
	private WebElement officer;
	
	@FindBy(xpath="//*[@id='tabs-swipe-delhi']/li[2]/a")
	private WebElement Clerk;
	
	@FindBy(xpath="//*[@id='tabs-swipe-delhi']/li[3]/a")
	private WebElement Cashier;
	
	@FindBy(xpath="//*[@id='tabs-swipe-delhi']/li[4]/a")        // edit button
	private WebElement dept_user; 
	
	@FindBy(xpath="//div[@id='test-swipe-2']//i[@class='fa fa fa-pencil-square-o fa-2x text-success']")
	private WebElement edit_button;
	
	@FindBy(xpath="(//input[@id='first_name'])[2]")
	private WebElement update_name;
	
	@FindBy(xpath="//div/button[contains(text(),'Update')]")
	private WebElement update_button;
	
	@FindBy(xpath="(//div[@id='test-swipe-2']//i[@class='fa fa-remove fa-2x text-warning'])[4]")
	private WebElement delete_button;      
	                                                //delete department officer
	
	
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement yes_Delete;
	
	@FindBy(xpath="//input[@placeholder='Employee ID']")
	private WebElement emp_id;
	
	@FindBy(xpath="//input[@placeholder='Full Name']")
	private WebElement full_name;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement officer_mail;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement officer_pwd1_TB;  
	
	@FindBy(xpath="//input[@placeholder='Confirm Password']")
	private WebElement officer_pwd2_TB;
	
	@FindBy(xpath="//select[@id='userType']")
	private WebElement userType_dropdown;
	
	@FindBy(xpath="//select[@id='rto']")
	private WebElement RTO_dropdown;
	
	@FindBy(xpath="//select[@class='form-control ng-pristine ng-untouched ng-valid']")
	private WebElement ARTO_dropdown;
	
	@FindBy(xpath="//select[@id='role']")
	private WebElement Role_dropdown;
	
	@FindBy(xpath="//select[@id='designation']")
	private WebElement designation_dropdown;
	
	
	@FindBy(xpath="//input[@id='mob_no']")
	private WebElement mobile;
	
	@FindBy(xpath="//*[@id='newRoleForm']/div[15]/div/button")
	private WebElement officer_submit; 
	
	
	
	
	
	 public master_Database_management() throws InterruptedException {
		// TODO Auto-generated constructor stub
	
		 
		
        PageFactory.initElements(driver,this);
        Actions act=new Actions(driver);
	    act.moveToElement(add_icon).build().perform();
	    Thread.sleep(1000);
		master_db_MGMT_icon.click();
		Thread.sleep(5000);
		js=((JavascriptExecutor)driver);
		
 }
	  
		
	 @Test
		public void Area_module() throws InterruptedException, IOException{
			masterTest=masterExtent.createTest("Master database Management");
			masterTest.log(Status.INFO,"plz add an area");
			Actions act=new Actions(driver);
		    act.moveToElement(add_icon).build().perform();
		    Thread.sleep(1000);
			master_db_MGMT_icon.click();
			Thread.sleep(5000);
			System.out.println("Area module is starting");
			Thread.sleep(8000);
			js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();", addUser);
			Thread.sleep(2000);
			masterTest.log(Status.INFO,"check area functionality by add an area");
			String Area=getDataFromRegExcel("Area");
			Area_tb.sendKeys(Area);
			String addres=getDataFromRegExcel("Address");
			Address.sendKeys(addres);
			submit.click();
			Thread.sleep(2000);
			edit.click();
			Thread.sleep(2000);
			masterTest.log(Status.INFO,"edit an area");
			edit_Area_tb.clear();
			String newArea=getDataFromRegExcel("new_Area");
			edit_Area_tb.sendKeys(newArea);
			edit_Address.clear();
     		String newAddres=getDataFromRegExcel("new_Address");
			edit_Address.sendKeys(newAddres);
			edit_submit.click();
			System.out.println("area updated successfully");
			Thread.sleep(4000);
		    System.out.println("Area module is end");

		}   
		
		
		

		@Test
		public void Designation_module() throws InterruptedException, IOException{
			
		    System.out.println("designation module is starting");
		    masterTest.log(Status.INFO,"check designation functionality by add an dsignation");

			Designation.click();
			Thread.sleep(3000);
		    js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();", addUser);
			Thread.sleep(3000);
			String des=getDataFromRegExcel("Designation");
			Designation_TB.sendKeys(des);
			Thread.sleep(1000);
			Designation_submit.click();
			Thread.sleep(2000);
			masterTest.log(Status.INFO,"delete an designtion");

			Designation_delete.click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			String available_oficer=total.getText();
			System.out.println("total designation are---"+available_oficer);
		    System.out.println("designation module is ended");
		}
		     
		
		
		
		
		@Test
		public void Court_module() throws InterruptedException, IOException{
			
		    System.out.println("court module is starting");
			court.click();
			Thread.sleep(5000);
			
		    js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();", addUser);
			Thread.sleep(3000);
			masterTest.log(Status.INFO,"check Courts functionality by add a Courts");

		    name=getDataFromRegExcel("Name");
	    	name_TB.sendKeys(name);
			email=getDataFromRegExcel("Email");
			email_TB.sendKeys(email);
		    pwd1=getDataFromRegExcel("Password1");
			pwd1_TB.sendKeys(pwd1);
			pwd2=getDataFromRegExcel("Password2");
			pwd2_TB.sendKeys(pwd2);
			String add=getDataFromRegExcel("Address");
			address.sendKeys(add);
			Thread.sleep(1000);
		    sel=new Select(Location);                //location is not working
			sel.selectByValue("0");
			Thread.sleep(1000);
			select_area.click();
			Thread.sleep(2000);
			AreaName.click();
			Thread.sleep(1000);
			address.click();
			Thread.sleep(2000);
			UtilPage.snapshot("Courts");
			court_submit.click();
			Thread.sleep(3000);
			String available_oficer=total.getText();
			System.out.println("total Court are---"+available_oficer);
		    System.out.println("court module is ended");
			
		}
		
		
		
		
		
		@Test
		public void officers_module() throws InterruptedException, IOException{
			
		    System.out.println("officer module is starting");
		    masterTest.log(Status.INFO,"check Officers functionality");
		    driver.navigate().refresh();

			officer.click();
			Thread.sleep(5000);
			String available_oficer=total.getText();
			System.out.println("total officer are---"+available_oficer);
			Clerk.click();
			masterTest.log(Status.INFO,"clerk");
			Thread.sleep(2000);
			masterTest.log(Status.INFO,"Cashier");

			Cashier.click();
			Thread.sleep(2000);
			dept_user.click();
			masterTest.log(Status.INFO,"check Department");
			Thread.sleep(4000);
			masterTest.log(Status.INFO,"update a user in department");
			edit_button.click();        // check update functionality in department user
			Thread.sleep(2000);
			update_name.clear();
			String newName=getDataFromRegExcel("Update_Name");
			update_name.sendKeys(newName);
			update_button.click();
			Thread.sleep(4000);
			dept_user.click();
			Thread.sleep(4000);
			masterTest.log(Status.INFO,"delete a user in department");
			delete_button.click();        // check delete functionality in department user
			Thread.sleep(2000);
			UtilPage.getScreenshot("delete screenshot");
			yes_Delete.click();
			Thread.sleep(4000);
			
			
			js=((JavascriptExecutor)driver);       // check + icon functionality in Mas_DB_mgmt_page
			js.executeScript("arguments[0].click();", addUser);
			Thread.sleep(2000);
			masterTest.log(Status.INFO,"add a new user in department");
			String empID=getDataFromRegExcel("Employee_Id");
			emp_id.sendKeys(empID);
			full_name.sendKeys(name);
			officer_mail.sendKeys(email);
			officer_pwd1_TB.sendKeys(pwd1);
			officer_pwd2_TB.sendKeys(pwd2);
			sel=new Select(userType_dropdown);
			sel.selectByIndex(1);
			Thread.sleep(1000);
			RTO_dropdown.click();
			Thread.sleep(1000);
			sel=new Select(RTO_dropdown);
			Thread.sleep(1000);
			sel.selectByIndex(1);
			Thread.sleep(1000);
			sel=new Select(ARTO_dropdown);
			Thread.sleep(1000);
			sel.selectByIndex(1);
			Thread.sleep(1000);
			sel=new Select(Role_dropdown);
			Thread.sleep(1000);
			sel.selectByIndex(1);
			Thread.sleep(1000);
			sel=new Select(designation_dropdown);
			Thread.sleep(1000);
			sel.selectByIndex(1);
			Thread.sleep(1000);
			String mob=getDataFromRegExcel("Mobile");
			Thread.sleep(1000);
			mobile.sendKeys(mob);
			UtilPage.snapshot("add new officer in mdm");
			Thread.sleep(1000);
			officer_submit.click();
		    System.out.println("officers module is ended");
			
			
		}
		
		public  Map<String,String> Read_RegExcel() throws IOException {
			
			Workbook bb=new XSSFWorkbook("D:\\Nic_work\\Desktop\\AllClasses_data\\Master_db_mgmt_data.xlsx");
			Sheet shet=bb.getSheet("ManageDb_Mgmt");
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
		public String getDataFromRegExcel(String key) throws IOException {
			
			Map<String,String> data=Read_RegExcel();
			String value=data.get(key);
			return value;

		}
}