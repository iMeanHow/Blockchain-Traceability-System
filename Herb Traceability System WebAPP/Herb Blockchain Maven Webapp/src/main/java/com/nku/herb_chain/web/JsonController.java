package com.nku.herb_chain.web;
import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/url")
public class JsonController {
	private static String address="http://upgrade.iclassedu.com/doudou/upgrade/student/beijiaodd/android.json";
	private URL url;
	private String kk;
	public StringBuffer buffer;
	
	
    @RequestMapping(value = "/getURL",  produces="text/html;charset=UTF-8")
    @ResponseBody
    public  String getURL(String callback)
    {
    	System.out.println("geturl");
    	String JsonString=vhttp();
    	System.out.println(JsonString);
    	JSONObject jsonObject=JSONObject.fromObject(JsonString);
    	String download=jsonObject.getString("filePath");
    	System.out.println("download url="+download);
    	return callback+"("+jsonObject.toString()+")";
    }

    
    public String vhttp() {
		System.out.println("trying to connect--"+address);
	    try {
	        url = new URL(address);
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
