package com.fliker.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fliker.Modal.LoginReview;
import com.fliker.Modal.RegisterPreview;

@Controller
public class RegisterController {

	@RequestMapping("/register")
	public ModelAndView login(@RequestParam(value = "email", required = true) String email,@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "firstname", required = true) String firstname,@RequestParam(value = "lastname", required = true) String lastname,@RequestParam(value = "gender", required = true) String gender,
			@RequestParam(value = "request", required = true) String request,@RequestParam(value = "subscription", required = true) String subscription,@RequestParam(value = "terms", required = true) String terms,
			RedirectAttributes redirectAttributes){
		
		//username='+emailid+'&password='+passwordid+'&firstname'+firstname+'&gender'+gender+'&request'+request+'&subscription'+subscription+'&terms'+terms
		
		System.out.println("In the register Controller");
		
		
		RegisterPreview regprev = new RegisterPreview();
		
		String returnUserid = regprev.registerUser(email, username, password, firstname, lastname, gender, request, subscription, terms);
		
		System.out.println("return userid"+returnUserid);
		ModelMap model = new ModelMap();
		model.addAttribute("useridnew", returnUserid);
		ModelAndView mv=new ModelAndView("redirect:/activationuserid",model);
		mv.addObject("useridnew", returnUserid);
		return mv;
	}
	
	@RequestMapping(value="/validateemail",method = RequestMethod.GET)
	public String login(@RequestParam(value = "email", required = true) String email){
		
		String message = "";
		RegisterPreview regprev = new RegisterPreview();
		message = regprev.validateUser(email);
		
		return message;
	}
	
}
