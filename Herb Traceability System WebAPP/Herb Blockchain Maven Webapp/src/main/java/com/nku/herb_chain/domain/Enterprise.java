package com.nku.herb_chain.domain;

public class Enterprise {
	private String ID;
	private String Company;
	private String Traceability_Promise;
 	private String Business_License;

 	//	Storage management
 	private String Product_Batch;
 	private String Save_Time;
 	private String Source;
 	
 	//	Information gathering
 	private String Save_Temp;
 	private String Save_Humidity;

 	//	Transaction voucher
 	private String Transaction_Voucher;
 	private String Picture_url;
 	//构造函数
	public Enterprise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enterprise(String iD,String company,String traceability_Promise, String business_License, String product_Batch, String save_Time,
			String source, String save_Temp, String save_Humidity, String transaction_Voucher,String pictuer_url) {
		super();
		ID=iD;
		Company=company;
		Traceability_Promise = traceability_Promise;
		Business_License = business_License;
		Product_Batch = product_Batch;
		Save_Time = save_Time;
		Source = source;
		Save_Temp = save_Temp;
		Save_Humidity = save_Humidity;
		Transaction_Voucher = transaction_Voucher;
		Picture_url=pictuer_url;
	}
 		
 	//成员方法
	
 	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getPicture_url() {
		return Picture_url;
	}

	public void setPicture_url(String picture_url) {
		Picture_url = picture_url;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		this.ID = iD;
	}	
	
	public String getTraceability_Promise() {
		return Traceability_Promise;
	}



	public void setTraceability_Promise(String traceability_Promise) {
		this.Traceability_Promise = traceability_Promise;
	}

	public String getBusiness_License() {
		return Business_License;
	}

	public void setBusiness_License(String business_License) {
		this.Business_License = business_License;
	}

	public String getProduct_Batch() {
		return Product_Batch;
	}

	public void setProduct_Batch(String product_Batch) {
		this.Product_Batch = product_Batch;
	}

	public String getSave_Time() {
		return Save_Time;
	}

	public void setSave_Time(String save_Time) {
		this.Save_Time = save_Time;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		this.Source = source;
	}

	public String getSave_Temp() {
		return Save_Temp;
	}

	public void setSave_Temp(String save_Temp) {
		this.Save_Temp = save_Temp;
	}

	public String getSave_Humidity() {
		return Save_Humidity;
	}

	public void setSave_Humidity(String save_Humidity) {
		this.Save_Humidity = save_Humidity;
	}

	public String getTransaction_Voucher() {
		return Transaction_Voucher;
	}

	public void setTransaction_Voucher(String transaction_Voucher) {
		this.Transaction_Voucher = transaction_Voucher;
	}

	@Override
	public String toString() {
		return "{\"ID\":\"" + ID + "\",\"Company\":\"" + Company + "\",\"Traceability_Promise\":\""
				+ Traceability_Promise + "\",\"Business_License\":\"" + Business_License + "\",\"Product_Batch\":\""
				+ Product_Batch + "\",\"Save_Time\":\"" + Save_Time + "\",\"Source\":\"" + Source
				+ "\",\"Save_Temp\":\"" + Save_Temp + "\",\"Save_Humidity\":\"" + Save_Humidity
				+ "\",\"Transaction_Voucher\":\"" + Transaction_Voucher + "\",\"Picture_url\":\"" + Picture_url
				+ "\"} ";
	}
	
	
}
