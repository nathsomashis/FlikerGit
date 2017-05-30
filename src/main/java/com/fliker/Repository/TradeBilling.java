package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="TradeBilling")
public class TradeBilling {

	@Id
	private String billingid;
	private String billingamount;
	private String billedfrom;
	private String billedto;
	public String getBillingid() {
		return billingid;
	}
	public void setBillingid(String billingid) {
		this.billingid = billingid;
	}
	public String getBillingamount() {
		return billingamount;
	}
	public void setBillingamount(String billingamount) {
		this.billingamount = billingamount;
	}
	public String getBilledfrom() {
		return billedfrom;
	}
	public void setBilledfrom(String billedfrom) {
		this.billedfrom = billedfrom;
	}
	public String getBilledto() {
		return billedto;
	}
	public void setBilledto(String billedto) {
		this.billedto = billedto;
	}
	
	
	
}
