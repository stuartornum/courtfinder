package uk.gov.justice.digital.courtfinder.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.factories.PageFactory;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;

public class CourtFinderNameAddressFullnameSearchSteps {

	private WebDriver driver;
	private JourneyFactory journeyFactory;

	public CourtFinderNameAddressFullnameSearchSteps(SharedDriver driver) {
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}	
	
	@Given("^I am on the courtfinder address search page$")
	public void i_am_on_the_courtfinder_address_search_page() throws Throwable {
	    journeyFactory.getCourtFinderAddressSearchPageJourney();
	    assertTrue("Unable to reach the address search page",PageFactory.getCourtFinderNameAndAddressSearchPage(driver).verifyOnPage());
	}

	@When("^I enter a (?:partial court name|court name|building name|street name|town, city or county|invalid address) \"(.*?)\" and search$")
	public void i_enter_a_court_name_and_search(String courtName) throws Throwable {
	    PageFactory.getCourtFinderNameAndAddressSearchPage(driver).setAddress(courtName);
	    PageFactory.getCourtFinderNameAndAddressSearchPage(driver).clickContinueButton();
	    PageFactory.getCourtFinderAddressSearchResultPage(driver).verifyOnPage();
	}

	@Then("^I will be returned a single court result \"(.*?)\"$")
	public void i_will_be_returned_a_single_court_result(String court) throws Throwable {
	    assertTrue("Not the number of results expected",PageFactory.getCourtFinderAddressSearchResultPage(driver).verifyNumberOfCourtsFound(1));
	    assertTrue("Unable to find a court",PageFactory.getCourtFinderAddressSearchResultPage(driver).verifyCourtResults(court));
	    
	}
	
	@Then("^in the result page I should find within the results the following \"(.*?)\" listed$")
	public void in_the_result_page_I_should_find_within_the_results_the_following_listed(String courts) throws Throwable {
	    assertTrue("Unable to find a court",PageFactory.getCourtFinderAddressSearchResultPage(driver).verifyCourtResults(courts));
	}
	
	@Then("^I should be prompted that the address is invalid$")
	public void i_should_be_prompted_that_the_address_is_invalid() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}	

}
