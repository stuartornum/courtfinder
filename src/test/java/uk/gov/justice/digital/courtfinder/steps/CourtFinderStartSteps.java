package uk.gov.justice.digital.courtfinder.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.factories.PageFactory;
import uk.gov.justice.digital.courtfinder.pages.CourtfinderSearchSelectionPage;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;

public class CourtFinderStartSteps {
	
	private WebDriver driver;
	private JourneyFactory journeyFactory;
	
	public CourtFinderStartSteps(SharedDriver driver){
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}
	
	@Given("^I am on the courtfinder start page$")
	public void i_am_on_the_courtfinder_start_page() throws Throwable {
	    journeyFactory.getCourtFinderStartPageJourney();
	    assertTrue("Unable to reach the courtfinder start page",
	    		   PageFactory.getCourtFinderStartPage(driver).verifyOnPage());
	}

	@When("^I click the start button$")
	public void i_click_the_start_button() throws Throwable {
	    PageFactory.getCourtFinderStartPage(driver).clickStartButton();
	}

	@Then("^I am redirected to the courtfinder search selection page$")
	public void i_am_redirected_to_the_courtfinder_search_selection_page() throws Throwable {
	    assertTrue("Unable to reach the courtfinder search selection page",
	    		   PageFactory.getCourtfinderSearchSelectionPage(driver).verifyOnPage());
	}	

}
