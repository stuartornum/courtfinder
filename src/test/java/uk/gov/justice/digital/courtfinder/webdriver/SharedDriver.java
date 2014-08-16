package uk.gov.justice.digital.courtfinder.webdriver;


import cucumber.api.java.*;
import cucumber.api.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import uk.gov.justice.digital.courtfinder.factories.ConfigurationFactory;

/**
 * Example of a WebDriver implementation that automatically closes at the end of
 * each scenario, and can be shared across step definitions via dependency
 * injection.
 */
public class SharedDriver extends EventFiringWebDriver {
	
	public SharedDriver() {
		super(ConfigurationFactory.getWebDriver());
	}

	@After
	public void close(Scenario scenario) {
		try {
			if (scenario.isFailed()) {
				byte[] screenshot = ((TakesScreenshot) this)
						.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			System.err
					.println(somePlatformsDontSupportScreenshots.getMessage());
		} finally {
			this.quit();
		}
	}
}
