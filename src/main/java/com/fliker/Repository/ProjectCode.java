package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ProjectCode")
public class ProjectCode {

	@Id
	private String projectcodeid;
	private String[] projectdistributionids;
	private String[] projectnotepad;
	private String timelineid;
	private String input_output_log;
	private String shareid;
	
	
	public String[] getProjectnotepad() {
		return projectnotepad;
	}
	public void setProjectnotepad(String[] projectnotepad) {
		this.projectnotepad = projectnotepad;
	}
	public String getTimelineid() {
		return timelineid;
	}
	public void setTimelineid(String timelineid) {
		this.timelineid = timelineid;
	}
	public String getInput_output_log() {
		return input_output_log;
	}
	public void setInput_output_log(String input_output_log) {
		this.input_output_log = input_output_log;
	}
	public String getProjectcodeid() {
		return projectcodeid;
	}
	public void setProjectcodeid(String projectcodeid) {
		this.projectcodeid = projectcodeid;
	}
	public String[] getProjectdistributionids() {
		return projectdistributionids;
	}
	public void setProjectdistributionids(String[] projectdistributionids) {
		this.projectdistributionids = projectdistributionids;
	}
	public String getShareid() {
		return shareid;
	}
	public void setShareid(String shareid) {
		this.shareid = shareid;
	}
	
	
}
