package com.fliker.Utility;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.fliker.Repository.Bill;
import com.fliker.Repository.OSMDemand;
import com.fliker.Repository.OSMModel;
import com.fliker.Repository.OSMOperator;
import com.fliker.Repository.OSMProjectDevelopment;
import com.fliker.Repository.OSMProjectInfo;
import com.fliker.Repository.OSMProjectInvestment;
import com.fliker.Repository.OSMProjectSeller;
import com.fliker.Repository.OSMStakeHolding;
import com.fliker.Repository.Post;
import com.fliker.Repository.Stock;
import com.fliker.Repository.TradePreBuyData;
import com.fliker.Repository.TradePreSaleData;
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
		basicdbobj.put("sellingcontractid", projseller.getSellingcontractid());
		basicdbobj.put("sellinglicenseid", projseller.getSellinglicenseid());
		basicdbobj.put("sellingplanid", projseller.getSellingplanid());
		
		
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


	public BasicDBObject formTradePreSaleDBObject(TradePreSaleData tradepresale) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("currenlock", tradepresale.getCurrenlock());
		basicdbobj.put("leftcompundamount",tradepresale.getLeftcompundamount());
		basicdbobj.put("lockedcompoundamount", tradepresale.getLockedcompoundamount());
		basicdbobj.put("lockedid", tradepresale.getLockedid());
		basicdbobj.put("osmmodelid", tradepresale.getOsmmodelid());
		basicdbobj.put("osmstakeholdingid", tradepresale.getOsmstakeholdingid());
		basicdbobj.put("saleamount", tradepresale.getSaleamount());
		basicdbobj.put("saleenddate", tradepresale.getSaleenddate());
		basicdbobj.put("salestartdate", tradepresale.getSalestartdate());
		basicdbobj.put("salestockprice", tradepresale.getSalestockprice());
		basicdbobj.put("startcompundamount", tradepresale.getStartcompundamount());
		basicdbobj.put("tradepresaleid", tradepresale.getTradepresaleid());
		basicdbobj.put("userid", tradepresale.getUserid());
		basicdbobj.put("billingsid", tradepresale.getBillingsid());
		return basicdbobj;
	}


	public BasicDBObject formTradePreBuyDBObject(TradePreBuyData tradeprebuy) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("billingextendtime", tradeprebuy.getBillingextendtime());
		basicdbobj.put("billingsid",tradeprebuy.getBillingsid());
		basicdbobj.put("buyendtime", tradeprebuy.getBuyendtime());
		basicdbobj.put("buystarttime", tradeprebuy.getBuystarttime());
		basicdbobj.put("currentstockprice", tradeprebuy.getCurrentstockprice());
		basicdbobj.put("lockedtradepresaleamount", tradeprebuy.getLockedtradepresaleamount());
		basicdbobj.put("osmmodelid", tradeprebuy.getOsmmodelid());
		basicdbobj.put("stockamount", tradeprebuy.getStockamount());
		basicdbobj.put("tradeprebuyid", tradeprebuy.getTradeprebuyid());
		basicdbobj.put("userid", tradeprebuy.getUserid());
		basicdbobj.put("osmstakeholdingid", tradeprebuy.getOsmstakeholdingid());
		
		return basicdbobj;
	}


	public BasicDBObject formOSMOperatorBillDBObject(Bill bill) {
		// TODO Auto-generated method stub
		
		BasicDBObject basicdbobj = new BasicDBObject();
		
		basicdbobj.put("billid", bill.getBillid());
		basicdbobj.put("contractid",bill.getContractid());
		basicdbobj.put("invoiceid", bill.getInvoiceid());
		basicdbobj.put("item", bill.getItem());
		basicdbobj.put("licenseid", bill.getLicenseid());
		basicdbobj.put("payfromid", bill.getPayfromid());
		basicdbobj.put("paymentmethods", bill.getPaymentmethods());
		basicdbobj.put("paytoid", bill.getPaytoid());
		basicdbobj.put("planid", bill.getPlanid());
		basicdbobj.put("totalamount", bill.getTotalamount());
		
		return basicdbobj;
	}


	public BasicDBObject formOSMProjectResourceDBObject(OSMProjectDevelopment osmprojdev) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("osmmodelid", osmprojdev.getOsmmodelid());
		basicdbobj.put("osmprojectdevelopmentid",osmprojdev.getOsmprojectdevelopmentid());
		basicdbobj.put("osmresourceid",osmprojdev.getOsmresourceid());
		basicdbobj.put("projectflodocs", osmprojdev.getProjectflodocs());
		basicdbobj.put("projectidlink", osmprojdev.getProjectidlink());
		basicdbobj.put("projectlinkaccess", osmprojdev.getProjectlinkaccess());
		basicdbobj.put("projectslidesid", osmprojdev.getProjectslidesid());
		
		return basicdbobj;
	}
	
	
}
