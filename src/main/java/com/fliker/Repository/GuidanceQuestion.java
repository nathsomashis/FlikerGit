package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceQuestion")
public class GuidanceQuestion {

	@Id
	private String guidanceid;
	private String[] questionids;
	public String getGuidanceid() {
		return guidanceid;
	}
	public void setGuidanceid(String guidanceid) {
		this.guidanceid = guidanceid;
	}
	public String[] getQuestionids() {
		return questionids;
	}
	public void setQuestionids(String[] questionids) {
		this.questionids = questionids;
	}
	
	
}
