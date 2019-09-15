package com.nku.herb_chain.web;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.nku.herb_chain.dao.UserDao;
import com.nku.herb_chain.domain.User;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/user")
public class UserController {
//    @Resource
//    private UserDao userDao;
    private UserDao userDao;
    
    @RequestMapping("/view")
    public String view() {
        return "main/login";
    }

    @RequestMapping("/indexview")
    public String index() {
        return "main/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(User model, HttpSession session) {
    	System.out.println("login action!");
    	if(model.getUsername().equals("Reflux")&&model.getPassword().equals("123456"))
    	{
        	session.setAttribute("username", model.getUsername());
            return new ModelAndView("redirect:/Main.jsp");
    	}
    	if(model.getUsername().equals("admin")&&model.getPassword().equals("123456"))
    	{
        	session.setAttribute("username", model.getUsername());
            return new ModelAndView("redirect:/Main.jsp");
    	}
    	session.setAttribute("error", "用户名或密码错误");
    	return new ModelAndView("redirect:/Login.jsp");
    }
    @RequestMapping(value = "/quit", method = RequestMethod.POST)
    public ModelAndView quit(User model, HttpSession session) {
    	System.out.println("quit action!");
    	session.invalidate();
    	return new ModelAndView("redirect:/Login.jsp");
    }
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ModelAndView regist(User model, HttpSession session) {
    	System.out.println("regist action!");

        return new ModelAndView("redirect:/regist.jsp");
    }
    
    @RequestMapping(value = "/getURL",  method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public  String getURL()
    {
    	System.out.println("aaa");
    	return "aa";
    			
    }
    
}
