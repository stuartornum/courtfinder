package uk.gov.justice.digital.courtfinder.pages.prodwedsite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import uk.gov.justice.digital.courtfinder.helpers.CourtResultHelper;
import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtDetailsPage extends SeleniumPage {

	private By courtHeaderText = new By.ByCssSelector(".page-header.group>h1");
	private By courtPhoto = new By.ByXPath(".//*[@id='court-photo']");

	private By courtName = new By.ByXPath(".//*[@id='content']/header/h1");

	private By courtPostalAddress = new By.ByXPath(".//*[@class='postal']/h3");

	private By courtPostcode = new By.ByXPath(".//*[@property='postalCode']");
	private By courtTown = new By.ByXPath(".//*[@property='addressLocality']");
	private By courtCounty = new By.ByXPath(".//*[@property='addressRegion']");
	private By courtAddress = new By.ByXPath(".//*[@property='streetAddress']");
	private By courtMap = new By.ByXPath(".//*[@class='maps']/a");

	private By courtDX = new By.ByXPath(
			".//*[@class='for-legal-professionals']/p");

	// DownloadImage(By.xpath("//*[@id='content']/div/div[1]/div/div/div[1]/img"),
	// "D:\\Download\\image.png");

	public By getCourtPhoto() {
		return courtPhoto;
	}

	public void setCourtPhoto(By courtPhoto) {
		this.courtPhoto = courtPhoto;
	}

	public By getCourtName() {
		return courtName;
	}

	public void setCourtName(By courtName) {
		this.courtName = courtName;
	}

	private String saveCourtImage() throws Exception {
		String[] saveFilename = getAttributeValue(getElement(courtPhoto), "src")
				.split("/");
		DownloadImage(courtPhoto, saveFilename[4]);
		return saveFilename[4];
	}

	private String getDetailElement(int index, By by) {
		List<WebElement> elements = getElements(by);
		String result = "";
		try {
			result = elements.get(index).getText();
		} catch (Exception e) {
			return "";
		}
		return result;
	}

	public String getVisitingPostcode() {
		return getDetailElement(0, courtPostcode);
	}

	public String getPostalPostcode() {
		return getDetailElement(1, courtPostcode);
	}

	public String getCourtDX() throws Exception {
		String dx = "";
		try {
			dx = getText(courtDX);
		} catch (Exception e) {
			return "";
		}
		return dx;
	}

	public String getCourtMap() throws Exception {
		String map = "";

		try {
			map = getAttributeValue(getElement(courtMap), "href");
		} catch (Exception e) {
			return "";
		}
		return map;
	}

	public String getVisitingCounty() {
		String county = "";
		try {
			county = getDetailElement(0, courtCounty);
		} catch (Exception e) {
			return "";
		}
		return county;
	}

	public String getPostalCounty() {
		String county = "";
		try {
			county = getDetailElement(1, courtCounty);
		} catch (Exception e) {
			return "";
		}
		return county;
	}

	public String getVisitingAddress() {
		return getDetailElement(0, courtAddress);
	}

	public String getPostalAddress() {
		return getDetailElement(1, courtAddress);
	}

	public String getVisitingTown() {
		return getDetailElement(0, courtTown);
	}

	public String getPostalTown() {
		return getDetailElement(1, courtTown);
	}

	public void scrapeDetails(CourtResultHelper helper) throws Exception {
		helper.setVisitingPostcode(getVisitingPostcode());
		helper.setVisitingAddress(getVisitingAddress());
		helper.setVisitingTown(getVisitingTown());
		helper.setVisitingCounty(getVisitingCounty());
		helper.setMap(getCourtMap());
		helper.setCourtDX(getCourtDX());
		if (isElementPresent(courtPhoto))
			helper.setPhotoName(saveCourtImage());
		else
			helper.setPhotoName("");
	}

	public CourtDetailsPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyOnPage(String court) throws Exception {
		waitForPageLoaded();
		return isInnerTextEqualToExpectedText(courtHeaderText, court);
	}

	public boolean hasPostalAddress() {
		try {
			isElementPresent(courtPostalAddress);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
