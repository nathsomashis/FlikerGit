package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceQuizLink")
public class GuidanceQuizLink {

	@Id
	private String quizlinkid;
	private String quizid;
	private String[] guidanceremarkid;
	private String[] shareduserids;
	private String[] guidancefeedbackid;
	public String getQuizlinkid() {
		return quizlinkid;
	}
	public void setQuizlinkid(String quizlinkid) {
		this.quizlinkid = quizlinkid;
	}
	public String getQuizid() {
		return quizid;
	}
	public void setQuizid(String quizid) {
		this.quizid = quizid;
	}
	public String[] getGuidanceremarkid() {
		return guidanceremarkid;
	}
	public void setGuidanceremarkid(String[] guidanceremarkid) {
		this.guidanceremarkid = guidanceremarkid;
	}
	public String[] getShareduserids() {
		return shareduserids;
	}
	public void setShareduserids(String[] shareduserids) {
		this.shareduserids = shareduserids;
	}
	public String[] getGuidancefeedbackid() {
		return guidancefeedbackid;
	}
	public void setGuidancefeedbackid(String[] guidancefeedbackid) {
		this.guidancefeedbackid = guidancefeedbackid;
	}
	
	
}
