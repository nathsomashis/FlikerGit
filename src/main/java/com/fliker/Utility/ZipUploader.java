package com.fliker.Utility;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ZipUploader {

	
	public static void main(String[] args) {
        
		 ZipFile zipFile = null;
		
		 
		try{ 
		 DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
		Document doc = docBuilder.newDocument();
		
		}catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  }
		 
		try {
			zipFile = new ZipFile("C:\\Users\\naths\\Desktop\\FlikerGit-master.zip");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		    Enumeration<? extends ZipEntry> entries = zipFile.entries();

		    while(entries.hasMoreElements()){
		        ZipEntry entry = entries.nextElement();
		        System.out.println("Entry ::"+entry.getName());
		        try {
					InputStream stream = zipFile.getInputStream(entry);
					byte[] bytes = IOUtils.toByteArray(stream);
					//System.out.println("Stream ::"+stream);
					
					if(entry.getName().equalsIgnoreCase("Dumps/CSSA Questions_Sujit.doc")){
						FileOutputStream fos = new FileOutputStream("C:\\Users\\naths\\Desktop\\NewDumps\\Questions_Sujit.doc");
						fos.write(bytes);
						fos.close();
					}
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
    }
	
	
	
	
	
	public String getXMlFormat(String entry,Document doc){
		
		String[] docentry = entry.split("/");
		NodeList nodesfirst = doc.getElementsByTagName("root");
		
		String xmlform = "";
	try {
		
		for(int m=0;m<docentry.length;m++){
			
			/*NodeList nodesfirst = doc.getElementsByTagName(docentry[m]);
			if(nodesfirst.getLength()<0){
				Element rootElement = doc.createElement(docentry[m]);
				doc.appendChild(rootElement);
			}else{
				for (int i = 0; i < nodesfirst.getLength(); i++) {
				      Element element = (Element) nodesfirst.item(i);
				      element.getElementsByTagName(docentry[m+1]);
				      
				      
				    }
			}*/
			
			ZipUploader zipuplioad = new ZipUploader();
			
			//zipuplioad.callBackDoc();
			
		}
		
		Element rootElement = doc.createElement("company");
		doc.appendChild(rootElement);

		// staff elements
		Element staff = doc.createElement("Staff");
		rootElement.appendChild(staff);

		// set attribute to staff element
		Attr attr = doc.createAttribute("id");
		attr.setValue("1");
		staff.setAttributeNode(attr);

		// shorten way
		// staff.setAttribute("id", "1");

		// firstname elements
		Element firstname = doc.createElement("firstname");
		firstname.appendChild(doc.createTextNode("yong"));
		staff.appendChild(firstname);

		// lastname elements
		Element lastname = doc.createElement("lastname");
		lastname.appendChild(doc.createTextNode("mook kim"));
		staff.appendChild(lastname);

		// nickname elements
		Element nickname = doc.createElement("nickname");
		nickname.appendChild(doc.createTextNode("mkyong"));
		staff.appendChild(nickname);

		// salary elements
		Element salary = doc.createElement("salary");
		salary.appendChild(doc.createTextNode("100000"));
		staff.appendChild(salary);

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("C:\\Users\\naths\\Desktop\\file.xml"));

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!"+result.toString());

	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
		
		
		return xmlform;
		
	}





	private void callBackDoc(Element rootElement,String[] elementstr,Document doc, int number) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	
}
