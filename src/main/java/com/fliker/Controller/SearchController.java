package com.fliker.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	
	
	@RequestMapping("/searchresults")
	public ModelAndView searchresult(@RequestParam(value = "name", required = false) String searchparam, HttpSession session){
		
		String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
		ModelAndView mv = new ModelAndView("/Search");
		
		mv.addObject("search", "searchresults");
		return mv;
		
	}
	
	
	@RequestMapping("/contentsearchresults")
	public ModelAndView contentsearch(@RequestParam(value = "name", required = false) String contentsearch,  HttpSession session){
		
		
		ModelAndView mv = new ModelAndView("/Search");
		
		mv.addObject("name", "contentsearchresults");
		return mv;
		
	}
	
	
	@RequestMapping("/searchhistory")
	public ModelAndView searchhistory(@RequestParam(value = "name", required = false) String searchhistoryparam){
		
		
		ModelAndView mv = new ModelAndView("/Search");
		
		mv.addObject("name", "searchhistory");
		return mv;
		
	}

}
