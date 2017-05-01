package com.fliker.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fliker.Modal.GuidancePreview;

@Controller
public class GuidanceExersizeController {

	//student apply for guidance
		@RequestMapping("/createAssignment")
		public void createAssignment(
				@RequestParam(value = "assignmentSets", required = false, defaultValue = "World") String assignmentSets,
				@RequestParam(value = "userid", required = false, defaultValue = "World") String userid,HttpServletRequest request
				) {
			System.out.println("in dashboard social controller");
	 
			
			
			GuidancePreview guidanceprev = new GuidancePreview();
			
			
		}
	
	
}
