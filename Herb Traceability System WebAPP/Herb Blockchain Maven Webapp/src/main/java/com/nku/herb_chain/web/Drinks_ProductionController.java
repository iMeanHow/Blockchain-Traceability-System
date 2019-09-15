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
import com.nku.herb_chain.dao.Drinks_ProductionDao;
import com.nku.herb_chain.dao.PlantingDao;
import com.nku.herb_chain.domain.Business;
import com.nku.herb_chain.domain.Drinks_Production;
import com.nku.herb_chain.domain.Planting;


@Controller
@RequestMapping(value = "/drinks_Production")

public class Drinks_ProductionController {
	
	private Drinks_ProductionDao drinks_ProductionDao;
    public Drinks_Production dp;
    public Stack<Drinks_Production> stack=new Stack<Drinks_Production>();
    private String P_url="";
    private String P_url1="";
    
    private int total=0;
    private int remain=0;
    
    @RequestMapping(value="/reset", method = RequestMethod.POST)
    public ModelAndView view(Drinks_Production model, HttpSession session) {
    	String name=(String) session.getAttribute("username");
    	session.invalidate();
    	session.setAttribute("username", name);
    	return new ModelAndView("redirect:/Planting.jsp");
    }
    @RequestMapping("/indexview")
    public String index() {
        return "main/index";
    }
    @RequestMapping(value ="/visitor_reset", method = RequestMethod.POST)
    public ModelAndView uview(Drinks_Production model, HttpSession session) {

    	session.invalidate();
    	return new ModelAndView("redirect:/drinks_Production_search.jsp");
    }
    @RequestMapping(value = "/visitor_search", method = RequestMethod.POST)
    public ModelAndView udrinks_Production_search(Drinks_Production model, HttpSession session) {
    	System.out.println("drinks_Production_search action! id="+model.getID());
    	
    	drinks_ProductionDao=new Drinks_ProductionDao();
    	Drinks_Production drinks_Production=drinks_ProductionDao.FindByID(model.getID());	
        if (drinks_Production.getID() == null) {
        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Search_Result.jsp");

        } else {
        	System.out.println("Approved");
        	System.out.println(drinks_Production.getID());
            session.setAttribute("mydrinks_Production", drinks_Production);
            return new ModelAndView("redirect:/drinks_Production_search.jsp");
        }	
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
    
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView drinks_Production_search(Drinks_Production model, HttpSession session) {
    	System.out.println("drinks_Production_search action!");
    	drinks_ProductionDao=new Drinks_ProductionDao();
    	Drinks_Production drinks_Production=drinks_ProductionDao.FindByID(model.getID());
    	
        if (drinks_Production.getID() == null) {
        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Result.jsp");
        } else {
        	System.out.println("Approved");
        	System.out.println(drinks_Production.getID());
            session.setAttribute("mydrinks_Production", drinks_Production);
            return new ModelAndView("redirect:/Drinks_Production.jsp");
        }   	
    }
    
    @RequestMapping(value = "/usearch", method = RequestMethod.POST)
    public ModelAndView drinks_Production_usearch(Drinks_Production model, HttpSession session) {
    	System.out.println("drinks_Production_usearch action!");
    	drinks_ProductionDao=new Drinks_ProductionDao();
    	Drinks_Production drinks_Production=drinks_ProductionDao.FindByID(model.getID());
    	
        if (drinks_Production.getID() == null) {
        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Result.jsp");
        } else {
        	System.out.println("Approved");
        	System.out.println(drinks_Production.getID());
            session.setAttribute("mydrinks_Productionu", drinks_Production);
            return new ModelAndView("redirect:/Drinks_Production_update.jsp");
        }   	
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public ModelAndView drinks_Production_insert(Drinks_Production model, HttpSession session) {
    	System.out.println("drinks_Production_insert action!");
    	if(!P_url.equals(""))
    		model.setPicture_url(P_url);
    	P_url="";
    	if(!P_url1.equals(""))
    		model.setPicture_url1(P_url1);
    	P_url1="";
    	dp=new Drinks_Production();
    	dp=model;
    	model=new Drinks_Production();
    	drinks_ProductionDao=new Drinks_ProductionDao();
    	boolean flag=drinks_ProductionDao.insert();	
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
    public  @ResponseBody String drinks_Production_insert_info() {
    	System.out.println("drinks_Production_insert_info action!");
    	System.out.println(dp.toString());
    	remain-=1;
        return dp.toString();     	
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
    	session.setAttribute("table", "drinks_Production");
        return new ModelAndView("redirect:/Uploading.jsp");
	}

	public void readExcel(InputStream input) throws Exception  {
		Workbook wb = null;
	try {
		wb = WorkbookFactory.create(input);
		Sheet sheet = wb.getSheetAt(0); // 获得第一个表单
		int totalRow = sheet.getLastRowNum();// 得到excel的总记录条数
		int columtotal = sheet.getRow(0).getPhysicalNumberOfCells();// 表头总共的列数
		System.out.println("总行数:" + totalRow + ",总列数:" + columtotal);
		Drinks_Production t;
		total=totalRow;
		remain=total;
		for (int i = 1; i <= totalRow; i++) {// 遍历行
			t=new Drinks_Production();
			if(sheet.getRow(i).getCell(0)!=null)
				t.setID(sheet.getRow(i).getCell(0).toString());
			if(sheet.getRow(i).getCell(1)!=null)
				t.setCompany(sheet.getRow(i).getCell(1).toString());
			if(sheet.getRow(i).getCell(2)!=null)
				t.setBusiness_License(sheet.getRow(i).getCell(2).toString());
			if(sheet.getRow(i).getCell(3)!=null)
				t.setTraceability_Promise(sheet.getRow(i).getCell(3).toString());
			if(sheet.getRow(i).getCell(4)!=null)
				t.setGMP_Certificate(sheet.getRow(i).getCell(4).toString());
			if(sheet.getRow(i).getCell(5)!=null)
				t.setAuto_Cancelation(sheet.getRow(i).getCell(5).toString());
			if(sheet.getRow(i).getCell(6)!=null)
				t.setTest_Report(sheet.getRow(i).getCell(6).toString());
			if(sheet.getRow(i).getCell(7)!=null)
				t.setVariety(sheet.getRow(i).getCell(7).toString());
			if(sheet.getRow(i).getCell(8)!=null)
				t.setStorage_Time(sheet.getRow(i).getCell(8).toString());
			if(sheet.getRow(i).getCell(9)!=null)
				t.setStorage_Batch(sheet.getRow(i).getCell(9).toString());
			if(sheet.getRow(i).getCell(10)!=null)
				t.setStorage_Quantity(sheet.getRow(i).getCell(10).toString());
			if(sheet.getRow(i).getCell(11)!=null)
				t.setClassification(sheet.getRow(i).getCell(11).toString());
			if(sheet.getRow(i).getCell(12)!=null)
				t.setSource(sheet.getRow(i).getCell(12).toString());
			if(sheet.getRow(i).getCell(13)!=null)
				t.setStorage_Temp(sheet.getRow(i).getCell(13).toString());
			if(sheet.getRow(i).getCell(14)!=null)
				t.setStorage_Humidity(sheet.getRow(i).getCell(13).toString());
			if(sheet.getRow(i).getCell(13)!=null)
				t.setProcess_Method(sheet.getRow(i).getCell(14).toString());
			if(sheet.getRow(i).getCell(15)!=null)
				t.setPacking_Batch(sheet.getRow(i).getCell(15).toString());
			if(sheet.getRow(i).getCell(16)!=null)
				t.setPacking_Class(sheet.getRow(i).getCell(16).toString());
			if(sheet.getRow(i).getCell(17)!=null)
				t.setPacking_Quantity(sheet.getRow(i).getCell(17).toString());
			if(sheet.getRow(i).getCell(18)!=null)
				t.setDeal_Info(sheet.getRow(i).getCell(18).toString());
			if(sheet.getRow(i).getCell(19)!=null)
				t.setOutput_Variety(sheet.getRow(i).getCell(19).toString());
			if(sheet.getRow(i).getCell(20)!=null)
				t.setOutput_Time(sheet.getRow(i).getCell(20).toString());
			if(sheet.getRow(i).getCell(21)!=null)
				t.setOutput_Batch(sheet.getRow(i).getCell(21).toString());
			if(sheet.getRow(i).getCell(22)!=null)
				t.setOutput_Quantity(sheet.getRow(i).getCell(22).toString());
			if(sheet.getRow(i).getCell(23)!=null)
				t.setOutput_Flow(sheet.getRow(i).getCell(23).toString());
			if(sheet.getRow(i).getCell(24)!=null)
				t.setOutput_Temp(sheet.getRow(i).getCell(24).toString());
			if(sheet.getRow(i).getCell(25)!=null)
				t.setOutput_Humidity(sheet.getRow(i).getCell(25).toString());				
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
		drinks_ProductionDao=new Drinks_ProductionDao();
		while(stack.isEmpty()==false)
		{
		
			dp=stack.pop();
			drinks_ProductionDao.insert();
		}
	}
	

    
}
