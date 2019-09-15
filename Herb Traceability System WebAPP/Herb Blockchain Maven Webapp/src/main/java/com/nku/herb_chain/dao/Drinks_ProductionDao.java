package com.nku.herb_chain.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.nku.herb_chain.connection.Connection;
import com.nku.herb_chain.domain.Drinks_Production;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class Drinks_ProductionDao {
	private Drinks_Production drinks_Production;
	private Connection con;
	
	public Drinks_ProductionDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Drinks_ProductionDao(Drinks_Production drinks_Production, Connection con) {
		super();
		this.drinks_Production = drinks_Production;
		this.con = con;
	}

	public Drinks_Production FindByID(String id){
		con=new Connection();
		drinks_Production=new Drinks_Production();
		String dd1=con.vhttp("myquery/queryHerbDrinksProduction/"+id);
		try {
		JSONObject jsonObject=JSONObject.fromObject(dd1);
		} catch(JSONException ex) {
            return drinks_Production;
        }
		Gson gson = new GsonBuilder().create();
		drinks_Production=gson.fromJson(dd1,Drinks_Production.class);;
		return drinks_Production;		
	}
	
	public boolean insert()
	{
		con=new Connection();
		String ss=con.vhttp("add/addHerbDrinksProduction/");

		System.out.println("ss="+ss);
		if(ss!=null)
			return true;
		
		return false;
	}
	
}
