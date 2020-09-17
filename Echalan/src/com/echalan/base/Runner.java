package com.echalan.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.echalan.page.BookStockManagement;
import com.echalan.page.Challan_History;
import com.echalan.page.Court_Challan;
import com.echalan.page.Dashboard;
import com.echalan.page.Job_allocate;
import com.echalan.page.Login;
import com.echalan.page.ManageUser;
import com.echalan.page.Manage_Role;
import com.echalan.page.Manual_chalan;
import com.echalan.page.MobileDevice_Manager;
import com.echalan.page.Profile;
import com.echalan.page.master_Database_management;
import com.echalan.utility.Screenshot;
import com.echalan.utility.UtilPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Runner {

	public static WebDriver MainDriver=null;
    Properties config = new Properties();
    FileInputStream fis;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentHtmlReporter htmlrepoter;
	Login log;
	Profile pro;

	
	

	@BeforeTest
	public void Browser() throws InterruptedException, IOException {

		htmlrepoter = new ExtentHtmlReporter(".//Report//EchallanReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlrepoter);
		logger = extent.createTest("browser");
		fis = new FileInputStream(".//src//com//echalan//config//config.properties");
		config.load(fis);
		String browser = config.getProperty("browser");
		
		String url = config.getProperty("url");		
		
		if (browser.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Downloads\\chromedriver_win32 (83)\\chromedriver.exe");
//		    MainDriver=new ChromeDriver();

			WebDriverManager.chromedriver().setup();
			MainDriver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
		}
		else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			MainDriver = new FirefoxDriver();
			FirefoxOptions options=new FirefoxOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);

		} 
		else if (browser.equals("ie")) {

			WebDriverManager.iedriver().setup();
			MainDriver = new InternetExplorerDriver();
		} 
		else {
			System.out.println("No browser value is given");
		}
		MainDriver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		
		MainDriver.manage().window().maximize();
		MainDriver.manage().deleteAllCookies();
		MainDriver.get(url);
		Thread.sleep(10000);
     logger.log(Status.INFO, "Browser is launch successfully");
     logger.info("browser is launching");
	}
      
	
	

	@Test
	public void Loginn() throws Exception {
		
	
		  
			log=new Login();
			log.login();
			
		    pro=new Profile();
			pro.profile();
			pro.update();
			pro.Process_flow();
			pro.logout();
			
			log.login();
			
			Thread.sleep(2000);
			Dashboard dash=new Dashboard();
			dash.dashboard();
   	   
   	   
		      Thread.sleep(2000);
		      Challan_History chalan=new Challan_History(); 
              chalan.AllMethod();
      
		
    			Thread.sleep(2000);
    			ManageUser manag=new ManageUser();
    			manag.userPage();
    	     
       
   	
    			Thread.sleep(2000);
		
    			master_Database_management a=new master_Database_management();
    			a.Area_module();
    			a.Designation_module();
    			a.Court_module();
    			a.officers_module();
      
			Thread.sleep(2000);
			Job_allocate job=new Job_allocate();
			job.Job_allocatemethod();
	
			Court_Challan cc=new Court_Challan(MainDriver);
			cc.allMethod();
	     	
	    	Thread.sleep(2000);
	    	MobileDevice_Manager mob=new MobileDevice_Manager();
	    	mob.AllMethod();
	  			
	    	Thread.sleep(2000);
	    	BookStockManagement book=new BookStockManagement();
	    	
	    	book.AllMethod();
	    	   
			Thread.sleep(2000);
			Manage_Role role=new Manage_Role();
			role.CreateRole();
//			role.RoleName();
			role.Edit();
//			role.Edit_update();
	    	
			pro.logout();
	      
	       }
	     
	      /* 
	      
	       public void manual_chalan() throws IOException, InterruptedException{
	    	   
	    	   log.ManualChalanlogin();
	    	   Manual_chalan man=new Manual_chalan();
	    	   man.submit_without_Fill();
	    	   man.challan_without_engineNO_005();
	    	   man.challan_without_chasisNO_006();
	    	   man.challan_without_ImpoundDocument_017();
	    	   man.challan_without_selectAccusedType_009();
	    	   man.challan_without_driverName_010();
	    	   man.without_fatherName_011();
	    	   man.without_courtAndDate_019();
	    	   man.without_court_020();
	    	   man.ImppoundDocument_with_witness_025();
	    	   man.witnessAnd_sentToCourt_026();
	    	   man.submitAndNo_027();
	    	   man.slectNoAfterSubmit_028();
	    	   man.m();
	    	   
	       }   
	
       */ 

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String temp = Screenshot.getScreenshot();
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ",
			 ExtentColor.RED));
			logger.fail("Invalid username or password", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			 logger.fail(result.getThrowable());
			extent.flush();
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ",
			 ExtentColor.GREEN));
		} else {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ",
			 ExtentColor.ORANGE));
			logger.skip(result.getThrowable());
		}
		
	}
	           
	

	@AfterTest
	public void last() {
		extent.flush();
	}
		}
