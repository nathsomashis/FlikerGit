package com.fliker.Modal;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.LogEntry;
import com.mongodb.BasicDBObject;

public class LoggingReview {

	public void entryLogging(String userid){
		
		String logid = "";
		
		MongoConnection mongoconn = new MongoConnection();
		LoggingReview logrev = new LoggingReview();
		
		
		
		
		try {
			logid = logrev.makeSHA1Hash(userid);
			String currtime = String.valueOf(System.currentTimeMillis());
			URL geolocdatfile = LoggingReview.class
                    .getClassLoader().getResource("GeoLiteCity.dat");
			System.out.println("geolocdatfile"+geolocdatfile);
			
			File file = new File("//GeoLiteCity.dat");
			
			LogEntry logentry = new LogEntry(logid, currtime, " ", " ");
			
			;
			mongoconn.saveObject(logrev.formDBObject(logentry, logid), "LoggingEntry");
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public BasicDBObject formDBObject(LogEntry logentry, String logid){
		
		BasicDBObject basicdbobj = new BasicDBObject();
		
		basicdbobj.put("logid", logid);
		basicdbobj.put("logtime", logentry.getLogtime());
		basicdbobj.put("loglocation", logentry.getLoglocation());
		basicdbobj.put("logDescription", logentry.getLogDescription());
		
		return basicdbobj;
		
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
	
	
	public String getlocaladdress(){
		String localhost = "";
		
		try {
			System.out.println("Your Host addr: " + InetAddress.getLocalHost().getHostAddress());  // often returns "127.0.0.1"
		    Enumeration<NetworkInterface> n;
			n = NetworkInterface.getNetworkInterfaces();
			for (; n.hasMoreElements();)
		    {
		        NetworkInterface e = n.nextElement();

		        Enumeration<InetAddress> a = e.getInetAddresses();
		        for (; a.hasMoreElements();)
		        {
		            InetAddress addr = a.nextElement();
		            System.out.println("  " + addr.getHostAddress());
		            localhost = addr.getHostAddress();
		        }
		    }
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
		return localhost;
	}
	
}
