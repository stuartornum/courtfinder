package uk.gov.justice.digital.courtfinder.factories;

import org.openqa.selenium.WebDriver;

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


}
