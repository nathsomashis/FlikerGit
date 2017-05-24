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
			@RequestParam(value = "stockprice", required = false, defaultValue = "World") String stockprice,
			@RequestParam(value = "stockid", required = false, defaultValue = "World") String stockid,
			@RequestParam(value = "ownerid", required = false, defaultValue = "World") String ownerid,
			HttpServletRequest request) {
		System.out.println("in controller");
		
		String stockavalable = "true";
		
		TradePreview tradeprev = new TradePreview();
		String istradeavail = tradeprev.checkAvalability(stockid,stockamount);
		if(istradeavail.equalsIgnoreCase("true")){
			
		}
		
		
		return stockavalable;
		
	}
	
	
	@RequestMapping("/stockavaliable")
	public String stockavaliable(
			@RequestParam(value = "stockamount", required = false, defaultValue = "World") String stockamount,
			@RequestParam(value = "stockprice", required = false, defaultValue = "World") String stockprice,
			HttpServletRequest request) {
		System.out.println("in controller");
		
		String stockavalable = "true";
		
		
		
		
		return stockavalable;
		
	}
}
