package com.fliker.Utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;

public class FileDirectoryFormat {

	HashMap foldermap = new HashMap();
	public static void main(String args[]){
		 ZipFile zipFile = null;
		 FileDirectoryFormat filedirec = new FileDirectoryFormat();
		
		try {
			zipFile = new ZipFile("C:\\Users\\naths\\Desktop\\FlikerGit-master (2).zip");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		    Enumeration<? extends ZipEntry> entries = zipFile.entries();
		    LinkedList<String> filelist = null;
		    String foldername = "";

		    TreeNode<String> root = new TreeNode<String>("root");
		    TreeNode<String> treeroot = null;
		    StringBuffer filbuff =  new StringBuffer();
		    
		    while(entries.hasMoreElements()){
		        ZipEntry entry = entries.nextElement();
		        //System.out.println("Entry ::"+entry.getName());
		        
					try {
						InputStream stream = zipFile.getInputStream(entry);
						byte[] bytes = IOUtils.toByteArray(stream);
					//System.out.println("Stream ::"+stream);
					
					
					
					if(entry.isDirectory()){
						//filelist = new LinkedList<String>();
						if(treeroot!=null){
						for (TreeNode<String> node : treeroot) {
							//String filelists = filbuff.substring(0, filbuff.length()-1);
							node.data = node.data+" ::Files List ::"+filbuff.toString();
							System.out.println("Inside Loop ::" + node.data);
							}
						}
						filbuff =  new StringBuffer();
						System.out.println("directory ::"+entry.getName());
						
						
							int lastbracket = entry.getName().lastIndexOf("/");
							String extraname = entry.getName().substring(0, lastbracket);
						
							TreeNode<String> acceptedtree = filedirec.getRoot(extraname);
						
							
							
							
							String[] folders = entry.getName().split("/");
							String[] folderlast = (folders[folders.length-1]).split(",");
							
							
							if(folders.length>0){
								if(folders.length == 2){
									treeroot = filedirec.getFoldertree(root, folders, 0,extraname,acceptedtree);
								}else{
									treeroot = filedirec.getFoldertree(root, folderlast, 0,extraname,acceptedtree);
								}
							
							
							
							//System.out.println(treeroot);
							
							for (TreeNode<String> node : treeroot) {
								String indent = createIndent(node.getLevel());
								//System.out.println("Inside Loop ::"+indent + node.data);
							}
							
							}
							
							
							//foldertree.put(foldername, filelist);
						}else{
							//filelist.add(entry.getName());
							filbuff.append(entry.getName()+",");
							//foldername = entry.getName();
							System.out.println("Files ::"+entry.getName());
						}
					
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        
		        /*zipupload.jsonFormat(foldertree);
				zipupload.divformat(foldertree);*/
				
				//fas.write((jsonstatem.toString()).getBytes());
				//System.out.println(jsonstatem.toString());
			
	        
	        
		    }
		    
		    
		    TreeNode<String> treeRoot = root;
			for (TreeNode<String> node : treeRoot) {
				String indent = createIndent(node.getLevel());
				System.out.println("Last ::"+indent + node.data+ node.getLevel());
			}
		    
		
	}
	
	
	public TreeNode getFoldertree(TreeNode roottree, String[] child, int i, String extraname, TreeNode acceptedtree){
		
		
		if(i<child.length){
			/*HashMap<String, LinkedList<String>> datamap = new HashMap<String, LinkedList<String>>();
			LinkedList valuelist = new LinkedList();
			datamap.put(child[i], valuelist);*/
			TreeNode<String> currentroot = null;
			
			if(acceptedtree!=null){
				currentroot = acceptedtree.addChild(child[i]);
				if(i==(child.length-1)){
					foldermap.put(extraname, currentroot);
				}
			}else{
				currentroot = roottree.addChild(child[i]);
				foldermap.put(extraname, currentroot);
			}
			
			i=i+1;
			return getFoldertree(currentroot,child,i,extraname,acceptedtree);
		}else{
			return roottree;
		}
		
	}
	
	public TreeNode<String> getRoot(String extraname){
		
		String newextraparam = extraname.substring(0, extraname.lastIndexOf("/"));
		
		TreeNode<String> terminal = null;
		TreeNode<String> currentroot = null;
		Set folderset = foldermap.entrySet();
		Iterator folderit = folderset.iterator();
		while(folderit.hasNext()){
			Map.Entry mefolder = (Map.Entry)folderit.next();
			if(((String)mefolder.getKey()).equalsIgnoreCase(newextraparam)){
				terminal = (TreeNode<String>)mefolder.getValue();
			}
			
		}
		
		return terminal;
	}
	
	
	private static String createIndent(int depth) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			sb.append(' ');
		}
		return sb.toString();
	}
}
