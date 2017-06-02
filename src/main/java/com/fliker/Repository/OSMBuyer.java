package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OSMBuyer")
public class OSMBuyer {

	@Id
	private String buyerid;
	private String buyerlocation;
	private String buyercluster; //according to supplymodule, supply percentage
	private String contractid;
	private String planid;
	private String licenseid;
	
	
	public String getContractid() {
		return contractid;
	}
	public void setContractid(String contractid) {
		this.contractid = contractid;
	}
	public String getPlanid() {
		return planid;
	}
	public void setPlanid(String planid) {
		this.planid = planid;
	}
	public String getLicenseid() {
		return licenseid;
	}
	public void setLicenseid(String licenseid) {
		this.licenseid = licenseid;
	}
	public String getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
	}
	public String getBuyerlocation() {
		return buyerlocation;
	}
	public void setBuyerlocation(String buyerlocation) {
		this.buyerlocation = buyerlocation;
	}
	public String getBuyercluster() {
		return buyercluster;
	}
	public void setBuyercluster(String buyercluster) {
		this.buyercluster = buyercluster;
	}
	
	
	
	
	
}
