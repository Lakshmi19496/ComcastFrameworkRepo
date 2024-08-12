package sample.testngtest;

import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;

public class Sample2 extends BaseClass  {
	@Test
	public void ATest() {
		System.out.println("ATest");
	}
	@Test(invocationCount = 0)
	public void BTest() {
		System.out.println("BTest");
	}
	@Test(invocationCount = 0)
	public void CTest() {
		System.out.println("CTest");
	}

}
