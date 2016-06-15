package com.fliker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.LoginReview;

@Controller
public class RegisterController {

	@RequestMapping("/register")
	public ModelAndView login(@RequestParam(value = "name", required = false, defaultValue = "World") String name, @PathVariable("username") String username, @PathVariable("password") String password){
		
		System.out.println("In the register Controller");
		
		
	  
		ModelAndView mv = new ModelAndView("/Confirm");
		
		return mv;
	}
	
}
