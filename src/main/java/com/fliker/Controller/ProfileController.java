package com.fliker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

	@RequestMapping("/profile")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name ) {
		System.out.println("in profile controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		mv = new ModelAndView("/Profile");
		
		//mv.addObject("postlist", postlist);
		mv.addObject("name", name);
		return mv;
	}
}
