package com.comcast.crm.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImp implements IRetryAnalyzer {
	
	int count=0;
	int countLimit=5;
	@Override
	public boolean retry(ITestResult result) {
		if(count<countLimit)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
