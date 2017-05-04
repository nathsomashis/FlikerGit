package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="QuestionAnswerDocSet")
public class QuestionAnswerDocSet {

	@Id
	private String sheetdocid;
	private String sheetContent;
	private String sheetContentNo;
	private String fileid[];
	public String getSheetdocid() {
		return sheetdocid;
	}
	public void setSheetdocid(String sheetdocid) {
		this.sheetdocid = sheetdocid;
	}
	public String[] getFileid() {
		return fileid;
	}
	public void setFileid(String[] fileid) {
		this.fileid = fileid;
	}
	public String getSheetContent() {
		return sheetContent;
	}
	public void setSheetContent(String sheetContent) {
		this.sheetContent = sheetContent;
	}
	public String getSheetContentNo() {
		return sheetContentNo;
	}
	public void setSheetContentNo(String sheetContentNo) {
		this.sheetContentNo = sheetContentNo;
	}
	
	
}
