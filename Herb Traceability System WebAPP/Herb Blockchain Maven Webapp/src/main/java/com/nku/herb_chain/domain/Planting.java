package com.nku.herb_chain.domain;

import com.alibaba.fastjson.annotation.JSONField;

public class Planting {
	@JSONField(name="ID")
	private String ID;
	@JSONField(name="Company")
	private String Company;
	//	Corporation registration
	@JSONField(name="Business_License")
	private String Business_License;
	@JSONField(name="Contract")
	private String Contract;
	@JSONField(name="Commitment")
	private String Commitment;
	
	//	Planting process management
	@JSONField(name="Plant_Type")
	private String Plant_Type;
	@JSONField(name="Plant_Time")
	private String Plant_Time;
	@JSONField(name="Plant_Area")
	private String Plant_Area;
	@JSONField(name="Harvest_Weight")
	private String Harvest_Weight;
	@JSONField(name="Plan_Production")
	private String Plan_Production;
	@JSONField(name="Real_Production")
	private String Real_Production;
	@JSONField(name="Harvest_Time")
	private String Harvest_Time;
	@JSONField(name="Pesticide_Remain")
	private String Pesticide_Remain;
	@JSONField(name="Content_Test")
	private String Content_Test;
	@JSONField(name="Test_Report")
	private String Test_Report;
	
	//	Certificate of origin
	@JSONField(name="Origin_Certificate")
	private String Origin_Certificate;
	@JSONField(name="Transaction_Voucher")
	private String Transaction_Voucher;
	
	//	Deal registration
	@JSONField(name="Deal_Quantity")
	private String Deal_Quantity;
	@JSONField(name="Deal_Time")
	private String Deal_Time;
	@JSONField(name="Deal_Variety")
	private String Deal_Variety;
	@JSONField(name="Deal_Price")
	private String Deal_Price;
	@JSONField(name="Counterparty")
	private String Counterparty;
	private String Picture_url;
	private String Picture_url1;
	 // 构造函数
	public Planting() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Planting(String iD,String company, String business_License, String contract, String commitment, String plant_Type,
			String plant_Time, String plant_Area, String harvest_Weight, String plan_Production, String real_Production,
			String harvest_Time, String pesticide_Remain, String content_Test, String test_Report,
			String origin_Certificate, String transaction_Voucher, String deal_Quantity, String deal_Time,
			String deal_Variety, String deal_Price, String counterparty,String pictuer_url,String pictuer_url1) {
		super();
		ID = iD;
		Company=company;
		Business_License = business_License;
		Contract = contract;
		Commitment = commitment;
		Plant_Type = plant_Type;
		Plant_Time = plant_Time;
		Plant_Area = plant_Area;
		Harvest_Weight = harvest_Weight;
		Plan_Production = plan_Production;
		Real_Production = real_Production;
		Harvest_Time = harvest_Time;
		Pesticide_Remain = pesticide_Remain;
		Content_Test = content_Test;
		Test_Report = test_Report;
		Origin_Certificate = origin_Certificate;
		Transaction_Voucher = transaction_Voucher;
		Deal_Quantity = deal_Quantity;
		Deal_Time = deal_Time;
		Deal_Variety = deal_Variety;
		Deal_Price = deal_Price;
		Counterparty = counterparty;
		Picture_url=pictuer_url;
		Picture_url1=pictuer_url1;
	}

	//成员方法
	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getPicture_url1() {
		return Picture_url1;
	}

	public void setPicture_url1(String picture_url1) {
		Picture_url1 = picture_url1;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		this.ID = iD;
	}
	public String getBusiness_License() {
		return Business_License;
	}

	public void setBusiness_License(String business_License) {
		this.Business_License = business_License;
	}

	public String getContract() {
		return Contract;
	}

	public void setContract(String contract) {
		this.Contract = contract;
	}

	public String getCommitment() {
		return Commitment;
	}

	public void setCommitment(String commitment) {
		this.Commitment = commitment;
	}

	public String getPlant_Type() {
		return Plant_Type;
	}

