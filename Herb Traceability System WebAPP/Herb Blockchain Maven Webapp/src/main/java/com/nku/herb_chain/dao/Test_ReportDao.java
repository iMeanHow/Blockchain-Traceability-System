package com.nku.herb_chain.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.nku.herb_chain.connection.Connection;
import com.nku.herb_chain.domain.Test_Report;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class Test_ReportDao {
	private Test_Report test_Report;
	private Connection con;
	
	public Test_ReportDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Test_ReportDao(Test_Report test_Report, Connection con) {
		super();
		this.test_Report = test_Report;
		this.con = con;
	}

	public Test_Report FindByID(String id){
		con=new Connection();
		test_Report=new Test_Report();
		String dd1=con.vhttp("myquery/queryTestReport/"+id);
		try {
		JSONObject jsonObject=JSONObject.fromObject(dd1);
		} catch(JSONException ex) {
            return test_Report;
        }
		
		Gson gson = new GsonBuilder().create();
		test_Report=gson.fromJson(dd1,Test_Report.class);;
		return test_Report;		
	}
	
	public boolean insert()
	{
		con=new Connection();
		String ss=con.vhttp("add/addTestReport/");
		System.out.println("ss="+ss);
		if(ss!=null)
			return true;
		
		return false;
	}
	
}
