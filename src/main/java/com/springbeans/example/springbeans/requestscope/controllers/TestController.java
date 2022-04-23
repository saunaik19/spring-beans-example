package com.springbeans.example.springbeans.requestscope.controllers;

import com.springbeans.example.springbeans.requestscope.beans.MyBean;
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

    @RequestMapping("/testing")
    public void test(HttpServletResponse httpServletResponse) throws IOException {
        System.out.println(myBean.getWebSiteName());
        PrintWriter out=httpServletResponse.getWriter();
        out.println("old website name is "+myBean.getWebSiteName() +" <br>");
        myBean.setWebSiteName("saurabhgovindNaik.com");
        out.println("website updated...");
        out.println("updated website name is "+myBean.getWebSiteName() +" <br>");
    }
}
