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
import com.nku.herb_chain.dao.MarketDao;
import com.nku.herb_chain.domain.Business;
import com.nku.herb_chain.domain.Market;
import com.nku.herb_chain.domain.Market;

@Controller
@RequestMapping(value = "/market")

public class MarketController {
	private MarketDao marketDao;
	private Market market;
	private String P_url="";
	private String P_url1="";
	private Stack<Market> stack=new Stack<Market>();
    private int total=0;
    private int remain=0;
    
    @RequestMapping(value ="/visitor_reset", method = RequestMethod.POST)
    public ModelAndView uview(Market model, HttpSession session) {

    	session.invalidate();
    	return new ModelAndView("redirect:/market_search.jsp");
    }
    @RequestMapping(value = "/visitor_search", method = RequestMethod.POST)
    public ModelAndView umarket_search(Market model, HttpSession session) {
    	System.out.println("market_search action! id="+model.getID());
    	
    	marketDao=new MarketDao();
    	Market market=marketDao.FindByID(model.getID());	
        if (market.getID() == null) {
        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Search_Result.jsp");

        } else {
        	System.out.println("Approved");
        	System.out.println(market.getID());
            session.setAttribute("mymarket", market);
            return new ModelAndView("redirect:/market_search.jsp");
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
    
    @RequestMapping(value="/reset", method = RequestMethod.POST)
    public ModelAndView view(Market model, HttpSession session) {
    	String name=(String) session.getAttribute("username");
    	session.invalidate();
    	session.setAttribute("username", name);
    	return new ModelAndView("redirect:/Marketing.jsp");
    }
    
    @RequestMapping("/indexview")
    public String index() {
        return "main/index";
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView market_search(Market model, HttpSession session) {
    	System.out.println("market_search action!");
    	marketDao=new MarketDao();
    	Market market=marketDao.FindByID(model.getID());
    	
        if (market.getID() == null) {

        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Result.jsp");
        } else {
        	System.out.println("Approved");
        	System.out.println(market.getID());
            session.setAttribute("mymarket", market);
            return new ModelAndView("redirect:/Market.jsp");
        }
    	
    }
    
    @RequestMapping(value = "/usearch", method = RequestMethod.POST)
    public ModelAndView market_usearch(Market model, HttpSession session) {
    	System.out.println("market_usearch action!");
    	marketDao=new MarketDao();
    	Market market=marketDao.FindByID(model.getID());
    	
        if (market.getID() == null) {

        	session.setAttribute("result", "ID不存在!");
            return new ModelAndView("redirect:/Result.jsp");
        } else {
        	System.out.println("Approved");
        	System.out.println(market.getID());
            session.setAttribute("mymarketu", market);
            return new ModelAndView("redirect:/Market_update.jsp");
        }	
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public ModelAndView business_update(Business model, HttpSession session) {
    	System.out.println("market_update action!");

    		session.setAttribute("result", "修改成功!");
            return new ModelAndView("redirect:/Update_S.jsp");
        	
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public ModelAndView market_insert(Market model, HttpSession session) {
    	System.out.println("market_insert action!");
    	market=new Market();
    	if(!P_url.equals(""))
    		model.setPicture_url(P_url);
    	if(!P_url1.equals(""))
    		model.setPicture_url1(P_url1);
    	P_url="";
    	P_url1="";
    	market=model;
    	model=new Market();
    	marketDao=new MarketDao();
    	boolean flag=marketDao.insert();	
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
    public  @ResponseBody String market_insert_info() {
    	System.out.println("market_insert_info action!");
    	System.out.println(market.toString());
        return market.toString();     	
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
		session.setAttribute("table", "market");
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
		Market t;
		total=totalRow;
		remain=total;
		
		for (int i = 1; i <= totalRow; i++) {// 遍历行
			t=new Market();
			if(sheet.getRow(i).getCell(0)!=null)
				t.setID(sheet.getRow(i).getCell(0).toString());
			if(sheet.getRow(i).getCell(1)!=null)
				t.setCompany(sheet.getRow(i).getCell(1).toString());
			if(sheet.getRow(i).getCell(2)!=null)
				t.setBusiness_License(sheet.getRow(i).getCell(2).toString());
			if(sheet.getRow(i).getCell(3)!=null)
				t.setTraceability_Promise(sheet.getRow(i).getCell(3).toString());
			if(sheet.getRow(i).getCell(4)!=null)
				t.setWholesaler(sheet.getRow(i).getCell(4).toString());
			if(sheet.getRow(i).getCell(5)!=null)
				t.setMarketing_Variety(sheet.getRow(i).getCell(5).toString());
			if(sheet.getRow(i).getCell(6)!=null)
				t.setMarketing_Quantity(sheet.getRow(i).getCell(6).toString());
			if(sheet.getRow(i).getCell(7)!=null)
				t.setOrigin_Certificate(sheet.getRow(i).getCell(7).toString());
			if(sheet.getRow(i).getCell(8)!=null)
				t.setEnterprise(sheet.getRow(i).getCell(8).toString());
			if(sheet.getRow(i).getCell(9)!=null)
				t.setPesticide_Remain(sheet.getRow(i).getCell(9).toString());	
			if(sheet.getRow(i).getCell(10)!=null)
				t.setContent_Test(sheet.getRow(i).getCell(10).toString());
			if(sheet.getRow(i).getCell(11)!=null)
				t.setTest_Report(sheet.getRow(i).getCell(11).toString());
			if(sheet.getRow(i).getCell(12)!=null)
				t.setDealing_Variety(sheet.getRow(i).getCell(12).toString());
			if(sheet.getRow(i).getCell(13)!=null)
				t.setDealing_Price(sheet.getRow(i).getCell(13).toString());
			if(sheet.getRow(i).getCell(14)!=null)
				t.setDealing_Quantity(sheet.getRow(i).getCell(14).toString());
			if(sheet.getRow(i).getCell(15)!=null)
				t.setDealing_Counterparty(sheet.getRow(i).getCell(15).toString());
			if(sheet.getRow(i).getCell(16)!=null)
				t.setDealing_Flow(sheet.getRow(i).getCell(16).toString());
			
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
		marketDao=new MarketDao();
		while(stack.isEmpty()==false)
		{
			market=stack.pop();
			marketDao.insert();
		}
	}
    
    
}
