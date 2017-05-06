package com.fliker.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.AssignmentFilePreview;
import com.fliker.Modal.GuidancePreview;
import com.fliker.Modal.GuidanceProjectPreview;

@Controller
public class GuidanceExersizeController {

	//student apply for guidance
		@RequestMapping("/createAssignment")
		public ModelAndView createAssignment(
				@RequestParam(value = "assignmentSets", required = false, defaultValue = "World") String assignmentSets,
				@RequestParam(value = "userid", required = false, defaultValue = "World") String userid,HttpServletRequest request,
				@RequestParam(value = "tokenid", required = false, defaultValue = "World") String tokenid,
				@RequestParam(value = "startdate", required = false, defaultValue = "World") String startdate,
				@RequestParam(value = "enddate", required = false, defaultValue = "World") String enddate
				) {
			System.out.println("in dashboard social controller");
	 
			AssignmentFilePreview assignprev = new AssignmentFilePreview();
			//IdentityHashMap< String, HashMap<String,LinkedList<String>>> assignmentsect = assignprev.requestobjectmap ;
			
			ArrayList assignmentList = new ArrayList();
			
			DateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat targetFormat = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
			Date datestart = new Date();
			Date dateend = new Date();
			try {
				datestart = originalFormat.parse(startdate);
				dateend = originalFormat.parse(enddate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			startdate = targetFormat.format(datestart); 
			enddate = targetFormat.format(dateend); 
			
			
			assignmentList = assignprev.saveAssignments(assignmentSets,tokenid,userid,startdate,enddate);
			
			
			GuidancePreview guidanceprev = new GuidancePreview();
			
			assignmentList = assignprev.retrieveAssignments("");//need to get the assignment id.
			
			
			ModelAndView mv = new ModelAndView("/AssignmentAnswer");
			mv.addObject("assignmentList", assignmentList);
			return mv;
			
			
		}
		
		
		@RequestMapping("/submitAssignment")
		public void submitAssignment(
				@RequestParam(value = "assignmentSets", required = false, defaultValue = "World") String assignmentSets,
				@RequestParam(value = "userid", required = false, defaultValue = "World") String userid,HttpServletRequest request,
				@RequestParam(value = "tokenid", required = false, defaultValue = "World") String tokenid
				) {
			System.out.println("in dashboard social controller");
	 
			AssignmentFilePreview assignprev = new AssignmentFilePreview();
			//IdentityHashMap< String, HashMap<String,LinkedList<String>>> assignmentsect = assignprev.requestobjectmap ;
			
			ArrayList assignmentList = new ArrayList();
			
			assignmentList = assignprev.answerAssignments(assignmentSets,tokenid,userid);
			
			
			GuidancePreview guidanceprev = new GuidancePreview();
			
			
		}
		
		
		@RequestMapping("/saveAssignment")
		public void saveAssignment(
				@RequestParam(value = "assignmentSets", required = false, defaultValue = "World") String assignmentSets,
				@RequestParam(value = "userid", required = false, defaultValue = "World") String userid,HttpServletRequest request,
				@RequestParam(value = "tokenid", required = false, defaultValue = "World") String tokenid,
				@RequestParam(value = "assignmentid", required = false, defaultValue = "World") String assignmentid
				) {
			System.out.println("in dashboard social controller");
	 
			AssignmentFilePreview assignprev = new AssignmentFilePreview();
			//IdentityHashMap< String, HashMap<String,LinkedList<String>>> assignmentsect = assignprev.requestobjectmap ;
			
			ArrayList assignmentList = new ArrayList();
			
			assignmentList = assignprev.saveQuestionAssignments(assignmentSets,tokenid,userid,assignmentid);
			
			
			GuidancePreview guidanceprev = new GuidancePreview();
			
			
		}
		
		
		@RequestMapping("/retrieveAssignment")
		public ModelAndView getAllAssignments(
				@RequestParam(value = "assignmentid", required = false, defaultValue = "World") String assignmentid,
				@RequestParam(value = "userid", required = false, defaultValue = "World") String userid,HttpServletRequest request,
				@RequestParam(value = "tokenid", required = false, defaultValue = "World") String tokenid
				) {
			System.out.println("in dashboard social controller");
	 
			AssignmentFilePreview assignprev = new AssignmentFilePreview();
			//IdentityHashMap< String, HashMap<String,LinkedList<String>>> assignmentsect = assignprev.requestobjectmap ;
			
			ArrayList assignmentList = new ArrayList();
			
			assignmentList = assignprev.retrieveAssignments(assignmentid);
			
			
			GuidancePreview guidanceprev = new GuidancePreview();
			
			
			ModelAndView mv = new ModelAndView("/AssignmentAnswer");
			mv.addObject("assignmentList", assignmentList);
			return mv;
			
			
		}
		
		
		@RequestMapping("/createProjectpaper")
		public void createProjectPaper(
				@RequestParam(value = "projectname", required = false, defaultValue = "World") String projectname,
				@RequestParam(value = "projectdescription", required = false, defaultValue = "World") String projectdescription,
				@RequestParam(value = "userid", required = false, defaultValue = "World") String userid,HttpServletRequest request,
				@RequestParam(value = "tokenid", required = false, defaultValue = "World") String tokenid
				
				
				) {
			System.out.println("in dashboard social controller");
	 
			//IdentityHashMap< String, HashMap<String,LinkedList<String>>> assignmentsect = assignprev.requestobjectmap ;
			
			GuidanceProjectPreview guidprojprev = new GuidanceProjectPreview();
			//String[] projectlink = projectlinks.split(",");
			
			ArrayList assignmentList = new ArrayList();
			
			//assignmentList = assignprev.retrieveAssignments(assignmentid);
			guidprojprev.createProjectPaper(projectname, projectdescription, tokenid);
			
			GuidancePreview guidanceprev = new GuidancePreview();
			
			
			/*ModelAndView mv = new ModelAndView("/AssignmentAnswer");
			mv.addObject("assignmentList", assignmentList);
			return mv;*/
			
			
		}
	
}
