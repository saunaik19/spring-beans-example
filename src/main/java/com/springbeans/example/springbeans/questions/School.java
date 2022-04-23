package com.springbeans.example.springbeans.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class School {

    @Autowired
    private NewStudent newStudent;

    public School() {
        System.out.println("School is created, constructor called....");
    }

    public NewStudent getNewStudent() {
        return newStudent;
    }

    public void setNewStudent(NewStudent newStudent) {
        this.newStudent = newStudent;
    }

    @Override
    public String toString() {
        return "School{" +
                "newStudent=" + newStudent.toString() +
                '}';
    }
}
