package com.fliker.Modal;

import java.util.ArrayList;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.ClassRoom;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ClassRoomPreview {
	
	ArrayList classroomprovided = null;
	ArrayList classroomtaken = null;
	String ProfileTimeTable = null;

	//no classroom/ nor providing
	public boolean isHaveClassroom(String userid){
		
		boolean classroomproviding = false;		
		classroomprovided = new ArrayList();
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("owner", userid, "ClassRoom");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			ClassRoom classroom = new ClassRoom();
			
			classroom.setClassname((String)theObj.get("classname"));
			classroom.setClassroomid((String)theObj.get("classroomid"));
			classroom.setDemoclassid((String)theObj.get("democlassid"));
			String[] partnerid = ((String)theObj.get("partnerid")).split(",");
			classroom.setPartnerid(partnerid);
			classroom.setProfileid((String)theObj.get("profileid"));
			classroom.setTimtableid((String)theObj.get("timtableid"));
			
			classroomprovided.add(classroom);
			classroomproviding = true;
			
		}else{
			classroomprovided.add("");
		}
		
		
		return classroomproviding;
	}
	
	public boolean isPublishClassroom(){
		
		boolean classpublished = false;
		
		
		
		return classpublished;
		
	}
	//no class taken / nor taken
	public boolean isTakingClassroom(String userid){
		
		boolean istakingclassrom = false;
		classroomtaken = new ArrayList();
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("userid", userid, "Profile");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
		
			String[] ongoingclassroomids = ((String)theObj.get("classroomid")).split(",");
			String timetableid = (String)theObj.get("timetableid");
			ProfileTimeTable = timetableid;
			istakingclassrom = true;
			
			for(int i=0;i<ongoingclassroomids.length;i++){
				
				DBCursor resultClascursor = mongocon.getDBObject("classroomid", ongoingclassroomids[i], "ClassRoom");
				if(resultClascursor.hasNext()){
					
					ClassRoom classroom = new ClassRoom();
					
					classroom.setClassname((String)theObj.get("classname"));
					classroom.setClassroomid((String)theObj.get("classroomid"));
					classroom.setDemoclassid((String)theObj.get("democlassid"));
					String[] partnerid = ((String)theObj.get("partnerid")).split(",");
					classroom.setPartnerid(partnerid);
					classroom.setProfileid((String)theObj.get("profileid"));
					classroom.setTimtableid((String)theObj.get("timtableid"));
					
					classroomtaken.add(classroom);
					
					
				}
				
			}
		}else{
			classroomtaken.add("");
		}
		
		return istakingclassrom;
	}
	
	public ArrayList getAllClassroom(){
		
		ArrayList allclassrooms = new ArrayList();
		
		allclassrooms = classroomprovided;
		
		return allclassrooms;
	}
	
	public ArrayList getAllOngoingClasses(){
		
		ArrayList ongoingclases = new ArrayList();
		
		ongoingclases = classroomtaken;
		
		return ongoingclases;
	}
	
	public String getTimeTables(){
		
		return ProfileTimeTable;
	}
	
	public String pageProm(String userid){
		String pageprom = "";
		ClassRoomPreview classromprev = new ClassRoomPreview();
		if(classromprev.isHaveClassroom(userid) && classromprev.isTakingClassroom(userid)){
			pageprom = "ClasRoomPublishAll";//done
		}else if(classromprev.isHaveClassroom(userid) &&	!classromprev.isTakingClassroom(userid)){
			pageprom = "ClassRoomOnly";//done
		}else if(!classromprev.isHaveClassroom(userid) &&	classromprev.isTakingClassroom(userid)){
			pageprom = "ClassTakingOnly";//done
		}else {
			pageprom = "ClassRoom";//done
		}
		return pageprom;
	}
	
	public void createClassRoom(){
		
	}
	
	
}
