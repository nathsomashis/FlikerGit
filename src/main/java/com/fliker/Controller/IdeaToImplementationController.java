package com.fliker.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.ClassRoomPreview;
import com.fliker.Modal.IdeaImplementationPreview;

@Controller
public class IdeaToImplementationController {

	@RequestMapping("/ideatoimplement")
	public ModelAndView showIdeaWorkRoom(
			@RequestParam(value = "name", required = false, defaultValue = "World") String username, HttpSession session ) {
		System.out.println("in classroom controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		mv = new ModelAndView("/IdeaImplement");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("name", username);
		return mv;
	}
	
	
	@RequestMapping("/saveidea")
	public void saveIdeaWorkRoom(
			@RequestParam(value = "ckeditor", required = false, defaultValue = "World") String textsection, HttpSession session, String locatioin,HttpServletRequest request,
			@RequestParam(value = "location", required = false, defaultValue = "World") String location,
			@RequestParam(value = "userid", required = false, defaultValue = "World") String userid) {
		System.out.println("in classroom controller");
		
		String[] filetoupload = new String[3];
 
		IdeaImplementationPreview ideaprev = new IdeaImplementationPreview();
		ideaprev.saveIdeaWork(textsection, userid, filetoupload, location, request);
		
		
	}
	
	
}
