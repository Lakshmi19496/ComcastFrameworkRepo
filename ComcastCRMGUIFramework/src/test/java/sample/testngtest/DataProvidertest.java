package sample.testngtest;

import org.testng.annotations.Test;

public class DataProvidertest {
	@Test(dataProvider = "a",dataProviderClass = DataProviding.class)
	public void sampleTest(String name,String phno) {
		System.out.println(name+" "+phno);
		
		
	}

}
