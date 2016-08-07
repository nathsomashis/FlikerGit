package com.fliker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrganizationController {

	@RequestMapping("/organizations")
	public ModelAndView organizationlist(){
		
		
		ModelAndView mv = new ModelAndView("/OrganizationList");
		
		//mv.addObject("name", name);
		return mv;
		
	}
	
	
	@RequestMapping("/neworganizations")
	public ModelAndView neworganizationlist(){
		
		
		ModelAndView mv = new ModelAndView("/NewOrganization");
		
		//mv.addObject("name", name);
		return mv;
		
	}
	
}
