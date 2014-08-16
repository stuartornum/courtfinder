package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtFinderSearchResultPage extends SeleniumPage{
	
	private By searchResultPageTitle = new By.ByXPath(".//*[@id='content']/header/h1");
	private String expectedSearchResultPageTitle = "Search results";
    private By searchResearchList = new By.ByXPath(".//*[@id='content']/div/article/div/ul/li");
	private String searchResultItem = ".//*[@id='content']/div/article/div/ul/li[%d]/div/a[1]";
	
	private By errorMessageForNI = new By.ByXPath(".//*[@id='content']/div/article/div/p");
	private String expectedErrorMessageForNI = "We are sorry, Northern Ireland is not supported by this tool";
	
	public boolean isNorthernIrelandErrorTextVisible(){
		return getText(errorMessageForNI).equalsIgnoreCase(expectedErrorMessageForNI);
	}
	
	public CourtFinderSearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	public String getCourtNameAtIndex(int index){
		String text = getText(new By.ByXPath(String.format(searchResultItem, index))); 
		return text;
	}
	
	public boolean verifyOnPage(){
		waitForPageLoaded();
		return isInnerTextEqualToExpectedText(searchResultPageTitle, expectedSearchResultPageTitle);
	}

	public int getNumberOfCourtResults() {
		// TODO Auto-generated method stub
		return getNumberOfListItems(searchResearchList);
	}

}
