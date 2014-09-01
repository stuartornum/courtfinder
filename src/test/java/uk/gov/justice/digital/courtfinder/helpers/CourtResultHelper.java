package uk.gov.justice.digital.courtfinder.helpers;

public class CourtResultHelper {
	
	private String courtName;
	private String courtNameUrl;
	
	private String visitingPostcode;
	
	private String courtDX;
	private String visitingAddress;
	private String visitingCounty;
	private String visitingTown;
	private String map;
	
	private String photoName;
	
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	public String getVisitingAddress() {
		return visitingAddress;
	}
	public void setVisitingAddress(String visitingAddress) {
		this.visitingAddress = visitingAddress.replace("\n", ",");
	}
	public String getVisitingCounty() {
		return visitingCounty;
	}
	public void setVisitingCounty(String visitingCounty) {
		this.visitingCounty = visitingCounty;
	}
	public String getVisitingTown() {
		return visitingTown;
	}
	public void setVisitingTown(String visitingTown) {
		this.visitingTown = visitingTown;
	}
	public String getCourtDX() {
		return courtDX;
	}
	public void setCourtDX(String courtDX) {
		this.courtDX = courtDX;
	}
	public String getVisitingPostcode() {
		return visitingPostcode;
	}
	public void setVisitingPostcode(String visitingPostcoode) {
		this.visitingPostcode = visitingPostcoode;
	}
	
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
		return courtName + "||" + courtNameUrl+ "||"+ visitingAddress+ "||"+ visitingTown+ "||"+ visitingCounty+ "||"+ visitingPostcode+ "||"+ courtDX+ "||"+ map +"||"+ photoName;
	}
	
	public String asJSONString(){
		return "{\"name\" : \"" + courtName + "\"," +
				 "\"visitingaddress\" : \"" + visitingAddress + "\"," +
				 "\"visitingTown\" : \"" + visitingTown + "\"," +
				 "\"visitingCounty\" : \"" + visitingCounty + "\"," +
				 "\"visitingPostcode\" : \"" + visitingPostcode + "\"," +
				 "\"image\" : \"" + photoName + "\"," +
				 "\"map\" : \"" + map + "\"," +
	             "\"url\" : \"" + courtNameUrl +
	             "\"}";
	}

}
