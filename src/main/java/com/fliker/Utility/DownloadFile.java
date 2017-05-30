package com.fliker.Utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadFile {

	public static void main(String[] args) throws IOException {
        InputStream in = null;
        FileOutputStream out = null;
        try {
            // URL("http://downloadplugins.verify.com/Windows/SubAngle.exe");
            System.out.println("Starting download");
            long t1 = System.currentTimeMillis();
            URL url = new URL("http://download.springsource.com/release/TOOLS/update/3.7.1.RELEASE/e4.5/springsource-tool-suite-3.7.1.RELEASE-e4.5.1-updatesite.zip");
            // Open the input and out files for the streams
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            in = conn.getInputStream();
            out = new FileOutputStream("YourFile.exe");
            // Read data into buffer and then write to the output file
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            long t2 = System.currentTimeMillis();
            System.out.println("Time for download & save file in millis:"+(t2-t1));
        } catch (Exception e) {
            // Display or throw the error
            System.out.println("Erorr while execting the program: "
                    + e.getMessage());
        } finally {
            // Close the resources correctly
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

    }
	
}
