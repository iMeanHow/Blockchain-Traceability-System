/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * The sample smart contract for documentation topic:
 * Writing Your First Blockchain Application
 */

package main

/* Imports
 * 4 utility libraries for formatting, handling bytes, reading and writing JSON, and string manipulation
 * 2 specific Hyperledger Fabric specific libraries for Smart Contracts
 */
import (
	//"bytes"

	"encoding/json"
	"fmt"
	"strconv"
	"github.com/hyperledger/fabric/core/chaincode/shim"
	sc "github.com/hyperledger/fabric/protos/peer"
)

// Define the Smart Contract structure
type SmartContract struct {
}

//	2018.7.28 newly added
type Herb_Planting struct {
	
	//	Corporation registration
	ID 					string
	Business_License 	string
	Contact        		string
	Commitment 			string
	
	//	Planting process management
	Plant_Type			string
	Plant_Time			string
	Plant_Area			string
	Harvest_Weight		string
	Plan_Production		string
	Real_Production		string
	Harvest_Time		string
	Pesticide_Remain	string
	Content_Test		string
	Test_Report			string

	//	Certificate of origin
	Origin_Certificate	string
	Transaction_Voucher	string

	//	Deal registration
	Deal_Quantity		string
	Deal_Time			string
	Deal_Variety		string
	Deal_Price			string
	Counterparty		string

	//	Company
	Company				string
}

type Herb_Enterprise struct{
 	
 	//	Enterprise management record
 	ID 					string
 	Traceability_Promise	string
 	Business_License		string

 	//	Storage management
 	Product_Batch			string
 	Save_Time				string
 	Source					string
 	
 	//	Information gathering
 	Save_Temp				string
 	Save_Humidity			string

 	//	Transaction voucher
 	Transaction_Voucher		string

 	//	Company
	Company				string
}

type Herb_Market struct{

	//	Corporation registration
	ID 					string
	Business_License		string
	Traceability_Promise	string

	//	Marketing registration
	Wholesaler				string
	Marketing_Variety 		string
	Marketing_Quantity 		string
	Origin_Certificate		string
	Enterprise 				string

	//	Testing registration
	Pesticide_Remain		string
	Content_Test			string
	Test_Report				string		//	Test_Report struct

	//	Deal registration
	Dealing_Variety			string
	Dealing_Price			string
	Dealing_Quantity		string
	Dealing_Counterparty	string
	Dealing_Flow			string

	//	Company
	Company				string
}

type Herb_Drinks_Production	struct{

	//	Corporation registration
	ID 					string
	Business_License		string
	Traceability_Promise	string
	GMP_Certificate			string

	//	Test registration
	Auto_Cancelation		string		//	Unqualified product
	Test_Report				string		//	Qualified product

	//	Storage registration
	Variety 				string
	Storage_Time			string
	Storage_Batch			string
	Storage_Quantity		string
	Class					string
	Source					string
	Storage_Temp			string
	Storage_Humidity		string

	//	Procession registration
	Process_Method			string

	//	Packing registration
	Packing_Batch			string
	Packing_Class			string
	Packing_Quantity		string

	//	Dealing registration
	Deal_Info				string

	//	Output registration
	Output_Variety			string
	Output_Time				string
	Output_Batch			string
	Output_Quantity			string
	Output_Flow				string
	Output_Temp				string
	Output_Humidity			string

	//	Company
	Company				string
}

type Herb_Business struct{
	
	//	Corporation registration
	ID 					string
	Business_License		string
	Traceability_Promise	string
	GSP_Permission			string

	//	Storage management
	Variety 				string
	Source					string
	Storage_Batch			string
	Storage_Quantity		string
	Class 					string
	Product_Enterprise		string
	Produce_Time			string
	Flow_Nodes				string

	//	Information gathering
	Humidity 				string

	//	Dealing registration
	Deal_Info				string

	//	Company
	Company				string
}

type Herb_Use struct{
	
	ID 					string
	//	Pharmacy
	Pharmacy_Ledger 		string

	//	Consumer
	Consumer_Ledger			string

	//	Company
	Company				string
}

