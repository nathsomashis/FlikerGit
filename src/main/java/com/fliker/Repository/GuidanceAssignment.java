package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceAssignment")
public class GuidanceAssignment {

	@Id
	private String guidanceid;
	private String[] assignmentids;
	
	
	
	public String getGuidanceid() {
		return guidanceid;
	}
	public void setGuidanceid(String guidanceid) {
		this.guidanceid = guidanceid;
	}
	public String[] getAssignmentids() {
		return assignmentids;
	}
	public void setAssignmentids(String[] assignmentids) {
		this.assignmentids = assignmentids;
	}
	
	
}
