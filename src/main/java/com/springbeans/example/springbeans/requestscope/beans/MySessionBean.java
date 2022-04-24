package com.springbeans.example.springbeans.requestscope.beans;

import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MySessionBean {

    public MySessionBean(){
        System.out.println("My MySessionBean created... "+this.hashCode());
    }
    private String webSiteName="SaurabhNaik.com";

    public String getWebSiteName() {
        return webSiteName;
    }

    public void setWebSiteName(String webSiteName) {
        this.webSiteName = webSiteName;
    }
}
