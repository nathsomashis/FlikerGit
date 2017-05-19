package com.fliker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OSMController {

	@RequestMapping("/osmprojectinfo")
	public ModelAndView osmProjectInfo(
			@RequestParam(value = "owner", required = false, defaultValue = "World") String ownerid ) {
		System.out.println("in controller");
		
		
		
		
		ModelAndView mv = new ModelAndView("/OSMProjectList");
		return mv;
	}
	
	@RequestMapping("/osmprojectinfonew")
	public ModelAndView osmcreateProjectInfo(
			@RequestParam(value = "owner", required = false, defaultValue = "World") String ownerid ) {
		System.out.println("in controller");
		
		
		
		
		ModelAndView mv = new ModelAndView("/OSMCreateProjectInfo");
		return mv;
	}
	
	
}
