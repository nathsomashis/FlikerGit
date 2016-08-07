package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Connections")
public class Connections {

	private String connectionid;
	private String userid;
	public String getConnectionid() {
		return connectionid;
	}
	public void setConnectionid(String connectionid) {
		this.connectionid = connectionid;
	}
	
	
	
	public Connections(){
		
	}
	
	public Connections(String connectionid, String userid){
		this.connectionid = connectionid;
		this.userid = userid;
		
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}
