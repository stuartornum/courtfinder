package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ById;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtFinderPostcodeSearchResultPage extends CourtFinderResultPage {


	
	private By pageTitle = new By.ByXPath(".//*[@id='content']/div/form/label[2]/div");
	private String expectedPageTitle = "Filtered by courts or tribunals dealing with";
	

	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
		return isInnerTextEqualToExpectedText(pageTitle, expectedPageTitle);
	}

	public CourtFinderPostcodeSearchResultPage(WebDriver driver) {
		super(driver);
	}
	


	public void clickCourtTitle(String court) throws NumberFormatException, Exception {
		String courtName = "";
        //loop results
		for (int resultIndex = 1; resultIndex <= getNumberOfResults(); resultIndex++ ){
		   courtName = (getCourtNameAtIndex(resultIndex));
		   if (courtName.equalsIgnoreCase(court)){
				click(new By.ByXPath(String.format(courtTitle, resultIndex))); 
				break;
		   }
		}		
	}

	

}
