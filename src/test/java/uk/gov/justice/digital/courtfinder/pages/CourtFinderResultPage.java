package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtFinderResultPage extends SeleniumPage {
	
	protected String courtTitle = ".//*[@id='content']/div/div/ul/li[%d]/div[1]/a";
	protected By numberOfResults = new By.ById("number-of-results");		

	public CourtFinderResultPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	public int getNumberOfResults() throws NumberFormatException, Exception{
		String result = "";
		try
		{
			result = getText(numberOfResults);
		}catch( Exception e){
			return -1;
		}
		return Integer.valueOf(result);
	}	
	
	public boolean verifyCourtResults(String courts) throws Exception {
		String[] results = courts.split(",");
		String courtName = "";
		boolean courtFound = false;
        //loop results
		for (int resultIndex = 1; resultIndex <= getNumberOfResults(); resultIndex++ ){
		   courtName = (getCourtNameAtIndex(resultIndex));
		   courtFound =false;
		   for (int index = 0; index < results.length;index++){
			   if (courtName.equalsIgnoreCase(results[index]))
				  courtFound = true;
		    }
		if (courtFound)
			break;
		}
		return courtFound;
	}
	
	public boolean verifyNumberOfCourtsFound(int numberOfCourtsFound) throws NumberFormatException, Exception {
		return ( getNumberOfResults() == numberOfCourtsFound);
	}	
	
	public String getCourtNameAtIndex(int index) throws Exception{
		String text = getText(new By.ByXPath(String.format(courtTitle, index))); 
		return text;
	}	

}
