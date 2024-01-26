package coverFoxUsingTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage 
{
	@FindBy(xpath="(//input[@type='number'])[1]")private WebElement pinCodeField;
	@FindBy(xpath="(//input[@type='number'])[2]")private WebElement mobNumField;
	@FindBy(xpath = "//div[text()='Continue']")private WebElement continueButton;
	
	public CoverFoxAddressDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterPinCode(String pincode)
	{
		pinCodeField.sendKeys(pincode);
	}
	
	public void enterMobNum(String mobileNumber)
	{
		mobNumField.sendKeys(mobileNumber);
	}

	public void clickOnContinueButton()
	{
		continueButton.click();
	}
	
	
	
	
	
//	
//	public boolean errorMsg()
//	{
//		Reporter.log("Error msg is displaying");
//		boolean errormsgdisplay = pincodeErrorMsg.isDisplayed();
//		return errormsgdisplay;
//	}
//	public String getErrorMsg()
//	{
//		return pincodeErrorMsg.getText();
//	}
//	
//	
	
	
	
	
	
			
}
