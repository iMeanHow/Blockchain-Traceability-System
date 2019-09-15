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
import com.nku.herb_chain.dao.UseDao;
import com.nku.herb_chain.domain.Business;
import com.nku.herb_chain.domain.Planting;
import com.nku.herb_chain.domain.Test_Report;
import com.nku.herb_chain.domain.Use;

@Controller
@RequestMapping(value = "/use")

public class UseController {
	private UseDao useDao;   
    public Use use;
    private Stack<Use> stack=new Stack<Use>();
    private String P_url="";
    private int total=0;
    private int remain=0;
    
    @RequestMapping(value="/reset", method = RequestMethod.POST)
    public ModelAndView view(Use model, HttpSession session) {
    	String name=(String) session.getAttribute("username");
    	session.invalidate();
    	session.setAttribute("username", name);
    	return new ModelAndView("redirect:/Use.jsp");
    }
    @RequestMapping("/indexview")
    public String index() {
        return "main/index";
    }
    
    @RequestMapping(value ="/visitor_reset", method = RequestMethod.POST)
    public ModelAndView uview(Use model, HttpSession session) {

    	session.invalidate();
    	return new ModelAndView("redirect:/use_search.jsp");
    }
    @RequestMapping(value = "/visitor_search", method = RequestMethod.POST)
    public ModelAndView uuse_search(Use model, HttpSession session) {
    	System.out.println("use_search action! id="+model.getID());
    	
    	useDao=new UseDao();
    	Use use=useDao.FindByID(model.getID());	
        if (use.getID() == null) {
        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Search_Result.jsp");

        } else {
        	System.out.println("Approved");
        	System.out.println(use.getID());
            session.setAttribute("myuse", use);
            return new ModelAndView("redirect:/use_search.jsp");
        }	
    }
    
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView use_search(Use model, HttpSession session) {
    	System.out.println("use_search action!");
    	useDao=new UseDao();
    	Use use=useDao.FindByID(model.getID());	
        if (use.getID() == null) {
        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Result.jsp");
        } else {
        	System.out.println("Approved");
        	System.out.println(use.getID());
            session.setAttribute("myuse", use);
            return new ModelAndView("redirect:/Use.jsp");
        }	
    }
    @RequestMapping(value = "/usearch", method = RequestMethod.POST)
    public ModelAndView use_usearch(Use model, HttpSession session) {
    	System.out.println("use_usearch action!");
    	useDao=new UseDao();
    	Use use=useDao.FindByID(model.getID());	
        if (use.getID() == null) {
        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Result.jsp");
        } else {
        	System.out.println("Approved");
        	System.out.println(use.getID());
            session.setAttribute("myuseu", use);
            return new ModelAndView("redirect:/Use_update.jsp");
        }	
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public ModelAndView use_insert(Use model, HttpSession session) {
    	System.out.println("use_insert action!");
    	use=new Use();
    	if(!P_url.equals(""))
    		model.setPicture_url(P_url);
    	P_url="";
    	use=model;
    	model=new Use();
    	useDao=new UseDao();
    	boolean flag=useDao.insert();	
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
    public  @ResponseBody String use_insert_info() {
    	System.out.println("use_insert_info action!");
    	System.out.println(use.toString());
        return use.toString();     	
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
		session.setAttribute("table", "use");
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
		Use t;
		total=totalRow;
		remain=total;
		for (int i = 1; i <= totalRow; i++) {// 遍历行
			t=new Use();
			if(sheet.getRow(i).getCell(0)!=null)
				t.setID(sheet.getRow(i).getCell(0).toString());
			if(sheet.getRow(i).getCell(1)!=null)
				t.setCompany(sheet.getRow(i).getCell(1).toString());
			if(sheet.getRow(i).getCell(2)!=null)
				t.setPharmacy_Ledger(sheet.getRow(i).getCell(2).toString());
			if(sheet.getRow(i).getCell(3)!=null)
				t.setConsumer_Ledger(sheet.getRow(i).getCell(3).toString());

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
		useDao=new UseDao();
		while(stack.isEmpty()==false)
		{
			use=stack.pop();
			useDao.insert();
		}
	}
    
    
    
    
}

