package com.nku.herb_chain.web;

import java.io.BufferedInputStream;

import java.io.BufferedReader;
import java.io.IOException;



import java.io.InputStream;
import java.util.List;
import java.util.Stack;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import net.sf.json.JSONObject;
import com.nku.herb_chain.domain.Business;
import com.nku.herb_chain.domain.Planting;
import com.nku.herb_chain.connection.OSSClientUtil;
import com.nku.herb_chain.dao.BusinessDao;
import com.nku.herb_chain.dao.PlantingDao;
import com.nku.herb_chain.dao.UpImgService;

@Controller
@RequestMapping(value = "/business")

public class BusinessController {
//	@Resource
//	private BusinessDao bd;
	private Stack<Business> stack=new Stack<Business>();
	private UpImgService upImgService;
	private BusinessDao businessDao;   
	private String P_url="";
	private String P_url1="";
    public Business bu;
    private int total=0;
    private int remain=0;
    @RequestMapping(value ="/reset", method = RequestMethod.POST)
    public ModelAndView view(Business model, HttpSession session) {
    	String name=(String) session.getAttribute("username");
    	session.invalidate();
    	session.setAttribute("username", name);
    	return new ModelAndView("redirect:/Business.jsp");
    }
    @RequestMapping("/indexview")
    public String index() {
        return "main/index";
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView business_search(Business model, HttpSession session) {
    	System.out.println("business_search action! id="+model.getID());
    	
    	businessDao=new BusinessDao();
    	Business business=businessDao.FindByID(model.getID());	
        if (business.getID() == null) {
        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Result.jsp");

        } else {
        	System.out.println("Approved");
        	System.out.println(business.getID());
            session.setAttribute("mybusiness", business);
            return new ModelAndView("redirect:/Business.jsp");
        }	
    }
    @RequestMapping(value ="/visitor_reset", method = RequestMethod.POST)
    public ModelAndView uview(Business model, HttpSession session) {

    	session.invalidate();
    	return new ModelAndView("redirect:/business_search.jsp");
    }
    @RequestMapping(value = "/visitor_search", method = RequestMethod.POST)
    public ModelAndView ubusiness_search(Business model, HttpSession session) {
    	System.out.println("business_search action! id="+model.getID());
    	
    	businessDao=new BusinessDao();
    	Business business=businessDao.FindByID(model.getID());	
        if (business.getID() == null) {
        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Search_Result.jsp");

        } else {
        	System.out.println("Approved");
        	System.out.println(business.getID());
            session.setAttribute("mybusiness", business);
            return new ModelAndView("redirect:/business_search.jsp");
        }	
    }
    
    @RequestMapping(value = "/usearch", method = RequestMethod.POST)
    public ModelAndView business_usearch(Business model, HttpSession session) {
    	System.out.println("business_search action! id="+model.getID());
    	
    	businessDao=new BusinessDao();
    	Business business=businessDao.FindByID(model.getID());	
        if (business.getID() == null) {
        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Result.jsp");
        } else {
        	System.out.println("Approved");
        	System.out.println(business.getID());
            session.setAttribute("mybusinessu", business);
            return new ModelAndView("redirect:/Business_update.jsp");
        }	
    }
    
    
    @RequestMapping(value = "/update", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public ModelAndView business_update(Business model, HttpSession session) {
    	System.out.println("business_update action!");
    	System.out.println(model.getID());
    	System.out.println(model.getVariety());
    	System.out.println(model.getStorage_Batch());
    	session.setAttribute("result", "修改成功!");
        return new ModelAndView("redirect:/Update_S.jsp");      	
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public ModelAndView business_insert( Business model,HttpSession session) throws IOException {
    	if(!P_url.equals(""))
    		model.setPicture_url(P_url);
    	if(!P_url1.equals(""))
    		model.setPicture_url1(P_url1);
    	P_url="";
    	P_url1="";
    	bu=model;
    	System.out.println(bu.toString());
    	model=new Business();
    	businessDao=new BusinessDao();
    	boolean flag=businessDao.insert();	
        if (!flag) {
        	session.setAttribute("result", "添加失败!");
            return new ModelAndView("redirect:/Update_S.jsp");}
        else {
    	session.setAttribute("result", "添加成功!");
        return new ModelAndView("redirect:/Update_S.jsp");
        }   	
    }
    
    @RequestMapping(value = "/info", method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    public  @ResponseBody String business_test() {
    	System.out.println("business_info action!");
    	System.out.println(bu.toString());
    	remain-=1;
        return bu.toString();     	
    }
    
    @RequestMapping(value = "/android_insert",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public  void business_adtest(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	System.out.println("business_adtest action!");
    	
		BufferedReader br=request.getReader();
		String body = "",str="";
		while((str=br.readLine())!=null)
		{
			body+=str.trim();
		}
		JSONObject json=JSONObject.fromObject(body);
		bu=(Business)JSONObject.toBean(json,Business.class);
		businessDao=new BusinessDao();
		businessDao.insert();
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
		session.setAttribute("table", "business");
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
		Sheet sheet = wb.getSheetAt(0); 
		int totalRow = sheet.getLastRowNum();
		int columtotal = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("总行数:" + totalRow + ",总列数:" + columtotal);
		total=totalRow;
		remain=total;
		Business t;

		for (int i = 1; i <= totalRow; i++) {
			t=new Business();
			if(sheet.getRow(i).getCell(0)!=null)
				t.setID(sheet.getRow(i).getCell(0).toString());
			if(sheet.getRow(i).getCell(1)!=null)
				t.setBusiness_License(sheet.getRow(i).getCell(1).toString());
			if(sheet.getRow(i).getCell(2)!=null)
				t.setTraceability_Promise(sheet.getRow(i).getCell(2).toString());
			if(sheet.getRow(i).getCell(3)!=null)
				t.setGSP_Permission(sheet.getRow(i).getCell(3).toString());
			if(sheet.getRow(i).getCell(4)!=null)
				t.setVariety(sheet.getRow(i).getCell(4).toString());
			if(sheet.getRow(i).getCell(5)!=null)
				t.setSource(sheet.getRow(i).getCell(5).toString());
			if(sheet.getRow(i).getCell(6)!=null)
				t.setStorage_Batch(sheet.getRow(i).getCell(6).toString());
			if(sheet.getRow(i).getCell(7)!=null)
				t.setStorage_Quantity(sheet.getRow(i).getCell(7).toString());
			if(sheet.getRow(i).getCell(8)!=null)
				t.setClassification(sheet.getRow(i).getCell(8).toString());
			if(sheet.getRow(i).getCell(9)!=null)
				t.setProduct_Enterprise(sheet.getRow(i).getCell(9).toString());
			if(sheet.getRow(i).getCell(10)!=null)
				t.setProduce_Time(sheet.getRow(i).getCell(10).toString());
			if(sheet.getRow(i).getCell(11)!=null)
				t.setFlow_Nodes(sheet.getRow(i).getCell(11).toString());
			if(sheet.getRow(i).getCell(12)!=null)
				t.setHumidity(sheet.getRow(i).getCell(12).toString());
			if(sheet.getRow(i).getCell(13)!=null)
				t.setDeal_Info(sheet.getRow(i).getCell(13).toString());
			
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
		businessDao=new BusinessDao();
		while(stack.isEmpty()==false)
		{
		
			bu=stack.pop();
			businessDao.insert();
		}
	}
	
	
	
	
}
