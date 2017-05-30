package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="TradeTemporarySale")
public class TradeTemporarySaleSorting {

	@Id
	private String tradetempsaleid;
	private String tradeenddatetime;
	private String tradecompositeamount;
	private String tradepresaleid;
	private String saleamount;
	
	
	
	public String getSaleamount() {
		return saleamount;
	}
	public void setSaleamount(String saleamount) {
		this.saleamount = saleamount;
	}
	public String getTradepresaleid() {
		return tradepresaleid;
	}
	public void setTradepresaleid(String tradepresaleid) {
		this.tradepresaleid = tradepresaleid;
	}
	public String getTradetempsaleid() {
		return tradetempsaleid;
	}
	public void setTradetempsaleid(String tradetempsaleid) {
		this.tradetempsaleid = tradetempsaleid;
	}
	public String getTradeenddatetime() {
		return tradeenddatetime;
	}
	public void setTradeenddatetime(String tradeenddatetime) {
		this.tradeenddatetime = tradeenddatetime;
	}
	public String getTradecompositeamount() {
		return tradecompositeamount;
	}
	public void setTradecompositeamount(String tradecompositeamount) {
		this.tradecompositeamount = tradecompositeamount;
	}
	
	
	
}
