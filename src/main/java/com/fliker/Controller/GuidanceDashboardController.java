package com.fliker.Controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.GuidancePreview;

@Controller
public class GuidanceDashboardController {

	
	//standardguidance
		@RequestMapping("/showDashBoard")
		public ModelAndView showDashBoard(
				@RequestParam(value = "guidanceid", required = false, defaultValue = "World") String guidanceid ) {
			System.out.println("in dashboard social controller");
	 
			HashMap dashboarddata = new HashMap();
			
			
			GuidancePreview guideprev = new GuidancePreview();
			dashboarddata = guideprev.getDashBoardData(guidanceid);
			
			ModelAndView mv;
			mv = new ModelAndView("/GuidanceStandard");
			
			
			
			//mv.addObject("postlist", postlist);
			mv.addObject("dashboarddata", dashboarddata);
			return mv;
		}
		
		
		@RequestMapping("/changeDashBoard")
		public void changeDashBoard(
				@RequestParam(value = "guidanceSubject", required = false, defaultValue = "World") String guidanceSubject ) {
			System.out.println("in dashboard social controller");
	 
			ArrayList dashboarddata = new ArrayList();
			
			
			GuidancePreview guideprev = new GuidancePreview();
			
			
			
		}
		
	
}
