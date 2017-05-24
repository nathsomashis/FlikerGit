package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="TradePreSale")
public class TradePreSaleData {

	private String tradepresaleid;
	private String osmmodelid;
	private String userid;
	private String osmstakeholdingid;
	private String salestartdate;
	private String saleenddate;
	private String saleamount;
	private String salestockprice;
	private String startcompundamount;
	private String lockedcompoundamount;
	private String leftcompundamount;
	private String[] lockedid;
	private String[] billingsid;
	
	
	
	
	public String[] getBillingsid() {
		return billingsid;
	}
	public void setBillingsid(String[] billingsid) {
		this.billingsid = billingsid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTradepresaleid() {
		return tradepresaleid;
	}
	public void setTradepresaleid(String tradepresaleid) {
		this.tradepresaleid = tradepresaleid;
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
	public String getSalestartdate() {
		return salestartdate;
	}
	public void setSalestartdate(String salestartdate) {
		this.salestartdate = salestartdate;
	}
	public String getSaleenddate() {
		return saleenddate;
	}
	public void setSaleenddate(String saleenddate) {
		this.saleenddate = saleenddate;
	}
	public String getSaleamount() {
		return saleamount;
	}
	public void setSaleamount(String saleamount) {
		this.saleamount = saleamount;
	}
	public String getSalestockprice() {
		return salestockprice;
	}
	public void setSalestockprice(String salestockprice) {
		this.salestockprice = salestockprice;
	}
	public String getStartcompundamount() {
		return startcompundamount;
	}
	public void setStartcompundamount(String startcompundamount) {
		this.startcompundamount = startcompundamount;
	}
	public String getLockedcompoundamount() {
		return lockedcompoundamount;
	}
	public void setLockedcompoundamount(String lockedcompoundamount) {
		this.lockedcompoundamount = lockedcompoundamount;
	}
	public String getLeftcompundamount() {
		return leftcompundamount;
	}
	public void setLeftcompundamount(String leftcompundamount) {
		this.leftcompundamount = leftcompundamount;
	}
	public String[] getLockedid() {
		return lockedid;
	}
	public void setLockedid(String[] lockedid) {
		this.lockedid = lockedid;
	}
	
	
	
	
	
}
