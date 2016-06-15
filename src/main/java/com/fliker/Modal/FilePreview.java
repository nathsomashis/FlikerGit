package com.fliker.Modal;


import java.net.UnknownHostException;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.FileUpload;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

public class FilePreview {

	public void saveFile(FileUpload fileupload ) throws UnknownHostException{
		
		/*MongoConnection mongoconn = new MongoConnection();
		
		mongoconn.getDBConnection().save(fileupload);*/
		
		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo("127.0.0.1", 27017);
		DB db = mongo.getDB("testdb");
		DBCollection collection = db.getCollection("fileupload");
		
		
		GridFS gridfs = new GridFS(db,"files");
		GridFSInputFile gfsFile = gridfs.createFile(fileupload.getFileblob());
		gfsFile.setFilename(fileupload.getName());
		gfsFile.save();
		
		BasicDBObject info = new BasicDBObject();
        info.put("id", fileupload.getId());
        info.put("name", fileupload.getName());
        info.put("location", fileupload.getLocation());
        info.put("size", fileupload.getSize());
        info.put("type", fileupload.getType());

        //
        // Let's store our document to MongoDB
        //
        collection.insert(info, WriteConcern.SAFE);
		
	}
}
