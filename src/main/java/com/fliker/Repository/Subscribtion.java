package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Subscribtion")
public class Subscribtion {

	@Id
	private String subscribtionid;
	private String subscribtiontype;
	private String subscribelocation;
	
	
	public String getSubscribelocation() {
		return subscribelocation;
	}
	public void setSubscribelocation(String subscribelocation) {
		this.subscribelocation = subscribelocation;
	}
	public String getSubscribtionid() {
		return subscribtionid;
	}
	public void setSubscribtionid(String subscribtionid) {
		this.subscribtionid = subscribtionid;
	}
	public String getSubscribtiontype() {
		return subscribtiontype;
	}
	public void setSubscribtiontype(String subscribtiontype) {
		this.subscribtiontype = subscribtiontype;
	}
	
	
}
