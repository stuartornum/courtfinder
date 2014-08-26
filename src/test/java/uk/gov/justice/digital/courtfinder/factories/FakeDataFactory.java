package uk.gov.justice.digital.courtfinder.factories;

public class FakeDataFactory {
	
	public static String getFinanceAndTaxTribunalsUrl(){
		return "http://www.financeandtaxtribunals.gov.uk/Aspx/view.aspx?id=%d";		

	}
	
	public static String getPropertyChamberLandRegistrationUrl(){
		return "http://www.ahmlr.gov.uk/Public/summary.aspx?id=%d";
	}	
	
	public static String getHESCChamberCareStandardsUrl(){
		return "http://www.carestandardstribunal.gov.uk/public/View.aspx?ID=%d";
	}
	
	public static String getAdministtrativeAppealsUrl(){
		return "http://www.osscsc.gov.uk/Aspx/view.aspx?id=%d";
	}	
	
	public static String getSearchPageUrl(){
		return "https://courttribunalfinder.service.gov.uk/";
	}
	
	public static String getPostcode(){
		return "CM233FE";
	}
	
	public static String getCourtFinderStartPageUrl(){
		return "https://courttribunalfinder.service.gov.uk/";
	}

}
