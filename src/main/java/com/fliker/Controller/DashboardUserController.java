package com.fliker.Controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Repository.User;


@Controller
public class DashboardUserController {
	
	@RequestMapping("/dashboard")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in dashboard controller");
 
		String username = "";
		
		/*Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof User) {
			  username = ((User)principal).getUsername();
			} else {
			  username = principal.toString();
			}*/
		
		ModelAndView mv;
		mv = new ModelAndView("/Login");
		
		/*if(username.isEmpty()){
			mv = new ModelAndView("/Login");
		}else{
			mv = new ModelAndView("/DashboardSocial");
		}*/
		
		mv.addObject("name", name);
		return mv;
	}
	

}