type Test_Report struct {

		ID 					string
		Report_ID			string
		Product_Name		string
		Specification		string
		Production_Place	string
		Quantity			string
		Batch 				string
		Sample_Origin		string
		Test_Type			string
		Test_Date			string
		Report_Date			string
		Reference			string
		//	Result:
		Characteristics		string
		Micro_Character		string
		Thin_Layer_Character string
		Moisture			string
		Ashes				string
		Acid_Insoluble_Ash	string
		SO2_Remain			string
		Granularity			string
		Evenness			string
		Microbe_Limitation	string
		Extractive			string

		Conclusion			string
}



//	-----------------------------------
type User_Info struct {
        User          string
        Balance       float64
        Plan_Power    int
        Plan_Bonus    float64
        Demand_Power  int
        Total_Bonus   float64
}
type Herb_Info struct {
//Plant
        ID                string
        Plant_Type        string
        Plant_Time        string   //time type
        Plant_Area        string
        Harvest_Weight    string
        Harvest_Time      string
        Plan_Production   string
        Real_Production   string
//Produce
        Product_Batch     string  
        Save_Time         string
        Save_Temp         string
        Save_Humidity     string
        Produce_Method    string
        Batch             string
        Level             string
//inspect
        Pesticide_Remain   string
        Pesticide_Content  string
        QT_ID              string //quality testing  report ID
        Qualification      bool   
}

type Common_Peer struct{
        Business_License     string
        Identity_Prove       string
        Contact_Form         string
        Commitment_ID        string
        Type                 string

}

type totalPlan_ret struct{
     Users_Total_Plan        int
}


//	JSON Operation
/*
type JsonStruct struct {
}

func NewJsonStruct() *JsonStruct {
    return &JsonStruct{}
}

func (jst *JsonStruct) Load(filename string, v interface{}) sc.Response {
    
    //ReadFile函数会读取文件的全部内容，并将结果以[]byte类型返回
    data, err := ioutil.ReadFile(filename)

    fmt.Println("Added")
    if err != nil {
    	fmt.Println("Added...err")
        return shim.Error("Incorrect file path.")
    }
    fmt.Println("Added1...")
    //读取的数据为json格式，需要进行解码
    err = json.Unmarshal(data, v)
    if err != nil {
    	fmt.Println("Added1...err")
        return shim.Error("Incorrect JSON format.")
    }
//    return shim.Error("...:"+filename+"  --")	//	?????????????
    fmt.Println("Added2...")
    return shim.Success(nil)
}
*/

//-------------------------------------

/*
 * The init method is called when the Smart Contract "fabcar" is instantiated by the blockchain network
 * Best practice is to have any Ledger initialization in separate function -- see initLedger()
 */
func (s *SmartContract) Init(APIstub shim.ChaincodeStubInterface) sc.Response {
	return shim.Success(nil)
}

/*
 * The Invoke method is called as a result of an application request to run the Smart Contract "fabcar"
 * The calling application program has also specified the particular smart contract function to be called, with arguments
 */
func (s *SmartContract) Invoke(APIstub shim.ChaincodeStubInterface) sc.Response {

	// Retrieve the requested Smart Contract function and arguments
	function, args := APIstub.GetFunctionAndParameters()
	// Route to the appropriate handler function to interact with the ledger appropriately
	if function == "query" {
		return s.query(APIstub, args)
    } else if function =="uploadUserPlan" {
               return s.uploadUserPlan(APIstub, args)
	} else if function == "initLedger" {
		return s.initLedger(APIstub)
	} else if function == "uploadBonus" {
		return s.uploadBonus(APIstub, args)
	} else if function == "distributeBonus" {
		return s.distributeBonus(APIstub)
	} else if function =="CalculatePlanBonus"{
                return s.CalculatePlanBonus(APIstub)
    } else if function =="uploadDemand"{
                return s.uploadDemand(APIstub,args)
    } else if function =="queryTotalPlan"{
                return s.queryTotalPlan(APIstub)
    } else if function =="queryTestReport"{
                return s.queryTestReport(APIstub,args)
    } else if function =="queryHerbPlanting"{
                return s.queryHerbPlanting(APIstub,args)
    } else if function =="queryHerbEnterprise"{
                return s.queryHerbEnterprise(APIstub,args)
    } else if function =="queryHerbMarket"{
                return s.queryHerbMarket(APIstub,args)
    } else if function =="queryHerbDrinksProduction"{
                return s.queryHerbDrinksProduction(APIstub,args)
    } else if function =="queryHerbBusiness"{
                return s.queryHerbBusiness(APIstub,args)
    } else if function =="queryHerbUse"{
                return s.queryHerbUse(APIstub,args)
    } else if function =="addHerbPlanting"{
                return s.addHerbPlanting(APIstub,args)
    } 


	return shim.Error("Invalid Smart Contract function name.")
}




