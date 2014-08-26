package uk.gov.justice.digital.courtfinder.steps;

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

public class AdministrativeAppealsSteps {
	
	private WebDriver driver;
	private JourneyFactory journeyFactory;
	
	public AdministrativeAppealsSteps(SharedDriver driver){
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}	
		
	
	@Given("^I am on (\\d+) administrative appeals record$")
	public void i_am_on_administrative_appeals_record(int recordNumber) throws Throwable {
	    journeyFactory.getAdministrativeAppealsPageJourney(recordNumber);
	    assertTrue(PageFactory.getAdministrativeAppealPage(driver).verifyOnPage());

	}

	@When("^I verify the following administrative appeals values:$")
	public void i_verify_the_following_administrative_appeals_values(List<List<String>> values) throws Throwable {
	      assertTrue(PageFactory.getAdministrativeAppealPage(driver).verifyAdministrativeAppealsRecord(values));

	}

	@Then("^I need to retrieve (\\d+) administrative appeals records to file \"(.*?)\"$")
	public void i_need_to_retrieve_administrative_appeals_records_to_file(int records, String fileName) throws Throwable {
		Storage.deleteFile(fileName);
		int recordCount = 0;
	    for (int loop=1; loop < records+1; loop++){
	    	journeyFactory.getAdministrativeAppealsPageJourney(loop);
	    	if (PageFactory.getAdministrativeAppealPage(driver).verifyOnPage()){
	    		recordCount++;
	    		Storage.append(fileName,PageFactory.getAdministrativeAppealPage(driver).getRecord());
	    	}

	    }
	    System.out.println("count: " + recordCount);
	}	

}
