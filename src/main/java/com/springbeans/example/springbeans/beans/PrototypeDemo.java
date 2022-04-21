package com.springbeans.example.springbeans.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)//correct way
public class PrototypeDemo {
    public PrototypeDemo() {
        System.out.println("PrototypeDemo constructor called.....");
    }
}
