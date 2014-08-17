package uk.gov.justice.digital.courtfinder.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtDetailsPage extends SeleniumPage{
	
   private By courtHeaderText = new By.ByCssSelector(".page-header.group>h1");
	
	public CourtDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifyOnPage(String court) throws InterruptedException{
		waitForPageLoaded();
		return isInnerTextEqualToExpectedText(courtHeaderText, court);
	}
	

}
