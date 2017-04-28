package com.fliker.Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.CoursePreview;
import com.fliker.Modal.GuidancePreview;
import com.fliker.Repository.Blog;
import com.fliker.Repository.DashBoardData;
import com.fliker.Repository.GuidanceContentDashboard;
import com.fliker.Repository.GuidanceContentShared;
import com.fliker.Repository.Share;
import com.fliker.Repository.Timetable;
import com.fliker.Repository.User;
import com.mongodb.gridfs.GridFSDBFile;

@Controller
public class GuidanceController {

	//standardguidance
	@RequestMapping("/standardguidance")
	public ModelAndView showFirstGuidance(
			@RequestParam(value = "guidanceSubject", required = false, defaultValue = "World") String guidanceSubject,
			@RequestParam(value = "guidanceType", required = false, defaultValue = "World") String guidanceType,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		ArrayList resourcesSearch = new ArrayList();
		ArrayList ongoingResources = new ArrayList();
		ArrayList progressData = new ArrayList();
		
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		GuidancePreview guideprev = new GuidancePreview();
		resourcesSearch = guideprev.getGuidanceResources(guidanceSubject,guidanceType);
		
		ongoingResources = guideprev.onGoingResources(userid);
		
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceStandard");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("resourcesSearch", resourcesSearch);
		mv.addObject("ongoingResources", ongoingResources);
		return mv;
	}
	
	
	@RequestMapping("/standardNextguidance")
	public ModelAndView showNextSetGuidance(
			@RequestParam(value = "guidanceSubject", required = false, defaultValue = "World") String guidanceSubject,
			@RequestParam(value = "pageno", required = false, defaultValue = "World") String pageno) {
		System.out.println("in dashboard social controller");
 
		ArrayList resourcesSearch = new ArrayList();
		ArrayList ongoingResources = new ArrayList();
		ArrayList progressData = new ArrayList();
		
		
		GuidancePreview guideprev = new GuidancePreview();
		resourcesSearch = guideprev.getNextSetGuidanceResources(pageno, guidanceSubject);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceStandard");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("guidanceSubject", guidanceSubject);
		return mv;
	}
	
	@RequestMapping("/professionalguidance")
	public ModelAndView proffFirstGuidance(
			@RequestParam(value = "guidanceSubject", required = false, defaultValue = "World") String guidanceSubject,
			@RequestParam(value = "guidanceType", required = false, defaultValue = "World") String guidanceType ) {
		System.out.println("in dashboard social controller");
 
		ArrayList resourcesSearch = new ArrayList();
		ArrayList ongoingResources = new ArrayList();
		ArrayList progressData = new ArrayList();
		
		GuidancePreview guideprev = new GuidancePreview();
		resourcesSearch = guideprev.getGuidanceResources(guidanceSubject,guidanceType);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceProfessional");
		
		
		
		//mv.addObject("postlist", postlist);
		return mv;
	}
	
	@RequestMapping("/professionalNextguidance")
	public ModelAndView proffNextGuidance(
			@RequestParam(value = "guidanceSubject", required = false, defaultValue = "World") String guidanceSubject,
			@RequestParam(value = "pageno", required = false, defaultValue = "World") String pageno) {
		System.out.println("in dashboard social controller");
 
		ArrayList resourcesSearch = new ArrayList();
		ArrayList ongoingResources = new ArrayList();
		ArrayList progressData = new ArrayList();
		
		GuidancePreview guideprev = new GuidancePreview();
		resourcesSearch = guideprev.getNextSetGuidanceResources(pageno, guidanceSubject);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceProfessional");
		
		
		
		//mv.addObject("postlist", postlist);
		return mv;
	}
	
	
	@RequestMapping("/consumeguidance")
	public void optGuidance(
			@RequestParam(value = "guidanceSubject", required = false, defaultValue = "World") String guidanceSubject,
			@RequestParam(value = "userid", required = false, defaultValue = "World") String userid,HttpServletRequest request,
			@RequestParam(value = "guidencetype", required = false, defaultValue = "World") String guidencetype) {
		System.out.println("in dashboard social controller");
 
		String[]  guidancesubjects = guidanceSubject.split(",");
		String guidanceflag = "consume";
		
		GuidancePreview guidanceprev = new GuidancePreview();
		guidanceprev.saveGidance(userid, guidancesubjects, request, guidanceflag,guidencetype);
		
		
	}
	
	
	@RequestMapping("/provideguidance")
	public void provideGuidance(
			@RequestParam(value = "guidanceSubject", required = false, defaultValue = "World") String guidanceSubject,
			@RequestParam(value = "userid", required = false, defaultValue = "World") String userid,HttpServletRequest request,
			@RequestParam(value = "guidencetype", required = false, defaultValue = "World") String guidencetype) {
		System.out.println("in dashboard social controller");
 
		String[]  guidancesubjects = guidanceSubject.split(",");
		String guidanceflag = "provide";
		
		GuidancePreview guidanceprev = new GuidancePreview();
		guidanceprev.saveGidance(userid, guidancesubjects, request, guidanceflag,guidencetype);
		
		
	}
	
	
	//student apply for guidance
	@RequestMapping("/applyguidance")
	public void applyForGuidance(
			@RequestParam(value = "guidanceSubject", required = false, defaultValue = "World") String guidanceSubject,
			@RequestParam(value = "userid", required = false, defaultValue = "World") String userid,HttpServletRequest request,
			@RequestParam(value = "guidencetype", required = false, defaultValue = "World") String guidencetype,
			@RequestParam(value = "guidanceuserid", required = false, defaultValue = "World") String guidanceuserid) {
		System.out.println("in dashboard social controller");
 
		GuidancePreview guidanceprev = new GuidancePreview();
		guidanceprev.applicationGuide(guidanceSubject,userid,guidencetype,guidanceuserid);
		
	}
	
