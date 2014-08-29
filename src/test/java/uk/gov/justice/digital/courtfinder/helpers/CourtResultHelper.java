package uk.gov.justice.digital.courtfinder.helpers;

public class CourtResultHelper {
	
	private String courtName;
	private String courtNameUrl;
	
	public String getCourtName() {
		return courtName;
	}
	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}
	public String getCourtNameUrl() {
		return courtNameUrl;
	}
	public void setCourtNameUrl(String courtNameUrl) {
		this.courtNameUrl = courtNameUrl;
	}	
	
	public String asString(){
		return courtName + "||" + courtNameUrl;
	}
	
	public String asJSONString(){
		return "{courtname = \"" + courtName + "\"," + "courturl = \"" + courtNameUrl + "\"}";
	}

}
