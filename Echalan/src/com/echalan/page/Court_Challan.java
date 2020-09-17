package com.echalan.page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class Court_Challan {
	
		 
			WebDriver driver;		

			 
			@FindBy(xpath="//i[ text()='add']")
			private WebElement add_icon;
			
			@FindBy(xpath="//a[@href='http://164.100.161.91/echallan/court-challan']")
			private WebElement court_icon;
			 
			
			@FindBy(xpath = "//span[@class='select2-selection__arrow']")
			private WebElement CourtType;
			
			@FindBy(xpath = "//ul/li[text()='Sent To Court']")
			private WebElement senttocourt;
			
			@FindBy(xpath="//span[@id='select2-statusFilter-container']")
			private WebElement notsenttocourt;
			
			
			@FindBy(xpath="//span[@class='hide-on-med-and-down']")
			private WebElement blankClick;
			
			@FindBy(xpath="(//span[@class='select2-selection__arrow'])[2]")
			private WebElement sourceofchallan;
			
			@FindBy(xpath="//ul/li[text()='Device Challan']")
			private WebElement Device;
			
			@FindBy(xpath="//ul/li[text()='Manual Challan']")
			private WebElement Manual;
			
			@FindBy(xpath="//ul/li[text()='CCTV Challan']")
			private WebElement CCTV;
			
			@FindBy(xpath="//*[@id='filterPanel']/div/div/div/div[2]/div/div[3]/div/span")
			private WebElement offence;
			
			@FindBy(xpath="//ul/li[@class='select2-results__option'][15]")
			private WebElement offenceType;
			
			@FindBy(xpath="//*[@id='filterPanel']/div/div/div/div[1]/div/div[4]/div[1]/a/i")
			private WebElement searchbtn;
			
			@FindBy(xpath = "//*[@id=\"filterPanel\"]/div/div/div/div[1]/div/div[4]/div[2]/a/i")
			private WebElement reset;
			
			@FindBy(id = "datepicker_st")
			private WebElement startdate;
			
			@FindBy(id = "datepicker_en")
			private WebElement enddate;
			
			@FindBy(id="datepicker_fwd")
			private WebElement fwd;
			
	
			public Court_Challan(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
				
			}
			
			public void allMethod() throws Exception{
			
				crtchlan_reset();
				crtchlan_manual();
//				crtchlan_device();
//				crtchlan_CCTV();
//				Sent_To_Court_Manual();
//				Sent_To_Court_Device();
//				Sent_To_Court_CCTV();
//				With_Blank();
//				Without_StartDate();
//				Without_EndtDate();
//				Without_Forwarddate();
//				Without_ChallanSource();
				

				
			}
			
			
			
			public void crtchlan_reset() throws Exception             // Test Case_1
			{
				Thread.sleep(2000);
				add_icon.click();
				Thread.sleep(2000);
				 WebDriverWait w=new WebDriverWait(driver, 5);
				 w.until(ExpectedConditions.visibilityOf(court_icon));
				 court_icon.click();
				Thread.sleep(1000);
				startdate.sendKeys("2019/09/01 00:00");
				Thread.sleep(1000);
				enddate.sendKeys("2019/09/30 23:59");
				Thread.sleep(1000);
				blankClick.click();
				sourceofchallan.click();
				Thread.sleep(1000);
				Manual.click();
				Thread.sleep(1000);
				offence.click();
				Thread.sleep(1000);
				offenceType.click();
				reset.click();
				Thread.sleep(20000);
			}
			
			public void crtchlan_manual() throws Exception                            // Test Case_2
			{
				Thread.sleep(1000);
				driver.navigate().refresh();
				Thread.sleep(3000);
				startdate.sendKeys("2019/09/01 00:00");
				Thread.sleep(1000);
				enddate.sendKeys("2019/09/30 23:59");
				Thread.sleep(1000);
				blankClick.click();
				sourceofchallan.click();
				Thread.sleep(1000);
				Manual.click();
				Thread.sleep(1000);
				offence.click();
				Thread.sleep(1000);
				offenceType.click();
				searchbtn.click();
				Thread.sleep(20000);
				
			}
			public void crtchlan_device() throws Exception                               // Test Case_3
			{
				Thread.sleep(1000);
				driver.navigate().refresh();
				Thread.sleep(3000);
				startdate.sendKeys("2019/09/01 00:00");
				Thread.sleep(1000);
				enddate.sendKeys("2019/09/30 23:59");
				Thread.sleep(1000);
				blankClick.click();
				sourceofchallan.click();
				Thread.sleep(1000);
				Device.click();
				Thread.sleep(1000);
				offence.click();
				Thread.sleep(1000);
				offenceType.click();
				searchbtn.click();
				Thread.sleep(20000);
			}
			
			public void crtchlan_CCTV() throws Exception                                 // Test Case_4
			{
				Thread.sleep(1000);
				driver.navigate().refresh();
				Thread.sleep(3000);
				startdate.sendKeys("2019/09/01 00:00");
				Thread.sleep(1000);
				enddate.sendKeys("2019/09/30 23:59");
				Thread.sleep(1000);
				blankClick.click();
				sourceofchallan.click();
				Thread.sleep(1000);
				CCTV.click();
				Thread.sleep(1000);
				offence.click();
				Thread.sleep(1000);
				offenceType.click();
				searchbtn.click();
				Thread.sleep(20000);
			}
			
			public void Sent_To_Court_Manual() throws Exception                                // Test Case_5
			{
				
				Thread.sleep(1000);
				
				driver.navigate().refresh();
				Thread.sleep(3000);
				CourtType.click();
				Thread.sleep(1000);
				senttocourt.click();
				Thread.sleep(1000);
				startdate.sendKeys("2019/09/01 00:00");
				Thread.sleep(1000);
				enddate.sendKeys("2019/09/30 23:59");
				Thread.sleep(1000);
				fwd.sendKeys("2019/11/10 11:00");
				blankClick.click();
				sourceofchallan.click();
				Thread.sleep(1000);
				Manual.click();
				Thread.sleep(1000);
				offence.click();
				Thread.sleep(1000);
				offenceType.click();
				searchbtn.click();
				Thread.sleep(20000);
				
				
			}
			
			public void Sent_To_Court_Device() throws Exception                                    // Test Case_6
			{

				Thread.sleep(5000);
				
				driver.navigate().refresh();
				Thread.sleep(3000);
				CourtType.click();
				Thread.sleep(1000);
				senttocourt.click();
				Thread.sleep(1000);
				startdate.sendKeys("2019/09/01 00:00");
				Thread.sleep(1000);
				enddate.sendKeys("2019/09/30 23:59");
				Thread.sleep(1000);
				fwd.sendKeys("2019/11/10 11:00");
				blankClick.click();
				sourceofchallan.click();
				Thread.sleep(1000);
				Device.click();
				Thread.sleep(1000);
				offence.click();
				Thread.sleep(1000);
				offenceType.click();
				searchbtn.click();
				Thread.sleep(20000);
				
				
			}
			
			public void Sent_To_Court_CCTV() throws Exception                               // Test Case_7
			{

				Thread.sleep(1000);
				
				driver.navigate().refresh();
				Thread.sleep(3000);
				CourtType.click();
				Thread.sleep(1000);
				senttocourt.click();
				Thread.sleep(1000);
				startdate.sendKeys("2019/09/01 00:00");
				Thread.sleep(1000);
				enddate.sendKeys("2019/09/30 23:59");
				Thread.sleep(1000);
				fwd.sendKeys("2019/11/10 11:00");
				blankClick.click();
				sourceofchallan.click();
				Thread.sleep(1000);
				CCTV.click();
				Thread.sleep(1000);
				offence.click();
				Thread.sleep(1000);
				offenceType.click();
				searchbtn.click();
				Thread.sleep(10000);
				
			}
			
			public void With_Blank() throws Exception                              // Test Case_8
			{
				Thread.sleep(2000);
				driver.navigate().refresh();
				Thread.sleep(4000);
				searchbtn.click();
				Thread.sleep(4000);
			}
			public void Without_StartDate() throws Exception                      // Test Case_9
			{
				Thread.sleep(1000);
				driver.navigate().refresh();
				Thread.sleep(3000);
				Thread.sleep(1000);
				enddate.sendKeys("2019/09/30 23:59");
				Thread.sleep(1000);
				blankClick.click();
				sourceofchallan.click();
				Thread.sleep(1000);
				CCTV.click();
				Thread.sleep(1000);
				offence.click();
				Thread.sleep(1000);
				offenceType.click();
				searchbtn.click();
				Thread.sleep(10000);
			}
			
			public void Without_EndtDate() throws Exception                      // Test Case_10
			{
				Thread.sleep(1000);
				driver.navigate().refresh();
				Thread.sleep(3000);
				Thread.sleep(1000);
				startdate.sendKeys("2019/09/30 23:59");
				Thread.sleep(1000);
				blankClick.click();
				sourceofchallan.click();
				Thread.sleep(1000);
				CCTV.click();
				Thread.sleep(1000);
				offence.click();
				Thread.sleep(1000);
				offenceType.click();
				searchbtn.click();
				Thread.sleep(10000);
			}
			
			public void Without_Forwarddate() throws Exception                    // Test Case_11
			{
	Thread.sleep(1000);
				
				driver.navigate().refresh();
				Thread.sleep(3000);
				CourtType.click();
				Thread.sleep(1000);
				senttocourt.click();
				Thread.sleep(1000);
				startdate.sendKeys("2019/09/01 00:00");
				Thread.sleep(1000);
				enddate.sendKeys("2019/09/30 23:59");
				Thread.sleep(1000);
//				fwd.sendKeys("2019/11/10 11:00");
				blankClick.click();
				sourceofchallan.click();
				Thread.sleep(1000);
				CCTV.click();
				Thread.sleep(1000);
				offence.click();
				Thread.sleep(1000);
				offenceType.click();
				searchbtn.click();
				Thread.sleep(10000);
		}
			
			public void Without_ChallanSource() throws Exception               // Test Case_12
			{
				driver.navigate().refresh();
				Thread.sleep(3000);
				startdate.sendKeys("2019/09/01 00:00");
				Thread.sleep(1000);
				enddate.sendKeys("2019/09/30 23:59");
				Thread.sleep(1000);
				blankClick.click();
				Thread.sleep(1000);
				offence.click();
				Thread.sleep(1000);
				offenceType.click();
				searchbtn.click();
				Thread.sleep(10000);
			}
		}









