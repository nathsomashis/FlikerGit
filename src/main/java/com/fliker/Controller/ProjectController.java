package com.fliker.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {

	
	@RequestMapping("/projectview")
	public ModelAndView showProject(
			@RequestParam(value = "name", required = false, defaultValue = "World") String username, HttpSession session ) {
		System.out.println("in classroom controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		
		
		
		
		mv = new ModelAndView("/ProjectInfo");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("name", username);
		return mv;
	}
	
	
	@RequestMapping("/projectcalendar")
	public ModelAndView showProjectCalendar(
			@RequestParam(value = "name", required = false, defaultValue = "World") String username, HttpSession session ) {
		System.out.println("in classroom controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		
		
		
		
		mv = new ModelAndView("/ProjectCalendar");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("name", username);
		return mv;
	}
	
	
	@RequestMapping("/projectblog")
	public ModelAndView showProjectDiscussion(
			@RequestParam(value = "name", required = false, defaultValue = "World") String username, HttpSession session ) {
		System.out.println("in classroom controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		
		
		
		
		mv = new ModelAndView("/ProjectBlog");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("name", username);
		return mv;
	}
	
	
	@RequestMapping("/projectblogtopic")
	public ModelAndView showProjectDiscussionTopic(
			@RequestParam(value = "name", required = false, defaultValue = "World") String username, HttpSession session ) {
		System.out.println("in classroom controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		
		
		
		
		mv = new ModelAndView("/ProjectTopic");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("name", username);
		return mv;
	}
	
	
	@RequestMapping("/projectblogpost")
	public ModelAndView showProjectDiscussionPost(
			@RequestParam(value = "name", required = false, defaultValue = "World") String username, HttpSession session ) {
		System.out.println("in classroom controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		
		
		
		
		mv = new ModelAndView("/ProjectTopicPost");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("name", username);
		return mv;
	}
	
	
	@RequestMapping("/projecttimeline")
	public ModelAndView showProjectTimeline(
			@RequestParam(value = "name", required = false, defaultValue = "World") String username, HttpSession session ) {
		System.out.println("in classroom controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		
		
		
		
		mv = new ModelAndView("/ProjectTimeLine");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("name", username);
		return mv;
	}
	
	
	@RequestMapping("/projectdrive")
	public ModelAndView showProjectDrive(
			@RequestParam(value = "name", required = false, defaultValue = "World") String username, HttpSession session ) {
		System.out.println("in classroom controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		
		
		
		
		mv = new ModelAndView("/ProjectSharedDrive");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("name", username);
		return mv;
	}
	
	
	@RequestMapping("/projectplanning")
	public ModelAndView showProjectPlanning(
			@RequestParam(value = "name", required = false, defaultValue = "World") String username, HttpSession session ) {
		System.out.println("in classroom controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		
		
		
		
		mv = new ModelAndView("/ProjectPlanning");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("name", username);
		return mv;
	}
	
	
	@RequestMapping("/projectstructure")
	public ModelAndView showProjectStructure(
			@RequestParam(value = "name", required = false, defaultValue = "World") String username, HttpSession session ) {
		System.out.println("in classroom controller");
 
		//ArrayList postlist = new ArrayList();
		
		/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist(lastid);*/
		
		ModelAndView mv;
		
		
		
		
		mv = new ModelAndView("/ProjectStructure");
		
		
		
		//mv.addObject("postlist", postlist);
		mv.addObject("name", username);
		return mv;
	}
	
	
}
