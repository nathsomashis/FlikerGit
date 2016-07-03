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
}
