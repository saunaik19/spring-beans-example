package com.springbeans.example.springbeans.requestscope.controllers;

import com.springbeans.example.springbeans.requestscope.beans.MyBean;
import com.springbeans.example.springbeans.requestscope.beans.MySessionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class TestController {

    //MyBean myBean=new MyBean();  mo not this way
    @Autowired
    MyBean myBean;

    @Autowired
    MySessionBean mySessionBean;

    @RequestMapping("/testing")
    public void test(HttpServletResponse httpServletResponse) throws IOException {
        System.out.println(myBean.getWebSiteName());
        PrintWriter out=httpServletResponse.getWriter();
        out.println("old website name is "+myBean.getWebSiteName() +" hashcode ="+myBean.hashCode()+" <br>");
        out.println("old website name is "+mySessionBean.getWebSiteName() +" hashcode ="+mySessionBean.hashCode()+" <br>");
        myBean.setWebSiteName("thisisrequestscopetest.com");
        mySessionBean.setWebSiteName("thisissessionscopetest.com");
        out.println("website updated...");
        out.println("updated website name is "+myBean.getWebSiteName() +" <br>");
    }

    @RequestMapping("/testing2")
    public void testSessionScope(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.getWriter().println("updated website name is "+myBean.getWebSiteName() +" hashcode ="+myBean.hashCode()+" <br>");
        httpServletResponse.getWriter().println("updated website name is "+mySessionBean.getWebSiteName() +" hashcode ="+mySessionBean.hashCode()+" <br>");
    }
}
