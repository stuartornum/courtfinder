package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtFinderAddressSearchResultPage extends CourtFinderResultPage{
	
	private By pageTitle = new By.ByXPath(".//*[@id='content']/div/form/label/div[2]");
	private String expectedPageTitle = "Enter part of the court or tribunal name or address.";
	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
		return isTextContainedInInnerText(pageTitle, expectedPageTitle);
	}

	public CourtFinderAddressSearchResultPage(WebDriver driver) {
		super(driver);
	}

}
