package com.fliker.Modal;

import java.util.ArrayList;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.OSMProjectInfo;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class OSMPreview {

	
	public ArrayList getProjectInfoList(){
		
		
		ArrayList projectlist = new ArrayList();
		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("OSMOwner");
		DBCursor cursor;

		cursor = collection.find().sort(new BasicDBObject("osmmodelid", -1));
		while (cursor.hasNext()) {
			DBObject currentItem = cursor.next();
			String osmmodelid = (String) currentItem.get("osmmodelid");
			
			MongoConnection mongoconinner = new MongoConnection();
			DBCursor resultcursor = mongoconinner.getDBObject("osmmodelid", osmmodelid, "OSMProjectInfo");
			if(resultcursor.hasNext()){
				
				DBObject theObjosm = resultcursor.next();
				
				OSMProjectInfo osmprojinf = new OSMProjectInfo();
				osmprojinf.setOsmmodelid((String)theObjosm.get("osmmodelid"));
				osmprojinf.setProjectbuyers((String)theObjosm.get("projectbuyers"));
				osmprojinf.setProjectdemandchart((String)theObjosm.get("projectdemandchart"));
				osmprojinf.setOsmmodelid((String)theObjosm.get("osmmodelid"));
				osmprojinf.setOsmmodelid((String)theObjosm.get("osmmodelid"));
				osmprojinf.setOsmmodelid((String)theObjosm.get("osmmodelid"));
				osmprojinf.setOsmmodelid((String)theObjosm.get("osmmodelid"));
				osmprojinf.setOsmmodelid((String)theObjosm.get("osmmodelid"));
				osmprojinf.setOsmmodelid((String)theObjosm.get("osmmodelid"));
				
			}
				
		}
		
		
		return 	projectlist;
	}
		
	
	
	
}
