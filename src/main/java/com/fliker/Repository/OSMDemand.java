package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OSMDemand")
public class OSMDemand {

	@Id
	private String osmdemandid;
	private String osmlikeid;
	private String osmshareid;
	private String osmsubscriptionid;
	private String osmstockpricevariation;
	private String osmdemandvariation;//like rating, share , subscription location, like location
	private String osmdemandcomplexity;//subscription type, subscribtion location
	public String getOsmdemandid() {
		return osmdemandid;
	}
	public void setOsmdemandid(String osmdemandid) {
		this.osmdemandid = osmdemandid;
	}
	public String getOsmlikeid() {
		return osmlikeid;
	}
	public void setOsmlikeid(String osmlikeid) {
		this.osmlikeid = osmlikeid;
	}
	public String getOsmshareid() {
		return osmshareid;
	}
	public void setOsmshareid(String osmshareid) {
		this.osmshareid = osmshareid;
	}
	public String getOsmsubscriptionid() {
		return osmsubscriptionid;
	}
	public void setOsmsubscriptionid(String osmsubscriptionid) {
		this.osmsubscriptionid = osmsubscriptionid;
	}
	public String getOsmstockpricevariation() {
		return osmstockpricevariation;
	}
	public void setOsmstockpricevariation(String osmstockpricevariation) {
		this.osmstockpricevariation = osmstockpricevariation;
	}
	public String getOsmdemandvariation() {
		return osmdemandvariation;
	}
	public void setOsmdemandvariation(String osmdemandvariation) {
		this.osmdemandvariation = osmdemandvariation;
	}
	public String getOsmdemandcomplexity() {
		return osmdemandcomplexity;
	}
	public void setOsmdemandcomplexity(String osmdemandcomplexity) {
		this.osmdemandcomplexity = osmdemandcomplexity;
	}
	
	
	
}
