package com.nku.herb_chain.domain;

public class Test_Report {
	private String ID;
	private String Report_ID;
	private String Product_Name;
	private String Specification;
	private String Production_Place;
	private String Quantity;
	private String Batch;
	private String Sample_Origin;
	private String Test_Type;
	private String Test_Date;
	private String Report_Date;
	private String Reference;
	private String Characteristics;
	private String Micro_Character;
	private String Thin_Layer_Character;
	private String Moisture;
	private String Ashes;
	private String Acid_Insoluble_Ash;
	private String SO2_Remain;
	private String Granularity;
	private String Evenness;
	private String Microbe_Limitation;
	private String Extractive;
	private String Conclusion;
	private String Picture_url;

	private String Picture_url1;
	//构造函数
	public Test_Report() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Test_Report(String iD,String report_ID, String product_Name, String specification, String production_Place,
			String quantity, String batch, String sample_Origin, String test_Type, String test_Date, String report_Date,
			String reference, String characteristics, String micro_Character, String thin_Layer_Character,
			String moisture, String ashes, String acid_Insoluble_Ash, String sO2_Remain, String granularity,
			String evenness, String microbe_Limitation, String extractive, String conclusion,String picture_url,String picture_url1) {
		super();
		ID=iD;
		Report_ID = report_ID;
		Product_Name = product_Name;
		Specification = specification;
		Production_Place = production_Place;
		Quantity = quantity;
		Batch = batch;
		Sample_Origin = sample_Origin;
		Test_Type = test_Type;
		Test_Date = test_Date;
		Report_Date = report_Date;
		Reference = reference;
		Characteristics = characteristics;
		Micro_Character = micro_Character;
		Thin_Layer_Character = thin_Layer_Character;
		Moisture = moisture;
		Ashes = ashes;
		Acid_Insoluble_Ash = acid_Insoluble_Ash;
		SO2_Remain = sO2_Remain;
		Granularity = granularity;
		Evenness = evenness;
		Microbe_Limitation = microbe_Limitation;
		Extractive = extractive;
		Conclusion = conclusion;
		Picture_url=picture_url;
		Picture_url1=picture_url1;
	}

	//成员方法
	public String getReport_ID() {
		return Report_ID;
	}

	public void setReport_ID(String report_ID) {
		this.Report_ID = report_ID;
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

	public String getProduct_Name() {
		return Product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.Product_Name = product_Name;
	}

	public String getSpecification() {
		return Specification;
	}

	public void setSpecification(String specification) {
		this.Specification = specification;
	}

	public String getProduction_Place() {
		return Production_Place;
	}

	public void setProduction_Place(String production_Place) {
		this.Production_Place = production_Place;
	}


	public String getQuantity() {
		return Quantity;
	}


	public void setQuantity(String quantity) {
		this.Quantity = quantity;
	}


	public String getBatch() {
		return Batch;
	}


	public void setBatch(String batch) {
		this.Batch = batch;
	}


	public String getSample_Origin() {
		return Sample_Origin;
	}


	public void setSample_Origin(String sample_Origin) {
		this.Sample_Origin = sample_Origin;
	}


	public String getTest_Type() {
		return Test_Type;
	}


	public void setTest_Type(String test_Type) {
		this.Test_Type = test_Type;
	}


	public String getTest_Date() {
		return Test_Date;
	}


	public void setTest_Date(String test_Date) {
		this.Test_Date = test_Date;
	}


	public String getReport_Date() {
		return Report_Date;
	}


	public void setReport_Date(String report_Date) {
		this.Report_Date = report_Date;
	}


	public String getReference() {
		return Reference;
	}


	public void setReference(String reference) {
		this.Reference = reference;
	}


	public String getCharacteristics() {
		return Characteristics;
	}


	public void setCharacteristics(String characteristics) {
		this.Characteristics = characteristics;
	}


	public String getMicro_Character() {
		return Micro_Character;
	}


	public void setMicro_Character(String micro_Character) {
		this.Micro_Character = micro_Character;
	}


	public String getThin_Layer_Character() {
		return Thin_Layer_Character;
	}


	public void setThin_Layer_Character(String thin_Layer_Character) {
		this.Thin_Layer_Character = thin_Layer_Character;
	}


	public String getMoisture() {
		return Moisture;
	}


	public void setMoisture(String moisture) {
		this.Moisture = moisture;
	}


	public String getAshes() {
		return Ashes;
	}


	public void setAshes(String ashes) {
		this.Ashes = ashes;
	}


	public String getAcid_Insoluble_Ash() {
		return Acid_Insoluble_Ash;
	}


	public void setAcid_Insoluble_Ash(String acid_Insoluble_Ash) {
		this.Acid_Insoluble_Ash = acid_Insoluble_Ash;
	}


	public String getSO2_Remain() {
		return SO2_Remain;
	}


	public void setSO2_Remain(String sO2_Remain) {
		this.SO2_Remain = sO2_Remain;
	}


	public String getGranularity() {
		return Granularity;
	}


	public void setGranularity(String granularity) {
		this.Granularity = granularity;
	}


	public String getEvenness() {
		return Evenness;
	}


	public void setEvenness(String evenness) {
		this.Evenness = evenness;
	}


	public String getMicrobe_Limitation() {
		return Microbe_Limitation;
	}


	public void setMicrobe_Limitation(String microbe_Limitation) {
		this.Microbe_Limitation = microbe_Limitation;
	}


	public String getExtractive() {
		return Extractive;
	}


	public void setExtractive(String extractive) {
		this.Extractive = extractive;
	}


	public String getConclusion() {
		return Conclusion;
	}


	public void setConclusion(String conclusion) {
		this.Conclusion = conclusion;
	}


	public String getPicture_url() {
		return Picture_url;
	}


	public void setPicture_url(String picture_url) {
		Picture_url = picture_url;
	}


	@Override
	public String toString() {
		return "{\"ID\":\"" + ID + "\",\"Report_ID\":\"" + Report_ID + "\",\"Product_Name\":\"" + Product_Name
				+ "\",\"Specification\":\"" + Specification + "\",\"Production_Place\":\"" + Production_Place
				+ "\",\"Quantity\":\"" + Quantity + "\",\"Batch\":\"" + Batch + "\",\"Sample_Origin\":\""
				+ Sample_Origin + "\",\"Test_Type\":\"" + Test_Type + "\",\"Test_Date\":\"" + Test_Date
				+ "\",\"Report_Date\":\"" + Report_Date + "\",\"Reference\":\"" + Reference
				+ "\",\"Characteristics\":\"" + Characteristics + "\",\"Micro_Character\":\"" + Micro_Character
				+ "\",\"Thin_Layer_Character\":\"" + Thin_Layer_Character + "\",\"Moisture\":\"" + Moisture
				+ "\",\"Ashes\":\"" + Ashes + "\",\"Acid_Insoluble_Ash\":\"" + Acid_Insoluble_Ash
				+ "\",\"SO2_Remain\":\"" + SO2_Remain + "\",\"Granularity\":\"" + Granularity + "\",\"Evenness\":\""
				+ Evenness + "\",\"Microbe_Limitation\":\"" + Microbe_Limitation + "\",\"Extractive\":\"" + Extractive
				+ "\",\"Conclusion\":\"" + Conclusion + "\",\"Picture_url\":\"" + Picture_url + "\",\"Picture_url1\":\""
				+ Picture_url1 + "\"} ";
	}



}
