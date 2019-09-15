package com.nku.herb_chain.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.nku.herb_chain.connection.Connection;
import com.nku.herb_chain.domain.Enterprise;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class EnterpriseDao {
	private Enterprise enterprise;
	private Connection con;
	
	public EnterpriseDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EnterpriseDao(Enterprise enterprise, Connection con) {
		super();
		this.enterprise = enterprise;
		this.con = con;
	}

	public Enterprise FindByID(String id){
		con=new Connection();
		enterprise=new Enterprise();
		String dd1=con.vhttp("myquery/queryHerbEnterprise/"+id);
		try {
		JSONObject jsonObject=JSONObject.fromObject(dd1);
		} catch(JSONException ex) {
            return enterprise;
        }
		Gson gson = new GsonBuilder().create();
		enterprise=gson.fromJson(dd1,Enterprise.class);;
		return enterprise;		
	}
	
	public boolean insert()
	{
		con=new Connection();
		String ss=con.vhttp("add/addHerbEnterprise/");
		System.out.println("ss="+ss);
		if(ss!=null)
			return true;	
		return false;
	}
}
