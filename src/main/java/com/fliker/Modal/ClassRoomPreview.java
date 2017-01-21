package com.fliker.Modal;

import java.util.ArrayList;

public class ClassRoomPreview {

	public boolean isHaveClassroom(){
		
		boolean classroom = false;		
		//search is being part of any classrrom 
		
		
		return classroom;
	}
	
	public boolean isPublishClassroom(){
		
		boolean classpublished = false;
		
		
		
		return classpublished;
		
	}
	
	public boolean isTakingClassroom(){
		
		boolean istakingclassrom = false;
		
		
		return istakingclassrom;
	}
	
	public ArrayList getAllClassroom(){
		
		ArrayList allclassrooms = new ArrayList();
		
		
		
		return allclassrooms;
	}
	
	public ArrayList getAllOngoingClasses(){
		
		ArrayList ongoingclases = new ArrayList();
		
		
		return ongoingclases;
	}
	
	public ArrayList getTimeTables(){
		
		ArrayList timeTables = new ArrayList();
		
		
		
		return timeTables;
	}
	
	public String pageProm(){
		String pageprom = "";
		ClassRoomPreview classromprev = new ClassRoomPreview();
		if(classromprev.isHaveClassroom() && classromprev.isTakingClassroom()){
			pageprom = "ClasRoomPublishAll";
		}else if(classromprev.isHaveClassroom() &&	!classromprev.isTakingClassroom()){
			pageprom = "ClassRoomOnly";
		}else {
			pageprom = "ClassRoom";
		}
		return pageprom;
	}
	
	public void createClassRoom(){
		
	}
	
	
}
