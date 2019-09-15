package com.nku.herb_chain.connection;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
public class Connection {
	private URL url;
	private String kk;
	public StringBuffer buffer;
	private String address;
	public Connection() {
	    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("IpConfig.properties");   
	      Properties p = new Properties();   
	      try {   
	       p.load(inputStream);   
	      } catch (IOException e1) {   
	       e1.printStackTrace();   
	      }   
	   this.address=p.getProperty("ip").toString();  
		// TODO Auto-generated constructor stub
	}
	public Connection(URL url,String kk, StringBuffer buffer) {
		super();
		this.url = url;
		this.kk = kk;
		this.buffer = buffer;   
	}
	
	public String vhttp(String uu) {
		System.out.println("trying to connect--"+address+uu);
	    try {
	        url = new URL(address+uu);
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	    HttpURLConnection conn = null;
	    try {
	        conn = (HttpURLConnection) url.openConnection();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    conn.setConnectTimeout(5 * 3000);
	    InputStream is = null; 
	    try {
	        is = conn.getInputStream();
	        System.out.println("step 2");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    InputStreamReader reader = null;
	    try {
	        int code = conn.getResponseCode();
	        System.out.println("Code=" + code);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    try {
	        reader = new InputStreamReader(is, "UTF-8");
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
	    BufferedReader bufferedReader = new BufferedReader(reader);
	    buffer = new StringBuffer();
	    String str;
	    try {
	        while ((str = bufferedReader.readLine()) != null) {
	            buffer.append(str);
	            buffer.append("\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    kk = buffer.toString();
	    return kk;
	}
}
