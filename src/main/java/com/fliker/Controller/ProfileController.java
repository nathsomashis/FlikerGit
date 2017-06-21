package com.fliker.Controller;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.ProfilePreview;
import com.fliker.Modal.TimeLinePreview;
import com.fliker.Repository.User;

@Controller
public class ProfileController {

	@RequestMapping("/profile")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name, HttpSession session,HttpServletRequest request) {
		System.out.println("in profile controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		mv = new ModelAndView("/Profile");
		
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userids = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userids);
		String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
		ArrayList profileInfo = profprev.getProfileInfo(userid);
		
		//ArrayList recommentlist = profprev.getRecommendedList(userid);
		
		mv.addObject("postlist", profileInfo);
		mv.addObject("name", name);
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		return mv;
	}
	
	
	@RequestMapping("/profiles")
	public ModelAndView showProfiles(
			@RequestParam(value = "userid", required = false) String userid, HttpSession session,HttpServletRequest request) {
		System.out.println("in profile controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		mv = new ModelAndView("/Profile");
		
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userids = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userids);
		//String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
		ArrayList profileInfo = profprev.getProfileInfo(userid);
		
		//ArrayList recommentlist = profprev.getRecommendedList(userid);
		
		mv.addObject("postlist", profileInfo);
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		return mv;
	}
	
	@RequestMapping("/currentStatus")
	public void savecurrentstatus(
			@RequestParam(value = "currentstatus", required = false, defaultValue = "World") String currentstatus, HttpSession session) {
		System.out.println("in profile controller");
 
		
		
		ModelAndView mv;
		mv = new ModelAndView("/Profile");
		
		
		String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
		ProfilePreview profprev = new ProfilePreview();
		profprev.saveCurrentStatus(userid,currentstatus);
		
		/*mv.addObject("postlist", profileInfo);
		mv.addObject("name", name);*/
		//return mv;
	}
	
	@RequestMapping("/contactNo")
	public void savecontact(
			@RequestParam(value = "contact", required = false, defaultValue = "World") String contact, HttpSession session) {
		System.out.println("in profile controller");
		
		ModelAndView mv;
		mv = new ModelAndView("/Profile");
		
		String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
		ProfilePreview profprev = new ProfilePreview();
		profprev.saveContactNo(userid,contact);
		
	}
	
	
	@RequestMapping("/emailModify")
	public void saveEmailNew(
			@RequestParam(value = "emailid", required = false, defaultValue = "World") String emailid, HttpSession session) {
		System.out.println("in profile controller");
		
		ModelAndView mv;
		mv = new ModelAndView("/Profile");
		
		String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
		ProfilePreview profprev = new ProfilePreview();
		profprev.saveEmailModify(userid,emailid);
		
	}
	
	@RequestMapping("/tellmeaboutme")
	public void saveTellmeaboutNew(
			@RequestParam(value = "aboutme", required = false, defaultValue = "World") String aboutme, HttpSession session) {
		System.out.println("in profile controller");
		
		ModelAndView mv;
		mv = new ModelAndView("/Profile");
		
		String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
		ProfilePreview profprev = new ProfilePreview();
		profprev.saveTellMeAbout(userid,aboutme);
		
	}
	
	@RequestMapping("/skypeid")
	public void saveskypeNew(
			@RequestParam(value = "skypeid", required = false, defaultValue = "World") String skypeid, HttpSession session) {
		System.out.println("in profile controller");
		
		ModelAndView mv;
		mv = new ModelAndView("/Profile");
		
		String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
		ProfilePreview profprev = new ProfilePreview();
		profprev.saveSkypeModify(userid,skypeid);
		
	}
	
	@RequestMapping("/experience")
	public void saveExperience(
			@RequestParam(value = "experience", required = false, defaultValue = "World") String experience, HttpSession session) {
		System.out.println("in profile controller");
		
		ModelAndView mv;
		mv = new ModelAndView("/Profile");
		
		String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
		ProfilePreview profprev = new ProfilePreview();
		profprev.saveExperience(userid,experience);
		
	}
	
	@RequestMapping("/salary")
	public void saveSalaryRange(
			@RequestParam(value = "salarystart", required = false, defaultValue = "World") String salarystart, HttpSession session,
			@RequestParam(value = "salaryend", required = false, defaultValue = "World") String salaryend) {
		System.out.println("in profile controller");
		
		ModelAndView mv;
		mv = new ModelAndView("/Profile");
		
		String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
		ProfilePreview profprev = new ProfilePreview();
		profprev.saveSalaryRange(userid,salarystart,salaryend);
		
	}
	
	
	@RequestMapping("/otherprofile")
	public ModelAndView otherProfile(
			@RequestParam(value = "userid", required = false) String userid, HttpSession session,HttpServletRequest request) {
		System.out.println("in profile controller");
		
		ArrayList profilelist = new ArrayList();
		ArrayList timelinelist = new ArrayList();
		ProfilePreview profprev = new ProfilePreview();
		TimeLinePreview timeprev = new TimeLinePreview();
		
		
		profilelist = profprev.getProfileInfo(userid);
		timelinelist = timeprev.getTimeLineData(userid);
		
		
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userids = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		String profileimageid = profprev.profileimage(userids);
		
		ModelAndView mv = new ModelAndView("/OthersProfile");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		mv.addObject("profilelist", profilelist);
		mv.addObject("timelinelist", timelinelist);
		
		//String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		return mv;
	}
	
}
