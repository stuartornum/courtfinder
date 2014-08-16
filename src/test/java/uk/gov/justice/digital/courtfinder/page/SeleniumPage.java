package uk.gov.justice.digital.courtfinder.page;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import uk.gov.justice.digital.courtfinder.factories.ConfigurationFactory;




public class SeleniumPage {

	protected final WebDriver driver;
	protected static final int HTTP_TIMEOUT = 30;
	
	public SeleniumPage(WebDriver driver){
		this.driver = driver;
	}
	
    public boolean isCurrentUrl(String aURL) {
        return  driver.getCurrentUrl().equals(aURL);
    }

    public String getCurrentUrl()
    {
        return  driver.getCurrentUrl();
    }

    public void getUrl(String sURL)
    {
    	driver.get(sURL);
    }

	private WebElement findElement(By by) {
		try {
			return driver.findElement(by);
		} catch (NoSuchElementException nse) {
			assertFalse("Unable to find element : " + by.toString(), true);
		}
		return null;
	}

	public void dragElementDown(By by, int numberOfPixelsToDragTheScrollbarDown) {
		Actions dragger = new Actions(driver);
		WebElement draggablePartOfScrollbar = findElement(by);
		dragger.moveToElement(draggablePartOfScrollbar).clickAndHold()
				.moveByOffset(0, numberOfPixelsToDragTheScrollbarDown)
				.release().perform();
	}

