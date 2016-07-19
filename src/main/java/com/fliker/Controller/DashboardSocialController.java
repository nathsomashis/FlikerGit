package com.fliker.Controller;

import java.net.UnknownHostException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.CommentsPreview;
import com.fliker.Modal.DashboardSocialPreview;
import com.fliker.Modal.LikesPreview;
import com.fliker.Modal.PostPreview;
import com.fliker.Modal.ProfilePreview;
import com.fliker.Modal.SharePreview;
import com.fliker.Repository.Post;
import com.fliker.Repository.Profile;
import com.fliker.Repository.User;
import com.mongodb.DBObject;

@Controller
public class DashboardSocialController {

	@RequestMapping("/dashboardsocial")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in dashboard social controller");

		ArrayList postlist = new ArrayList();

		DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.firstpostlist();
		int lastindex = postlist.size();
		
		/*
		 * Post posts = (Post) postlist.get(lastindex-1); String postidtoStore =
		 * posts.getPostid();
		 */

		System.out.println("postlist >><><" + postlist);

		ModelAndView mv;
		mv = new ModelAndView("/DashboardSocial");

		mv.addObject("postlist", postlist);
		mv.addObject("name", name);
		// mv.addObject("postlastid",postidtoStore);
		return mv;
	}
	
	
	
	@RequestMapping(value = "/dashboardsocialpost", method = RequestMethod.GET)
	public @ResponseBody ArrayList showPosts(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in dashboard social controller");

		ArrayList postlist = new ArrayList();

		DashboardSocialPreview dashpreview = new DashboardSocialPreview();
		postlist = dashpreview.postlist();
		int lastindex = postlist.size();
		
		/*
		 * Post posts = (Post) postlist.get(lastindex-1); String postidtoStore =
		 * posts.getPostid();
		 */

		System.out.println("postlist dashboard >><><" + postlist);

		/*ModelAndView mv;
		mv = new ModelAndView("/DashboardSocial");

		mv.addObject("postlist", postlist);
		mv.addObject("name", name);*/
		// mv.addObject("postlastid",postidtoStore);
		return postlist;
	}

	@RequestMapping("/dashboardsocial/getPosts")
	public ArrayList getPosts() {

		ArrayList postList = new ArrayList();
		ModelAndView mv = new ModelAndView();

		PostPreview postprev = new PostPreview();
		postList = postprev.getPosts(mv.getModel().get("postlastid").toString());

		return postList;
	}

	@RequestMapping("/dashboardsocial/saveComments")
	public void saveComments(@RequestParam(value = "postid", required = true) String postid,
			@RequestParam(value = "comment", required = true) String comment) {

		ModelAndView mv = new ModelAndView();
		User userinfo = (User) mv.getModel().get("User");

		CommentsPreview commentpreview = new CommentsPreview();
		try {
			commentpreview.arrayToPost(userinfo, postid, comment);
			commentpreview.updateCommentTable(userinfo, postid, comment);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping("/dashboardsocial/saveLikes")
	public void saveLikes(@RequestParam(value = "postid", required = true) String postid,
			@RequestParam(value = "liked", required = true) String liked) {

		boolean likes = false;

		if (liked == "true") {
			likes = true;
		}

		ModelAndView mv = new ModelAndView();
		User userinfo = (User) mv.getModel().get("User");

		LikesPreview likeprev = new LikesPreview();
		try {
			likeprev.likeToPost(userinfo, postid, likes);

			likeprev.updateLikeTable(userinfo, postid);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping("/dashboardsocial/saveShares")
	public void saveShares(@RequestParam(value = "postid", required = true) String postid,
			@RequestParam(value = "commentonshare", required = false) String commentOnShare) {

		ModelAndView mv = new ModelAndView();
		User userinfo = (User) mv.getModel().get("User");

		SharePreview sharedprev = new SharePreview();
		try {
			sharedprev.sharedToPost(userinfo, postid, commentOnShare);

			sharedprev.updateShareTable(userinfo, postid, commentOnShare);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping("/dashboardsocial/saveReplys")
	public void saveReplys(@RequestParam(value = "commentid", required = true) String commentid) {

	}

	@RequestMapping("/profileinfo/{userid}")
	public String usernameFromuserdid(  @RequestParam(value = "userid", required = true) String userid){
		
		User user = getUserinfo(userid);
		
		return user.getUsername();
		
	}

	private static ArrayList getProfileinfo(String userid) {

		ProfilePreview prof = new ProfilePreview();
		ArrayList profile = prof.getProfileInfo(userid);

		return profile;
	}

	private static User getUserinfo(String userid) {

		ProfilePreview prof = new ProfilePreview();
		User user = new User();

		return user;
	}

}
