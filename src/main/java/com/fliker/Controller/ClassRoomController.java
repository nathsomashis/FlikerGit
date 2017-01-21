package com.fliker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.ClassRoomPreview;

@Controller
public class ClassRoomController {

	
	@RequestMapping("/classroom")
	public ModelAndView showClassRoom(
			@RequestParam(value = "name", required = false, defaultValue = "World") String username ) {
		System.out.println("in classroom controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		
		ClassRoomPreview classprev = new ClassRoomPreview();
		
		String havingclassroom = classprev.pageProm();
		havingclassroom = "/"+havingclassroom;
		mv = new ModelAndView(havingclassroom);
		
		
		//mv = new ModelAndView("/GuidanceStandard");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("name", username);
		return mv;
	}
	
	
	@RequestMapping("/createclassroom")
	public ModelAndView createClassroom(
			@RequestParam(value = "classname", required = false, defaultValue = "World") String classname,
			@RequestParam(value = "democlassid", required = false, defaultValue = "World") String democlassid) {
		System.out.println("in classroom controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		
		ClassRoomPreview classprev = new ClassRoomPreview();
		classprev.createClassRoom();
		
		mv = new ModelAndView("/ClassRoomOnly");
		
		
		//mv = new ModelAndView("/GuidanceStandard");
		
		
		
		//mv.addObject("postlist", postlist);
		//mv.addObject("name", username);
		return mv;
	}
	
	
	
	
	
}
