package org.Selenium.GcReddy.batchNo32;


import org.Selenium.batchNo32.Reports.Log;
import org.Selenium.batchNo32.Reports.Reports;
import org.Selenium.batchNo32.Utility.ExcelUtils;
import org.Selenium.batchNo32.appModule.LaunchEnv;
import org.Selenium.batchNo32.appModule.LoginActions;
import org.Selenium.batchNo32.appModule.LoginActions_multiple;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import jdk.internal.org.jline.utils.Log;

public class LoginActions_MultipleData extends LoginActions {
  @BeforeMethod
  public void OpenBrowserAndURL() throws InterruptedException {
	  Reports.startTest("LoginActions", "Executing the test case for Positive Data only");
	  // launch browser..
	  Assert.assertTrue(LaunchEnv.BrowserInvocation(prop_config.getProperty("Open_Browser")));
	  // launch URL
	  Assert.assertTrue(LaunchEnv.invokeUrl(prop_config.getProperty("Uibank_url")));
  }  
           
  @Test (dataProvider ="anyname") // every column representation
  public  void Login_Runner_MultipleData(String rm, String un, String pw, String criteria, String ExpOutput, String result ) {	 
		  try {
	      Assert.assertTrue(LoginActions_multiple.loginforMultipleData(rm, un, pw, criteria, ExpOutput, result)) ;  
		 
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
  
  //Annotator
  @DataProvider (name ="anyname")
  public static Object[][] ExcelSheetReading() {	  
	  Object[][] excelData = ExcelUtils.getData("UIbank_Data");
	return excelData;	 
  }
  

  
  
  }
  
  
 
  

