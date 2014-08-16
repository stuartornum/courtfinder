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

}
