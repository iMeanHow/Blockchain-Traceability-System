package com.nku.herb_chain.domain;

public class Use {
	private String ID;
	private String Company;
	//	Pharmacy
	private String Pharmacy_Ledger;
	//	Consumer
	private String Consumer_Ledger;
	private String Picture_url;
	//构造函数
	public Use() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Use(String iD,String company,String pharmacy_Ledger, String consumer_Ledger,String pictuer_url) {
		super();
		ID=iD;
		Company=company;
		Pharmacy_Ledger = pharmacy_Ledger;
		Consumer_Ledger = consumer_Ledger;
		Picture_url=pictuer_url;
	}
	
	//成员函数
	public String getPharmacy_Ledger() {
		return Pharmacy_Ledger;
	}
	public void setPharmacy_Ledger(String pharmacy_Ledger) {
		this.Pharmacy_Ledger = pharmacy_Ledger;
	}
	
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		this.ID = iD;
	}
	
	public String getConsumer_Ledger() {
		return Consumer_Ledger;
	}
	public void setConsumer_Ledger(String consumer_Ledger) {
		this.Consumer_Ledger = consumer_Ledger;
	}
	public String getPicture_url() {
		return Picture_url;
	}
	public void setPicture_url(String picture_url) {
		Picture_url = picture_url;
	}
	@Override
	public String toString() {
		return "{\"ID\":\"" + ID + "\",\"Company\":\"" + Company + "\",\"Pharmacy_Ledger\":\"" + Pharmacy_Ledger
				+ "\",\"Consumer_Ledger\":\"" + Consumer_Ledger + "\",\"Picture_url\":\"" + Picture_url + "\"} ";
	}

	
	
}
