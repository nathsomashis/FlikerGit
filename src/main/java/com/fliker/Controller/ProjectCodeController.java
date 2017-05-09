package com.fliker.Controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.AssignmentFilePreview;
import com.fliker.Repository.User;
import com.fliker.Utility.ActivationUtility;

@Controller
public class ProjectCodeController {

	
	
	@RequestMapping("/uploadNewCode")
	public ModelAndView uploadnewCode(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		String token = (String)context.getAttribute("RequestToken");
		
		
		
		
		
		
		ModelAndView mv = new ModelAndView("/AssignmentView");
		return mv;

	}
	
	
	@RequestMapping("/createNewBranch")
	public void createNewBranch(@RequestParam(value = "branchfromversion", required = false, defaultValue = "World") String branchfromversion,HttpServletRequest request) {
		System.out.println("in file controller");

		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		String token = (String)context.getAttribute("RequestToken");
		
		
		
		/*ModelAndView mv = new ModelAndView("/AssignmentView");
		return mv;*/

	}
	
	
	@RequestMapping("/mergeBranch")
	public void mergeBranch(@RequestParam(value = "branchfromversion", required = false, defaultValue = "World") String branchfromversion,
			@RequestParam(value = "mainversion", required = false, defaultValue = "World") String mainversion,HttpServletRequest request) {
		System.out.println("in file controller");

		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		String token = (String)context.getAttribute("RequestToken");
		
		
		
		/*ModelAndView mv = new ModelAndView("/AssignmentView");
		return mv;*/

	}
	
	
	@RequestMapping("/updateFile")
	public ModelAndView updateFile(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		String token = (String)context.getAttribute("RequestToken");
		
		
		
		ModelAndView mv = new ModelAndView("/AssignmentView");
		return mv;

	}
	
	
	@RequestMapping("/replaceOldCode")
	public ModelAndView replaceOldCode(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		String token = (String)context.getAttribute("RequestToken");
		
		
		
		ModelAndView mv = new ModelAndView("/AssignmentView");
		return mv;

	}
	
	
	
	
}
