package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OSMProjectSeller")
public class OSMProjectSeller {

	@Id
	private String projectsellerid;
	private String osmmodelid;
	private String sellerdescription;
	private String sellingmarketdoc;
	private String[] sellingplanid;
	private String[] sellingcontractid;
	private String[] sellinglicenseid;
	
	
	
	public String[] getSellingplanid() {
		return sellingplanid;
	}
	public void setSellingplanid(String[] sellingplanid) {
		this.sellingplanid = sellingplanid;
	}
	public String[] getSellingcontractid() {
		return sellingcontractid;
	}
	public void setSellingcontractid(String[] sellingcontractid) {
		this.sellingcontractid = sellingcontractid;
	}
	public String[] getSellinglicenseid() {
		return sellinglicenseid;
	}
	public void setSellinglicenseid(String[] sellinglicenseid) {
		this.sellinglicenseid = sellinglicenseid;
	}
	public String getProjectsellerid() {
		return projectsellerid;
	}
	public void setProjectsellerid(String projectsellerid) {
		this.projectsellerid = projectsellerid;
	}
	public String getOsmmodelid() {
		return osmmodelid;
	}
	public void setOsmmodelid(String osmmodelid) {
		this.osmmodelid = osmmodelid;
	}
	public String getSellerdescription() {
		return sellerdescription;
	}
	public void setSellerdescription(String sellerdescription) {
		this.sellerdescription = sellerdescription;
	}
	public String getSellingmarketdoc() {
		return sellingmarketdoc;
	}
	public void setSellingmarketdoc(String sellingmarketdoc) {
		this.sellingmarketdoc = sellingmarketdoc;
	}
	
	
	
	
}
