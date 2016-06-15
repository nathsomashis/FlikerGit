package com.fliker.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class PostCreateController   {

	@RequestMapping(value = "/filePost",  method=RequestMethod.POST, headers = "content-type=multipart/*")
	public void showMessage( HttpServletRequest request,HttpServletResponse response,
			@RequestParam("file") MultipartFile file1) {
		System.out.println("in file controller");
		
		if (request instanceof MultipartHttpServletRequest) {
			System.out.println("in multipart file controller");
	    }
	    else {
	    	System.out.println("in file controller");
	    	
	    	System.out.println(request.getParameter("file"));
	    	
	    }
		
	}
	
}
