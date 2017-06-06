package com.fliker.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fliker.Utility.ActivationUtility;

@Controller
public class ActivationController {

	
	@RequestMapping("/activationuserid")
	public ModelAndView chatmessages(@RequestParam(value = "email", required = false, defaultValue = "World") String email,
			@RequestParam(value = "useridnew", required = false, defaultValue = "World") String userid){
		
		
		ModelAndView mv = new ModelAndView("/Confirm");
		
		String newuserid = (String) mv.getModel().get("useridnew");
		System.out.println(newuserid);
		
		ModelMap model = new ModelMap();
		String newuser = (String) model.get("useridnew");
		
		System.out.println(userid);
		
		ActivationUtility activutil = new ActivationUtility();
		activutil.createActivationLink(userid,email);
		
		
		return mv;
		
	}
	
	
}
