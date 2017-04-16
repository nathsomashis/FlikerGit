package com.fliker.Controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.poi.*;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fliker.Modal.CoursePreview;
import com.fliker.Modal.FilePreview;
import com.fliker.Repository.FileUpload;
import com.fliker.Repository.Profile;
import com.fliker.Repository.User;
import com.mongodb.gridfs.GridFSDBFile;

@Controller
public class FileController {

	
	private ArrayList fieldlist = new ArrayList();
	private LinkedList fileidlistone = new LinkedList();
	private LinkedList fileidlisttwo = new LinkedList();
	private LinkedList fileidlistthird = new LinkedList();
	private LinkedList fileidlistfourth = new LinkedList();
	LinkedHashMap weekfirst = new LinkedHashMap();
	LinkedHashMap weeksecond = new LinkedHashMap();
	LinkedHashMap weekthird = new LinkedHashMap();
	LinkedHashMap weekfourth = new LinkedHashMap();
	
	
	@RequestMapping("/file")
	public void showMessage( MultipartHttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile file1, HttpSession session ) {
		System.out.println("in file controller");
 
		/*try {
            Iterator<String> itr = request.getFileNames();

            while (itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                String mimeType = file.getContentType();
                String filename = file.getOriginalFilename();
                byte[] bytes = file.getBytes();

                System.out.println("mimeType"+mimeType+"filename "+filename+" bytes "+bytes);
            }
        }
        catch (Exception e) {
            //return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
		 /*try {
			for (Part part : request.getParts()) { 
			      System.out.println(part.getName()); 
			      InputStream is = request.getPart(part.getName()).getInputStream(); 
			      int i = is.available(); 
			      byte[] b  = new byte[i]; 
			      is.read(b); 
			      System.out.println("Length : " + b.length); 
			      String fileName = getFileName(part); 
			      System.out.println("File name : " + fileName); 
			      FileOutputStream os = new FileOutputStream("c:/temp/logs/" + fileName); 
			      os.write(b); 
			      is.close(); 
			    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		// Getting uploaded files from the request object
        Map<String, MultipartFile> fileMap = request.getFileMap();

        // Maintain a list to send back the files info. to the client side
        List<FileUpload> uploadedFiles = new ArrayList<FileUpload>();

        for (MultipartFile multipartFile : fileMap.values()) {

            // Save the file to local disk
            try {
				saveFileToLocalDisk(multipartFile);
				
				FileUpload fileInfo = getUploadedFileInfo(multipartFile);
				
				System.out.println(fileInfo.getName());
				System.out.println(fileInfo.getSize());
				System.out.println(fileInfo.getType());
				System.out.println(fileInfo.getFileid());
				String fileid = fileInfo.getFileid();
			    fieldlist.add(fileInfo.getFileid());
			    
			    
				FilePreview filepreview = new FilePreview();
			      filepreview.saveFile(fileInfo);
			      
			      
			    
			    
			    
			    session.setAttribute("fileidsimage", fieldlist);
			      
			    ModelMap model = new ModelMap();
				model.addAttribute("fieldlists", fieldlist);
				System.out.println("fieldlist ++"+fieldlist);
				
				
				
				ModelAndView mv = new ModelAndView();
				mv.addObject("fileidlist", fieldlist);
			    
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            //FileUpload fileInfo = getUploadedFileInfo(multipartFile);

            // Save the file info to database
            //fileInfo = saveFileToDatabase(fileInfo);

            // adding the file info to the list
            //uploadedFiles.add(fileInfo);
            
            
            
            
        }
     }
        
        
        
        @RequestMapping("/filesummernote")
        @ResponseBody
    	public String fileSummerupload( MultipartHttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile file1, HttpSession session ) {
    		System.out.println("in file controller");
    		String link="";
    		
    		// Getting uploaded files from the request object
            Map<String, MultipartFile> fileMap = request.getFileMap();

            // Maintain a list to send back the files info. to the client side
            List<FileUpload> uploadedFiles = new ArrayList<FileUpload>();

            for (MultipartFile multipartFile : fileMap.values()) {

                // Save the file to local disk
                try {
    				saveFileToLocalDisk(multipartFile);
    				
    				FileUpload fileInfo = getUploadedFileInfo(multipartFile);
    				
    				System.out.println(fileInfo.getName());
    				System.out.println(fileInfo.getSize());
    				System.out.println(fileInfo.getType());
    				System.out.println(fileInfo.getFileid());
    				String fileid = fileInfo.getFileid();
    			    fieldlist.add(fileInfo.getFileid());
    			    link = "/Fliker/imageController/"+fileid;
    			    
    				FilePreview filepreview = new FilePreview();
    			      filepreview.saveFile(fileInfo);
    			      
    			      
    			    
    			    
    			    
    			    session.setAttribute("fileidsimage", fieldlist);
    			      
    			    ModelMap model = new ModelMap();
    				model.addAttribute("fieldlists", fieldlist);
    				System.out.println("fieldlist ++"+fieldlist);
    				
    				
    				
    				ModelAndView mv = new ModelAndView();
    				mv.addObject("fileidlist", fieldlist);
    			    
    				
    			} catch (FileNotFoundException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}

                
         }   
        System.out.println("link >>"+link);    
        return link;
		
	}
	
	
	@RequestMapping("/fileCourseOne")
	public void fileCourseOne( MultipartHttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile file1, HttpSession session ) {
		System.out.println("in file controller");
 
		String fileids="";
		String filename="";
		
		// Getting uploaded files from the request object
        Map<String, MultipartFile> fileMap = request.getFileMap();

        // Maintain a list to send back the files info. to the client side
        List<FileUpload> uploadedFiles = new ArrayList<FileUpload>();

        for (MultipartFile multipartFile : fileMap.values()) {

            // Save the file to local disk
            try {
				saveFileToLocalDisk(multipartFile);
				
				FileUpload fileInfo = getUploadedFileInfo(multipartFile);
				
				
				
				System.out.println(fileInfo.getName());
				System.out.println(fileInfo.getSize());
				System.out.println(fileInfo.getType());
				System.out.println(fileInfo.getFileid());
				fileids = fileInfo.getFileid();
				filename = fileInfo.getName();
				
				if(filename.endsWith("doc")||filename.endsWith("docx")|| filename.endsWith("pdf")||filename.endsWith("txt")){
					
				}
				
				String fileid = fileInfo.getFileid();
				fileidlistone.add(fileInfo.getFileid());
			    
			    
				FilePreview filepreview = new FilePreview();
			      filepreview.saveFile(fileInfo);
			      
			      
			    
			    
			    
			    session.setAttribute("fileidsimage", fieldlist);
			      
			    ModelMap model = new ModelMap();
				model.addAttribute("fieldlists", fieldlist);
				System.out.println("fieldlist ++"+fieldlist);
				
				
				
				ModelAndView mv = new ModelAndView();
				mv.addObject("fileidlist", fieldlist);
			    
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

     }
        weekfirst.put(fileids, filename);
        fileidlistone.add(filename);
        
        ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfirst", weekfirst);
		
	}

	
	@RequestMapping("/fileCourseOneRemove")
	public void fileCourseOneRemove( HttpServletRequest request,HttpServletResponse response,@RequestParam("file") String file1, HttpSession session ) {
		System.out.println("in file controller");
 
		String fileids="";
		String filenames="";
		
				System.out.println("file1 ><><>"+file1);
				
				Iterator it = weekfirst.entrySet().iterator();
				while(it.hasNext()){
					Map.Entry me = (Map.Entry)it.next();
					if(((String)me.getValue()).equalsIgnoreCase(file1)){
						System.out.println((String)me.getKey());
						it.remove();
					}
				}
				
				
		
	}
	
	@RequestMapping("/fileCourseTwo")
	public void fileCourseTwo( MultipartHttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile file1, HttpSession session ) {
		System.out.println("in file controller");
		
		String fileids = "";
		String filename = "";
 
		// Getting uploaded files from the request object
        Map<String, MultipartFile> fileMap = request.getFileMap();

        // Maintain a list to send back the files info. to the client side
        List<FileUpload> uploadedFiles = new ArrayList<FileUpload>();

        for (MultipartFile multipartFile : fileMap.values()) {

            // Save the file to local disk
            try {
				saveFileToLocalDisk(multipartFile);
				
				FileUpload fileInfo = getUploadedFileInfo(multipartFile);
				
				System.out.println(fileInfo.getName());
				System.out.println(fileInfo.getSize());
				System.out.println(fileInfo.getType());
				System.out.println(fileInfo.getFileid());
				
				fileids = fileInfo.getFileid();
				filename = fileInfo.getName();
				
				String fileid = fileInfo.getFileid();
				fileidlisttwo.add(fileInfo.getFileid());
			    
			    
				FilePreview filepreview = new FilePreview();
			      filepreview.saveFile(fileInfo);
			      
			      
			    
			    
			    
			    session.setAttribute("fileidsimage", fieldlist);
			      
			    ModelMap model = new ModelMap();
				model.addAttribute("fieldlists", fieldlist);
				System.out.println("fieldlist ++"+fieldlist);
				
				
				
				ModelAndView mv = new ModelAndView();
				mv.addObject("fileidlist", fieldlist);
			    
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

     }
        weeksecond.put(fileids, filename);
        
        ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weeksecond", weeksecond);
		
	}
	
	@RequestMapping("/fileCourseThree")
	public void fileCourseThree( MultipartHttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile file1, HttpSession session ) {
		System.out.println("in file controller");
		
		String fileids = "";
		String filenames = "";
 
		// Getting uploaded files from the request object
        Map<String, MultipartFile> fileMap = request.getFileMap();

        // Maintain a list to send back the files info. to the client side
        List<FileUpload> uploadedFiles = new ArrayList<FileUpload>();

        for (MultipartFile multipartFile : fileMap.values()) {

            // Save the file to local disk
            try {
				saveFileToLocalDisk(multipartFile);
				
				FileUpload fileInfo = getUploadedFileInfo(multipartFile);
				
				System.out.println(fileInfo.getName());
				System.out.println(fileInfo.getSize());
				System.out.println(fileInfo.getType());
				System.out.println(fileInfo.getFileid());
				
				fileids = fileInfo.getFileid();
				filenames = fileInfo.getName();
				
				String fileid = fileInfo.getFileid();
				fileidlistthird.add(fileInfo.getFileid());
			    
			    
				FilePreview filepreview = new FilePreview();
			      filepreview.saveFile(fileInfo);
			      
			      
			    
			    
			    
			    session.setAttribute("fileidsimage", fieldlist);
			      
			    ModelMap model = new ModelMap();
				model.addAttribute("fieldlists", fieldlist);
				System.out.println("fieldlist ++"+fieldlist);
				
				
				
				ModelAndView mv = new ModelAndView();
				mv.addObject("fileidlist", fieldlist);
			    
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
     }
        weekthird.put(fileids, filenames);
        
        ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekthird", weekthird);
		
	}
	
	@RequestMapping("/fileCourseFour")
	public void fileCourseFour( MultipartHttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile file1, HttpSession session ) {
		System.out.println("in file controller");
		
		String fileids = "";
		String filenames = "";
 
		// Getting uploaded files from the request object
        Map<String, MultipartFile> fileMap = request.getFileMap();

        // Maintain a list to send back the files info. to the client side
        List<FileUpload> uploadedFiles = new ArrayList<FileUpload>();

        for (MultipartFile multipartFile : fileMap.values()) {

            // Save the file to local disk
            try {
				saveFileToLocalDisk(multipartFile);
				
				FileUpload fileInfo = getUploadedFileInfo(multipartFile);
				
				System.out.println(fileInfo.getName());
				System.out.println(fileInfo.getSize());
				System.out.println(fileInfo.getType());
				System.out.println(fileInfo.getFileid());
				
				fileids = fileInfo.getFileid();
				filenames = fileInfo.getName();
				
				String fileid = fileInfo.getFileid();
				fileidlistfourth.add(fileInfo.getFileid());
			    
			    
				FilePreview filepreview = new FilePreview();
			      filepreview.saveFile(fileInfo);
			      
			      
			    
			    
			    
			    session.setAttribute("fileidsimage", fieldlist);
			      
			    ModelMap model = new ModelMap();
				model.addAttribute("fieldlists", fieldlist);
				System.out.println("fieldlist ++"+fieldlist);
				
				
				
				ModelAndView mv = new ModelAndView();
				mv.addObject("fileidlist", fieldlist);
			    
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
     }
        weekfourth.put(fileids, filenames);
        
        ServletContext context = request.getSession().getServletContext();
		context.setAttribute("weekfourth", weekfourth);
		
	}
	
	
	
	
	
	@RequestMapping("/fileCourse")
	public void fileCourse( MultipartHttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile file1, HttpSession session ) {
		System.out.println("in file controller");
 
		/*try {
            Iterator<String> itr = request.getFileNames();

            while (itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                String mimeType = file.getContentType();
                String filename = file.getOriginalFilename();
                byte[] bytes = file.getBytes();

                System.out.println("mimeType"+mimeType+"filename "+filename+" bytes "+bytes);
            }
        }
        catch (Exception e) {
            //return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
		 /*try {
			for (Part part : request.getParts()) { 
			      System.out.println(part.getName()); 
			      InputStream is = request.getPart(part.getName()).getInputStream(); 
			      int i = is.available(); 
			      byte[] b  = new byte[i]; 
			      is.read(b); 
			      System.out.println("Length : " + b.length); 
			      String fileName = getFileName(part); 
			      System.out.println("File name : " + fileName); 
			      FileOutputStream os = new FileOutputStream("c:/temp/logs/" + fileName); 
			      os.write(b); 
			      is.close(); 
			    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		// Getting uploaded files from the request object
        Map<String, MultipartFile> fileMap = request.getFileMap();

        // Maintain a list to send back the files info. to the client side
        List<FileUpload> uploadedFiles = new ArrayList<FileUpload>();

        for (MultipartFile multipartFile : fileMap.values()) {

            // Save the file to local disk
            try {
				saveFileToLocalDisk(multipartFile);
				
				FileUpload fileInfo = getUploadedFileInfo(multipartFile);
				
				System.out.println(fileInfo.getName());
				System.out.println(fileInfo.getSize());
				System.out.println(fileInfo.getType());
				System.out.println(fileInfo.getFileid());
				String fileid = fileInfo.getFileid();
			    fieldlist.add(fileInfo.getFileid());
			    
			    
				FilePreview filepreview = new FilePreview();
			      filepreview.saveFile(fileInfo);
			      
			      
			    
			    
			    
			    session.setAttribute("fileidsimage", fieldlist);
			      
			    ModelMap model = new ModelMap();
				model.addAttribute("fieldlists", fieldlist);
				System.out.println("fieldlist ++"+fieldlist);
				
				
				
				ModelAndView mv = new ModelAndView();
				mv.addObject("fileidlist", fieldlist);
			    
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            //FileUpload fileInfo = getUploadedFileInfo(multipartFile);

            // Save the file info to database
            //fileInfo = saveFileToDatabase(fileInfo);

            // adding the file info to the list
            //uploadedFiles.add(fileInfo);
            
            
            
     }
		
	}
	
	
	private String getFileName(Part part) { 
	    String partHeader = part.getHeader("content-disposition"); 
	    System.out.println("Part Header = " + partHeader); 
	    for (String cd : part.getHeader("content-disposition").split(";")) { 
	      if (cd.trim().startsWith("filename")) { 
	        return cd.substring(cd.indexOf('=') + 1).trim() 
	            .replace("\"", ""); 
	      } 
	    } 
	    return null;

	  }
	
	
	 private void saveFileToLocalDisk(MultipartFile multipartFile)
             throws IOException, FileNotFoundException {

      String outputFileName = getOutputFilename(multipartFile);
      byte[] imagebytes = multipartFile.getBytes();
      //FileCopyUtils.copy(multipartFile.getBytes(), new FileOutputStream(outputFileName));
      System.out.println(outputFileName);
      System.out.println(imagebytes);
      
      
	 }
	 
	 private String getOutputFilename(MultipartFile multipartFile) {

         return getDestinationLocation() + multipartFile.getOriginalFilename();
	 }
	 
	 private String getDestinationLocation() {
         return "F:/uploaded-files/";
	 }
	 
	 
	 private FileUpload getUploadedFileInfo(MultipartFile multipartFile)
             throws IOException {

		 FileController filcon = new FileController();
		 String uniqueid = "";
		try {
			uniqueid = filcon.makeSHA1Hash(multipartFile.getOriginalFilename());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 FileUpload fileInfo = new FileUpload();
		  fileInfo.setFileid(uniqueid+System.currentTimeMillis());
	      fileInfo.setName(multipartFile.getOriginalFilename());
	      fileInfo.setSize(multipartFile.getSize());
	      fileInfo.setType(multipartFile.getContentType());
	      fileInfo.setLocation(getDestinationLocation());
	      fileInfo.setFileblob(multipartFile.getBytes());
	      /*ByteArrayInputStream stream = new   ByteArrayInputStream(multipartFile.getBytes());
	      String myString = IOUtils.toString(stream, "UTF-8");
	      XWPFWordExtractor  extractor = null;
	      FileInputStream fis = new FileInputStream(getDestinationLocation() + multipartFile.getOriginalFilename());
	      XWPFDocument document = new XWPFDocument(fis);
          extractor = new XWPFWordExtractor(document);
          String fileData = extractor.getText();
          for (int i = 0; i < fileData.length; i++)
          {
              if (fileData[i] != null)
                  System.out.println(fileData[i]);
          }
	      
	      System.out.println("file content"+fileData);*/
      return fileInfo;
	 }
	 
	 
	// @RequestMapping("/Image")
		public void showImage(String id ) {
			System.out.println("in file Image controller");
	 
		
			
		}
		