	public void setPlant_Type(String plant_Type) {
		this.Plant_Type = plant_Type;
	}

	public String getPlant_Time() {
		return Plant_Time;
	}

	public void setPlant_Time(String plant_Time) {
		this.Plant_Time = plant_Time;
	}

	public String getPlant_Area() {
		return Plant_Area;
	}

	public void setPlant_Area(String plant_Area) {
		this.Plant_Area = plant_Area;
	}

	public String getHarvest_Weight() {
		return Harvest_Weight;
	}

	public void setHarvest_Weight(String harvest_Weight) {
		this.Harvest_Weight = harvest_Weight;
	}

	public String getPlan_Production() {
		return Plan_Production;
	}

	public void setPlan_Production(String plan_Production) {
		this.Plan_Production = plan_Production;
	}

	public String getReal_Production() {
		return Real_Production;
	}

	public void setReal_Production(String real_Production) {
		this.Real_Production = real_Production;
	}

	public String getHarvest_Time() {
		return Harvest_Time;
	}

	public void setHarvest_Time(String harvest_Time) {
		this.Harvest_Time = harvest_Time;
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

	public String getOrigin_Certificate() {
		return Origin_Certificate;
	}

	public void setOrigin_Certificate(String origin_Certificate) {
		this.Origin_Certificate = origin_Certificate;
	}

	public String getTransaction_Voucher() {
		return Transaction_Voucher;
	}

	public void setTransaction_Voucher(String transaction_Voucher) {
		this.Transaction_Voucher = transaction_Voucher;
	}

	public String getDeal_Quantity() {
		return Deal_Quantity;
	}

	public void setDeal_Quantity(String deal_Quantity) {
		this.Deal_Quantity = deal_Quantity;
	}

	public String getDeal_Time() {
		return Deal_Time;
	}

	public void setDeal_Time(String deal_Time) {
		this.Deal_Time = deal_Time;
	}

	public String getDeal_Variety() {
		return Deal_Variety;
	}

	public void setDeal_Variety(String deal_Variety) {
		this.Deal_Variety = deal_Variety;
	}

	public String getDeal_Price() {
		return Deal_Price;
	}

	public void setDeal_Price(String deal_Price) {
		this.Deal_Price = deal_Price;
	}

	public String getCounterparty() {
		return Counterparty;
	}

	public void setCounterparty(String counterparty) {
		this.Counterparty = counterparty;
	}

	public String getPicture_url() {
		return Picture_url;
	}

	public void setPicture_url(String picture_url) {
		Picture_url = picture_url;
	}

	@Override
	public String toString() {
		return "{\"ID\":\"" + ID + "\",\"Company\":\"" + Company + "\",\"Business_License\":\"" + Business_License
				+ "\",\"Contract\":\"" + Contract + "\",\"Commitment\":\"" + Commitment + "\",\"Plant_Type\":\""
				+ Plant_Type + "\",\"Plant_Time\":\"" + Plant_Time + "\",\"Plant_Area\":\"" + Plant_Area
				+ "\",\"Harvest_Weight\":\"" + Harvest_Weight + "\",\"Plan_Production\":\"" + Plan_Production
				+ "\",\"Real_Production\":\"" + Real_Production + "\",\"Harvest_Time\":\"" + Harvest_Time
				+ "\",\"Pesticide_Remain\":\"" + Pesticide_Remain + "\",\"Content_Test\":\"" + Content_Test
				+ "\",\"Test_Report\":\"" + Test_Report + "\",\"Origin_Certificate\":\"" + Origin_Certificate
				+ "\",\"Transaction_Voucher\":\"" + Transaction_Voucher + "\",\"Deal_Quantity\":\"" + Deal_Quantity
				+ "\",\"Deal_Time\":\"" + Deal_Time + "\",\"Deal_Variety\":\"" + Deal_Variety + "\",\"Deal_Price\":\""
				+ Deal_Price + "\",\"Counterparty\":\"" + Counterparty + "\",\"Picture_url\":\"" + Picture_url
				+ "\",\"Picture_url1\":\"" + Picture_url1 + "\"} ";
	}


	
	
}
