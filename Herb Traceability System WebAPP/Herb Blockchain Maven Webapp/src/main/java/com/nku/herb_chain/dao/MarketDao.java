package com.nku.herb_chain.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.nku.herb_chain.connection.Connection;
import com.nku.herb_chain.domain.Market;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class MarketDao {
	private Market market;
	private Connection con;
	
	public MarketDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MarketDao(Market market, Connection con) {
		super();
		this.market = market;
		this.con = con;
	}

	public Market FindByID(String id){
		con=new Connection();
		market=new Market();
		String dd1=con.vhttp("myquery/queryHerbMarket/"+id);
		try {
		JSONObject jsonObject=JSONObject.fromObject(dd1);
		} catch(JSONException ex) {
            return market;
        }

		Gson gson = new GsonBuilder().create();
		market=gson.fromJson(dd1,Market.class);;
		return market;		
	}
	
	public boolean insert()
	{
		con=new Connection();
		String ss=con.vhttp("add/addHerbMarket/");
		System.out.println("ss="+ss);
		if(ss!=null)
			return true;	
		return false;
	}
}