		@RequestMapping(value = "/imageController/{imageId}")
		@ResponseBody
		public byte[] helloWorld(@PathVariable String imageId)  {
		  
			CoursePreview courseprev = new CoursePreview();
			GridFSDBFile imagecontent = courseprev.getFiles(imageId);
			System.out.println("imagecontent ++"+imagecontent.getInputStream());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				imagecontent.writeTo(baos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] imageblob = baos.toByteArray();
			
		  return imageblob;
		}
		
		@RequestMapping(value = "/imageFromUserid/{userid}")
		@ResponseBody
		public byte[] imageFromId(@PathVariable String userid)  {
		  
			CoursePreview courseprev = new CoursePreview();
			
			Profile profinf = courseprev.profileInfo(userid);
			
			GridFSDBFile imagecontent = courseprev.getFiles(profinf.getProfileImageid());
			System.out.println("imagecontent ++"+imagecontent.getInputStream());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				imagecontent.writeTo(baos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] imageblob = baos.toByteArray();
			
		  return imageblob;
		}
		
		
		public String makeSHA1Hash(String input)
	            throws NoSuchAlgorithmException, UnsupportedEncodingException
	        {
	            MessageDigest md = MessageDigest.getInstance("SHA1");
	            md.reset();
	            byte[] buffer = input.getBytes("UTF-8");
	            md.update(buffer);
	            byte[] digest = md.digest();

	            String hexStr = "";
	            for (int i = 0; i < digest.length; i++) {
	                hexStr +=  Integer.toString( ( digest[i] & 0xff ) + 0x100, 16).substring( 1 );
	            }
	            return hexStr;
	        }
	 
		
		public LinkedHashMap<String,HashMap<LinkedList,String>> parse(){
			
			LinkedHashMap<String,HashMap<LinkedList,String>> assignmentset = new LinkedHashMap<String,HashMap<LinkedList,String>>();
			
			
			
			
			
			
			
			return assignmentset;
		}
		
		
		@RequestMapping("/assignmentUpload")
		public void assignmentupload( MultipartHttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile file1, HttpSession session ) {
			System.out.println("in file controller");
	 
			String fileids="";
			String filename="";
			
			// Getting uploaded files from the request object
	        Map<String, MultipartFile> fileMap = request.getFileMap();

	        // Maintain a list to send back the files info. to the client side
	        List<FileUpload> uploadedFiles = new ArrayList<FileUpload>();

	        for (MultipartFile multipartFile : fileMap.values()) {

	            // Save the file to local disk
	            try {
					
					
					FileUpload fileInfo = getUploadedFileInfo(multipartFile);
					
					
					
					System.out.println(fileInfo.getName());
					System.out.println(fileInfo.getSize());
					System.out.println(fileInfo.getType());
					System.out.println(fileInfo.getFileid());
					fileids = fileInfo.getFileid();
					filename = fileInfo.getName();
					
					if(filename.endsWith("doc")||filename.endsWith("docx")|| filename.endsWith("pdf")||filename.endsWith("txt")){
						
						
						
						
					}
					
					saveFileToLocalDisk(multipartFile);
					
					String fileid = fileInfo.getFileid();
					fileidlistone.add(fileInfo.getFileid());
				    
				    
					FilePreview filepreview = new FilePreview();
				      filepreview.saveFile(fileInfo);
				      
				      
				    
				    
				    
				    session.setAttribute("fileidsimage", fieldlist);
				      
				    ModelMap model = new ModelMap();
					model.addAttribute("fieldlists", fieldlist);
					System.out.println("fieldlist ++"+fieldlist);
					
					
					
					ModelAndView mv = new ModelAndView();
					mv.addObject("fileidlist", fieldlist);
				    
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	     }
	        weekfirst.put(fileids, filename);
	        fileidlistone.add(filename);
	        
	        ServletContext context = request.getSession().getServletContext();
			context.setAttribute("weekfirst", weekfirst);
			
		}
		
}
