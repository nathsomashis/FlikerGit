package com.fliker.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.ClassRoomPreview;

@Controller
public class IdeaToImplementationController {

	@RequestMapping("/ideatoimplement")
	public ModelAndView showClassRoom(
			@RequestParam(value = "name", required = false, defaultValue = "World") String username, HttpSession session ) {
		System.out.println("in classroom controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		
		
		
		
		mv = new ModelAndView("/Project");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("name", username);
		return mv;
	}
	
	
}
