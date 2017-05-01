package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="TempFileHistory")
public class TempFileHistory {

	@Id
	private String tempfilehistoryid;
	private String requestuserid;
	private String[] contexts;
	public String getTempfilehistoryid() {
		return tempfilehistoryid;
	}
	public void setTempfilehistoryid(String tempfilehistoryid) {
		this.tempfilehistoryid = tempfilehistoryid;
	}
	public String getRequestuserid() {
		return requestuserid;
	}
	public void setRequestuserid(String requestuserid) {
		this.requestuserid = requestuserid;
	}
	public String[] getContexts() {
		return contexts;
	}
	public void setContexts(String[] contexts) {
		this.contexts = contexts;
	}
	
	
	
	
	
}
