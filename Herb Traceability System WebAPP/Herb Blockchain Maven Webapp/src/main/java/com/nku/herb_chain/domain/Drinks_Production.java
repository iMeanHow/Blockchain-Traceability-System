package com.nku.herb_chain.domain;

import com.alibaba.fastjson.annotation.JSONField;

public class Drinks_Production {
	private String ID;
	private String Company;
	//	Corporation registration
	private String Business_License;
	private String Traceability_Promise;
	private String GMP_Certificate;

	//	Test registration
	private String Auto_Cancelation;		//	Unqualified product
	private String Test_Report;		//	Qualified product

	//	Storage registration
	private String Variety;
	private String Storage_Time;
	private String Storage_Batch;
	private String Storage_Quantity;
	private String Classification;
	private String Source;
	private String Storage_Temp;
	private String Storage_Humidity;

	//	Procession registration
	private String Process_Method;

	//	Packing registration
	private String Packing_Batch;
	private String Packing_Class;
	private String Packing_Quantity;

	//	Dealing registration
	private String Deal_Info;

	//	Output registration
	private String Output_Variety;
	private String Output_Time;
	private String Output_Batch;
	private String Output_Quantity;
	private String Output_Flow;
	private String Output_Temp;
	private String Output_Humidity;
	@JSONField(name="Picture_url")
	private String Picture_url;

