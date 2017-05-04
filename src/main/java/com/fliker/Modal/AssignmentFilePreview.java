package com.fliker.Modal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Assignment;
import com.fliker.Repository.FileUnionTimeFrame;
import com.fliker.Repository.FileUpload;
import com.fliker.Repository.QuestionAnswerDocSet;
import com.fliker.Utility.DateFunctionality;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class AssignmentFilePreview {
	
	
	public IdentityHashMap< String, HashMap<String,LinkedList<String>>> requestobjectmap = new IdentityHashMap<String,HashMap<String,LinkedList<String>>>();

	
	public void saveFileToLocalDisk(MultipartFile multipartFile) throws IOException, FileNotFoundException {

		String outputFileName = getOutputFilename(multipartFile);
		byte[] imagebytes = multipartFile.getBytes();
		// FileCopyUtils.copy(multipartFile.getBytes(), new
		// FileOutputStream(outputFileName));
		System.out.println(outputFileName);
		System.out.println(imagebytes);

	}
	
	public String getOutputFilename(MultipartFile multipartFile) {

		return getDestinationLocation() + multipartFile.getOriginalFilename();
	}

	public String getDestinationLocation() {
		return "F:/uploaded-files/";
	}
	
	public FileUpload getUploadedFileInfo(MultipartFile multipartFile) throws IOException {

		AssignmentFilePreview assignprev = new AssignmentFilePreview();
		String uniqueid = "";
		try {
			uniqueid = assignprev.makeSHA1Hash(multipartFile.getOriginalFilename());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FileUpload fileInfo = new FileUpload();
		fileInfo.setFileid(uniqueid + System.currentTimeMillis());
		fileInfo.setName(multipartFile.getOriginalFilename());
		fileInfo.setSize(multipartFile.getSize());
		fileInfo.setType(multipartFile.getContentType());
		fileInfo.setLocation(getDestinationLocation());
		fileInfo.setFileblob(multipartFile.getBytes());

		return fileInfo;
	}
	
	public String makeSHA1Hash(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("SHA1");
		md.reset();
		byte[] buffer = input.getBytes("UTF-8");
		md.update(buffer);
		byte[] digest = md.digest();

		String hexStr = "";
		for (int i = 0; i < digest.length; i++) {
			hexStr += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1);
		}
		return hexStr;
	}
	
	public void saveFile(Map<String, MultipartFile> fileMap, String userid, String asignNo,String token){
		String fileids = "";
		String filenames = "";
		
		AssignmentFilePreview assignprev = new AssignmentFilePreview();
		// Maintain a list to send back the files info. to the client side
		List<FileUpload> uploadedFiles = new ArrayList<FileUpload>();

		for (MultipartFile multipartFile : fileMap.values()) {

			// Save the file to local disk
			try {
				assignprev.saveFileToLocalDisk(multipartFile);

				FileUpload fileInfo = assignprev.getUploadedFileInfo(multipartFile);
				fileids = fileInfo.getFileid();
				filenames = fileInfo.getName();
				String fileid = fileInfo.getFileid();
				FilePreview filepreview = new FilePreview();
				filepreview.saveFile(fileInfo);

				SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
		        //String dateInString = "Friday, Jun 7, 2013 12:10:56 PM";//example
		        
				
				
	            Date datepack = new Date();
	            DateFunctionality datefunc = new DateFunctionality();
	            
	            String localdate = datefunc.getUniformDates(formatter.format(datepack));
	            
	            Calendar cal = Calendar.getInstance();
	            cal.setTime(datepack);
	            
	            String yearpack = Integer.toString(cal.get(Calendar.YEAR));
	            String monthspack = Integer.toString(cal.get(Calendar.MONTH));
	            String daypack = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
	            String hourpack = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
	            String minutespack  = Integer.toString(cal.get(Calendar.MINUTE));
				
				String context = "Assignment ::"+asignNo+" ,FileID ::"+fileid+" ,FileName ::"+filenames;
				
				assignprev.savetempfilehistory(userid, fileid, localdate,daypack,monthspack, hourpack,context,token);
				
				
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}
	
	
	public void savetempfilehistory(String userid, String fileid, String date, String day,String month, String hour, String context,String  token ){
		
		AssignmentFilePreview assignprev = new AssignmentFilePreview();
		/*String uniqueid = "";
		
		try {
			uniqueid = assignprev.makeSHA1Hash(fileid+userid);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
		Set collectionset = requestobjectmap.entrySet();
		Iterator colliter = collectionset.iterator();
		while(colliter.hasNext()){
			
			Map.Entry me = (Map.Entry)colliter.next();
			
			if(me.getKey() == token){
				HashMap userval = (HashMap)me.getValue();
				Set userset = userval.entrySet();
				Iterator userit = userset.iterator();
				while(userit.hasNext()){
					Map.Entry met = (Map.Entry)userit.next();
					
					if(((String)met.getKey()).equalsIgnoreCase(userid)){
						
						LinkedList templist = (LinkedList)me.getValue();
						templist.add(fileid);
						
					}
					
				}
						
				
			}else{
				
				LinkedList templist = new LinkedList();
				templist.add(fileid);
				HashMap setupmap = new HashMap();
				setupmap.put(userid, templist);
				
				requestobjectmap.put(token, setupmap);
				
				
				
			}
			
		}
		
		FileUnionTimeFrame fileuntimeframe = new FileUnionTimeFrame();
		fileuntimeframe.setContext(context);
		fileuntimeframe.setDate(date);
		fileuntimeframe.setDay(day);
		fileuntimeframe.setFileid(fileid);
		fileuntimeframe.setHour(hour);
		fileuntimeframe.setMonth(month);
		fileuntimeframe.setTempid(token);
		fileuntimeframe.setUserid(userid);
		
		MongoConnection mongoconsearch = new MongoConnection();
		SearchPreview searchprev = new SearchPreview();
		BasicDBObject basicreqobjsearch =  assignprev.formDBObject(fileuntimeframe);
		
		mongoconsearch.saveObject(basicreqobjsearch, "FileUnionTimeFrame");
		
	}

	private BasicDBObject formDBObject(FileUnionTimeFrame fileuntimeframe) {
		// TODO Auto-generated method stub
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("context", fileuntimeframe.getContext());
		basicdbobj.put("date", fileuntimeframe.getDate());
		basicdbobj.put("day", fileuntimeframe.getDay());
		basicdbobj.put("fileid", fileuntimeframe.getFileid());
		basicdbobj.put("hour", fileuntimeframe.getHour());
		basicdbobj.put("month", fileuntimeframe.getMonth());
		basicdbobj.put("tempid", fileuntimeframe.getTempid());
		basicdbobj.put("userid", fileuntimeframe.getUserid());
		
		
		return basicdbobj;
	}

	public ArrayList saveAssignments(String assignmentSets, String tokenid, String userid) {
		// TODO Auto-generated method stub
		
		ArrayList assignmentlist = new ArrayList();
		HashMap<Integer,HashMap<String,String>> assignquestionset = new HashMap<Integer,HashMap<String,String>>();
		
		AssignmentPreview assignprev = new AssignmentPreview();
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("tempid", tokenid, "FileUnionTimeFrame");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			if(((String)theObj.get("userid")).equalsIgnoreCase(userid)){
				
				QuestionAnswerDocSet questionanswerdocset = new QuestionAnswerDocSet();
				
				
				String assignmentQuestion = "";
				
				
				String contexttext = (String)theObj.get("context");
				String assignmentNo = (contexttext.split(",")[0]).split("::")[1];
				String fileid = (contexttext.split(",")[1]).split("::")[1];
				
				String[] assignmentset = assignmentSets.split(":;");
				
				for(int m=0;m<assignmentset.length;m++){
					
					String assignmentQno = assignmentset[m].split("::")[0];
					
					if(assignmentQno.equalsIgnoreCase(assignmentNo)){
						
						assignmentQuestion = assignmentQno +"::"+assignmentset[m].split("::")[1];
						
						Set assignset = assignquestionset.entrySet();
						Iterator assignit = assignset.iterator();
						while(assignit.hasNext()){
							Map.Entry meassign = (Map.Entry)assignit.next();
							
							int qnos = (Integer)meassign.getKey();
							int qno = Integer.valueOf(assignmentQno);
							if(qnos == qno){
								
								HashMap existingfileid = (HashMap)meassign.getValue();
								Set exisset = existingfileid.entrySet();
								Iterator existit = exisset.iterator();
								while(existit.hasNext()){
									Map.Entry meexist = (Map.Entry)existit.next();
									
									String existingfile = (String)meexist.getValue();
									existingfile = existingfile + ","+fileid;
									HashMap newStateData = new HashMap();
									newStateData.put((String)meexist.getKey(), existingfile);
									assignquestionset.put(qno, newStateData);
								}
								
							}else{
								
								HashMap newStateData = new HashMap();
								newStateData.put(assignmentset[m].split("::")[1], fileid);
								assignquestionset.put(qno, newStateData);
							}
							
						}
						
					}
					
				}
				
				//assignmentlist.add(fileunitimfr);
				assignmentlist.add(assignmentQuestion);
				
			}
			
		}
		
		assignprev.saveAssignmentQuestionSet(assignquestionset);
		return assignmentlist;
	}
	
	
	
	public ArrayList saveQuestionAssignments(String assignmentSets, String tokenid, String userid, String assignmentid) {
		// TODO Auto-generated method stub
		
		Assignment assignment = new Assignment();
		ArrayList assignmentlist = new ArrayList();
		AssignmentPreview assignprev = new AssignmentPreview();
		HashMap<Integer,HashMap<String,String>> assignquestionset = new HashMap<Integer,HashMap<String,String>>();
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("tempid", tokenid, "FileUnionTimeFrame");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			if(((String)theObj.get("userid")).equalsIgnoreCase(userid)){
				QuestionAnswerDocSet questionanswerdocset = new QuestionAnswerDocSet();
				
				
				String assignmentQuestion = "";
				
				
				String contexttext = (String)theObj.get("context");
				String assignmentNo = (contexttext.split(",")[0]).split("::")[1];
				String fileid = (contexttext.split(",")[1]).split("::")[1];
				
				String[] assignmentset = assignmentSets.split(":;");
				
				for(int m=0;m<assignmentset.length;m++){
					
					String assignmentQno = assignmentset[m].split("::")[0];
					
					if(assignmentQno.equalsIgnoreCase(assignmentNo)){
						
						assignmentQuestion = assignmentQno +"::"+assignmentset[m].split("::")[1];
						
						Set assignset = assignquestionset.entrySet();
						Iterator assignit = assignset.iterator();
						while(assignit.hasNext()){
							Map.Entry meassign = (Map.Entry)assignit.next();
							
							int qnos = (Integer)meassign.getKey();
							int qno = Integer.valueOf(assignmentQno);
							if(qnos == qno){
								
								HashMap existingfileid = (HashMap)meassign.getValue();
								Set exisset = existingfileid.entrySet();
								Iterator existit = exisset.iterator();
								while(existit.hasNext()){
									Map.Entry meexist = (Map.Entry)existit.next();
									
									String existingfile = (String)meexist.getValue();
									existingfile = existingfile + ","+fileid;
									HashMap newStateData = new HashMap();
									newStateData.put((String)meexist.getKey(), existingfile);
									assignquestionset.put(qno, newStateData);
								}
								
							}else{
								
								HashMap newStateData = new HashMap();
								newStateData.put(assignmentset[m].split("::")[1], fileid);
								assignquestionset.put(qno, newStateData);
							}
							
						}
						
					}
					
				}
				
				//assignmentlist.add(fileunitimfr);
				assignmentlist.add(assignmentQuestion);
				
			}
			
		}
		
		assignprev.saveAssignmentAnswerSet(assignquestionset,assignmentid);
		return assignmentlist;
	}
	
	
	
	

	public ArrayList answerAssignments(String assignmentSets, String tokenid, String userid) {
		// TODO Auto-generated method stub
		
		
		
		
		return null;
	}
	
	
				
	
	
}
