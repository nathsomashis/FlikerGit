package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceLocationData")
public class GuidanceLocationData {

	private String locationid;
	private String guidanceid;
	private String userid;
	
}