//	20180915 newly added

//	Adding...

func (s *SmartContract) addHerbPlanting(APIstub shim.ChaincodeStubInterface, args []string) sc.Response {

	if len(args) != 1 {
		return shim.Error("Incorrect number of arguments. Expecting 1")
	}
/*
	JsonParse := NewJsonStruct()
	herbPlanting := Herb_Planting{}
	JsonParse.Load(args[0], &herbPlanting)
*/
	herbPlanting := Herb_Planting{}

	if err := json.Unmarshal([]byte(args[0]), &herbPlanting); err==nil{

	}

	herbPlantingAsBytes, _ := json.Marshal(herbPlanting)

	APIstub.PutState("HERB_PLANTING_"+herbPlanting.ID, herbPlantingAsBytes)

	return shim.Error("error "+herbPlanting.ID+"xxx")
//	return shim.Success(nil)
}


//	Querying...


func (s *SmartContract) queryTestReport(APIstub shim.ChaincodeStubInterface, args []string) sc.Response {
	
	//	get the according struct object by args:ID
	if len(args) != 1 {
		return shim.Error("Incorrect number of arguments. Expecting 1")
	}
	testReportAsBytes, _ := APIstub.GetState("TEST_REPORT_"+args[0])
	return shim.Success(testReportAsBytes)
}


func (s *SmartContract) queryHerbPlanting(APIstub shim.ChaincodeStubInterface, args []string) sc.Response {

	if len(args) != 1 {
		return shim.Error("Incorrect number of arguments. Expecting 1")
	}
	herbPlantingAsBytes, _ := APIstub.GetState("HERB_PLANTING_"+args[0])
	return shim.Success(herbPlantingAsBytes)
}

func (s *SmartContract) queryHerbEnterprise(APIstub shim.ChaincodeStubInterface, args []string) sc.Response {
	
	if len(args) != 1 {
		return shim.Error("Incorrect number of arguments. Expecting 1")
	}
	herbEnterpriseAsBytes, _ := APIstub.GetState("HERB_ENTERPRISE_"+args[0])
	return shim.Success(herbEnterpriseAsBytes)
}

func (s *SmartContract) queryHerbMarket(APIstub shim.ChaincodeStubInterface, args []string) sc.Response {
	
	if len(args) != 1 {
		return shim.Error("Incorrect number of arguments. Expecting 1")
	}
	herbMarketAsBytes, _ := APIstub.GetState("HERB_MARKET_"+args[0])
	return shim.Success(herbMarketAsBytes)
}

func (s *SmartContract) queryHerbDrinksProduction(APIstub shim.ChaincodeStubInterface, args []string) sc.Response {
	
	if len(args) != 1 {
		return shim.Error("Incorrect number of arguments. Expecting 1")
	}
	herbDrinksProductionAsBytes, _ := APIstub.GetState("HERB_DRINKS_PRODUCTION_"+args[0])
	return shim.Success(herbDrinksProductionAsBytes)
}

func (s *SmartContract) queryHerbBusiness(APIstub shim.ChaincodeStubInterface, args []string) sc.Response {
	
	if len(args) != 1 {
		return shim.Error("Incorrect number of arguments. Expecting 1")
	}
	herbBusinessAsBytes, _ := APIstub.GetState("HERB_BUSINESS_"+args[0])
	return shim.Success(herbBusinessAsBytes)
}

