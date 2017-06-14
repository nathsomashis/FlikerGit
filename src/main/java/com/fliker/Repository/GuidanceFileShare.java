package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceDashFileShare")
public class GuidanceFileShare {

	@Id
	private String guidancefileid;
	private String guidanceid;
	private String[] consumerids;
	
	
	public String getGuidanceid() {
		return guidanceid;
	}
	public void setGuidanceid(String guidanceid) {
		this.guidanceid = guidanceid;
	}
	public String getGuidancefileid() {
		return guidancefileid;
	}
	public void setGuidancefileid(String guidancefileid) {
		this.guidancefileid = guidancefileid;
	}
	public String[] getConsumerids() {
		return consumerids;
	}
	public void setConsumerids(String[] consumerids) {
		this.consumerids = consumerids;
	}
	
	
}
