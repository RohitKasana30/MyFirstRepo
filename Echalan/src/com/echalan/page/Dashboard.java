package com.echalan.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.echalan.base.Runner;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Dashboard {
	
	  WebDriver driver=Runner.MainDriver;
	  ExtentReports dashExtent=Runner.extent;
	  ExtentTest dashTest=Runner.logger;
	


	  @Test
		public  void dashboard() throws Exception 
		{
			dashTest=dashExtent.createTest("Dashboard");
			dashTest.log(Status.INFO,"Dashboard is starting");
			//Select sel=new Select(driver.findElement(By.xpath("//*[@id=\"subscribe\"]/div/filters/div[3]/div[3]/span[1]/span[1]/span")));
			Thread.sleep(5000);
			//sel.selectByIndex(2);
			driver.findElement(By.id("vehicle_number_new")).sendKeys("GJ12Z1119");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"filterPanel\"]/div[1]/div/div/div/div[2]/div[4]/div[1]/a/i")).click();  //search btn
			Thread.sleep(2000);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,500)");
			Thread.sleep(6000);
			driver.findElement(By.id("vehicle_number_new")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("challan_number")).sendKeys("GJ32384191203070950");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"filterPanel\"]/div[1]/div/div/div/div[2]/div[4]/div[1]/a/i")).click();
			Thread.sleep(10000);
			driver.findElement(By.id("challan_number")).clear();
			Thread.sleep(2000);
	/*		driver.findElement(By.id("voilator_name")).sendKeys("ARBHAMBHAI D KUCHH");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"filterPanel\"]/div[1]/div/div/div/div[2]/div[4]/div[1]/a/i")).click();  //search btn
			Thread.sleep(15000);
			driver.findElement(By.id("voilator_name")).clear();
			Thread.sleep(2000);
			driver.findElement(By.id("dl_number")).sendKeys("DL7SZ3561");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"filterPanel\"]/div[1]/div/div/div/div[2]/div[4]/div[1]/a/i")).click();
			Thread.sleep(10000);
			driver.findElement(By.id("dl_number")).clear();                */
			dashTest.log(Status.INFO,"Dashboard run successfully");
			
			
			

		}

	}



