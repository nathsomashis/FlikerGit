package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Invoice")
public class Invoice {

	@Id
	private String invoiceid;
	private String invoiceitem;
	private String invoiceprice;
	private String invoicebuyer;
	private String invoicedate;
	private String invoicelocaldate;
	
	
	
	public String getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}
	public String getInvoicelocaldate() {
		return invoicelocaldate;
	}
	public void setInvoicelocaldate(String invoicelocaldate) {
		this.invoicelocaldate = invoicelocaldate;
	}
	public String getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(String invoiceid) {
		this.invoiceid = invoiceid;
	}
	public String getInvoiceitem() {
		return invoiceitem;
	}
	public void setInvoiceitem(String invoiceitem) {
		this.invoiceitem = invoiceitem;
	}
	public String getInvoiceprice() {
		return invoiceprice;
	}
	public void setInvoiceprice(String invoiceprice) {
		this.invoiceprice = invoiceprice;
	}
	public String getInvoicebuyer() {
		return invoicebuyer;
	}
	public void setInvoicebuyer(String invoicebuyer) {
		this.invoicebuyer = invoicebuyer;
	}
	
	
	
	
}
