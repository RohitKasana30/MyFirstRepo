package com.echalan.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.echalan.base.Runner;


public class Screenshot
{
	 public static String path;
		public static String getScreenshot()
		{
			
			Runner reg = new Runner();
			WebDriver driver = Runner.MainDriver;
			Date d = new Date();
			String fileName = d.toString().replace(":", "_").replace(" ", "_")+".png";

			TakesScreenshot ts=(TakesScreenshot) driver;
			
			File src=ts.getScreenshotAs(OutputType.FILE);
			
			path=System.getProperty("user.dir")+"/Screenshot/"+fileName;
			System.out.println(path);
			
			File destination=new File(path);
			
			try 
			{
				FileUtils.copyFile(src, destination);
			} catch (IOException e) 
			{
				System.out.println("Capture Failed "+e.getMessage());
			}
			
			return path;
		}
		
	
	
	
	
	

}
