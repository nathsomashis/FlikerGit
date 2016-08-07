package com.fliker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpecializationController {

	@RequestMapping("/newspecialization")
	public ModelAndView newSpecialization(){
		
		
		ModelAndView mv = new ModelAndView("/NewSpecialization");
		
		//mv.addObject("name", name);
		return mv;
		
	}
}
