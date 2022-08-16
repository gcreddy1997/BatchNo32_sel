package org.Selenium.GcReddy.batchNo32;



import org.Selenium.batchNo32.Reports.Log;
import org.Selenium.batchNo32.Reports.Reports;
import org.Selenium.batchNo32.appModule.LaunchEnv;
import org.Selenium.batchNo32.appModule.LoginActions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


//import jdk.internal.org.jline.utils.Log;

public class LoginActions_PositiveData extends LoginActions {
  @BeforeMethod
  public void OpenBrowserAndURL() throws InterruptedException {
	  Reports.startTest("LoginActions", "Executing the test case for Positive Data only");
	  // launch browser..
	  Assert.assertTrue(LaunchEnv.BrowserInvocation(prop_config.getProperty("Open_Browser")));
	  // launch URL
	  Assert.assertTrue(LaunchEnv.invokeUrl(prop_config.getProperty("Uibank_url")));
  }
  
  
  @Test 
  public  void Login_Runner_onlyPasitiveData() {	 
		  try {
	      Assert.assertTrue(LoginActions.loginForPositiveData("gcreddy1997@gmail.com", "Madhavi@1206")) ;  
		 
		  }catch(Exception e) {
			  e.printStackTrace();
		  
		  System.out.println("It is executing for error message where runMode = NO...");
		  Log.info("It is executing for error message where runMode = NO...");
		  Reports.info("No data" , "It is executing for error message where runMode = NO...");	 
		  }		  
  }
  
  
  @AfterMethod
  public void closeBroser() {
	 LaunchEnv.closeBrowser();
	 Reports.endTest();
  } 
  
  
  
 
  
}
