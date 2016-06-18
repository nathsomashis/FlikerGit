package com.fliker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.LoginReview;
import com.fliker.Modal.RegisterPreview;

@Controller
public class RegisterController {

	@RequestMapping("/register")
	public ModelAndView login(@RequestParam(value = "email", required = true) String email,@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "firstname", required = true) String firstname,@RequestParam(value = "lastname", required = true) String lastname,@RequestParam(value = "gender", required = true) String gender,
			@RequestParam(value = "request", required = true) String request,@RequestParam(value = "subscription", required = true) String subscription,@RequestParam(value = "terms", required = true) String terms){
		
		//username='+emailid+'&password='+passwordid+'&firstname'+firstname+'&gender'+gender+'&request'+request+'&subscription'+subscription+'&terms'+terms
		
		System.out.println("In the register Controller");
		
		
		/*RegisterPreview regprev = new RegisterPreview();
		regprev.registerUser(email, username, password, firstname, lastname, gender, request, subscription, terms);*/
		
	  
		ModelAndView mv = new ModelAndView("/Confirm");
		
		return mv;
	}
	
}