	public void waitImplicitSeconds(int seconds) {
		driver.manage().timeouts()
				.implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public void switcthToIFrame(int id) {
		driver.switchTo().frame(id);
	}


	public void switchToDefaultDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean isInnerTextEmpty(By by) {
		return findElement(by).getText().isEmpty();
	}

	public void setSelectOptionByIndex(By by, int index) {
		new Select(findElement(by)).selectByIndex(index);
	}

	public void setSelectOptionByVisibleText(By by, String selection) {
		new Select(findElement(by)).selectByVisibleText(selection);
	}

	public void setSelectOptionByValue(By by, String value) {
		new Select(findElement(by)).selectByValue(value);
	}

	public int getNumberOfSelectOptions(By by){
		Select se = new Select(driver.findElement(by));
		List<WebElement> l = se.getOptions();
		return l.size();
	}
	
	public int getNumberOfListItems(By by){;
		List<WebElement> l = driver.findElements(by);
		return l.size();
	}
	
	public boolean isSelected(By by) {
		return findElement(by).isSelected();
	}

	public boolean isDisplayed(By by) {
		return findElement(by).isDisplayed();
	}

	public boolean isEnabled(By by) {
		return findElement(by).isEnabled();
	}

	public boolean isTextPresent(String expectedText) {
		return driver.getPageSource()
				.contains(expectedText);
	}

	public boolean isInnerTextEqualToExpectedText(By by, String expectedText) {
		String textValue = findElement(by).getText().trim();
		if ((textValue != null) && (textValue.equalsIgnoreCase(expectedText))) {
			return true;
		}
		assertFalse("Expected Text : " + expectedText + "/nActual Text: "
				+ textValue, true);
		return false;
	}

	public boolean isTextContainedInInnerText(By by, String expectedText)
			throws Exception {
		String actualText = findElement(by).getText();
		if ((actualText != null) && (actualText.contains(expectedText))) {
			return true;
		} else
			throw new Exception("Error: isTextContainedInInnerText \n"
					+ "expected: " + expectedText + "\n actual: " + actualText);
	}

	public boolean isTextEqualToAttributeValue(By by, String attribute,
			String expectedText) throws Exception {
		String actualText = findElement(by).getAttribute(attribute);
		if ((actualText != null) && (actualText.equalsIgnoreCase(expectedText))) {
			return true;
		} else
			throw new Exception("Error: isTextEqualToAttributeValue \n"
					+ "expected: " + expectedText + "\n actual: " + actualText);
	}

	public boolean isTextContainedInAttribute(By by, String attribute,
			String expectedText) throws Exception {
		String actualText = findElement(by).getAttribute(attribute);
		if ((actualText != null) && (actualText.contains(expectedText))) {
			return true;
		} else
			throw new Exception("Error: isTextContainedInAttibute \n"
					+ "expected: " + expectedText + "\n actual: " + actualText);
	}

	public boolean isLinkRedirectedToExpectedURL(By by, String expectedText,
			String currentURL) throws Exception {
		findElement(by).click();
		if (driver.getCurrentUrl()
				.contains(expectedText)) {
			driver.get(currentURL);
			return true;
		} else {
			throw new Exception("Invalid Link : \n" + "Expected : "
					+ expectedText + "\n" + "Actual   : "
					+ driver.getCurrentUrl());
		}

	}

	public boolean isListEmpty(By by) {
		return driver.findElements(by).isEmpty();
	}

	public WebElement getElement(By by) {
		return findElement(by);
	}

	public List<WebElement> getElements(By by) {
		return driver.findElements(by);
	}

	public String getText(By by) {
		return findElement(by).getText();
	}

	public String getAttributeValue(WebElement element, String attribute) {
		String value = element.getAttribute(attribute);
		if (value == null)
			return "";
		else
			return value;
	}

	public void setText(By by, String inText) {
		findElement(by).clear();
		findElement(by).sendKeys(inText);
	}

	public WebElement waitToGetElement(By by, int waitinseconds) throws Exception {
		try {
		WebElement element = new WebDriverWait(driver,
				waitinseconds).until(ExpectedConditions
				.presenceOfElementLocated(by));
		return element;
		}
		catch(TimeoutException e){
			throw new Exception("Timed out after 30 seconds waiting for presence of element located by: " + by.toString());
		}
	}


	public boolean isElementPresent(By by) {
		try {
			findElement(by);
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public void click(By by) {
		if (ConfigurationFactory.getWebDriverName().equalsIgnoreCase(ConfigurationFactory.chromeBrowser)){
			WebElement element = driver.findElement(by);

			Actions actions = new Actions(driver);

			actions.moveToElement(element).click().perform();	
		}else
		  findElement(by).click();
		
	}

	public boolean verifyOnPageByElement(By by) {
		waitForPageLoaded();
		return isElementPresent(by);
	}

	public boolean verifyOnPage() throws Exception {
		waitForPageLoaded();
		return false;
	}

	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, HTTP_TIMEOUT);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			assertFalse("Timeout waiting for Page Load Request to complete.",
					true);
		}
	}
	

	
    public void capturePageScreenShot(String sFileName)
    {
        try {
            File scrnsht =
                    ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrnsht, new
                    File(sFileName+".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Wait for iSecs
     * @param iSecs
     */
    public void pause(int iSecs)
    {
        try{
            (new WebDriverWait(driver, iSecs))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("-1")));
        }
        catch(TimeoutException x)
        {}
    }    
   
    public boolean atCurrentUrl(String sExpURL) {
        assertTrue("Page Validation Fails.", driver.getCurrentUrl().contains(sExpURL));
        return true;
    }

    static public void assertTrue(String message, boolean condition) {
        if (!condition)
            fail(message);
    }
    
    private static void fail(String message)
    {
        AssertionError e = new AssertionError(message);
        e.fillInStackTrace();
        StackTraceElement[] stackTrace = e.getStackTrace();
        final int FRAMES_TO_POP = stackTrace.length;
        StackTraceElement[] newStackTrace = new StackTraceElement[stackTrace.length-FRAMES_TO_POP];
        e.setStackTrace(newStackTrace);
        throw e;
    }    
    
    
	protected boolean isCookieAvailableByName(String cookieName) {
		if (driver.manage().getCookieNamed(cookieName) != null)
		   return true;
		else 
		   return false;
	}    
    
    public boolean isAlertPresent() {

        boolean presentFlag = false;

        try {

            // Check the presence of alert
            Alert alert = driver.switchTo().alert();
            // Alert present; set the flag
            presentFlag = true;
            // if present consume the alert
            alert.accept();

        } catch (NoAlertPresentException ex) {
            // Alert not present
            ex.printStackTrace();
        }
        return presentFlag;

    }
    
    public void refresh()
    {
        driver.navigate().refresh();
    }

}
