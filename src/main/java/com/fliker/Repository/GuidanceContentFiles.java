package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceContentFiles")
public class GuidanceContentFiles {

	@Id
	private String fileids;
	private String fileentrydatetime;
	private String filecompletedate;
	private String fileprogresspercentage;
	public String getFileids() {
		return fileids;
	}
	public void setFileids(String fileids) {
		this.fileids = fileids;
	}
	public String getFileentrydatetime() {
		return fileentrydatetime;
	}
	public void setFileentrydatetime(String fileentrydatetime) {
		this.fileentrydatetime = fileentrydatetime;
	}
	public String getFilecompletedate() {
		return filecompletedate;
	}
	public void setFilecompletedate(String filecompletedate) {
		this.filecompletedate = filecompletedate;
	}
	public String getFileprogresspercentage() {
		return fileprogresspercentage;
	}
	public void setFileprogresspercentage(String fileprogresspercentage) {
		this.fileprogresspercentage = fileprogresspercentage;
	}
	
	
}
