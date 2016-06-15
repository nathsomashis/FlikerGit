package com.fliker.Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fliker.Modal.FilePreview;
import com.fliker.Repository.FileUpload;

@Controller
public class FileController {

	
	@RequestMapping("/file")
	public void showMessage( MultipartHttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile file1 ) {
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
				
				FilePreview filepreview = new FilePreview();
			      filepreview.saveFile(fileInfo);
				
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
         return "D:/uploaded-files/";
	 }
	 
	 
	 private FileUpload getUploadedFileInfo(MultipartFile multipartFile)
             throws IOException {

		 FileUpload fileInfo = new FileUpload();
	      fileInfo.setName(multipartFile.getOriginalFilename());
	      fileInfo.setSize(multipartFile.getSize());
	      fileInfo.setType(multipartFile.getContentType());
	      fileInfo.setLocation(getDestinationLocation());
	      fileInfo.setFileblob(multipartFile.getBytes());
      return fileInfo;
	 }
	 
}
