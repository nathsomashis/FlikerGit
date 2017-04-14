package com.fliker.Modal;

import java.util.ArrayList;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.NotificationList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class NotificationPreview {

	
	public ArrayList getAllNotification( String userid){
		
		ArrayList notificationlist = new ArrayList();
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("userid", userid, "NotificationList");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
		   
			NotificationList notificationlis = new NotificationList();
			notificationlis.setNoteuserid(userid);
			notificationlis.setNotificationids((String[])theObj.get("notificationids"));
			notificationlist.add(notificationlis);
		}
		
		
		return notificationlist;
		
		
	}
	
	
	public ArrayList getNotifications(String lastid, ArrayList notificationlist){
		
		ArrayList notifications = new ArrayList();
		
		for(int m=0;m<notificationlist.size();m++){
			
			NotificationList notificlist = (NotificationList) notificationlist.get(m);
			String[] notificationids = notificlist.getNotificationids();
			
			if(lastid.isEmpty()){
				
				for(int s=0;s<13;s++){
					
					notifications.add(notificationids[s]);
					
				}
				
			}else{
				for(int s=0;s<notificationids.length;s++){
					if(notificationids[s] == lastid){
						s++;
						notifications.add(notificationids[s]);
						notifications.add(notificationids[s+1]);
						notifications.add(notificationids[s+2]);
						notifications.add(notificationids[s+3]);
					}
				}
			}
			
		}
		
		return notifications;
		
		
	}
	
}
