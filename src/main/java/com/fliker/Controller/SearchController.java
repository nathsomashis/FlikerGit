package com.fliker.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.SearchPreview;

@Controller
public class SearchController {
	
	
	@RequestMapping("/searchresults")
	public ModelAndView searchresult(@RequestParam(value = "name", required = false) String searchparam, HttpSession session){
		
		String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
		
		SearchPreview searchprev = new SearchPreview();
		ArrayList searchresult = searchprev.getSearchResult(searchparam);
		
		ModelAndView mv = new ModelAndView("/Search");
		
		mv.addObject("search", "searchresults");
		mv.addObject("searchResult", searchresult);
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

}
