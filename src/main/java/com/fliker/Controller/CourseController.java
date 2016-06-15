package com.fliker.Controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.CoursePreview;
import com.fliker.Repository.Courses;

@Controller
public class CourseController {

	@RequestMapping("/course")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name ) {
		System.out.println("in controller");
 
		ArrayList courselist = new ArrayList<Courses>();
		CoursePreview coursepreview = new CoursePreview();
		/*if(!id.isEmpty()){
			courselist = coursepreview.getCourseList(" ");
		}else{
			courselist = coursepreview.getCourseList(id);
		}*/
		ModelAndView mv = new ModelAndView("/Courses");
		mv.addObject("name", name);
		mv.addObject("courselist", courselist);
		return mv;
	}
	
	
	
	
}
