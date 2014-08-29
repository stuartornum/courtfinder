package uk.gov.justice.digital.courtfinder.pages.prodwedsite;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uk.gov.justice.digital.courtfinder.helpers.CourtResultHelper;
import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class AlphabeticalCourtListPage extends SeleniumPage {
	
	private By pageTitle = new By.ByXPath(".//*[@id='content']/header/h1");
	private String expectedPageTitle = "Courts and tribunals";
	
	private String alphabeticalSelector = "//*/a[@href='#courts-by-%s']";
	private String courtLink = ".//*[@id='courts-by-%s']/a";
	
	public void clickCourt(String letter) throws Exception{
		click(new By.ByXPath(String.format(courtLink, letter)));
	}

	public AlphabeticalCourtListPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
		return isInnerTextEqualToExpectedText(pageTitle, expectedPageTitle);
	}

	public void selectLetter(String letter) throws Exception {
		click(new By.ByXPath(String.format(alphabeticalSelector, letter)));
		
	}

	public void collectCourtDetailsOnPage(String letter) throws Exception {
		String courtLetterLink = String.format(courtLink, letter);
		List<WebElement> elements = getElements(new By.ByXPath(courtLetterLink));
		for (int index = 1; index <= elements.size(); index++){
			CourtResultHelper helper = new CourtResultHelper();
			helper.setCourtName(getText(new By.ByXPath(courtLetterLink+"["+index+"]")));
			helper.setCourtNameUrl(getAttributeValue(elements.get(index-1), "href"));
			System.out.println(helper.asString());
			System.out.println(helper.asJSONString());
			//URL url = new URL("https://courtfinder-servicegovuk-production.s3.amazonaws.com/images/abergavenny_magistrates_court.jpg");
			//System.out.println(url.);
		}
	}

}
