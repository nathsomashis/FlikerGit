package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OSMModelPunch")
public class OSMModelPunch {

	private String osmmodelpunchid;
	private String osmmodelid;
	private String originalstockprice;
	private String onbuyerpriceincrease;
	private String onsubscribingpriceincrease;
	private String onmilestoneachievementpriceincrease;
	private String osmmodelparamone;
	private String osmmodelparamtwo;
	private String osmmodelparamthree;
	private String osmmodelparamfour;
	private String osmmodelparamfive;
	private String osmmodelparamsix;
	public String getOsmmodelpunchid() {
		return osmmodelpunchid;
	}
	public void setOsmmodelpunchid(String osmmodelpunchid) {
		this.osmmodelpunchid = osmmodelpunchid;
	}
	public String getOsmmodelid() {
		return osmmodelid;
	}
	public void setOsmmodelid(String osmmodelid) {
		this.osmmodelid = osmmodelid;
	}
	public String getOriginalstockprice() {
		return originalstockprice;
	}
	public void setOriginalstockprice(String originalstockprice) {
		this.originalstockprice = originalstockprice;
	}
	public String getOnbuyerpriceincrease() {
		return onbuyerpriceincrease;
	}
	public void setOnbuyerpriceincrease(String onbuyerpriceincrease) {
		this.onbuyerpriceincrease = onbuyerpriceincrease;
	}
	public String getOnsubscribingpriceincrease() {
		return onsubscribingpriceincrease;
	}
	public void setOnsubscribingpriceincrease(String onsubscribingpriceincrease) {
		this.onsubscribingpriceincrease = onsubscribingpriceincrease;
	}
	public String getOnmilestoneachievementpriceincrease() {
		return onmilestoneachievementpriceincrease;
	}
	public void setOnmilestoneachievementpriceincrease(String onmilestoneachievementpriceincrease) {
		this.onmilestoneachievementpriceincrease = onmilestoneachievementpriceincrease;
	}
	public String getOsmmodelparamone() {
		return osmmodelparamone;
	}
	public void setOsmmodelparamone(String osmmodelparamone) {
		this.osmmodelparamone = osmmodelparamone;
	}
	public String getOsmmodelparamtwo() {
		return osmmodelparamtwo;
	}
	public void setOsmmodelparamtwo(String osmmodelparamtwo) {
		this.osmmodelparamtwo = osmmodelparamtwo;
	}
	public String getOsmmodelparamthree() {
		return osmmodelparamthree;
	}
	public void setOsmmodelparamthree(String osmmodelparamthree) {
		this.osmmodelparamthree = osmmodelparamthree;
	}
	public String getOsmmodelparamfour() {
		return osmmodelparamfour;
	}
	public void setOsmmodelparamfour(String osmmodelparamfour) {
		this.osmmodelparamfour = osmmodelparamfour;
	}
	public String getOsmmodelparamfive() {
		return osmmodelparamfive;
	}
	public void setOsmmodelparamfive(String osmmodelparamfive) {
		this.osmmodelparamfive = osmmodelparamfive;
	}
	public String getOsmmodelparamsix() {
		return osmmodelparamsix;
	}
	public void setOsmmodelparamsix(String osmmodelparamsix) {
		this.osmmodelparamsix = osmmodelparamsix;
	}
	
	
	
	
}
