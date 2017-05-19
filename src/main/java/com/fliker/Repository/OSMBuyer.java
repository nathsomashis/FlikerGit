package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OSMBuyer")
public class OSMBuyer {

	@Id
	private String buyerid;
	private String buyerlocation;
	private String buyercluster; //according to supplymodule, supply percentage
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
