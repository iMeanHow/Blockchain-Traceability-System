package com.nku.herb_chain.domain;


import com.alibaba.fastjson.annotation.JSONField;
public class Business {
	@JSONField(name="ID")
	private String ID;
	@JSONField(name="Company")
	private String Company;


	//	Corporation registration
	@JSONField(name="Business_License")
	private String Business_License;
	@JSONField(name="Traceability_Promise")
	private String Traceability_Promise;
	@JSONField(name="GSP_Permission")
	private String GSP_Permission;

	//	Storage management
	@JSONField(name="Variety")
	private String Variety;
	@JSONField(name="Source")
	private String Source;
	@JSONField(name="Storage_Batch")
	private String Storage_Batch;
	@JSONField(name="Storage_Quantity")
	private String Storage_Quantity;
	@JSONField(name="Classification")
	private String Classification;
	@JSONField(name="Product_Enterprise")
	private String Product_Enterprise;
	@JSONField(name="Produce_Time")
	private String Produce_Time;
	@JSONField(name="Flow_Nodes")
	private String Flow_Nodes;

	//	Information gathering
	@JSONField(name="Humidity")
	private String Humidity;

	//	Dealing registration
	@JSONField(name="Deal_Info")
	private String Deal_Info;
	
	
	@JSONField(name="Picture_url")
	private String Picture_url;
	private String Picture_url1;
	//构造函数
	public Business() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Business(String iD,String company, String business_License, String traceability_Promise, String gSP_Permission,
			String variety, String source, String storage_Batch, String storage_Quantity, String classification,
			String product_Enterprise, String produce_Time, String flow_Nodes, String humidity, String deal_Info,String picture_url,String picture_url1) {
		super();
		this.ID = iD;
		this.Company=company;
		this.Business_License = business_License;
		Traceability_Promise = traceability_Promise;
		GSP_Permission = gSP_Permission;
		Variety = variety;
		Source = source;
		Storage_Batch = storage_Batch;
		Storage_Quantity = storage_Quantity;
		Classification = classification;
		Product_Enterprise = product_Enterprise;
		Produce_Time = produce_Time;
		Flow_Nodes = flow_Nodes;
		Humidity = humidity;
		Deal_Info = deal_Info;
		Picture_url=picture_url;
		Picture_url1=picture_url1;
	}
	
	//成员方法
	public String getPicture_url() {
		return Picture_url;
	}

	
	public void setPicture_url(String picture_url) {
		this.Picture_url = picture_url;
	}

	public String getID() {
		return ID;
	}

	public String getPicture_url1() {
		return Picture_url1;
	}


	public void setPicture_url1(String picture_url1) {
		Picture_url1 = picture_url1;
	}


	public void setID(String iD) {
		this.ID = iD;
	}
	
	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		this.Company = company;
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

	public String getGSP_Permission() {
		return GSP_Permission;
	}

	public void setGSP_Permission(String gSP_Permission) {
		this.GSP_Permission = gSP_Permission;
	}

	public String getVariety() {
		return Variety;
	}

	public void setVariety(String variety) {
		this.Variety = variety;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		this.Source = source;
	}

	public String getStorage_Batch() {
		return Storage_Batch;
	}

	public void setStorage_Batch(String storage_Batch) {
		this.Storage_Batch = storage_Batch;
	}

	public String getStorage_Quantity() {
		return Storage_Quantity;
	}

	public void setStorage_Quantity(String storage_Quantity) {
		this.Storage_Quantity = storage_Quantity;
	}

	public String getClassification() {
		return Classification;
	}

	public void setClassification(String classification) {
		this.Classification = classification;
	}

	public String getProduct_Enterprise() {
		return Product_Enterprise;
	}

	public void setProduct_Enterprise(String product_Enterprise) {
		this.Product_Enterprise = product_Enterprise;
	}

	public String getProduce_Time() {
		return Produce_Time;
	}

	public void setProduce_Time(String produce_Time) {
		this.Produce_Time = produce_Time;
	}

	public String getFlow_Nodes() {
		return Flow_Nodes;
	}

	public void setFlow_Nodes(String flow_Nodes) {
		this.Flow_Nodes = flow_Nodes;
	}

	public String getHumidity() {
		return Humidity;
	}

	public void setHumidity(String humidity) {
		this.Humidity = humidity;
	}

	public String getDeal_Info() {
		return Deal_Info;
	}

	public void setDeal_Info(String deal_Info) {
		this.Deal_Info = deal_Info;
	}


	@Override
	public String toString() {
		return "{\"ID\":\"" + ID + "\",\"Company\":\"" + Company + "\",\"Business_License\":\"" + Business_License
				+ "\",\"Traceability_Promise\":\"" + Traceability_Promise + "\",\"GSP_Permission\":\"" + GSP_Permission
				+ "\",\"Variety\":\"" + Variety + "\",\"Source\":\"" + Source + "\",\"Storage_Batch\":\""
				+ Storage_Batch + "\",\"Storage_Quantity\":\"" + Storage_Quantity + "\",\"Classification\":\""
				+ Classification + "\",\"Product_Enterprise\":\"" + Product_Enterprise + "\",\"Produce_Time\":\""
				+ Produce_Time + "\",\"Flow_Nodes\":\"" + Flow_Nodes + "\",\"Humidity\":\"" + Humidity
				+ "\",\"Deal_Info\":\"" + Deal_Info + "\",\"Picture_url\":\"" + Picture_url + "\",\"Picture_url1\":\""
				+ Picture_url1 + "\"} ";
	}




	

	
}
