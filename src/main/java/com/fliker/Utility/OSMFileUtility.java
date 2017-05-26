package com.fliker.Utility;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.fliker.Repository.OSMDemand;
import com.fliker.Repository.OSMModel;
import com.fliker.Repository.OSMOperator;
import com.fliker.Repository.OSMProjectInfo;
import com.fliker.Repository.OSMProjectInvestment;
import com.fliker.Repository.OSMProjectSeller;
import com.fliker.Repository.OSMStakeHolding;
import com.fliker.Repository.Post;
import com.fliker.Repository.Stock;
import com.fliker.Repository.TradeTemporarySaleSorting;
import com.mongodb.BasicDBObject;

public class OSMFileUtility {

	public String makeSHA1Hash(String input)
            throws NoSuchAlgorithmException, UnsupportedEncodingException
        {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.reset();
            byte[] buffer = input.getBytes("UTF-8");
            md.update(buffer);
            byte[] digest = md.digest();

            String hexStr = "";
            for (int i = 0; i < digest.length; i++) {
                hexStr +=  Integer.toString( ( digest[i] & 0xff ) + 0x100, 16).substring( 1 );
            }
            return hexStr;
        }
	
	
	public BasicDBObject formOSMModelDBObject(OSMModel osmmodel){
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("osmbackupid", osmmodel.getOsmbackupid());
		basicdbobj.put("osmdemandid", osmmodel.getOsmdemandid());
		basicdbobj.put("osmdependentid", osmmodel.getOsmdependentid());
		basicdbobj.put("osmhealthid", osmmodel.getOsmhealthid());
		basicdbobj.put("osmid", osmmodel.getOsmid());
		basicdbobj.put("osmpartnerid", osmmodel.getOsmpartnerid());
		basicdbobj.put("osmstakeholdingid", osmmodel.getOsmstakeholdingid());
		basicdbobj.put("osmstockid", osmmodel.getOsmstockid());
		basicdbobj.put("osmsupplyid", osmmodel.getOsmsupplyid());
		
		return basicdbobj;
		
	}


	public BasicDBObject formOSMProjectDBObject(OSMProjectInfo projectinfo) {
		// TODO Auto-generated method stub
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("osmmodelid", projectinfo.getOsmmodelid());
		basicdbobj.put("projectbuyers", projectinfo.getProjectbuyers());
		basicdbobj.put("projectdemandchart", projectinfo.getProjectdemandchart());
		basicdbobj.put("projectdescription", projectinfo.getProjectdescription());
		basicdbobj.put("projectdocs", projectinfo.getProjectdocs());
		basicdbobj.put("projectinfoid", projectinfo.getProjectinfoid());
		basicdbobj.put("projectinvestors", projectinfo.getProjectinvestors());
		basicdbobj.put("projectmarkettingdoc", projectinfo.getProjectmarkettingdoc());
		basicdbobj.put("projectname", projectinfo.getProjectname());
		basicdbobj.put("projectresources", projectinfo.getProjectresources());
		basicdbobj.put("projectstockprice", projectinfo.getProjectstockprice());
		
		
		return basicdbobj;
	}


	public BasicDBObject formOSMProjectInvestDBObject(OSMProjectInvestment osmprojinvest) {
		// TODO Auto-generated method stub
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("osmmodelid", osmprojinvest.getOsmmodelid());
		basicdbobj.put("osminvestmentdoc", osmprojinvest.getOsminvestmentdoc());
		basicdbobj.put("osminvestorslink", osmprojinvest.getOsminvestorslink());
		basicdbobj.put("osmstakedivision", osmprojinvest.getOsmstakedivision());
		basicdbobj.put("osmstakeholdingid", osmprojinvest.getOsmstakeholdingid());
		
		
		return basicdbobj;
	}


