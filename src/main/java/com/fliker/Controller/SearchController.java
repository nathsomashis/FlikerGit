package com.fliker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	
	
	@RequestMapping("/searchresults")
	public ModelAndView notifications(@RequestParam(value = "name", required = false, defaultValue = "World") String name){
		
		
		ModelAndView mv = new ModelAndView("/Search");
		
		mv.addObject("name", name);
		return mv;
		
	}

}
