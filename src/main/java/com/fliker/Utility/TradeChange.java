package com.fliker.Utility;

public class TradeChange {

	public String change(String preiviousprice, String pricechange){
		
		String newprice = "";
		
		newprice = preiviousprice + pricechange;
		
		return newprice;
	}

	public String changeLike(String companystockprice, int length) {
		// TODO Auto-generated method stub
		
		String newprice = "";
		
		int newvalue = (1/length);
		
		newprice = companystockprice + newvalue+0.005;
		
		return newprice;
	}

	public String changeShare(String companystockprice, int length) {
		// TODO Auto-generated method stub
		String newprice = "";
		
		int newvalue = (1/length);
		
		newprice = companystockprice + newvalue+0.025;
		
		return newprice;
	}
	
	
}
