package com.fliker.Modal;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.SpringMongoConfig;
import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Company;
import com.fliker.Repository.CourseReview;
import com.fliker.Repository.Courses;
import com.fliker.Repository.FAQ;
import com.fliker.Repository.FileUpload;
import com.fliker.Repository.Jobs;
import com.fliker.Repository.Organization;
import com.fliker.Repository.Profile;
import com.fliker.Repository.Reply;
import com.fliker.Repository.User;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;

public class CoursePreview {

	//private static final Logger logger = Logger.getLogger(CoursePreview.class);
	
	private ArrayList courselist = new ArrayList();
	private ArrayList couretaking = new ArrayList();
	
	//check for course providing
	public boolean isProvidingCourse(String userid){
		
		boolean courseprovider = false;
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("userid", userid, "Course");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
		
			Courses courses = new Courses();
			
			courses.setCourseCategory((String)theObj.get("courseCategory"));
			courses.setCoursecreatedate((String)theObj.get("coursecreatedate"));
			courses.setCoursecreatelocation((String)theObj.get("coursecreatelocation"));
			courses.setCourseDescription((String)theObj.get("courseDescription"));
			courses.setCourseFee((String)theObj.get("courseFee"));
			courses.setCourseid((String)theObj.get("courseid"));
			courses.setCourseimageid((String)theObj.get("courseimageid"));
			courses.setCourselinkid((String)theObj.get("courselinkid"));
			courses.setCourseName((String)theObj.get("courseName"));
			courses.setCourseownerid((String)theObj.get("courseownerid"));
			courses.setCoursepublisheddate((String)theObj.get("coursepublisheddate"));
			courses.setCoursepublishlocation((String)theObj.get("coursepublishlocation"));
			courses.setCourseReview((String)theObj.get("courseReview"));
			
			String[] weekids = ((String)theObj.get("courseweekids")).split(",");
			
			courses.setCourseweekids(weekids);
			courseprovider = true;
			
			courselist.add(courses);
			
		}else{
			courselist.add("");
		}
		
		
		return courseprovider;
	}
	
	//check course taking
	public boolean isTakingCourse(String userid){
		
		boolean coursetaking = false;
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("userid", userid, "Profile");
		if(resultcursor.hasNext()){
			
			DBObject theObj = resultcursor.next();
			
			String coursetak = (String)theObj.get("courseids");
			if(coursetak !=null){
				
				coursetaking = true;
				String[] courselist = ((String)theObj.get("courseids")).split(",");
				
				for(int i=0;i<courselist.length;i++){
				MongoConnection mongoconnest = new MongoConnection();
				DBCursor resultcursornext = mongoconnest.getDBObject("courseid", courselist[i], "Course");
				if(resultcursornext.hasNext()){
					DBObject theObjnext = resultcursornext.next();
					
					Courses courses = new Courses();
					
					courses.setCourseCategory((String)theObjnext.get("courseCategory"));
					courses.setCoursecreatedate((String)theObjnext.get("coursecreatedate"));
					courses.setCoursecreatelocation((String)theObjnext.get("coursecreatelocation"));
					courses.setCourseDescription((String)theObjnext.get("courseDescription"));
					courses.setCourseFee((String)theObjnext.get("courseFee"));
					courses.setCourseid((String)theObjnext.get("courseid"));
					courses.setCourseimageid((String)theObjnext.get("courseimageid"));
					courses.setCourselinkid((String)theObjnext.get("courselinkid"));
					courses.setCourseName((String)theObjnext.get("courseName"));
					courses.setCourseownerid((String)theObjnext.get("courseownerid"));
					courses.setCoursepublisheddate((String)theObjnext.get("coursepublisheddate"));
					courses.setCoursepublishlocation((String)theObjnext.get("coursepublishlocation"));
					courses.setCourseReview((String)theObjnext.get("courseReview"));
					
					String[] weekids = ((String)theObjnext.get("courseweekids")).split(",");
					
					courses.setCourseweekids(weekids);
					
					couretaking.add(courses);
					
					}else{
						couretaking.add("");
					}
				
					
				}
				
			}else{
				couretaking.add("");
			}
			
		}
		return coursetaking;
	}
	
	
	public ArrayList getCourseTaking(){
		return couretaking;
	}
	
	public ArrayList getCourseProviding(){
		return courselist;
	}
	
	public String promptCoursePage(String userid){
		
		String pagepromt = "";
		
		CoursePreview courseprev = new CoursePreview();
		
		if(courseprev.isProvidingCourse(userid) && courseprev.isTakingCourse(userid)){
			pagepromt = "CourseProvTake";
		}else if(courseprev.isProvidingCourse(userid) && !courseprev.isTakingCourse(userid)){
			pagepromt = "CourseProvOnly";//done
		}else if(!courseprev.isProvidingCourse(userid) && courseprev.isTakingCourse(userid)){
			pagepromt = "CourseTakeOnly";//done
		}else{
			pagepromt = "CourseOnly";//done
		}
		
		return "/"+pagepromt;
	}
	
	
	
	
	

	public ArrayList getCourseList() {

		ArrayList courselist = new ArrayList();
		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("Course");
		DBCursor cursor;

		cursor = collection.find().limit(3).sort(new BasicDBObject("courseReview", -1));
		while (cursor.hasNext()) {
			DBObject currentItem = cursor.next();
			String imageid = (String) currentItem.get("courseimageid");
			/*
			 * BasicDBList fileids = (BasicDBList) currentItem.get("fileids");
			 * for(int i=0;i<fileids.size();i++){ String fileid = (String)
			 * fileids.get(i); System.out.println("fileid ++"+fileid); }
			 */

			// FileUpload ImageFile = getFiles(imageid);
			// cursor = collection.find(new BasicDBObject("courseid",
			// lastid)).limit(50).sort(new BasicDBObject("courseReview",-1));
			// String image

			String userid = (String) currentItem.get("userid");

			System.out.println("imageid" + imageid + " userid " + userid); //

			courselist.add(currentItem);
			// courselist.add(ImageFile);

		}

		System.out.println("courselist in preview ::" + courselist);

		return courselist;
	}

	public ArrayList getMyCourseList(User userinfo) {

		ArrayList mycourselist = new ArrayList();

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		Query query2 = new Query();
		// query2.addCriteria(Criteria.where("courseOwner").is("dog").and("age").is(40));
		query2.addCriteria(Criteria.where("courseOwner").is(userinfo.getUsername()));
		List<Courses> userTest3 = mongoOperation.find(query2, Courses.class);

		for (Courses course : userTest3) {
			mycourselist.add(course);
		}

		return mycourselist;

	}

	public ArrayList getMyCourseListWithid(String lastid) {

		ArrayList courselist = new ArrayList();
		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("Course");
		DBCursor cursor;

		// cursor = collection.find(new BasicDBObject("courseid",
		// lastid)).limit(3).sort(new BasicDBObject("courseReview",-1));
		cursor = collection.find().skip(3).limit(3).sort(new BasicDBObject("courseReview", -1));
		while (cursor.hasNext()) {
			DBObject currentItem = cursor.next();
			String imageid = (String) currentItem.get("courseimageid");
			/*
			 * BasicDBList fileids = (BasicDBList) currentItem.get("fileids");
			 * for(int i=0;i<fileids.size();i++){ String fileid = (String)
			 * fileids.get(i); System.out.println("fileid ++"+fileid); }
			 */

			// FileUpload ImageFile = getFiles(imageid);
			// cursor = collection.find(new BasicDBObject("courseid",
			// lastid)).limit(50).sort(new BasicDBObject("courseReview",-1));
			// String image

			String userid = (String) currentItem.get("userid");

			System.out.println("imageid" + imageid + " userid " + userid); //

			courselist.add(currentItem);
			// courselist.add(ImageFile);

		}

		System.out.println("courselist in preview :: onlastload" + courselist);

		return courselist;

	}

	public GridFSDBFile getFiles(String fileid) {

		FileUpload fileimage = new FileUpload();
		GridFSDBFile imageForOutput = null;
		String fileimageid = "";
		
		MongoConnection mongoconn = new MongoConnection();
		DBCursor filecur = mongoconn.getDBObject("id", fileid, "fileupload");
		
		while(filecur.hasNext()){
			
			BasicDBObject fileobj = (BasicDBObject) filecur.next();
			
			fileimageid = (String) fileobj.get("name");
			
		}

		/*ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		Query query = new Query();
		// query2.addCriteria(Criteria.where("courseOwner").is("dog").and("age").is(40));
		query.addCriteria(Criteria.where("_id").is(fileid));*/
		
		
		
		/*List<FileUpload> fileimages = (List<FileUpload>) mongoOperation.find(query, FileUpload.class);

		for (int i = 0; i < fileimages.size(); i++) {
			fileimage = fileimages.get(i);
		}*/

		MongoClientURI uri  = new MongoClientURI("mongodb://admin:admin@ds021663.mlab.com:21663/fliker");
        MongoClient client = new MongoClient(uri);
        DB db = client.getDB(uri.getDatabase());

		//DB db = mongo.getDB("testdb");
		DBCollection collection = mongoconn.getDBConnection("fileupload");
		GridFS gridfs = new GridFS(db, "files");

		imageForOutput = gridfs.findOne(fileimageid);
		System.out.println("imageForOutput >>" + imageForOutput);
		return imageForOutput;

	}

	public List<Courses> courseInfo(String courseid) {

		/*ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		ArrayList courselist = new ArrayList();

		//Query searchUserQuery = new Query(Criteria.where("courseid").is(courseid));
		//Courses savedcourse = mongoOperation.findOne(searchUserQuery, Courses.class);

		Query query = new Query();
		// query2.addCriteria(Criteria.where("courseOwner").is("dog").and("age").is(40));
		query.addCriteria(Criteria.where("courseid").is(courseid));
		List<Courses> courseinfo = (List<Courses>) mongoOperation.find(query, Courses.class);*/
		
		List<Courses> courselist = new ArrayList<Courses>();
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("courseid", courseid, "Course");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			Courses courses = new Courses();
			courses.setCourseCategory((String)theObj.get("courseCategory"));
			courses.setCourseDescription((String)theObj.get("courseDescription"));
			courses.setCourseFee((String)theObj.get("courseFee"));
			courses.setCourseid((String)theObj.get("courseid"));
			courses.setCourseimageid((String)theObj.get("courseimageid"));
			courses.setCourseName((String)theObj.get("courseName"));
			courses.setCourseownerid((String)theObj.get("courseownerid"));
			String[] partners = ((String)theObj.get("coursePartners")).split(",");
			courses.setCoursePartners(partners);
			//String[] reviews = ((String)theObj.get("courseReview")).split(",");
			courses.setCourseReview((String)theObj.get("courseReview"));
			String[] sponsors = ((String)theObj.get("courseSponsors")).split(",");
			courses.setCourseSponsors(sponsors);
			String[] faqids = ((String)theObj.get("FAQid")).split(",");
			courses.setFAQid(faqids) ;
			
			courselist.add(courses);
			
			
		}
		
		

		/*
		 * for(int i=0;i<courseinfo.size();i++){ Courses corselst =
		 * courseinfo.get(i); courselist.add(corselst.getCoursename());
		 * courselist.add(corselst.getCourseid());
		 * courselist.add(corselst.getCourseCategory());
		 * courselist.add(corselst.getCourseDescription());
		 * courselist.add(corselst.getCourseFee());
		 * courselist.add(corselst.getCourseimageid());
		 * courselist.add(corselst.getTimeduration());
		 * courselist.add(corselst.getFAQ());
		 * 
		 * 
		 * ApplicationContext ctx1 = new
		 * AnnotationConfigApplicationContext(SpringMongoConfig.class);
		 * MongoOperations mongoOperation1 = (MongoOperations)
		 * ctx1.getBean("mongoTemplate");
		 * 
		 * //User Details Query query1 = new Query(); //
		 * query2.addCriteria(Criteria.where("courseOwner").is("dog").and("age")
		 * .is(40)); query1.addCriteria(Criteria.where("userid").is(
		 * "572f7777bc22c22add92894e")); List<Profile> profileinfo =
		 * (List<Profile>) mongoOperation1.find(query1, Profile.class); for(int
		 * j=0;j<profileinfo.size();j++){
		 * 
		 * Profile prof = profileinfo.get(j);
		 * 
		 * courselist.add(prof.getAboutme());
		 * courselist.add(prof.getProfileThumbnailid());
		 * courselist.add(prof.getCoursesids());
		 * courselist.add(prof.getEmailid());
		 * courselist.add(prof.getExperience());
		 * courselist.add(prof.getFollowers());
		 * 
		 * }
		 * 
		 * 
		 * //Partners details String[] coursePartners =
		 * corselst.getCoursePartners(); for(int
		 * m=0;m<coursePartners.length;m++){
		 * 
		 * List partners;
		 * 
		 * Query query2 = new Query(); //
		 * query2.addCriteria(Criteria.where("courseOwner").is("dog").and("age")
		 * .is(40));
		 * query2.addCriteria(Criteria.where("companyid").is(coursePartners[m]))
		 * ; partners = (List<Company>) mongoOperation.find(query2,
		 * Company.class);
		 * 
		 * if(partners.isEmpty()){ Query query3 = new Query(); //
		 * query2.addCriteria(Criteria.where("courseOwner").is("dog").and("age")
		 * .is(40));
		 * query3.addCriteria(Criteria.where("organizationID").is(coursePartners
		 * [m])); partners = (List<Organization>) mongoOperation.find(query1,
		 * Organization.class);
		 * 
		 * for(int n=0;n<partners.size();n++){ Organization org = (Organization)
		 * partners.get(n); courselist.add(org.getOrganizationID());
		 * courselist.add(org.getOrglogoid()); }
		 * 
		 * 
		 * }else{ for(int n=0;n<partners.size();n++){ Company company =
		 * (Company) partners.get(n); courselist.add(company.getCompanyid());
		 * courselist.add(company.getCompanylogoid()); } }
		 * 
		 * }
		 * 
		 * 
		 * 
		 * //Sponsor details String[] courseSponsors =
		 * corselst.getCourseSponsors(); for(int
		 * o=0;o<courseSponsors.length;o++){
		 * 
		 * List sponsors;
		 * 
		 * Query query2 = new Query(); //
		 * query2.addCriteria(Criteria.where("courseOwner").is("dog").and("age")
		 * .is(40));
		 * query2.addCriteria(Criteria.where("companyid").is(courseSponsors[o]))
		 * ; sponsors = (List<Company>) mongoOperation.find(query1,
		 * Company.class);
		 * 
		 * if(sponsors.isEmpty()){ Query query3 = new Query(); //
		 * query2.addCriteria(Criteria.where("courseOwner").is("dog").and("age")
		 * .is(40));
		 * query3.addCriteria(Criteria.where("organizationID").is(courseSponsors
		 * [o])); sponsors = (List<Organization>) mongoOperation.find(query1,
		 * Organization.class);
		 * 
		 * for(int n=0;n<sponsors.size();n++){ Organization org = (Organization)
		 * sponsors.get(n); courselist.add(org.getOrganizationID());
		 * courselist.add(org.getOrglogoid()); }
		 * 
		 * 
		 * }else{ for(int n=0;n<sponsors.size();n++){ Company company =
		 * (Company) sponsors.get(n); courselist.add(company.getCompanyid());
		 * courselist.add(company.getCompanylogoid()); } }
		 * 
		 * }
		 * 
		 * //Review details
		 * 
		 * }
		 */

		System.out.println("courseinfo >>." + courselist);

		return courselist;

	}

	public Profile profileInfo(String userid) {

		System.out.println("userid >>" + userid);
		MongoConnection mongoconn = new MongoConnection();
		DBCursor dbcur = mongoconn.getDBObject("userid", userid, "Profile");
		Profile profileinfo = new Profile();
		
		while(dbcur.hasNext()){
			
			profileinfo = (Profile) dbcur.next();
			
		}

		return profileinfo;

	}

	public List sponsorsinfo(String[] sponsorsarr) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		System.out.println("sponsorsarr >>>>" + sponsorsarr);

		List sponsors = null;

		String[] courseSponsors = sponsorsarr;
		for (int o = 0; o < courseSponsors.length; o++) {

			Query query2 = new Query();
			// query2.addCriteria(Criteria.where("courseOwner").is("dog").and("age").is(40));
			query2.addCriteria(Criteria.where("companyid").is(courseSponsors[o]));
			sponsors = (List<Company>) mongoOperation.find(query2, Company.class);

			if (sponsors.isEmpty()) {
				Query query3 = new Query();
				// query2.addCriteria(Criteria.where("courseOwner").is("dog").and("age").is(40));
				query3.addCriteria(Criteria.where("organizationID").is(courseSponsors[o]));
				sponsors = (List<Organization>) mongoOperation.find(query2, Organization.class);

			}

		}
		return sponsors;

	}

	public List partnerinfo(String[] partnerarr) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		System.out.println("partnerarr >>>>" + partnerarr);

		List partners = null;

		String[] coursePartners = partnerarr;
		for (int m = 0; m < coursePartners.length; m++) {

			Query query2 = new Query();
			// query2.addCriteria(Criteria.where("courseOwner").is("dog").and("age").is(40));
			query2.addCriteria(Criteria.where("companyid").is(coursePartners[m]));
			partners = (List<Company>) mongoOperation.find(query2, Company.class);

			if (partners.isEmpty()) {
				Query query3 = new Query();
				// query2.addCriteria(Criteria.where("courseOwner").is("dog").and("age").is(40));
				query3.addCriteria(Criteria.where("organizationID").is(coursePartners[m]));
				partners = (List<Organization>) mongoOperation.find(query3, Organization.class);

			}

		}
		return partners;

	}

	public ArrayList<FAQ> faqsets(String[] faqids) {

		ArrayList<FAQ> faqlist = new ArrayList<FAQ>();

		System.out.println("faqids >>" + faqids);
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		for (int s = 0; s < faqids.length; s++) {

			Query searchUserQuery = new Query(Criteria.where("faqid").is(faqids[s]));
			FAQ faqinfo = mongoOperation.findOne(searchUserQuery, FAQ.class);

			faqlist.add(faqinfo);

		}

		return faqlist;

	}

	public ArrayList<Profile> connectioninfo(String[] connectionids) {

		ArrayList<Profile> profileconn = new ArrayList<Profile>();
		
		System.out.println("userid >>" + connectionids);
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		
		for(int m=0;m<connectionids.length;m++){
			Query searchUserQuery = new Query(Criteria.where("userid").is(connectionids[m]));
			Profile profileinfo = mongoOperation.findOne(searchUserQuery, Profile.class);
			
			profileconn.add(profileinfo);
		}

		return profileconn;

	}
	
	
	public ArrayList<Profile> followersinfo(String[] connectionids) {

		ArrayList<Profile> profilefoll = new ArrayList<Profile>();
		
		System.out.println("userid >>" + connectionids);
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		
		for(int m=0;m<connectionids.length;m++){
			Query searchUserQuery = new Query(Criteria.where("userid").is(connectionids[m]));
			Profile profileinfo = mongoOperation.findOne(searchUserQuery, Profile.class);
			
			profilefoll.add(profileinfo);
		}

		return profilefoll;

	}
	
	
	public HashMap coursereviews(String[] reviewids) {

		HashMap courserev = new HashMap();
		CourseReview courserevs = new CourseReview();
		Reply replys = new Reply();
		
		System.out.println("userid >>" + reviewids);
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		
		for(int m=0;m<reviewids.length;m++){
			Query searchUserQuery = new Query(Criteria.where("_id").is(reviewids[m]));
			courserevs = mongoOperation.findOne(searchUserQuery, CourseReview.class);
			
			String[] replyids = courserevs.getReplyid();
			/*if(replyids.length < 1){
				break;
			}else{
				
				for(int f=0;f<replyids.length;f++){
					Query searchUserQuery1 = new Query(Criteria.where("_id").is(replyids[f]));
					replys = mongoOperation.findOne(searchUserQuery1, Reply.class);
				}
			}*/
			
			courserev.put(courserevs, replyids);
			
		}

		return courserev;

	}
	
	
	public HashMap courseRevFullSet(HashMap courserev){
		
		HashMap courserevfullset = new HashMap();
		ArrayList replylist = new ArrayList();
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		Set courseset = courserev.entrySet();
		Reply replys = new Reply();
		Iterator courseit = courseset.iterator();
		while(courseit.hasNext()){
			Map.Entry courseme = (Map.Entry)courseit.next();
			
			String[] replyids = (String[]) courseme.getValue();
			for(int g=0;g<replyids.length;g++){
				
				Query searchUserQuery = new Query(Criteria.where("replyid").is(replyids[g]));
				replys = mongoOperation.findOne(searchUserQuery, Reply.class);
				
				replylist.add(replys);
			}
			
			
		}
		
		courserevfullset.put(courserev, replylist);
		return courserevfullset;
	}

}
