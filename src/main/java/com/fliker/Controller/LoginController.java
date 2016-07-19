package com.fliker.Controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.DashboardSocialPreview;
import com.fliker.Modal.LoggingReview;
import com.fliker.Modal.LoginReview;

@Controller
@SessionAttributes("userid")
public class LoginController {
	
	///{username}/{password}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value = "email", required = true) String username,
			@RequestParam(value = "password", required = true) String password, HttpSession session){
		
		System.out.println("In the Login Controller");
		
		LoginReview loginreview = new LoginReview();
		String message = loginreview.validateUser(username, password);
	  
		ModelAndView mv = null;
		
		if(message.equalsIgnoreCase("The username is not valid")){
			mv = new ModelAndView("/Login");
		}else if(message.equalsIgnoreCase("The password doesn't match")){
			mv = new ModelAndView("/Login");
		}else {
			mv = new ModelAndView("/DashboardSocial");
			
			mv.addObject("userid", message);
			session.setAttribute("userid", message);
			
			DashboardSocialPreview dashprev = new DashboardSocialPreview();
			ArrayList postlist = dashprev.firstpostlist();
			mv.addObject("postlist", postlist);
			
			LoggingReview logrev = new LoggingReview();
			logrev.entryLogging(message);
		}
	  
		
		return mv;
		
	}
	
	@RequestMapping("/registeruser")
	public ModelAndView registeruser(@RequestParam(value = "name", required = false, defaultValue = "World") String name){
		
		System.out.println("In the Login register Controller");
		
		ModelAndView mv = new ModelAndView("/Register");
		
		mv.addObject("name", name);
		return mv;
		
	}
	
	
	@RequestMapping("/generatecode")
	public @ResponseBody String getMessage(@RequestParam(value = "phonenumber", required = false, defaultValue = "World") String phonenumber){
		
		
		try {
		String recipient = "+8095460568";
        String message = " Greetings from Mr. Gupta! Have a nice day!";
        String username = "admin";
        String password = "abc123";
        String originator = "+8095460568";

        String requestUrl  = "http://127.0.0.1:9501/api?action=sendmessage&" +
        					 "username=" + URLEncoder.encode(username, "UTF-8") +
        					 "&password=" + URLEncoder.encode(password, "UTF-8") +
        					 "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
        					 "&messagetype=SMS:TEXT" +
        					 "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
        					 "&originator=" + URLEncoder.encode(originator, "UTF-8") +
        					 "&serviceprovider=GSMModem1" +
        					 "&responseformat=html";



        URL url = new URL(requestUrl);
        HttpURLConnection uc = (HttpURLConnection)url.openConnection();

        System.out.println(uc.getResponseMessage());

        uc.disconnect();

		} catch(Exception ex) {
		        System.out.println(ex.getMessage());
		
		}
		
		System.out.println("In the Login Controller");
		
		/*LoginReview loginreview = new LoginReview();
		String message = loginreview.validateUser(username, password);*/
	  
		
		return "forward:/dashboardsocial";
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(){
		
		System.out.println("In the logout Controller");
		
		ModelAndView mv = new ModelAndView("/Login");
		
		return mv;
		
	}
	
	@RequestMapping("/forgotpassword")
	public ModelAndView forgetpassword(@RequestParam(value = "name", required = false, defaultValue = "World") String name){
		
		System.out.println("In the Login register Controller");
		
		ModelAndView mv = new ModelAndView("/ForgetPassword");
		
		mv.addObject("name", name);
		return mv;
		
	}
	
	@RequestMapping("/resetpassword")
	public ModelAndView resetpassword(@RequestParam(value = "name", required = false, defaultValue = "World") String name){
		
		System.out.println("In the Login register Controller");
		
		ModelAndView mv = new ModelAndView("/Confirm");
		
		mv.addObject("name", name);
		return mv;
		
	}
	

}
