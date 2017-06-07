package com.fliker.Controller;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.ProfilePreview;
import com.fliker.Modal.SearchPreview;
import com.fliker.Repository.User;

@Controller
public class SearchController {
	
	
	@RequestMapping("/searchresults")
	public ModelAndView searchresult(@RequestParam(value = "searchparam", required = false) String searchparam, HttpServletRequest request){
		
		//String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
		SearchPreview searchprev = new SearchPreview();
		ArrayList searchresult = new ArrayList();
		System.out.println(" Search >>"+searchparam);
		ModelAndView mv = new ModelAndView("/Search");
		
		try{
			if(searchparam!= null){
				searchresult = searchprev.getSearchResult(searchparam);
				mv.addObject("searchResult", searchresult);
			}
			
			
		}catch (NullPointerException exc){
			exc.getLocalizedMessage();
			searchresult.add("");
			
		}
		
		System.out.println(" Search Result ::>>"+searchresult);
		
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		System.out.println("userid ::"+userid);
		
		//mv.addObject("search", "searchresults");
		
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		return mv;
		
	}
	
	
	@RequestMapping("/searchfirst")
	public ModelAndView searchfirst( HttpServletRequest request){
		
		//String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
		SearchPreview searchprev = new SearchPreview();
		ArrayList searchresult = new ArrayList();
		/*System.out.println(" Search >>"+searchparam);
		
		try{
			searchresult = searchprev.getSearchResult(searchparam);
			
		}catch (NullPointerException exc){
			exc.getLocalizedMessage();
			searchresult.add("");
			
		}*/
		
		//System.out.println(" Search Result ::>>"+searchresult);
		
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		System.out.println("userid ::"+userid);
		
		ModelAndView mv = new ModelAndView("/Search");
		
		//mv.addObject("search", "searchresults");
		//mv.addObject("searchResult", searchresult);
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		return mv;
		
	}
	
	
	@RequestMapping("/contentsearchresults")
	public ModelAndView contentsearch(@RequestParam(value = "name", required = false) String contentsearch,
			@RequestParam(value = "type", required = false) String contentsearchtype,HttpSession session){
		
		String[] contentSearchTypes = contentsearchtype.split(",");
		String contentSearchCat = contentSearchTypes[0];
		String contentSearchCol = contentSearchTypes[1];
		
		SearchPreview searchprev = new SearchPreview();
		ArrayList searchresult = searchprev.getSearchResultOnCategory(contentsearch,contentSearchCat,contentSearchCol);
		
		ModelAndView mv = new ModelAndView("/Search");
		
		mv.addObject("name", "contentsearchresults");
		mv.addObject("searchResult", searchresult);
		return mv;
		
	}
	
	
	@RequestMapping("/searchhistory")
	public ModelAndView searchhistory(@RequestParam(value = "name", required = false) String searchhistoryparam){
		
		
		SearchPreview searchprev = new SearchPreview();
		ArrayList searchresult = searchprev.getSearchResultHistoryDefault(searchhistoryparam);
		ModelAndView mv = new ModelAndView("/Search");
		
		mv.addObject("name", "searchhistory");
		mv.addObject("searchResult", searchresult);
		return mv;
		
	}
	
	@RequestMapping("/search")
	public ModelAndView search(HttpServletRequest request){
		
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		
		ProfilePreview profprev = new ProfilePreview();
		
		String profileimageid = profprev.profileimage(userid);
		
		System.out.println("userid ::"+userid);

		
		ModelAndView mv = new ModelAndView("/Search");
		
		mv.addObject("name", "searchhistory");
		mv.addObject("ProfileImage", profileimageid);
		mv.addObject("Gender", gender);
		mv.addObject("FullName", userfirstname+" "+userlastname);
		
		return mv;
		
	}

}
