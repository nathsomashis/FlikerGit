package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="InstituteTestTemplate")
public class InstituteTestTemplate {

	@Id
	private String testemplateid; //2018 half yearly test
	private String[] examtemplateid;
	private String seatarrangementid;
	private String[] studentresultid;
	
}
