package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="LoggingEntry")
public class LogEntry {

	@Id
	private String logid;
	private String logtime;
	private String loglocation;
	private String logDescription;
	public String getLogid() {
		return logid;
	}
	public void setLogid(String logid) {
		this.logid = logid;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	public String getLoglocation() {
		return loglocation;
	}
	public void setLoglocation(String loglocation) {
		this.loglocation = loglocation;
	}
	public String getLogDescription() {
		return logDescription;
	}
	public void setLogDescription(String logDescription) {
		this.logDescription = logDescription;
	}
	
	public LogEntry(){
		
	}
	
	public LogEntry(String logid, String logtime, String loglocation, String logdescription){
		
		this.logid = logid;
		this.logtime = logtime;
		this.loglocation = loglocation;
		this.logDescription = logdescription;
		
	}
	
}
