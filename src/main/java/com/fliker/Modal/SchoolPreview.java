package com.fliker.Modal;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Assignment;
import com.fliker.Repository.Institute;
import com.fliker.Repository.InstituteDivision;
import com.fliker.Repository.Profile;
import com.fliker.Repository.Timetable;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class SchoolPreview {

	public ArrayList getSchoolTakingData(String userid){
		
		ArrayList schoollist = new ArrayList();
		
		MongoConnection mongocon = new MongoConnection();
		Assignment assignment = new Assignment();
		DBCursor resultcursor = mongocon.getDBObject("studentuserid", userid, "EschoolStudentInfo");
		while(resultcursor.hasNext()){
			DBObject dbj = resultcursor.next();
			HashMap schoolattendmap = new HashMap();
			schoolattendmap.put("schoolid", (String)dbj.get("schoolid"));
			
			
			if(((String)dbj.get("optall")).equalsIgnoreCase("false")){
				schoolattendmap.put("optall", "false");
			}
			if(((String)dbj.get("optonlycourse")).equalsIgnoreCase("true")){
				schoolattendmap.put("courselist", (BasicDBList)dbj.get("courseselection"));
			}else if(((String)dbj.get("optguidanceonly")).equalsIgnoreCase("true")){
				schoolattendmap.put("guidancelist", (BasicDBList)dbj.get("guidanceselection"));
			}else {
				schoolattendmap.put("courselist", (BasicDBList)dbj.get("courseselection"));
				schoolattendmap.put("guidancelist", (BasicDBList)dbj.get("guidanceselection"));
			}
			
			
			schoollist.add(schoolattendmap);
		}
		
		return schoollist;
	}
	
	public ArrayList getAllSchoolPublishData(String userid){
		
		ArrayList schoolattendlist = new ArrayList();
		
		MongoConnection mongocon = new MongoConnection();
		Assignment assignment = new Assignment();
		DBCursor resultcursor = mongocon.getDBObject("userid", userid, "Profile");
		while(resultcursor.hasNext()){
			DBObject dbj = resultcursor.next();
			
			BasicDBList schoolids = (BasicDBList)dbj.get("schoolids");
			for(int m=0;m<schoolids.size();m++){
				HashMap schoolmap = new HashMap();
				DBCursor schoolcursor = mongocon.getDBObject("eschoolid", (String)schoolids.get(m), "ESchool");
				while(schoolcursor.hasNext()){
					DBObject schooldbj = schoolcursor.next();
					schoolmap.put("schoolid", (String)schooldbj.get("eschoolid"));
					schoolmap.put("schoolname", (String)schooldbj.get("eschoolname"));
					schoolmap.put("schoolduration", (String)schooldbj.get("duration"));
					
					if(((String)schooldbj.get("onlycheckguidance")).equalsIgnoreCase("true")){
						
						BasicDBList guidancelinks = (BasicDBList)schooldbj.get("eschoolguidancelink");
						schoolmap.put("guidancelinks", guidancelinks);
						
					}else if(((String)schooldbj.get("onlycheckcourse")).equalsIgnoreCase("true")){
						
						BasicDBList courselinks = (BasicDBList)schooldbj.get("eschoolcourselink");
						schoolmap.put("courselinks", courselinks);
						
					}else{
						
						BasicDBList courselinks = (BasicDBList)schooldbj.get("eschoolcourselink");
						schoolmap.put("courselinks", courselinks);
						BasicDBList guidancelinks = (BasicDBList)schooldbj.get("eschoolguidancelink");
						schoolmap.put("guidancelinks", guidancelinks);
						
					}
					schoolmap.put("schooldesc", (String)schooldbj.get("eschooldescription"));
					BasicDBList studentlist = (BasicDBList)schooldbj.get("studentslistinfo");
					schoolmap.put("studentnumber", Integer.toString(studentlist.size()));
					BasicDBList resourcelist = (BasicDBList)schooldbj.get("resources");
					schoolmap.put("resources", resourcelist);
					schoolmap.put("schoollocation", (String)schooldbj.get("schoollocation"));
					schoolmap.put("schoolimage", (String)schooldbj.get("eschoolimageid"));
					BasicDBList likes = (BasicDBList)schooldbj.get("likes");
					BasicDBList shares = (BasicDBList)schooldbj.get("shares");
					schoolmap.put("likes", Integer.toString(likes.size()));
					schoolmap.put("share", Integer.toString(shares.size()));
					
				}
				
				schoolattendlist.add(schoolmap	);
				
			}
			
		}
		
		return schoolattendlist;
	}

	public String addNewInstitute(String institutetype, String institutename, String institutedesc, String instituteadd, String currentstatus, String instituteprice) {
		// TODO Auto-generated method stub
		
		
		
		
		SchoolPreview schoolprev = new SchoolPreview();
		
		Institute institute = new Institute();
		institute.setInstituteaddress(instituteadd);
		institute.setInstitutename(institutename);
		institute.setInstitutedesc(institutedesc);
		GuidancePreview guidanceprev = new GuidancePreview();
		
		
		String uniqueid = "";
		
		try {
			uniqueid = guidanceprev.makeSHA1Hash(institutename+institutetype);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		institute.setInstituteid(uniqueid);
		institute.setCurrentstatus(currentstatus);
		String[] divisionid = new String[0];
		institute.setDivisionid(divisionid);
		institute.setPlaygroundid("");
		institute.setScheduletimetable("");
		String[] testtemplateid = new String[0];
		institute.setTesttemplateid(testtemplateid);
		institute.setInstituteadmissionprice(instituteprice);
		institute.setInstitutetype("Institute");
		
		MongoConnection mongoconsearch = new MongoConnection();
		BasicDBObject basicguishareobj =  schoolprev.formNewInstituteDBObject(institute);
		mongoconsearch.saveObject(basicguishareobj, "Institute");
		
		return uniqueid;
		
	}

	private BasicDBObject formNewInstituteDBObject(Institute institute) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("accountid", institute.getAccountid());
		basicdbobj.put("currentstatus", institute.getCurrentstatus());
		basicdbobj.put("divisionid", institute.getDivisionid());
		basicdbobj.put("instituteaddress", institute.getInstituteaddress());
		basicdbobj.put("instituteadmissionprice", institute.getInstituteadmissionprice());
		basicdbobj.put("institutedesc", institute.getInstitutedesc());
		basicdbobj.put("instituteid", institute.getInstituteid());
		basicdbobj.put("institutename", institute.getInstitutename());
		basicdbobj.put("planinfoid", institute.getPlaninfoid());
		basicdbobj.put("playgroundid", institute.getPlaygroundid());
		basicdbobj.put("scheduletimetable", institute.getScheduletimetable());
		basicdbobj.put("studentparentportalid", institute.getStudentparentportalid());
		basicdbobj.put("testtemplateid", institute.getTesttemplateid());
		basicdbobj.put("institutetype", institute.getInstitutetype());
		
		return basicdbobj;
	}

	public JSONArray getSubjectGuidance(String guidancesubject) {
		// TODO Auto-generated method stub
		ArrayList guidancelist = new ArrayList();
		JSONArray jsonlist = new JSONArray();
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("guidanceSubject", guidancesubject, "GuidanceSelection");
		while(resultcursor.hasNext()){
			DBObject dbj = resultcursor.next();
			
			JSONObject jsonobj = new JSONObject();
			
			ProfilePreview profprev = new ProfilePreview();
			Profile profile = profprev.getProfileData((String)dbj.get("userid"));
			
			jsonobj.put("Name", profile.getName());
			jsonobj.put("Position", profile.getCurrentStatus());
			jsonobj.put("Office", (String)dbj.get("guidancelocation"));
			BasicDBList interestedmem = (BasicDBList)dbj.get("guidanceinterest");
			jsonobj.put("People Interested", Integer.toString(interestedmem.size()));
			jsonobj.put("Duration", (String)dbj.get("guidanceduration"));
			jsonobj.put("Price", (String)dbj.get("price"));
			
			jsonlist.add(jsonobj);
		}
		
		
		return jsonlist;
	}

	public ArrayList saveNewBranchCollege(String branch, String subjectlist, String sectionlist, String collegeid) {
		// TODO Auto-generated method stub
		
		String[] subjectar = subjectlist.split(",");
		String[] subdivisionrr = sectionlist.split(",");
		
		InstituteDivision institutedivision = new InstituteDivision();
		institutedivision.setDivisiontype(branch);
		String uniqueid = "";
		GuidancePreview guidanceprev = new GuidancePreview();
		
		try {
			uniqueid = guidanceprev.makeSHA1Hash(branch+collegeid);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		institutedivision.setDivisionid(uniqueid);
		institutedivision.setBlackboardid(uniqueid);
		String[] historybatchid = new String[0];
		institutedivision.setHistorybatchid(historybatchid);
		String[] students = new String[0];
		institutedivision.setStudents(students);
		institutedivision.setSubdivisiontype(subdivisionrr);
		if(subdivisionrr.length < 1){
			Timetable timetable = new Timetable();
			
			
			//timetable.setTimeableid();
			
			institutedivision.setTimetableid(uniqueid);
		}
		
		
		
		
		
		
		MongoConnection mongoconsearch = new MongoConnection();
		//mongoconsearch.updateObject(new BasicDBObject("instituteid", collegeid),new BasicDBObject("$push", new BasicDBObject("consumeruserid", userid)), "Institute");
		
		
		return null;
	}

	public String addNewCollege(String institutetype, String institutename, String institutedesc, String instituteadd,
			String currentstatus, String instituteprice) {
		// TODO Auto-generated method stub
		
		Institute institute = new Institute();
		institute.setCurrentstatus(currentstatus);
		institute.setInstituteaddress(instituteadd);
		institute.setInstituteadmissionprice(instituteprice);
		institute.setInstitutedesc(institutedesc);
		institute.setInstitutename(institutename);
		String uniqueid = "";
		GuidancePreview guidanceprev = new GuidancePreview();
		
		try {
			uniqueid = guidanceprev.makeSHA1Hash(institutename+institutetype);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		institute.setInstituteid(uniqueid);
		String[] planinfoid = new String[0];
		institute.setPlaninfoid(planinfoid);
		institute.setPlaygroundid("");
		String[] testtemplateid = new String[0];
		institute.setTesttemplateid(testtemplateid);
		String[] studentparentportalid = new String[0];
		institute.setStudentparentportalid(studentparentportalid);
		institute.setScheduletimetable("");
		institute.setInstitutetype("College");
		SchoolPreview schoolprev = new SchoolPreview();
		
		MongoConnection mongoconsearch = new MongoConnection();
		BasicDBObject basicguishareobj =  schoolprev.formNewInstituteDBObject(institute);
		mongoconsearch.saveObject(basicguishareobj, "Institute");
		
		return uniqueid;
	}
	
	
	
	
}
