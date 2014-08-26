package uk.gov.justice.digital.courtfinder.factories;

import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.pages.AdministrativeAppealPage;
import uk.gov.justice.digital.courtfinder.pages.CourtDetailsPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderSearchPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderSearchResultPage;
import uk.gov.justice.digital.courtfinder.pages.FinanceAndTaxTribunalPage;
import uk.gov.justice.digital.courtfinder.pages.HESCChamberCareStandardsPage;
import uk.gov.justice.digital.courtfinder.pages.PropertyChamberLandRegistrationPage;

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
	
	public static FinanceAndTaxTribunalPage getFinanceAndTaxTribunalPage(WebDriver driver){
		return new FinanceAndTaxTribunalPage(driver);
	}
	
	public static PropertyChamberLandRegistrationPage getPropertyChamberLandRegistrationPage(WebDriver driver){
		return new PropertyChamberLandRegistrationPage(driver);
	}
	
	public static HESCChamberCareStandardsPage getHESCChamberCareStandardsPage(WebDriver driver){
		return new HESCChamberCareStandardsPage(driver);
	}
	
	public static AdministrativeAppealPage getAdministrativeAppealPage(WebDriver driver){
		return new AdministrativeAppealPage(driver);
	}	
	
}
