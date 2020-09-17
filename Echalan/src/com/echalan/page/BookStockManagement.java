package com.echalan.page;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.echalan.base.Runner;

public class BookStockManagement {
	

	public WebDriver driver=Runner.MainDriver;
//	ExtentReports challanHistoryExtent=Runner.extent;
//	ExtentTest challanHistoryTest=Runner.logger;
String bookno;
String minquant;
String maxquant;
String comments;
JavascriptExecutor js;


@FindBy(xpath="//i[ text()='add']")
private WebElement add_icon;

@FindBy(xpath="//ul/li/a[@href='http://164.100.161.91/echallan/challan-book']")
private WebElement class_icon;

@FindBy(xpath="//div/a[@id='newUser']")
private WebElement addNewUser;

@FindBy(xpath="//div/a[@class='btn red waves-effect waves-light cancel']")
private WebElement cancel;

@FindBy(xpath="//div/button[@type='submit']")
private WebElement submit;

@FindBy(xpath="//input[@id='book_no']")
private WebElement bookNo;

@FindBy(xpath="//input[@id='minimum_quantity']")
private WebElement min_quantity;

@FindBy(xpath="//input[@id='maximum_quantity']")
private WebElement max_quantity;

@FindBy(xpath="//input[@id='comment']")
private WebElement commentTB;

@FindBy(xpath="//label[@for='inactive']")
private WebElement inactive;

@FindBy(xpath="//label[@for='inactive']")
private WebElement active;

@FindBy(xpath="//a[@class='edit']")
private WebElement edit;

@FindBy(xpath="//*[@id='mainContainer']/div[1]/section[3]/div/div[2]/div/div/form/div[3]/a")
private WebElement cancelInEdit;

@FindBy(xpath="(//input[@id='maximum_quantity'])[2]")
private WebElement max_quantityInEdit;

@FindBy(xpath="//a[@title='Availabe Forms']")
private WebElement Availabe_form;

@FindBy(xpath="//button[text()='Close']")
private WebElement close;

@FindBy(xpath="//a[@title='Availabe Forms']/following-sibling::a")
private WebElement delete;

@FindBy(xpath="//button[text()='OK']")
private WebElement ok;

@FindBy(xpath="//button[text()='No']")
private WebElement No_delete;

@FindBy(xpath="//button[text()='Yes']")
private WebElement yes_delete;

@FindBy(xpath="//input[@id='search']")
private WebElement search_book;

@FindBy(xpath="//input[@id='datepicker_start']")
private WebElement startDate;

@FindBy(xpath="//input[@id='datepicker_end']")
private WebElement endDate;

@FindBy(xpath="//i[@class='fa fa-search']")
private WebElement search_button;

@FindBy(xpath="(//div/button[@type='submit'])[2]")
private WebElement submitInEdit;

@FindBy(xpath="//i[@class='fa fa-refresh']")
private WebElement reset_button;

@FindBy(xpath="//a[text()='Challan Book Management']")
private WebElement Book_Management;

@FindBy(xpath="//input[@class='select2-search__field']")
private WebElement search_book1;

@FindBy(xpath="//ul[@id='select2-assignBook-results']/li")
private WebElement select_book1;
	

public BookStockManagement(){
	 
	
    PageFactory.initElements(driver,this);
    System.out.println("constructor is running");
   
}	

public void AllMethod() throws InterruptedException, IOException{
	
	System.out.println("all method is running");
  //  bookno=getDataFromRegExcel("Book_no");
    bookno="1101";
	System.out.println(bookno);
	 minquant=getDataFromRegExcel("Min_quant");
	System.out.println(minquant);
	 maxquant=getDataFromRegExcel("Max_quant");
	System.out.println(maxquant);
	 comments=getDataFromRegExcel("comment");
	System.out.println(comments);
	js=((JavascriptExecutor)driver);
	addIconClickTC001and002();
//	addnewUserIconTC003();
//	cancel_TC004();
//	submit_TC005();
//	withoutFillBookNo_TC006();
//	Inactive_TC007();
//	withoutMinQuanity_TC008();
//	withoutMaxQuanity_TC009();
//	withoutFillBookNo_TC0100();
//	FillAndreset_TC011();
//	searchButton_TC012();
//	FillDateAndSearch_TC013();
//	FillallandSearch_TC014();
//	edit_TC015();
//	cancelAfterEdit_TC016();
//	changeAndSubmit_TC017();
//	ClickAvailableForm_TC018();
//	Close_TC019();
//	Delete_TC020();
//	NO_Delete_TC021();
//	yes_Delete_TC022();
	chBookmangmt_TC023();
	addNew_chBookmangmt_TC024();
	cancel_chBookmangmt_TC025();
	submit_TC026();
	addBookandSubmit_TC027();
		
		
	}
	public void addIconClickTC001and002() throws InterruptedException{
		
		 Actions act=new Actions(driver);
		    act.moveToElement(add_icon).build().perform();
		    Thread.sleep(1000);
		    class_icon.click();	
		    Thread.sleep(5000);
	}
	public void addnewUserIconTC003() throws InterruptedException{
		
		//js=((JavascriptExecutor)driver);       
		
		    js.executeScript("arguments[0].click();", addNewUser);
		 //   submit.click();
		    Thread.sleep(1000);
	}
	
