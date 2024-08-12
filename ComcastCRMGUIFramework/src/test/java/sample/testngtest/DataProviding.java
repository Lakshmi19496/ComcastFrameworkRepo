package sample.testngtest;

import org.testng.annotations.DataProvider;

public class DataProviding {
	@DataProvider(name="a")
	public Object[][] sendData(){
		Object[][] obj=new Object[3][2];
		obj[0][0]="Lakshmi";
		obj[0][1]="0987654321";
		obj[1][0]="Ravi";
		obj[1][1]="9876543021";
		obj[2][0]="Radha";
		obj[2][1]="9087654321";
		return obj;
	}

}
