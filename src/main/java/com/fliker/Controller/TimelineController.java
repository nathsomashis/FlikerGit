package com.fliker.Controller;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.ProfilePreview;
import com.fliker.Modal.TimeLinePreview;
import com.fliker.Repository.User;

@Controller
public class TimelineController {

	@RequestMapping("/timeline")
	public ModelAndView showTimeline(
			@RequestParam(value = "lastid", required = false, defaultValue="") String lastid,HttpSession session,HttpServletRequest request ) {
		System.out.println("in dashboard social controller");
 
		ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userids = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userids);
		String userid = (String) session.getAttribute("userid");
		
		TimeLinePreview timelineprev = new TimeLinePreview();
		ArrayList timelines = new ArrayList();
		
		if(lastid.isEmpty()){
			timelines = timelineprev.getTimelinePost();
		}else{
			timelines = timelineprev.getTimelineLaterPost(lastid);
		}
		
		
		
		ModelAndView mv;
		mv = new ModelAndView("/Timeline");
		
		mv.addObject("timelines", timelines);
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		return mv;
	}
}
