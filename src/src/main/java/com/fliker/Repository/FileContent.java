package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="FileContent")
public class FileContent {

	@Id
	private String filecontentid;
	private String fileid;
	private String fileContent;
	private String fileurl;
	public String getFilecontentid() {
		return filecontentid;
	}
	public void setFilecontentid(String filecontentid) {
		this.filecontentid = filecontentid;
	}
	public String getFileid() {
		return fileid;
	}
	public void setFileid(String fileid) {
		this.fileid = fileid;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	public String getFileurl() {
		return fileurl;
	}
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
	
	
	
}
