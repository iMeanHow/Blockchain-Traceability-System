package com.nku.herb_chain.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nku.herb_chain.connection.OSSClientUtil;
import com.nku.herb_chain.dao.BusinessDao;
import com.nku.herb_chain.dao.PlantingDao;
import com.nku.herb_chain.dao.Test_ReportDao;
import com.nku.herb_chain.domain.Business;
import com.nku.herb_chain.domain.Test_Report;
import com.nku.herb_chain.domain.Planting;

@Controller
@RequestMapping(value = "/test_Report")

public class Test_ReportController {
	private Test_ReportDao test_ReportDao;   
    public Test_Report tr;
    private String P_url="";

    private String P_url1="";
    private Stack<Test_Report> stack=new Stack<Test_Report>();
    private int total=0;
    private int remain=0;
    
    @RequestMapping(value="/reset", method = RequestMethod.POST)
    public ModelAndView view(Test_Report model, HttpSession session) {
    	String name=(String) session.getAttribute("username");
    	session.invalidate();
    	session.setAttribute("username", name);
    	return new ModelAndView("redirect:/Test_Report.jsp");
    }
    @RequestMapping("/indexview")
    public String index() {
        return "main/index";
    }
    
    @RequestMapping(value ="/visitor_reset", method = RequestMethod.POST)
    public ModelAndView uview(Test_Report model, HttpSession session) {

    	session.invalidate();
    	return new ModelAndView("redirect:/test_Report_search.jsp");
    }
    @RequestMapping(value = "/visitor_search", method = RequestMethod.POST)
    public ModelAndView utest_Report_search(Test_Report model, HttpSession session) {
    	System.out.println("test_Report_search action! id="+model.getID());
    	
    	test_ReportDao=new Test_ReportDao();
    	Test_Report test_Report=test_ReportDao.FindByID(model.getID());	
        if (test_Report.getID() == null) {
        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Search_Result.jsp");

        } else {
        	System.out.println("Approved");
        	System.out.println(test_Report.getID());
            session.setAttribute("mytest_Report", test_Report);
            return new ModelAndView("redirect:/test_Report_search.jsp");
        }	
    }
    
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView test_Report_search(Test_Report model, HttpSession session) {
    	System.out.println("test_Report_search action!");
    	test_ReportDao=new Test_ReportDao();
    	Test_Report test_Report=test_ReportDao.FindByID(model.getID());	
        if (test_Report.getID() == null) {
        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Result.jsp");
        } else {
        	System.out.println("Approved");
        	System.out.println(test_Report.getID());
            session.setAttribute("mytest_Report", test_Report);
            return new ModelAndView("redirect:/Test_Report.jsp");
        }	
    }
    
