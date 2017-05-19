/*package com.fliker.Utility;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ZipUploader {

	
	public static void main(String[] args) {
        
		 ZipFile zipFile = null;
		 Element rootElement = null;
		 Document doc = null;
		 FileOutputStream fos = null;
		 FileOutputStream fas = null;
		 
		 ZipUploader zipupload = new ZipUploader();
		try {
			fos = new FileOutputStream("C:\\Users\\naths\\Desktop\\NewDumps\\FilesList.doc");
			fas = new FileOutputStream("C:\\Users\\naths\\Desktop\\NewDumps\\FilesListDirectory.doc");
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 
		TreeMap<String,LinkedList<String>> foldertree = new TreeMap<String,LinkedList<String>>();	
		
		TreeMap<String,Object> foldermap = new TreeMap<String,Object>();
			
		 
		try {
			zipFile = new ZipFile("C:\\Users\\naths\\Desktop\\FlikerGit-master (2).zip");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		    Enumeration<? extends ZipEntry> entries = zipFile.entries();
		    LinkedList<String> filelist = null;
		    String foldername = "";

		    while(entries.hasMoreElements()){
		        ZipEntry entry = entries.nextElement();
		        //System.out.println("Entry ::"+entry.getName());
		        try {
					InputStream stream = zipFile.getInputStream(entry);
					byte[] bytes = IOUtils.toByteArray(stream);
					//System.out.println("Stream ::"+stream);
					
					
					
					if(entry.isDirectory()){
						//System.out.println("directory ::"+entry.getName());
						
						if((filelist !=null)&&(!filelist.isEmpty()) && (!foldername.isEmpty())){
							String[] folders = foldername.split("/");
							
							TreeNode<String> root = new TreeNode<String>("root");
							TreeNode<String> treeroot = zipupload.getFoldertree(root, folders, 0);
								
							}
							
							foldertree.put(foldername, filelist);
						}
						
						filelist = new LinkedList<String>();
						foldername = entry.getName();
						
					}else{
						//fos.write(entry.getName().getBytes());
						filelist.add(entry.getName());
					}
					
					
					ZipUploader zipupload = new ZipUploader();
					zipupload.callBackDoc(rootElement, elementstr, doc, 0);
					
					if(entry.getName().equalsIgnoreCase("Dumps/CSSA Questions_Sujit.doc")){
						FileOutputStream fos = new FileOutputStream("C:\\Users\\naths\\Desktop\\NewDumps\\Questions_Sujit.doc");
						fos.write(bytes);
						fos.close();
					}
					//System.out.println(foldertree.values());
					
					String jsonstring = '"'+"";
					StringBuffer jsonstatem = new StringBuffer();
					//jsonstatem.append(jsonstring);
					
					
					
					
					Set treeset = foldertree.entrySet();
					Iterator treeit = treeset.iterator();
					while(treeit.hasNext()){
						Map.Entry metree = (Map.Entry)treeit.next();
						StringBuffer filebuff = new StringBuffer();
						String folderlocation = "{"+'"'+(String)metree.getKey()+'"'+":[";
						filebuff.append(folderlocation);
						
						
						//fas.write(((String)metree.getKey()).getBytes());
						LinkedList fileslist = (LinkedList)metree.getValue();
						StringBuffer filemodify = new StringBuffer();
						for(int k=0;k<fileslist.size();k++){
							
							String files = "{"+'"'+(String)fileslist.get(k)+'"'+"}"+",";
							filemodify.append(files);
							
						}
						String filetomodify = filemodify.substring(0, filemodify.length()-1);
						filebuff.append(filemodify);
						//fas.write((filebuff.toString()).getBytes());
						String ending = "]"+"},";
						filebuff.append(ending);
						
						jsonstatem.append(filebuff.toString());
					}
					
					zipupload.jsonFormat(foldertree);
					zipupload.divformat(foldertree);
					
					//fas.write((jsonstatem.toString()).getBytes());
					//System.out.println(jsonstatem.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        
		    }
		    try {
				fos.close();
				fas.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
	
	public TreeNode getFoldertree(TreeNode roottree, String[] child, int i){
			
			if(i<child.length)TreeNode<String> currentroot = roottree.addChild(child[i]);
			
			
		return getFoldertree(currentroot,String[] child,i++);
	}
	
	
	private void divformat(TreeMap<String, LinkedList<String>> foldertree) {
		// TODO Auto-generated method stub
		
		
		
		
	}


	public String jsonFormat(TreeMap foldertree){
		String jsonstring = '"'+"";
		StringBuffer jsonstatem = new StringBuffer();
		Set treeset = foldertree.entrySet();
		Iterator treeit = treeset.iterator();
		while(treeit.hasNext()){
			Map.Entry metree = (Map.Entry)treeit.next();
			StringBuffer filebuff = new StringBuffer();
			String folderlocation = "{"+'"'+(String)metree.getKey()+'"'+":[";
			filebuff.append(folderlocation);
			
			
			//fas.write(((String)metree.getKey()).getBytes());
			LinkedList fileslist = (LinkedList)metree.getValue();
			StringBuffer filemodify = new StringBuffer();
			for(int k=0;k<fileslist.size();k++){
				
				String files = "{"+'"'+(String)fileslist.get(k)+'"'+"}"+",";
				filemodify.append(files);
				
			}
			String filetomodify = filemodify.substring(0, filemodify.length()-1);
			filebuff.append(filemodify);
			//fas.write((filebuff.toString()).getBytes());
			String ending = "]"+"},";
			filebuff.append(ending);
			
			jsonstatem.append(filebuff.toString());
		}
		
		return jsonstatem.toString();
	}
	
	
	





	public String getXMlFormat(String entry,Document doc){
		
		String[] docentry = entry.split("/");
		NodeList nodesfirst = doc.getElementsByTagName("root");
		
		String xmlform = "";
	try {
		
		for(int m=0;m<docentry.length;m++){
			
			NodeList nodesfirst = doc.getElementsByTagName(docentry[m]);
			if(nodesfirst.getLength()<0){
				Element rootElement = doc.createElement(docentry[m]);
				doc.appendChild(rootElement);
			}else{
				for (int i = 0; i < nodesfirst.getLength(); i++) {
				      Element element = (Element) nodesfirst.item(i);
				      element.getElementsByTagName(docentry[m+1]);
				      
				      
				    }
			}
			
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





	public void callBackDoc(Element rootElement,String[] elementstr,Document doc, int number) {
		// TODO Auto-generated method stub
		NodeList node = rootElement.getChildNodes(); //get the child elements
		String nodeset = "false";
        System.out.println(node.getLength());
        for(int k=0; k<node.getLength();k++){
            Node currentNode = node.item(k);
            Element currentelement = (Element)currentNode;
            if(currentelement.getElementsByTagName(elementstr[number]).getLength()>0){
            	callBackDoc(currentelement,elementstr,doc,number+1);
            	
            }else{
            	if(k==(node.getLength()-1)){
            		nodeset = "true";
            	}
            }
		
        }
        
        if(nodeset.equalsIgnoreCase("true") || node.getLength() == 0){
        	ZipUploader zipupload = new ZipUploader();
        	zipupload.xmlformat(rootElement, elementstr, doc, number);
        }
	}
        
    public void xmlformat(Element rootElement,String[] elementstr,Document doc,int number){
    	
    	LinkedList elementlist  = new LinkedList();
    	for(int m=0;m<elementstr.length;m++){
    		
    			Element newElement = doc.createElement(elementstr[m]);
    			elementlist.add(newElement);
    		
    	}
    	
    	for(int j=1;j<elementlist.size();j++){
    		Element currentelement = (Element) elementlist.get(j);
    		for(int n=0;n<=j;n++){
    			Element nextElement = (Element) elementlist.get(j);
    			nextElement.appendChild(currentelement);
    		}
    	}
    	
    	rootElement.appendChild((Element) elementlist.get(0));
    	
    }
	
	
}
*/