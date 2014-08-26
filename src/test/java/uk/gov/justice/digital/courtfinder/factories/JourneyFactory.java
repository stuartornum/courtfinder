package uk.gov.justice.digital.courtfinder.factories;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.pages.CourtFinderStartPage;
import uk.gov.justice.digital.courtfinder.pages.CourtfinderSearchSelectionPage;

public class JourneyFactory {
	
	private final WebDriver driver;


	public JourneyFactory(WebDriver driver) {
		this.driver = driver;
		
	}

	public void getCourtFinderSearchPageJourney() {
	   driver.get(FakeDataFactory.getSearchPageUrl());
	   
	}


	public void getFinanceAndTaxTribunalPageJourney(int recordNumber) {
		driver.get(String.format(FakeDataFactory.getFinanceAndTaxTribunalsUrl(),recordNumber));
	
	}
	
	public void getPropertyChamberLandRegistrationPageJourney(int recordNumber) {
		driver.get(String.format(FakeDataFactory.getPropertyChamberLandRegistrationUrl(),recordNumber));
	
	}	
	
	public void getHESCChamberCareStandardsPageJourney(int recordNumber) {
		driver.get(String.format(FakeDataFactory.getHESCChamberCareStandardsUrl(),recordNumber));
	
	}	
	
	public void getAdministrativeAppealsPageJourney(int recordNumber) {
		driver.get(String.format(FakeDataFactory.getAdministtrativeAppealsUrl(),recordNumber));
	
	}	
	
	public void getCourtFinderStartPageJourney(){
		driver.get(FakeDataFactory.getCourtFinderStartPageUrl());
	}
	
	public void getCourtFinderSearchSelecionPageJourney() throws Exception{
		getCourtFinderStartPageJourney();
		CourtFinderStartPage page = PageFactory.getCourtFinderStartPage(driver);
		assertTrue("Unable to reach the start page",
				   page.verifyOnPage());
		page.clickStartButton();
	}

	public void getCourtFinderPostcodeSearchPageJourney() throws Exception{
		getCourtFinderSearchSelecionPageJourney();
		CourtfinderSearchSelectionPage page = new CourtfinderSearchSelectionPage(driver);
		assertTrue("Unable to reach the searchh selection page",
				  page.verifyOnPage());
		page.clickPostcodeSearch();
		page.clickContinueButton();
	}

}
