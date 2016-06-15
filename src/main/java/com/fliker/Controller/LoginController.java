package com.fliker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	///{username}/{password}
	
	@RequestMapping("/login")
	public String login(@RequestParam(value = "name", required = false, defaultValue = "World") String name){
		
		System.out.println("In the Login Controller");
		
		/*LoginReview loginreview = new LoginReview();
		String message = loginreview.validateUser(username, password);*/
	  
		
		return "forward:/dashboardsocial";
		
	}
	
	/*@RequestMapping("/registeruser")
	public ModelAndView registeruser(@RequestParam(value = "name", required = false, defaultValue = "World") String name){
		
		System.out.println("In the Login register Controller");
		
		LoginReview loginreview = new LoginReview();
		String message = loginreview.validateUser(username, password);
	  
		ModelAndView mv = new ModelAndView("/Register");
		
		if(username.isEmpty()){
			mv = new ModelAndView("/Login");
		}else{
			mv = new ModelAndView("/DashboardSocial");
		}
		
		mv.addObject("name", name);
		return mv;
		
		//return "";
	}*/

}
