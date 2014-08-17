package uk.gov.justice.digital.courtfinder.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.factories.PageFactory;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderSearchPage;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;

public class CourtTribunalSearchSteps {
	
	private WebDriver driver;
	private JourneyFactory journeyFactory;
	
	public CourtTribunalSearchSteps(SharedDriver driver){
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}
	
	@Given("^I am on the courtfinder search page$")
	public void i_am_on_the_courtfinder_search_page() throws Throwable {
	    journeyFactory.getCourtFinderSearchPageJourney();
	    assertTrue(PageFactory.getCourtFinderSearchPage(driver).verifyOnPage());
	}
	


}
