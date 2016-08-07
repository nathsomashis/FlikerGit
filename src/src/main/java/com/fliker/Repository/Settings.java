package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Settings")
public class Settings {

	@Id
	private String profileid;
	private String fixedheader;
	private String fixedNavigation;
	private String fixedRibbon;
	private String fixedFooter;
	private String container;
	private String rtlsupport;
	private String menuontop;
	private String colorblind;
	private String smartdefault;
	private String darkelegencce;
	private String ultralight;
	private String googleskin;
	private String pixelsmash;
	private String glass;
	private String materialdesign;
	public String getProfileid() {
		return profileid;
	}
	public void setProfileid(String profileid) {
		this.profileid = profileid;
	}
	public String getFixedheader() {
		return fixedheader;
	}
	public void setFixedheader(String fixedheader) {
		this.fixedheader = fixedheader;
	}
	public String getFixedNavigation() {
		return fixedNavigation;
	}
	public void setFixedNavigation(String fixedNavigation) {
		this.fixedNavigation = fixedNavigation;
	}
	public String getFixedRibbon() {
		return fixedRibbon;
	}
	public void setFixedRibbon(String fixedRibbon) {
		this.fixedRibbon = fixedRibbon;
	}
	public String getFixedFooter() {
		return fixedFooter;
	}
	public void setFixedFooter(String fixedFooter) {
		this.fixedFooter = fixedFooter;
	}
	public String getContainer() {
		return container;
	}
	public void setContainer(String container) {
		this.container = container;
	}
	public String getRtlsupport() {
		return rtlsupport;
	}
	public void setRtlsupport(String rtlsupport) {
		this.rtlsupport = rtlsupport;
	}
	public String getMenuontop() {
		return menuontop;
	}
	public void setMenuontop(String menuontop) {
		this.menuontop = menuontop;
	}
	public String getColorblind() {
		return colorblind;
	}
	public void setColorblind(String colorblind) {
		this.colorblind = colorblind;
	}
	public String getSmartdefault() {
		return smartdefault;
	}
	public void setSmartdefault(String smartdefault) {
		this.smartdefault = smartdefault;
	}
	public String getDarkelegencce() {
		return darkelegencce;
	}
	public void setDarkelegencce(String darkelegencce) {
		this.darkelegencce = darkelegencce;
	}
	public String getUltralight() {
		return ultralight;
	}
	public void setUltralight(String ultralight) {
		this.ultralight = ultralight;
	}
	public String getGoogleskin() {
		return googleskin;
	}
	public void setGoogleskin(String googleskin) {
		this.googleskin = googleskin;
	}
	public String getPixelsmash() {
		return pixelsmash;
	}
	public void setPixelsmash(String pixelsmash) {
		this.pixelsmash = pixelsmash;
	}
	public String getGlass() {
		return glass;
	}
	public void setGlass(String glass) {
		this.glass = glass;
	}
	public String getMaterialdesign() {
		return materialdesign;
	}
	public void setMaterialdesign(String materialdesign) {
		this.materialdesign = materialdesign;
	}
	
	
}
