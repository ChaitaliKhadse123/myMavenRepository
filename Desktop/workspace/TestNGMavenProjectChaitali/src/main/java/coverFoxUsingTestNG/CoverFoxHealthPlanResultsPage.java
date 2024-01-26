package coverFoxUsingTestNG;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxHealthPlanResultsPage
{
	@FindBy(xpath="//div[contains(text(),'matching Health')]")private WebElement resultsInString;
	@FindBy(id="plans-list")private List<WebElement> planList;
	
	public CoverFoxHealthPlanResultsPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public int validatePlanListWithResults() throws InterruptedException
	{
		Thread.sleep(10000);
		String test=resultsInString.getText();
		//49 matching Health Insurance Plans
		
		System.out.println(test);
		
		String ar[]=test.split(" ");
		//ar[]={"49" "matching" "Health" "Insurance" "Plans"}
		Thread.sleep(10000);
		String numberOfResultsInString=ar[0];
		//convert String to integer
		//49-->in number(int)
		int numberOfResultsInInt=Integer.parseInt(numberOfResultsInString);
		
		int totalNumberOfPlans=planList.size();
		
		if(totalNumberOfPlans==numberOfResultsInInt)
		{
			System.out.println("Plans number matching with plans List,TC is passed");
		}
			else 
			{
			System.out.println("Plans number is not matching with plans List, TC is failed");
			}
		return numberOfResultsInInt;
		
	}
	public int availablePlanNumberFromBanners()
	{
		int totalNumberOfPlans=planList.size();
		return totalNumberOfPlans;
	}
}
