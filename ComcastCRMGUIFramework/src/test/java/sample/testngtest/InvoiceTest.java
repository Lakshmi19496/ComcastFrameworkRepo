package sample.testngtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;
@Listeners(com.comcast.crm.listenerutility.ListenerImplementation.class)
public class InvoiceTest extends BaseClass{
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryAnalyserImp.class)
	public void createInvoiceTest() {
		System.out.println("test-1");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "login");
		System.out.println("test-2");
		System.out.println("test-3");
		System.out.println("test-4");
	}
	
	@Test
public void createInvoiceWithPhnonenoTest() {
	System.out.println("test-1");
	
	System.out.println("test-2");
	System.out.println("test-3");
	System.out.println("test-4");
	}


}
