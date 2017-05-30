package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OSMStakeHold")
public class OSMStakeHolding {

	@Id
	private String stakeholdingid;
	private String stakeownerid;
	private String stakeamount;
	private String stakestokpriceid;
	private String stakeholderlocation;
	private String stakepercentage;
	private String starstokprice;
	
	
	
	public String getStakepercentage() {
		return stakepercentage;
	}
	public void setStakepercentage(String stakepercentage) {
		this.stakepercentage = stakepercentage;
	}
	public String getStarstokprice() {
		return starstokprice;
	}
	public void setStarstokprice(String starstokprice) {
		this.starstokprice = starstokprice;
	}
	public String getStakeholderlocation() {
		return stakeholderlocation;
	}
	public void setStakeholderlocation(String stakeholderlocation) {
		this.stakeholderlocation = stakeholderlocation;
	}
	public String getStakeholdingid() {
		return stakeholdingid;
	}
	public void setStakeholdingid(String stakeholdingid) {
		this.stakeholdingid = stakeholdingid;
	}
	public String getStakeownerid() {
		return stakeownerid;
	}
	public void setStakeownerid(String stakeownerid) {
		this.stakeownerid = stakeownerid;
	}
	public String getStakeamount() {
		return stakeamount;
	}
	public void setStakeamount(String stakeamount) {
		this.stakeamount = stakeamount;
	}
	public String getStakestokpriceid() {
		return stakestokpriceid;
	}
	public void setStakestokpriceid(String stakestokpriceid) {
		this.stakestokpriceid = stakestokpriceid;
	}
	

	
	
	
}
