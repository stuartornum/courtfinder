package uk.gov.justice.digital.courtfinder.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.factories.FakeDataFactory;
import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.factories.PageFactory;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderSearchPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderSearchResultPage;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;

public class FullPostcodeSearchSteps {
	
	private WebDriver driver;
	private JourneyFactory journeyFactory;
	
	public FullPostcodeSearchSteps(SharedDriver driver){
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}
	

	@When("^I enter (?:a Northern Ireland postcode|a postcode|an invalid postcode|an exact postcode) \"(.*?)\" (?:with an area|and area) of law \"(.*?)\"$")
	public void i_enter_a_and_area_of(String postcode, String areaOfLaw) throws Throwable {
	    CourtFinderSearchPage page = PageFactory.getCourtFinderSearchPage(driver);
	    page.setSearchText(postcode);
	    page.setSelectionByVisibleText(areaOfLaw);
	    page.clickSearchButton();
	}

	@Then("^I am returned the closest \"(.*?)\"$")
	public void i_am_returned_the_closest(String courts) throws Throwable {
	    assertTrue(PageFactory.getCourtFinderSearchResultPage(driver).verifyOnPage());
	    String[] courtArray = courts.split(",");
	    for (int index=0; index < courtArray.length; index++){
	    	assertTrue(PageFactory.getCourtFinderSearchResultPage(driver)
	    			              .getCourtNameAtIndex(index+1)
	    			              .equalsIgnoreCase(courtArray[index]));
	    }
	    //assertTrue("Invalid number of results returned",PageFactory.getCourtFinderSearchResultPage(driver).getNumberOfCourtResults() == courtArray.length);
	}
	
	@Then("^I am returned an error message that Northern Ireland is not supported$")
	public void i_am_returned_an_error_message_that_Northern_Ireland_is_not_supported() throws Throwable {
	    CourtFinderSearchResultPage page = new CourtFinderSearchResultPage(driver);
	    assertTrue(page.verifyOnPage());
		assertTrue(page.isNorthernIrelandErrorTextVisible());
	}
	
	@Given("^the search button is disabled$")
	public void the_search_button_is_disabled() throws Throwable {
	    assertFalse(PageFactory.getCourtFinderSearchPage(driver).isSearchButtonEnabled());
	}

	@When("^I enter a postcode$")
	public void i_enter_a_postcode() throws Throwable {
	    PageFactory.getCourtFinderSearchPage(driver).setSearchText(FakeDataFactory.getPostcode());
	}

	@Then("^the search button is enabled$")
	public void the_search_button_is_enabled() throws Throwable {
	    assertTrue(PageFactory.getCourtFinderSearchPage(driver).isSearchButtonEnabled());

	}

	@When("^then select search$")
	public void then_select_search() throws Throwable {
	    PageFactory.getCourtFinderSearchPage(driver).clickSearchButton();
	}

	@Then("^I am prompted that an area of law must be entered$")
	public void i_am_prompted_that_an_area_of_search_must_be_entered() throws Throwable {
	    assertTrue(PageFactory.getCourtFinderSearchPage(driver).verifyareaOfLawErrorText());
	}
	
	@When("^select view details for \"(.*?)\"$")
	public void select_view_details_for(String court) throws Throwable {
	    PageFactory.getCourtFinderSearchResultPage(driver).clickViewDetailsLink(court);
	}

	@Then("^I am redirected to the \"(.*?)\" details page$")
	public void i_am_redirected_to_the_details_page(String court) throws Throwable {
	    assertTrue(PageFactory.getCourtDetailsPage(driver).verifyOnPage(court));
	}
	
	@Then("^the total number of results (\\d+) should be displayed$")
	public void the_total_number_of_results_should_be_displayed(int result) throws Throwable {
		int numberOfResults = PageFactory.getCourtFinderSearchResultPage(driver).getNumberOfCourtResults();
	    assertTrue("Expected: "+ result +" Actual : " +numberOfResults, numberOfResults == result);
	}
	@Then("^I am prompted that no search results for \"(.*?)\" could not be found$")
	public void i_prompted_that_no_search_results_for_postcode_could_be_found(String postcode) throws Throwable {
	    assertTrue(PageFactory.getCourtFinderSearchResultPage(driver).verifyErrorDisplayedForInvalidCourtOrPostcode(postcode));
	}
	
	@Then("^I am prompted that the postcode could not be found$")
	public void i_prompted_that_the_postcode_could_not_be_found() throws Throwable {
	    assertTrue(PageFactory.getCourtFinderSearchResultPage(driver).verifyErrorDisplayedForInvalidPostcode());

	}
	
	
	

}
