package com.fliker.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.FilePreview;
import com.fliker.Modal.PostPreview;
import com.fliker.Modal.ProfilePreview;
import com.fliker.Repository.FileUpload;
import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Controller
public class PostCreateController   {

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Viewable  uploadFile(
		@FormDataParam("file") InputStream uploadedInputStream,
		@FormDataParam("file") FormDataContentDisposition fileDetail,
		@FormDataParam("comment") String inputComment) {

		String uploadedFileLocation = "E:\\Non Official" + fileDetail.getFileName();
		System.out.println("inputComment "+inputComment);

		// save it
		writeToFile(uploadedInputStream, uploadedFileLocation);

		String output = "File uploaded to : " + uploadedFileLocation;

		
		
		return new Viewable("/WEB-INF/views/NewPost");

	}
	
	// save uploaded file to new location
		private void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {

			try {
				OutputStream out = new FileOutputStream(new File(
						uploadedFileLocation));
				int read = 0;
				byte[] bytes = new byte[1024];

				FileUpload fileup = new FileUpload();
				out = new FileOutputStream(new File(uploadedFileLocation));
				while ((read = uploadedInputStream.read(bytes)) != -1) {
					out.write(bytes, 0, read);
					
					
				}
				
				fileup.setFileblob(bytes);
				fileup.setFileid("example123");
				fileup.setLocation(uploadedFileLocation);
				fileup.setName(uploadedFileLocation);
				fileup.setType("Image");
				
				FilePreview filprev = new FilePreview();
				filprev.saveFile(fileup);
				out.flush();
				out.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	
		
		@RequestMapping("/postcreate")
		public ModelAndView showMessage(
				@RequestParam(value = "postdescription", required = false, defaultValue = "World") String postdescription,
				@RequestParam(value = "location", required = false) String location,
				HttpSession session
				) {
			System.out.println("in profile controller"+location);
	 
			//ArrayList postlist = new ArrayList();
			
			/*DashboardSocialPreview dashpreview = new DashboardSocialPreview();
			postlist = dashpreview.postlist(lastid);*/
			
			ArrayList<String> fileids = (ArrayList<String>)session.getAttribute("fileidsimage");
			System.out.println("fileids"+fileids);
			
			
			
			ModelAndView mv;
			mv = new ModelAndView("/NewPost");
			/*ModelMap model = new ModelMap();
			ArrayList filelist = (ArrayList) model.get("fieldlists");
			System.out.println("fieldlist >>"+filelist);
			
			ArrayList filelists = (ArrayList) mv.getModel().get("fileidlist");
			ArrayList filearr = (ArrayList)session.getAttribute("fieldlists");
			System.out.println("filelists in the con"+filelists);
			System.out.println("filearr in the con"+filearr);*/
			
			String[] fileidstring = new String[fileids.size()];
			fileidstring = fileids.toArray(fileidstring);
			
			//String userid = (String) session.getAttribute("userid");// (String) mv.getModel().get("userid");
			
			String userid = (String) session.getAttribute("userid");
			
			PostPreview postprev = new PostPreview();
			postprev.savePost(userid, postdescription, fileidstring,location);
			
			ProfilePreview profprev = new ProfilePreview();
			//ArrayList profileInfo = profprev.getProfileInfo(userid);
			
			//mv.addObject("postlist", profileInfo);
			mv.addObject("name", postdescription);
			return mv;
		}
		
		
		@RequestMapping("/postlink")
		public ModelAndView postlink(
				@RequestParam(value = "postid", required = false, defaultValue = "World") String postid) {
	 
			ModelAndView mv;
			mv = new ModelAndView("/PostLink");
			
			return mv;
		}
		
		
		
}
