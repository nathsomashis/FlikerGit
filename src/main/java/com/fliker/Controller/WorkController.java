package com.fliker.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkController {

	@RequestMapping("/work")
	public ModelAndView showWork(
			@RequestParam(value = "name", required = false, defaultValue = "World") String username, HttpSession session ) {
		System.out.println("in classroom controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		
		
		
		
		mv = new ModelAndView("/WorkScreen");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("name", username);
		return mv;
	}
	
	@RequestMapping("/workValidate")
	public ModelAndView workValidate(
			@RequestParam(value = "name", required = false, defaultValue = "World") String username, HttpSession session ) {
		System.out.println("in classroom controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		
		
		
		
		mv = new ModelAndView("/WorkProvider");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("name", username);
		return mv;
	}
	
		
	
}
