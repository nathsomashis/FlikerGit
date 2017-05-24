package com.fliker.Modal;

import com.fliker.Connection.MongoConnection;
import com.fliker.Utility.TradeChange;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class TradePreview {

	public String stockchangeonBuying(String osmmodelid){
		
		String newStock = "";
		
		MongoConnection mongoconosms = new MongoConnection();
		DBCursor resultosms = mongoconosms.getDBObject("osmmodelid", osmmodelid, "OSM");
		if(resultosms.hasNext()){
			DBObject osmprojObj = resultosms.next();
			
			String companystockid = (String)osmprojObj.get("osmstockid");
			String[] companystakeholdersid = (String[])osmprojObj.get("osmstakeholdingid");
			
			String companystockprice = "";
			String buypunch = "";
			
			MongoConnection mongoconstock = new MongoConnection();
			DBCursor resultstock = mongoconstock.getDBObject("stockid", companystockid, "Stock");
			if(resultstock.hasNext()){
				DBObject osmprojstock = resultstock.next();
				
				companystockprice = (String)osmprojstock.get("stockprice");
			}
			
			MongoConnection mongoconbuypunch = new MongoConnection();
			DBCursor resultbuypunch = mongoconbuypunch.getDBObject("osmmodelid", osmmodelid, "OSMModelPunch");
			if(resultbuypunch.hasNext()){
				DBObject osmbuypunch = resultbuypunch.next();
				
				buypunch = (String)osmbuypunch.get("onbuyerpriceincrease");
				
			}
			
			
			TradeChange tradechange = new TradeChange();
			String newPrice = tradechange.change(companystockprice, buypunch);
			
			MongoConnection mongoconnewprice = new MongoConnection();
			mongoconnewprice.updateObject(new BasicDBObject("stockid", companystockid), new BasicDBObject("$set", new BasicDBObject("stockprice", newPrice)), "Stock");
			
			
			for(int f=0;f<companystakeholdersid.length;f++){
				
				MongoConnection mongoconstakestock = new MongoConnection();
				DBCursor resultstakestock = mongoconstakestock.getDBObject("stakeholdingid", companystakeholdersid[f], "OSMStakeHold");
				if(resultstakestock.hasNext()){
					DBObject osmstakestock = resultstakestock.next();
					
					String stockidstake = (String)osmstakestock.get("stakestokpriceid");
					
					
					mongoconnewprice.updateObject(new BasicDBObject("stockid", stockidstake), new BasicDBObject("$set", new BasicDBObject("stockprice", newPrice)), "Stock");
				}
				
				
			}
			
			mongoconnewprice.updateObject(new BasicDBObject("osmmodelid", osmmodelid), new BasicDBObject("$push", new BasicDBObject("osmstockpricevariation", newPrice)), "OSMDemand");
			
			
		}
		
			
		
		return newStock;
	}

	public String stockchangeonSubscription(String osmmodelid, String userid) {
		// TODO Auto-generated method stub
		
		String newStock = "";
		
		MongoConnection mongoconosms = new MongoConnection();
		DBCursor resultosms = mongoconosms.getDBObject("osmmodelid", osmmodelid, "OSM");
		if(resultosms.hasNext()){
			DBObject osmprojObj = resultosms.next();
			
			String companystockid = (String)osmprojObj.get("osmstockid");
			String[] companystakeholdersid = (String[])osmprojObj.get("osmstakeholdingid");
			
			String companystockprice = "";
			String subscribepunch = "";
			
			MongoConnection mongoconstock = new MongoConnection();
			DBCursor resultstock = mongoconstock.getDBObject("stockid", companystockid, "Stock");
			if(resultstock.hasNext()){
				DBObject osmprojstock = resultstock.next();
				
				companystockprice = (String)osmprojstock.get("stockprice");
			}
			
			MongoConnection mongoconbuypunch = new MongoConnection();
			DBCursor resultbuypunch = mongoconbuypunch.getDBObject("osmmodelid", osmmodelid, "OSMModelPunch");
			if(resultbuypunch.hasNext()){
				DBObject osmbuypunch = resultbuypunch.next();
				
				subscribepunch = (String)osmbuypunch.get("onsubscribingpriceincrease");
				
			}
			
			
			TradeChange tradechange = new TradeChange();
			String newPrice = tradechange.change(companystockprice, subscribepunch);
			
			MongoConnection mongoconnewprice = new MongoConnection();
			mongoconnewprice.updateObject(new BasicDBObject("stockid", companystockid), new BasicDBObject("$set", new BasicDBObject("stockprice", newPrice)), "Stock");
			
			
			for(int f=0;f<companystakeholdersid.length;f++){
				
				MongoConnection mongoconstakestock = new MongoConnection();
				DBCursor resultstakestock = mongoconstakestock.getDBObject("stakeholdingid", companystakeholdersid[f], "OSMStakeHold");
				if(resultstakestock.hasNext()){
					DBObject osmstakestock = resultstakestock.next();
					
					String stockidstake = (String)osmstakestock.get("stakestokpriceid");
					
					
					mongoconnewprice.updateObject(new BasicDBObject("stockid", stockidstake), new BasicDBObject("$set", new BasicDBObject("stockprice", newPrice)), "Stock");
				}
				
				
			}
			
			mongoconnewprice.updateObject(new BasicDBObject("osmmodelid", osmmodelid), new BasicDBObject("$push", new BasicDBObject("osmstockpricevariation", newPrice)), "OSMDemand");
			mongoconnewprice.updateObject(new BasicDBObject("osmmodelid", osmmodelid), new BasicDBObject("$push", new BasicDBObject("osmsubscriptionid", userid)), "OSMDemand");
		}
			
		return newStock;
		
		
	}

	public String stockchangeonLike(String osmmodelid, String ownerid) {
		// TODO Auto-generated method stub
		
		String newStock = "";
		
		MongoConnection mongoconosms = new MongoConnection();
		DBCursor resultosms = mongoconosms.getDBObject("osmmodelid", osmmodelid, "OSM");
		if(resultosms.hasNext()){
			DBObject osmprojObj = resultosms.next();
			
			String companystockid = (String)osmprojObj.get("osmstockid");
			String[] companystakeholdersid = (String[])osmprojObj.get("osmstakeholdingid");
			
			String companystockprice = "";
			String[] likedamount = null;
			
			MongoConnection mongoconstock = new MongoConnection();
			DBCursor resultstock = mongoconstock.getDBObject("stockid", companystockid, "Stock");
			if(resultstock.hasNext()){
				DBObject osmprojstock = resultstock.next();
				
				companystockprice = (String)osmprojstock.get("stockprice");
			}
			
			MongoConnection mongoconbuypunch = new MongoConnection();
			DBCursor resultbuypunch = mongoconbuypunch.getDBObject("osmmodelid", osmmodelid, "OSMDemand");
			if(resultbuypunch.hasNext()){
				DBObject osmbuypunch = resultbuypunch.next();
				
				likedamount = (String[])osmbuypunch.get("osmlikeid");
				
			}
			
			
			TradeChange tradechange = new TradeChange();
			String newPrice = tradechange.changeLike(companystockprice, likedamount.length);
			
			MongoConnection mongoconnewprice = new MongoConnection();
			mongoconnewprice.updateObject(new BasicDBObject("stockid", companystockid), new BasicDBObject("$set", new BasicDBObject("stockprice", newPrice)), "Stock");
			
			
			for(int f=0;f<companystakeholdersid.length;f++){
				
				MongoConnection mongoconstakestock = new MongoConnection();
				DBCursor resultstakestock = mongoconstakestock.getDBObject("stakeholdingid", companystakeholdersid[f], "OSMStakeHold");
				if(resultstakestock.hasNext()){
					DBObject osmstakestock = resultstakestock.next();
					
					String stockidstake = (String)osmstakestock.get("stakestokpriceid");
					
					
					mongoconnewprice.updateObject(new BasicDBObject("stockid", stockidstake), new BasicDBObject("$set", new BasicDBObject("stockprice", newPrice)), "Stock");
				}
				
				
			}
			
			mongoconnewprice.updateObject(new BasicDBObject("osmmodelid", osmmodelid), new BasicDBObject("$push", new BasicDBObject("osmstockpricevariation", newPrice)), "OSMDemand");
		}
			
		return newStock;
		
	}

	public String stockchangeonShare(String osmmodelid, String ownerid) {
		// TODO Auto-generated method stub
		
		
String newStock = "";
		
		MongoConnection mongoconosms = new MongoConnection();
		DBCursor resultosms = mongoconosms.getDBObject("osmmodelid", osmmodelid, "OSM");
		if(resultosms.hasNext()){
			DBObject osmprojObj = resultosms.next();
			
			String companystockid = (String)osmprojObj.get("osmstockid");
			String[] companystakeholdersid = (String[])osmprojObj.get("osmstakeholdingid");
			
			String companystockprice = "";
			String[] sharedamount = null;
			
			MongoConnection mongoconstock = new MongoConnection();
			DBCursor resultstock = mongoconstock.getDBObject("stockid", companystockid, "Stock");
			if(resultstock.hasNext()){
				DBObject osmprojstock = resultstock.next();
				
				companystockprice = (String)osmprojstock.get("stockprice");
			}
			
			MongoConnection mongoconbuypunch = new MongoConnection();
			DBCursor resultbuypunch = mongoconbuypunch.getDBObject("osmmodelid", osmmodelid, "OSMDemand");
			if(resultbuypunch.hasNext()){
				DBObject osmbuypunch = resultbuypunch.next();
				
				sharedamount = (String[])osmbuypunch.get("osmshareid");
				
			}
			
			
			TradeChange tradechange = new TradeChange();
			String newPrice = tradechange.changeShare(companystockprice, sharedamount.length);
			
			MongoConnection mongoconnewprice = new MongoConnection();
			mongoconnewprice.updateObject(new BasicDBObject("stockid", companystockid), new BasicDBObject("$set", new BasicDBObject("stockprice", newPrice)), "Stock");
			
			
			for(int f=0;f<companystakeholdersid.length;f++){
				
				MongoConnection mongoconstakestock = new MongoConnection();
				DBCursor resultstakestock = mongoconstakestock.getDBObject("stakeholdingid", companystakeholdersid[f], "OSMStakeHold");
				if(resultstakestock.hasNext()){
					DBObject osmstakestock = resultstakestock.next();
					
					String stockidstake = (String)osmstakestock.get("stakestokpriceid");
					
					
					mongoconnewprice.updateObject(new BasicDBObject("stockid", stockidstake), new BasicDBObject("$set", new BasicDBObject("stockprice", newPrice)), "Stock");
				}
				
				
			}
			
			mongoconnewprice.updateObject(new BasicDBObject("osmmodelid", osmmodelid), new BasicDBObject("$push", new BasicDBObject("osmstockpricevariation", newPrice)), "OSMDemand");
		}
			
		return newStock;
		
	}

	/*public void stockchangeonInvesting(String token) {
		// TODO Auto-generated method stub
		
		
		
		
	}*/
	
	
}
