package com.fliker.DataAnalysis;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GeoSpacialAnalysis")
public class GeoSpacialAnalysis {

	@Id
	private String geospacialid;
	private String contentspecsid;
	
	
}
