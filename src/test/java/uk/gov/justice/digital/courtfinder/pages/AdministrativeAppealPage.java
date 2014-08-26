package uk.gov.justice.digital.courtfinder.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class AdministrativeAppealPage extends SeleniumPage{

	public AdministrativeAppealPage(WebDriver driver) {
		super(driver);
	}
	
	private By pageTitle = new By.ByXPath(".//*[@id='contentarea']/h1");
	private String expectedPageTitle = "Decision Summary Information";
	private By neutralCitationNumber = new By.ByXPath(".//*[@id='form1']/table/tbody/tr[1]/td");
	private By reportedNumber = new By.ByXPath(
			".//*[@id='form1']/table/tbody/tr[2]/td");	
	private By fileNumber = new By.ByXPath(".//*[@id='form1']/table/tbody/tr[3]/td");
	private By appellant = new By.ByXPath(
			".//*[@id='form1']/table/tbody/tr[4]/td");
	private By respondent = new By.ByXPath(
			".//*[@id='form1']/table/tbody/tr[5]/td");
	private By judge = new By.ByXPath(
			".//*[@id='form1']/table/tbody/tr[6]/td");
	private By dateofDecision = new By.ByXPath(
			".//*[@id='form1']/table/tbody/tr[7]/td");
	private By dateAdded = new By.ByXPath(
			".//*[@id='form1']/table/tbody/tr[8]/td");	
	private By mainCategory = new By.ByXPath(
			".//*[@id='form1']/table/tbody/tr[9]/td");
	private By subCategory = new By.ByXPath(
			".//*[@id='form1']/table/tbody/tr[10]/td");
	private By secondaryCategory = new By.ByXPath(
			".//*[@id='form1']/table/tbody/tr[11]/td");
	private By secondarySubCategory = new By.ByXPath(
			".//*[@id='form1']/table/tbody/tr[12]/td");	
	private By summary = new By.ByXPath(".//*[@id='form1']/table/tbody/tr[13]/td");
	private By link = new By.ByXPath(".//*[@id='form1']/table/tbody/tr[14]/td/a");

	public String getReportedNumber() throws Exception {
		return getText(reportedNumber).trim();
	}

	public String getNeturalCitationNumber() throws Exception {
		return getText(neutralCitationNumber).trim();
	}	

	public String getFileNumber() throws Exception {
		return getText(fileNumber).trim();
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

	public String getJudge() throws Exception {
		return getText(judge).trim();
	}

	public String getDateOfDecision() throws Exception {
		return getText(dateofDecision).trim();
	}
	
	public String getDateAdded() throws Exception {
		return getText(dateAdded).trim();
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
		builder.append(getNeturalCitationNumber() + "||");
		builder.append(getReportedNumber() + "||");	
		builder.append(getFileNumber() + "||");			
		builder.append(getAppellant() + "||");
		builder.append(getRespondent() + "||");
		builder.append(getJudge() +  "||");
		builder.append(getDateOfDecision() +"||");
		builder.append(getDateAdded() +"||");
		builder.append(getMainCategory() + "||");
		builder.append(getSubCategory() + "||");
		builder.append(getSummary() + "||");
		builder.append(getLink() + "||" );
		builder.append(getSecondaryCategory() + "||");
		builder.append(getSecondarySubCategory());
		System.out.println(builder.toString());
		return builder.toString();
	}

	public boolean verifyAdministrativeAppealsRecord(List<List<String>> values)
			throws Exception {
		for (int index = 1; index < values.size(); index++) {
			String fieldValue = values.get(index).get(1).trim();
			switch (index) {
			case 1: {
				if (!fieldValue.contains(getNeturalCitationNumber()))
					throw new Exception(systemMessage(fieldValue,
							getNeturalCitationNumber()));
				break;
			}
			case 2: {
				if (!fieldValue.contains(getReportedNumber()))
					throw new Exception(systemMessage(fieldValue,
							getReportedNumber()));
				break;
			}			
			case 3: {
				if (!fieldValue.contains(getFileNumber()))
					throw new Exception(systemMessage(fieldValue,
							getFileNumber()));
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
				if (!fieldValue.contains(getJudge()))
					throw new Exception(systemMessage(fieldValue,
							getJudge()));
				break;
			}	
			case 7: {
				if (!fieldValue.contains(getDateOfDecision()))
					throw new Exception(systemMessage(fieldValue,
							getDateOfDecision()));
				break;
			}
			case 8: {
				if (!fieldValue.contains(getDateAdded()))
					throw new Exception(systemMessage(fieldValue,
							getDateAdded()));
				break;
			}			
			case 9: {
				if (!fieldValue.contains(getMainCategory()))
					throw new Exception(systemMessage(fieldValue,
							getMainCategory()));
				break;
			}
			case 10: {
				if (!fieldValue.contains(getSubCategory()))
					throw new Exception(systemMessage(fieldValue,
							getSubCategory()));
				break;
			}
			case 11: {
				if (!fieldValue.contains(getSecondaryCategory()))
					throw new Exception(systemMessage(fieldValue,
							getSecondaryCategory()));
				break;
			}
			case 12: {
				if (!fieldValue.contains(getSecondarySubCategory()))
					throw new Exception(systemMessage(fieldValue,
							getSecondarySubCategory()));
				break;
			}
			case 13: {
				if (!fieldValue.contains(getSummary()))
					throw new Exception(systemMessage(fieldValue,
							getSummary()));
				break;
			}
			case 14: {
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
