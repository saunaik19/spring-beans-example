package com.springbeans.example.springbeans.requestscope.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@Scope(value = "prototype",proxyMode =ScopedProxyMode.TARGET_CLASS)
public class MyPrototypeBean {

    public MyPrototypeBean(){
        System.out.println("My MyPrototypeBean object created... "+this.hashCode());
    }
    private String webSiteName="SaurabhNaik.com";

    public String getWebSiteName() {
        return webSiteName;
    }

    public void setWebSiteName(String webSiteName) {
        this.webSiteName = webSiteName;
    }
}
