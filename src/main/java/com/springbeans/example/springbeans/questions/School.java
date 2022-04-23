package com.springbeans.example.springbeans.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class School {

    @Autowired
    private NewStudent newStudent;
    @Autowired
    private StudentSpring studentSpring;

    public School() {
        System.out.println("School is created, constructor called....");
    }


    @Lookup //spring will use cg libs & provide us implementation for this
    StudentSpring createStudentSpring(){
        return null;
    }

    public NewStudent getNewStudent() {
        return newStudent;
    }


    public void setNewStudent(NewStudent newStudent) {
        this.newStudent = newStudent;
    }

    public StudentSpring getStudentSpring() {
        StudentSpring newStudentSpring=createStudentSpring();
        return newStudentSpring;
    }

    public void setStudentSpring(StudentSpring studentSpring) {
        this.studentSpring = studentSpring;
    }
}
