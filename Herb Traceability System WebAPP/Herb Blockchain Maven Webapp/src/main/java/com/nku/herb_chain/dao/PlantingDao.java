package com.nku.herb_chain.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.nku.herb_chain.connection.Connection;
import com.nku.herb_chain.domain.Planting;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class PlantingDao {
	
	private Planting planting;
	private Connection con;
	
	public PlantingDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PlantingDao(Planting planting, Connection con) {
		super();
		this.planting = planting;
		this.con = con;
	}

	public Planting FindByID(String id){
		con=new Connection();
		planting=new Planting();
		String dd1=con.vhttp("myquery/queryHerbPlanting/"+id);
		try {
		JSONObject jsonObject=JSONObject.fromObject(dd1);
		} catch(JSONException ex) {
            return planting;
        }
		
		Gson gson = new GsonBuilder().create();
		planting=gson.fromJson(dd1,Planting.class);;
		return planting;		
	}
	
	public boolean insert()
	{
		con=new Connection();
		String ss=con.vhttp("add/addHerbPlanting/");
		System.out.println("ss="+ss);
		if(ss!=null)
			return true;
		
		return false;
	}
}
