package coverFoxUsingTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoverFoxMemberDetailsPage
{
@FindBy(id="Age-You")private WebElement ageDropDown; 
@FindBy(xpath="//div[@class='next-btn']")private WebElement nextButton;


public CoverFoxMemberDetailsPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public void handleAgeDropDown(String age)
{
	ageDropDown.click();
	Select s=new Select(ageDropDown);
	s.selectByVisibleText(age+" years");
}

public void clickOnNextButton()
{
	nextButton.click();
}


}

