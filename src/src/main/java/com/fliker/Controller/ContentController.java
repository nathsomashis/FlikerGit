package com.fliker.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContentController {
	
	@RequestMapping("/createpost")
	public ModelAndView creatPostActivity(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name ) {
		System.out.println("in dashboard social controller");
 
		ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		mv = new ModelAndView("/NewPost");
		
		mv.addObject("postlist", postlist);
		mv.addObject("name", name);
		return mv;
	}
	
	@RequestMapping("/createjob")
	public ModelAndView createJobsActivity(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name ) {
		System.out.println("in dashboard social controller");
 
		ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		mv = new ModelAndView("/NewJob");
		
		mv.addObject("postlist", postlist);
		mv.addObject("name", name);
		return mv;
	}
	
	@RequestMapping("/createcourse")
	public ModelAndView createCourseActivity(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name ) {
		System.out.println("in dashboard social controller");
 
		ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		mv = new ModelAndView("/NewCourse");
		
		mv.addObject("postlist", postlist);
		mv.addObject("name", name);
		return mv;
	}
	
	@RequestMapping("/savecourse")
	public ModelAndView saveCourseActivity(
			MultipartHttpServletRequest request,@RequestParam(value = "File", required = true) MultipartFile files,
			@RequestParam(value = "Course", required = true, defaultValue = "World") String Course , @RequestParam(value = "Coursedescription", required = true ) String Coursedescription,
			@RequestParam(value = "Category" , required = true) String Category,@RequestParam(value = "Sponsers", required=false, defaultValue = "None") String[] Sponsers, 
			@RequestParam(value = "Partners", required = false, defaultValue = "None") String[] Partners) {
		System.out.println("in save course controller");
 
		ArrayList postlist = new ArrayList();
		
		System.out.println(" In the save course");
		
		
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		mv = new ModelAndView("/NewCourse");
		
		mv.addObject("postlist", postlist);
		//mv.addObject("name", name);
		return mv;
	}
	
	@RequestMapping(value = "/uploadPostImage", method = RequestMethod.POST)
	public void upload(@RequestParam("file") MultipartFile file) {
		System.out.println(" upload image");
		
	    /*Map<String, Object> map = Maps.newHashMap();
	    try {
	    BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
	    File destination = new File("C:/Users/XXX/Desktop/Image_files/Image1.png");
	    ImageIO.write(src, "png", destination);
	    } catch(Exception e) {
	        e.printStackTrace();
	    }*/
	    
	}
	
	

}
