package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtFinderCourtDetailsPage extends SeleniumPage {
	
	private By pageIdentifier = new By.ById("courts-show");

	
	private By courtTitle = new By.ByXPath(".//*[@id='content']/header/h1");

	public CourtFinderCourtDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifyCourtTitle(String court) throws Exception{
		return isTextContainedInInnerText(courtTitle, court);
	}
	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
		return isElementPresent(pageIdentifier);
	}

}
