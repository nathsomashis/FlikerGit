package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OSMProjectInvestment")
public class OSMProjectInvestment {

	
	@Id
	private String osmstakeholdingid;
	private String osmmodelid;
	private String[] osminvestmentdoc;
	private String osminvestorslink;
	private String osmstakedivision;
	private String osminvestmentdescription;
	private String osminvestmenttermsandcondition;
	
	
	
	public String getOsminvestmentdescription() {
		return osminvestmentdescription;
	}
	public void setOsminvestmentdescription(String osminvestmentdescription) {
		this.osminvestmentdescription = osminvestmentdescription;
	}
	public String getOsminvestmenttermsandcondition() {
		return osminvestmenttermsandcondition;
	}
	public void setOsminvestmenttermsandcondition(String osminvestmenttermsandcondition) {
		this.osminvestmenttermsandcondition = osminvestmenttermsandcondition;
	}
	public String getOsmstakedivision() {
		return osmstakedivision;
	}
	public void setOsmstakedivision(String osmstakedivision) {
		this.osmstakedivision = osmstakedivision;
	}
	public String getOsmstakeholdingid() {
		return osmstakeholdingid;
	}
	public void setOsmstakeholdingid(String osmstakeholdingid) {
		this.osmstakeholdingid = osmstakeholdingid;
	}
	public String getOsmmodelid() {
		return osmmodelid;
	}
	public void setOsmmodelid(String osmmodelid) {
		this.osmmodelid = osmmodelid;
	}
	
	public String getOsminvestorslink() {
		return osminvestorslink;
	}
	public void setOsminvestorslink(String osminvestorslink) {
		this.osminvestorslink = osminvestorslink;
	}
	public String[] getOsminvestmentdoc() {
		return osminvestmentdoc;
	}
	public void setOsminvestmentdoc(String[] osminvestmentdoc) {
		this.osminvestmentdoc = osminvestmentdoc;
	}
	
	
	
}
