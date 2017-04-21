package com.fliker.DataAnalysis;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ProjectModuleAnalysis")
public class ProjectModuleAnalysis {

	@Id
	private String moduleid;
	private String moduleapproach;
	private String moduleflow;
	private String modulerepeat;
	private String modulecorrection;
	public String getModuleid() {
		return moduleid;
	}
	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
	}
	public String getModuleapproach() {
		return moduleapproach;
	}
	public void setModuleapproach(String moduleapproach) {
		this.moduleapproach = moduleapproach;
	}
	public String getModuleflow() {
		return moduleflow;
	}
	public void setModuleflow(String moduleflow) {
		this.moduleflow = moduleflow;
	}
	public String getModulerepeat() {
		return modulerepeat;
	}
	public void setModulerepeat(String modulerepeat) {
		this.modulerepeat = modulerepeat;
	}
	public String getModulecorrection() {
		return modulecorrection;
	}
	public void setModulecorrection(String modulecorrection) {
		this.modulecorrection = modulecorrection;
	}
	
	
	
}
