package com.echalan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class MobileDevice_Manager {
	
	WebDriver homedriver=Runner.MainDriver;
	ExtentReports mobileDevice_Extent=Runner.extent;
	ExtentTest mobileDevice_Test=Runner.logger;
	JavascriptExecutor js;
	 Actions act;
	
	
	
	@FindBy(xpath="//i[ text()='add']")
	private WebElement add_icon;
	
	@FindBy(xpath="//a[@href='http://164.100.161.91/echallan/manage-device']")
	private WebElement Mobile_Device_icon;
	
	
	@FindBy(xpath="//*[@id=\"accordion3\"]/div[2]/div[1]/div/a/i")
	private WebElement Approved_First;
	
	@FindBy(xpath="//*[@id='accordion3-1']/div/div/div/div[2]/div/a")
	private WebElement deleteApprovedsuspend;
	
	@FindBy(xpath="//*[@class='swal2-input']")
	private WebElement reason_TB;
	
	@FindBy(xpath="//button[@class='swal2-cancel swal2-styled']")
	private WebElement cancel;
	
	@FindBy(xpath="//button[@class='swal2-confirm swal2-styled']")
	private WebElement submit;
	
	@FindBy(xpath="//*[@id='accordion3']/div[3]/div[1]/div/a")
	private WebElement Suspend_device;
	
	@FindBy(xpath="//div[@class='card-head']")
	private WebElement blank_click;
	
	@FindBy(xpath="//*[@id=\"accordion5\"]/div[2]/div[1]/div/a")
	private WebElement Suspend_first;
	
	
	@FindBy(xpath="//*[@id='accordion5-0']/div/div/div/div[2]/div/a[1]")
	private WebElement SuspendDevice_sendToApproved;
	
	@FindBy(xpath="//button[@class='swal2-cancel swal2-styled']")
	private WebElement SuspendDevice_sendToApproved_cancel;
	
	@FindBy(xpath="//button[@class='swal2-confirm swal2-styled']")
	private WebElement SuspendDevice_sendToApproved_submit;
	
	@FindBy(xpath="//*[@id='accordion5-0']/div/div/div/div[2]/div/a[2]")
	private WebElement deleteSuspendDevice;
	
	@FindBy(xpath="//*[@id='accordion4']/div[2]/div[1]/div/a")
	private WebElement pendingForApproval;
	
	@FindBy(xpath="//*[@id='accordion4-0']/div/div/div/div[2]/div/a[1]")
	private WebElement pendingForApproval_approveRequestDevice;
	
	@FindBy(xpath="//*[@id='accordion4-0']/div/div/div/div[2]/div/a[2]")
	private WebElement pendingForApproval_RemoveRequest;
	
	@FindBy(xpath="//*[@id=\"accordion6\"]/div[2]/div[1]/div/a")
	private WebElement Reject_first1;
	
	@FindBy(xpath="//*[@id=\"accordion6\"]/div[2]/div[1]/div/a")
	private WebElement Reject_first;
	
	@FindBy(xpath="//*[@id=\"accordion6\"]/div[2]/div[1]/div/a")
	private WebElement Reject_first2;
	
	
	@FindBy(xpath="//*[@id=\"accordion6\"]/div[3]/div[1]/div/a/i")
	private WebElement Reject_second;
	
	
	
	
	
	public MobileDevice_Manager(){
		
		 PageFactory.initElements(homedriver,this);
		}

	public void AllMethod() throws Exception {
		
		ApprovedDevices();
		suspend_device();
		PendingForApproval();
	}
	
	public void ApprovedDevices() throws Exception {
		
		
		  Thread.sleep(1000);
		   act=new Actions(homedriver);
		  act.moveToElement(add_icon).build().perform();
		  js = (JavascriptExecutor) homedriver;
	        
		 Thread.sleep(1000);
		 Mobile_Device_icon.click();
		 Thread.sleep(5000);
		 Approved_First.click(); 
		 Thread.sleep(2000);
		 js.executeScript("arguments[0].click();",deleteApprovedsuspend);
		 Thread.sleep(2000);
		 reason_TB.sendKeys("due to wrong data");
		 Thread.sleep(1000);
		 cancel.click();
		 Thread.sleep(1000);
//		 js.executeScript("arguments[0].click();",deleteApprovedsuspend);
//		 Thread.sleep(2000);
//		 reason_TB.sendKeys("due to wrong data");
//		 Thread.sleep(1000);	 
//		 submit.click();
		 
	}
	
	public void suspend_device() throws InterruptedException{
		 Suspend_device.click(); 
		 Thread.sleep(3000);
		 js.executeScript("arguments[0].click();",SuspendDevice_sendToApproved);
		 Thread.sleep(2000);
		 SuspendDevice_sendToApproved_cancel.click();
		 Thread.sleep(2000);
		 js.executeScript("arguments[0].click();",deleteSuspendDevice);
		 reason_TB.sendKeys("due to wrong data");
		 Thread.sleep(1000);
		 cancel.click();
		 Thread.sleep(1000);
//		 js.executeScript("arguments[0].click();",deleteApprovedsuspend);
//		 Thread.sleep(2000);
//		 reason_TB.sendKeys("due to wrong data");
//		 Thread.sleep(1000);	 
//		 submit.click();
		 
	}
		 public void PendingForApproval() throws InterruptedException{
			 pendingForApproval.click(); 
			 Thread.sleep(3000);
			 js.executeScript("arguments[0].click();",pendingForApproval_approveRequestDevice);
			 Thread.sleep(2000);
			 SuspendDevice_sendToApproved_cancel.click();
			 Thread.sleep(2000);
			 js.executeScript("arguments[0].click();",pendingForApproval_RemoveRequest);
			 reason_TB.sendKeys("due to wrong data");
			 Thread.sleep(1000);
			 cancel.click();
			 Thread.sleep(1000);
//			 js.executeScript("arguments[0].click();",deleteApprovedsuspend);
//			 Thread.sleep(2000);
//			 reason_TB.sendKeys("due to wrong data");
//			 Thread.sleep(1000);	 
//			 submit.click();

	}
	
	
	public void ScrollDown() {
		
		JavascriptExecutor js = (JavascriptExecutor) homedriver;
        js.executeScript("window.scrollBy(0,350)", "");
	}
}
/*
	
	@Test
	public void function() throws InterruptedException{
		
		mobileDevice_Test=mobileDevice_Extent.createTest("Job Allocate");
		mobileDevice_Test.log(Status.INFO,"create a team");
		
		Actions action = new Actions(homedriver);
		WebElement btn = homedriver.findElement(By.xpath(" //i[contains(text(),'add')]"));
		action.moveToElement(btn).build().perform();
		Thread.sleep(1000);
		
		WebElement btn_100 = homedriver.findElement(By.xpath("//i[contains(text(),'phonelink_setup')]"));
		btn_100.click();
		Thread.sleep(3000);
		
		Actions action101 = new Actions(homedriver);
		WebElement btn101 = homedriver.findElement(By.xpath(" //i[@class='fa fa-angle-down']"));
		action.moveToElement(btn101).build().perform();
		Thread.sleep(2000);
		btn101.click();
		Thread.sleep(2000);
		WebElement btn_10 = homedriver.findElement(By.xpath("//i[@class='fa fa-trash-o']"));
		btn_10.click();
		Thread.sleep(2000);
		
		WebElement btn_11 = homedriver.findElement(By.xpath("//button[@class='swal2-cancel swal2-styled']"));
		btn_11.click();
		Thread.sleep(2000);
}
	}  */


