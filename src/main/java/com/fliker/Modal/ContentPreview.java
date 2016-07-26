package com.fliker.Modal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.Part;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.multipart.MultipartFile;

import com.fliker.SpringMongoConfig;
import com.fliker.Repository.Company;
import com.fliker.Repository.Courses;
import com.fliker.Repository.FileUpload;
import com.fliker.Repository.Jobs;
import com.fliker.Repository.Post;
import com.fliker.Repository.User;

public class ContentPreview {

	
	public void savePost(MultipartFile file, String PostComment, User userinformation){
		
		try {
			saveFileToLocalDisk(file);
			
			FileUpload fileInfo = getUploadedFileInfo(file);
			
			System.out.println(fileInfo.getName());
			System.out.println(fileInfo.getSize());
			System.out.println(fileInfo.getType());
			
			String fileids = fileInfo.getFileid();
			String[] fileidsarr = fileids.split(",");
			
			PostPreview postprev = new PostPreview();
			//postprev.savePost(userinformation.getUserid(), PostComment, fileidsarr);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	private String getFileName(Part part) { 
	    String partHeader = part.getHeader("content-disposition"); 
	    System.out.println("Part Header = " + partHeader); 
	    for (String cd : part.getHeader("content-disposition").split(";")) { 
	      if (cd.trim().startsWith("filename")) { 
	        return cd.substring(cd.indexOf('=') + 1).trim() 
	            .replace("\"", ""); 
	      } 
	    } 
	    return null;

	  }
	
	
	 private void saveFileToLocalDisk(MultipartFile multipartFile)
             throws IOException, FileNotFoundException {

      String outputFileName = getOutputFilename(multipartFile);
      byte[] imagebytes = multipartFile.getBytes();
      //FileCopyUtils.copy(multipartFile.getBytes(), new FileOutputStream(outputFileName));
      System.out.println(outputFileName);
      System.out.println(imagebytes);
      
      
	 }
	 
	 private String getOutputFilename(MultipartFile multipartFile) {

         return getDestinationLocation() + multipartFile.getOriginalFilename();
	 }
	 
	 private String getDestinationLocation() {
         return "D:/uploaded-files/";
	 }
	 
	 
	 private FileUpload getUploadedFileInfo(MultipartFile multipartFile)
             throws IOException {

		 FileUpload fileInfo = new FileUpload();
	      fileInfo.setName(multipartFile.getOriginalFilename());
	      fileInfo.setSize(multipartFile.getSize());
	      fileInfo.setType(multipartFile.getContentType());
	      fileInfo.setLocation(getDestinationLocation());
	      fileInfo.setFileblob(multipartFile.getBytes());
      return fileInfo;
	 }
	
	 
	 public void saveCourse(String CourseName, String CourseDescription, String CourseCategory, MultipartFile files, String[] CourseSponsers, String[] CoursePartners, User userinfo){
		 
		 ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
			MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		 
		 	try {
				saveFileToLocalDisk(files);
			
			
				FileUpload fileInfo = getUploadedFileInfo(files);
				
				System.out.println(fileInfo.getName());
				System.out.println(fileInfo.getSize());
				System.out.println(fileInfo.getType());	
				
				Courses courses = new Courses();
				courses.setCourseName(CourseName);
				courses.setCourseDescription(CourseDescription);
				courses.setCourseCategory(CourseCategory);
				courses.setCourseid(CourseName+System.currentTimeMillis()+CourseCategory);
				//courses.setCourseimage(fileInfo);
				courses.setCoursePartners(CoursePartners);
				courses.setCourseSponsors(CourseSponsers);
				courses.setCourseownerid(userinfo.getUsername());
				//courses.setCourseOwnerInfo(userinfo);
				
				mongoOperation.save(courses);
				
				
		 	} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
	 }
	 
	 
	 public void saveJob(String JobDesc, String JobRequirement, String JobPreferredSkills, String JobCountry, String JobCity, String JobPostalCode, String JobContact,
			 String JobContactMobile, String JobCompany, String[] JobSkills, String EndDate, String StartDate){
		 
		 ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
			MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
			
			Query searchUserQuery = new Query(Criteria.where("companyname").is(JobCompany));
			Company company = mongoOperation.findOne(searchUserQuery, Company.class);
			Query searchUserQuery1 = null;
			
			int totalNumberCourse = JobSkills.length;
			
			Courses[] coursearray = new Courses[totalNumberCourse];
			String[] courseIDs = new String[totalNumberCourse];
			
			ArrayList courselist = new ArrayList();
			
			for(int i=0;i<totalNumberCourse;i++){
				searchUserQuery1 = new Query(Criteria.where("courseName").is(JobSkills[i]));
				Courses course = mongoOperation.findOne(searchUserQuery1, Courses.class);
				courselist.add(course);
			}
			
			courselist.toArray(coursearray);
			courselist.toArray(courseIDs);
			
		 
		 	Jobs jobs = new Jobs();
			jobs.setJobContacts(JobContact+","+JobContactMobile);
			jobs.setJobEndDate(EndDate);
			jobs.setJobActivation(true);
			jobs.setJobid(JobCompany+System.currentTimeMillis()+JobDesc);
			jobs.setJobname(JobDesc);
			jobs.setJobProjectDescription(JobRequirement);
			jobs.setJobResponsibilities(JobPreferredSkills);
			jobs.setJobStartDate(StartDate);
			jobs.setJobCompanyid(company.getCompanyid());
			jobs.setCourseids(courseIDs);
			
			
			
			mongoOperation.save(jobs);
		 
		 
	 }
	 
	
}
