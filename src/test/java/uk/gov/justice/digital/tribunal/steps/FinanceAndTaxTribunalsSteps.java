package uk.gov.justice.digital.tribunal.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.factories.PageFactory;
import uk.gov.justice.digital.courtfinder.helpers.Storage;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;

import java.util.List;

public class FinanceAndTaxTribunalsSteps {
	
	private WebDriver driver;
	private JourneyFactory journeyFactory;
	
	public FinanceAndTaxTribunalsSteps(SharedDriver driver){
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}	
	
	@Given("^I am on  (\\d+) finance and tax tribunal record$")
	public void i_am_on_finance_and_tax_tribunal_record(int recordNumber) throws Throwable {
	    journeyFactory.getFinanceAndTaxTribunalPageJourney(recordNumber);
	    assertTrue(PageFactory.getFinanceAndTaxTribunalPage(driver).verifyOnPage());

	}	
	
	@When("^I verify the following tribunal values:$")
	public void i_verify_the_following_tribunal_values(List<List<String>> values) throws Throwable {
       assertTrue(PageFactory.getFinanceAndTaxTribunalPage(driver).verifyTaxAndFinanceRecord(values));
	}	

	@Then("^I need to retrieve (\\d+) records to file \"(.*?)\"$")
	public void i_need_to_retrieve_records_to_file(int records, String fileName) throws Throwable {
		Storage.deleteFile(fileName);
		int recordCount = 0;
	    for (int loop=1; loop < records+1; loop++){
	    	journeyFactory.getFinanceAndTaxTribunalPageJourney(loop);
	    	if (PageFactory.getFinanceAndTaxTribunalPage(driver).verifyOnPage()){
	    		recordCount++;
	    		Storage.append(fileName,PageFactory.getFinanceAndTaxTribunalPage(driver).getRecord());
	    	}

	    }
	    System.out.println("count: " + recordCount);

	}

}
