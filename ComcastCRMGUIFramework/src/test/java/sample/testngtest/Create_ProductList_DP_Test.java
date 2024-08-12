package sample.testngtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class Create_ProductList_DP_Test {

	
	
	@Test(dataProvider = "getData")
	public void productPriceTest(String brand,String productName) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		//search for iphone
		driver.findElement(By.name("field-keywords")).sendKeys(brand+Keys.ENTER);
		//get xpath of the price of phones
		String x="//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span/span[2]";
		String text = driver.findElement(By.xpath(x)).getText();
		System.out.println(text);
		
	

	}
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		
		
		Object[][] obj=new Object[3][2];
		
		ExcelUtility eLib=new ExcelUtility();
	
		int row = eLib.getRowCount("products");
		for(int i=0;i<row;i++) {
		obj[i][0]=eLib.getDataFromExcelFile("products", i+1, 0);
		obj[i][1]=eLib.getDataFromExcelFile("products", i+1, 1);
		
		}
		
		return obj;
	}
}
