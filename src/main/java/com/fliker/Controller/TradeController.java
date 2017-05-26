package com.fliker.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.OSMPreview;
import com.fliker.Modal.ProfilePreview;
import com.fliker.Modal.TradePreview;
import com.fliker.Repository.User;

@Controller
public class TradeController {

	
	@RequestMapping("/stockselling")
	public String stockselling(
			@RequestParam(value = "stockamount", required = false, defaultValue = "World") String stockamount,
			@RequestParam(value = "stockprice", required = false, defaultValue = "World") String stockprice,
			@RequestParam(value = "stockid", required = false, defaultValue = "World") String stockid,
			@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid,
			HttpServletRequest request) {
		System.out.println("in controller");
		
		String stockavalable = "true";
		
		
		
		
		
		return stockavalable;
		
	}

	
	@RequestMapping("/stockbuying")
	public String stockbuying(
			@RequestParam(value = "stockamount", required = false, defaultValue = "World") String stockamount,
			@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid,
			HttpServletRequest request) {
		System.out.println("in controller");
		
		String stockavalable = "true";
		TradePreview tradeprev = new TradePreview();
		ServletContext context = request.getSession().getServletContext();
		HashMap<String,LinkedList<String>> tradeavaillist = (HashMap<String,LinkedList<String>>)context.getAttribute("TradeAvailList");
		String totalstock = (String)context.getAttribute("TradeTotalList");
		
		tradeprev.proceedToBuyout(totalstock,stockamount,ownerid,tradeavaillist);
		
		
		
		/*
		HashMap<String,LinkedList<String>> istradeavail = tradeprev.checkAvalability(osmmodelid,stockid,stockamount,stockprice);
		String elements = tradeprev.checkElements(istradeavail);
		if(!elements.isEmpty()){
			tradeprev.getAllTradeElements(elements,stockamount);
		}*/
		
		return stockavalable;
		
	}
	
	
	@RequestMapping("/stockavaliable")
	public int stockavaliable(
			@RequestParam(value = "osmmodelid", required = false, defaultValue = "World") String osmmodelid,
			@RequestParam(value = "stockprice", required = false, defaultValue = "World") String stockprice,
			HttpServletRequest request) {
		System.out.println("in controller");
		
		String stockavalable = "true";
		int totalstock = 0;
		
		TradePreview tradeprev = new TradePreview();
		HashMap<String,LinkedList<String>> istradeavail = tradeprev.checkAvalability(osmmodelid);
		String elements = tradeprev.checkElements(istradeavail);
		if(!elements.isEmpty()){
			totalstock = tradeprev.getAllTradeElements(elements,stockprice);
		}
		ServletContext context = request.getSession().getServletContext();
		context.setAttribute("TradeAvailList", istradeavail);
		context.setAttribute("TradeTotalList", elements);
		
		return totalstock;
		
	}
}
