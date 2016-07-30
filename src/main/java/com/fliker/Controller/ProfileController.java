package com.fliker.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.ProfilePreview;

@Controller
public class ProfileController {

	@RequestMapping("/profile")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name, HttpSession session) {
		System.out.println("in profile controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		mv = new ModelAndView("/Profile");
		
		
		String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
		ProfilePreview profprev = new ProfilePreview();
		ArrayList profileInfo = profprev.getProfileInfo(userid);
		
		mv.addObject("postlist", profileInfo);
		mv.addObject("name", name);
		return mv;
	}
	
	@RequestMapping("/currentStatus")
	public void savecurrentstatus(
			@RequestParam(value = "currentstatus", required = false, defaultValue = "World") String currentstatus, HttpSession session) {
		System.out.println("in profile controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		mv = new ModelAndView("/Profile");
		
		
		String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
		/*ProfilePreview profprev = new ProfilePreview();
		ArrayList profileInfo = profprev.getProfileInfo(userid);*/
		
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
		
	}
	
	
	@RequestMapping("/emailModify")
	public void saveEmailNew(
			@RequestParam(value = "emailid", required = false, defaultValue = "World") String emailid, HttpSession session) {
		System.out.println("in profile controller");
		
		ModelAndView mv;
		mv = new ModelAndView("/Profile");
		
		String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
	}
	
	@RequestMapping("/tellmeaboutme")
	public void saveTellmeaboutNew(
			@RequestParam(value = "aboutme", required = false, defaultValue = "World") String aboutme, HttpSession session) {
		System.out.println("in profile controller");
		
		ModelAndView mv;
		mv = new ModelAndView("/Profile");
		
		String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
	}
	
	@RequestMapping("/skypeid")
	public void saveskypeNew(
			@RequestParam(value = "skypeid", required = false, defaultValue = "World") String skypeid, HttpSession session) {
		System.out.println("in profile controller");
		
		ModelAndView mv;
		mv = new ModelAndView("/Profile");
		
		String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
	}
	
}
