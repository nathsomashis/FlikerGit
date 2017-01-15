package com.fliker.Modal;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

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
