package uk.gov.justice.digital.courtfinder.steps.prodwebsite;

import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.factories.PageFactory;
import uk.gov.justice.digital.courtfinder.pages.prodwedsite.CourtFinderSearchPage;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;
import cucumber.api.java.en.When;
import cucumber.api.PendingException;

public class CourtAndTribunalFullnameSteps {

	private WebDriver driver;
	private JourneyFactory journeyFactory;
	
	public CourtAndTribunalFullnameSteps(SharedDriver driver){
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}

	@When("^I enter a fullname for a court or tribunal \"(.*?)\" and area of law \"(.*?)\"$")
	public void i_enter_a_and_area_of(String courtOrTribunal, String areaOfLaw) throws Throwable {
	    CourtFinderSearchPage page = PageFactory.getCourtFinderSearchPage(driver);
	    page.setSearchText(courtOrTribunal);
	    page.setSelectionByVisibleText(areaOfLaw);
	    page.clickSearchButton();
	}
	
	@When("^I enter a partial name \"(.*?)\" for a court or tribunal$")
	public void i_enter_a_partial_name_for_a_court_or_tribunal(String partialName) throws Throwable {
	    CourtFinderSearchPage page = PageFactory.getCourtFinderSearchPage(driver);
	    page.setSearchText(partialName);		
	}

	@When("^I select the court or tribunal \"(.*?)\" displayed in the matches list$")
	public void i_select_the_displayed_in_the_matches_list(String courtOrTribunalName) throws Throwable {
	    PageFactory.getCourtFinderSearchPage(driver).setResultFromPartialNameEntryByName(courtOrTribunalName);
	}

}