    @RequestMapping(value = "/usearch", method = RequestMethod.POST)
    public ModelAndView test_Report_usearch(Test_Report model, HttpSession session) {
    	System.out.println("test_Report_usearch action!");
    	test_ReportDao=new Test_ReportDao();
    	Test_Report test_Report=test_ReportDao.FindByID(model.getID());	
        if (test_Report.getID() == null) {
        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Result.jsp");
        } else {
        	System.out.println("Approved");
        	System.out.println(test_Report.getID());
            session.setAttribute("mytest_Reportu", test_Report);
            return new ModelAndView("redirect:/Test_Report_update.jsp");
        }	
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public ModelAndView test_Report_update(Business model, HttpSession session) {
    	System.out.println("test_Report_update action!");
    	session.setAttribute("result", "修改成功!");
        return new ModelAndView("redirect:/Update_S.jsp");   	
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public ModelAndView test_Report_insert(Test_Report model, HttpSession session) {
    	System.out.println("test_Report_insert action!");
    	if(!P_url.equals(""))
    		model.setPicture_url(P_url);
    	if(!P_url1.equals(""))
    		model.setPicture_url1(P_url1);
    	P_url="";P_url1="";
    	tr=model;
    	model=new Test_Report();
    	Test_ReportDao test_ReportDao=new Test_ReportDao();
    	boolean flag=test_ReportDao.insert();	
        if (!flag) {
        	System.out.println("添加失败");
        	session.setAttribute("result", "添加失败!");
            return new ModelAndView("redirect:/Update_S.jsp");}
        else {
        System.out.println("添加成功");
    	session.setAttribute("result", "添加成功!");
        return new ModelAndView("redirect:/Update_S.jsp");
        }	
    }
    
    @RequestMapping(value = "/UpImg", method = RequestMethod.POST)
    public void UploadImg(@RequestParam(value="file",required=false) MultipartFile file) throws IOException {
    		
    		System.out.println("Img Upload");
    	    if (file == null || file.getSize() <= 0) 
    	    {
  		      System.out.println("file不能为空");
  		    }
	        OSSClientUtil ossClient=new OSSClientUtil();
		    String name = ossClient.uploadImg2Oss(file);
		    String imgUrl = ossClient.getImgUrl(name);
		    String[] split = imgUrl.split("\\?");
		    System.out.println("split_url="+split[0]);
		    if(P_url.equals(""))
		    	P_url=split[0];
		    else
		    	P_url1=split[0];
    }
    
    
    @RequestMapping(value = "/info", method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    public  @ResponseBody String test_Report_test() {
    	System.out.println("test_Report_info action!");
    	System.out.println(tr.toString());
    	remain-=1;
        return tr.toString();     	
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    protected ModelAndView Excel_Insert(@RequestParam(value="file",required=false) MultipartFile file,HttpSession session)throws ServletException, IOException {
		System.out.println("file upload!!");
		new Thread(new Runnable() {		
			@Override
			public void run() {
				try {
					readExcel(file.getInputStream());
					Excel_insert();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();	
		session.setAttribute("table", "test_Report");
        return new ModelAndView("redirect:/Uploading.jsp");
	}

    @RequestMapping(value = "/progress", method = RequestMethod.POST)
    @ResponseBody
    public int progress()
    {
    	return remain;
    }
    
    @RequestMapping(value = "/total", method = RequestMethod.POST)
    @ResponseBody
    public int total()
    {
    	return total;
    }
	public void readExcel(InputStream input) throws Exception  {
		Workbook wb = null;
	try {
		wb = WorkbookFactory.create(input);
		Sheet sheet = wb.getSheetAt(0); // 获得第一个表单
		int totalRow = sheet.getLastRowNum();// 得到excel的总记录条数
		int columtotal = sheet.getRow(0).getPhysicalNumberOfCells();// 表头总共的列数
		System.out.println("总行数:" + totalRow + ",总列数:" + columtotal);
		Test_Report t;
		total=totalRow;
		remain=total;
		for (int i = 1; i <= totalRow; i++) {// 遍历行
			t=new Test_Report();
			if(sheet.getRow(i).getCell(0)!=null)
				t.setID(sheet.getRow(i).getCell(0).toString());
			if(sheet.getRow(i).getCell(1)!=null)
				t.setReport_ID(sheet.getRow(i).getCell(1).toString());
			if(sheet.getRow(i).getCell(2)!=null)
				t.setProduct_Name(sheet.getRow(i).getCell(2).toString());
			if(sheet.getRow(i).getCell(3)!=null)
				t.setProduction_Place(sheet.getRow(i).getCell(3).toString());
			if(sheet.getRow(i).getCell(4)!=null)
				t.setQuantity(sheet.getRow(i).getCell(4).toString());
			if(sheet.getRow(i).getCell(5)!=null)
				t.setBatch(sheet.getRow(i).getCell(5).toString());
			if(sheet.getRow(i).getCell(6)!=null)
				t.setSample_Origin(sheet.getRow(i).getCell(6).toString());
			if(sheet.getRow(i).getCell(7)!=null)
				t.setTest_Type(sheet.getRow(i).getCell(7).toString());
			if(sheet.getRow(i).getCell(8)!=null)
				t.setTest_Date(sheet.getRow(i).getCell(8).toString());
			if(sheet.getRow(i).getCell(9)!=null)
				t.setReport_Date(sheet.getRow(i).getCell(9).toString());
			if(sheet.getRow(i).getCell(10)!=null)
				t.setReference(sheet.getRow(i).getCell(10).toString());
			if(sheet.getRow(i).getCell(11)!=null)
				t.setCharacteristics(sheet.getRow(i).getCell(11).toString());
			if(sheet.getRow(i).getCell(12)!=null)
				t.setMicro_Character(sheet.getRow(i).getCell(12).toString());
			if(sheet.getRow(i).getCell(13)!=null)
				t.setThin_Layer_Character(sheet.getRow(i).getCell(13).toString());
			if(sheet.getRow(i).getCell(14)!=null)
				t.setMoisture(sheet.getRow(i).getCell(4).toString());
			if(sheet.getRow(i).getCell(15)!=null)
				t.setAshes(sheet.getRow(i).getCell(5).toString());
			if(sheet.getRow(i).getCell(16)!=null)
				t.setAcid_Insoluble_Ash(sheet.getRow(i).getCell(6).toString());
			if(sheet.getRow(i).getCell(17)!=null)
				t.setSO2_Remain(sheet.getRow(i).getCell(17).toString());
			if(sheet.getRow(i).getCell(18)!=null)
				t.setGranularity(sheet.getRow(i).getCell(18).toString());
			if(sheet.getRow(i).getCell(19)!=null)
				t.setEvenness(sheet.getRow(i).getCell(19).toString());
			if(sheet.getRow(i).getCell(20)!=null)
				t.setMicrobe_Limitation(sheet.getRow(i).getCell(20).toString());
			if(sheet.getRow(i).getCell(21)!=null)
				t.setExtractive(sheet.getRow(i).getCell(21).toString());
			if(sheet.getRow(i).getCell(22)!=null)
				t.setConclusion(sheet.getRow(i).getCell(22).toString());
			
			stack.push(t);
		}
		
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new Exception(ex);
	}finally {
		 try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	} 
	
	public void Excel_insert() {
		test_ReportDao=new Test_ReportDao();
		while(stack.isEmpty()==false)
		{
			tr=stack.pop();
			test_ReportDao.insert();
		}
	}
    
    
}