	private String Picture_url1;
	//构造函数
	public Drinks_Production() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Drinks_Production(String iD, String company,String business_License, String traceability_Promise, String gMP_Certificate,
			String auto_Cancelation, String test_Report, String variety, String storage_Time, String storage_Batch,
			String storage_Quantity, String classification, String source, String storage_Temp, String storage_Humidity,
			String process_Method, String packing_Batch, String packing_Class, String packing_Quantity,
			String deal_Info, String output_Variety, String output_Time, String output_Batch, String output_Quantity,
			String output_Flow, String output_Temp, String output_Humidity,String picture_url,String picture_url1) {
		super();
		ID = iD;
		Company=company;
		Business_License = business_License;
		Traceability_Promise = traceability_Promise;
		GMP_Certificate = gMP_Certificate;
		Auto_Cancelation = auto_Cancelation;
		Test_Report = test_Report;
		Variety = variety;
		Storage_Time = storage_Time;
		Storage_Batch = storage_Batch;
		Storage_Quantity = storage_Quantity;
		Classification = classification;
		Source = source;
		Storage_Temp = storage_Temp;
		Storage_Humidity = storage_Humidity;
		Process_Method = process_Method;
		Packing_Batch = packing_Batch;
		Packing_Class = packing_Class;
		Packing_Quantity = packing_Quantity;
		Deal_Info = deal_Info;
		Output_Variety = output_Variety;
		Output_Time = output_Time;
		Output_Batch = output_Batch;
		Output_Quantity = output_Quantity;
		Output_Flow = output_Flow;
		Output_Temp = output_Temp;
		Output_Humidity = output_Humidity;
		Picture_url=picture_url;
		Picture_url1=picture_url1;
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

	public String getGMP_Certificate() {
		return GMP_Certificate;
	}

	public void setGMP_Certificate(String gMP_Certificate) {
		this.GMP_Certificate = gMP_Certificate;
	}

	public String getAuto_Cancelation() {
		return Auto_Cancelation;
	}

	public void setAuto_Cancelation(String auto_Cancelation) {
		this.Auto_Cancelation = auto_Cancelation;
	}

	public String getTest_Report() {
		return Test_Report;
	}

	public void setTest_Report(String test_Report) {
		this.Test_Report = test_Report;
	}

	public String getVariety() {
		return Variety;
	}

	public void setVariety(String variety) {
		this.Variety = variety;
	}

	public String getStorage_Time() {
		return Storage_Time;
	}

	public void setStorage_Time(String storage_Time) {
		this.Storage_Time = storage_Time;
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

	public void setClassification(String class1) {
		this.Classification = class1;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		this.Source = source;
	}

	public String getStorage_Temp() {
		return Storage_Temp;
	}

	public void setStorage_Temp(String storage_Temp) {
		this.Storage_Temp = storage_Temp;
	}

	public String getStorage_Humidity() {
		return Storage_Humidity;
	}

	public void setStorage_Humidity(String storage_Humidity) {
		this.Storage_Humidity = storage_Humidity;
	}

	public String getProcess_Method() {
		return Process_Method;
	}

	public void setProcess_Method(String process_Method) {
		this.Process_Method = process_Method;
	}

	public String getPacking_Batch() {
		return Packing_Batch;
	}

	public void setPacking_Batch(String packing_Batch) {
		this.Packing_Batch = packing_Batch;
	}

	public String getPacking_Class() {
		return Packing_Class;
	}

	public void setPacking_Class(String packing_Class) {
		this.Packing_Class = packing_Class;
	}

	public String getPacking_Quantity() {
		return Packing_Quantity;
	}

	public void setPacking_Quantity(String packing_Quantity) {
		this.Packing_Quantity = packing_Quantity;
	}

	public String getDeal_Info() {
		return Deal_Info;
	}

	public void setDeal_Info(String deal_Info) {
		this.Deal_Info = deal_Info;
	}

	public String getOutput_Variety() {
		return Output_Variety;
	}

	public void setOutput_Variety(String output_Variety) {
		this.Output_Variety = output_Variety;
	}

	public String getOutput_Time() {
		return Output_Time;
	}

	public void setOutput_Time(String output_Time) {
		this.Output_Time = output_Time;
	}

	public String getOutput_Batch() {
		return Output_Batch;
	}

	public void setOutput_Batch(String output_Batch) {
		this.Output_Batch = output_Batch;
	}

	public String getOutput_Quantity() {
		return Output_Quantity;
	}

	public void setOutput_Quantity(String output_Quantity) {
		this.Output_Quantity = output_Quantity;
	}

	public String getOutput_Flow() {
		return Output_Flow;
	}

	public void setOutput_Flow(String output_Flow) {
		this.Output_Flow = output_Flow;
	}

	public String getOutput_Temp() {
		return Output_Temp;
	}

	public void setOutput_Temp(String output_Temp) {
		this.Output_Temp = output_Temp;
	}

	public String getOutput_Humidity() {
		return Output_Humidity;
	}

	public void setOutput_Humidity(String output_Humidity) {
		this.Output_Humidity = output_Humidity;
	}

	@Override
	public String toString() {
		return "{\"ID\":\"" + ID + "\",\"Company\":\"" + Company + "\",\"Business_License\":\"" + Business_License
				+ "\",\"Traceability_Promise\":\"" + Traceability_Promise + "\",\"GMP_Certificate\":\""
				+ GMP_Certificate + "\",\"Auto_Cancelation\":\"" + Auto_Cancelation + "\",\"Test_Report\":\""
				+ Test_Report + "\",\"Variety\":\"" + Variety + "\",\"Storage_Time\":\"" + Storage_Time
				+ "\",\"Storage_Batch\":\"" + Storage_Batch + "\",\"Storage_Quantity\":\"" + Storage_Quantity
				+ "\",\"Classification\":\"" + Classification + "\",\"Source\":\"" + Source + "\",\"Storage_Temp\":\""
				+ Storage_Temp + "\",\"Storage_Humidity\":\"" + Storage_Humidity + "\",\"Process_Method\":\""
				+ Process_Method + "\",\"Packing_Batch\":\"" + Packing_Batch + "\",\"Packing_Class\":\"" + Packing_Class
				+ "\",\"Packing_Quantity\":\"" + Packing_Quantity + "\",\"Deal_Info\":\"" + Deal_Info
				+ "\",\"Output_Variety\":\"" + Output_Variety + "\",\"Output_Time\":\"" + Output_Time
				+ "\",\"Output_Batch\":\"" + Output_Batch + "\",\"Output_Quantity\":\"" + Output_Quantity
				+ "\",\"Output_Flow\":\"" + Output_Flow + "\",\"Output_Temp\":\"" + Output_Temp
				+ "\",\"Output_Humidity\":\"" + Output_Humidity + "\",\"Picture_url\":\"" + Picture_url
				+ "\",\"Picture_url1\":\"" + Picture_url1 + "\"} ";
	}


	
}
