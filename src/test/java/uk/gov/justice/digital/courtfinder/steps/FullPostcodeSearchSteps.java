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
	
	@Given("^I am on the courtfinder search page$")
	public void i_am_on_the_courtfinder_search_page() throws Throwable {
	    journeyFactory.getCourtFinderSearchPageJourney();
	    assertTrue(PageFactory.getCourtFinderSearchPage(driver).verifyOnPage());
	}

	@When("^I enter a \"(.*?)\" and area of \"(.*?)\"$")
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

	@Then("^I am prompted that an area of search must be entered$")
	public void i_am_prompted_that_an_area_of_search_must_be_entered() throws Throwable {
	    assertTrue(PageFactory.getCourtFinderSearchPage(driver).verifyareaOfLawErrorText());
	}
	
	

}
