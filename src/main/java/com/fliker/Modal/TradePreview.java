package com.fliker.Modal;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.OSMModel;
import com.fliker.Repository.TradeBilling;
import com.fliker.Repository.TradePreBuyData;
import com.fliker.Repository.TradePreSaleData;
import com.fliker.Repository.TradeTemporarySaleSorting;
import com.fliker.Utility.DateFunctionality;
import com.fliker.Utility.OSMFileUtility;
import com.fliker.Utility.TradeChange;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
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

	public HashMap<String,LinkedList<String>> checkAvalability(String osmmodelid, String ownerid) {
		// TODO Auto-generated method stub
		
		LinkedList temptradeset = new LinkedList();
		String isavailable = "false";
		double leftamount = 0;
		StringBuffer tradepresaleid = new StringBuffer();
		DateFunctionality datefunc = new DateFunctionality();	
		HashMap<String,LinkedList<String>> trademap = new HashMap<String,LinkedList<String>>();
		String currentdate = datefunc.getCurrentdate();
		OSMFileUtility osmfileutility = new OSMFileUtility();
				
		
		MongoConnection mongoconstakestock = new MongoConnection();
		DBCursor resultstakestock = mongoconstakestock.getDBObject("osmmodelid", osmmodelid, "TradePreSale");
		while(resultstakestock.hasNext()){
			DBObject osmstakestock = resultstakestock.next();
			String lockedownerid = (String)osmstakestock.get("currenlock");
			
			if(lockedownerid.isEmpty()){
			
			TradePreSaleData tradesaledata = new TradePreSaleData();
			
			String salepreid = (String)osmstakestock.get("tradepresaleid");
			String saleamount = (String)osmstakestock.get("saleamount");
			String saleendtime = (String)osmstakestock.get("saleenddate");
			String leftamt = (String)osmstakestock.get("leftcompundamount");
			
			MongoConnection mongoconnewprice = new MongoConnection();
			mongoconnewprice.updateObject(new BasicDBObject("tradepresaleid", salepreid), new BasicDBObject("$set", new BasicDBObject("currenlock", ownerid)), "TradePreSale");
			
			leftamount = leftamount + Double.parseDouble(leftamt);
			
			String currentdatediff = datefunc.getDateDiffference(currentdate, saleendtime);
			
			if(currentdatediff.contains("days") || currentdatediff.contains("hours") || currentdatediff.contains("minutes") || currentdatediff.contains("seconds")){
				
				TradeTemporarySaleSorting tradetempsort = new TradeTemporarySaleSorting();
				tradetempsort.setTradeenddatetime(saleendtime);
				tradetempsort.setTradecompositeamount(leftamt);
				tradetempsort.setTradetempsaleid(currentdate);
				tradetempsort.setTradepresaleid(salepreid);
				tradetempsort.setSaleamount(saleamount);
				
				
				MongoConnection mongocondemand = new MongoConnection();

				BasicDBObject basicreqobjdemand = osmfileutility.formTradeTempSaleDBObject(tradetempsort);
				mongocondemand.saveObject(basicreqobjdemand, "TradeTemporarySale");
				
				temptradeset.add(tradetempsort);
				
			}
			}
		}
		trademap.put(currentdate, temptradeset);
		
		return trademap;
	}

	public String checkElements(HashMap<String, LinkedList<String>> istradeavail) {
		// TODO Auto-generated method stub
		String elementisavail = "";
		
		HashMap<String, LinkedList<String>> elementslist = new HashMap<String, LinkedList<String>>();
		Set eleset = elementslist.entrySet();
		Iterator eleit = eleset.iterator();
		if(eleit.hasNext()){
			Map.Entry meelem = (Map.Entry)eleit.next();
			if(((LinkedList)meelem.getValue()).isEmpty()){
				elementisavail = (String)meelem.getKey();
			}
		}
		return elementisavail;
	}

	public int getAllTradeElements(String elements, String stockprice) {
		// TODO Auto-generated method stub
		ArrayList postlist = new ArrayList();
		double totalstockamount = 0.00;
		double stockdbl = Integer.parseInt(stockprice);
		int totalstock = 0;
		
		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("TradeTemporarySale");
		DBCursor cursor = collection.find(new BasicDBObject("tradetempsaleid", elements)).limit(50).sort(new BasicDBObject("tradeenddatetime",-1));
		
		while(cursor.hasNext()){
			postlist.add(cursor.next());
			
			DBObject stockobj = cursor.next();
			totalstockamount = totalstockamount+ (double)stockobj.get("tradecompositeamount");
		}
		
		totalstock = (int) (totalstockamount/stockdbl);
		
		return totalstock;
	}

	public ArrayList proceedToBuyout(String totalstock, String stockamount, String ownerid, HashMap<String, LinkedList<String>> tradeavaillist) {
		// TODO Auto-generated method stub
		
		ArrayList temppresaleid = new ArrayList();
		int originalstockamount = Integer.parseInt(stockamount);
		int remainingstockamount = 0;
		
		if(totalstock.equalsIgnoreCase(stockamount)){
			Set tradeset = tradeavaillist.entrySet();
			Iterator tradeit = tradeset.iterator();
			if(tradeit.hasNext()){
				Map.Entry metrade = (Map.Entry)tradeit.next();
				
				LinkedList alltradelist = (LinkedList)metrade.getValue();
				for(int i=0;i<alltradelist.size();i++){
					
					TradeTemporarySaleSorting tradertempsale = (TradeTemporarySaleSorting) alltradelist.get(i);
					temppresaleid.add(tradertempsale.getTradepresaleid());
					
				}
			}
		}else{
			Set tradeset = tradeavaillist.entrySet();
			Iterator tradeit = tradeset.iterator();
			if(tradeit.hasNext()){
				Map.Entry metrade = (Map.Entry)tradeit.next();
				
				LinkedList alltradelist = (LinkedList)metrade.getValue();
				for(int i=0;i<alltradelist.size();i++){
					
					TradeTemporarySaleSorting tradertempsale = (TradeTemporarySaleSorting) alltradelist.get(i);
					int tradeavailamount = Integer.parseInt(tradertempsale.getSaleamount());
					if(originalstockamount > 0){
						if(originalstockamount > tradeavailamount){
							temppresaleid.add(tradertempsale.getTradepresaleid()+"::"+"full");
							originalstockamount = originalstockamount - tradeavailamount;
						}else if(originalstockamount < tradeavailamount){
							temppresaleid.add(tradertempsale.getTradepresaleid()+"::"+originalstockamount);
						}
						
					}
				}
			}
		}
		
		
		return temppresaleid;
	}

	public void buyout(ArrayList tradesalelist, String ownerid, String stockpricerate) {
		// TODO Auto-generated method stub
		
		for(int f=0;f<tradesalelist.size();f++){
			String elements = (String) tradesalelist.get(f);
			String[] elemnetid = elements.split("::");
			String tempsaleid = elemnetid[0];
			String percentagesale = elemnetid[1];
			
			MongoConnection mongoconstakestock = new MongoConnection();
			DBCursor resultstakestock = mongoconstakestock.getDBObject("tradepresaleid", tempsaleid, "TradePreSale");
			while(resultstakestock.hasNext()){
				DBObject osmstakestock = resultstakestock.next();
				
				if(percentagesale.equalsIgnoreCase("full")){
					
					String wholecompoundamount = (String)osmstakestock.get("leftcompundamount");
					MongoConnection mongoconnewprice = new MongoConnection();
					mongoconnewprice.updateObject(new BasicDBObject("tradepresaleid", tempsaleid), new BasicDBObject("$set", new BasicDBObject("lockedcompoundamount", wholecompoundamount)), "TradePreSale");
					mongoconnewprice.updateObject(new BasicDBObject("tradepresaleid", tempsaleid), new BasicDBObject("$set", new BasicDBObject("leftcompundamount", 0)), "TradePreSale");
					mongoconnewprice.updateObject(new BasicDBObject("tradepresaleid", tempsaleid), new BasicDBObject("$set", new BasicDBObject("saleamount", 0)), "TradePreSale");
					
					TradeBilling tradebill = new TradeBilling();
					tradebill.setBilledto((String)osmstakestock.get("userid"));
					tradebill.setBilledfrom(ownerid);
					
					String stockprice = (String)osmstakestock.get("salestockprice");
					double stockstartprice = Double.parseDouble(stockprice);
					double currentstock = Double.parseDouble(stockpricerate);
					double payableamount = 0.00;
					double compoundamount = Double.parseDouble(wholecompoundamount);
					
					payableamount = compoundamount/(currentstock);
					 
					tradebill.setBillingamount(Double.toString(payableamount));
					//Billing details
					
				}else{
					String wholecompoundamount = (String)osmstakestock.get("leftcompundamount");
					String salestockprice = (String)osmstakestock.get("salestockprice");
					String saleamount = (String)osmstakestock.get("saleamount");
					int amounttaken = Integer.parseInt(saleamount) - Integer.parseInt(percentagesale);
					double leftamount = Double.parseDouble(salestockprice)* amounttaken;
					double lockamount = Double.parseDouble(salestockprice)*Integer.parseInt(percentagesale);
					
					MongoConnection mongoconnewprice = new MongoConnection();
					mongoconnewprice.updateObject(new BasicDBObject("tradepresaleid", tempsaleid), new BasicDBObject("$set", new BasicDBObject("leftcompundamount", leftamount)), "TradePreSale");
					mongoconnewprice.updateObject(new BasicDBObject("tradepresaleid", tempsaleid), new BasicDBObject("$set", new BasicDBObject("lockedcompoundamount", lockamount)), "TradePreSale");
					mongoconnewprice.updateObject(new BasicDBObject("tradepresaleid", tempsaleid), new BasicDBObject("$set", new BasicDBObject("saleamount", amounttaken)), "TradePreSale");
					
					
					TradeBilling tradebill = new TradeBilling();
					tradebill.setBilledto((String)osmstakestock.get("userid"));
					tradebill.setBilledfrom(ownerid);
					
					String stockprice = (String)osmstakestock.get("salestockprice");
					double stockstartprice = Double.parseDouble(stockprice);
					double currentstock = Double.parseDouble(stockpricerate);
					double payableamount = 0.00;
					double compoundamount = lockamount;
					
					payableamount = compoundamount/(currentstock);
					 
					tradebill.setBillingamount(Double.toString(payableamount));
					
				}
				
			}
			
			
			
		}
		
		
	}

	public void releaseLockTrade(HashMap<String, LinkedList<String>> tradeavaillist, String ownerid, String osmmodelid) {
		// TODO Auto-generated method stub
		
		Set tradeset = tradeavaillist.entrySet();
		Iterator tradeit = tradeset.iterator();
		while(tradeit.hasNext()){
			
			Map.Entry meiter = (Map.Entry)tradeit.next();
			LinkedList tradetempid = (LinkedList)meiter.getValue();
			
			for(int s=0;s<tradetempid.size();s++){
				
				String tradetempsaleidcombine = (String)tradetempid.get(s);
				String tradetempsaleid = tradetempsaleidcombine.split("::")[0];
				
				MongoConnection mongoconstakestock = new MongoConnection();
				DBCursor resultstakestock = mongoconstakestock.getDBObject("tradepresaleid", tradetempsaleid, "TradePreSale");
				while(resultstakestock.hasNext()){
					DBObject osmstakestock = resultstakestock.next();
					
					String osmmodelidselect = (String)osmstakestock.get("osmmodelid");
					if(osmmodelid.equalsIgnoreCase(osmmodelidselect)){
						String lockerowner = (String)osmstakestock.get("currenlock");
						if(lockerowner.equalsIgnoreCase(ownerid)){
							
							MongoConnection mongoconnewprice = new MongoConnection();
							mongoconnewprice.updateObject(new BasicDBObject("tradepresaleid", tradetempsaleid), new BasicDBObject("$set", new BasicDBObject("currenlock", "")), "TradePreSale");
						}
						
					}
					
				}
				
			}
			
		}
		
		
	}

	public void releaseStockToSell(String stockamount, String stockprice, String stockid, String ownerid,
			String osmmodelid) {
		// TODO Auto-generated method stub
		
		OSMFileUtility osmfileutility = new OSMFileUtility();
		TradePreSaleData tradepresale = new TradePreSaleData();
		tradepresale.setUserid(ownerid);
		
		String uniqueid = "";
		try {
			uniqueid = osmfileutility.makeSHA1Hash(stockamount+stockprice+osmmodelid+ownerid);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tradepresale.setTradepresaleid(uniqueid);
		double startcompamt = Double.parseDouble(stockamount)* Double.parseDouble(stockprice);
		String startcompundamount = Double.toString(startcompamt);
		tradepresale.setStartcompundamount(startcompundamount);
		tradepresale.setSalestockprice(stockprice);
		
		DateFunctionality datefunc = new DateFunctionality();
		datefunc.getCurrentdate();
		String[] lockidarr = new String[0];
		String[] billingarr = new String[0];
		
		tradepresale.setSalestartdate(datefunc.getCurrentdate());
		tradepresale.setSaleenddate(datefunc.getFuturedate(2));
		tradepresale.setSaleamount(stockamount);
		tradepresale.setOsmstakeholdingid(stockid);
		tradepresale.setOsmmodelid(osmmodelid);
		tradepresale.setLockedcompoundamount("0");
		tradepresale.setLeftcompundamount("0");
		tradepresale.setCurrenlock("");
		tradepresale.setLockedid(lockidarr);
		tradepresale.setBillingsid(billingarr);
		
		MongoConnection mongocon = new MongoConnection();

		BasicDBObject basicreqobj = osmfileutility.formTradePreSaleDBObject(tradepresale);
		mongocon.saveObject(basicreqobj, "TradePreSale");
		
		
	}

	public String[] retrieveStocks(String ownerid) {
		// TODO Auto-generated method stub
		
		String[] osmodelid = null;
		MongoConnection mongoconstakestock = new MongoConnection();
		DBCursor resultstakestock = mongoconstakestock.getDBObject("userid", ownerid, "OSMOperator");
		while(resultstakestock.hasNext()){
			DBObject osmstakestock = resultstakestock.next();
			
			osmodelid = (String[])osmstakestock.get("osmmodelid");
			
		}
		
		return osmodelid;
	}
	
	public void buyoutTrade(String osmmodelid,String osmstakeholdingid, String userid, String currentstockprice, String stockamount, String billingsid){
		
		OSMFileUtility osmfileutility = new OSMFileUtility();
		String[] lockstockamt = new String[0];
		String[] billings = new String[0];
		DateFunctionality datefunc = new DateFunctionality();
		TradePreBuyData tradeprebuy = new TradePreBuyData();
		tradeprebuy.setUserid(userid);
		
		String uniqueid = "";
		try {
			uniqueid = osmfileutility.makeSHA1Hash(stockamount+osmstakeholdingid+osmmodelid+userid);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tradeprebuy.setTradeprebuyid(uniqueid);
		tradeprebuy.setStockamount(stockamount);
		tradeprebuy.setOsmstakeholdingid(osmstakeholdingid);
		tradeprebuy.setOsmmodelid(osmmodelid);
		tradeprebuy.setCurrentstockprice(currentstockprice);
		tradeprebuy.setBuystarttime(datefunc.getCurrentdate());
		tradeprebuy.setBuyendtime("");
		tradeprebuy.setBillingsid(billings);
		tradeprebuy.setLockedtradepresaleamount(lockstockamt);
		tradeprebuy.setBillingextendtime(datefunc.getFuturedate(2));
		
		
		MongoConnection mongocon = new MongoConnection();

		BasicDBObject basicreqobj = osmfileutility.formTradePreBuyDBObject(tradeprebuy);
		mongocon.saveObject(basicreqobj, "TradePreBuy");
	}
	

	/*public void stockchangeonInvesting(String token) {
		// TODO Auto-generated method stub
		
		
		
		
	}*/
	
	
}
