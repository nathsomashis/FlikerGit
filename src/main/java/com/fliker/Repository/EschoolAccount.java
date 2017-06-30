package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="EschoolAccount")
public class EschoolAccount {

	@Id
	private String accountid;
	private String paypalaccounturl;
	private String[] billid;
	private String[] invoiceid;
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getPaypalaccounturl() {
		return paypalaccounturl;
	}
	public void setPaypalaccounturl(String paypalaccounturl) {
		this.paypalaccounturl = paypalaccounturl;
	}
	public String[] getBillid() {
		return billid;
	}
	public void setBillid(String[] billid) {
		this.billid = billid;
	}
	public String[] getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(String[] invoiceid) {
		this.invoiceid = invoiceid;
	}
	
	
	
}

