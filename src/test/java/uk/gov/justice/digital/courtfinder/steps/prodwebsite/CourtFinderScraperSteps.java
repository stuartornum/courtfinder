package uk.gov.justice.digital.courtfinder.steps.prodwebsite;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.factories.PageFactory;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CourtFinderScraperSteps {
	
	private WebDriver driver;
	private JourneyFactory journeyFactory;
	
	public CourtFinderScraperSteps(SharedDriver driver){
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}	

	@Given("^I am on the alphabetical list of courts-tribunals$")
	public void i_am_on_the_alphabetical_list_of_courts_tribunals()
			throws Throwable {
		journeyFactory.getAlphabeticalCourtListPageJourney();
		assertTrue("Unable to reach the alphabetical court page",
				  PageFactory.getAlphabeticalCourtListPage(driver).verifyOnPage());
	}

	@When("^I select all the \"(.*?)\"$")
	public void i_select_all_the(String letter) throws Throwable {
		PageFactory.getAlphabeticalCourtListPage(driver).selectLetter(letter.toLowerCase());
	}

	@Then("^I collect all the details for each court listed for \"(.*?)\"$")
	public void i_collect_all_the_details_for_each_court_listed_for(String letter) throws Throwable {
		PageFactory.getAlphabeticalCourtListPage(driver).collectCourtDetailsOnPage(letter.toLowerCase());
	}

}
