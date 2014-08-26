package uk.gov.justice.digital.tribunal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class PropertyChamberLandRegistrationPage extends SeleniumPage {
	
	public PropertyChamberLandRegistrationPage(WebDriver driver) {
		super(driver);
	}

	private By pageTitle = new By.ByXPath(".//*[@id='contentarea']/h1");
	private String expectedPageTitle = "Decision summary";
	private By decisionNumber = new By.ByXPath(
			".//*[@id='lblref1']");
	private By dateOfDecision = new By.ByXPath(
			".//*[@id='lblHdate']");	
	private By adjudicator = new By.ByXPath(".//*[@id='lblDadj']");
	private By appellant = new By.ByXPath(
			".//*[@id='lblApp']");
	private By respondent = new By.ByXPath(
			".//*[@id='lblResp']");

	private By mainCategory = new By.ByXPath(
			".//*[@id='lblCat1']");
	private By subCategory = new By.ByXPath(
			".//*[@id='lblScat1']");
	private By secondaryCategory = new By.ByXPath(
			".//*[@id='lblCat2']");
	private By secondarySubCategory = new By.ByXPath(
			".//*[@id='lblScat2']");	
	private By summary = new By.ByXPath(".//*[@id='contentarea']/table/tbody/tr[12]/td");
	private By link = new By.ByXPath(".//*[@id='contentarea']/table/tbody/tr[13]/td/a");

	public String getDecisionNumber() throws Exception {
		return getText(decisionNumber).trim();
	}
	
	public String getLink(){
		String decisionLink = "";
		String decisionLinks = "";
		try{
			List<WebElement> elements = getElements(link);
			for (int index=0; index < elements.size(); index ++){
				decisionLink = getAttributeValue(elements.get(index), "href");
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

	public String getAppellant() throws Exception {
		return getText(appellant).trim();
	}

	public String getRespondent() throws Exception {
		return getText(respondent).trim();
	}

	public String getAdjudicator() throws Exception {
		return getText(adjudicator).trim();
	}

	public String getDateOfDecision() throws Exception {
		return getText(dateOfDecision).trim();
	}

	public String getMainCategory() throws Exception {
		return getText(mainCategory).trim();
	}

	public String getSubCategory() throws Exception {
		return getText(subCategory);
	}
	
	public String getSecondaryCategory() throws Exception {
		return getText(secondaryCategory).trim();
	}

	public String getSecondarySubCategory() throws Exception {
		return getText(secondarySubCategory);
	}	


	public boolean verifyOnPage() throws Exception {
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
		builder.append(getAppellant() + "||");
		builder.append(getRespondent() + "||");
		builder.append(getAdjudicator() +  "||");
		builder.append(getDateOfDecision() +"||");
		builder.append(getMainCategory() + "||");
		builder.append(getSubCategory() + "||");
		builder.append(getSummary() + "||");
		builder.append(getLink() + "||" );
		builder.append(getSecondaryCategory() + "||");
		builder.append(getSecondarySubCategory());
		//System.out.println(builder.toString());
		return builder.toString();
	}

	public boolean verifyPropertyChamberLandRegistration(List<List<String>> values)
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
				if (!fieldValue.contains(getDateOfDecision()))
					throw new Exception(systemMessage(fieldValue,
							getDateOfDecision()));
				break;
			}
			case 3: {
				if (!fieldValue.contains(getAdjudicator()))
					throw new Exception(systemMessage(fieldValue,
							getAdjudicator()));
				break;
			}
			case 4: {
				if (!fieldValue.contains(getAppellant()))
					throw new Exception(systemMessage(fieldValue,
							getAppellant()));
				break;
			}
			case 5: {
				if (!fieldValue.contains(getRespondent()))
					throw new Exception(systemMessage(fieldValue,
							getRespondent()));
				break;
			}
			case 6: {
				if (!fieldValue.contains(getMainCategory()))
					throw new Exception(systemMessage(fieldValue,
							getMainCategory()));
				break;
			}
			case 7: {
				if (!fieldValue.contains(getSubCategory()))
					throw new Exception(systemMessage(fieldValue,
							getSubCategory()));
				break;
			}
			case 8: {
				if (!fieldValue.contains(getSecondaryCategory()))
					throw new Exception(systemMessage(fieldValue,
							getSecondaryCategory()));
				break;
			}
			case 9: {
				if (!fieldValue.contains(getSecondarySubCategory()))
					throw new Exception(systemMessage(fieldValue,
							getSecondarySubCategory()));
				break;
			}
			case 10: {
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


