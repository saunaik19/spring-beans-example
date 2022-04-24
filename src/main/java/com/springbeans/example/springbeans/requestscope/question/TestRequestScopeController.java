package com.springbeans.example.springbeans.requestscope.question;

import com.springbeans.example.springbeans.requestscope.beans.MyBean;
import com.springbeans.example.springbeans.requestscope.beans.MyPrototypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TestRequestScopeController {
    @Autowired
    WebApplicationContext webApplicationContext;

    @RequestMapping("test-request")
    public void testRequestVsPrototype(HttpServletResponse httpServletResponse) throws IOException {
        MyBean myBean1=webApplicationContext.getBean(MyBean.class);
        MyBean myBean2=webApplicationContext.getBean(MyBean.class);
        MyPrototypeBean myPrototypeBean1=webApplicationContext.getBean("myPrototypeBean",MyPrototypeBean.class);
        MyPrototypeBean myPrototypeBean2=webApplicationContext.getBean("myPrototypeBean",MyPrototypeBean.class);
        httpServletResponse.getWriter().println(myBean1.hashCode()+ " "+myBean2.hashCode());
        httpServletResponse.getWriter().println("IT is same because they are part of same request");

        httpServletResponse.getWriter().println("------------------------------------------------");
        httpServletResponse.getWriter().println(myPrototypeBean1.hashCode()+ " "+myPrototypeBean2.hashCode());
        httpServletResponse.getWriter().println("IT is different because they are part of same request but type is prototype");
    }
}
