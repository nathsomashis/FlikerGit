package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceAssignmentLink")
public class GuidanceAssignmentLink {

	private String assignmentlinkid;
	private String assignmentid;
	private String[] guidanceremarkid;
	private String[] shareduserids;
	private String[] guidancefeedbackid;
	public String getAssignmentlinkid() {
		return assignmentlinkid;
	}
	public void setAssignmentlinkid(String assignmentlinkid) {
		this.assignmentlinkid = assignmentlinkid;
	}
	public String getAssignmentid() {
		return assignmentid;
	}
	public void setAssignmentid(String assignmentid) {
		this.assignmentid = assignmentid;
	}
	
	public String[] getShareduserids() {
		return shareduserids;
	}
	public void setShareduserids(String[] shareduserids) {
		this.shareduserids = shareduserids;
	}
	public String[] getGuidanceremarkid() {
		return guidanceremarkid;
	}
	public void setGuidanceremarkid(String[] guidanceremarkid) {
		this.guidanceremarkid = guidanceremarkid;
	}
	public String[] getGuidancefeedbackid() {
		return guidancefeedbackid;
	}
	public void setGuidancefeedbackid(String[] guidancefeedbackid) {
		this.guidancefeedbackid = guidancefeedbackid;
	}
	
	
	
	
	
}
