package com.fliker.Utility;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.fliker.Repository.OSMModel;
import com.fliker.Repository.OSMProjectInfo;
import com.fliker.Repository.Post;
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
	
	
}
