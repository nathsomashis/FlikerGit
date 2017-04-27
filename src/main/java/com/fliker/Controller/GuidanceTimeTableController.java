package com.fliker.Controller;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.GuidancePreview;
import com.fliker.Modal.ProfilePreview;
import com.fliker.Repository.Timetable;
import com.fliker.Repository.User;

@Controller
public class GuidanceTimeTableController {

	
	//standardguidance
		@RequestMapping("/guidancetimetable")
		public ModelAndView showGuidanceTimeTable(HttpServletRequest request) {
			System.out.println("in dashboard social controller");
	 
			ArrayList timetablesearch = new ArrayList();
			
			ServletContext context = request.getSession().getServletContext();
			
			User userinf = (User) context.getAttribute("UserValues");
			String userid = userinf.getUserid();
			String userfirstname = userinf.getFirstname();
			String userlastname = userinf.getLastname();
			String gender = userinf.getGender();
			
			ProfilePreview profprev = new ProfilePreview();
			
			String profileimageid = profprev.profileimage(userid);
			
			
			Timetable timetableinf = (Timetable)context.getAttribute("TimeTable");
			
			String timetableid = timetableinf.getTimeableid();
			
			GuidancePreview guideprev = new GuidancePreview();
			timetablesearch = guideprev.getGuidanceTimeTable(timetableid);
			
			ModelAndView mv;
			mv = new ModelAndView("/GuidanceStandard");
			
			
			
			//mv.addObject("postlist", postlist);
			return mv;
		}
	
}
