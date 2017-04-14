package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Notification")
public class Notification {

	@Id
	private String notificationid;
	private String notificationtime;
	private String notificationacknowledged;
	public String getNotificationid() {
		return notificationid;
	}
	public void setNotificationid(String notificationid) {
		this.notificationid = notificationid;
	}
	public String getNotificationtime() {
		return notificationtime;
	}
	public void setNotificationtime(String notificationtime) {
		this.notificationtime = notificationtime;
	}
	public String getNotificationacknowledged() {
		return notificationacknowledged;
	}
	public void setNotificationacknowledged(String notificationacknowledged) {
		this.notificationacknowledged = notificationacknowledged;
	}
	
	
	
}
