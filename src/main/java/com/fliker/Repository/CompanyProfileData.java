package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="")
public class CompanyProfileData {

	@Id
	private String dataid;
	public String getDataid() {
		return dataid;
	}
	public void setDataid(String dataid) {
		this.dataid = dataid;
	}
	private String fileid;
	private String fileEdition;
	public String getFileid() {
		return fileid;
	}
	public void setFileid(String fileid) {
		this.fileid = fileid;
	}
	public String getFileEdition() {
		return fileEdition;
	}
	public void setFileEdition(String fileEdition) {
		this.fileEdition = fileEdition;
	}
	
	
}
