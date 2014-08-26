package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;


import uk.gov.justice.digital.courtfinder.page.SeleniumPage;



public class CourtFinderStartPage extends SeleniumPage {
	
	private By pageTitle = new By.ByXPath("");
	private String expectedPageTitleText = "Find a court or tribunal";
	
	private By startButton = new By.ById("start-button");

	public CourtFinderStartPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickStartButton() throws Exception{
		click(startButton);
	}
	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
		return isInnerTextEqualToExpectedText(pageTitle, expectedPageTitleText);
	}

}
