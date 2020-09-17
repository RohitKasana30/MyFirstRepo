package com.echalan.page;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.echalan.base.Runner;
import com.echalan.utility.UtilPage;

public class Login {
	
	WebDriver Login_driver=Runner.MainDriver;
	ExtentReports Login_Extent=Runner.extent;
	ExtentTest Login_Test=Runner.logger;
	ExtentReports ManualChalanLogin_Extent=Runner.extent;
	ExtentTest ManualChalanLogin_Test=Runner.logger;
	
	
	
    	@FindBy(xpath="/html/body/div[1]/div[2]/button")
	    private WebElement first_popup;
		
	    @FindBy(xpath="//button[@type='button']")
	    private WebElement popup;
		
		@FindBy(xpath="//input[@id='userName']")
		private WebElement username;
		
		@FindBy(xpath="//span[@id='next']")
		private WebElement next;
		
		@FindBy(xpath="//input[@id='password']")
		private WebElement password;
		
		@FindBy(xpath="//button[@name='login']")
		private WebElement login;
		

	
		
          public Login(){
		 
	        PageFactory.initElements(Login_driver,this);	
	 }
		
   @Test
	public void login() throws InterruptedException, IOException{
//		Login_Test=Login_Extent.createTest("Login");
//		Login_Test.log(Status.INFO,"remove popup");		
		 System.out.println("login");
		 Actions act = new Actions(Login_driver);
			try {
				first_popup.click();
			popup.click();
			}
			catch(Exception e){
				Login_driver.findElement(By.xpath("//button[@type='button']")).click();
			}
			Thread.sleep(2000);
//			Login_Test.log(Status.INFO,"enter username");
//			String userID=getDataFromRegExcel("UserName");
//			username.sendKeys(userID);
			username.sendKeys("rtoahmedabad01@gmail.com");
			next.click();
		    Thread.sleep(1000);
//		    Login_Test.log(Status.INFO,"enter password");
//		    String pass=getDataFromRegExcel("Password");
//		    Thread.sleep(2000);
//			password.sendKeys(pass); 
			password.sendKeys("*7BlackbirD*");
//			UtilPage.snapshot("overflow of icons in homepage");
			login.click();
//			Login_Test.log(Status.INFO,"login successfully");
			Thread.sleep(3000);
			 System.out.println("login successfully");
//			Actions act1=new Actions(Login_driver);
//		    act1.moveToElement(add_icon).build().perform();
//		    Thread.sleep(1000);
		    
	}
   
   @Test
  	public void ManualChalanlogin() throws InterruptedException, IOException{
	   ManualChalanLogin_Test=ManualChalanLogin_Extent.createTest("Manual challanLogin");
	   ManualChalanLogin_Test.log(Status.INFO,"remove popup");		
  		 System.out.println("login");
  		 Actions act = new Actions(Login_driver);
  			try {
  				Thread.sleep(2000);
  			first_popup.click();
  			popup.click();
  			}
  			catch(Exception e){
  				Login_driver.findElement(By.xpath("//button[@type='button']")).click();
  			}
  			Thread.sleep(2000);
  			ManualChalanLogin_Test.log(Status.INFO,"enter username for manual challan ");
  			username.sendKeys("aimvgj01dbgarchar@nic.com");
  			next.click();
  		    Thread.sleep(1000);
  		  ManualChalanLogin_Test.log(Status.INFO,"enter password for manual challan");
  			password.sendKeys("Dbg@1399");
  			login.click();
  			ManualChalanLogin_Test.log(Status.INFO,"login successfully for manual challan");
  			Thread.sleep(3000);
  			
  		    
  	}
	public  Map<String,String> Read_RegExcel() throws IOException {
		
		Workbook bb=new XSSFWorkbook("C:\\Users\\Administrator\\Desktop\\AllClasses_data\\Master_db_mgmt_data.xlsx");
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
