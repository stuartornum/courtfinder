package uk.gov.justice.digital.courtfinder.steps.prodwebsite;

import static org.junit.Assert.assertTrue;



import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.factories.PageFactory;
import uk.gov.justice.digital.courtfinder.helpers.Storage;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;

public class CourtFinderScraperSteps {
	
	private WebDriver driver;
	private JourneyFactory journeyFactory;
	private String fileName = "courts.json";
	
	public CourtFinderScraperSteps(SharedDriver driver){
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}	

	@Given("^I am on the alphabetical list of courts-tribunals$")
	public void i_am_on_the_alphabetical_list_of_courts_tribunals()
			throws Throwable {

		Storage.deleteFile(fileName);
		Storage.append(fileName,"{\"courts\":[");
		journeyFactory.getAlphabeticalCourtListPageJourney();
		assertTrue("Unable to reach the alphabetical court page",
				  PageFactory.getAlphabeticalCourtListPage(driver).verifyOnPage());
	}


	@Then("^I collect all the details for each court listed for <letter>:$")
	public void i_collect_all_the_details_for_each_court_listed_for_letter(List<String> letter) throws Throwable {		
		for (int index = 1; index < letter.size(); index++){
		  PageFactory.getAlphabeticalCourtListPage(driver).selectLetter(letter.get(index).toLowerCase());
		  PageFactory.getAlphabeticalCourtListPage(driver).collectCourtDetailsOnPage(letter.get(index).toLowerCase(), fileName);
		}
	}
	
	@Then("^I save all the court details$")
	public void i_save_all_the_court_details() throws Throwable {
	    Storage.append(fileName, "]}");
	}

}
