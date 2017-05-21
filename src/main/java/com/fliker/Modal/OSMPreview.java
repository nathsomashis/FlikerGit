package com.fliker.Modal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Company;
import com.fliker.Repository.FileUnionTimeFrame;
import com.fliker.Repository.FileUpload;
import com.fliker.Repository.OSMModel;
import com.fliker.Repository.OSMProjectInfo;
import com.fliker.Repository.SearchContent;
import com.fliker.Utility.DateFunctionality;
import com.fliker.Utility.OSMFileUtility;
import com.fliker.Utility.ServicesUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class OSMPreview {

	
	public ArrayList getProjectInfoList(){
		
		
		ArrayList projectlist = new ArrayList();
		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("OSMOwner");
		DBCursor cursor;

		cursor = collection.find().sort(new BasicDBObject("osmmodelid", -1));
		while (cursor.hasNext()) {
			DBObject currentItem = cursor.next();
			String osmmodelid = (String) currentItem.get("osmmodelid");
			
			MongoConnection mongoconinner = new MongoConnection();
			DBCursor resultcursor = mongoconinner.getDBObject("osmmodelid", osmmodelid, "OSMProjectInfo");
			if(resultcursor.hasNext()){
				
				DBObject theObjosm = resultcursor.next();
				
				OSMProjectInfo osmprojinf = new OSMProjectInfo();
				osmprojinf.setOsmmodelid((String)theObjosm.get("osmmodelid"));
				osmprojinf.setProjectbuyers((String[])theObjosm.get("projectbuyers"));
				osmprojinf.setProjectdemandchart((String)theObjosm.get("projectdemandchart"));
				osmprojinf.setProjectdescription((String)theObjosm.get("projectdescription"));
				osmprojinf.setProjectdocs((String[])theObjosm.get("projectdocs"));
				osmprojinf.setProjectinfoid((String)theObjosm.get("projectinfoid"));
				osmprojinf.setProjectinvestors((String[])theObjosm.get("projectinvestors"));
				osmprojinf.setProjectmarkettingdoc((String)theObjosm.get("projectmarkettingdoc"));
				osmprojinf.setProjectname((String)theObjosm.get("projectname"));
				osmprojinf.setProjectresources((String[])theObjosm.get("projectresources"));
				osmprojinf.setProjectstockprice((String)theObjosm.get("projectstockprice"));
				
				projectlist.add(osmprojinf);
				
			}
				
		}
		
		
		return 	projectlist;
	}

	public ArrayList getAllCompanyList() {
		// TODO Auto-generated method stub
		
		ArrayList companylist = new ArrayList();
		
		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("OSMOwner");
		DBCursor cursor;

		cursor = collection.find().sort(new BasicDBObject("osmmodelid", -1));
		while (cursor.hasNext()) {
			DBObject currentItem = cursor.next();
			
			Company comapny = new Company();
			comapny.setCompanyid((String)currentItem.get("companyid"));
			comapny.setAboutUs((String)currentItem.get("AboutUs"));
			comapny.setAboutvideoid((String)currentItem.get("aboutvideoid"));
			comapny.setCompanyImageid((String)currentItem.get("companyImageid"));
			comapny.setCompanyIndustry((String)currentItem.get("companyIndustry"));
			comapny.setCompanylogoid((String)currentItem.get("companylogoid"));
			comapny.setCompanyname((String)currentItem.get("companyname"));
			comapny.setCompanyWebsite((String)currentItem.get("companyWebsite"));
			
			
			companylist.add(comapny);
			
		}
		
		
		return companylist;
	}

	public String createNewProjectInfo(String projectdescription, String projectname, String ownerid, String companyid,
			String projectinvestors, String projectbuyers, String osmpartners, String osmbackupcompany, String osmdependependid, String location) {
		// TODO Auto-generated method stub
		String osmmodelid = "";
		OSMFileUtility osmfileutility = new OSMFileUtility();
		OSMPreview osmprev = new OSMPreview();
		
		osmprev.saveProjectInfo(projectdescription, projectname, ownerid, companyid,
			projectinvestors, projectbuyers);
		
		OSMModel osmmodel = new OSMModel();
		String uniqueid = "";
		try {
			uniqueid = osmfileutility.makeSHA1Hash(projectname);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		osmmodel.setOsmid(uniqueid);
		osmmodel.setOsmstakeholdingid(projectinvestors.split(","));
		osmmodel.setOsmbackupid(osmbackupcompany.split(","));
		osmmodel.setOsmdependentid(osmdependependid.split(","));
		osmmodel.setOsmpartnerid(osmpartners.split(","));
		osmmodel.setOsmhealthid("0");
		
		
		ServicesUtil servutil = new ServicesUtil();
		String locationaddress = servutil.getLocationAddress(location);
		System.out.println(" locationaddress ++"+locationaddress);
		osmmodel.setOsmlocation(locationaddress);
		
		
		
		
		
		MongoConnection mongocon = new MongoConnection();
		
		BasicDBObject basicreqobj =  osmfileutility.formOSMModelDBObject(osmmodel);
		mongocon.saveObject(basicreqobj, "OSM");
		
		
		OSMProjectInfo projectinfo = new OSMProjectInfo();
		projectinfo.setOsmmodelid(uniqueid);
		projectinfo.setProjectdescription(projectdescription);
		projectinfo.setProjectinfoid(uniqueid);
		projectinfo.setProjectinvestors(projectinvestors.split(","));
		projectinfo.setProjectbuyers(projectbuyers.split(","));
		projectinfo.setProjectname(projectname);
		
		MongoConnection mongoconproj = new MongoConnection();
		
		BasicDBObject basicreqobjproj =  osmfileutility.formOSMProjectDBObject(projectinfo);
		mongocon.saveObject(basicreqobj, "OSMProjectInfo");
		
		//lots of operation needed to do here
		
		
		SearchContent searchcontent = new SearchContent();
		searchcontent.setSearchid(uniqueid);
		searchcontent.setContentDescription("Project Name ::"+projectname+"Project Description ::"+projectdescription+"Project Investors ::"+projectinvestors.split(",")+"Project Buyers::"+projectbuyers.split(",")+"Location ::"+locationaddress);
		searchcontent.setContentLink("");
		searchcontent.setContentType("OSM");
		
		MongoConnection mongoconsearch = new MongoConnection();
		SearchPreview searchprev = new SearchPreview();
		BasicDBObject basicreqobjsearch =  searchprev.formDBObject(searchcontent);
		
		mongoconsearch.saveObject(basicreqobjsearch, "Content");
		//mongoOperation.save(postentry);
		
		
		return osmmodelid;
		
	}

	private void saveProjectInfo(String projectdescription, String projectname, String ownerid, String companyid,
			String projectinvestors, String projectbuyers) {
		// TODO Auto-generated method stub
		
		OSMPreview osmprev = new OSMPreview();
		OSMFileUtility osmfilutil = new OSMFileUtility();
		DateFunctionality datefunc = new DateFunctionality();
		
		String timer = datefunc.getDateSystems();
		String uniqueid="";
		try {
			uniqueid = osmfilutil.makeSHA1Hash(projectname);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void saveFile(Map<String, MultipartFile> fileMap, String userid, String projectinfo,String token) {
		// TODO Auto-generated method stub
		
		String fileids = "";
		String filenames = "";
		
		OSMPreview osmprev = new OSMPreview();
		// Maintain a list to send back the files info. to the client side
		List<FileUpload> uploadedFiles = new ArrayList<FileUpload>();

		for (MultipartFile multipartFile : fileMap.values()) {

			// Save the file to local disk
			try {
				osmprev.saveFileToLocalDisk(multipartFile);

				FileUpload fileInfo = osmprev.getUploadedFileInfo(multipartFile);
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
				
				String context = "OSMProjectDoc ::"+projectinfo+", OSMModelID"+token+" ,FileID ::"+fileid+" ,FileName ::"+filenames;
				
				osmprev.savetempfilehistory(userid, fileid, localdate,daypack,monthspack, hourpack,context,token);
				
				
				
				
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
		
		OSMPreview osmprev = new OSMPreview();
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
		BasicDBObject basicreqobjsearch =  osmprev.formDBObject(fileuntimeframe);
		
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

	public ArrayList getAllExistingOSMModels(String ownerid) {
		// TODO Auto-generated method stub
		
		ArrayList osmmodellist = new ArrayList();
		
		MongoConnection mongoconinner = new MongoConnection();
		DBCursor resultcursor = mongoconinner.getDBObject("ownerid", ownerid, "OSMOwner");
		if(resultcursor.hasNext()){
			
			DBObject theObjosm = resultcursor.next();
			
			String[] osmmodels = (String[])theObjosm.get("osmmodelid");
			
			for(int d= 0;d<osmmodels.length;d++){
			
				MongoConnection mongoconosms = new MongoConnection();
				DBCursor resultosms = mongoconosms.getDBObject("osmmodelid", osmmodels[d], "OSMProjectInfo");
				while(resultosms.hasNext()){
					DBObject osmprojObj = resultosms.next();
					
					OSMProjectInfo osmprojinfo = new OSMProjectInfo();
					
					osmprojinfo.setProjectname((String)osmprojObj.get("projectname"));
					osmprojinfo.setProjectdemandchart((String)osmprojObj.get("projectdemandchart"));
					
					
					osmmodellist.add(osmprojinfo);
				}
			}
			
			
			
		}
		
		return osmmodellist;
	}

	public void saveExistingOSMModelsDoc(String tokenid, String userid) {
		// TODO Auto-generated method stub
		
		MongoConnection mongoconosms = new MongoConnection();
		DBCursor resultosms = mongoconosms.getDBObject("tempid", tokenid, "FileUnionTimeFrame");
		while(resultosms.hasNext()){
			DBObject osmprojObj = resultosms.next();
			
			FileUnionTimeFrame fileunion = new FileUnionTimeFrame();
			
			if(((String)osmprojObj.get("userid")).equalsIgnoreCase(userid)){
				
				if(((String)osmprojObj.get("context")).contains("OSMProjectDoc")){
					
					String projectdoc = (String)osmprojObj.get("fileid");
					
					MongoConnection mongoconn = new MongoConnection();
					mongoconn.updateObject(new BasicDBObject("osmmodelid", tokenid), new BasicDBObject("$push", new BasicDBObject("projectdocs", projectdoc)), "OSMProjectInfo");
					
				}else if(((String)osmprojObj.get("context")).contains("OSMProjectMarkettingDoc")){
					
					String projectdoc = (String)osmprojObj.get("fileid");
					
					MongoConnection mongoconn = new MongoConnection();
					mongoconn.updateObject(new BasicDBObject("osmmodelid", tokenid), new BasicDBObject("$set", new BasicDBObject("projectmarkettingdoc", projectdoc)), "OSMProjectInfo");
					
				}
				
			}
			
		}
		
		
	}
		
	
	
	
}


