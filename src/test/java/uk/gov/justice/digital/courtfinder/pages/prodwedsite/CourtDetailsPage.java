package uk.gov.justice.digital.courtfinder.pages.prodwedsite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtDetailsPage extends SeleniumPage{
	
   private By courtHeaderText = new By.ByCssSelector(".page-header.group>h1");
   private By courtPhoto = new By.ByXPath(".//*[@id='court-photo']");
   
   //DownloadImage(By.xpath("//*[@id='content']/div/div[1]/div/div/div[1]/img"),
//			"D:\\Download\\image.png");  


   
	
	public CourtDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifyOnPage(String court) throws Exception{
		waitForPageLoaded();
		return isInnerTextEqualToExpectedText(courtHeaderText, court);
	}
	
	
	

}
