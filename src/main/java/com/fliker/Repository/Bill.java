package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Bill")
public class Bill {

	private String billid;
	private String contractid;
	private String planid;
	private String licenseid;
	private String invoiceid;
	private String payfromid;
	private String paytoid;
	private String totalamount;
	private String item;
	private String paymentmethods;
	public String getBillid() {
		return billid;
	}
	public void setBillid(String billid) {
		this.billid = billid;
	}
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
	public String getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(String invoiceid) {
		this.invoiceid = invoiceid;
	}
	
	public String getPayfromid() {
		return payfromid;
	}
	public void setPayfromid(String payfromid) {
		this.payfromid = payfromid;
	}
	public String getPaytoid() {
		return paytoid;
	}
	public void setPaytoid(String paytoid) {
		this.paytoid = paytoid;
	}
	public String getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(String totalamount) {
		this.totalamount = totalamount;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getPaymentmethods() {
		return paymentmethods;
	}
	public void setPaymentmethods(String paymentmethods) {
		this.paymentmethods = paymentmethods;
	}
	
	
	
	
	
}
