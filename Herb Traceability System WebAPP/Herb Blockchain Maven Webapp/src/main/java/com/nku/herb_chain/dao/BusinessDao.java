package com.nku.herb_chain.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.nku.herb_chain.connection.Connection;
import com.nku.herb_chain.domain.Business;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class BusinessDao 
{
	private Business business;
	private Connection con;	
	public BusinessDao() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BusinessDao(Business business, Connection con) {
		super();
		this.business = business;
		this.con = con;
	}

	public Business FindByID(String id){

		con=new Connection();
		business=new Business();
		String dd1=con.vhttp("myquery/queryHerbBusiness/"+id);
		try {
			JSONObject jsonObject=JSONObject.fromObject(dd1);
		} catch(JSONException ex) {
			ex.printStackTrace();
            return business;
        }
		//System.out.println(jsonObject);
		
		Gson gson = new GsonBuilder().create();
		business=gson.fromJson(dd1,Business.class);
		System.out.println(business);
		return business;		
	}
	
	public boolean insert()
	{
		con=new Connection();
		String ss=con.vhttp("add/addHerbBusiness/");
		System.out.println("ss="+ss);
		if(ss!=null)
			return true;	
		return false;
	}
	
	public boolean change(Business p)
	{
		return true;
	}
	
	
}
