package sample.testngtest;

import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;

public class Sample1 extends BaseClass{
	@Test
	public void aTest() {
		System.out.println("sample1");
	}
	@Test(invocationCount = 0)
	public void bTest() {
		System.out.println("sample2");
	}
	@Test(invocationCount = 0)
	public void cTest() {
		System.out.println("sample3");
	}

}
