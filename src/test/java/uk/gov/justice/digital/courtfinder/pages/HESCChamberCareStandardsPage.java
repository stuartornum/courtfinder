package uk.gov.justice.digital.courtfinder.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class HESCChamberCareStandardsPage extends SeleniumPage{

	public HESCChamberCareStandardsPage(WebDriver driver) {
		super(driver);
	}
	
	private By pageTitle = new By.ByXPath(".//*[@id='contentarea']/h1");
	private String expectedPageTitle = "Decision Summary Information";
	private By decisionNumber = new By.ByXPath(
			".//*[@id='contentarea']/table/tbody/tr[1]/td");
	private By decisionName = new By.ByXPath(".//*[@id='contentarea']/table/tbody/tr[2]/td");
	private By dateOfDecision = new By.ByXPath(
			".//*[@id='contentarea']/table/tbody/tr[3]/td");	
	private By schedule = new By.ByXPath(".//*[@id='contentarea']/table/tbody/tr[4]/td");

	private By mainCategory = new By.ByXPath(
			".//*[@id='contentarea']/table/tbody/tr[5]/td");
	private By subCategory = new By.ByXPath(
			".//*[@id='contentarea']/table/tbody/tr[6]/td");
	private By summary = new By.ByXPath(".//*[@id='contentarea']/table/tbody/tr[7]/td");
	private By link = new By.ByXPath(".//*[@id='contentarea']/table/tbody/tr[8]/td/a");

	public String getDecisionNumber() throws Exception {
		return getText(decisionNumber).trim();
	}
	
	public String getDecisionName() throws Exception {
		return getText(decisionName).trim();
	}	
	
	public String getLink(){
		String decisionLink = "";
		String decisionLinks = "";
		try{
			List<WebElement> elements = getElements(link);
			for (int index=0; index < elements.size(); index ++){
				decisionLink = getAttributeValue(elements.get(index), "href");
				decisionLink.replace("..", "http://www.financeandtaxtribunals.gov.uk");
				if (index == 0)
					decisionLinks = decisionLink;
				else
					decisionLinks = decisionLinks + "," + decisionLink; 
			}
		} catch (Exception e)
		{
		}
		return decisionLinks; 
	}
	
	public String getSummary() throws Exception{
		
		return getText(summary).replace("\n", " ").replace("\r", " ");
	}

	public String getDateOfDecision() throws Exception {
		return getText(dateOfDecision).trim();
	}

	public String getMainCategory() throws Exception {
		return getText(mainCategory).trim();
	}
	
	public String getSchedule() throws Exception {
		return getText(schedule);
	}	

	public String getSubCategory() throws Exception {
		return getText(subCategory);
	}

	public boolean verifyOnPage() throws Exception {
		waitForPageLoaded();
		try
		{
		   return isTextContainedInInnerText(pageTitle, expectedPageTitle);
		}catch(Exception e){
			return false;
		}
	}

	private String systemMessage(String expected, String actual) {
		return String.format(
				"Record value not found : expected : %s \n actual : %s",
				expected, actual);
	}
	
	public String getRecord() throws Exception{
		StringBuilder builder = new StringBuilder();
		builder.append(getDecisionNumber() + "||");
		builder.append(getDecisionName() + "||");		
		builder.append(getDateOfDecision() +"||");
		builder.append(getSchedule() +"||");		
		builder.append(getMainCategory() + "||");
		builder.append(getSubCategory() + "||");
		builder.append(getSummary() + "||");
		builder.append(getLink() );
		System.out.println(builder.toString());
		return builder.toString();
	}

	public boolean verifyHSEChamberCareStandardRecord(List<List<String>> values)
			throws Exception {
		for (int index = 1; index < values.size(); index++) {
			String fieldValue = values.get(index).get(1).trim();
			switch (index) {
			case 1: {
				if (!fieldValue.contains(getDecisionNumber()))
					throw new Exception(systemMessage(fieldValue,
							getDecisionNumber()));
				break;
			}
			case 2: {
				if (!fieldValue.contains(getDecisionName()))
					throw new Exception(systemMessage(fieldValue,
							getDecisionName()));
				break;
			}
			case 3: {
				if (!fieldValue.contains(getDateOfDecision()))
					throw new Exception(systemMessage(fieldValue,
							getDateOfDecision()));
				break;
			}
			case 4: {
				if (!fieldValue.contains(getSchedule()))
					throw new Exception(systemMessage(fieldValue,
							getSchedule()));
				break;
			}			
			case 5: {
				if (!fieldValue.contains(getMainCategory()))
					throw new Exception(systemMessage(fieldValue,
							getMainCategory()));
				break;
			}
			case 6: {
				if (!fieldValue.contains(getSubCategory()))
					throw new Exception(systemMessage(fieldValue,
							getSubCategory()));
				break;
			}	
			case 7: {
				if (!fieldValue.contains(getSummary()))
					throw new Exception(systemMessage(fieldValue,
							getSummary()));
				break;
			}
			case 8: {
				if (!fieldValue.contains(getLink()))
					throw new Exception(systemMessage(fieldValue,
							getLink()));
				break;
			}			
			}
		}
		return true;
	}	

}
