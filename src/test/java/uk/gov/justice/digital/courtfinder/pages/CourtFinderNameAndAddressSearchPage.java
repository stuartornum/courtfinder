package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtFinderNameAndAddressSearchPage extends SeleniumPage{
	
	private By pageTitle = new By.ByXPath("");
	private String expectedPageTitle = "";

	public CourtFinderNameAndAddressSearchPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
		return isInnerTextEqualToExpectedText(pageTitle, expectedPageTitle);
	}
	
	
	
	

}
