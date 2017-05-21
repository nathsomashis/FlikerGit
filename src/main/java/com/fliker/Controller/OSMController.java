package com.fliker.Controller;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.OSMPreview;
import com.fliker.Modal.ProfilePreview;
import com.fliker.Repository.User;

@Controller
public class OSMController {

	@RequestMapping("/osmprojectinfo")
	public ModelAndView osmProjectInfo(
			@RequestParam(value = "owner", required = false, defaultValue = "World") String ownerid,
			HttpServletRequest request) {
		System.out.println("in controller");
		
		ArrayList osmprojlist = new ArrayList();
		OSMPreview osmprev = new OSMPreview();
		osmprojlist = osmprev.getProjectInfoList();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		ModelAndView mv = new ModelAndView("/OSMProjectList");
		mv.addObject("osmprojectlist", osmprojlist);
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		return mv;
	}
	
	@RequestMapping("/osmprojectinfonew")
	public ModelAndView osmcreateProjectInfo(
			@RequestParam(value = "projectdescription", required = false, defaultValue = "World") String projectdescription,
			@RequestParam(value = "projectname", required = false, defaultValue = "World") String projectname,
			@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid,
			@RequestParam(value = "companyid", required = false, defaultValue = "World") String companyid,
			@RequestParam(value = "osmpartnerid", required = false, defaultValue = "World") String osmpartners,
			@RequestParam(value = "osmbackupid", required = false, defaultValue = "World") String osmbackupcompany,
			@RequestParam(value = "osmdependependid", required = false, defaultValue = "World") String osmdependependid,
			@RequestParam(value = "projectinvestors", required = false, defaultValue = "World") String projectinvestors,
			@RequestParam(value = "projectbuyers", required = false, defaultValue = "World") String projectbuyers,
			@RequestParam(value = "location", required = false) String location) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		String osmid = osmprev.createNewProjectInfo(projectdescription,projectname, ownerid,companyid,projectinvestors,projectbuyers,osmpartners, osmbackupcompany, osmdependependid, location);
		
		
		ModelAndView mv = new ModelAndView("/OSMCreateProjectInfoNext");
		mv.addObject("osmid", osmid);
		return mv;
	}
	
	@RequestMapping("/osmprojectinfonext")
	public ModelAndView osmprojectinfolink(
			@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		ArrayList existingprojects = new ArrayList();
		existingprojects = osmprev.getAllExistingOSMModels(ownerid);
		
		ModelAndView mv = new ModelAndView("/OSMCreateProjectInfo");
		mv.addObject("existingproject", existingprojects);
		return mv;
	}
	
	
	@RequestMapping("/osmprojectinfodocsave")
	public ModelAndView osmprojectdoclink(
			@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid,
			HttpServletRequest requests) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		ArrayList existingprojectsdoc = new ArrayList();
		ServletContext context = requests.getSession().getServletContext();
		String token = (String)context.getAttribute("osmid");
		osmprev.saveExistingOSMModelsDoc(token,ownerid);
		
		ModelAndView mv = new ModelAndView("/OSMProjectList");
		//mv.addObject("existingprojectsdoc", existingprojectsdoc);
		return mv;
	}
	
	@RequestMapping("/osmcomapnylist")
	public String getAllCompanyList(){
		
		OSMPreview osmprev = new OSMPreview();
		ArrayList companyList = osmprev.getAllCompanyList();
		
		String comapanyset = companyList.toString();
		return comapanyset;
	}
	
	
	@RequestMapping("/osmcomapnylists")
	public String getExistingOSMStructure(){
		
		OSMPreview osmprev = new OSMPreview();
		ArrayList companyList = osmprev.getAllCompanyList();
		
		String comapanyset = companyList.toString();
		return comapanyset;
	}
	
	@RequestMapping("/osmprojectsubscription")
	public ModelAndView osmprojectsubscription(
			@RequestParam(value = "userid", required = false, defaultValue = "World") String userid,
			@RequestParam(value = "subscriptiontype", required = false, defaultValue = "World") String subscriptiontype,
			HttpServletRequest requests) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		ArrayList existingprojectsdoc = new ArrayList();
		ServletContext context = requests.getSession().getServletContext();
		String token = (String)context.getAttribute("osmid");
		//osmprev.saveExistingOSMModelsDoc(token,ownerid);
		
		ModelAndView mv = new ModelAndView("/OSMProjectList");
		//mv.addObject("existingprojectsdoc", existingprojectsdoc);
		return mv;
	}
	
	
}
