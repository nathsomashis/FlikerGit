package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OSMTrade")
public class OSMTrade {

	@Id
	private String osmtradeid;
	private String osmbiddingprice;
	private String closingvalue;
	private String openingvalue;
	private String osmbiddingamount;
	private String osmtradesellingownerid;
	private String osmmodelid;
	public String getOsmtradeid() {
		return osmtradeid;
	}
	public void setOsmtradeid(String osmtradeid) {
		this.osmtradeid = osmtradeid;
	}
	public String getOsmbiddingprice() {
		return osmbiddingprice;
	}
	public void setOsmbiddingprice(String osmbiddingprice) {
		this.osmbiddingprice = osmbiddingprice;
	}
	public String getClosingvalue() {
		return closingvalue;
	}
	public void setClosingvalue(String closingvalue) {
		this.closingvalue = closingvalue;
	}
	public String getOpeningvalue() {
		return openingvalue;
	}
	public void setOpeningvalue(String openingvalue) {
		this.openingvalue = openingvalue;
	}
	public String getOsmbiddingamount() {
		return osmbiddingamount;
	}
	public void setOsmbiddingamount(String osmbiddingamount) {
		this.osmbiddingamount = osmbiddingamount;
	}
	public String getOsmtradesellingownerid() {
		return osmtradesellingownerid;
	}
	public void setOsmtradesellingownerid(String osmtradesellingownerid) {
		this.osmtradesellingownerid = osmtradesellingownerid;
	}
	public String getOsmmodelid() {
		return osmmodelid;
	}
	public void setOsmmodelid(String osmmodelid) {
		this.osmmodelid = osmmodelid;
	}
	
	
	
	
	
}
