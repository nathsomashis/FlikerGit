package com.fliker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyController {

	@RequestMapping("/companies")
	public ModelAndView notifications(){
		
		
		ModelAndView mv = new ModelAndView("/CompanyList");
		
		//mv.addObject("name", name);
		return mv;
		
	}
	
}
