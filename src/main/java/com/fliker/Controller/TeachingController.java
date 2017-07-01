package com.fliker.Controller;

import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.GuidancePreview;
import com.fliker.Modal.ProfilePreview;
import com.fliker.Modal.SchoolPreview;
import com.fliker.Repository.User;

@Controller
public class TeachingController {

	//standardguidance
		@RequestMapping("/standardteach")
		public ModelAndView standardTeach(
				HttpServletRequest request) {
			System.out.println("in dashboard social controller");
			
			ArrayList schoollist = new ArrayList();
			ArrayList schoolattendlist = new ArrayList();
	 
			ServletContext context = request.getSession().getServletContext();
			
			User userinf = (User) context.getAttribute("UserValues");
			String userid = userinf.getUserid();
			String userfirstname = userinf.getFirstname();
			String userlastname = userinf.getLastname();
			String gender = userinf.getGender();
			ProfilePreview profprev = new ProfilePreview();
			
			String profileimageid = profprev.profileimage(userid);
			
			SchoolPreview schoolprev = new SchoolPreview();
			//schoollist = schoolprev.getAllSchoolPublishData(userid);
			//schoolattendlist = schoolprev.getSchoolTakingData(userid);
			
			ModelAndView mv;
			mv = new ModelAndView("/SchoolTest");
			
			mv.addObject("ProfileImage", profileimageid);
			mv.addObject("Gender", gender);
			mv.addObject("userid", userid);
			//mv.addObject("schoollist", schoollist);
			//mv.addObject("schoolattendlist", schoolattendlist);
			mv.addObject("FullName", userfirstname+" "+userlastname);
			return mv;
		}
		
		
		@RequestMapping("/createNewSchool")
		public ModelAndView createNewSchool(
				HttpServletRequest request) {
			System.out.println("in dashboard social controller");
			
			ServletContext context = request.getSession().getServletContext();
			
			User userinf = (User) context.getAttribute("UserValues");
			String userid = userinf.getUserid();
			String userfirstname = userinf.getFirstname();
			String userlastname = userinf.getLastname();
			String gender = userinf.getGender();
			ProfilePreview profprev = new ProfilePreview();
			
			String profileimageid = profprev.profileimage(userid);
			
			ModelAndView mv;
			mv = new ModelAndView("/CreateNewSchool");
			
			mv.addObject("ProfileImage", profileimageid);
			mv.addObject("Gender", gender);
			mv.addObject("userid", userid);
			//mv.addObject("schoollist", schoollist);
			//mv.addObject("schoolattendlist", schoolattendlist);
			mv.addObject("FullName", userfirstname+" "+userlastname);
			return mv;
		}
	
}
