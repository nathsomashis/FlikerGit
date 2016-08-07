package com.fliker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DailyNotesController {
	
	
	@RequestMapping("/dailynotes")
	public void notifications(@RequestParam(value = "note", required = false, defaultValue = "World") String note){
		
		System.out.println("notes"+note);
		
		
	}

}
