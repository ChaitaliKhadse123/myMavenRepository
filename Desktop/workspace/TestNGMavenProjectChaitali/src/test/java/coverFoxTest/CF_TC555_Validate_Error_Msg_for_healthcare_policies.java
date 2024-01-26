package coverFoxTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import coverFoxBase.Base;
import coverFoxUsingTestNG.CoverFoxAddressDetailsPage;
import coverFoxUsingTestNG.CoverFoxHealthPlanPage;
import coverFoxUsingTestNG.CoverFoxHomePage;
import coverFoxUsingTestNG.CoverFoxMemberDetailsPage;
import coverFoxUtility.Utility;

@Listeners(coverFoxListener.CoverFoxListener.class)
public class CF_TC555_Validate_Error_Msg_for_healthcare_policies extends Base
{
	
	public static Logger logger;
	CoverFoxHomePage home;
	CoverFoxHealthPlanPage healthPlan;
	CoverFoxAddressDetailsPage addressDetails;
	CoverFoxMemberDetailsPage memberDetails;
	
	
	@BeforeClass
	public void luanchBrowser() throws InterruptedException
	{
		logger.getLogger("CoverFoxInsurance");
		PropertyConfigurator.configure("log4j.properties");
		launchCoverFox();
		home=new CoverFoxHomePage(driver);
		healthPlan=new CoverFoxHealthPlanPage(driver);
		addressDetails=new CoverFoxAddressDetailsPage(driver);
		memberDetails=new CoverFoxMemberDetailsPage(driver);
		
		
	}
	
//    private void Logger(String string) {
//		// TODO Auto-generated method stub
//		
//	}

	@BeforeMethod
    public void enterMemberDetails()throws InterruptedException, IOException {
	  
    	Reporter.log("clicking on gender button",true);
		home.clickOnFemaleButton();
		Thread.sleep(1000);
		
		Reporter.log("clicking on next button",true);
		healthPlan.clickOnNextButton();
		Thread.sleep(1000);
		
		Reporter.log("Handeling age dropdown",true);
	
		memberDetails.handleAgeDropDown(Utility.readDataFromProperty("age"));
		Reporter.log("clicking on next button",true);
		memberDetails.clickOnNextButton();
		Thread.sleep(1000);
		
		Reporter.log("Entering pin code",true);
		addressDetails.enterPinCode(Utility.readDataFromProperty("pinCode"));
		
		Reporter.log("Enter",true);
		addressDetails.enterMobNum(Utility.readDataFromProperty("MobNum"));
		
		Reporter.log("Enter",true);
		addressDetails.clickOnContinueButton();
		Thread.sleep(1000);
    }  
	
//  @Test
//  public void validatePincodeErrorMsg() throws InterruptedException, IOException
//  {
//	  Thread.sleep(1000);
//	  //String actualerrorpincodemsg = addressDetails.getErrorMsg();
//	  //String expectederrormsg="Please enter a valid pin1";
//	  //SoftAssert s=new SoftAssert();
//	  //s.assertEquals(actualerrorpincodemsg, expectederrormsg,"Error msg not match,TC is failed");
//	  Thread.sleep(1000);
//	  Assert.assertTrue(addressDetails.errorMsg()," Error msg didnot display");
//	  Utility.takeScreenshot(driver, "TC555_Error");
//	  //s.assertAll();
//	  
//  }

  @AfterMethod
  public void closeBrowser() throws InterruptedException
	{
		
	    Thread.sleep(1000);
	    closeCoverFox();
	}
  
} 
  
  
  
  
  
  
  
  
  
  
  
