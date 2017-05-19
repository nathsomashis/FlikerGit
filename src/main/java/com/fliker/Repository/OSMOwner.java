package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OSMOwner")
public class OSMOwner {

	@Id
	private String ownerid;
	private String[] companyprofileid;
	private String[] osmmodelid;
	public String getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}
	public String[] getCompanyprofileid() {
		return companyprofileid;
	}
	public void setCompanyprofileid(String[] companyprofileid) {
		this.companyprofileid = companyprofileid;
	}
	public String[] getOsmmodelid() {
		return osmmodelid;
	}
	public void setOsmmodelid(String[] osmmodelid) {
		this.osmmodelid = osmmodelid;
	}
	
	
	
	
}
