package uk.gov.justice.digital.tribunal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class FinanceAndTaxTribunalPage extends SeleniumPage {

	private By pageTitle = new By.ByXPath("html/body/h1");
	private String expectedPageTitle = "Decision Summary Information";
	private By decisionNumber = new By.ByXPath(
			".//*[@id='Table1']/tbody/tr[1]/td[2]");
	private By appellant = new By.ByXPath(
			".//*[@id='Table1']/tbody/tr[2]/td[2]");
	private By respondent = new By.ByXPath(
			".//*[@id='Table1']/tbody/tr[3]/td[2]");
	private By chair = new By.ByXPath(".//*[@id='Table1']/tbody/tr[4]/td[2]");
	private By dateOfDecision = new By.ByXPath(
			".//*[@id='Table1']/tbody/tr[5]/td[2]");
	private By mainCategory = new By.ByXPath(
			".//*[@id='Table1']/tbody/tr[6]/td[2]");
	private By subCategory = new By.ByXPath(
			".//*[@id='Table1']/tbody/tr[7]/td[2]");
	private By summary = new By.ByXPath(".//*[@id='Table1']/tbody/tr[8]/td[2]");
	private By link = new By.ByXPath(".//*[@id='Table1']/tbody/tr[9]/td[2]/a");

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

	public String getAppellant() throws Exception {
		return getText(appellant).trim();
	}

	public String getRespondent() throws Exception {
		return getText(respondent).trim();
	}

	public String getChair() throws Exception {
		return getText(chair).trim();
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

	public FinanceAndTaxTribunalPage(WebDriver driver) {
		super(driver);
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
		builder.append(getChair() +  "||");
		builder.append(getDateOfDecision() +"||");
		builder.append(getMainCategory() + "||");
		builder.append(getSubCategory() + "||");
		builder.append(getSummary() + "||");
		builder.append(getLink() );
		//System.out.println(builder.toString());
		return builder.toString();
	}

	public boolean verifyTaxAndFinanceRecord(List<List<String>> values)
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
				if (!fieldValue.contains(getAppellant()))
					throw new Exception(systemMessage(fieldValue,
							getAppellant()));
				break;
			}
			case 3: {
				if (!fieldValue.contains(getRespondent()))
					throw new Exception(systemMessage(fieldValue,
							getRespondent()));
				break;
			}
			case 4: {
				if (!fieldValue.contains(getChair()))
					throw new Exception(systemMessage(fieldValue,
							getChair()));
				break;
			}
			case 5: {
				if (!fieldValue.contains(getDateOfDecision()))
					throw new Exception(systemMessage(fieldValue,
							getDateOfDecision()));
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
			}
		}
		return true;
	}

}
