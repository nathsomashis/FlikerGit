package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OSM")
public class OSMModel {
	
	@Id
	private String osmid;
	private String osmdemandid;
	private String osmsupplyid;
	private String osmstakeholdingid;
	private String osmhealthid;
	private String osmbackupid;
	private String osmpartnerid;
	private String[] osmdependentid;
	private String osmstockid;
	
	
	public String getOsmpartnerid() {
		return osmpartnerid;
	}
	public void setOsmpartnerid(String osmpartnerid) {
		this.osmpartnerid = osmpartnerid;
	}
	public String getOsmid() {
		return osmid;
	}
	public void setOsmid(String osmid) {
		this.osmid = osmid;
	}
	public String getOsmdemandid() {
		return osmdemandid;
	}
	public void setOsmdemandid(String osmdemandid) {
		this.osmdemandid = osmdemandid;
	}
	public String getOsmsupplyid() {
		return osmsupplyid;
	}
	public void setOsmsupplyid(String osmsupplyid) {
		this.osmsupplyid = osmsupplyid;
	}
	public String getOsmstakeholdingid() {
		return osmstakeholdingid;
	}
	public void setOsmstakeholdingid(String osmstakeholdingid) {
		this.osmstakeholdingid = osmstakeholdingid;
	}
	public String getOsmhealthid() {
		return osmhealthid;
	}
	public void setOsmhealthid(String osmhealthid) {
		this.osmhealthid = osmhealthid;
	}
	public String getOsmbackupid() {
		return osmbackupid;
	}
	public void setOsmbackupid(String osmbackupid) {
		this.osmbackupid = osmbackupid;
	}
	public String[] getOsmdependentid() {
		return osmdependentid;
	}
	public void setOsmdependentid(String[] osmdependentid) {
		this.osmdependentid = osmdependentid;
	}
	public String getOsmstockid() {
		return osmstockid;
	}
	public void setOsmstockid(String osmstockid) {
		this.osmstockid = osmstockid;
	}
	
	
	

}
