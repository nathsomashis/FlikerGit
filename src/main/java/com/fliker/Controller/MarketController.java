package com.fliker.Controller;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.CoursePreview;
import com.fliker.Modal.ProfilePreview;
import com.fliker.Repository.Courses;
import com.fliker.Repository.User;

@Controller
public class MarketController {

	@RequestMapping("/market")
	public ModelAndView showAllCourses(HttpSession session, HttpServletRequest request) {
		System.out.println("in controller");
 
		ArrayList courselist = new ArrayList<Courses>();
		CoursePreview coursepreview = new CoursePreview();
			
		courselist = coursepreview.getCourseList();
		
		ServletContext context = request.getSession().getServletContext();
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		System.out.println("courselist"+courselist);
		
		ModelAndView mv = new ModelAndView("/Market");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		return mv;
	}
	
	@RequestMapping("/marketcartremoveitem")
	public ModelAndView marketremoveitemfromcart(@RequestParam(value = "itemid", required = false) String itemid,
			HttpSession session, HttpServletRequest request) {
		System.out.println("in controller");
 
		ArrayList courselist = new ArrayList<Courses>();
		CoursePreview coursepreview = new CoursePreview();
			
		courselist = coursepreview.getCourseList();
		
		ServletContext context = request.getSession().getServletContext();
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		System.out.println("courselist"+courselist);
		
		ModelAndView mv = new ModelAndView("/Market");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		return mv;
	}
	
	
}
