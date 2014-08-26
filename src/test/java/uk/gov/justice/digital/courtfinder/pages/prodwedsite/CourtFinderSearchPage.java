package uk.gov.justice.digital.courtfinder.pages.prodwedsite;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtFinderSearchPage extends SeleniumPage {
	
	private By searchPageTitle = new By.ByXPath(".//*[@id='content']/header/h1");
	private String expectedSearchTitleText = "Court and tribunal finder";	 
   
	private By searchTextBox = new By.ByXPath(".//*[@id='search-main']");
	
	private By areaOfLawDropDown = new By.ByXPath(".//*[@id='area_of_law']");
	
	private By searchButton = new By.ByXPath(".//*[@id='filters']/button");
	
	private By areaOfLawErrorText = new By.ByCssSelector(".error-text");
	private String expectedAreaOfLawErrorText = "You must select an area of law";
	
	private By resultsFromPartailNameEntry = new By.ByXPath(".//*[@id='results']/ul/li");
	private String resultsFromPartialNameEntryLink = ".//*[@id='results']/ul/li[%d]/a";
	
	
	public void setResultFromPartialNameEntryByName(String courtOrTribunalName) throws Exception{
		waitToGetElement(resultsFromPartailNameEntry, HTTP_TIMEOUT);
		List<WebElement> elements = getElements(resultsFromPartailNameEntry);
		for (int index= 0; index < elements.size(); index++){
			if (elements.get(index).getText().equalsIgnoreCase(courtOrTribunalName)){
				click(new By.ByXPath(String.format(resultsFromPartialNameEntryLink,index+1)));
				return;
			}
		}
		throw new Exception("No such court or tribunal in result list found that is named : " + courtOrTribunalName);
	}
	
	public boolean verifyareaOfLawErrorText() throws Exception{
		return isTextContainedInInnerText(areaOfLawErrorText, expectedAreaOfLawErrorText);
	}
	
	public boolean isSearchButtonEnabled() throws Exception{
		return isEnabled(searchButton);
	}
	
	public void clickSearchButton() throws Exception{
		click(searchButton);
	}
	
	public void clickAreaOfLawDropDown() throws Exception{
		click(areaOfLawDropDown);
	}
	
	public void setSelectionByVisibleText(String selection) throws Exception{
		setSelectOptionByVisibleText(areaOfLawDropDown, selection);
	}
	
	public void setSearchText(String searchText) throws Exception{
		setText(searchTextBox, searchText);
	}
	
	
	
	public CourtFinderSearchPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
		return this.isInnerTextEqualToExpectedText(searchPageTitle, expectedSearchTitleText);
	}
	

}
