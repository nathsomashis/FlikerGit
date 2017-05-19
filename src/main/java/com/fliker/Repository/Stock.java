package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Stock")
public class Stock {

	@Id
	private String stockid;
	private String companyid;
	private String stockprice;
	private String stockamount;
	private String openingvalue;
	private String closingvalue;
	public String getStockid() {
		return stockid;
	}
	public void setStockid(String stockid) {
		this.stockid = stockid;
	}
	public String getCompanyid() {
		return companyid;
	}
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	public String getStockprice() {
		return stockprice;
	}
	public void setStockprice(String stockprice) {
		this.stockprice = stockprice;
	}
	public String getStockamount() {
		return stockamount;
	}
	public void setStockamount(String stockamount) {
		this.stockamount = stockamount;
	}
	public String getOpeningvalue() {
		return openingvalue;
	}
	public void setOpeningvalue(String openingvalue) {
		this.openingvalue = openingvalue;
	}
	public String getClosingvalue() {
		return closingvalue;
	}
	public void setClosingvalue(String closingvalue) {
		this.closingvalue = closingvalue;
	}
	
	
	
}
