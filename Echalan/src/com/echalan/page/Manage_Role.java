package com.echalan.page;

	

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.echalan.base.Runner;

import io.github.bonigarcia.wdm.WebDriverManager;


	public class Manage_Role {
		
		WebDriver driver=Runner.MainDriver;
		ExtentReports managRole_Extent=Runner.extent;
		ExtentTest managRole_Test=Runner.logger;
		@FindBy(xpath="//button[@type='button']")
		private WebElement popup;
		
		@FindBy(xpath="//i[ text()='add']")
		private WebElement add ;
		
		@FindBy(xpath="//a[@class='btn-floating orange accent-2']")
		private WebElement RolePage_icon;
		
		@FindBy(xpath="//*[@id='mainContainer']/div[1]/section/div[1]/div/div[1]/div/div[1]/div/a/i")
		private WebElement newUser;
		
		@FindBy(id="roleName")
		private WebElement newUserNameTB;
		
		@FindBy(xpath="//*[@id='newRoleForm']/div[1]/div[2]/div/div/div[4]/label/span")
		private WebElement activity1;
		
		@FindBy(xpath="//*[@id='newRoleForm']/div[1]/div[2]/div/div/div[6]/label/span")
		private WebElement activity2;
		
		@FindBy(xpath="//*[@id='newRoleForm']/div[1]/div[2]/div/div/div[7]/label/span")
		private WebElement activity3;
		
		@FindBy(xpath="//*[@id='newRoleForm']/div[1]/div[2]/div/div/div[9]/label/span")
		private WebElement activity4;
		
		@FindBy(id="submitRole")
		private WebElement submit;
		
		@FindBy(xpath="//*[@id='accordion3']/div[1]/div[1]/div")
		private WebElement selectUserByArrow;
		
		@FindBy(xpath="//*[@id='accordion3-0']/div/div/div[1]/div[2]/div")
		private WebElement editButton;
		
		@FindBy(xpath="//*[@id='accordion3-0']/div/div/div[2]/div/div[1]/div[1]/input[1]")
		private WebElement updateUser_newName;
		
		@FindBy(xpath="//*[@id='accordion3-0']/div/div/div[2]/div/div[2]/div/button")
		private WebElement updatebutton;
		
		
		
		@Test
		public void CreateRole() throws Exception {
			
			PageFactory.initElements(driver, this);
			System.out.println("managerole method is start");
			 Actions act1=new Actions(driver);
			 act1.moveToElement(add).build().perform();
			 Thread.sleep(1000);
			 JavascriptExecutor js=((JavascriptExecutor)driver);
			 js.executeScript("arguments[0].click();", RolePage_icon);
		     Thread.sleep(5000);
		     newUser.click();
		     Thread.sleep(1000);
		     newUserNameTB.sendKeys("Rohit kasana 8");   // new name
		     Thread.sleep(1000);
		     activity1.click();
		     activity2.click();
		     JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)");
		     submit.click();
		     Thread.sleep(1000);
		     System.out.println("managerole method is end");
		}
		
		@Test
		public void Edit() throws Exception
		{
			System.out.println("edit is start");
			driver.navigate().refresh();
			Thread.sleep(8000);
			selectUserByArrow.click();
			Thread.sleep(1000);
			editButton.click();
			Thread.sleep(1000);
			updateUser_newName.clear();
			Thread.sleep(1000);
			updateUser_newName.sendKeys("Rohit 011");    //update new name
			Thread.sleep(2000);
			updatebutton.click();
	        
			System.out.println("edit is complete");
			
			
		}
		
//		@Test
//		public void RoleName() throws Exception
//		{
//		//	managRole_Test.log(Status.INFO,"create a user");
//			System.out.println("rolename method is start");
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//*[@id='mainContainer']/div[2]/ul/li[10]/a")).click();
//			Thread.sleep(5000);
//			//cross.click();
//			driver.findElement(By.xpath("//*[@id='mainContainer']/div[1]/section/div[1]/div/div[1]/div/div[1]/div/a/i")).click();
//			Thread.sleep(1000);
//			JavascriptExecutor jse1 = (JavascriptExecutor)driver;
//			jse1.executeScript("window.scrollBy(0,250)");
//			Thread.sleep(1000);
//			driver.findElement(By.id("cancel")).click();
//			System.out.println("rolename method is end");
//		}
		
		
		
		
//		@Test
//		public void Edit_update() throws Exception
//		{
//			System.out.println("edit -update is start");
//			Thread.sleep(1000);  
//			driver.findElement(By.xpath("//*[@id='accordion3']/div[1]/div[1]/div/a")).click();
//			Thread.sleep(2000); 
//			driver.findElement(By.xpath("//*[@id='accordion3-1']/div/div/div[2]/div/div[1]/div[1]/input[1]")).clear();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@id='accordion3-1']/div/div/div[2]/div/div[1]/div[1]/input[1]")).sendKeys("manager_3");
//			Thread.sleep(2000);
//		//	driver.findElement(By.xpath("//*[@id='accordion3-9']/div/div/div[2]/div/div[2]/div/button")).click();
//			driver.findElement(By.xpath("//*[@id='accordion3-1']/div/div/div[2]/div/div[2]/div/button")).click();
//
//			
//	//		managRole_Test.log(Status.INFO,"you update successfully");
//			System.out.println("edit-update is complete");
//		}
//	


}