	//accepting students application
	@RequestMapping("/acceptapplyguidance")
	public void acceptForApplyForGuidance(
			@RequestParam(value = "guidanceSubject", required = false, defaultValue = "World") String guidanceSubject,
			@RequestParam(value = "userid", required = false, defaultValue = "World") String userid,HttpServletRequest request,
			@RequestParam(value = "guidencetype", required = false, defaultValue = "World") String guidencetype,
			@RequestParam(value = "applyuserid", required = false, defaultValue = "World") String applyuserid) {
		System.out.println("in dashboard social controller");
 
		GuidancePreview guidanceprev = new GuidancePreview();
		guidanceprev.applyForGuidance(guidanceSubject,applyuserid,guidencetype,userid);
		
		
		
	}
	
	//paging guidance to student
	@RequestMapping("/pagingguidance")
	public void pagingForGuidance(
			@RequestParam(value = "guidanceSubject", required = false, defaultValue = "World") String guidanceSubject,
			@RequestParam(value = "userid", required = false, defaultValue = "World") String userid,HttpServletRequest request,
			@RequestParam(value = "guidencetype", required = false, defaultValue = "World") String guidencetype,
			@RequestParam(value = "guidanceuserid", required = false, defaultValue = "World") String guidanceuserid) {
		System.out.println("in dashboard social controller");
 
		GuidancePreview guidanceprev = new GuidancePreview();
		guidanceprev.applicationGuide(guidanceSubject,guidanceuserid,guidencetype,userid);
		
	}
	
	//student accepting paging from provider
	@RequestMapping("/acceptpagingguidance")
	public void acceptPagingForGuidance(
			@RequestParam(value = "guidanceSubject", required = false, defaultValue = "World") String guidanceSubject,
			@RequestParam(value = "userid", required = false, defaultValue = "World") String userid,HttpServletRequest request,
			@RequestParam(value = "guidencetype", required = false, defaultValue = "World") String guidencetype,
			@RequestParam(value = "guidanceuserid", required = false, defaultValue = "World") String guidanceuserid) {
		System.out.println("in dashboard social controller");
 
		GuidancePreview guidanceprev = new GuidancePreview();
		guidanceprev.applyForGuidance(guidanceSubject,guidanceuserid,guidencetype,userid);
		
	}
	
	
	@RequestMapping("/gotoguidance")
	public ModelAndView goToGuidance(
			@RequestParam(value = "guidanceid", required = false, defaultValue = "World") String guidanceid,ModelMap model) {
		System.out.println("in dashboard social controller");
 
		ArrayList resourcesSearch = new ArrayList();
		
		
		GuidancePreview guideprev = new GuidancePreview();
		resourcesSearch = guideprev.getGuidanceData(guidanceid);
		
		Timetable timetable = guideprev.getTimeTableInfo(guidanceid);
		model.addAttribute("TimeTable", timetable);
		
		GuidanceContentShared guidshareditem = guideprev.getSharedInfo(guidanceid);
		model.addAttribute("GuidShared", guidshareditem);
		
		GuidanceContentDashboard guiddashdata = guideprev.getDashBoardGuidance(guidanceid);
		model.addAttribute("GuidDashBoard", guiddashdata);
		
		Blog blogs = guideprev.getGuidanceBlogs(guidanceid);
		model.addAttribute("GuidBlog", blogs);
		
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceProfessional");
		
		
		
		//mv.addObject("postlist", postlist);
		return mv;
	}
	
	
	@RequestMapping(value = "/nextmeeting/{participant}")
	@ResponseBody
	public String helloWorld(@PathVariable String particiant)  {
	  
		String meetingtime = "";
		
		String guidanceid = particiant.split(",")[0];
		String participantid= particiant.split(",")[1];
		GuidancePreview guidprev = new GuidancePreview();
		meetingtime = guidprev.nextMeeting(guidanceid,participantid);
		
		
	  return meetingtime;
	}
	
	
	
}
