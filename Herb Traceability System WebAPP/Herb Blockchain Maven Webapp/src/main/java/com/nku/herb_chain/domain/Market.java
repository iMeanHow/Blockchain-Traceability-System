package com.nku.herb_chain.domain;

public class Market {
	private String ID;
	private String Company;
	//	Corporation registration
	private String Business_License;
	private String Traceability_Promise;

	//	Marketing registration
	private String Wholesaler;
	private String Marketing_Variety;
	private String Marketing_Quantity;
	private String Origin_Certificate;
	private String Enterprise;

	//	Testing registration
	private String Pesticide_Remain;
	private String Content_Test;
	private String Test_Report;	//	Test_Report struct

	//	Deal registration
	private String Dealing_Variety;
	private String Dealing_Price;
	private String Dealing_Quantity;
	private String Dealing_Counterparty;
	private String Dealing_Flow;
	private String Picture_url;
	private String Picture_url1;
	// 构造函数
	public Market() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Market(String iD, String company,String business_License, String traceability_Promise, String wholesaler,
			String marketing_Variety, String marketing_Quantity, String origin_Certificate, String enterprise,
			String pesticide_Remain, String content_Test, String test_Report, String dealing_Variety,
			String dealing_Price, String dealing_Quantity, String dealing_Counterparty, String dealing_Flow,String picture_url,String picture_url1) {
		super();
		ID = iD;
		Company=company;
		Business_License = business_License;
		Traceability_Promise = traceability_Promise;
		Wholesaler = wholesaler;
		Marketing_Variety = marketing_Variety;
		Marketing_Quantity = marketing_Quantity;
		Origin_Certificate = origin_Certificate;
		Enterprise = enterprise;
		Pesticide_Remain = pesticide_Remain;
		Content_Test = content_Test;
		Test_Report = test_Report;
		Dealing_Variety = dealing_Variety;
		Dealing_Price = dealing_Price;
		Dealing_Quantity = dealing_Quantity;
		Dealing_Counterparty = dealing_Counterparty;
		Dealing_Flow = dealing_Flow;
		Picture_url=picture_url;
		Picture_url1=picture_url1;
	}


	//成员方法
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		this.ID = iD;
	}
	
	public String getPicture_url() {
		return Picture_url;
	}

	public void setPicture_url(String picture_url) {
		Picture_url = picture_url;
	}

	public String getPicture_url1() {
		return Picture_url1;
	}

	public void setPicture_url1(String picture_url1) {
		Picture_url1 = picture_url1;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getBusiness_License() {
		return Business_License;
	}
	
	public void setBusiness_License(String business_License) {
		this.Business_License = business_License;
	}

	public String getTraceability_Promise() {
		return Traceability_Promise;
	}

	public void setTraceability_Promise(String traceability_Promise) {
		this.Traceability_Promise = traceability_Promise;
	}

	public String getWholesaler() {
		return Wholesaler;
	}

	public void setWholesaler(String wholesaler) {
		this.Wholesaler = wholesaler;
	}

	public String getMarketing_Variety() {
		return Marketing_Variety;
	}

	public void setMarketing_Variety(String marketing_Variety) {
		this.Marketing_Variety = marketing_Variety;
	}

	public String getMarketing_Quantity() {
		return Marketing_Quantity;
	}

	public void setMarketing_Quantity(String marketing_Quantity) {
		this.Marketing_Quantity = marketing_Quantity;
	}

	public String getOrigin_Certificate() {
		return Origin_Certificate;
	}

	public void setOrigin_Certificate(String origin_Certificate) {
		this.Origin_Certificate = origin_Certificate;
	}

	public String getEnterprise() {
		return Enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.Enterprise = enterprise;
	}

	public String getPesticide_Remain() {
		return Pesticide_Remain;
	}

	public void setPesticide_Remain(String pesticide_Remain) {
		this.Pesticide_Remain = pesticide_Remain;
	}

	public String getContent_Test() {
		return Content_Test;
	}

	public void setContent_Test(String content_Test) {
		this.Content_Test = content_Test;
	}

	public String getTest_Report() {
		return Test_Report;
	}

	public void setTest_Report(String test_Report) {
		this.Test_Report = test_Report;
	}

	public String getDealing_Variety() {
		return Dealing_Variety;
	}

	public void setDealing_Variety(String dealing_Variety) {
		this.Dealing_Variety = dealing_Variety;
	}

	public String getDealing_Price() {
		return Dealing_Price;
	}

	public void setDealing_Price(String dealing_Price) {
		this.Dealing_Price = dealing_Price;
	}

	public String getDealing_Quantity() {
		return Dealing_Quantity;
	}

	public void setDealing_Quantity(String dealing_Quantity) {
		this.Dealing_Quantity = dealing_Quantity;
	}

	public String getDealing_Counterparty() {
		return Dealing_Counterparty;
	}

	public void setDealing_Counterparty(String dealing_Counterparty) {
		this.Dealing_Counterparty = dealing_Counterparty;
	}

	public String getDealing_Flow() {
		return Dealing_Flow;
	}

	public void setDealing_Flow(String dealing_Flow) {
		this.Dealing_Flow = dealing_Flow;
	}

	@Override
	public String toString() {
		return "{\"ID\":\"" + ID + "\",\"Company\":\"" + Company + "\",\"Business_License\":\"" + Business_License
				+ "\",\"Traceability_Promise\":\"" + Traceability_Promise + "\",\"Wholesaler\":\"" + Wholesaler
				+ "\",\"Marketing_Variety\":\"" + Marketing_Variety + "\",\"Marketing_Quantity\":\""
				+ Marketing_Quantity + "\",\"Origin_Certificate\":\"" + Origin_Certificate + "\",\"Enterprise\":\""
				+ Enterprise + "\",\"Pesticide_Remain\":\"" + Pesticide_Remain + "\",\"Content_Test\":\"" + Content_Test
				+ "\",\"Test_Report\":\"" + Test_Report + "\",\"Dealing_Variety\":\"" + Dealing_Variety
				+ "\",\"Dealing_Price\":\"" + Dealing_Price + "\",\"Dealing_Quantity\":\"" + Dealing_Quantity
				+ "\",\"Dealing_Counterparty\":\"" + Dealing_Counterparty + "\",\"Dealing_Flow\":\"" + Dealing_Flow
				+ "\",\"Picture_url\":\"" + Picture_url + "\",\"Picture_url1\":\"" + Picture_url1 + "\"} ";
	}



}