	public BasicDBObject formOSMProjectSellerDBObject(OSMProjectSeller projseller) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("osmmodelid", projseller.getOsmmodelid());
		basicdbobj.put("projectsellerid",projseller.getProjectsellerid());
		basicdbobj.put("sellerdescription", projseller.getSellerdescription());
		basicdbobj.put("sellingmarketdoc", projseller.getSellingmarketdoc());
		
		
		return basicdbobj;
	}


	public BasicDBObject formOSMOperatorDBObject(OSMOperator osmoperator) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("activeCompany", osmoperator.getActiveCompany());
		basicdbobj.put("newsevents", osmoperator.getNewsevents());
		basicdbobj.put("oldbuyings", osmoperator.getOldbuyings());
		basicdbobj.put("olddevelopments", osmoperator.getOlddevelopments());
		basicdbobj.put("oldinvestments", osmoperator.getOldinvestments());
		basicdbobj.put("operatorComapnyid", osmoperator.getOperatorComapnyid());
		basicdbobj.put("operatorid", osmoperator.getOperatorid());
		basicdbobj.put("operatorStory", osmoperator.getOperatorStory());
		basicdbobj.put("osmmodelid", osmoperator.getOsmmodelid());
		basicdbobj.put("osmownerids", osmoperator.getOsmownerids());
		basicdbobj.put("stockholdings", osmoperator.getStockholdings());
		basicdbobj.put("userid", osmoperator.getUserid());
		
		return basicdbobj;
	}


	public BasicDBObject formOSMStakeHoldingDBObject(OSMStakeHolding stakeholding) {
		// TODO Auto-generated method stub
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("stakeamount", stakeholding.getStakeamount());
		basicdbobj.put("stakeholderlocation",stakeholding.getStakeholderlocation());
		basicdbobj.put("stakeholdingid", stakeholding.getStakeholdingid());
		basicdbobj.put("stakeownerid", stakeholding.getStakeownerid());
		basicdbobj.put("stakepercentage", stakeholding.getStakepercentage());
		basicdbobj.put("stakestokpriceid", stakeholding.getStakestokpriceid());
		basicdbobj.put("starstokprice", stakeholding.getStarstokprice());
		
		
		return basicdbobj;
	}


	public BasicDBObject formOSMStockDBObject(Stock stock) {
		// TODO Auto-generated method stub
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("closingvalue", stock.getClosingvalue());
		basicdbobj.put("companyid",stock.getCompanyid());
		basicdbobj.put("openingvalue", stock.getOpeningvalue());
		basicdbobj.put("stockamount", stock.getStockamount());
		basicdbobj.put("stockid", stock.getStockid());
		basicdbobj.put("stockprice", stock.getStockprice());
		
		return basicdbobj;
	}


	public BasicDBObject formOSMDemandDBObject(OSMDemand osmdemand) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("osmdemandcomplexity", osmdemand.getOsmdemandcomplexity());
		basicdbobj.put("osmdemandid",osmdemand.getOsmdemandid());
		basicdbobj.put("osmdemandvariation", osmdemand.getOsmdemandvariation());
		basicdbobj.put("osmlikeid", osmdemand.getOsmlikeid());
		basicdbobj.put("osmmodelid", osmdemand.getOsmmodelid());
		basicdbobj.put("osmshareid", osmdemand.getOsmshareid());
		basicdbobj.put("osmstockpricevariation", osmdemand.getOsmstockpricevariation());
		basicdbobj.put("osmsubscriptionid", osmdemand.getOsmsubscriptionid());
		
		return basicdbobj;
	}


	public BasicDBObject formTradeTempSaleDBObject(TradeTemporarySaleSorting tradetempsort) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("tradetempsaleid", tradetempsort.getTradetempsaleid());
		basicdbobj.put("tradeenddatetime",tradetempsort.getTradeenddatetime());
		basicdbobj.put("tradecompositeamount", tradetempsort.getTradecompositeamount());
		basicdbobj.put("tradepresaleid", tradetempsort.getTradepresaleid());
		basicdbobj.put("saleamount", tradetempsort.getSaleamount());
		return basicdbobj;
	}
	
	
}
