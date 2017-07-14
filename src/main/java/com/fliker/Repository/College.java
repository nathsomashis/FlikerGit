package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="College")
public class College {

	private String collegeid;
	private String collegename;
	private String collegeprincipal;
	private String collegeaddress;
	private String collegeadmissioncharges;
	private String[] branchid;
	private String[] studentuser;
	private String boardid;
	
	
}