func (s *SmartContract) queryHerbUse(APIstub shim.ChaincodeStubInterface, args []string) sc.Response {
	
	if len(args) != 1 {
		return shim.Error("Incorrect number of arguments. Expecting 1")
	}
	herbUseAsBytes, _ := APIstub.GetState("HERB_USE_"+args[0])
	return shim.Success(herbUseAsBytes)
}

//	------------------------------------------------------------

func (s *SmartContract) initLedger(APIstub shim.ChaincodeStubInterface) sc.Response {
	
	herbs:= []Herb_Info{
		Herb_Info{ID:"100001",Plant_Type:"三七",Plant_Time:"2013年3月",Plant_Area:"800亩",Harvest_Weight:"120吨",Harvest_Time:"2015年12月20日",Plan_Production:"150吨",Real_Production:"120吨",Product_Batch:"无",Save_Time:"无",Save_Temp:"无",Save_Humidity:"无",Produce_Method:"分捡、晾晒、分级、干燥、超微粉碎",Batch:"160515",Level:"优级",Pesticide_Remain:"无",Pesticide_Content:"无",QT_ID:"无",Qualification:true},
       }

	i := 0
	for i < len(herbs) {
		herbAsBytes, _ := json.Marshal(herbs[i])
		APIstub.PutState("HERB_INFO_"+herbs[i].ID, herbAsBytes)
		//fmt.Println("Added", herbs[i])
		i = i + 1
	}

	//	Test report:
	report := []Test_Report {
		Test_Report {ID:"100001",Report_ID:"C15051503", Product_Name:"三七粉", Specification:"细粉100g/瓶", Production_Place:"云南", Quantity:"5万瓶", Batch:"160515-1", Sample_Origin:"口服饮片车间", Test_Type:"全检", Test_Date:"2016年05月15日", Report_Date:"2016年05月27日", Reference:"《中国药典》（2015年版 一部及四部）", Characteristics:"符合规定", Micro_Character:"符合规定", Thin_Layer_Character:"符合规定", Moisture:"8.5%", Ashes:"3.0%", Acid_Insoluble_Ash:"1.6%", SO2_Remain:"30mg/kg", Granularity:"98%", Evenness:"符合规定", Microbe_Limitation:"需氧菌总数为510cfu/g；霉菌和酵母菌总数＜10cfu/g；耐胆盐革兰阴性菌未检出；沙门菌未检出。", Extractive:"22.0%", Conclusion:"本品按《中国药典》（2015年版 一部及四部）检验上述项目，结果符合规定。"},
	}
	i = 0
	for i < len(report) {
		reportAsBytes, _ := json.Marshal(report[i])
		APIstub.PutState("TEST_REPORT_"+report[i].ID, reportAsBytes)
		//fmt.Println("Added", report[i])
		i = i + 1
	}

	//	2018.7.28 newly added

	//	Herb planting
	herbPlanting := []Herb_Planting {
		Herb_Planting {ID:"100001", Company:"文山盘龙云海三七种植合作社", Business_License:"文山盘龙云海三七种植合作社", Contact:"电话", Commitment:"——", Plant_Type:"三七", Plant_Time:"2013/3/1", Plant_Area:"800亩", Harvest_Weight:"120吨", Plan_Production:"150吨", Real_Production:"120吨", Harvest_Time:"2015/12/2", Pesticide_Remain:"质量检测报告", Content_Test:"NULL", Test_Report:"NULL", Origin_Certificate:"文山三七道地药材证明", Transaction_Voucher:"凭证", Deal_Quantity:"100吨", Deal_Time:"2015/12/25", Deal_Variety:"三七个子", Deal_Price:"100元/kg", Counterparty:"云南盘龙云海药业有限公司"},
	}
	i = 0
	for i < len(herbPlanting) {
		herbPlantingAsBytes, _ := json.Marshal(herbPlanting[i])
		APIstub.PutState("HERB_PLANTING_"+herbPlanting[i].ID, herbPlantingAsBytes)
		//fmt.Println("Added", herbPlanting[i])
		i = i + 1
	}

	//	Herb enterprise
	herbEnterprise := []Herb_Enterprise {
		Herb_Enterprise {ID:"100001", Company:"文山盘龙云海三七种植合作社", Traceability_Promise:"——", Business_License:"文山盘龙云海三七种植合作社", Product_Batch:"160110", Save_Time:"2016/1/10", Source:"文山种植基地", Save_Temp:"25℃", Save_Humidity:"50%RH", Transaction_Voucher:"凭证"},
	}
	i = 0
	for i < len(herbEnterprise) {
		herbEnterpriseAsBytes, _ := json.Marshal(herbEnterprise[i])
		APIstub.PutState("HERB_ENTERPRISE_"+herbEnterprise[i].ID, herbEnterpriseAsBytes)
		//fmt.Println("Added", herbEnterprise[i])
		i = i + 1
	}

	//	Herb marketing
	herbMarket := []Herb_Market {
		Herb_Market {ID:"100001", Company:"文山盘龙云海三七种植合作社", Business_License:"文山盘龙云海三七种植合作社", Traceability_Promise:"——", Wholesaler:"南开大学任仕睿", Marketing_Variety:"三七", Marketing_Quantity:"100吨", Origin_Certificate:"文山三七道地药材证明", Enterprise:"云南盘龙云海药业有限公司", Pesticide_Remain:"质量检测报告", Content_Test:"NULL", Test_Report:"南开大学王子纯", Dealing_Variety:"三七", Dealing_Price:"100元/kg", Dealing_Quantity:"100吨", Dealing_Counterparty:"云南盘龙云海药业有限公司", Dealing_Flow:"云南盘龙云海药业有限公司"},
	}
	i = 0
	for i < len(herbMarket) {
		herbMarketAsBytes, _ := json.Marshal(herbMarket[i])
		APIstub.PutState("HERB_MARKET_"+herbMarket[i].ID, herbMarketAsBytes)
		//fmt.Println("Added", herbMarket[i])
		i = i + 1
	}

	//	Herb drinks production
	herbDrinksProduction := []Herb_Drinks_Production {
		Herb_Drinks_Production {ID:"100001", Company:"文山盘龙云海三七种植合作社", Business_License:"云南盘龙云海药业有限公司", Traceability_Promise:"——", GMP_Certificate:"GMP证书", Auto_Cancelation:"NULL", Test_Report:"检测报告160110-1", Variety:"三七", Storage_Time:"2016/1/10", Storage_Batch:"160110", Storage_Quantity:"100吨", Class:"个子", Source:"文山种植基地", Storage_Temp:"25℃", Storage_Humidity:"50%RH", Process_Method:"分拣、晾晒、分级、干燥、超微粉碎", Packing_Batch:"160515", Packing_Class:"优级", Packing_Quantity:"100g*10万瓶", Deal_Info:"Dealing Information", Output_Variety:"三七粉（100g/瓶）", Output_Time:"2016年", Output_Batch:"160515", Output_Quantity:"5万瓶", Output_Flow:"某连锁药店", Output_Temp:"25℃", Output_Humidity:"50%RH"},
	}
	i = 0
	for i < len(herbDrinksProduction) {
		herbDrinksProductionAsBytes, _ := json.Marshal(herbDrinksProduction[i])
		APIstub.PutState("HERB_DRINKS_PRODUCTION_"+herbDrinksProduction[i].ID, herbDrinksProductionAsBytes)
		//fmt.Println("Added", herbDrinksProduction[i])
		i = i + 1
	}

	//	Herb business
	herbBusiness := []Herb_Business {
		Herb_Business {ID:"100001", Company:"文山盘龙云海三七种植合作社", Business_License:"某连锁药店", Traceability_Promise:"——", GSP_Permission:"GSP许可", Variety:"三七粉（100g/瓶）", Source:"云南文山", Storage_Batch:"160515", Storage_Quantity:"1万瓶", Class:"优级", Product_Enterprise:"云南盘龙云海药业有限公司", Produce_Time:"2016/6/15", Flow_Nodes:"——", Humidity:"24℃、55%RH", Deal_Info:"Dealing Information"},
	}
	i = 0
	for i < len(herbBusiness) {
		herbBusinessAsBytes, _ := json.Marshal(herbBusiness[i])
		APIstub.PutState("HERB_BUSINESS_"+herbBusiness[i].ID, herbBusinessAsBytes)
		//fmt.Println("Added", herbBusiness[i])
		i = i + 1
	}

	//	Herb planting
	herbUse := []Herb_Use {
		Herb_Use {ID:"100001", Company:"文山盘龙云海三七种植合作社", Pharmacy_Ledger:"Pharmacy_Ledger", Consumer_Ledger:"Consumer_Ledger"},
	}
	i = 0
	for i < len(herbUse) {
		herbUseAsBytes, _ := json.Marshal(herbUse[i])
		APIstub.PutState("HERB_USE_"+herbUse[i].ID, herbUseAsBytes)
		//fmt.Println("Added", herbUse[i])
		i = i + 1
	}

    return shim.Success(nil)
}










