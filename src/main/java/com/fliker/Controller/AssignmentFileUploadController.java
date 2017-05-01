package com.fliker.Controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fliker.Modal.AssignmentFilePreview;
import com.fliker.Repository.User;

@Controller
public class AssignmentFileUploadController {

	
	@RequestMapping("/assignfileCourseOne")
	public void assignfileCourseOne(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		AssignmentFilePreview assignfilprev = new AssignmentFilePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		assignfilprev.saveFile(request.getFileMap(),userid, "1",requests);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	@RequestMapping("/assignfileCourseTwo")
	public void assignfileCourseTwo(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		AssignmentFilePreview assignfilprev = new AssignmentFilePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		assignfilprev.saveFile(request.getFileMap(),userid, "2", requests);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	
	@RequestMapping("/assignfileCourseThree")
	public void assignfileCourseThree(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		AssignmentFilePreview assignfilprev = new AssignmentFilePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		assignfilprev.saveFile(request.getFileMap(),userid, "3",requests);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	
	@RequestMapping("/assignfileCourseFour")
	public void assignfileCourseFour(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		AssignmentFilePreview assignfilprev = new AssignmentFilePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		assignfilprev.saveFile(request.getFileMap(),userid, "4",requests);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	
	@RequestMapping("/assignfileCourseFive")
	public void assignfileCourseFive(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		AssignmentFilePreview assignfilprev = new AssignmentFilePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		assignfilprev.saveFile(request.getFileMap(),userid, "5",requests);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	
	@RequestMapping("/assignfileCourseSix")
	public void assignfileCourseSix(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		AssignmentFilePreview assignfilprev = new AssignmentFilePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		assignfilprev.saveFile(request.getFileMap(),userid, "6",requests);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	
	@RequestMapping("/assignfileCourseSeven")
	public void assignfileCourseSeven(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		AssignmentFilePreview assignfilprev = new AssignmentFilePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		assignfilprev.saveFile(request.getFileMap(),userid, "7",requests);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	@RequestMapping("/assignfileCourseEight")
	public void assignfileCourseEight(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		AssignmentFilePreview assignfilprev = new AssignmentFilePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		assignfilprev.saveFile(request.getFileMap(),userid, "8",requests);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	
	@RequestMapping("/assignfileCourseNine")
	public void assignfileCourseNine(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		AssignmentFilePreview assignfilprev = new AssignmentFilePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		assignfilprev.saveFile(request.getFileMap(),userid, "9",requests);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	@RequestMapping("/assignfileCourseTen")
	public void assignfileCourseTen(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		AssignmentFilePreview assignfilprev = new AssignmentFilePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		assignfilprev.saveFile(request.getFileMap(),userid, "10",requests);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	
	@RequestMapping("/assignfileCourseEleven")
	public void assignfileCourseEleven(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		AssignmentFilePreview assignfilprev = new AssignmentFilePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		assignfilprev.saveFile(request.getFileMap(),userid, "11",requests);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	
	@RequestMapping("/assignfileCourseTwelve")
	public void assignfileCourseTwelve(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		AssignmentFilePreview assignfilprev = new AssignmentFilePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		assignfilprev.saveFile(request.getFileMap(),userid, "12",requests);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	
	@RequestMapping("/assignfileCourseThriteen")
	public void assignfileCourseThirteen(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		AssignmentFilePreview assignfilprev = new AssignmentFilePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		assignfilprev.saveFile(request.getFileMap(),userid, "13",requests);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	
	@RequestMapping("/assignfileCourseFourteen")
	public void assignfileCourseFourteen(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		AssignmentFilePreview assignfilprev = new AssignmentFilePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		assignfilprev.saveFile(request.getFileMap(),userid, "14",requests);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	
	@RequestMapping("/assignfileCourseFifteen")
	public void assignfileCourseFifteen(MultipartHttpServletRequest request, HttpServletResponse response,HttpServletRequest requests,
			@RequestParam("file") MultipartFile file1, HttpSession session) {
		System.out.println("in file controller");

		AssignmentFilePreview assignfilprev = new AssignmentFilePreview();
		ServletContext context = request.getSession().getServletContext();
		
		User userinf = (User) context.getAttribute("UserValues");
		String userid = userinf.getUserid();
		String userfirstname = userinf.getFirstname();
		String userlastname = userinf.getLastname();
		String gender = userinf.getGender();
		assignfilprev.saveFile(request.getFileMap(),userid, "15",requests);

		/*ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);*/

	}
	
	
}
