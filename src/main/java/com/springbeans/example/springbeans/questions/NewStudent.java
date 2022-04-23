package com.springbeans.example.springbeans.questions;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NewStudent {
    private String studentName;

    public NewStudent() {
        System.out.println("NewStudent constructor called...."+this.hashCode());
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "NewStudent{" +
                "studentName='" + studentName + '\'' +
                '}';
    }
}
