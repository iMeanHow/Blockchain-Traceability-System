package com.nku.herb_chain.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.nku.herb_chain.connection.Connection;
import com.nku.herb_chain.domain.Use;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class UseDao {
	private Use use;
	private Connection con;
	
	public UseDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UseDao(Use use, Connection con) {
		super();
		this.use = use;
		this.con = con;
	}

	public Use FindByID(String id){
		con=new Connection();
		use=new Use();
		String dd1=con.vhttp("myquery/queryHerbUse/"+id);
		try {
		JSONObject jsonObject=JSONObject.fromObject(dd1);
		} catch(JSONException ex) {
            return use;
        }


		Gson gson = new GsonBuilder().create();
		use=gson.fromJson(dd1,Use.class);;
		return use;		
	}
	
	public boolean insert()
	{
		con=new Connection();
		String ss=con.vhttp("add/addHerbUse/");
		System.out.println("ss="+ss);
		if(ss!=null)
			return true;		
		return false;
	}
}
