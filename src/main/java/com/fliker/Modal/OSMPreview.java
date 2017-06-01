package com.fliker.Modal;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Bill;
import com.fliker.Repository.Company;
import com.fliker.Repository.Contract;
import com.fliker.Repository.FileUnionTimeFrame;
import com.fliker.Repository.FileUpload;
import com.fliker.Repository.LicenseType;
import com.fliker.Repository.OSMDemand;
import com.fliker.Repository.OSMModel;
import com.fliker.Repository.OSMOperator;
import com.fliker.Repository.OSMProjectDevelopment;
import com.fliker.Repository.OSMProjectInfo;
import com.fliker.Repository.OSMProjectInvestment;
import com.fliker.Repository.OSMProjectSeller;
import com.fliker.Repository.OSMStakeHolding;
import com.fliker.Repository.PlanType;
import com.fliker.Repository.SearchContent;
import com.fliker.Repository.Stock;
import com.fliker.Utility.DateFunctionality;
import com.fliker.Utility.OSMFileUtility;
import com.fliker.Utility.ServicesUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

public class OSMPreview {

	public ArrayList getProjectInfoList() {

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
			if (resultcursor.hasNext()) {

				DBObject theObjosm = resultcursor.next();

				OSMProjectInfo osmprojinf = new OSMProjectInfo();
				osmprojinf.setOsmmodelid((String) theObjosm.get("osmmodelid"));
				osmprojinf.setProjectbuyers((String[]) theObjosm.get("projectbuyers"));
				osmprojinf.setProjectdemandchart((String) theObjosm.get("projectdemandchart"));
				osmprojinf.setProjectdescription((String) theObjosm.get("projectdescription"));
				osmprojinf.setProjectdocs((String[]) theObjosm.get("projectdocs"));
				osmprojinf.setProjectinfoid((String) theObjosm.get("projectinfoid"));
				osmprojinf.setProjectinvestors((String[]) theObjosm.get("projectinvestors"));
				osmprojinf.setProjectmarkettingdoc((String) theObjosm.get("projectmarkettingdoc"));
				osmprojinf.setProjectname((String) theObjosm.get("projectname"));
				osmprojinf.setProjectresources((String[]) theObjosm.get("projectresources"));
				osmprojinf.setProjectstockprice((String) theObjosm.get("projectstockprice"));
				osmprojinf.setProjectrequestors((String[]) theObjosm.get("projectrequestors"));
				projectlist.add(osmprojinf);

			}

		}

		return projectlist;
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
			comapny.setCompanyid((String) currentItem.get("companyid"));
			comapny.setAboutUs((String) currentItem.get("AboutUs"));
			comapny.setAboutvideoid((String) currentItem.get("aboutvideoid"));
			comapny.setCompanyImageid((String) currentItem.get("companyImageid"));
			comapny.setCompanyIndustry((String) currentItem.get("companyIndustry"));
			comapny.setCompanylogoid((String) currentItem.get("companylogoid"));
			comapny.setCompanyname((String) currentItem.get("companyname"));
			comapny.setCompanyWebsite((String) currentItem.get("companyWebsite"));

