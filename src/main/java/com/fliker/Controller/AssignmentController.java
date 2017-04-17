package com.fliker.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.GuidancePreview;

@Controller
public class AssignmentController {

	@RequestMapping("/createassign")
	public void createQuestionSet(
			@RequestParam(value = "assignquestion", required = false, defaultValue = "World") String assignquestion,
			@RequestParam(value = "assignanswer", required = false, defaultValue = "World") String assignanswer) {
		System.out.println("in dashboard social controller");
 

		
		
		
		GuidancePreview guideprev = new GuidancePreview();
		
		
	}
	
	
}
