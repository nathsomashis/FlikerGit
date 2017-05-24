package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="TradePreBuy")
public class TradePreBuyData {

	private String tradeprebuyid;
	private String osmmodelid;
	private String osmstakeholdingid;
	private String userid;
	private String buystarttime;
	private String buyendtime;
	private String[] lockedtradepresaleamount; //priority on the basis of trade pre sale timing. 
	private String billingextendtime;
	private String currentstockprice;
	private String stockamount;
	private String[] billingsid;
	public String getTradeprebuyid() {
		return tradeprebuyid;
	}
	public void setTradeprebuyid(String tradeprebuyid) {
		this.tradeprebuyid = tradeprebuyid;
	}
	public String getOsmmodelid() {
		return osmmodelid;
	}
	public void setOsmmodelid(String osmmodelid) {
		this.osmmodelid = osmmodelid;
	}
	public String getOsmstakeholdingid() {
		return osmstakeholdingid;
	}
	public void setOsmstakeholdingid(String osmstakeholdingid) {
		this.osmstakeholdingid = osmstakeholdingid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBuystarttime() {
		return buystarttime;
	}
	public void setBuystarttime(String buystarttime) {
		this.buystarttime = buystarttime;
	}
	public String getBuyendtime() {
		return buyendtime;
	}
	public void setBuyendtime(String buyendtime) {
		this.buyendtime = buyendtime;
	}
	public String[] getLockedtradepresaleamount() {
		return lockedtradepresaleamount;
	}
	public void setLockedtradepresaleamount(String[] lockedtradepresaleamount) {
		this.lockedtradepresaleamount = lockedtradepresaleamount;
	}
	public String getBillingextendtime() {
		return billingextendtime;
	}
	public void setBillingextendtime(String billingextendtime) {
		this.billingextendtime = billingextendtime;
	}
	public String getCurrentstockprice() {
		return currentstockprice;
	}
	public void setCurrentstockprice(String currentstockprice) {
		this.currentstockprice = currentstockprice;
	}
	public String getStockamount() {
		return stockamount;
	}
	public void setStockamount(String stockamount) {
		this.stockamount = stockamount;
	}
	public String[] getBillingsid() {
		return billingsid;
	}
	public void setBillingsid(String[] billingsid) {
		this.billingsid = billingsid;
	}
	
	
	
	
	
}
