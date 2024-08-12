package com.comcast.crm.orgtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.protobuf.Method;

public class TestNgTest {
	@Test
	public void sample(Method mtd)
	{
		System.out.println(mtd.getName());
		System.out.println("create");
		//Assert.fail();
		
	}
	@Test(priority=2)
	public void deleteTest()
	{
		System.out.println("delete");
	
	}

}
