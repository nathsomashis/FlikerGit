package com.fliker.Controller;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.AssignmentFilePreview;
import com.fliker.Modal.CoursePreview;
import com.fliker.Modal.FilePreview;
import com.fliker.Modal.GuidancePreview;
import com.fliker.Modal.ProfilePreview;
import com.fliker.Modal.UserPreview;
import com.fliker.Repository.Blog;
import com.fliker.Repository.DashBoardData;
import com.fliker.Repository.FileUpload;
import com.fliker.Repository.GuidanceContentDashboard;
import com.fliker.Repository.GuidanceContentShared;
import com.fliker.Repository.Profile;
import com.fliker.Repository.Share;
import com.fliker.Repository.Timetable;
import com.fliker.Repository.User;
import com.mongodb.BasicDBList;
import com.mongodb.gridfs.GridFSDBFile;

@Controller
public class GuidanceController {

	//standardguidance
	@RequestMapping("/standardguidance")
	public ModelAndView showFirstGuidance(
			@RequestParam(value = "guidanceSubject", required = false) String guidanceSubject,
			@RequestParam(value = "guidanceType", required = false) String guidanceType,
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
		
		Set<Currency> currencyset = guideprev.getAllCurrencies();
		
		HashMap guidanceprovidingsubjectmap = new HashMap();
		//guidanceprovidingsubjectmap = guideprev.getAllGuidanceProvidingSubjectList(userid);// get all profiles for the subject i am providing guidance
		
		ArrayList guidanceconsumesubjectmap = new ArrayList();
		//guidanceconsumesubjectmap = guideprev.getAllGuidanceConsumingSubjectList(userid);// get all profiles for the subject i need guidance means provider
		guidanceconsumesubjectmap = guideprev.getAllGuidanceConsuming(userid);// get all profiles for the subject i need guidance means provider
		if(guidanceconsumesubjectmap == null){
			guidanceconsumesubjectmap.add("");
		}
		
		//ongoingResources = guideprev.onGoingResources(userid);
		ongoingResources = guideprev.getGuidanceUnPublishDetails(userid);
		if(ongoingResources == null){
			ongoingResources.add("");
		}
		
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceStandard");
		
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("userid", userid);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		mv.addObject("resourcesSearch", resourcesSearch);
		mv.addObject("ongoingResources", ongoingResources);
		mv.addObject("currencyset", currencyset);
		//mv.addObject("guidanceprovidingsubjectmap", guidanceprovidingsubjectmap);
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
	
	@RequestMapping("/guidanceInfoView")
	public ModelAndView guidanceinfoview(
			@RequestParam(value = "guidanceid", required = false) String guidanceid,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		HashMap guidanceinfolist = new HashMap();
		
		GuidancePreview guidprev = new GuidancePreview();
		guidanceinfolist = guidprev.getGuidanceInfo(guidanceid);
		
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceInfoView");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("userid", userid);
		mv.addObject("guidanceid", guidanceid);
		mv.addObject("guidanceinfolist", guidanceinfolist);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		
		return mv;
	}
	
	@RequestMapping("/guidancepayment")
	public ModelAndView guidancepayment(
			@RequestParam(value = "guidanceid", required = false) String guidanceid,
			@RequestParam(value = "guidanceitem", required = false) String guidanceitem,
			@RequestParam(value = "price", required = false) String price,
			@RequestParam(value = "payableto", required = false) String payableto,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		String billid = "";
		
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		GuidancePreview guidprev = new GuidancePreview();
		billid = guidprev.generateInvoice(userid,guidanceid,guidanceitem,price,payableto);
		
		HashMap billdetails = guidprev.getBillDetail(billid);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceBuy");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("userid", userid);
		mv.addObject("bill", billid);
		mv.addObject("billdetails", billdetails);
		mv.addObject("guidanceid", guidanceid);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		
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
	public String optGuidance(
			@RequestParam(value = "guidanceSubject", required = false) String guidanceSubject,
			@RequestParam(value = "guidancereason", required = false) String guidancereason,
			@RequestParam(value = "guidencetype", required = false) String guidencetype,
			@RequestParam(value = "location", required = false) String location,
			@RequestParam(value = "published", required = false) String published,
			@RequestParam(value = "duration", required = false, defaultValue = "") String duration,
			@RequestParam(value = "userid", required = false) String userid,HttpServletRequest request) {
		try{
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
			guidanceprev.saveGidance(userids, guidanceSubject,guidancereason, request, guidanceflag,guidencetype,location,published,duration);// save new guidance needed.
			
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
		}catch(Exception ex){
			return "false";
		}
		/*ModelAndView mv;
		mv = new ModelAndView("/GuidanceStandard");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		mv.addObject("ongoingResources", ongoingResources);
		//mv.addObject("resourcesSearch", resourcesSearch);
		
		return mv;*/
		return "true";
	}
	
	
	@RequestMapping("/provideguidance")
	public String provideGuidance(
			@RequestParam(value = "guidanceSubject", required = false) String guidanceSubject,
			@RequestParam(value = "guidancereason", required = false) String guidancereason,
			@RequestParam(value = "guidencetype", required = false) String guidencetype,
			@RequestParam(value = "guidanceprice", required = false) String guidanceprice,
			@RequestParam(value = "location", required = false) String location,
			@RequestParam(value = "published", required = false) String published,
			@RequestParam(value = "duration", required = false, defaultValue = "") String duration,
			@RequestParam(value = "currency", required = false) String currency,
			@RequestParam(value = "specifications", required = false) String specifications,
			@RequestParam(value = "specificationdesc", required = false) String specificationdesc,
			HttpServletRequest request) {
		
		
		try{
				System.out.println("in dashboard social controller"+guidanceSubject+guidancereason+location+published);
		 
				//String[]  guidancesubjects = guidanceSubject.split(",");
				String guidanceflag = "provide";
				
				guidanceprice = guidanceprice + " "+ currency;
				
				GuidancePreview guidanceprev = new GuidancePreview();
				ServletContext context = request.getSession().getServletContext();
				User userinf = (User) context.getAttribute("UserValues");
				String userids = userinf.getUserid();
				
				String[] specificationarr = specifications.split(",");
				String[] specificationexpl = specificationdesc.split(",");
				
				String guidanceid = guidanceprev.saveGidance(userids, guidanceSubject,guidancereason, request, guidanceflag,guidencetype,location,published,duration);// New Guidance to provide
				
				guidanceprev.applyForGuidance(guidanceSubject,"",guidencetype,userids,guidanceid,guidanceprice,specificationarr,specificationexpl);
				
				guidanceprev.createGuidanceContentData(guidanceid,guidanceprice,guidancereason);
				
				
		}catch(Exception ex){
			return "false";
		}
		
		return "true";
		
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
		//guidanceprev.applicationGuide(guidanceSubject,userid,guidencetype,guidanceuserid);
		
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
	
	@RequestMapping("/pagingguidance")
	public ModelAndView getGuidanceInfoConsumer(
			@RequestParam(value = "guidanceid", required = false) String guidanceid,HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		ArrayList resourcesSearch = new ArrayList();
		ArrayList ongoingResources = new ArrayList();
		ArrayList progressData = new ArrayList();
		
		ServletContext context = request.getSession().getServletContext();
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String gender = userinf.getGender();
		
		GuidancePreview guideprev = new GuidancePreview();
		resourcesSearch = guideprev.getGuidanceEntryData(guidanceid,userid);
		
		ongoingResources = guideprev.getGuidanceAssignmentDetail(guidanceid);
		
		ProfilePreview profprev = new ProfilePreview();
		
		Profile profile = profprev.getProfileData(userid);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceSheet");
		
		mv.addObject("ProfileImage", profile.getProfileImageid());
		mv.addObject("Gender", gender);
		mv.addObject("resourcesSearch", resourcesSearch);
		mv.addObject("FullName", profile.getName());
		
		//mv.addObject("postlist", postlist);
		return mv;
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
 
		HashMap resourcesSearch = new HashMap();
		
		
		GuidancePreview guideprev = new GuidancePreview();
		resourcesSearch = guideprev.getGuidanceData(guidanceid);
		
		Set currencyset = guideprev.getAllCurrencies();
		
		
		ServletContext context = request.getSession().getServletContext();
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		Profile profile = profprev.getProfileData(userid);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceSheet");
		
		mv.addObject("ProfileImage", profile.getProfileImageid());
		mv.addObject("Gender", gender);
		mv.addObject("FullName", profile.getName());
		mv.addObject("resourcesSearch", resourcesSearch);
		mv.addObject("guidanceid", guidanceid);
		mv.addObject("currencyset", currencyset);
		
		return mv;
	}
	
	
	@RequestMapping("/createGuidanceEntry")
	public ModelAndView createGuidanceEntry(
			@RequestParam(value = "guidanceid", required = false) String guidanceid,ModelMap model,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		HashMap resourcesSearch = new HashMap();
		
		

	
		ServletContext context = request.getSession().getServletContext();
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		Profile profile = profprev.getProfileData(userid);
		
		GuidancePreview guideprev = new GuidancePreview();
		guideprev.createGuidanceEntry(guidanceid,userid);
		
		
		resourcesSearch = guideprev.getGuidanceData(guidanceid);
		
		Set currencyset = guideprev.getAllCurrencies();
		
		ArrayList guidanceconsumesubjectmap = new ArrayList();
		//guidanceconsumesubjectmap = guideprev.getAllGuidanceConsumingSubjectList(userid);// get all profiles for the subject i need guidance means provider
		guidanceconsumesubjectmap = guideprev.getAllGuidanceConsuming(userid);// get all profiles for the subject i need guidance means provider
		if(guidanceconsumesubjectmap == null){
			guidanceconsumesubjectmap.add("");
		}
		ArrayList ongoingResources = new ArrayList();
		//ongoingResources = guideprev.onGoingResources(userid);
		ongoingResources = guideprev.getGuidanceUnPublishDetails(userid);
		if(ongoingResources == null){
			ongoingResources.add("");
		}
		
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceStandard");
		
		mv.addObject("ProfileImage", profile.getProfileImageid());
		mv.addObject("Gender", gender);
		mv.addObject("FullName", profile.getName());
		mv.addObject("ongoingResources", ongoingResources);
		//mv.addObject("guidanceprovidingsubjectmap", guidanceprovidingsubjectmap);
		mv.addObject("guidanceconsumesubjectmap", guidanceconsumesubjectmap);
		mv.addObject("resourcesSearch", resourcesSearch);
		mv.addObject("guidanceid", guidanceid);
		mv.addObject("currencyset", currencyset);
		
		//mv.addObject("postlist", postlist);
		return mv;
	}
	
	
	@RequestMapping("/saveguidanceinfo")
	public String saveGuidanceInfo(
			@RequestParam(value = "guidancedesc", required = false) String guidancedesc,ModelMap model,
			@RequestParam(value = "guidanceexperience", required = false) String guidanceexperience,
			@RequestParam(value = "guidancecost", required = false) String guidancecost,
			@RequestParam(value = "guidancecostcurrency", required = false) String guidancecostcurrency,
			@RequestParam(value = "guidancecostper", required = false) String guidancecostper,
			@RequestParam(value = "guidanceid", required = false) String guidanceid,
			HttpServletRequest request) {
			try{
				System.out.println("in dashboard social controller");
				
				GuidancePreview guideprev = new GuidancePreview();
				guideprev.saveGuidanceInfo(guidancedesc,guidanceexperience,guidancecost,guidancecostcurrency,guidancecostper,guidanceid);
		
			}catch(Exception ex){
				return "false";
			}
		
		return "true";
	}
	
	@RequestMapping("/guidancefile")
	public void guidancesharefileupload(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session,
			@RequestParam("token") String tokenui) {
		System.out.println("in file controller");

		GuidancePreview guidprev = new GuidancePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		String token = (String)context.getAttribute("guidanceid");
		
		String fileid = guidprev.saveFile(request.getFileMap(),userid, "GuidanceContentShare",token,tokenui);
		System.out.println(fileid);

		guidprev.saveToShareDash(fileid,token);
		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	@RequestMapping("/guidanceShareContent")
	public void guidanceShareContent(@RequestParam(value = "token", required = false) String tokenui, HttpSession session,
			@RequestParam(value = "userids", required = false) String userids,HttpServletRequest request) {
		System.out.println("in file controller");

		GuidancePreview guidprev = new GuidancePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		
		String token = (String)context.getAttribute("guidanceid");
		String xfileid = guidprev.getFileInfoId(tokenui,userid);
		
		//String fileid = guidprev.getFileID(xfileid,userid,token,"");
		
		guidprev.saveFileToStudentsShare(userids,xfileid,token);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/
		
		
	}
	
	
	@RequestMapping("/guidanceShareFiles")
	public @ResponseBody ArrayList guidanceShareFiles( HttpSession session,HttpServletRequest request,
			@RequestParam(value = "guidanceid", required = false) String guidanceid) {
		System.out.println("in file controller");

		GuidancePreview guidprev = new GuidancePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		
		String token = (String)context.getAttribute("guidanceid");
		ArrayList filelist = guidprev.fileExisting(guidanceid);
		
		
		return filelist;
	}
	
	
	@RequestMapping("/guidanceShareNewConsumers")
	public @ResponseBody ArrayList guidanceShareConsumer( HttpSession session,HttpServletRequest request,
			@RequestParam(value = "fileid", required = false) String fileid,
			@RequestParam(value = "guidanceid", required = false) String guidanceid) {
		System.out.println("in file controller");

		GuidancePreview guidprev = new GuidancePreview();
		
		ArrayList consumerlist = guidprev.getUnSharedConsumers(fileid,guidanceid);
		
		
		return consumerlist;
	}
	
	
	@RequestMapping("/guidanceShareConsumers")
	public void guidanceDashShare( HttpSession session,HttpServletRequest request,
			@RequestParam(value = "fileid", required = false) String fileid,
			@RequestParam(value = "guidanceid", required = false) String guidanceid,
			@RequestParam(value = "userids", required = false) String userids) {
		System.out.println("in file controller");

		GuidancePreview guidprev = new GuidancePreview();
		
		guidprev.shareToConsumers(fileid,userids,guidanceid);
		
	}
	
	
	
	
	@RequestMapping("/guidanceview")
	public ModelAndView viewGuidance(
			@RequestParam(value = "guidanceid", required = false) String guidanceid,ModelMap model,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		ArrayList resourcesSearch = new ArrayList();
		
		
		GuidancePreview guideprev = new GuidancePreview();
		resourcesSearch = guideprev.getGuidanceViewData(guidanceid);
		
		//String userid = guideprev.getGuidanceCosumeruserid(guidanceid);
		ServletContext context = request.getSession().getServletContext();
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String gender = userinf.getGender();
		
		
		
		ProfilePreview profprev = new ProfilePreview();
		
		Profile profile = profprev.getProfileData(userid);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceView");
		
		mv.addObject("ProfileImage", profile.getProfileImageid());
		mv.addObject("Gender", gender);
		mv.addObject("FullName", profile.getName());
		mv.addObject("resourcesSearch", resourcesSearch);
		mv.addObject("guidanceid", guidanceid);
		
		
		//mv.addObject("postlist", postlist);
		return mv;
	}
	
	@RequestMapping("/gotoguidancedash")
	public ModelAndView viewGuidanceDash(
			@RequestParam(value = "guidanceid", required = false) String guidanceid,ModelMap model,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		ArrayList resourcesSearch = new ArrayList();
		
		
		GuidancePreview guideprev = new GuidancePreview();
		ArrayList specificationlist = (ArrayList)guideprev.getSpecificationData(guidanceid);
		
		ServletContext context = request.getSession().getServletContext();
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		Profile profile = profprev.getProfileData(userid);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceContentDash");
		
		mv.addObject("ProfileImage", profile.getProfileImageid());
		mv.addObject("Gender", gender);
		mv.addObject("FullName", profile.getName());
		mv.addObject("guidanceid", guidanceid);
		
		
		//mv.addObject("postlist", postlist);
		return mv;
	}
	
	
	@RequestMapping("/gotoguidanceshare")
	public ModelAndView goToGuidanceShare(
			@RequestParam(value = "guidanceid", required = false, defaultValue = "World") String guidanceid,ModelMap model,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		ArrayList consumerlist = new ArrayList();
		GuidancePreview guideprev = new GuidancePreview();
		//resourcesSearch = guideprev.getGuidanceData(guidanceid);
		
		ArrayList existingfilelist = (ArrayList)guideprev.getAllGuidanceFiles(guidanceid);
		
		BasicDBList useridlist = guideprev.getGuidanceCosumeruserid(guidanceid);
		for(int s=0;s<useridlist.size();s++){
			consumerlist.add(useridlist.get(s));
		}
		
		ServletContext context = request.getSession().getServletContext();
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		Profile profile = profprev.getProfileData(userid);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceShare");
		
		mv.addObject("ProfileImage", profile.getProfileImageid());
		mv.addObject("Gender", gender);
		mv.addObject("FullName", profile.getName());
		mv.addObject("consumerlist", consumerlist);
		mv.addObject("existingfilelist", existingfilelist);
		mv.addObject("guidanceid", guidanceid);
		
		//mv.addObject("postlist", postlist);
		return mv;
	}
	
	
	@RequestMapping("/saveguidanceinfoachievement")
	public String saveGuidanceInfoAchievement(
			@RequestParam(value = "guidanceid", required = false, defaultValue = "World") String guidanceid,ModelMap model,
			@RequestParam(value = "achievementdescribe", required = false, defaultValue = "World") String achievementdesc,
			@RequestParam(value = "guidanceachievement", required = false, defaultValue = "World") String achievementname,
			@RequestParam(value = "acheivetoken", required = false, defaultValue = "World") String token,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
		String result = "false";
		try{
			ArrayList resourcesSearch = new ArrayList();
			
			
			GuidancePreview guideprev = new GuidancePreview();
			//resourcesSearch = guideprev.getGuidanceData(guidanceid);
			ServletContext context = request.getSession().getServletContext();
			User userinf = (User) context.getAttribute("UserValues");
			String userid = userinf.getUserid();
			guideprev.saveGuidanceAchievementInfo(achievementdesc,achievementname,token,userid,guidanceid);
			
			
		}catch(Exception ex){
			return result;
		}
		return result;
	}
	
	
	@RequestMapping("/gotoguidanceexcersize")
	public ModelAndView goToGuidanceExcersize(
			@RequestParam(value = "guidanceid", required = false, defaultValue = "World") String guidanceid,ModelMap model,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		ArrayList asignmentlist = new ArrayList();
		ArrayList quizlist = new ArrayList();
		
		
		GuidancePreview guideprev = new GuidancePreview();
		asignmentlist = guideprev.getGuidanceAssignmentData(guidanceid);
		quizlist = guideprev.getGuidanceQuizData(guidanceid);
		
		//String userid = guideprev.getGuidanceCosumeruserid(guidanceid);
		ServletContext context = request.getSession().getServletContext();
		User userinf = (User) context.getAttribute("UserValues");
		String accessuserid = userinf.getUserid();
		String contenttype = guideprev.getGuidanceType(guidanceid,accessuserid);
		
		UserPreview userprev = new UserPreview();
		String gender = userprev.getGender(accessuserid);
		
		
		ProfilePreview profprev = new ProfilePreview();
		
		Profile profile = profprev.getProfileData(accessuserid);
		
		ModelAndView mv = new ModelAndView();
		mv = new ModelAndView("/GuidanceProviderExcersize");
		

		mv.addObject("ProfileImage", profile.getProfileImageid());
		mv.addObject("Gender", gender);
		mv.addObject("FullName", profile.getName());
		mv.addObject("resourcesSearch", resourcesSearch);
		mv.addObject("guidanceid", guidanceid);
		mv.addObject("contenttype",contenttype);
		
		//mv.addObject("postlist", postlist);
		return mv;
	}
	
	
	@RequestMapping("/gotoguidancecalendar")
	public ModelAndView goToGuidanceTimetable(
			@RequestParam(value = "guidanceid", required = false) String guidanceid,ModelMap model,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		ArrayList resourcesSearch = new ArrayList();
		
		
		GuidancePreview guideprev = new GuidancePreview();
		ArrayList eventlist = guideprev.getAllEvent(guidanceid);
		
		
		ServletContext context = request.getSession().getServletContext();
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String gender = userinf.getGender();
		
		
		ProfilePreview profprev = new ProfilePreview();
		
		Profile profile = profprev.getProfileData(userid);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceCalendar");
		
		mv.addObject("ProfileImage", profile.getProfileImageid());
		mv.addObject("Gender", gender);
		mv.addObject("FullName", profile.getName());
		mv.addObject("eventlist", eventlist);
		mv.addObject("guidanceid", guidanceid);
		
		//mv.addObject("postlist", postlist);
		return mv;
	}
	
	
	@RequestMapping("/guidanceCalendarEvent")
	public void createGuidanceCalendarEvent(
			@RequestParam(value = "guidanceid", required = false) String guidanceid,ModelMap model,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "eventpriority", required = false) String eventpriority,
			@RequestParam(value = "prioritytype", required = false) String prioritytype,
			@RequestParam(value = "entryid", required = false) String entryid,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
		
		ServletContext context = request.getSession().getServletContext();
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
 
		GuidancePreview guideprev = new GuidancePreview();
		guideprev.saveNewEvent(guidanceid,title,description,eventpriority,prioritytype,entryid,userid);
		
		
	}
	
	
	@RequestMapping("/guidanceCalendarEventClear")
	public void clearGuidanceCalendarEvent(
			@RequestParam(value = "guidanceid", required = false) String guidanceid,ModelMap model,
			@RequestParam(value = "entryid", required = false) String entryid,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		GuidancePreview guideprev = new GuidancePreview();
		//guideprev.saveNewEvent(guidanceid,title,description,eventpriority,prioritytype,entryid,entrydatetime);
		
		
	}
	
	@RequestMapping("/availableTime")
	public HashMap checkAvailableTime(
			@RequestParam(value = "guidanceid", required = false) String guidanceid,ModelMap model,
			@RequestParam(value = "entrystarttime", required = false) String entrystarttime,
			@RequestParam(value = "entryendtime", required = false) String entryendtime,
			HttpServletRequest request) {
		System.out.println("in dashboard social controller");
 
		GuidancePreview guideprev = new GuidancePreview();
		HashMap timemap = guideprev.getAvailableTime(guidanceid,entrystarttime,entryendtime);
		
		return timemap;
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
		
		
		ServletContext context = request.getSession().getServletContext();
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String gender = userinf.getGender();
		
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
		
		
		ServletContext context = request.getSession().getServletContext();
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String gender = userinf.getGender();
		
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
		
		ServletContext context = request.getSession().getServletContext();
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String gender = userinf.getGender();
		
		
		ProfilePreview profprev = new ProfilePreview();
		
		Profile profile = profprev.getProfileData(userid);
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceProject");
		
		mv.addObject("ProfileImage", profile.getProfileImageid());
		mv.addObject("Gender", gender);
		mv.addObject("FullName", profile.getName());
		mv.addObject("resourcesSearch", resourcesSearch);
		mv.addObject("guidanceid", guidanceid);
		
		//mv.addObject("postlist", postlist);
		return mv;
		}catch (Exception timewex){
			ModelAndView mv = new ModelAndView("/ErrorTimeOut");
			return mv;
		}
	}
	
	@RequestMapping("/addToInterest")
	public void interestAdd(@RequestParam(value = "guidanceid", required = false) String guidanceid,
			@RequestParam(value = "userid", required = false) String userid)  {
	  
		GuidancePreview guidprev = new GuidancePreview();
		guidprev.saveInterest(guidanceid,userid);
		
		
	}
	
}
