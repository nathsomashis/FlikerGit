package com.fliker.Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.CoursePreview;
import com.fliker.Modal.OSMPreview;
import com.fliker.Modal.ProfilePreview;
import com.fliker.Repository.Company;
import com.fliker.Repository.OSMProjectInvestment;
import com.fliker.Repository.Profile;
import com.fliker.Repository.User;
import com.mongodb.gridfs.GridFSDBFile;

@Controller
public class OSMController {

	@RequestMapping("/osmprojectinfo")
	public ModelAndView osmProjectInfo(
			@RequestParam(value = "owner", required = false, defaultValue = "World") String ownerid,
			HttpServletRequest request) {
		System.out.println("in controller");
		
		ArrayList osmprojlist = new ArrayList();
		ArrayList existingprojectlist = new ArrayList();
		OSMPreview osmprev = new OSMPreview();
		osmprojlist = osmprev.getProjectInfoList();
		existingprojectlist = osmprev.getRelatedOSMModels(ownerid);
		osmprojlist.add(existingprojectlist);
		
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
			@RequestParam(value = "location", required = false) String location,
			HttpServletRequest request) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		String osmid = osmprev.createNewProjectInfo(projectdescription,projectname, ownerid,companyid,projectinvestors,projectbuyers,osmpartners, osmbackupcompany, osmdependependid, location);
		
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		ModelAndView mv = new ModelAndView("/OSMCreateProjectInfoNext");
		mv.addObject("osmid", osmid);
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		return mv;
	}
	
	@RequestMapping("/osmprojectinfonext")
	public ModelAndView osmprojectinfolink(
			@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid, HttpServletRequest request) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		ArrayList existingprojects = new ArrayList();
		existingprojects = osmprev.getAllExistingOSMModels(ownerid);
		
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		ModelAndView mv = new ModelAndView("/OSMCreateProjectInfo");
		mv.addObject("existingproject", existingprojects);
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
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
		
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		ModelAndView mv = new ModelAndView("/OSMProjectList");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
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
	
	
	@RequestMapping("/osmlists")
	public String getExistingOSMStructure(){
		
		OSMPreview osmprev = new OSMPreview();
		ArrayList companyList = osmprev.getAllCompanyList();
		
		String comapanyset = companyList.toString();
		return comapanyset;
	}
	
	
	//to see after subscription
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
		
		HashMap subscriptionmap = osmprev.opensubscriptionAs(userid,subscriptiontype,token);
		String modelink = "/OSMProjectInvestor";
		
		User userinf = (User) context.getAttribute("UserValues");
		String userids = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userids);
		
		
		Set subscribeset = subscriptionmap.entrySet();
		Iterator subit = subscribeset.iterator();
		while(subit.hasNext()){
			Map.Entry mesub = (Map.Entry)subit.next();
			modelink = (String)mesub.getKey();
			existingprojectsdoc = (ArrayList)mesub.getValue();
		}
		
		ModelAndView mv = new ModelAndView(modelink);
		
		
		mv.addObject("existingprojectsdoc", existingprojectsdoc);
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		return mv;
	}
	
	
	@RequestMapping("/osmlike")
	public void osmlikes(@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid,
			@RequestParam(value = "osmmodelid", required = false, defaultValue = "World") String osmmodelid){
		
		OSMPreview osmprev = new OSMPreview();
		osmprev.saveLikeInfo(ownerid,osmmodelid);
		
	}

	@RequestMapping("/osmshare")
	public void osmshare(@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid,
			@RequestParam(value = "osmmodelid", required = false, defaultValue = "World") String osmmodelid){
		
		OSMPreview osmprev = new OSMPreview();
		osmprev.saveShareInfo(ownerid,osmmodelid);
		
	}
	
	//subscribing by buyer
	@RequestMapping("/osmsubscribebuying")
	public ModelAndView submitbuying(
			@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid,
			HttpServletRequest requests) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		ArrayList existingprojectlist = new ArrayList();
		ServletContext context = requests.getSession().getServletContext();
		String token = (String)context.getAttribute("osmid");
		osmprev.saveOSMModelBuying(token,ownerid);
		
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		existingprojectlist = osmprev.getRelatedOSMModels(ownerid);
		
		ModelAndView mv = new ModelAndView("/OSMProjectList");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		//mv.addObject("existingprojectsdoc", existingprojectsdoc);
		return mv;
	}
	
	
	//buying plans
		@RequestMapping("/osmbuyingplan")
		public ModelAndView planforbuying(
				@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid,
				HttpServletRequest requests) {
			System.out.println("in controller");
			
			OSMPreview osmprev = new OSMPreview();
			ArrayList existingprojectlist = new ArrayList();
			ServletContext context = requests.getSession().getServletContext();
			String token = (String)context.getAttribute("osmid");
			//osmprev.saveOSMModelBuying(token,ownerid);
			
			
			User userinf = (User) context.getAttribute("UserValues");
			String userid = userinf.getUserid();
			String userfirstname = userinf.getFirstname();
			String userlastname = userinf.getLastname();
			String gender = userinf.getGender();
			
			ProfilePreview profprev = new ProfilePreview();
			
			String profileimageid = profprev.profileimage(userid);
			
			//existingprojectlist = osmprev.getRelatedOSMModels(ownerid);
			
			ModelAndView mv = new ModelAndView("/OSMProjectBuy");
			mv.addObject("ProfileImage", profileimageid);
			mv.addObject("Gender", gender);
			mv.addObject("FullName", userfirstname+" "+userlastname);
			//mv.addObject("existingprojectsdoc", existingprojectsdoc);
			return mv;
		}
		
		//buying plans
				@RequestMapping("/osmplanbuy")
				public ModelAndView plantypebuy(
						@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid,
						HttpServletRequest requests) {
					System.out.println("in controller");
					
					OSMPreview osmprev = new OSMPreview();
					ArrayList existingprojectlist = new ArrayList();
					ServletContext context = requests.getSession().getServletContext();
					String token = (String)context.getAttribute("osmid");
					//osmprev.saveOSMModelBuying(token,ownerid);
					
					
					User userinf = (User) context.getAttribute("UserValues");
					String userid = userinf.getUserid();
					String userfirstname = userinf.getFirstname();
					String userlastname = userinf.getLastname();
					String gender = userinf.getGender();
					
					ProfilePreview profprev = new ProfilePreview();
					
					String profileimageid = profprev.profileimage(userid);
					
					//existingprojectlist = osmprev.getRelatedOSMModels(ownerid);
					
					ModelAndView mv = new ModelAndView("/OSMBill");
					mv.addObject("ProfileImage", profileimageid);
					mv.addObject("Gender", gender);
					mv.addObject("FullName", userfirstname+" "+userlastname);
					//mv.addObject("existingprojectsdoc", existingprojectsdoc);
					return mv;
				}	
		
	
	//subscribe by developer
	@RequestMapping("/osmsubscribedevelop")
	public ModelAndView submitdevelopment(
			@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid,
			HttpServletRequest requests) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		ArrayList existingprojectlist = new ArrayList();
		ServletContext context = requests.getSession().getServletContext();
		String token = (String)context.getAttribute("osmid");
		osmprev.saveOSMModelDevloping(token,ownerid);
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		existingprojectlist = osmprev.getRelatedOSMModels(ownerid);
		
		ModelAndView mv = new ModelAndView("/OSMProjectList");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		//mv.addObject("existingprojectsdoc", existingprojectsdoc);
		return mv;
	}
	
	//accept the developer
	@RequestMapping("/osmacceptdeveloper")
	public void enrolldeveloper(
			@RequestParam(value = "developerid", required = false, defaultValue = "World") String developerid,
			@RequestParam(value = "osmmodelid", required = false, defaultValue = "World") String osmmodelid,
			HttpServletRequest requests) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		ArrayList existingprojectlist = new ArrayList();
		ServletContext context = requests.getSession().getServletContext();
		osmprev.saveOSMModelDevloplist(osmmodelid,developerid);
		
		
		//existingprojectlist = osmprev.getRelatedOSMModels(ownerid);
		
		/*ModelAndView mv = new ModelAndView("/OSMProjectList");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		//mv.addObject("existingprojectsdoc", existingprojectsdoc);
		return mv;*/
	}
	
	/**
	 * 
	 * 
	 * Investment Formulate
	 * Start
	 * @param ownerid
	 * @param requests
	 * @return
	 */
	
	//on subscribing for the investment by investor
	@RequestMapping("/osmsubscribeinvest")
	public ModelAndView submitinvestment(
			@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid,
			HttpServletRequest requests) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		ArrayList existingprojectlist = new ArrayList();
		ServletContext context = requests.getSession().getServletContext();
		String token = (String)context.getAttribute("osmid");
		osmprev.saveOSMModelInvest(token,ownerid);
		
		existingprojectlist = osmprev.getRelatedOSMModels(ownerid);
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		ModelAndView mv = new ModelAndView("/OSMProjectList");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		//mv.addObject("existingprojectsdoc", existingprojectsdoc);
		return mv;
	}
	
	
	/*@RequestMapping("/osminvestmentdemand")
	public ModelAndView investmentdemand(
			@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid,
			HttpServletRequest requests) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		ArrayList existingprojectlist = new ArrayList();
		ServletContext context = requests.getSession().getServletContext();
		String token = (String)context.getAttribute("osmid");
		osmprev.saveOSMModelInvest(token,ownerid);
		
		existingprojectlist = osmprev.getRelatedOSMModels(ownerid);
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		ModelAndView mv = new ModelAndView("/OSMProjectList");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		//mv.addObject("existingprojectsdoc", existingprojectsdoc);
		return mv;
	}*/
	
	//on investing for the investment by investor
	@RequestMapping("/osminvest")
	public ModelAndView investment(
			@RequestParam(value = "ownerid", required = false) String ownerid,
			@RequestParam(value = "osmmodelid", required = false) String osmmodelid,
			@RequestParam(value = "investamount", required = false) String investamount,
			@RequestParam(value = "investpercentage", required = false) String investpercentage,
			@RequestParam(value = "stockprice", required = false) String stockprice,
			@RequestParam(value = "initialstockprice", required = false) String initialstockprice,
			@RequestParam(value = "enabletrading", required = false) String enabletrading,
			HttpServletRequest requests) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		ArrayList existingprojectlist = new ArrayList();
		ServletContext context = requests.getSession().getServletContext();
		String token = (String)context.getAttribute("osmid");
		
		osmprev.saveInvestMent(ownerid,osmmodelid,investamount,investpercentage,stockprice,initialstockprice, enabletrading);
		
		//osmprev.saveDemandChart(ownerid,osmmodelid);
		//existingprojectlist = osmprev.getRelatedOSMModels(ownerid);
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		ModelAndView mv = new ModelAndView("/OSMProjectList");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		//mv.addObject("existingprojectsdoc", existingprojectsdoc);
		return mv;
	}
	
	//invester scren edit for the project provider
	@RequestMapping("/osmprojectinvestmentnew")
	public ModelAndView createprojectinvestdata(
			@RequestParam(value = "osmmodelid", required = false, defaultValue = "World") String osmmodelid,
			HttpServletRequest requests) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		ServletContext context = requests.getSession().getServletContext();
		String token = (String)context.getAttribute("osmid");
		
		//osmprev.createOSMModelInvestSet(osmmodelid,stakeamount, stakedivision);
		
		//osmprev.saveOSMModelDevloping(token,ownerid);
		
		String isexist = osmprev.checkInvestSet(osmmodelid);
		OSMProjectInvestment osminvest = new OSMProjectInvestment();
		
		if(isexist.equalsIgnoreCase("true")){
			osminvest = osmprev.getInvestDataDetails(osmmodelid);
		}
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		
		ModelAndView mv = new ModelAndView("/OSMProjectInvestDocScreen");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		mv.addObject("osminvest", osminvest);
		return mv;
	}
	
	
	// get all existing projectinvestors list
	@RequestMapping("/osmprojectinvester")
	public ModelAndView projectinvesters(
			@RequestParam(value = "osmmodelid", required = false, defaultValue = "World") String osmmodelid,
			HttpServletRequest requests) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		ServletContext context = requests.getSession().getServletContext();
		ArrayList investorlist = new ArrayList();
		
		String token = (String)context.getAttribute("osmid");
		
		//osmprev.createOSMModelInvestSet(osmmodelid,stakeamount, stakedivision);
		
		//osmprev.saveOSMModelDevloping(token,ownerid);
		
		String isexist = osmprev.checkInvestSet(osmmodelid);
		
		if(isexist.equalsIgnoreCase("true")){
			investorlist = osmprev.getProjectInvestors(osmmodelid);
		}
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		
		ModelAndView mv = new ModelAndView("/OSMProjectInvestDocScreen");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		mv.addObject("investorlist", investorlist);
		return mv;
	}
	
	
	//save existing project investment or create new project investment
	@RequestMapping("/osmprojectinvestmentsubmit")
	public ModelAndView submitprojectinvestfinal(
			@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid,
			@RequestParam(value = "projectinvestlink", required = false, defaultValue = "World") String projectinvestlink,
			@RequestParam(value = "osmmodelid", required = false, defaultValue = "World") String osmmodelid,
			@RequestParam(value = "stakeamount", required = false, defaultValue = "World") String stakeamount,
			@RequestParam(value = "stakedivision", required = false, defaultValue = "World") String stakedivision,
			HttpServletRequest requests) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		ArrayList existingprojectlist = new ArrayList();
		ServletContext context = requests.getSession().getServletContext();
		String token = (String)context.getAttribute("osmid");
		
		String isexist = osmprev.checkInvestSet(osmmodelid);
		
		if(isexist.equalsIgnoreCase("false")){
			osmprev.createOSMModelInvestSet(osmmodelid,stakeamount, stakedivision,ownerid,projectinvestlink);
		}else if(isexist.equalsIgnoreCase("true")){
			osmprev.saveOSMModelInvestDocSave(osmmodelid,stakeamount, stakedivision,ownerid,projectinvestlink);
		}
		
		
		//osmprev.saveOSMProjectInvestUpdate(projectinvestlink,token);
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		existingprojectlist = osmprev.getRelatedOSMModels(ownerid);
		
		ModelAndView mv = new ModelAndView("/OSMProjectList");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		//mv.addObject("existingprojectsdoc", existingprojectsdoc);
		return mv;
	}
	
	
	
	/**
	 * 
	 * 
	 * Investment Formulate
	 * End
	 * @param ownerid
	 * @param requests
	 * @return
	 */
	
	@RequestMapping("/osmprojectsellernew")
	public ModelAndView createprojectselldata(
			@RequestParam(value = "osmmodelid", required = false, defaultValue = "World") String osmmodelid,
			@RequestParam(value = "sellerdescription", required = false, defaultValue = "World") String sellerdescription,
			HttpServletRequest requests) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		ServletContext context = requests.getSession().getServletContext();
		String token = (String)context.getAttribute("osmid");
		
		osmprev.createOSMModelSellerSet(osmmodelid,sellerdescription);
		
		//osmprev.saveOSMModelDevloping(token,ownerid);
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		
		ModelAndView mv = new ModelAndView("/OSMProjectSellerDocScreen");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		//mv.addObject("existingprojectsdoc", existingprojectsdoc);
		return mv;
	}
	
	
	@RequestMapping("/osmprojectsellingsubmit")
	public ModelAndView submitprojectsellerfinal(
			@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid,
			HttpServletRequest requests) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		ArrayList existingprojectlist = new ArrayList();
		ServletContext context = requests.getSession().getServletContext();
		String token = (String)context.getAttribute("osmid");
		osmprev.saveOSMModelSellerDocSave(token,ownerid);
		
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		existingprojectlist = osmprev.getRelatedOSMModels(ownerid);
		
		ModelAndView mv = new ModelAndView("/OSMProjectList");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		//mv.addObject("existingprojectsdoc", existingprojectsdoc);
		return mv;
	}
	
	
	@RequestMapping("/osmprojectresourcenew")
	public ModelAndView createprojectresourcedata(
			@RequestParam(value = "osmmodelid", required = false, defaultValue = "World") String osmmodelid,
			HttpServletRequest requests) {
		System.out.println("in controller");
		
		//OSMPreview osmprev = new OSMPreview();
		ServletContext context = requests.getSession().getServletContext();
		String token = (String)context.getAttribute("osmid");
		
		//osmprev.createOSMModelResourceSet(osmmodelid);
		
		//osmprev.saveOSMModelDevloping(token,ownerid);
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		
		ModelAndView mv = new ModelAndView("/OSMProjectResourceDocScreen");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		mv.addObject("osmmodelid", osmmodelid);
		//mv.addObject("existingprojectsdoc", existingprojectsdoc);
		return mv;
	}
	
	
	@RequestMapping("/osmmodelprojectpublish")
	public String publishprojectmodel(
			@RequestParam(value = "osmmodelid", required = false, defaultValue = "World") String osmmodelid,
			HttpServletRequest requests) {
		System.out.println("in controller");
		
		OSMPreview osmprev = new OSMPreview();
		ServletContext context = requests.getSession().getServletContext();
		
		String check = osmprev.checkAllProjectData(osmmodelid);
		
		if(check.equalsIgnoreCase("true")){
			
		}
		//osmprev.createOSMModelResourceSet(osmmodelid);
		
		//osmprev.saveOSMModelDevloping(token,ownerid);
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		
		/*ModelAndView mv = new ModelAndView("/OSMProjectResourceDocScreen");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		mv.addObject("osmmodelid", osmmodelid);*/
		//mv.addObject("existingprojectsdoc", existingprojectsdoc);
		return check;
	}
	
	@RequestMapping(value = "/osmcontrol/{osmmodelid}")
	@ResponseBody
	public byte[] osmcompanyimagename(@PathVariable String osmmodelid) {

		String companyimagename = "";
		
		OSMPreview osmprev = new OSMPreview();
		String companylogoid = osmprev.getOSMOperatorCompanyLogo(osmmodelid);
		
		
		
		return osmprev.imagefromid(companylogoid);
	}
	
	
	@RequestMapping(value = "/osmcompanyidentify/{osmmodelid}")
	@ResponseBody
	public String osmcompanyimageid(@PathVariable String osmmodelid) {

		String companyimagename = "";
		
		OSMPreview osmprev = new OSMPreview();
		String companylogoid = osmprev.getOSMOperatorCompanyID(osmmodelid);
		
		
		
		return companylogoid;
	}
	
	
}