func (s *SmartContract) query(APIstub shim.ChaincodeStubInterface, args []string) sc.Response {
	

	herbInfoAsBytes, _ := APIstub.GetState(args[0])
	return shim.Success(herbInfoAsBytes)
}


func (s *SmartContract) distributeBonus(APIstub shim.ChaincodeStubInterface) sc.Response{

           resultsIterator, err := APIstub.GetStateByRange("","")
           //result_copy:=resultsIterator
           if err != nil {
                return shim.Error(err.Error())
           }
           defer resultsIterator.Close()
           //var totalPlan int
           temp:=User_Info{}
           for resultsIterator.HasNext(){
                next_user,_:=resultsIterator.Next()
                json.Unmarshal(next_user.Value,&temp)
                temp.Balance+=temp.Plan_Bonus
                temp.Plan_Bonus=0
                temp.Plan_Power=0
                temp.Total_Bonus=0
                userAsBytes,_:=json.Marshal(temp)
                APIstub.PutState(next_user.Key,userAsBytes)
           }
           fmt.Printf("Distributing users bonus  ...")
           return shim.Success(nil)

}

func (s *SmartContract) queryTotalPlan(APIstub shim.ChaincodeStubInterface) sc.Response{

           resultsIterator, err := APIstub.GetStateByRange("","")
           if err != nil {
                return shim.Error(err.Error())
           }
           defer resultsIterator.Close()
           var totalPlan int
           temp:=User_Info{}

           for resultsIterator.HasNext(){
                next_user,_:=resultsIterator.Next()
                json.Unmarshal(next_user.Value,&temp)
                totalPlan+=temp.Plan_Power

           }
           fmt.Println("Querying total plan  ...")
           fmt.Println("Totalplan: ", totalPlan)
           ret:=totalPlan_ret{Users_Total_Plan:totalPlan}
           retAsbyte,_:=json.Marshal(ret)
           return shim.Success(retAsbyte)

}

