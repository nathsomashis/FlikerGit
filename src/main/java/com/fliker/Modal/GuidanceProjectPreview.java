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

import org.springframework.web.multipart.MultipartFile;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.FileUnionTimeFrame;
import com.fliker.Repository.FileUpload;
import com.fliker.Repository.ProjectAssignment;
import com.fliker.Utility.DateFunctionality;
import com.mongodb.BasicDBObject;

public class GuidanceProjectPreview {

	public IdentityHashMap< String, HashMap<String,LinkedList<String>>> requestobjectmap = new IdentityHashMap<String,HashMap<String,LinkedList<String>>>();
	
	public void saveFile(Map<String, MultipartFile> fileMap, String userid, String asignNo,String token){
		String fileids = "";
		String filenames = "";
		
		GuidanceProjectPreview guideprev = new GuidanceProjectPreview();
		// Maintain a list to send back the files info. to the client side
		List<FileUpload> uploadedFiles = new ArrayList<FileUpload>();

		for (MultipartFile multipartFile : fileMap.values()) {

			// Save the file to local disk
			try {
				guideprev.saveFileToLocalDisk(multipartFile);

				FileUpload fileInfo = guideprev.getUploadedFileInfo(multipartFile);
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
				
				String context = "Project Flow ::"+asignNo+" ,FileID ::"+fileid+" ,FileName ::"+filenames;
				
				guideprev.savetempfilehistory(userid, fileid, localdate,daypack,monthspack, hourpack,context,token);
				
				
				
				
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
		
		GuidanceProjectPreview guideprev = new GuidanceProjectPreview();
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
		BasicDBObject basicreqobjsearch =  guideprev.formDBObject(fileuntimeframe);
		
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


	public void createProjectPaper(String projectname, String projectdescription, String tokenid) {
		// TODO Auto-generated method stub
		
		GuidanceProjectPreview guideprojprev = new GuidanceProjectPreview();
		
		ProjectAssignment projectassign = new ProjectAssignment();
		projectassign.setProject_article(projectdescription);
		
		String uniqueid = "";
		try {
			uniqueid = guideprojprev.makeSHA1Hash(projectname);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		projectassign.setProjectid(uniqueid);
		
		MongoConnection mongoconsearch = new MongoConnection();
		SearchPreview searchprev = new SearchPreview();
		BasicDBObject basicreqobjsearch =  guideprojprev.formDBGuidanceProjectObject(projectassign);
		
		mongoconsearch.saveObject(basicreqobjsearch, "ProjectAssignment");
		
		
		
	}
	
	
	private BasicDBObject formDBGuidanceProjectObject(ProjectAssignment projectassign) {
		// TODO Auto-generated method stub
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("projectid", projectassign.getProjectid());
		basicdbobj.put("project_links", projectassign.getProject_links());
		basicdbobj.put("project_flow", projectassign.getProject_flow());
		basicdbobj.put("project_doc", projectassign.getProject_doc());
		basicdbobj.put("project_article", projectassign.getProject_article());
		basicdbobj.put("project_answer_reference_link", projectassign.getProject_answer_reference_link());
		basicdbobj.put("project_answer_reference_doc", projectassign.getProject_answer_reference_doc());
		basicdbobj.put("project_answer_links", projectassign.getProject_answer_links());
		basicdbobj.put("project_answer_doc", projectassign.getProject_answer_doc());
		basicdbobj.put("project_answer_architechture", projectassign.getProject_answer_architechture());
		
		
		return basicdbobj;
	}
	
	
}
