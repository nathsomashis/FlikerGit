package com.fliker.Modal;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Post;
import com.fliker.Repository.SearchContent;
import com.fliker.Repository.SearchHistory;
import com.fliker.Repository.SearchResult;
import com.fliker.Utility.DateFunctionality;
import com.fliker.Utility.UploadFileService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class SearchPreview {

	public ArrayList getSearchResult(String searchparam){
		
		ArrayList serchres = new ArrayList();
		//db.users.find({"name": /.*m.*/})
		
		String newSearchparam = ".*"+searchparam+".*";
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("Content_Description", newSearchparam, "Content");
		String uniqueid = "";
		
		UploadFileService upservice = new UploadFileService();
		try {
			uniqueid = upservice.makeSHA1Hash(searchparam);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			SearchContent searchcontent = new SearchContent();
			//searchcontent.get
			searchcontent.getSearchid();
			searchcontent.getContentType();
			searchcontent.getContentDescription();
			searchcontent.getContentLink();
			
			serchres.add(searchcontent);
			
		}
		
		SearchResult searchresult = new SearchResult();
		
		searchresult.setSearchresultid(uniqueid);
		searchresult.setSearchContentid(serchres);
		
		SearchHistory searchhistory = new SearchHistory();
		
		DateFunctionality datefun = new DateFunctionality();
		
		searchhistory.setSearchid(datefun.getCurrentdate());
		searchhistory.setSearchresultid(uniqueid);
		
		
		return serchres;
	}
	
	public ArrayList getSearchResultContent(String searchCategory, String contentsearchparam){
		
		ArrayList serchrescontent = new ArrayList();
		String searchContentCategory = ".*"+contentsearchparam+".*";
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject(searchCategory, searchContentCategory, "Content");
		String uniqueid = "";
		
		UploadFileService upservice = new UploadFileService();
		try {
			uniqueid = upservice.makeSHA1Hash(searchContentCategory);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			SearchContent searchcontent = new SearchContent();
			//searchcontent.get
			searchcontent.getSearchid();
			searchcontent.getContentType();
			searchcontent.getContentDescription();
			searchcontent.getContentLink();
			
			serchrescontent.add(searchcontent);
			
		}
		
		SearchResult searchresult = new SearchResult();
		
		searchresult.setSearchresultid(uniqueid);
		searchresult.setSearchContentid(serchrescontent);
		
		SearchHistory searchhistory = new SearchHistory();
		
		DateFunctionality datefun = new DateFunctionality();
		
		searchhistory.setSearchid(datefun.getCurrentdate());
		searchhistory.setSearchresultid(uniqueid);
		
		
		
		return serchrescontent;
	}
	
	public ArrayList getSearchResultHistory(String historysearchparam){
		
		ArrayList serchreshistory = new ArrayList();
		String historysearchparamTrim = ".*"+historysearchparam+".*";
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("SearchHistory", historysearchparamTrim, "Content");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			SearchHistory searchhist = new SearchHistory();
			searchhist.getSearchid();
			searchhist.getSearchresultid();
			
			serchreshistory.add(searchhist);
			
		}
		
		
		return serchreshistory;
	}
	
	public ArrayList getSearchResultHistoryDefault(String lastid){
		
		ArrayList serchreshistorydefault = new ArrayList();
		
		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("SearchHistory");
		DBCursor cursor;
		if(lastid.isEmpty()){
			cursor = collection.find().limit(50).sort(new BasicDBObject("searchid",-1));
		}else{
			cursor = collection.find(new BasicDBObject("searchid", lastid)).limit(50).sort(new BasicDBObject("searchid",-1));
		}
		
		while(cursor.hasNext()){
			serchreshistorydefault.add(cursor.next());
		}
		
		return serchreshistorydefault;
	}
	
	public void entrySearch(String content, String contentType, HttpServletRequest request, String id, String link){
		
		MongoConnection mongoconn = new MongoConnection();
		SearchPreview searchprev = new SearchPreview();
		SearchContent searchcontent = new SearchContent();
		
		try {
			searchcontent.setSearchid(searchprev.makeSHA1Hash(content));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		searchcontent.setContentDescription(content);
		searchcontent.setContentType(contentType);
		String postlink = searchprev.formLink(request.getRequestURL().toString(), request.getContextPath().toString(),link);
		searchcontent.setContentLink(postlink+id);//post link
		
		mongoconn.saveObject(searchprev.formDBObject(searchcontent), "SearchContent");
	}
	
	public String formLink(String url, String context, String linkadd)throws NullPointerException{
		
		URI uri;
		String domain=null;
		try {
			uri = new URI(url);
			domain = uri.getHost();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		String link = domain+"/"+context+"/"+linkadd+"?";
		
		return link;
		
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
	
	
	public BasicDBObject formDBObject(SearchContent searchcontent){
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("searchid", searchcontent.getSearchid());
		basicdbobj.put("searchdocid", searchcontent.getSearchdocid());
		basicdbobj.put("contentDescription", searchcontent.getContentDescription());
		basicdbobj.put("contentType", searchcontent.getContentType());
		basicdbobj.put("contentLink", searchcontent.getContentLink());
		
		return basicdbobj;
		
	}
	
	
}
