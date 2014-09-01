package uk.gov.justice.digital.courtfinder.factories;

import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.pages.CourtFinderAddressSearchResultPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderCourtDetailsPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderListViewPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderAddressSearchPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderPostcodeSearchResultPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderSearchErrorPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderStartPage;
import uk.gov.justice.digital.courtfinder.pages.CourtfinderPostcodSearchPage;
import uk.gov.justice.digital.courtfinder.pages.CourtfinderSearchSelectionPage;
import uk.gov.justice.digital.courtfinder.pages.prodwedsite.AlphabeticalCourtListPage;
import uk.gov.justice.digital.courtfinder.pages.prodwedsite.CourtDetailsPage;
import uk.gov.justice.digital.courtfinder.pages.prodwedsite.CourtFinderSearchPage;
import uk.gov.justice.digital.courtfinder.pages.prodwedsite.CourtFinderSearchResultPage;
import uk.gov.justice.digital.tribunal.pages.AdministrativeAppealPage;
import uk.gov.justice.digital.tribunal.pages.FinanceAndTaxTribunalPage;
import uk.gov.justice.digital.tribunal.pages.HESCChamberCareStandardsPage;
import uk.gov.justice.digital.tribunal.pages.PropertyChamberLandRegistrationPage;

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
	
	public static CourtFinderStartPage getCourtFinderStartPage(WebDriver driver){
		return new CourtFinderStartPage(driver);
	}
	
	public static CourtfinderSearchSelectionPage getCourtfinderSearchSelectionPage(WebDriver driver){
		return new CourtfinderSearchSelectionPage(driver);
	}	
	
	public static CourtfinderPostcodSearchPage getCourtfinderPostcodSearchPage(WebDriver driver){
		return new CourtfinderPostcodSearchPage(driver);
	}	
	
	public static CourtFinderListViewPage getCourtFinderListViewPage(WebDriver driver){
		return new CourtFinderListViewPage(driver);
	}	

	public static CourtFinderAddressSearchPage getCourtFinderAddressSearchPage(WebDriver driver){
		return new CourtFinderAddressSearchPage(driver);
	}

	public static CourtFinderPostcodeSearchResultPage getCourtFinderPostcodeSearchResultPage(WebDriver driver){
		return new CourtFinderPostcodeSearchResultPage(driver);
	}	
	
	public static CourtFinderSearchErrorPage getCourtFinderSearchErrorPage(WebDriver driver){
		return new CourtFinderSearchErrorPage(driver);
	}
	
	public static CourtFinderCourtDetailsPage getCourtFinderCourtDetailsPage(WebDriver driver){
		return new CourtFinderCourtDetailsPage(driver);
	}
	
	public static AlphabeticalCourtListPage getAlphabeticalCourtListPage(WebDriver driver){
		  return new AlphabeticalCourtListPage(driver);
	}

	public static CourtFinderAddressSearchResultPage getCourtFinderAddressSearchResultPage(
			WebDriver driver) {
		return new CourtFinderAddressSearchResultPage(driver);
	}
	
}
