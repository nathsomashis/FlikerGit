package com.fliker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {

	@RequestMapping("/tasklists")
	public ModelAndView tasklists(@RequestParam(value = "name", required = false, defaultValue = "World") String name){
		
		
		ModelAndView mv = new ModelAndView("/TaskList");
		
		mv.addObject("name", name);
		return mv;
		
	}
	
}
