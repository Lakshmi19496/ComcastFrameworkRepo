package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImplementation implements ITestListener,ISuiteListener {
	public ExtentReports report;
	public ExtentTest test;
	
	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("=====report backup====");
		report.flush();
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("=====report configg====");

		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report_"+time+".html");

		spark.config().setDocumentTitle("CRM test suite result");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Os","Windows -10");
		report.setSystemInfo("Browser","Chrome-100");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}
	@Override
	public void onTestFailure(ITestResult result) {
		//String time=new Date().toString().replace(" ", "_").replace(":", "$");


		TakesScreenshot ts=(TakesScreenshot)UtilityClassObject.getDriver();;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);

		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		String var = result.getMethod().getMethodName()+"_"+time;
		test.addScreenCaptureFromBase64String(filePath,var);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"=====>FAILED<====");
		test.log(Status.FAIL, result.getThrowable());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+"=====>SKIPPED<====");
		test.log(Status.SKIP, result.getThrowable());
		
		// TODO Auto-generated method stub

	}
	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"=====>started<=======");
		
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("======>"+result.getMethod().getMethodName()+"<========");
		test.log(Status.PASS, result.getMethod().getMethodName()+"=====>completed<====");
	}



}
