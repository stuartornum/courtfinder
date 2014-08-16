package uk.gov.justice.digital.courtfinder.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtFinderSearchPage extends SeleniumPage {
	
	private By searchPageTitle = new By.ByXPath(".//*[@id='content']/header/h1");
	private String expectedSearchTitleText = "Court and tribunal finder";	 
   
	private By searchTextBox = new By.ByXPath(".//*[@id='search-main']");
	
	private By areaOfLawDropDown = new By.ByXPath(".//*[@id='area_of_law']");
	
	private By searchButton = new By.ByXPath(".//*[@id='filters']/button");
	
	private By areaOfLawErrorText = new By.ByCssSelector(".error-text");
	private String expectedAreaOfLawErrorText = "You must select an area of law";
	
	public boolean verifyareaOfLawErrorText() throws Exception{
		return isTextContainedInInnerText(areaOfLawErrorText, expectedAreaOfLawErrorText);
	}
	
	public boolean isSearchButtonEnabled(){
		return isEnabled(searchButton);
	}
	
	public void clickSearchButton(){
		click(searchButton);
	}
	
	public void clickAreaOfLawDropDown(){
		click(areaOfLawDropDown);
	}
	
	public void setSelectionByVisibleText(String selection){
		setSelectOptionByVisibleText(areaOfLawDropDown, selection);
	}
	
	public void setSearchText(String searchText){
		setText(searchTextBox, searchText);
	}
	
	
	
	public CourtFinderSearchPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifyOnPage(){
		waitForPageLoaded();
		return this.isInnerTextEqualToExpectedText(searchPageTitle, expectedSearchTitleText);
	}
	

}
