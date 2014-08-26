package uk.gov.justice.digital.tribunal.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.factories.PageFactory;
import uk.gov.justice.digital.courtfinder.helpers.Storage;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PropertyChamberLandRegistrationSteps {
	
	private WebDriver driver;
	private JourneyFactory journeyFactory;
	
	public PropertyChamberLandRegistrationSteps(SharedDriver driver){
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}	
		
	
	
	@Given("^I am on  (\\d+) property chamber land registration record$")
	public void i_am_on_property_chamber_land_registration_record(int recordNumber) throws Throwable {
	    journeyFactory.getPropertyChamberLandRegistrationPageJourney(recordNumber);
	    assertTrue(PageFactory.getPropertyChamberLandRegistrationPage(driver).verifyOnPage());
	}	
	
	
	@When("^I verify the following property chamber land registration values:$")
	public void i_verify_the_following_property_chamber_land_registration_values(List<List<String>> values) throws Throwable {
	      assertTrue(PageFactory.getPropertyChamberLandRegistrationPage(driver).verifyPropertyChamberLandRegistration(values));

	}	
	
	@Then("^I need to retrieve (\\d+) property chamber land registration records to file \"(.*?)\"$")
	public void i_need_to_retrieve_property_chamber_land_registration_records_to_file(int records, String fileName) throws Throwable {
		Storage.deleteFile(fileName);
		int recordCount = 0;
	    for (int loop=1; loop < records+1; loop++){
	    	journeyFactory.getPropertyChamberLandRegistrationPageJourney(loop);;
	    	if (PageFactory.getPropertyChamberLandRegistrationPage(driver).verifyOnPage()){
	    		recordCount++;
	    		Storage.append(fileName,PageFactory.getPropertyChamberLandRegistrationPage(driver).getRecord());
	    	}

	    }
	    System.out.println("count: " + recordCount);
	}

}
