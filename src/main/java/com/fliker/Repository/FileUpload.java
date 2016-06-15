package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="fileupload")
public class FileUpload {

	  @Id
	  private String id;
	  private String name;
	  private String location;
	  private Long size;
	  private String type;
	  private byte[] fileblob;
	  
	public byte[] getFileblob() {
		return fileblob;
	}
	public void setFileblob(byte[] fileblob) {
		this.fileblob = fileblob;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	  
	
	
	
	  
}
