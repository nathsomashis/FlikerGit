package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="NotificationList")
public class NotificationList {
	
	@Id
	private String noteuserid;
	private String[] notificationids;
	public String getNoteuserid() {
		return noteuserid;
	}
	public void setNoteuserid(String noteuserid) {
		this.noteuserid = noteuserid;
	}
	public String[] getNotificationids() {
		return notificationids;
	}
	public void setNotificationids(String[] notificationids) {
		this.notificationids = notificationids;
	}
	
	

}
