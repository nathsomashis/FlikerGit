package com.fliker.Controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fliker.Modal.AssignmentFilePreview;
import com.fliker.Modal.GuidanceProjectPreview;
import com.fliker.Repository.User;

@Controller
public class GuidanceProjectController {

	@RequestMapping("/guidanceprojectflow")
	public void guidanceprojectflow(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		GuidanceProjectPreview guidpreojprev = new GuidanceProjectPreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		String token = (String)context.getAttribute("RequestToken");
		
		guidpreojprev.saveFile(request.getFileMap(),userid, "Project-Flow",token);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	
	
	@RequestMapping("/guidanceprojectarticle")
	public void guidanceprojectarticle(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		GuidanceProjectPreview guidpreojprev = new GuidanceProjectPreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		String token = (String)context.getAttribute("RequestToken");
		
		guidpreojprev.saveFile(request.getFileMap(),userid, "Project-Doc",token);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	
	
	
}
