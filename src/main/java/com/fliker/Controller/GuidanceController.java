package com.fliker.Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

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
import com.fliker.Modal.ProfilePreview;
import com.fliker.Modal.UserPreview;
import com.fliker.Repository.Blog;
import com.fliker.Repository.DashBoardData;
import com.fliker.Repository.GuidanceContentDashboard;
import com.fliker.Repository.GuidanceContentShared;
import com.fliker.Repository.Profile;
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
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		GuidancePreview guideprev = new GuidancePreview();
		resourcesSearch = guideprev.getGuidanceUnPublishDetails(userid);
		
		HashMap guidanceprovidingsubjectmap = new HashMap();
		guidanceprovidingsubjectmap = guideprev.getAllGuidanceProvidingSubjectList(userid);// get all profiles for the subject i am providing guidance
		
		HashMap guidanceconsumesubjectmap = new HashMap();
		guidanceconsumesubjectmap = guideprev.getAllGuidanceConsumingSubjectList(userid);// get all profiles for the subject i need guidance means provider
		
		
		ongoingResources = guideprev.onGoingResources(userid);
		
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceStandard");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		mv.addObject("resourcesSearch", resourcesSearch);
		mv.addObject("ongoingResources", ongoingResources);
		mv.addObject("guidanceprovidingsubjectmap", guidanceprovidingsubjectmap);
		mv.addObject("guidanceconsumesubjectmap", guidanceconsumesubjectmap);
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
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		GuidancePreview guideprev = new GuidancePreview();
		resourcesSearch = guideprev.getGuidanceResources(guidanceSubject,guidanceType);
		
		ongoingResources = guideprev.onGoingResources(userid);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceProfessional");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		mv.addObject("resourcesSearch", resourcesSearch);
		mv.addObject("ongoingResources", ongoingResources);
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
	public ModelAndView optGuidance(
			@RequestParam(value = "guidanceSubject", required = false) String guidanceSubject,
			@RequestParam(value = "guidancereason", required = false) String guidancereason,
			@RequestParam(value = "location", required = false) String location,
			@RequestParam(value = "published", required = false) String published,
			@RequestParam(value = "duration", required = false, defaultValue = "") String duration,
			@RequestParam(value = "userid", required = false) String userid,HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		String[]  guidancesubjects = guidanceSubject.split(",");
		String guidanceflag = "consume";
		
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userids = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		GuidancePreview guidanceprev = new GuidancePreview();
		guidanceprev.saveGidance(userids, guidanceSubject,guidancereason, request, guidanceflag,"consumer",location,published,duration);// save new guidance needed.
		
		HashMap guidanceconsumesubjectmap = new HashMap();
		guidanceconsumesubjectmap = guidanceprev.getAllGuidanceConsumingSubjectList(userid);
		
		/*ArrayList resourcesSearch = new ArrayList();
		resourcesSearch = guidanceprev.getGuidanceResources(guidanceSubject,"provider");*/
		
		ArrayList guidanceToBeList = new ArrayList();
		//guidanceToBeList = guidanceprev.getNewGuidance(userids);// No resources yet added
		
		ArrayList ongoingResources = new ArrayList();
		ongoingResources = guidanceprev.onGoingResources(userids);// Ongoing guidance going on
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceStandard");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		mv.addObject("ongoingResources", ongoingResources);
		//mv.addObject("resourcesSearch", resourcesSearch);
		
		return mv;
		
	}
	
	
	@RequestMapping("/provideguidance")
	public ModelAndView provideGuidance(
			@RequestParam(value = "guidanceSubject", required = false) String guidanceSubject,
			@RequestParam(value = "guidancereason", required = false) String guidancereason,
			@RequestParam(value = "guidencetype", required = false) String guidencetype,
			@RequestParam(value = "guidanceprice", required = false) String guidanceprice,
			@RequestParam(value = "location", required = false) String location,
			@RequestParam(value = "published", required = false) String published,
			@RequestParam(value = "duration", required = false, defaultValue = "") String duration,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller"+guidanceSubject+guidancereason+location+published);
 
		//String[]  guidancesubjects = guidanceSubject.split(",");
		String guidanceflag = "provide";
		
		GuidancePreview guidanceprev = new GuidancePreview();
		ServletContext context = request.getSession().getServletContext();
		User userinf = (User) context.getAttribute("UserValues");
		String userids = userinf.getUserid();
		
		String guidanceid = guidanceprev.saveGidance(userids, guidanceSubject,guidancereason, request, guidanceflag,guidencetype,location,published,duration);// New Guidance to provide
		
		guidanceprev.applyForGuidance(guidanceSubject,"",guidencetype,userids,guidanceid,guidanceprice);
		
		
		//both returning same data
		ArrayList resourcesSearch = new ArrayList();
		resourcesSearch = guidanceprev.getGuidanceUnPublishDetails(userids);// No resources yet added 
		
		ArrayList ongoingResources = new ArrayList();
		ongoingResources = guidanceprev.onGoingResources(userids);// Ongoing guidance going on
		
		
		HashMap guidanceprovidingsubjectmap = new HashMap();
		guidanceprovidingsubjectmap = guidanceprev.getAllGuidanceProvidingSubjectList(userids);// get all profiles for the subject i am providing guidance
		
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userids);
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceStandard");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		mv.addObject("resourcesSearch", resourcesSearch);
		mv.addObject("ongoingResources", ongoingResources);
		
		return mv;
		
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
		//guidanceprev.applyForGuidance(guidanceSubject,applyuserid,guidencetype,userid);
		
		
		
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
		//guidanceprev.applyForGuidance(guidanceSubject,guidanceuserid,guidencetype,userid);
		
	}
	
	
	@RequestMapping("/gotoguidance")
	public ModelAndView goToGuidance(
			@RequestParam(value = "guidanceid", required = false, defaultValue = "World") String guidanceid,ModelMap model,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		ArrayList resourcesSearch = new ArrayList();
		
		
		GuidancePreview guideprev = new GuidancePreview();
		resourcesSearch = guideprev.getGuidanceData(guidanceid);
		
		String userid = guideprev.getGuidanceCosumeruserid(guidanceid);
		
		UserPreview userprev = new UserPreview();
		String gender = userprev.getGender(userid);
		
		Timetable timetable = guideprev.getTimeTableInfo(guidanceid);
		//model.addAttribute("TimeTable", timetable);
		
		GuidanceContentShared guidshareditem = guideprev.getSharedInfo(guidanceid);
		//model.addAttribute("GuidShared", guidshareditem);
		
		GuidanceContentDashboard guiddashdata = guideprev.getDashBoardGuidance(guidanceid);
		//model.addAttribute("GuidDashBoard", guiddashdata);
		
		Blog blogs = guideprev.getGuidanceBlogs(guidanceid);
		//model.addAttribute("GuidBlog", blogs);
		
		ServletContext context = request.getSession().getServletContext();
		
		
		ProfilePreview profprev = new ProfilePreview();
		
		Profile profile = profprev.getProfileData(userid);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceSheet");
		
		mv.addObject("ProfileImage", profile.getProfileImageid());
		mv.addObject("Gender", gender);
		mv.addObject("FullName", profile.getName());
		mv.addObject("TimeTable", timetable);
		mv.addObject("GuidShared", guidshareditem);
		mv.addObject("GuidDashBoard", guiddashdata);
		mv.addObject("GuidBlog", blogs);
		mv.addObject("resourcesSearch", resourcesSearch);
		mv.addObject("guidanceid", guidanceid);
		
		//mv.addObject("postlist", postlist);
		return mv;
	}
	
	
	@RequestMapping("/gotoguidanceshare")
	public ModelAndView goToGuidanceShare(
			@RequestParam(value = "guidanceid", required = false, defaultValue = "World") String guidanceid,ModelMap model,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		ArrayList resourcesSearch = new ArrayList();
		
		
		GuidancePreview guideprev = new GuidancePreview();
		resourcesSearch = guideprev.getGuidanceData(guidanceid);
		
		String userid = guideprev.getGuidanceCosumeruserid(guidanceid);
		
		UserPreview userprev = new UserPreview();
		String gender = userprev.getGender(userid);
		
		Timetable timetable = guideprev.getTimeTableInfo(guidanceid);
		//model.addAttribute("TimeTable", timetable);
		
		GuidanceContentShared guidshareditem = guideprev.getSharedInfo(guidanceid);
		//model.addAttribute("GuidShared", guidshareditem);
		
		GuidanceContentDashboard guiddashdata = guideprev.getDashBoardGuidance(guidanceid);
		//model.addAttribute("GuidDashBoard", guiddashdata);
		
		Blog blogs = guideprev.getGuidanceBlogs(guidanceid);
		//model.addAttribute("GuidBlog", blogs);
		
		ServletContext context = request.getSession().getServletContext();
		
		
		ProfilePreview profprev = new ProfilePreview();
		
		Profile profile = profprev.getProfileData(userid);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceShare");
		
		mv.addObject("ProfileImage", profile.getProfileImageid());
		mv.addObject("Gender", gender);
		mv.addObject("FullName", profile.getName());
		mv.addObject("TimeTable", timetable);
		mv.addObject("GuidShared", guidshareditem);
		mv.addObject("GuidDashBoard", guiddashdata);
		mv.addObject("GuidBlog", blogs);
		mv.addObject("resourcesSearch", resourcesSearch);
		mv.addObject("guidanceid", guidanceid);
		
		//mv.addObject("postlist", postlist);
		return mv;
	}
	
	
	@RequestMapping("/gotoguidanceexcersize")
	public ModelAndView goToGuidanceExcersize(
			@RequestParam(value = "guidanceid", required = false, defaultValue = "World") String guidanceid,ModelMap model,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		ArrayList resourcesSearch = new ArrayList();
		
		
		GuidancePreview guideprev = new GuidancePreview();
		resourcesSearch = guideprev.getGuidanceData(guidanceid);
		
		//String userid = guideprev.getGuidanceCosumeruserid(guidanceid);
		ServletContext context = request.getSession().getServletContext();
		User userinf = (User) context.getAttribute("UserValues");
		String accessuserid = userinf.getUserid();
		String contenttype = guideprev.getGuidanceType(guidanceid,accessuserid);
		
		UserPreview userprev = new UserPreview();
		String gender = userprev.getGender(accessuserid);
		
		Timetable timetable = guideprev.getTimeTableInfo(guidanceid);
		//model.addAttribute("TimeTable", timetable);
		
		GuidanceContentShared guidshareditem = guideprev.getSharedInfo(guidanceid);
		//model.addAttribute("GuidShared", guidshareditem);
		
		GuidanceContentDashboard guiddashdata = guideprev.getDashBoardGuidance(guidanceid);
		//model.addAttribute("GuidDashBoard", guiddashdata);
		
		Blog blogs = guideprev.getGuidanceBlogs(guidanceid);
		//model.addAttribute("GuidBlog", blogs);
		
		ProfilePreview profprev = new ProfilePreview();
		
		Profile profile = profprev.getProfileData(accessuserid);
		
		ModelAndView mv = new ModelAndView();
		if(contenttype.equalsIgnoreCase("provider")){
			mv = new ModelAndView("/GuidanceProviderExcersize");
		}else if(contenttype.equalsIgnoreCase("consumer")){
			mv = new ModelAndView("/GuidanceConsumerExcersize");
		}else{
			mv = new ModelAndView("/GuidanceConsumerExcersize");
		}

		mv.addObject("ProfileImage", profile.getProfileImageid());
		mv.addObject("Gender", gender);
		mv.addObject("FullName", profile.getName());
		mv.addObject("TimeTable", timetable);
		mv.addObject("GuidShared", guidshareditem);
		mv.addObject("GuidDashBoard", guiddashdata);
		mv.addObject("GuidBlog", blogs);
		mv.addObject("resourcesSearch", resourcesSearch);
		mv.addObject("guidanceid", guidanceid);
		mv.addObject("contenttype",contenttype);
		
		//mv.addObject("postlist", postlist);
		return mv;
	}
	
	
	@RequestMapping("/gotoguidancecalendar")
	public ModelAndView goToGuidanceTimetable(
			@RequestParam(value = "guidanceid", required = false, defaultValue = "World") String guidanceid,ModelMap model,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		ArrayList resourcesSearch = new ArrayList();
		
		
		GuidancePreview guideprev = new GuidancePreview();
		resourcesSearch = guideprev.getGuidanceData(guidanceid);
		
		String userid = guideprev.getGuidanceCosumeruserid(guidanceid);
		
		UserPreview userprev = new UserPreview();
		String gender = userprev.getGender(userid);
		
		Timetable timetable = guideprev.getTimeTableInfo(guidanceid);
		//model.addAttribute("TimeTable", timetable);
		
		GuidanceContentShared guidshareditem = guideprev.getSharedInfo(guidanceid);
		//model.addAttribute("GuidShared", guidshareditem);
		
		GuidanceContentDashboard guiddashdata = guideprev.getDashBoardGuidance(guidanceid);
		//model.addAttribute("GuidDashBoard", guiddashdata);
		
		Blog blogs = guideprev.getGuidanceBlogs(guidanceid);
		//model.addAttribute("GuidBlog", blogs);
		
		ServletContext context = request.getSession().getServletContext();
		
		
		ProfilePreview profprev = new ProfilePreview();
		
		Profile profile = profprev.getProfileData(userid);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceCalendar");
		
		mv.addObject("ProfileImage", profile.getProfileImageid());
		mv.addObject("Gender", gender);
		mv.addObject("FullName", profile.getName());
		mv.addObject("TimeTable", timetable);
		mv.addObject("GuidShared", guidshareditem);
		mv.addObject("GuidDashBoard", guiddashdata);
		mv.addObject("GuidBlog", blogs);
		mv.addObject("resourcesSearch", resourcesSearch);
		mv.addObject("guidanceid", guidanceid);
		
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
	
	
	@RequestMapping("/endorseStudent")
	public void saveEndorsement(
			@RequestParam(value = "student", required = false, defaultValue = "World") String student,
			@RequestParam(value = "provider", required = false, defaultValue = "World") String provider,HttpServletRequest request,
			@RequestParam(value = "guidanceSubject", required = false, defaultValue = "World") String guidanceSubject
			) {
		System.out.println("in dashboard social controller");
 
		GuidancePreview guidanceprev = new GuidancePreview();
		guidanceprev.endorseSubject(guidanceSubject,provider,student);
		
		
		
	}
	
	@RequestMapping("/guidanceAllAssignments")
	public String guidanceAllAssignments(
			@RequestParam(value = "guidanceid", required = false, defaultValue = "World") String guidanceid,ModelMap model,
			@RequestParam(value = "contenttype", required = false, defaultValue = "World") String contenttype,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		String assignmentlist = "";
		String questionlist = "";
		
		
		GuidancePreview guideprev = new GuidancePreview();
		
		
		String userid = guideprev.getGuidanceCosumeruserid(guidanceid);
		
		UserPreview userprev = new UserPreview();
		String gender = userprev.getGender(userid);
		
		assignmentlist = guideprev.formAssignmentList(guidanceid,userid,contenttype);
		//questionlist = guideprev.formQuestionList(guidanceid,userid,contenttype);
		
		/*Timetable timetable = guideprev.getTimeTableInfo(guidanceid);
		//model.addAttribute("TimeTable", timetable);
		
		GuidanceContentShared guidshareditem = guideprev.getSharedInfo(guidanceid);
		//model.addAttribute("GuidShared", guidshareditem);
		
		GuidanceContentDashboard guiddashdata = guideprev.getDashBoardGuidance(guidanceid);
		//model.addAttribute("GuidDashBoard", guiddashdata);
		
		Blog blogs = guideprev.getGuidanceBlogs(guidanceid);*/
		//model.addAttribute("GuidBlog", blogs);
		
		ServletContext context = request.getSession().getServletContext();
		
		
		ProfilePreview profprev = new ProfilePreview();
		
		Profile profile = profprev.getProfileData(userid);
		return assignmentlist;
		
		/*ModelAndView mv;
		mv = new ModelAndView("/GuidanceCalendar");
		
		mv.addObject("ProfileImage", profile.getProfileImageid());
		mv.addObject("Gender", gender);
		mv.addObject("FullName", profile.getName());
		mv.addObject("TimeTable", timetable);
		mv.addObject("GuidShared", guidshareditem);
		mv.addObject("GuidDashBoard", guiddashdata);
		mv.addObject("GuidBlog", blogs);
		mv.addObject("assignmentlist", assignmentlist);
		mv.addObject("guidanceid", guidanceid);
		
		//mv.addObject("postlist", postlist);
		return mv;*/
		
		
		
	}
	
	
	@RequestMapping("/guidanceAllQuiz")
	public String guidanceAllQuiz(
			@RequestParam(value = "guidanceid", required = false, defaultValue = "World") String guidanceid,ModelMap model,
			@RequestParam(value = "contenttype", required = false, defaultValue = "World") String contenttype,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		String assignmentlist = "";
		String questionlist = "";
		
		
		GuidancePreview guideprev = new GuidancePreview();
		
		
		String userid = guideprev.getGuidanceCosumeruserid(guidanceid);
		
		UserPreview userprev = new UserPreview();
		String gender = userprev.getGender(userid);
		
		//assignmentlist = guideprev.formAssignmentList(guidanceid,userid,contenttype);
		questionlist = guideprev.formQuestionList(guidanceid,userid,contenttype);
		
		/*Timetable timetable = guideprev.getTimeTableInfo(guidanceid);
		//model.addAttribute("TimeTable", timetable);
		
		GuidanceContentShared guidshareditem = guideprev.getSharedInfo(guidanceid);
		//model.addAttribute("GuidShared", guidshareditem);
		
		GuidanceContentDashboard guiddashdata = guideprev.getDashBoardGuidance(guidanceid);
		//model.addAttribute("GuidDashBoard", guiddashdata);
		
		Blog blogs = guideprev.getGuidanceBlogs(guidanceid);*/
		//model.addAttribute("GuidBlog", blogs);
		
		ServletContext context = request.getSession().getServletContext();
		
		
		ProfilePreview profprev = new ProfilePreview();
		
		Profile profile = profprev.getProfileData(userid);
		return questionlist;
		
		/*ModelAndView mv;
		mv = new ModelAndView("/GuidanceCalendar");
		
		mv.addObject("ProfileImage", profile.getProfileImageid());
		mv.addObject("Gender", gender);
		mv.addObject("FullName", profile.getName());
		mv.addObject("TimeTable", timetable);
		mv.addObject("GuidShared", guidshareditem);
		mv.addObject("GuidDashBoard", guiddashdata);
		mv.addObject("GuidBlog", blogs);
		mv.addObject("assignmentlist", assignmentlist);
		mv.addObject("guidanceid", guidanceid);
		
		//mv.addObject("postlist", postlist);
		return mv;*/
		
		
		
	}
	
	
	@RequestMapping("/gotoguidanceproject")
	public ModelAndView goToGuidanceProject(
			@RequestParam(value = "guidanceid", required = false, defaultValue = "World") String guidanceid,ModelMap model,
			@RequestParam(value = "logid", required = false, defaultValue = "World") String logid,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
		
		try{
 
		ArrayList resourcesSearch = new ArrayList();
		
		
		GuidancePreview guideprev = new GuidancePreview();
		resourcesSearch = guideprev.getGuidanceProjectData(guidanceid);
		
		String userid = guideprev.getGuidanceCosumeruserid(guidanceid);
		
		UserPreview userprev = new UserPreview();
		String gender = userprev.getGender(userid);
		
		Timetable timetable = guideprev.getTimeTableInfo(guidanceid);
		//model.addAttribute("TimeTable", timetable);
		
		GuidanceContentShared guidshareditem = guideprev.getSharedInfo(guidanceid);
		//model.addAttribute("GuidShared", guidshareditem);
		
		GuidanceContentDashboard guiddashdata = guideprev.getDashBoardGuidance(guidanceid);
		//model.addAttribute("GuidDashBoard", guiddashdata);
		
		Blog blogs = guideprev.getGuidanceBlogs(guidanceid);
		//model.addAttribute("GuidBlog", blogs);
		
		ServletContext context = request.getSession().getServletContext();
		
		
		ProfilePreview profprev = new ProfilePreview();
		
		Profile profile = profprev.getProfileData(userid);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceProject");
		
		mv.addObject("ProfileImage", profile.getProfileImageid());
		mv.addObject("Gender", gender);
		mv.addObject("FullName", profile.getName());
		mv.addObject("TimeTable", timetable);
		mv.addObject("GuidShared", guidshareditem);
		mv.addObject("GuidDashBoard", guiddashdata);
		mv.addObject("GuidBlog", blogs);
		mv.addObject("resourcesSearch", resourcesSearch);
		mv.addObject("guidanceid", guidanceid);
		
		//mv.addObject("postlist", postlist);
		return mv;
		}catch (Exception timewex){
			ModelAndView mv = new ModelAndView("/ErrorTimeOut");
			return mv;
		}
	}
	
	
	
}
