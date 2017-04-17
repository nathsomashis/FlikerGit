package com.fliker.Modal;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import com.fliker.Repository.Assignment;
import com.fliker.Repository.Guidance;
import com.mongodb.BasicDBObject;

public class AssignmentPreview {

	
	private ArrayList answerset;
	private ArrayList questionsets;
	
	
	public void createAssignment(String assignques){
		
		Assignment asignment = new Assignment();
		
		
	}

	public void submitAssignment(String assignstarttime, String assignenddate){
		
		Assignment asignment = new Assignment();
		AssignmentPreview assignprev = new AssignmentPreview();
		
		
		
		String uniqueid = "";
		
		try {
			uniqueid = assignprev.makeSHA1Hash(assignstarttime+assignenddate);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		asignment.setAssignmentid(uniqueid);
		asignment.setAssignmentstartdatetime(assignstarttime);
		
	}
	
	
	public String makeSHA1Hash(String input)
	          throws NoSuchAlgorithmException, UnsupportedEncodingException
	      {
	          MessageDigest md = MessageDigest.getInstance("SHA1");
	          md.reset();
	          byte[] buffer = input.getBytes("UTF-8");
	          md.update(buffer);
	          byte[] digest = md.digest();

	          String hexStr = "";
	          for (int i = 0; i < digest.length; i++) {
	              hexStr +=  Integer.toString( ( digest[i] & 0xff ) + 0x100, 16).substring( 1 );
	          }
	          return hexStr;
	      }

	  public BasicDBObject formDBObject(Guidance guidance){
			
			BasicDBObject basicdbobj = new BasicDBObject();
			basicdbobj.put("guidanceid", guidance.getGuidanceid());
			basicdbobj.put("userid", guidance.getUserid());
			basicdbobj.put("guidanceSubject", guidance.getGuidanceSubject());
			
			return basicdbobj;
			
		}
	
}
