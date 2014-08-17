package uk.gov.justice.digital.courtfinder.factories;

import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.pages.CourtDetailsPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderSearchPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderSearchResultPage;

public class PageFactory {
    
	public static CourtFinderSearchPage getCourtFinderSearchPage(WebDriver driver){
		return new CourtFinderSearchPage(driver);
	}
	
	public static CourtFinderSearchResultPage getCourtFinderSearchResultPage(WebDriver driver){
		return new CourtFinderSearchResultPage(driver);
	}
	
	public static CourtDetailsPage getCourtDetailsPage(WebDriver driver){
		return new CourtDetailsPage(driver);
	}
	
}
