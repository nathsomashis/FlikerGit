package com.fliker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuidanceController {

	//standardguidance
	@RequestMapping("/standardguidance")
	public ModelAndView showGuidance(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name ) {
		System.out.println("in dashboard social controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		mv = new ModelAndView("/GuidanceStandard");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("name", name);
		return mv;
	}
	
}
