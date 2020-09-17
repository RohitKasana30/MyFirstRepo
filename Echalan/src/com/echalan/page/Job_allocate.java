package com.echalan.page;

import java.io.IOException;

import org.openqa.selenium.By;
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


public class Job_allocate {
	
	public WebDriver homedriver=Runner.MainDriver;
	ExtentReports jobExtent=Runner.extent;
	ExtentTest jobTest=Runner.logger;	

	@FindBy(xpath="//i[ text()='add']")
	private WebElement add_icon;
	
	@FindBy(xpath="//a[@class='btn-floating blue darken-1']")
	private WebElement jobAllocate_icon;
	
	@FindBy(xpath="//a[@title='Create new Job Team']")
	private WebElement addNewteam;
	
	@FindBy(xpath="//input[@id='teamName']")
	private WebElement team_tb;
	
	@FindBy(xpath="//button[@ng-click='toggleDropdown()']")
	private WebElement dropdown_list;
	
	@FindBy(xpath="//ul/li[@role='presentation'][5]")
	private WebElement select_officer;
	
	@FindBy(xpath="(//button[@class='btn red waves-effect waves-light'])[2]")
	private WebElement submit;
	
	@FindBy(xpath="//a[@title='total challans']")
	private WebElement totalChallanButton;
	
	@FindBy(xpath="//a[@class='btn btn-icon-toggle reAssignJob']")
	private WebElement newTeamJob;
	
	@FindBy(id="autocomplete")
	private WebElement address;
	
	@FindBy(id="dateTime")
	private WebElement startDate;
	
	@FindBy(id="toDateTime")
	private WebElement EndDate;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement submit2;
	
	
	
	  public Job_allocate() {
		// TODO Auto-generated constructor stub
		 
	        PageFactory.initElements(homedriver,this);
			
		}


	
	
	
	@Test
	public  void  Job_allocatemethod() throws InterruptedException {
		jobTest=jobExtent.createTest("Job Allocate");
		jobTest.log(Status.INFO,"create a team");
		
	    Actions act1=new Actions(homedriver);
	    act1.moveToElement(add_icon).build().perform();
	    Thread.sleep(1000);
		act1.moveToElement(jobAllocate_icon).click().build().perform();
		Thread.sleep(3000);
		act1.moveToElement(addNewteam).click().build().perform();
		Thread.sleep(2000);
		team_tb.sendKeys("rohit2");
		dropdown_list.click();
		Thread.sleep(2000);
		select_officer.click();
		Thread.sleep(2000);
		submit.click();
		Thread.sleep(2000);
		totalChallanButton.click();
		Thread.sleep(2000);
		newTeamJob.click();
		Thread.sleep(1000);
		address.click();
		address.sendKeys("noida");
		Thread.sleep(1000);
		startDate.sendKeys("2020/04/06 15:00");
		Thread.sleep(1000);
		EndDate.sendKeys("2020/04/05 17:00");
		Thread.sleep(1000);
		submit2.click();

	



	}



}
