package com.springbeans.example.springbeans.requestscope.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
//@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)//to fool controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST,proxyMode = ScopedProxyMode.TARGET_CLASS)//this is standard way
public class MyBean {

    public MyBean(){
        System.out.println("My Bean object created... "+this.hashCode());
    }
    private String webSiteName="SaurabhNaik.com";

    public String getWebSiteName() {
        return webSiteName;
    }

    public void setWebSiteName(String webSiteName) {
        this.webSiteName = webSiteName;
    }
}
