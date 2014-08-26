package uk.gov.justice.digital.courtfinder.pages.prodwedsite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtFinderSearchResultPage extends SeleniumPage{
	
	private By searchResultPageTitle = new By.ByXPath(".//*[@id='content']/header/h1");
	private String expectedSearchResultPageTitle = "Search results";
    private By searchResearchList = new By.ByXPath(".//*[@id='content']/div/article/div/ul/li");
	private String searchResultItem = ".//*[@id='content']/div/article/div/ul/li[%d]/div/a[1]";
	
	private By errorMessageForNI = new By.ByXPath(".//*[@id='content']/div/article/div/p");
	private String expectedErrorMessageForNI = "We are sorry, Northern Ireland is not supported by this tool";

	private By     courtResultItem = new By.ByCssSelector(".court-title");
	private String viewDetailsLink = ".//*[@id='content']/div/article/div/ul/li[%d]/div/a[2]";

    private By errorMessageForInvalidCourtOrPostcode = new By.ByXPath(".//*[@id='content']/div/article/div/p[1]");	
	private String expectedErrorMessageForInvalidCourtOrPostcode = "Your search for %s did not return any results.";
	private String expectedErrorMessageForPostcode = "We couldn't find that post code. Please try again.";
    
	private int positionOfCountInResultList(String court){
		List<WebElement> elements = getElements(courtResultItem);
		for (int index=0; index < elements.size(); index++){
			if ( elements.get(index).getText().equalsIgnoreCase(court) )
			   return index+1;
		}
		return -1;
	}
	
	public void clickViewDetailsLink(String court) throws Exception{
		int position = positionOfCountInResultList(court);
		click(new By.ByXPath(String.format(viewDetailsLink, position)));
	}
	
	public boolean isNorthernIrelandErrorTextVisible() throws Exception{
		return getText(errorMessageForNI).equalsIgnoreCase(expectedErrorMessageForNI);
	}
	
	public CourtFinderSearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	public String getCourtNameAtIndex(int index) throws Exception{
		String text = getText(new By.ByXPath(String.format(searchResultItem, index))); 
		return text;
	}
	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
		return isInnerTextEqualToExpectedText(searchResultPageTitle, expectedSearchResultPageTitle);
	}

	public int getNumberOfCourtResults() {
		return getNumberOfListItems(searchResearchList);
	}
	
	public boolean verifyErrorDisplayedForInvalidCourtOrPostcode(String value) throws Exception{
        String expectedMessage = String.format(expectedErrorMessageForInvalidCourtOrPostcode, value);
		return isTextContainedInInnerText(errorMessageForInvalidCourtOrPostcode ,expectedMessage);
	}

	public boolean verifyErrorDisplayedForInvalidPostcode() throws Exception {
			return isTextContainedInInnerText(errorMessageForInvalidCourtOrPostcode ,expectedErrorMessageForPostcode);

	}

}
