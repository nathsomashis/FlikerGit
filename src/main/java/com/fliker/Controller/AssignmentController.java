package com.fliker.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.AssignmentPreview;
import com.fliker.Modal.CoursePreview;
import com.fliker.Modal.GuidancePreview;
import com.fliker.Repository.Courses;

@Controller
public class AssignmentController {

	@RequestMapping("/createassign")
	public void createQuestionSet(
			@RequestParam(value = "assignquestion", required = false, defaultValue = "World") String assignquestion,
			@RequestParam(value = "assignquestiondoc", required = false, defaultValue = "World") String assignquestiondoc,
			@RequestParam(value = "assignanswer", required = false, defaultValue = "World") String assignanswer,
			@RequestParam(value = "assignanswerdoc", required = false, defaultValue = "World") String assignanswerdoc) {
		System.out.println("in dashboard social controller");
 
		String[] answerset = assignanswer.split("A::");
		String[] answerdoc = assignanswerdoc.split("Adoc::");
		String[] questionset = assignquestion.split("Q::");
		String[] questiondoc = assignquestiondoc.split("Qdoc::");
		
		AssignmentPreview assignprev = new AssignmentPreview();
		assignprev.formElement(questionset, questiondoc, answerset, answerdoc);
		
		
		
		
		GuidancePreview guideprev = new GuidancePreview();
		
		
	}
	
	@RequestMapping("/assignmentView")
	public ModelAndView showAssignmentView(
			@RequestParam(value = "assignmentid", required = false, defaultValue = "World") String assignmentid ) {
		System.out.println("in controller");
 
		ArrayList assignmentlist = new ArrayList<Courses>();
		
		
		ModelAndView mv = new ModelAndView("/AssignmentView");
		mv.addObject("assignmentlist", assignmentlist);
		return mv;
	}
	
	
	@RequestMapping("/assignmentAnswer")
	public ModelAndView answerAssignment(
			@RequestParam(value = "assignmentid", required = false, defaultValue = "World") String assignmentid ) {
		System.out.println("in controller");
 
		ArrayList assignmentlist = new ArrayList<Courses>();
		
		
		ModelAndView mv = new ModelAndView("/AssignmentAnswer");
		mv.addObject("assignmentlist", assignmentlist);
		return mv;
	}
	
	
	
	
	
	
	
	
}
