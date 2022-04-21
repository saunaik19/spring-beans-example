package com.springbeans.example.springbeans.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeDemo {
    public PrototypeDemo() {
        System.out.println("PrototypeDemo constructor called.....");
    }
}
