package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtfinderPostcodSearchPage extends SeleniumPage {
	
	private By searchPostcode = new By.ByXPath(".//*[@name='postcode']");
	
	private By filterAllCourts = new By.ById("aol-0");
	private By filterYourLegalProblem = new By.ByXPath("");
	private By filterAdoption = new By.ByXPath(".//*[@value='Adoption']");
	private By filterBankruptcy = new By.ByXPath(".//*[@value='Bankruptcy']");
	private By filterCivilPartnerships = new By.ByXPath(".//*[@value='Civil partnership']");
	private By filterChildren = new By.ByXPath(".//*[@value='Children']");
	private By filterCrime = new By.ByXPath(".//*[@value='Crime']");
	private By filterDivorce = new By.ByXPath(".//*[@value='Divorce']");
	private By filterDomesticViolence = new By.ByXPath(".//*[@value='Domestic violence']");
	private By filterEmployment = new By.ByXPath(".//*[@value='Employment']");
	private By filterForcedMarriage = new By.ByXPath(".//*[@value='Forced marriage']");
	private By filterHousingPossession = new By.ByXPath(".//*[@value='Housing possession']");
	private By filterImmigration = new By.ByXPath(".//*[@value='Immigration']");
	private By filterMoneyClaims = new By.ByXPath(".//*[@value='Money claims']");
	private By filterProbate = new By.ByXPath(".//*[@value='Probate']");
	private By filterSocialSecurity = new By.ByXPath(".//*[@value='Social security']");
//	private By filterHighCourt = new By.ByXPath(".//*[@value='High Court']");
	
	private By continueButton = new By.ById("continue");
	
	private By pageTitle = new By.ByXPath(".//*[@id='content']/div/form/fieldset/label[1]/div[1]");
	private String expectedPageTitle = "Search by postcode";
	
	private By errorNoPostcodeEntered = new By.ByXPath(".//*[@class='validation-error']");
	private String expectedErrorTextNoPostcodeEntered = "You did not enter a postcode. Please try again.";
	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
		return isInnerTextEqualToExpectedText(pageTitle, expectedPageTitle);
	}
	
	public void clickContinue() throws Exception{
		click(continueButton);
	}
	
	
	private void selectAllCourts() throws Exception{
		click(filterAllCourts);
	}

	private void selectYourLegalProm() throws Exception{
		click(filterYourLegalProblem);
	}
	
	private void selectAdoption() throws Exception{
		click(filterAdoption);
	}
	
	private void selectBankruptcy() throws Exception{
		click(filterBankruptcy);
	}
	
	private void selectCivilPartnerships() throws Exception{
		click(filterCivilPartnerships);
	}
	
	private void selectChildren() throws Exception{
		click(filterChildren);
	}
	
	private void selectCrime() throws Exception{
		click(filterCrime);
	}
	
	private void selectDivorce() throws Exception{
		click(filterDivorce);
	}
	
	private void selectDomesticViolence() throws Exception{
		click(filterDomesticViolence);
	}
	
	private void selectEmployment() throws Exception{
		click(filterEmployment);
	}
	
	private void selectForcedMarriage() throws Exception{
		click(filterForcedMarriage);
	}
	
	private void selectHousingPossession() throws Exception{
		click(filterHousingPossession);
	}
	
	private void selectImmigration() throws Exception{
		click(filterImmigration);
	}
	
	private void selectMoneyClaims() throws Exception{
		click(filterMoneyClaims);
	}
	
	private void selectProbate() throws Exception{
		click(filterProbate);
	}
	
	private void selectSocialSecurity() throws Exception{
		click(filterSocialSecurity);
	}
	
	public void setSearchPostcode(String postcode) throws Exception{
		setText(searchPostcode, postcode);
	}

	public CourtfinderPostcodSearchPage(WebDriver driver) {
		super(driver);
	}
	
	private void setSpecificAreaOfLaw(String areaOfLaw) throws Exception{
		//selectYourLegalProm();
		if (areaOfLaw.equalsIgnoreCase("adoption"))
			selectAdoption();
		else if (areaOfLaw.equalsIgnoreCase("bankruptcy"))
			selectBankruptcy();
		else if (areaOfLaw.equalsIgnoreCase("civil partnership"))
			selectCivilPartnerships();
		else if (areaOfLaw.equalsIgnoreCase("children"))
			selectChildren();
		else if (areaOfLaw.equalsIgnoreCase("crime"))
			selectCrime();
		else if (areaOfLaw.equalsIgnoreCase("divorce"))
			selectDivorce();
		else if (areaOfLaw.equalsIgnoreCase("domestic violence"))
			selectDomesticViolence();
		else if (areaOfLaw.equalsIgnoreCase("employment"))
			selectEmployment();
		else if (areaOfLaw.equalsIgnoreCase("forced marriage"))
			selectForcedMarriage();
		else if (areaOfLaw.equalsIgnoreCase("housing possession"))
			selectHousingPossession();
		else if (areaOfLaw.equalsIgnoreCase("immigration"))
			selectImmigration();
		else if (areaOfLaw.equalsIgnoreCase("money claims"))
			selectMoneyClaims();
		else if (areaOfLaw.equalsIgnoreCase("probate"))
			selectProbate();
		else if (areaOfLaw.equalsIgnoreCase("social security"))
			selectSocialSecurity();
		else
			throw new Exception("Unknown area of law : " + areaOfLaw);
	}
		

	public void setAreaOfLaw(String areaOfLaw) throws Exception {
		String aol = areaOfLaw.toLowerCase().trim();
		if (aol.equalsIgnoreCase("all courts and tribunals")){
			selectAllCourts();
		}else{
			setSpecificAreaOfLaw(aol);
		}
		
		
	}

	public boolean verifyErrorPromptEnterPostcode() throws Exception {
		waitToGetElement(errorNoPostcodeEntered, HTTP_TIMEOUT);
		return isTextContainedInInnerText(errorNoPostcodeEntered, expectedErrorTextNoPostcodeEntered);
	}

}
