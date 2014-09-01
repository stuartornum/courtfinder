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

	private WebDriver driver;
	private JourneyFactory journeyFactory;

	public CourtFinderPostcodeSearchSteps(SharedDriver driver) {
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}

	@Given("^I am on the courtfinder postcode search page$")
	public void i_am_on_the_courtfinder_postcode_search_page() throws Throwable {
		journeyFactory.getCourtFinderPostcodeSearchPageJourney();
		assertTrue("Unable to reach the postcode search page", PageFactory
				.getCourtfinderPostcodSearchPage(driver).verifyOnPage());
	}

	@When("^I enter a postcode \"(.*?)\" and area of law \"(.*?)\" and select continue$")
	public void i_enter_a_postcode_and_area_of_law_and_select_continue(
			String postcode, String areaOfLaw) throws Throwable {
		CourtfinderPostcodSearchPage page = PageFactory
				.getCourtfinderPostcodSearchPage(driver);
		page.setSearchPostcode(postcode);
		page.setAreaOfLaw(areaOfLaw);
		page.clickContinue();
	}

	@Then("^I am redirected to the postcode results displaying the closest \"(.*?)\"$")
	public void i_am_redirected_to_the_postcode_results_displaying_the_closest(
			String courts) throws Throwable {
		assertTrue("could not reach the postcode search result page",
				PageFactory.getCourtFinderPostcodeSearchResultPage(driver)
						.verifyOnPage());
		assertTrue("Unable to find a court",
				PageFactory.getCourtFinderPostcodeSearchResultPage(driver)
						.verifyCourtResults(courts));
	}

	@When("^I enter a Northern Ireland postcode \"(.*?)\" and area of law \"(.*?)\" and select continue$")
	public void i_enter_a_Northern_Ireland_postcode_and_area_of_law_and_select_continue(
			String postcode, String areaOfLaw) throws Throwable {
		CourtfinderPostcodSearchPage page = PageFactory
				.getCourtfinderPostcodSearchPage(driver);
		page.setSearchPostcode(postcode);
		page.setAreaOfLaw(areaOfLaw);
		page.clickContinue();
	}

	@Then("^I am returned an error message that Northern Ireland is not supported except for immigration$")
	public void i_am_returned_an_error_message_that_Northern_Ireland_is_not_supported_except_for_immigration()
			throws Throwable {
		assertTrue("Unable to reach the search error page", PageFactory
				.getCourtFinderSearchErrorPage(driver).verifyOnPage());
	}

	@When("^select the \"(.*?)\" link in the postcode search results$")
	public void select_the_link_in_the_postcode_search_results(String court) throws Throwable {
	    PageFactory.getCourtFinderPostcodeSearchResultPage(driver).clickCourtTitle(court);
	}

	@Then("^I am redirected to the selected \"(.*?)\" details page$")
	public void i_am_redirected_to_the_selected_details_page(String court) throws Throwable {
	    assertTrue("Unable to reach the court details page",PageFactory.getCourtFinderCourtDetailsPage(driver).verifyOnPage());
	    assertTrue("Court title on details page is not as expected",PageFactory.getCourtFinderCourtDetailsPage(driver).verifyCourtTitle(court));
	}
	
	@Then("^the total number of search results (\\d+) should be displayed$")
	public void the_total_number_of_search_results_should_be_displayed(int numberOfCourtsFound) throws Throwable {
	    assertTrue("Invalid number of courts found",PageFactory.getCourtFinderPostcodeSearchResultPage(driver).verifyNumberOfCourtsFound(numberOfCourtsFound));
	}
	
	@Then("^I am prompted that the searched postcode could not be found$")
	public void i_am_prompted_that_the_searched_postcode_could_not_be_found() throws Throwable {
        assertTrue("No error message displayed for entering an invalid postcode",
        		   PageFactory.getCourtFinderPostcodeSearchResultPage(driver).verifyErrorNoResultsFound());
	}
	
	@When("^I select continue$")
	public void i_select_continue() throws Throwable {
	    PageFactory.getCourtfinderPostcodSearchPage(driver).clickContinue();
	}

	@Then("^I am prompted to enter a postcode$")
	public void i_am_prompted_to_enter_a_postcode() throws Throwable {
	    assertTrue("No error message displayed for not entering a postcode"
	    		   ,PageFactory.getCourtfinderPostcodSearchPage(driver).verifyErrorPromptEnterPostcode());
	}
	
	@Then("^for the \"(.*?)\" the \"(.*?)\" and \"(.*?)\" are displayed$")
	public void for_the_the_and_are_displayed(String court, String dx, String courtnumber) throws Throwable {
	    assertTrue("Invalid dx number",PageFactory.getCourtFinderPostcodeSearchResultPage(driver).verifyCourtDX(court,dx));
	    assertTrue("Invalid court number",PageFactory.getCourtFinderPostcodeSearchResultPage(driver).verifyCourtNumber(court,courtnumber));

	}

	@Then("^for the \"(.*?)\" the \"(.*?)\" is displayed$")
	public void for_the_the_is_displayed(String court, String courtaddress) throws Throwable {
	   assertTrue(PageFactory.getCourtFinderPostcodeSearchResultPage(driver).verifyCourtAddress(court,courtaddress));
	}	

}