	public void cancel_TC004() throws InterruptedException{
		   
//		js.executeScript("arguments[0].click();", addNewUser);
//	    Thread.sleep(1000);
	    cancel.click();
	    Thread.sleep(1000);
	
}
	
	public void submit_TC005() throws InterruptedException{
		  
		Thread.sleep(1000);
	    js.executeScript("arguments[0].click();", addNewUser);
//	    addNewUser.click();
//	    Thread.sleep(1000);
//	    cancel.click();
	    Thread.sleep(1000);
	    submit.click();
	
}
	
	public void withoutFillBookNo_TC006() throws InterruptedException{
		   
		cancel.click();
	    Thread.sleep(1000);
	    js.executeScript("arguments[0].click();", addNewUser);
	    Thread.sleep(2000);
	    min_quantity.sendKeys(minquant);
	   Thread.sleep(1000);
	   max_quantity.sendKeys(maxquant);
	   Thread.sleep(1000);
	   commentTB.sendKeys(comments);
	   Thread.sleep(1000);
	    submit.click();
	
}
	
	public void Inactive_TC007() throws InterruptedException{
		
	//	cancel.click();
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", addNewUser);
		Thread.sleep(3000);
		   bookNo.sendKeys(bookno);
		   Thread.sleep(1000);
		   inactive.click();
		   Thread.sleep(1000);
		   min_quantity.sendKeys(minquant);
		   Thread.sleep(1000);
		   max_quantity.sendKeys(maxquant);
		   Thread.sleep(1000);
		   commentTB.sendKeys(comments);
		   Thread.sleep(1000);
		   submit.click();
	
}
	
	public void withoutMinQuanity_TC008() throws InterruptedException{
		
		js.executeScript("arguments[0].click();", addNewUser);
		Thread.sleep(3000);
		   bookNo.sendKeys(bookno);
		   Thread.sleep(1000);
		   max_quantity.sendKeys(maxquant);
		   Thread.sleep(1000);
		   commentTB.sendKeys(comments);
		   Thread.sleep(1000);
	       submit.click();
	       Thread.sleep(1000);
	       cancel.click();
}
	
	public void withoutMaxQuanity_TC009() throws InterruptedException{
		   
		js.executeScript("arguments[0].click();", addNewUser);
		Thread.sleep(3000);
		   bookNo.sendKeys(bookno);
		   Thread.sleep(1000);
		   min_quantity.sendKeys(minquant);
		   Thread.sleep(1000);
		   commentTB.sendKeys(comments);
		   Thread.sleep(1000);
	       submit.click();
	       Thread.sleep(1000);
	       cancel.click();
	
}
	
