package uk.gov.justice.digital.courtfinder.step;

public class HtmlStepContextSingleton {

	private static HtmlStepContext stepContext;

	public static HtmlStepContext getInstance() {
		if (stepContext == null) {
			return stepContext = new HtmlStepContext();
		} else
			return stepContext;
	}

}
