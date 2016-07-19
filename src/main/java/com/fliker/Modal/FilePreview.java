package com.fliker.Modal;


import java.net.UnknownHostException;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.FileUpload;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteConcern;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

public class FilePreview {

	public void saveFile(FileUpload fileupload ) throws UnknownHostException{
		
		/*MongoConnection mongoconn = new MongoConnection();
		
		mongoconn.getDBConnection().save(fileupload);*/
		
		MongoClientURI uri  = new MongoClientURI("mongodb://admin:admin@ds021663.mlab.com:21663/fliker");
        MongoClient client = new MongoClient(uri);
        DB db = client.getDB(uri.getDatabase());

        DBCollection collection = db.getCollection("fileupload");
		//DBCollection collection = mongoconn.getDBConnection("fileupload");
		
		
		GridFS gridfs = new GridFS(db,"files");
		GridFSInputFile gfsFile = gridfs.createFile(fileupload.getFileblob());
		gfsFile.setFilename(fileupload.getName());
		gfsFile.save();
		
		BasicDBObject info = new BasicDBObject();
        info.put("id", fileupload.getFileid());
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
