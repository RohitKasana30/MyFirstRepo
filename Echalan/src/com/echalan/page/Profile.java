package com.echalan.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.echalan.base.Runner;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Profile {

		
		

	WebDriver driver=Runner.MainDriver;
	ExtentReports Pofile_Extent=Runner.extent;
	ExtentTest Profile_Test=Runner.logger;
			
			/*@FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/ul[2]/li/a")
			private WebElement profile;
			
			@FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/ul[2]/li/ul/li[2]/a")
			private WebElement myProfile;
			
			@FindBy(id = "reset")
			private WebElement reset;
			
			public Profile()
			{
				this.driver = driver;
				PageFactory.initElements(driver,this);
			}*/
			
			
	       @Test
			public void profile() throws Exception
			{
				Profile_Test=Pofile_Extent.createTest("Profile");
				
				driver.findElement(By.xpath("//*[@id='header']/div/div[2]/ul[2]/li/a")).click();
				Thread.sleep(1000); 
				driver.findElement(By.xpath("//*[@id='header']/div/div[2]/ul[2]/li/ul/li[2]/a")).click();
				Thread.sleep(1000);   
				Profile_Test.log(Status.INFO,"reset the pasword");
				driver.findElement(By.id("reset")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("old_pass")).sendKeys("*7Blackbird");
				Thread.sleep(1000);
			    driver.findElement(By.id("new_pass")).sendKeys("*7Blackbird1");
			    Thread.sleep(1000);
			    driver.findElement(By.id("confirm_pass")).sendKeys("*7Blackbird1");
			    Thread.sleep(1000);
			    driver.findElement(By.id("cancel")).click();
			    
				/*try {
					
					Thread.sleep(1000);
					profile.click();
				}
				catch(Exception e)
				{
					
				}
				
				Thread.sleep(1000);
				myProfile.click();
				Thread.sleep(1000);
				reset.click();
				*/
				
			}
			
	       @Test
			public void update() throws Exception
			{
				Profile_Test.log(Status.INFO,"update the profile");
				driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/ul[2]/li/a")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/ul[2]/li/ul/li[2]/a")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("reset")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("old_pass")).sendKeys("*7Blackbird");
				Thread.sleep(1000);
			    driver.findElement(By.id("new_pass")).sendKeys("*7Blackbird1");
			    Thread.sleep(1000);
			    driver.findElement(By.id("confirm_pass")).sendKeys("*7Blackbird1");
			    Thread.sleep(1000);
			}
			
	       @Test
			public void Process_flow() throws Exception
			{
				Profile_Test.log(Status.INFO,"process flow of profile");
				driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/ul[2]/li/a")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/ul[2]/li/ul/li[4]/a/span")).click(); //profile_flow
				Thread.sleep(1000);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(2000,25000)");
				Thread.sleep(5000);
				driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/button[1]")).click();  //ok btn
			}
			
	       @Test
			public void logout() throws InterruptedException
			{
				Profile_Test.log(Status.INFO,"logout the profile");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/ul[2]/li/a")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/ul[2]/li/ul/li[6]/a")).click();
			}

		}


	
