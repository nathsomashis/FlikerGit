package com.fliker.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.CoursePreview;
import com.fliker.Repository.CourseReview;
import com.fliker.Repository.Courses;
import com.fliker.Repository.FAQ;
import com.fliker.Repository.Profile;

@Controller
public class CourseController {

	//private static final Logger logger = Logger.getLogger(CourseController.class);
	
	
	@RequestMapping("/course")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name ) {
		System.out.println("in controller");
 
		ArrayList courselist = new ArrayList<Courses>();
		CoursePreview coursepreview = new CoursePreview();
			
		courselist = coursepreview.getCourseList();
		
		System.out.println("courselist"+courselist);
		
		ModelAndView mv = new ModelAndView("/Courses");
		mv.addObject("name", name);
		mv.addObject("courselist", courselist);
		return mv;
	}
	
	@RequestMapping( value = "/courseinfo", method = RequestMethod.GET )
	public @ResponseBody ArrayList showCourseInfo(
			@RequestParam(value = "lastid", required = true) String lastid, HttpServletRequest request ) {
		System.out.println("in controller load more");
 
		ArrayList courselist = new ArrayList<Courses>();
		CoursePreview coursepreview = new CoursePreview();
		
			courselist = coursepreview.getMyCourseListWithid(lastid);
			System.out.println("courselist <><><><"+courselist);
		
		ModelAndView mv = new ModelAndView("/CourseInfo");
		mv.addObject("name", lastid);
		mv.addObject("newcourselist", courselist);
		request.setAttribute("newcourselist", courselist);
		return courselist;
	}
	
	@RequestMapping("/coursedetail")
	public ModelAndView coursedetail(
			@RequestParam(value = "courseid", required = false, defaultValue = "World") String courseid ) {
		System.out.println("in controller");
 
		ArrayList<Courses> courselist = new ArrayList<Courses>();
		System.out.println("courseid ;;;;"+courseid);
		CoursePreview coursepreview = new CoursePreview();
		Profile profinf = new Profile();
		List sponsorsinfo = new ArrayList();
		List partnerinfo = new ArrayList();
		ArrayList<FAQ> faqs = new ArrayList<FAQ>();
		ArrayList<Profile> connectionlist = new ArrayList<Profile>();
		ArrayList<Profile> followlist = new ArrayList<Profile>();
		HashMap courserev = new HashMap();
		
		HashMap courserevfulllist = new HashMap();
			
		courselist = (ArrayList) coursepreview.courseInfo(courseid);
		
		for(int i=0;i<courselist.size();i++){
			Courses courseinfo = courselist.get(i);
			
			profinf = coursepreview.profileInfo(courseinfo.getCourseid());
			
			sponsorsinfo = coursepreview.sponsorsinfo(courseinfo.getCourseSponsors());
			
			partnerinfo = coursepreview.partnerinfo(courseinfo.getCoursePartners());
			
			faqs = coursepreview.faqsets(courseinfo.getFAQid());
			
			connectionlist = coursepreview.connectioninfo(profinf.getConnectids());
			
			followlist = coursepreview.followersinfo(profinf.getFollwerids());
			
			courserev = coursepreview.coursereviews(courseinfo.getCourseReview());
			
			courserevfulllist = coursepreview.courseRevFullSet(courserev);
			
			
			
		}
		System.out.println("faqs :::L><"+faqs);
		System.out.println("sponsorsinfo :::L><"+sponsorsinfo);
		System.out.println("partnerinfo :::L><"+partnerinfo);
		System.out.println("profinf :::L><"+profinf);
		System.out.println("courselist"+courselist);
		System.out.println("connectionlist"+connectionlist);
		System.out.println("followlist"+followlist);
		System.out.println("courserev" +courserev);
		System.out.println("courserevfulllist" +courserevfulllist);
		
		ModelAndView mv = new ModelAndView("/CoursesDetail");
		
		mv.addObject("faqs",faqs);
		mv.addObject("sponsorsinfo", sponsorsinfo);
		mv.addObject("partnerinfo", partnerinfo);
		mv.addObject("profinf", profinf);
		mv.addObject("courselist", courselist);
		mv.addObject("connectionlist",connectionlist);
		mv.addObject("followlist",followlist);
		mv.addObject("courserev",courserev);
		mv.addObject("courserevfulllist",courserevfulllist);
		return mv;
	}
	
	@RequestMapping("/coursevideos")
	public ModelAndView courseVideos(
			@RequestParam(value = "courseid", required = false, defaultValue = "World") String courseid ) {
		System.out.println("in controller for videos");
 
		ArrayList courselist = new ArrayList<Courses>();
		System.out.println("courseid ;;;;"+courseid);
		/*CoursePreview coursepreview = new CoursePreview();
			
		courselist = coursepreview.getCourseList();
		
		System.out.println("courselist"+courselist);*/
		
		ModelAndView mv = new ModelAndView("/CoursesVideos");
		
		mv.addObject("courselist", courselist);
		return mv;
	}
	
	
}
