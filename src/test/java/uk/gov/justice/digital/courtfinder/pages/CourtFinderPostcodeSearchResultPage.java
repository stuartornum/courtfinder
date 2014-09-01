package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtFinderPostcodeSearchResultPage extends CourtFinderResultPage {


	
	private By pageTitle = new By.ByXPath(".//*[@id='content']/div/form/label[2]/div");
	private String expectedPageTitle = "Filtered by courts or tribunals dealing with";
	
	private By errorInvalidPostcode = new By.ByXPath(".//*[@id='content']/div/p");
	private String expectedErrorTextInvalidPostcode = "Sorry, there are no results for";

	private String courtDX = ".//*[@id='content']/div/div/ul/li[%d]/div[2]/p[2]/span[2]";
	private String courtNumber = ".//*[@id='content']/div/div/ul/li[%d]/div[2]/p[2]/span[4]";
	private String courtAddress = ".//*[@id='content']/div/div/ul/li[%d]/div[2]/p[1]";

	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
		return isInnerTextEqualToExpectedText(pageTitle, expectedPageTitle);
	}

	public CourtFinderPostcodeSearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	public int getCourtIndex(String courtName) throws Exception{
		int index = -1;
		String court = "";
        //loop results
		for (int resultIndex = 1; resultIndex <= getNumberOfResults(); resultIndex++ ){
		   court = (getCourtNameAtIndex(resultIndex));
		   if (court.equalsIgnoreCase(courtName)){
				return resultIndex; 
		   }
		}				
		throw new Exception("No court found for : " + courtName);
	}
	


	public void clickCourtTitle(String court) throws Exception {
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
	
	



	public boolean verifyErrorNoResultsFound() throws Exception {
		return isTextContainedInInnerText(errorInvalidPostcode, expectedErrorTextInvalidPostcode);
	}

	public boolean verifyCourtDX(String court, String dx) throws Exception {
		if (isTextContainedInInnerText(new By.ByXPath(String.format(courtDX, getCourtIndex(court))), dx))
			return true;
		return false;
	}
	

	public boolean verifyCourtNumber(String court, String courtnumber) throws Exception {
		if (isTextContainedInInnerText(new By.ByXPath(String.format(courtNumber, getCourtIndex(court))), courtnumber))
			return true;
		return false;
	}

	public boolean verifyCourtAddress(String court, String courtaddress) throws Exception {
		if (isTextContainedInInnerText(new By.ByXPath(String.format(courtAddress, getCourtIndex(court))), courtaddress))
			return true;
		return false;
	}
	

}
