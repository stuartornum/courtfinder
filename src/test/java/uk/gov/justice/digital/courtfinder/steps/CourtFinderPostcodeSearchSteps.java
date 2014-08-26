package uk.gov.justice.digital.courtfinder.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.factories.PageFactory;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderPostcodeSearchResultPage;
import uk.gov.justice.digital.courtfinder.pages.CourtfinderPostcodSearchPage;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;

public class CourtFinderPostcodeSearchSteps {

	private WebDriver      driver;
	private JourneyFactory journeyFactory;
	
	public CourtFinderPostcodeSearchSteps(SharedDriver driver){
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}
	
	@Given("^I am on the courtfinder postcode search page$")
	public void i_am_on_the_courtfinder_postcode_search_page() throws Throwable {
	    journeyFactory.getCourtFinderPostcodeSearchPageJourney();
	    assertTrue("Unable to reach the postcode search page",
	    		   PageFactory.getCourtfinderPostcodSearchPage(driver).verifyOnPage());
	}

	@When("^I enter a postcode \"(.*?)\" and area of law \"(.*?)\" and select continue$")
	public void i_enter_a_postcode_and_area_of_law_and_select_continue(String postcode, String areaOfLaw) throws Throwable {
	    CourtfinderPostcodSearchPage page = PageFactory.getCourtfinderPostcodSearchPage(driver);
	    page.setSearchPostcode(postcode);
	    page.setAreaOfLaw(areaOfLaw);
	    page.clickContinue();
	}

	@Then("^I am redirected to the postcode results displaying the closest \"(.*?)\"$")
	public void i_am_redirected_to_the_postcode_results_displaying_the_closest(String courts) throws Throwable {
	    assertTrue("could not reach the postcode search result page",
	    		   PageFactory.getCourtFinderPostcodeSearchResultPage(driver).verifyOnPage());
	    assertTrue("",
	    		   PageFactory.getCourtFinderPostcodeSearchResultPage(driver).verifyCourtResults(courts));
	}
	
	@When("^I enter a Northern Ireland postcode \"(.*?)\" and area of law \"(.*?)\" and select continue$")
	public void i_enter_a_Northern_Ireland_postcode_and_area_of_law_and_select_continue(String postcode, String areaOfLaw) throws Throwable {
	    CourtfinderPostcodSearchPage page = PageFactory.getCourtfinderPostcodSearchPage(driver);
	    page.setSearchPostcode(postcode);
	    page.setAreaOfLaw(areaOfLaw);
	    page.clickContinue();
	}

	@Then("^I am returned an error message that Northern Ireland is not supported except for immigration$")
	public void i_am_returned_an_error_message_that_Northern_Ireland_is_not_supported_except_for_immigration() throws Throwable {
	    assertTrue("Unable to reach the search error page",
	    		   PageFactory.getCourtFinderSearchErrorPage(driver).verifyOnPage());
	}	
	
	
}
