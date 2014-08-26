package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtfinderSearchSelectionPage extends SeleniumPage {
	
	private By pageTitle = new By.ByXPath("");
	private String expectedPageTitle =  "Choose the type of search you would like to do";
	
	private By postcodeSearch = new By.ById("postcode-search");
	private By addressSearch  = new By.ById("name-address-search");
	private By listView       = new By.ById("list-view");
	
	
	private By continueButton  = new By.ByXPath("continue");
	
	
	public void clickPostcodeSearch() throws Exception{
		click(postcodeSearch);
	}
	
	public void clickaddressSearch() throws Exception{
		click(addressSearch);
	}
	
	public void clickContinueButton() throws Exception{
		click(continueButton);
	}
	
	public void clickListView() throws Exception{
		click(listView);
	}

	public CourtfinderSearchSelectionPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
	  	return isTextContainedInInnerText(pageTitle, expectedPageTitle);
	}

}
