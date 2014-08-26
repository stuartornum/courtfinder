package uk.gov.justice.digital.tribunal.steps;

import static org.junit.Assert.assertTrue;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.factories.PageFactory;
import uk.gov.justice.digital.courtfinder.helpers.Storage;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;

public class HESChamberCareStandardsSteps {
	
	private WebDriver driver;
	private JourneyFactory journeyFactory;
	
	public HESChamberCareStandardsSteps(SharedDriver driver){
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}	
			
	
	@Given("^I am on (\\d+) HESCC care standards record$")
	public void i_am_on_HESCC_care_standards_record(int recordNumber) throws Throwable {
	    journeyFactory.getHESCChamberCareStandardsPageJourney(recordNumber);
	    assertTrue(PageFactory.getHESCChamberCareStandardsPage(driver).verifyOnPage());
	}

	@When("^I verify the following HESCC care standards values:$")
	public void i_verify_the_following_HESCC_care_standards_values(List<List<String>> values) throws Throwable {
	      assertTrue(PageFactory.getHESCChamberCareStandardsPage(driver).verifyHSEChamberCareStandardRecord(values));
	}

	@Then("^I need to retrieve (\\d+) HESCC care standards records to file \"(.*?)\"$")
	public void i_need_to_retrieve_HESCC_care_standards_records_to_file(int records, String fileName) throws Throwable {
		Storage.deleteFile(fileName);
		int recordCount = 0;
	    for (int loop=1; loop < records+1; loop++){
	    	journeyFactory.getHESCChamberCareStandardsPageJourney(loop);;
	    	if (PageFactory.getHESCChamberCareStandardsPage(driver).verifyOnPage()){
	    		recordCount++;
	    		Storage.append(fileName,PageFactory.getHESCChamberCareStandardsPage(driver).getRecord());
	    	}

	    }
	    System.out.println("count: " + recordCount);
	}
	

}