	public void withoutFillBookNo_TC0100() throws InterruptedException{
		   
		   
		   bookNo.sendKeys("1101");
		   Thread.sleep(1000);
		   min_quantity.sendKeys(minquant);
		   Thread.sleep(1000);
		   max_quantity.sendKeys(maxquant);
		   Thread.sleep(1000);
		   commentTB.sendKeys(comments);
		   Thread.sleep(1000);
		   submit.click();
}
	
	
	public void FillAndreset_TC011() throws InterruptedException{
		
		Thread.sleep(2000);
		search_book.sendKeys("1101");
		startDate.sendKeys("2020/05/18");
		endDate.sendKeys("2020/06/15");
		Thread.sleep(2000);
		reset_button.click();
	}
	
public void searchButton_TC012() throws InterruptedException{
	
	Thread.sleep(2000);
	search_button.click();
	}

public void FillDateAndSearch_TC013() throws InterruptedException{
	
	Thread.sleep(2000);
	startDate.clear();
	startDate.sendKeys("2020/05/04");
	Thread.sleep(1000);
	endDate.clear();
	Thread.sleep(1000);
	endDate.sendKeys("2020/06/15");
	Thread.sleep(2000);
	search_button.click();
	Thread.sleep(2000);
}

public void FillallandSearch_TC014() throws InterruptedException{
	
	search_book.sendKeys("11");
	startDate.clear();
	startDate.sendKeys("2020/05/03");
	Thread.sleep(1000);
	endDate.clear();
	Thread.sleep(1000);
	endDate.sendKeys("2020/06/15");
	Thread.sleep(2000);
	search_button.click();
	Thread.sleep(2000);
	System.out.println("tc 14 commplete");
}

public void edit_TC015() throws InterruptedException{
	reset_button.click();
	Thread.sleep(3000);
	edit.click();
	Thread.sleep(2000);
	System.out.println("tc 15 commplete");
}

public void cancelAfterEdit_TC016() throws InterruptedException{
	cancelInEdit.click();
	System.out.println("tc 16 commplete");
}

public void changeAndSubmit_TC017() throws InterruptedException{
	Thread.sleep(3000);
	edit.click();
	Thread.sleep(2000);
	max_quantityInEdit.clear();
	max_quantityInEdit.sendKeys("6");
	submitInEdit.click();
	System.out.println("tc 17 commplete");
	
}

public void ClickAvailableForm_TC018() throws InterruptedException{
	Thread.sleep(2000);
	Availabe_form.click();
	System.out.println("tc 18 commplete");
	
}

public void Close_TC019() throws InterruptedException{
	Thread.sleep(2000);
	close.click();
	System.out.println("tc 19 commplete");
}

public void Delete_TC020() throws InterruptedException{
	Thread.sleep(2000);
	try{
	delete.click();
	}catch(Exception e){
		js.executeScript("arguments[0].click();", delete);
	}
	System.out.println("tc 20 commplete");
}

public void NO_Delete_TC021() throws InterruptedException{
	Thread.sleep(2000);
	No_delete.click();
	System.out.println("tc 21 commplete");
}

public void yes_Delete_TC022() throws InterruptedException{
	Thread.sleep(2000);
	js.executeScript("arguments[0].click();", delete);
	System.out.println("tc 20 commplete");
	Thread.sleep(2000);
	yes_delete.click();
	System.out.println("tc 21 commplete");
}

		   
public void chBookmangmt_TC023() throws InterruptedException{
	Thread.sleep(2000);
	Book_Management.click();
	Thread.sleep(4000);
	System.out.println("pass 23");
	
}

public void addNew_chBookmangmt_TC024() throws InterruptedException{
	Thread.sleep(1000);
	js.executeScript("arguments[0].click();", addNewUser);
	Thread.sleep(2000);
	System.out.println("pass 24");
	
}

public void cancel_chBookmangmt_TC025() throws InterruptedException{
	Thread.sleep(1000);
	cancel.click();
	System.out.println("pass 25");
}

public void submit_TC026() throws InterruptedException{
	
	Thread.sleep(2000);
	js.executeScript("arguments[0].click();", addNewUser);
	Thread.sleep(2000);
	submit.click();
	System.out.println("pass 26");
}


public void addBookandSubmit_TC027() throws InterruptedException{
	
	
	try {
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", addNewUser);
		Thread.sleep(2000);
		search_book1.click();
		Thread.sleep(1000);
		select_book1.click();
		Thread.sleep(1000);
		submit.click();
		System.out.println("pass 27");
	} catch (Exception e) {
		e.getMessage();
		e.printStackTrace();
	}
}
	
	public static Map<String,String> Read_RegExcel() throws IOException {
		
		Workbook bb=new XSSFWorkbook("D:\\Nic_work\\Desktop\\AllClasses_data\\BookStockManagement.xlsx");
		Sheet shet=bb.getSheet("Book");
		Map<String,String> mp=new HashMap<String,String>();
		Row row=shet.getRow(0);
		int totalcell=row.getLastCellNum();
			for(int j=0;j<totalcell;j++) {
			String key=	shet.getRow(1).getCell(j).getStringCellValue();
			String value=shet.getRow(3).getCell(j).getStringCellValue();
			mp.put(key, value);
			}
			
		return mp;
	}
	public static String getDataFromRegExcel(String key) throws IOException {
		
		Map<String,String> data=Read_RegExcel();
		String value=data.get(key);
		return value;

	}



}
