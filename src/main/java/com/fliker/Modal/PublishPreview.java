package com.fliker.Modal;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Post;
import com.fliker.Repository.Publish;
import com.mongodb.BasicDBObject;

public class PublishPreview {

	
	public void publishtopublisher(String guidanceSubject, String userid, String guidencetype, String guidanceuserid, String guidanceid){
		
		PublishPreview publishprev = new PublishPreview();
		
		Publish publish = new Publish();
		
		publish.setPublishacknowledgement("false");
		publish.setPublishdescription(guidanceSubject+guidencetype);
		publish.setPublishid(guidanceid);
		publish.setPublishrecieveruserid(guidanceuserid);
		publish.setPublishsenderuserid(userid);
		publish.setPublishtype(guidencetype);
		
		MongoConnection mongocon = new MongoConnection();
		
		BasicDBObject basicreqobj =  publishprev.formDBObject(publish);
		
		mongocon.saveObject(basicreqobj, "Publish");
		
		
		
	}
	
	
	public BasicDBObject formDBObject(Publish publish){
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("publishid", publish.getPublishid());
		basicdbobj.put("publishsenderuserid", publish.getPublishsenderuserid());
		basicdbobj.put("publishrecieveruserid", publish.getPublishrecieveruserid());
		basicdbobj.put("publishtype", publish.getPublishtype());
		basicdbobj.put("publishdescription", publish.getPublishdescription());
		basicdbobj.put("publishacknowledgement", publish.getPublishacknowledgement());
		
		return basicdbobj;
		
	}
}
