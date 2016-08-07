package com.fliker.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.JobsPreview;
import com.fliker.Repository.Jobs;

@Controller
public class JobsController {

	@RequestMapping("/jobs")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");
 
		ModelAndView mv = new ModelAndView("/Jobs");
		mv.addObject("name", name);
		return mv;
	}
	
	
	@ResponseBody()
	@RequestMapping(value = "/jobs/getJobsList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSearchResultViaAjax() {
		
		
		StringBuffer jobbufferresult = new StringBuffer();
		
		JobsPreview jobpreview = new JobsPreview();
		
		ArrayList joblist = new ArrayList();
		joblist = jobpreview.getJobsList();
		
		jobbufferresult.append("{"+"\"data\": [");
		
		for(int i=0;i<joblist.size();i++){
			
			
			Jobs job = (Jobs) joblist.get(i);
			HashMap jobpercentile = job.getJobPercentage();
			
			String jobentry = "";
			String jobcleared = "";
			
			Set jobset = jobpercentile.entrySet();
			Iterator jobit = jobset.iterator();
			while(jobit.hasNext()){
				Map.Entry jobme = (Map.Entry)jobit.next();
				jobentry = jobentry+jobme.getKey()+",";
				jobcleared = jobcleared + jobme.getValue()+",";
			}
			
			int lasttrunc = jobentry.lastIndexOf(",");
			int lasttrunc2 = jobcleared.lastIndexOf(",");
			jobentry = jobentry.substring(0, lasttrunc);
			jobcleared = jobcleared.substring(0, lasttrunc2);
			
			
			String result = "{"+
					"\"name\": \""+job.getJobTitle()+"<br><small class='text-muted'><i>Budget: 5,000<i></small>\""+","+
					"\"est\": \"<td><div class='progress progress-xs' data-progressbar-value='"+job.getJobProgress()+"'><div class='progress-bar'></div></div></td>\""+","+
			        "\"contacts\": \"<div class='project-members'><a href='javascript:void(0)'><img src='img/avatars/male.png' class='offline' alt='user'></a> </div> \""+","+
			        "\"status\": \"<span class='label label-success'>"+job.isJobActivation()+"</span>\""+","+
			        "\"target-actual\": \"<span style='margin-top:5px' class='sparkline display-inline' data-sparkline-type='compositebar' data-sparkline-height='18px' data-sparkline-barcolor='#aafaaf' data-sparkline-line-width='2.5' data-sparkline-line-val='["+jobentry+"]' data-sparkline-bar-val='["+jobcleared+"]'></span>\""+","+
			        "\"actual\": \"<span class='sparkline text-align-center' data-sparkline-type='line' data-sparkline-width='100%' data-sparkline-height='25px'>20,-35,70</span>\""+","+
			        "\"tracker\": \"<span class='onoffswitch'><input type='checkbox' name='start_interval' class='onoffswitch-checkbox' onchange='setTracker' id='st1"+job.getJobid()+"' checked='checked'><label class='onoffswitch-label' for='st1'><span class='onoffswitch-inner' data-swchon-text='ON' data-swchoff-text='OFF'></span><span class='onoffswitch-switch'></span></label></span>\""+","+
			        "\"starts\": \""+job.getJobStartDate()+"\""+","+
			        "\"ends\": \"<strong>"+job.getJobEndDate()+"</strong>\""+","+
			        "\"comments\": \""+job.getJobProjectDescription()+"\""+","+
			        "\"action\": \"<button onclick='jobApply()' id='"+job.getJobid()+"' class='btn btn-xs'>Apply</button> <button class='btn btn-xs btn-danger pull-right' style='margin-left:5px'>Unfollow</button> <button class='btn btn-xs btn-success pull-right'>Share</button> \""+
					"}"; 
			jobbufferresult.append(result);
		}

		jobbufferresult.append("]"+"}");
		System.out.println("In the jobcontroller");
		/*String result = "{"+"\"data\": ["+"{"+
		"\"name\": \"Sharepoint Upgrade<br><small class='text-muted'><i>Budget: 5,000<i></small>\""+","+
		"\"est\": \"<td><div class='progress progress-xs' data-progressbar-value='100'><div class='progress-bar'></div></div></td>\""+","+
        "\"contacts\": \"<div class='project-members'><a href='javascript:void(0)'><img src='img/avatars/male.png' class='offline' alt='user'></a> </div> \""+","+
        "\"status\": \"<span class='label label-success'>ACTIVE</span>\""+","+
        "\"target-actual\": \"<span style='margin-top:5px' class='sparkline display-inline' data-sparkline-type='compositebar' data-sparkline-height='18px' data-sparkline-barcolor='#aafaaf' data-sparkline-line-width='2.5' data-sparkline-line-val='[6,4,7,8,47,9,9,8,3,2,2,5,6,7,4,1,5,7,6]' data-sparkline-bar-val='[6,4,7,8,47,9,9,8,3,2,2,5,6,7,9,9,5,7,6]'></span>\""+","+
        "\"actual\": \"<span class='sparkline text-align-center' data-sparkline-type='line' data-sparkline-width='100%' data-sparkline-height='25px'>20,-35,70</span>\""+","+
        "\"tracker\": \"<span class='onoffswitch'><input type='checkbox' name='start_interval' class='onoffswitch-checkbox' id='st1' checked='checked'><label class='onoffswitch-label' for='st1'><span class='onoffswitch-inner' data-swchon-text='ON' data-swchoff-text='OFF'></span><span class='onoffswitch-switch'></span></label></span>\""+","+
        "\"starts\": \"01-21-2013\""+","+
        "\"ends\": \"<strong>02-30-2018</strong>\""+","+
        "\"comments\": \"This is a blank comments area, used to add comments and keep notes\""+","+
        "\"action\": \"<button class='btn btn-xs'>Open case</button> <button class='btn btn-xs btn-danger pull-right' style='margin-left:5px'>Delete Record</button> <button class='btn btn-xs btn-success pull-right'>Save Changes</button> \""+
		"}"+
		"]"+"}";    */
		return jobbufferresult.toString();

	}
	
	
	@ResponseBody()
	@RequestMapping(value = "/jobs/setTracker/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String setTracker(@PathVariable("id") String id){
		
		String returnresult = "";
		Jobs jobs = new Jobs();
		JobsPreview jobpreview = new JobsPreview();
		/*jobs = jobpreview.searchId(id);
		if(!jobs.isJobTrack()){
			returnresult = jobpreview.setTracker(id, true);
		}else {
			returnresult = jobpreview.setTracker(id, false);
		}*/
		return returnresult;
	}
	
	@ResponseBody()
	@RequestMapping(value = "/jobs/jobApply/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void jobApply(@PathVariable("id") String id){
		
	}
	
}