func (s *SmartContract) CalculatePlanBonus(APIstub shim.ChaincodeStubInterface) sc.Response{
           var bonus float64
           resultsIterator, err := APIstub.GetStateByRange("","")
           if err != nil {
                return shim.Error(err.Error())
           }
           defer resultsIterator.Close()
           var totalPlan int
           temp:=User_Info{}
           var demand int
           for resultsIterator.HasNext(){
                next_user,_:=resultsIterator.Next()
                json.Unmarshal(next_user.Value,&temp)
                totalPlan+=temp.Plan_Power
                bonus=temp.Total_Bonus
                demand=temp.Demand_Power
           }
           fmt.Println("Calculating users bonus  ...")
           fmt.Println("Totalplan: ", totalPlan)
           
           fmt.Println("Totalbonus: ",bonus)
           var weight float64

           if demand<totalPlan{
             weight=float64(bonus)/float64(totalPlan)
           } else{
             weight=float64(bonus)/float64(demand)
           }
           
           fmt.Println("Bonus_weight: ",weight)

           copy_data, _:= APIstub.GetStateByRange("","")
           for copy_data.HasNext(){
               single_user,_:=copy_data.Next()
               json.Unmarshal(single_user.Value,&temp)
               temp.Plan_Bonus=float64(weight)*float64(temp.Plan_Power)
               fmt.Println("test_bonus: ",temp.Plan_Bonus)
               userAsBytes,_:=json.Marshal(temp)
               APIstub.PutState(single_user.Key,userAsBytes)
           }
           defer copy_data.Close()
           return shim.Success(nil)

}

