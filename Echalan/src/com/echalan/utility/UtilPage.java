package com.echalan.utility;



	import java.io.File;
import java.io.IOException;
	import java.util.Date;

	import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

	import com.echalan.base.Runner;
import com.echalan.page.Manual_chalan;

import ru.yandex.qatools.ashot.AShot;
	import ru.yandex.qatools.ashot.Screenshot;
	import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

	public class UtilPage extends Runner {
		
	//	public WebDriver utildriver=Runner.MainDriver;

		public static String propertiesPATH="src\\com\\echalan\\config\\config.properties";
		public static String htmlrepoterPATH=".//Report//EchallanReport.html";
		public static String browserPATH="C:\\Users\\Administrator\\Downloads\\chromedriver_win32 (83)\\chromedriver.exe";
		
		public static void snapshot(String name) throws IOException{
			
			 Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(MainDriver);
			    ImageIO.write(fpScreenshot.getImage(),"PNG",new File("C:\\Users\\Administrator\\Desktop\\Screnshot\\"+name+".png"));
		        
		}

		public static void getScreenshot(String text) throws IOException
		{
			
			Date d = new Date();
			//String fileName = d.toString().replace(":", "_").replace(" ", "_")+".png";

			TakesScreenshot ts=(TakesScreenshot)MainDriver;
			
			File src=ts.getScreenshotAs(OutputType.FILE);
			
			String path=".//Screenshot//"+text+".png";
					
			File destination=new File(path);
			
				FileUtils.copyFile(src, destination);

	} 
		public static void getScrenshot(String text) throws IOException
		{
			File src1=((TakesScreenshot)MainDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src1,new File(".//Screenshot//"+text+".png"));
		}
		
		}


