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
		
		
		@RequestMapping("/createInstitute")
		public ModelAndView maintainSchool(
				@RequestParam(value = "institutetype", required = false) String institutetype,
				@RequestParam(value = "institutename", required = false) String institutename,
				@RequestParam(value = "institutedesc", required = false) String institutedesc,
				@RequestParam(value = "instituteadd", required = false) String instituteadd,
				@RequestParam(value = "currentstatus", required = false) String currentstatus,
				@RequestParam(value = "instituteprice", required = false) String instituteprice,
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
			SchoolPreview schoolprev = new SchoolPreview();
			
			ArrayList proflist = profprev.getProfileInfo(userid);
			
			ModelAndView mv =  null;
			
			if(institutetype.equalsIgnoreCase("institute")){
				String instituteid = schoolprev.addNewInstitute(institutetype,institutename,institutedesc,instituteadd,currentstatus,instituteprice);
				
				
				mv = new ModelAndView("/CreateInstitute");
				
				mv.addObject("instituteid", instituteid);
				mv.addObject("institutename", institutename);
				mv.addObject("institutedesc", institutedesc);
				mv.addObject("instituteprice", instituteprice);
				mv.addObject("instituteadd", instituteadd);
			}else if(institutetype.equalsIgnoreCase("school")){
				mv = new ModelAndView("/CreateSchool");
			}else if(institutetype.equalsIgnoreCase("college")){
				mv = new ModelAndView("/CreateCollege");
			}
			
			mv.addObject("ProfileImage", profileimageid);
			mv.addObject("Gender", gender);
			mv.addObject("userid", userid);
			mv.addObject("proflist", proflist);
			//mv.addObject("schoolattendlist", schoolattendlist);
			mv.addObject("FullName", userfirstname+" "+userlastname);
			return mv;
		}
	
}