func (s *SmartContract) createUser(APIstub shim.ChaincodeStubInterface, args []string) sc.Response {

	if len(args) != 2 {
		return shim.Error("Incorrect number of arguments. Expecting 1")
	}

	var user = User_Info{User: args[1], Balance: 0, Plan_Power:0, Plan_Bonus:0}

	userAsBytes, _ := json.Marshal(user)
	APIstub.PutState(args[0], userAsBytes)

	return shim.Success(nil)
}


func (s *SmartContract) uploadUserPlan(APIstub shim.ChaincodeStubInterface, args []string) sc.Response {

	if len(args) != 2 {
	     return shim.Error("Incorrect number of arguments. Expecting 2")
	}

	userAsBytes, _ := APIstub.GetState(args[0])
	temp := User_Info{}

	json.Unmarshal(userAsBytes, &temp)
	temp.Plan_Power,_ = strconv.Atoi(args[1])
	userAsBytes, _ = json.Marshal(temp)
	APIstub.PutState(args[0], userAsBytes)
        fmt.Println("Uploading user's plan ...",temp.Plan_Power)

        
	return shim.Success(nil)
}
func (s *SmartContract) uploadBonus(APIstub shim.ChaincodeStubInterface, args []string) sc.Response {

        if len(args) != 1 {
                return shim.Error("Incorrect number of arguments. Expecting 1")
        }

        bonus,_:= strconv.Atoi(args[0])
        resultsIterator, err := APIstub.GetStateByRange("","")
        if err != nil {
             return shim.Error(err.Error())
        }
        defer resultsIterator.Close()
        temp:=User_Info{}
        for resultsIterator.HasNext(){
             next_user,_:=resultsIterator.Next()
             json.Unmarshal(next_user.Value,&temp)
             temp.Total_Bonus=float64(bonus)
             fmt.Println("User Bonus ...",temp.Total_Bonus)
             userAsBytes,_:=json.Marshal(temp)
             APIstub.PutState(next_user.Key,userAsBytes)

        }
        fmt.Println("Uploading bonus ...",bonus)
        //shim.Success(nil)
        //s.CalculatePlanBonus(APIstub)


        return shim.Success(nil)
}
func (s *SmartContract) uploadDemand(APIstub shim.ChaincodeStubInterface, args []string) sc.Response {

        if len(args) != 1 {
                return shim.Error("Incorrect number of arguments. Expecting 1")
        }

        demand,_:= strconv.Atoi(args[0])
        resultsIterator, err := APIstub.GetStateByRange("","")
        if err != nil {
             return shim.Error(err.Error())
        }
        defer resultsIterator.Close()
        temp:=User_Info{}
        for resultsIterator.HasNext(){
             next_user,_:=resultsIterator.Next()
             json.Unmarshal(next_user.Value,&temp)
             temp.Demand_Power=int(demand)
             fmt.Println("User Bonus ...",temp.Demand_Power)
             userAsBytes,_:=json.Marshal(temp)
             APIstub.PutState(next_user.Key,userAsBytes)

        }
        fmt.Println("Uploading bonus ...",demand)
        //shim.Success(nil)
        //s.CalculatePlanBonus(APIstub)


        return shim.Success(nil)
}


// The main function is only relevant in unit test mode. Only included here for completeness.
func main() {

	// Create a new Smart Contract
	err := shim.Start(new(SmartContract))
	if err != nil {
		fmt.Printf("Error creating new Smart Contract: %s", err)
	}
}
