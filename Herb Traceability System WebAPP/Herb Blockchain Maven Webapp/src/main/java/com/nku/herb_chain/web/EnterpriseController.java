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

import com.nku.herb_chain.domain.Business;
import com.nku.herb_chain.domain.Drinks_Production;
import com.nku.herb_chain.domain.Enterprise;
import com.nku.herb_chain.connection.OSSClientUtil;
import com.nku.herb_chain.dao.BusinessDao;
import com.nku.herb_chain.dao.EnterpriseDao;

@Controller
@RequestMapping(value = "/enterprise")

public class EnterpriseController {
	private EnterpriseDao enterpriseDao;
    private Enterprise enterprise;
    private Stack<Enterprise> stack=new Stack<Enterprise>();
    private String P_url="";
    private int total=0;
    private int remain=0;
    @RequestMapping(value ="/visitor_reset", method = RequestMethod.POST)
    public ModelAndView uview(Enterprise model, HttpSession session) {

    	session.invalidate();
    	return new ModelAndView("redirect:/enterprise_search.jsp");
    }
    @RequestMapping(value = "/visitor_search", method = RequestMethod.POST)
    public ModelAndView uenterprise_search(Enterprise model, HttpSession session) {
    	System.out.println("enterprise_search action! id="+model.getID());
    	
    	enterpriseDao=new EnterpriseDao();
    	Enterprise enterprise=enterpriseDao.FindByID(model.getID());	
        if (enterprise.getID() == null) {
        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Search_Result.jsp");

        } else {
        	System.out.println("Approved");
        	System.out.println(enterprise.getID());
            session.setAttribute("myenterprise", enterprise);
            return new ModelAndView("redirect:/enterprise_search.jsp");
        }	
    }
    @RequestMapping(value="/reset", method = RequestMethod.POST)
    public ModelAndView view(Enterprise model, HttpSession session) {
    	String name=(String) session.getAttribute("username");
    	session.invalidate();
    	session.setAttribute("username", name);
    	return new ModelAndView("redirect:/Enterprise.jsp");
    }
    @RequestMapping("/indexview")
    public String index() {
        return "main/index";
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
    public ModelAndView enterprise_search(Enterprise model, HttpSession session) {
    	System.out.println("enterprise_search action!");
    	enterpriseDao=new EnterpriseDao();
    	Enterprise enterprise=enterpriseDao.FindByID(model.getID());
        if (enterprise.getID() == null) {
        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Result.jsp");
        } else {
        	System.out.println("Approved");
            session.setAttribute("myenterprise", enterprise);
            return new ModelAndView("redirect:/Enterprise.jsp");
        }	
    }
    
    @RequestMapping(value = "/usearch", method = RequestMethod.POST)
    public ModelAndView enterprise_usearch(Enterprise model, HttpSession session) {
    	System.out.println("enterprise_usearch action!");
    	enterpriseDao=new EnterpriseDao();
    	Enterprise enterprise=enterpriseDao.FindByID(model.getID());
        if (enterprise.getID() == null) {

        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Result.jsp");
        } else {
        	System.out.println("Approved");
        	System.out.println(enterprise.getID());
            session.setAttribute("myenterpriseu", enterprise);
            return new ModelAndView("redirect:/Enterprise_update.jsp");
        }	
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public ModelAndView enterprise_insert(Enterprise model, HttpSession session) {
    	System.out.println("enterprise_insert action!");
    	enterprise=new Enterprise();
    	if(!P_url.equals(""))
    		model.setPicture_url(P_url);
    	P_url="";
    	enterprise=model;
    	model=new Enterprise();
    	enterpriseDao=new EnterpriseDao();
    	boolean flag=enterpriseDao.insert();	
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
		    P_url=split[0];
    }
    
    
    @RequestMapping(value = "/info", method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    public  @ResponseBody String enterprise_insert_info() {
    	System.out.println("enterprise_insert_info action!");
    	System.out.println(enterprise.toString());
    	remain-=1;
        return enterprise.toString();     	
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
		session.setAttribute("table", "enterprise");
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
		Enterprise t;
		total=totalRow;
		remain=total;
		for (int i = 1; i <= totalRow; i++) {// 遍历行
			t=new Enterprise();
			if(sheet.getRow(i).getCell(0)!=null)
				t.setID(sheet.getRow(i).getCell(0).toString());
			if(sheet.getRow(i).getCell(1)!=null)
				t.setCompany(sheet.getRow(i).getCell(1).toString());
			if(sheet.getRow(i).getCell(2)!=null)
				t.setTraceability_Promise(sheet.getRow(i).getCell(2).toString());
			if(sheet.getRow(i).getCell(3)!=null)
				t.setBusiness_License(sheet.getRow(i).getCell(3).toString());
			if(sheet.getRow(i).getCell(4)!=null)
				t.setProduct_Batch(sheet.getRow(i).getCell(4).toString());
			if(sheet.getRow(i).getCell(5)!=null)
				t.setSave_Time(sheet.getRow(i).getCell(5).toString());
			if(sheet.getRow(i).getCell(6)!=null)
				t.setSource(sheet.getRow(i).getCell(6).toString());
			if(sheet.getRow(i).getCell(7)!=null)
				t.setSave_Temp(sheet.getRow(i).getCell(7).toString());
			if(sheet.getRow(i).getCell(8)!=null)
				t.setSave_Humidity(sheet.getRow(i).getCell(8).toString());
			if(sheet.getRow(i).getCell(9)!=null)
				t.setTransaction_Voucher(sheet.getRow(i).getCell(9).toString());			
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
		enterpriseDao=new EnterpriseDao();
		while(stack.isEmpty()==false)
		{
			enterprise=stack.pop();
			enterpriseDao.insert();
		}
	}
    
    
}
