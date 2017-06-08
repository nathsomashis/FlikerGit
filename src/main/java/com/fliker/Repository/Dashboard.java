package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Dashboard")
public class Dashboard {

	@Id
	private String dashboardid;
	private String[] locationids;
	public String getDashboardid() {
		return dashboardid;
	}
	public void setDashboardid(String dashboardid) {
		this.dashboardid = dashboardid;
	}
	public String[] getLocationids() {
		return locationids;
	}
	public void setLocationids(String[] locationids) {
		this.locationids = locationids;
	}
	
	
}