			companylist.add(comapny);

		}

		return companylist;
	}

	public String createNewProjectInfo(String projectdescription, String projectname, String ownerid, String companyid,
			String projectinvestors, String projectbuyers, String osmpartners, String osmbackupcompany,
			String osmdependependid, String location) {
		// TODO Auto-generated method stub
		String osmmodelid = "";
		OSMFileUtility osmfileutility = new OSMFileUtility();
		OSMPreview osmprev = new OSMPreview();

		osmprev.saveProjectInfo(projectdescription, projectname, ownerid, companyid, projectinvestors, projectbuyers);

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
		osmmodel.setOsmowner(ownerid);

		ServicesUtil servutil = new ServicesUtil();
		String locationaddress = servutil.getLocationAddress(location);
		System.out.println(" locationaddress ++" + locationaddress);
		osmmodel.setOsmlocation(locationaddress);

		MongoConnection mongocon = new MongoConnection();

		BasicDBObject basicreqobj = osmfileutility.formOSMModelDBObject(osmmodel);
		mongocon.saveObject(basicreqobj, "OSM");

		OSMProjectInfo projectinfo = new OSMProjectInfo();
		projectinfo.setOsmmodelid(uniqueid);
		projectinfo.setProjectdescription(projectdescription);
		projectinfo.setProjectinfoid(uniqueid);
		projectinfo.setProjectinvestors(projectinvestors.split(","));
		projectinfo.setProjectbuyers(projectbuyers.split(","));
		projectinfo.setProjectname(projectname);

		MongoConnection mongoconproj = new MongoConnection();

		BasicDBObject basicreqobjproj = osmfileutility.formOSMProjectDBObject(projectinfo);
		mongoconproj.saveObject(basicreqobjproj, "OSMProjectInfo");
		
		
		OSMDemand osmdemand = new OSMDemand();
		osmdemand.setOsmdemandid(uniqueid);
		
		String uniquedemandid = "";
		try {
			uniquedemandid = osmfileutility.makeSHA1Hash(projectname+uniqueid);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		osmdemand.setOsmdemandid(uniquedemandid);
		
		MongoConnection mongocondemand = new MongoConnection();

		BasicDBObject basicreqobjdemand = osmfileutility.formOSMDemandDBObject(osmdemand);
		mongocondemand.saveObject(basicreqobjdemand, "OSMDemand");
		
		
		// lots of operation needed to do here

		SearchContent searchcontent = new SearchContent();
		searchcontent.setSearchid(uniqueid);
		searchcontent.setContentDescription("Project Name ::" + projectname + "Project Description ::"
				+ projectdescription + "Project Investors ::" + projectinvestors.split(",") + "Project Buyers::"
				+ projectbuyers.split(",") + "Location ::" + locationaddress);
		searchcontent.setContentLink("");
		searchcontent.setContentType("OSM");

		MongoConnection mongoconsearch = new MongoConnection();
		SearchPreview searchprev = new SearchPreview();
		BasicDBObject basicreqobjsearch = searchprev.formDBObject(searchcontent);

		mongoconsearch.saveObject(basicreqobjsearch, "Content");
		// mongoOperation.save(postentry);

		return osmmodelid;

	}

	private void saveProjectInfo(String projectdescription, String projectname, String ownerid, String companyid,
			String projectinvestors, String projectbuyers) {
		// TODO Auto-generated method stub

		OSMPreview osmprev = new OSMPreview();
		OSMFileUtility osmfilutil = new OSMFileUtility();
		DateFunctionality datefunc = new DateFunctionality();

		String timer = datefunc.getDateSystems();
		String uniqueid = "";
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

	public void saveFile(Map<String, MultipartFile> fileMap, String userid, String projectinfo, String token) {
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
				// String dateInString = "Friday, Jun 7, 2013 12:10:56
				// PM";//example

				Date datepack = new Date();
				DateFunctionality datefunc = new DateFunctionality();

				String localdate = datefunc.getUniformDates(formatter.format(datepack));

				Calendar cal = Calendar.getInstance();
				cal.setTime(datepack);

				String yearpack = Integer.toString(cal.get(Calendar.YEAR));
				String monthspack = Integer.toString(cal.get(Calendar.MONTH));
				String daypack = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
				String hourpack = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
				String minutespack = Integer.toString(cal.get(Calendar.MINUTE));

				String context = "OSMProjectDoc ::" + projectinfo + ", OSMModelID" + token + " ,FileID ::" + fileid
						+ " ,FileName ::" + filenames;

				osmprev.savetempfilehistory(userid, fileid, localdate, daypack, monthspack, hourpack, context, token);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void savetempfilehistory(String userid, String fileid, String date, String day, String month, String hour,
			String context, String token) {

		OSMPreview osmprev = new OSMPreview();
		/*
		 * String uniqueid = "";
		 * 
		 * try { uniqueid = assignprev.makeSHA1Hash(fileid+userid); } catch
		 * (NoSuchAlgorithmException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (UnsupportedEncodingException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */

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
		BasicDBObject basicreqobjsearch = osmprev.formDBObject(fileuntimeframe);

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
		if (resultcursor.hasNext()) {

			DBObject theObjosm = resultcursor.next();

			String[] osmmodels = (String[]) theObjosm.get("osmmodelid");

			for (int d = 0; d < osmmodels.length; d++) {

				MongoConnection mongoconosms = new MongoConnection();
				DBCursor resultosms = mongoconosms.getDBObject("osmmodelid", osmmodels[d], "OSMProjectInfo");
				while (resultosms.hasNext()) {
					DBObject osmprojObj = resultosms.next();

					OSMProjectInfo osmprojinfo = new OSMProjectInfo();

					osmprojinfo.setProjectname((String) osmprojObj.get("projectname"));
					osmprojinfo.setProjectdemandchart((String) osmprojObj.get("projectdemandchart"));

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
		while (resultosms.hasNext()) {
			DBObject osmprojObj = resultosms.next();

			FileUnionTimeFrame fileunion = new FileUnionTimeFrame();

			if (((String) osmprojObj.get("userid")).equalsIgnoreCase(userid)) {

				if (((String) osmprojObj.get("context")).contains("OSMProjectDoc")) {

					String projectdoc = (String) osmprojObj.get("fileid");

					MongoConnection mongoconn = new MongoConnection();
					mongoconn.updateObject(new BasicDBObject("osmmodelid", tokenid),
							new BasicDBObject("$push", new BasicDBObject("projectdocs", projectdoc)), "OSMProjectInfo");

				} else if (((String) osmprojObj.get("context")).contains("OSMProjectMarkettingDoc")) {

					String projectdoc = (String) osmprojObj.get("fileid");

					MongoConnection mongoconn = new MongoConnection();
					mongoconn.updateObject(new BasicDBObject("osmmodelid", tokenid),
							new BasicDBObject("$set", new BasicDBObject("projectmarkettingdoc", projectdoc)),
							"OSMProjectInfo");

				}

			}

		}

	}

	public HashMap opensubscriptionAs(String userid, String subscriptiontype, String token) {
		// TODO Auto-generated method stub

		HashMap<String, ArrayList> holdinglist = new HashMap<String, ArrayList>();
		ArrayList subscribelist = new ArrayList();

		String subscribelink = "";

		if (subscriptiontype.equalsIgnoreCase("Investor")) {

			MongoConnection mongoconinner = new MongoConnection();
			DBCursor resultcursor = mongoconinner.getDBObject("osmmodelid", token, "OSMProjectInvestment");
			if (resultcursor.hasNext()) {
				DBObject osmprojObj = resultcursor.next();

				OSMProjectInvestment osmprojinvest = new OSMProjectInvestment();

				osmprojinvest.setOsminvestmentdoc((String[]) osmprojObj.get("osminvestmentdoc"));
				osmprojinvest.setOsminvestorslink((String) osmprojObj.get("osminvestorslink"));
				osmprojinvest.setOsmstakeholdingid((String) osmprojObj.get("osmstakeholdingid"));
				osmprojinvest.setOsmmodelid((String) osmprojObj.get("osmmodelid"));
				osmprojinvest.setOsminvestmentdescription((String) osmprojObj.get("osminvestmentdescription"));
				osmprojinvest.setOsminvestmenttermsandcondition((String) osmprojObj.get("osminvestmenttermsandcondition"));

				subscribelist.add(osmprojinvest);

			}
			holdinglist.put("/OSMProjectInvestor", subscribelist);

		} else if (subscriptiontype.equalsIgnoreCase("Buyer")) {

			MongoConnection mongoconinner = new MongoConnection();
			DBCursor resultcursor = mongoconinner.getDBObject("osmmodelid", token, "OSMProjectSeller");
			if (resultcursor.hasNext()) {
				DBObject osmprojObj = resultcursor.next();

				OSMProjectSeller osmprojsell = new OSMProjectSeller();

				osmprojsell.setProjectsellerid((String) osmprojObj.get("projectsellerid"));
				osmprojsell.setOsmmodelid((String) osmprojObj.get("osmmodelid"));
				osmprojsell.setSellerdescription((String) osmprojObj.get("sellerdescription"));
				osmprojsell.setSellingmarketdoc((String) osmprojObj.get("sellingmarketdoc"));

				subscribelist.add(osmprojsell);

			}
			holdinglist.put("/OSMProjectBuying", subscribelist);

		} else if (subscriptiontype.equalsIgnoreCase("Developer")) {

			MongoConnection mongoconinner = new MongoConnection();
			DBCursor resultcursor = mongoconinner.getDBObject("osmmodelid", token, "OSMProjectDevelopment");
			if (resultcursor.hasNext()) {
				DBObject osmprojObj = resultcursor.next();

				OSMProjectDevelopment osmprojdevelop = new OSMProjectDevelopment();

				osmprojdevelop.setOsmmodelid((String) osmprojObj.get("osmmodelid"));
				osmprojdevelop.setOsmprojectdevelopmentid((String) osmprojObj.get("osmprojectdevelopmentid"));
				osmprojdevelop.setOsmresourceid((String[]) osmprojObj.get("osmresourceid"));
				osmprojdevelop.setProjectflodocs((String[]) osmprojObj.get("projectflodocs"));
				osmprojdevelop.setProjectidlink((String) osmprojObj.get("projectidlink"));
				osmprojdevelop.setProjectlinkaccess((String) osmprojObj.get("projectlinkaccess"));
				osmprojdevelop.setProjectslidesid((String) osmprojObj.get("projectslidesid"));

				subscribelist.add(osmprojdevelop);

			}

			holdinglist.put("/OSMProjectResource", subscribelist);
		}
		
		return holdinglist;
	}

	public void saveOSMModelInvest(String token, String ownerid) {
		// TODO Auto-generated method stub

		MongoConnection mongoconosms = new MongoConnection();
		DBCursor resultosms = mongoconosms.getDBObject("osmmodelid", token, "OSMProjectInfo");
		if (resultosms.hasNext()) {
			DBObject osmprojObj = resultosms.next();

			MongoConnection mongoconn = new MongoConnection();
			mongoconn.updateObject(new BasicDBObject("osmmodelid", token),
					new BasicDBObject("$push", new BasicDBObject("projectinvestors", ownerid)), "OSMProjectInfo");
			mongoconn.updateObject(new BasicDBObject("osmmodelid", token),
					new BasicDBObject("$push", new BasicDBObject("osminvestors", ownerid)), "OSM");
			mongoconn.updateObject(new BasicDBObject("userid", ownerid),
					new BasicDBObject("$push", new BasicDBObject("oldinvestments", token)), "OSMOperator");
			mongoconn.updateObject(new BasicDBObject("userid", ownerid),
					new BasicDBObject("$push", new BasicDBObject("osmmodelid", token)), "OSMOperator");

			/*
			 * TradePreview tradeprev = new TradePreview();
			 * tradeprev.stockchangeonInvesting(token);
			 */

		}
		
		TradePreview tradeprev = new TradePreview();
		tradeprev.stockchangeonSubscription(token,ownerid);
	}

	public void saveOSMModelBuying(String token, String ownerid) {
		// TODO Auto-generated method stub

		MongoConnection mongoconosms = new MongoConnection();
		DBCursor resultosms = mongoconosms.getDBObject("osmmodelid", token, "OSMProjectInfo");
		if (resultosms.hasNext()) {
			DBObject osmprojObj = resultosms.next();

			MongoConnection mongoconn = new MongoConnection();
			mongoconn.updateObject(new BasicDBObject("osmmodelid", token),
					new BasicDBObject("$push", new BasicDBObject("projectbuyers", ownerid)), "OSMProjectInfo");
			mongoconn.updateObject(new BasicDBObject("osmmodelid", token),
					new BasicDBObject("$push", new BasicDBObject("osmbuyerids", ownerid)), "OSM");
			mongoconn.updateObject(new BasicDBObject("userid", ownerid),
					new BasicDBObject("$push", new BasicDBObject("oldbuyings", token)), "OSMOperator");
			mongoconn.updateObject(new BasicDBObject("userid", ownerid),
					new BasicDBObject("$push", new BasicDBObject("osmmodelid", token)), "OSMOperator");

			TradePreview tradeprev = new TradePreview();
			tradeprev.stockchangeonBuying(token);
		}
	}

	public ArrayList getRelatedOSMModels(String ownerid) {
		// TODO Auto-generated method stub
		ArrayList projectlist = new ArrayList();
		MongoConnection mongoconosms = new MongoConnection();
		DBCursor resultosms = mongoconosms.getDBObject("userid", ownerid, "OSMOperator");
		while (resultosms.hasNext()) {

			DBObject osmprojObj = resultosms.next();
			String[] osmmodelids = (String[]) osmprojObj.get("osmmodelid");

			for (int d = 0; d < osmmodelids.length; d++) {

				MongoConnection mongoconinner = new MongoConnection();
				DBCursor resultcursor = mongoconinner.getDBObject("osmmodelid", osmmodelids[d], "OSMProjectInfo");
				if (resultcursor.hasNext()) {

					DBObject theObjosm = resultcursor.next();

					OSMProjectInfo osmprojinf = new OSMProjectInfo();
					osmprojinf.setOsmmodelid((String) theObjosm.get("osmmodelid"));
					osmprojinf.setProjectbuyers((String[]) theObjosm.get("projectbuyers"));
					osmprojinf.setProjectdemandchart((String) theObjosm.get("projectdemandchart"));
					osmprojinf.setProjectdescription((String) theObjosm.get("projectdescription"));
					osmprojinf.setProjectdocs((String[]) theObjosm.get("projectdocs"));
					osmprojinf.setProjectinfoid((String) theObjosm.get("projectinfoid"));
					osmprojinf.setProjectinvestors((String[]) theObjosm.get("projectinvestors"));
					osmprojinf.setProjectmarkettingdoc((String) theObjosm.get("projectmarkettingdoc"));
					osmprojinf.setProjectname((String) theObjosm.get("projectname"));
					osmprojinf.setProjectresources((String[]) theObjosm.get("projectresources"));
					osmprojinf.setProjectstockprice((String) theObjosm.get("projectstockprice"));
					osmprojinf.setProjectrequestors((String[]) theObjosm.get("projectrequestors"));

					projectlist.add(osmprojinf);

				}

			}

		}

		return null;
	}

	public void saveOSMModelDevloping(String token, String ownerid) {
		// TODO Auto-generated method stub

		MongoConnection mongoconosms = new MongoConnection();
		DBCursor resultosms = mongoconosms.getDBObject("osmmodelid", token, "OSMProjectInfo");
		if (resultosms.hasNext()) {
			DBObject osmprojObj = resultosms.next();

			MongoConnection mongoconn = new MongoConnection();
			mongoconn.updateObject(new BasicDBObject("osmmodelid", token),
					new BasicDBObject("$push", new BasicDBObject("projectrequestors", ownerid)), "OSMProjectInfo");

			mongoconn.updateObject(new BasicDBObject("userid", ownerid),
					new BasicDBObject("$push", new BasicDBObject("olddevelopments", token)), "OSMOperator");
			mongoconn.updateObject(new BasicDBObject("userid", ownerid),
					new BasicDBObject("$push", new BasicDBObject("osmmodelid", token)), "OSMOperator");
		}
		
		TradePreview tradeprev = new TradePreview();
		tradeprev.stockchangeonSubscription(token, ownerid);

	}

	public void saveOSMModelDevloplist(String osmmodelid, String developerid) {
		// TODO Auto-generated method stub

		MongoConnection mongoconosms = new MongoConnection();
		DBCursor resultosms = mongoconosms.getDBObject("osmmodelid", osmmodelid, "OSMProjectInfo");
		if (resultosms.hasNext()) {
			DBObject osmprojObj = resultosms.next();

			MongoConnection mongoconn = new MongoConnection();
			mongoconn.updateObject(new BasicDBObject("osmmodelid", osmmodelid),
					new BasicDBObject("$push", new BasicDBObject("projectresources", developerid)), "OSMProjectInfo");

			/*
			 * mongoconn.updateObject(new BasicDBObject("userid", developerid),
			 * new BasicDBObject("$push", new BasicDBObject("olddevelopments",
			 * osmmodelid)), "OSMOperator"); mongoconn.updateObject(new
			 * BasicDBObject("userid", developerid), new BasicDBObject("$push",
			 * new BasicDBObject("osmmodelid", osmmodelid)), "OSMOperator");
			 */
		}

	}

	public void createOSMModelInvestSet(String osmmodelid, String stakeamount, String stakedivision, String ownerid,
			String projectinvestlink) {
		// TODO Auto-generated method stub

		OSMProjectInvestment osmprojinvest = new OSMProjectInvestment();
		osmprojinvest.setOsmmodelid(osmmodelid);
		osmprojinvest.setOsmstakedivision(stakedivision);
		osmprojinvest.setOsminvestorslink(projectinvestlink);
		OSMFileUtility osmfileutility = new OSMFileUtility();

		String uniqueid = "";
		try {
			uniqueid = osmfileutility.makeSHA1Hash(osmmodelid);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		osmprojinvest.setOsmstakeholdingid(uniqueid);
		StringBuffer projectinvestdoc = new StringBuffer();

		MongoConnection mongoconosms = new MongoConnection();
		DBCursor resultosms = mongoconosms.getDBObject("tempid", osmmodelid, "FileUnionTimeFrame");
		while (resultosms.hasNext()) {
			DBObject osmprojObj = resultosms.next();

			FileUnionTimeFrame fileunion = new FileUnionTimeFrame();

			if (((String) osmprojObj.get("userid")).equalsIgnoreCase(ownerid)) {

				if (((String) osmprojObj.get("context")).contains("OSMProjectInvestDoc")) {

					String projectdoc = (String) osmprojObj.get("fileid");
					projectinvestdoc.append(projectdoc);
					projectinvestdoc.append(",");
				}

			}
		}

		String[] projectinvestdocarr = (projectinvestdoc.substring(0, projectinvestdoc.length() - 1)).split(",");
		osmprojinvest.setOsminvestmentdoc(projectinvestdocarr);

		MongoConnection mongoconproj = new MongoConnection();

		BasicDBObject basicreqobjproj = osmfileutility.formOSMProjectInvestDBObject(osmprojinvest);
		mongoconproj.saveObject(basicreqobjproj, "OSMProjectInvestment");

		// lots of operation needed to do here

		/*
		 * 
		 * 
		 * SearchContent searchcontent = new SearchContent();
		 * searchcontent.setSearchid(uniqueid);
		 * searchcontent.setContentDescription("Project Name ::"+projectname+
		 * "Project Description ::"+projectdescription+"Project Investors ::"
		 * +projectinvestors.split(",")+"Project Buyers::"
		 * +projectbuyers.split(",")+"Location ::"+locationaddress);
		 * searchcontent.setContentLink("");
		 * searchcontent.setContentType("OSM");
		 * 
		 * MongoConnection mongoconsearch = new MongoConnection(); SearchPreview
		 * searchprev = new SearchPreview(); BasicDBObject basicreqobjsearch =
		 * searchprev.formDBObject(searchcontent);
		 * 
		 * mongoconsearch.saveObject(basicreqobjsearch, "Content");
		 */

	}

	public void saveOSMModelInvestDocSave(String token, String stakeamount, String stakedivision, String ownerid,
			String projectinvestlink) {
		// TODO Auto-generated method stub

		StringBuffer projectdocbuff = new StringBuffer();
		String[] filearr = null;

		MongoConnection mongoconcheck = new MongoConnection();
		DBCursor resultcheck = mongoconcheck.getDBObject("osmmodelid", token, "OSMProjectInvestment");
		if (resultcheck.hasNext()) {
			DBObject osmprojObj = resultcheck.next();

			filearr = (String[]) osmprojObj.get("osminvestmentdoc");

		}

		MongoConnection mongoconosms = new MongoConnection();
		DBCursor resultosms = mongoconosms.getDBObject("tempid", token, "FileUnionTimeFrame");
		while (resultosms.hasNext()) {
			DBObject osmprojObj = resultosms.next();

			FileUnionTimeFrame fileunion = new FileUnionTimeFrame();

			if (((String) osmprojObj.get("userid")).equalsIgnoreCase(ownerid)) {

				if (((String) osmprojObj.get("context")).contains("OSMProjectInvestDoc")) {

					String projectdoc = (String) osmprojObj.get("fileid");

					if (filearr != null) {

						for (int s = 0; s < filearr.length; s++) {

							if (!filearr[s].equalsIgnoreCase(projectdoc)) {
								projectdocbuff.append(projectdoc);
								projectdocbuff.append(",");
							}

						}

					} else {
						projectdocbuff.append(projectdoc);
						projectdocbuff.append(",");
					}

				}

			}

		}

		String[] projectdocarr = (projectdocbuff.substring(0, projectdocbuff.length() - 1)).split(",");

		MongoConnection mongoconn = new MongoConnection();
		mongoconn.updateObject(new BasicDBObject("osmmodelid", token),
				new BasicDBObject("$push", new BasicDBObject("osminvestmentdoc", projectdocarr)),
				"OSMProjectInvestment");
		mongoconn.updateObject(new BasicDBObject("osmmodelid", token),
				new BasicDBObject("$set", new BasicDBObject("osmstakedivision", stakedivision)),
				"OSMProjectInvestment");
		mongoconn.updateObject(new BasicDBObject("osmmodelid", token),
				new BasicDBObject("$set", new BasicDBObject("osminvestorslink", projectinvestlink)),
				"OSMProjectInvestment");

	}

	/*
	 * public void saveOSMProjectInvestUpdate(String projectinvestlink, String
	 * token) { // TODO Auto-generated method stub
	 * 
	 * MongoConnection mongoconn = new MongoConnection();
	 * mongoconn.updateObject(new BasicDBObject("osmmodelid", token), new
	 * BasicDBObject("$set", new BasicDBObject("osminvestorslink",
	 * projectinvestlink)), "OSMProjectInvestment"); }
	 */

	public void createOSMModelSellerSet(String osmmodelid, String sellerdescription) {
		// TODO Auto-generated method stub

		OSMProjectSeller projseller = new OSMProjectSeller();
		projseller.setOsmmodelid(osmmodelid);
		projseller.setSellerdescription(sellerdescription);

		OSMFileUtility osmfileutility = new OSMFileUtility();

		String uniqueid = "";
		try {
			uniqueid = osmfileutility.makeSHA1Hash(osmmodelid);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		projseller.setProjectsellerid(uniqueid);

		MongoConnection mongoconproj = new MongoConnection();

		BasicDBObject basicreqobjproj = osmfileutility.formOSMProjectSellerDBObject(projseller);
		mongoconproj.saveObject(basicreqobjproj, "OSMProjectSeller");

	}

	public void saveOSMModelSellerDocSave(String token, String ownerid) {
		// TODO Auto-generated method stub

		MongoConnection mongoconosms = new MongoConnection();
		DBCursor resultosms = mongoconosms.getDBObject("tempid", token, "FileUnionTimeFrame");
		while (resultosms.hasNext()) {
			DBObject osmprojObj = resultosms.next();

			FileUnionTimeFrame fileunion = new FileUnionTimeFrame();

			if (((String) osmprojObj.get("userid")).equalsIgnoreCase(ownerid)) {

				if (((String) osmprojObj.get("context")).contains("OSMProjectSellerDoc")) {

					String projectdoc = (String) osmprojObj.get("fileid");

					MongoConnection mongoconn = new MongoConnection();
					mongoconn.updateObject(new BasicDBObject("osmmodelid", token),
							new BasicDBObject("$set", new BasicDBObject("sellingmarketdoc", projectdoc)),
							"OSMProjectSeller");

				}

			}

		}

	}

	public String checkInvestSet(String osmmodelid) {
		// TODO Auto-generated method stub
		String osmmodelinvest = "false";

		MongoConnection mongoconosms = new MongoConnection();
		DBCursor resultosms = mongoconosms.getDBObject("osmmodelid", osmmodelid, "OSMProjectInvestment");
		if (resultosms.hasNext()) {

			osmmodelinvest = "true";
		}

		return osmmodelinvest;
	}

	public OSMProjectInvestment getInvestDataDetails(String osmmodelid) {
		// TODO Auto-generated method stub

		OSMProjectInvestment osminvestment = new OSMProjectInvestment();

		MongoConnection mongoconosms = new MongoConnection();
		DBCursor resultosms = mongoconosms.getDBObject("osmmodelid", osmmodelid, "OSMProjectInvestment");
		if (resultosms.hasNext()) {
			DBObject osmprojObj = resultosms.next();

			osminvestment.setOsminvestmentdoc((String[]) osmprojObj.get("osminvestmentdoc"));
			osminvestment.setOsminvestorslink((String) osmprojObj.get("osminvestorslink"));
			osminvestment.setOsmstakedivision((String) osmprojObj.get("osmstakedivision"));
			osminvestment.setOsmstakeholdingid((String) osmprojObj.get("osmstakeholdingid"));
		}

		return osminvestment;
	}

	public ArrayList getProjectInvestors(String osmmodelid) {
		// TODO Auto-generated method stub

		ArrayList investorlist = new ArrayList();

		MongoConnection mongoconosms = new MongoConnection();
		DBCursor resultosms = mongoconosms.getDBObject("osmid", osmmodelid, "OSM");
		while (resultosms.hasNext()) {
			DBObject osmprojObj = resultosms.next();

			String[] stakeholdersid = (String[]) osmprojObj.get("osmstakeholdingid");

			for (int m = 0; m < stakeholdersid.length; m++) {

				HashMap stakeholderinfo = new HashMap();

				MongoConnection mongoconstake = new MongoConnection();
				DBCursor resultstake = mongoconstake.getDBObject("stakeholdingid", stakeholdersid[m], "OSMStakeHold");
				while (resultstake.hasNext()) {
					DBObject osmstake = resultstake.next();

					stakeholderinfo.put("stakeamount", osmstake.get("stakeamount"));
					stakeholderinfo.put("stakeholderlocation", osmstake.get("stakeholderlocation"));
					stakeholderinfo.put("stakepercentage", osmstake.get("stakepercentage"));

					String stakeowner = (String) osmstake.get("stakeownerid");

					MongoConnection mongoconstakeowner = new MongoConnection();
					DBCursor resultstakeowner = mongoconstakeowner.getDBObject("userid", stakeowner, "OSMOperator");
					if (resultstakeowner.hasNext()) {
						DBObject osmstakeowner = resultstakeowner.next();

						String activecompany = (String) osmstakeowner.get("activeCompany");

						MongoConnection mongoconstakeownercompany = new MongoConnection();
						DBCursor resultstakeownercompany = mongoconstakeownercompany.getDBObject("companyid",
								activecompany, "Company");
						if (resultstakeownercompany.hasNext()) {
							DBObject osmstakeownercompany = resultstakeownercompany.next();

							stakeholderinfo.put("Company Name", osmstakeownercompany.get("companyname"));
							stakeholderinfo.put("Company Image", osmstakeownercompany.get("companyImageid"));
							stakeholderinfo.put("Company Logo", osmstakeownercompany.get("companylogoid"));
							stakeholderinfo.put("Company Website", osmstakeownercompany.get("companyWebsite"));

						}

					}

				}
				investorlist.add(stakeholderinfo);
			}
		}

		return investorlist;
	}

	public void saveInvestMent(String ownerid, String osmmodelid, String investamount, String investpercentage,
			String stockprice, String initialstockprice, String enabletrading) {
		// TODO Auto-generated method stub
		OSMPreview osmprev = new OSMPreview();
		MongoConnection mongoconn = new MongoConnection();

		String checkoperator = osmprev.checkOperator(ownerid);

		if (checkoperator.equalsIgnoreCase("true")) {

			mongoconn.updateObject(new BasicDBObject("userid", ownerid),
					new BasicDBObject("$push", new BasicDBObject("oldinvestments", osmmodelid)), "OSMOperator");
		}

		osmprev.saveStakeHoldings(ownerid, investamount, investpercentage, stockprice, enabletrading);

		mongoconn.updateObject(new BasicDBObject("osmid", osmmodelid),
				new BasicDBObject("$push", new BasicDBObject("osmstakeholdingid", ownerid)), "OSM");
		/*mongoconn.updateObject(new BasicDBObject("osmid", osmmodelid),
				new BasicDBObject("$push", new BasicDBObject("osmstakeholdingid", ownerid)), "OSM");*/

	}

	private String saveStakeHoldings(String ownerid, String investamount, String investpercentage, String stockprice,
			String enabletrading) {
		// TODO Auto-generated method stub

		OSMStakeHolding stakeholding = new OSMStakeHolding();
		stakeholding.setStakeamount(investamount);
		stakeholding.setStakeownerid(ownerid);
		stakeholding.setStakepercentage(investpercentage);
		stakeholding.setStarstokprice(stockprice);

		OSMFileUtility osmfileutility = new OSMFileUtility();

		String uniquestockid = "";

		if (enabletrading.equalsIgnoreCase("true")) {

			Stock stock = new Stock();
			stock.setStockamount(investamount);
			stock.setStockprice(stockprice);
			String comapnyid = "";

			MongoConnection mongoconstakeowner = new MongoConnection();
			DBCursor resultstakeowner = mongoconstakeowner.getDBObject("userid", ownerid, "OSMOperator");
			if (resultstakeowner.hasNext()) {
				DBObject osmstakeowner = resultstakeowner.next();

				comapnyid = (String) osmstakeowner.get("activeCompany");

			}

			stock.setCompanyid(comapnyid);

			try {
				uniquestockid = osmfileutility.makeSHA1Hash(ownerid + stockprice);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			stock.setStockid(uniquestockid);

			MongoConnection mongoconsearch = new MongoConnection();
			// SearchPreview searchprev = new SearchPreview();
			BasicDBObject basicreqobjsearch = osmfileutility.formOSMStockDBObject(stock);

			mongoconsearch.saveObject(basicreqobjsearch, "Stock");

		}
		stakeholding.setStakestokpriceid(uniquestockid);

		String uniqueid = "";
		try {
			uniqueid = osmfileutility.makeSHA1Hash(ownerid + investpercentage);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		stakeholding.setStakeholdingid(uniqueid);

		MongoConnection mongoconsearch = new MongoConnection();
		// SearchPreview searchprev = new SearchPreview();
		BasicDBObject basicreqobjsearch = osmfileutility.formOSMStakeHoldingDBObject(stakeholding);

		mongoconsearch.saveObject(basicreqobjsearch, "OSMStakeHold");

		return uniqueid;
	}

	public String checkOperator(String ownerid) {

		String ownerpresent = "false";
		OSMPreview osmprev = new OSMPreview();

		MongoConnection mongoconstakeowner = new MongoConnection();
		DBCursor resultstakeowner = mongoconstakeowner.getDBObject("userid", ownerid, "OSMOperator");
		if (resultstakeowner.hasNext()) {

			ownerpresent = "true";
		} else {

			OSMFileUtility osmfileutility = new OSMFileUtility();

			String uniqueid = "";
			try {
				uniqueid = osmfileutility.makeSHA1Hash(ownerid);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			OSMOperator osmoperator = new OSMOperator();
			osmoperator.setOperatorid(uniqueid);
			osmoperator.setUserid(ownerid);

			MongoConnection mongoconsearch = new MongoConnection();
			// SearchPreview searchprev = new SearchPreview();
			BasicDBObject basicreqobjsearch = osmfileutility.formOSMOperatorDBObject(osmoperator);

			mongoconsearch.saveObject(basicreqobjsearch, "OSMOperator");

			ownerpresent = "true";

		}

		return ownerpresent;
	}

	public String checkAllProjectData(String osmmodelid) {
		// TODO Auto-generated method stub

		String investersettings = "false";
		String buyingsettings = "false";
		String developersettings = "false";

		MongoConnection mongoconinvest = new MongoConnection();
		DBCursor resultinvest = mongoconinvest.getDBObject("osmmodelid", osmmodelid, "OSMProjectInvestment");
		if (resultinvest.hasNext()) {
			investersettings = "true";
		}

		MongoConnection mongoconbuying = new MongoConnection();
		DBCursor resultbuying = mongoconbuying.getDBObject("osmmodelid", osmmodelid, "OSMProjectInvestment");
		if (resultbuying.hasNext()) {
			buyingsettings = "true";
		}

		MongoConnection mongocondevelop = new MongoConnection();
		DBCursor resultdevelop = mongocondevelop.getDBObject("osmmodelid", osmmodelid, "OSMProjectInvestment");
		if (resultdevelop.hasNext()) {
			developersettings = "true";
		}

		if (investersettings.equalsIgnoreCase("true") && buyingsettings.equalsIgnoreCase("true")
				&& developersettings.equalsIgnoreCase("true")) {

			return "true";
		} else
			return "false";

	}

	public void saveDemandChart(String ownerid, String osmmodelid) {
		// TODO Auto-generated method stub

		// OSMDemand osmdemand = new OSMDemand();

		MongoConnection mongoconn = new MongoConnection();

		mongoconn.updateObject(new BasicDBObject("osmid", osmmodelid),
				new BasicDBObject("$push", new BasicDBObject("osmsubscriptionid", ownerid)), "OSMDemand");

		MongoConnection mongocondemand = new MongoConnection();
		DBCursor resultdemand = mongocondemand.getDBObject("osmmodelid", osmmodelid, "OSMDemand");
		if (resultdemand.hasNext()) {

			DBObject osmdemand = resultdemand.next();
			String currentdemandstockprice = (String) osmdemand.get("osmstockpricevariation");
			int currentstock = Integer.parseInt(currentdemandstockprice);

		}

		mongoconn.updateObject(new BasicDBObject("osmid", osmmodelid),
				new BasicDBObject("$push", new BasicDBObject("osmstakeholdingid", ownerid)), "OSMStakeHold");

	}

	public void saveLikeInfo(String ownerid, String osmmodelid) {
		// TODO Auto-generated method stub
		
		MongoConnection mongoconn = new MongoConnection();
		mongoconn.updateObject(new BasicDBObject("osmid", osmmodelid),
				new BasicDBObject("$push", new BasicDBObject("osmlikeid", ownerid)), "OSMDemand");
		
		TradePreview tradepreview = new TradePreview();
		tradepreview.stockchangeonLike(osmmodelid, ownerid);
		
	}

	public void saveShareInfo(String ownerid, String osmmodelid) {
		// TODO Auto-generated method stub
		
		MongoConnection mongoconn = new MongoConnection();
		mongoconn.updateObject(new BasicDBObject("osmid", osmmodelid),
				new BasicDBObject("$push", new BasicDBObject("osmshareid", ownerid)), "OSMDemand");
		
		TradePreview tradepreview = new TradePreview();
		tradepreview.stockchangeonShare(osmmodelid, ownerid);
		
		
	}
	
	public ArrayList getOSMOperatorID(String osmmodelid){
		
		String osmowner = "";
		String company = "";
		ArrayList companyinfo = new ArrayList(); 
		
		
		MongoConnection mongocondemand = new MongoConnection();
		DBCursor resultdemand = mongocondemand.getDBObject("osmid", osmmodelid, "OSM");
		if (resultdemand.hasNext()) {
			DBObject osmdemand = resultdemand.next();
			osmowner =  (String)osmdemand.get("osmowner");
			
			MongoConnection mongoconcompany = new MongoConnection();
			DBCursor resultcompany = mongoconcompany.getDBObject("userid", osmowner, "OSMOperator");
			if (resultcompany.hasNext()) {
				DBObject osmcompany = resultcompany.next();
				company = (String)osmcompany.get("activeCompany");
				
				MongoConnection mongoconcompan = new MongoConnection();
				DBCursor resultcompan = mongoconcompan.getDBObject("userid", osmowner, "OSMOperator");
				if (resultcompan.hasNext()) {
					DBObject osmcompan = resultcompan.next();
					
					Company compinfo = new Company();
					compinfo.setCompanyid((String)osmcompan.get("companyid"));
					compinfo.setCompanyImageid((String)osmcompan.get("companyImageid"));
					compinfo.setCompanylogoid((String)osmcompan.get("companylogoid"));
					
					companyinfo.add(compinfo);
				}
			}
			
		}
		
		return companyinfo;
	}
	
	
	public String getOSMOperatorCompanyLogo(String osmmodelid){
		
		String osmowner = "";
		String company = "";
		String companyname = "";
		
		
		MongoConnection mongocondemand = new MongoConnection();
		DBCursor resultdemand = mongocondemand.getDBObject("osmid", osmmodelid, "OSM");
		if (resultdemand.hasNext()) {
			DBObject osmdemand = resultdemand.next();
			osmowner =  (String)osmdemand.get("osmowner");
			
			MongoConnection mongoconcompany = new MongoConnection();
			DBCursor resultcompany = mongoconcompany.getDBObject("userid", osmowner, "OSMOperator");
			if (resultcompany.hasNext()) {
				DBObject osmcompany = resultcompany.next();
				company = (String)osmcompany.get("activeCompany");
				
				MongoConnection mongoconcompan = new MongoConnection();
				DBCursor resultcompan = mongoconcompan.getDBObject("userid", osmowner, "OSMOperator");
				if (resultcompan.hasNext()) {
					DBObject osmcompan = resultcompan.next();
					
					/*Company compinfo = new Company();
					compinfo.setCompanyid((String)osmcompan.get("companyid"));
					compinfo.setCompanyImageid((String)osmcompan.get("companyImageid"));
					compinfo.setCompanylogoid((String)osmcompan.get("companylogoid"));*/
					
					companyname = (String)osmcompan.get("companylogoid");
				}
			}
			
		}
		
		return companyname;
	}

	public byte[] imagefromid(String imageId) {

		CoursePreview courseprev = new CoursePreview();
		GridFSDBFile imagecontent = courseprev.getFiles(imageId);
		System.out.println("imagecontent ++" + imagecontent.getInputStream());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			imagecontent.writeTo(baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] imageblob = baos.toByteArray();

		return imageblob;
	}

	public String getOSMOperatorCompanyID(String osmmodelid) {
		// TODO Auto-generated method stub
		String osmowner = "";
		String company = "";
		String companyid = "";
		
		
		MongoConnection mongocondemand = new MongoConnection();
		DBCursor resultdemand = mongocondemand.getDBObject("osmid", osmmodelid, "OSM");
		if (resultdemand.hasNext()) {
			DBObject osmdemand = resultdemand.next();
			osmowner =  (String)osmdemand.get("osmowner");
			
			MongoConnection mongoconcompany = new MongoConnection();
			DBCursor resultcompany = mongoconcompany.getDBObject("userid", osmowner, "OSMOperator");
			if (resultcompany.hasNext()) {
				DBObject osmcompany = resultcompany.next();
				company = (String)osmcompany.get("activeCompany");
				
				MongoConnection mongoconcompan = new MongoConnection();
				DBCursor resultcompan = mongoconcompan.getDBObject("userid", osmowner, "OSMOperator");
				if (resultcompan.hasNext()) {
					DBObject osmcompan = resultcompan.next();
					
					/*Company compinfo = new Company();
					compinfo.setCompanyid((String)osmcompan.get("companyid"));
					compinfo.setCompanyImageid((String)osmcompan.get("companyImageid"));
					compinfo.setCompanylogoid((String)osmcompan.get("companylogoid"));*/
					
					companyid = (String)osmcompan.get("companyid");
				}
			}
			
		}
		
		return companyid;
	}

	public HashMap generatePaymentOptions(String projectsellerid) {
		// TODO Auto-generated method stub
		
		HashMap totalmap = new HashMap();
		ArrayList plantypelist = new ArrayList();
		ArrayList contractlist = new ArrayList();
		ArrayList licenselist = new ArrayList();
		
		MongoConnection mongocondemand = new MongoConnection();
		DBCursor resultdemand = mongocondemand.getDBObject("projectsellerid", projectsellerid, "OSMProjectSeller");
		if (resultdemand.hasNext()) {
			DBObject osmdemand = resultdemand.next();
			String[] sellingploanid  =  (String[])osmdemand.get("sellingplanid");
			String[] sellingcontractid = (String[])osmdemand.get("sellingcontractid");
			String[] sellinglicenseid = (String[])osmdemand.get("sellinglicenseid");
			
			if(sellingploanid.length >0){
				
				for(int m=0;m<sellingploanid.length;m++){
					
					MongoConnection mongoconcompan = new MongoConnection();
					DBCursor resultcompan = mongoconcompan.getDBObject("planid", sellingploanid[m], "Plan");
					if (resultcompan.hasNext()) {
						DBObject osmcompan = resultcompan.next();
						
						PlanType plantype = new PlanType();
						plantype.setPlanid((String)osmcompan.get("planid"));
						plantype.setPlanname((String)osmcompan.get("planname"));
						plantype.setPlanperday((String)osmcompan.get("planperday"));
						plantype.setPlanamount((String)osmcompan.get("planamount"));
						plantype.setPlanduration((String)osmcompan.get("planduration"));
						plantype.setPlanpermonth((String)osmcompan.get("planpermonth"));
						plantype.setPlanperyear((String)osmcompan.get("planperyear"));
						
						plantypelist.add(plantype);
					}
					
				}
				
				
			}
			
			if(sellingcontractid.length > 0){
				
				for(int n=0;n<sellingcontractid.length;n++){
					
					MongoConnection mongoconcompan = new MongoConnection();
					DBCursor resultcompan = mongoconcompan.getDBObject("planid", sellingcontractid[n], "Plan");
					if (resultcompan.hasNext()) {
						DBObject osmcompan = resultcompan.next();
						
						Contract contract = new Contract();
						
						contract.setContractid((String)osmcompan.get("contractid"));
						contract.setContractdocid((String)osmcompan.get("contractdocid"));
						contract.setContractlegalnotice((String)osmcompan.get("contractlegalnotice"));
						
						contractlist.add(contract);
						
					}
					
					
					
				}
				
				
			}
			
			if(sellinglicenseid.length > 0){
				
				for(int o=0;o<sellinglicenseid.length;o++){
					MongoConnection mongoconcompan = new MongoConnection();
					DBCursor resultcompan = mongoconcompan.getDBObject("licenseid", sellinglicenseid[o], "License");
					if (resultcompan.hasNext()) {
						DBObject osmcompan = resultcompan.next();
						
						LicenseType license = new LicenseType();
						license.setLicenseid((String)osmcompan.get("licenseid"));
						license.setLicenseduration((String)osmcompan.get("licenseduration"));
						license.setLicensetype((String)osmcompan.get("licensetype"));
						
						licenselist.add(license);
						
					}
					
					
				}
				
				
			}
			
		}
		
		
		totalmap.put("plan", plantypelist);
		totalmap.put("contract", contractlist);
		totalmap.put("license", licenselist);
		
		return totalmap;
		
	}

	public Bill generateBill(String planid, String contractid, String licenseid, String selectedtype, String buyerid, String paytoid, String payamount) {
		// TODO Auto-generated method stub
		
		Bill bill = new Bill();
		
		if(selectedtype.equalsIgnoreCase("plan")){
			
			
			OSMFileUtility osmfileutility = new OSMFileUtility();

			String uniqueid = "";
			try {
				uniqueid = osmfileutility.makeSHA1Hash(planid);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			bill.setBillid(uniqueid);
			bill.setContractid("");
			bill.setInvoiceid(uniqueid);
			bill.setLicenseid("");
			bill.setPayfromid(buyerid);
			bill.setPaymentmethods("");
			bill.setPaytoid(paytoid);
			bill.setPlanid(planid);
			bill.setItem("Service");
			bill.setTotalamount(payamount);
				
			MongoConnection mongoconsearch = new MongoConnection();
			// SearchPreview searchprev = new SearchPreview();
			BasicDBObject basicreqobjsearch = osmfileutility.formOSMOperatorBillDBObject(bill);

			mongoconsearch.saveObject(basicreqobjsearch, "Bill");
			
		}else if(selectedtype.equalsIgnoreCase("contract")){
			
			OSMFileUtility osmfileutility = new OSMFileUtility();

			String uniqueid = "";
			try {
				uniqueid = osmfileutility.makeSHA1Hash(planid);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			bill.setBillid(uniqueid);
			bill.setContractid(contractid);
			bill.setInvoiceid(uniqueid);
			bill.setLicenseid("");
			bill.setPayfromid(buyerid);
			bill.setPaymentmethods("");
			bill.setPaytoid(paytoid);
			bill.setPlanid("");
			bill.setItem("Service");
			bill.setTotalamount(payamount);
				
			MongoConnection mongoconsearch = new MongoConnection();
			// SearchPreview searchprev = new SearchPreview();
			BasicDBObject basicreqobjsearch = osmfileutility.formOSMOperatorBillDBObject(bill);

			mongoconsearch.saveObject(basicreqobjsearch, "Bill");
			
			
		}else if(selectedtype.equalsIgnoreCase("license")){
			
			OSMFileUtility osmfileutility = new OSMFileUtility();

			String uniqueid = "";
			try {
				uniqueid = osmfileutility.makeSHA1Hash(planid);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			bill.setBillid(uniqueid);
			bill.setContractid("");
			bill.setInvoiceid(uniqueid);
			bill.setLicenseid(licenseid);
			bill.setPayfromid(buyerid);
			bill.setPaymentmethods("");
			bill.setPaytoid(paytoid);
			bill.setPlanid("");
			bill.setItem("Product");
			bill.setTotalamount(payamount);
				
			MongoConnection mongoconsearch = new MongoConnection();
			// SearchPreview searchprev = new SearchPreview();
			BasicDBObject basicreqobjsearch = osmfileutility.formOSMOperatorBillDBObject(bill);

			mongoconsearch.saveObject(basicreqobjsearch, "Bill");
			
		}
		
		return bill;
	}

	public Bill generateInvestBill(String osmmodelid, String investamount, String investpercentage, String stockprice,
			String stockamount, String ownerid) {
		// TODO Auto-generated method stub
		
		Bill bill = new Bill();
		
		OSMFileUtility osmfileutility = new OSMFileUtility();

		String uniqueid = "";
		try {
			uniqueid = osmfileutility.makeSHA1Hash(osmmodelid+stockamount);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bill.setBillid(uniqueid);
		bill.setContractid("");
		bill.setInvoiceid(uniqueid);
		bill.setLicenseid("");
		
		String payto = "";
		MongoConnection mongoconcompan = new MongoConnection();
		DBCursor resultcompan = mongoconcompan.getDBObject("osmid", osmmodelid, "OSM");
		if (resultcompan.hasNext()) {
			DBObject osmcompan = resultcompan.next();
			payto = (String)osmcompan.get("osmowner");
			
		}
		
		String totalamount = Double.toString(Double.parseDouble(stockamount)* Double.parseDouble(stockprice));
		
		bill.setPayfromid(ownerid);
		bill.setPaymentmethods("");
		bill.setPaytoid(payto);
		bill.setPlanid("");
		bill.setItem("Stock");
		bill.setTotalamount(totalamount);
			
		MongoConnection mongoconsearch = new MongoConnection();
		// SearchPreview searchprev = new SearchPreview();
		BasicDBObject basicreqobjsearch = osmfileutility.formOSMOperatorBillDBObject(bill);

		mongoconsearch.saveObject(basicreqobjsearch, "Bill");
		
		
		
		return bill;
	}
	
	
}
