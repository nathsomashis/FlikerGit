package com.fliker.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.NotificationPreview;

@Controller
public class NotificationController {

	@RequestMapping("/notifications")
	public ModelAndView notifications(@RequestParam(value = "userid", required = false, defaultValue = "World") String userid,
			@RequestParam(value = "lastid", required = false, defaultValue = "World") String lastid){
		
		
		ModelAndView mv = new ModelAndView("/NotificationList");
		NotificationPreview noteprev = new NotificationPreview();
		ArrayList notificationlistto = new ArrayList();
		ArrayList notifications = new ArrayList();
		
		notificationlistto = noteprev.getAllNotification(userid);
		notifications = noteprev.getNotifications(lastid, notificationlistto);
		
		
		mv.addObject("notifications", notifications);
		return mv;
		
	}
	
}
