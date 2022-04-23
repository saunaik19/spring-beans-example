package com.springbeans.example.springbeans;

import com.springbeans.example.springbeans.beans.ConfigDependentBean;
import com.springbeans.example.springbeans.beans.ConfigDependentPrototypeBean;
import com.springbeans.example.springbeans.beans.PrototypeDemo;
import com.springbeans.example.springbeans.beans.SampleBean;
import com.springbeans.example.springbeans.questions.NewStudent;
import com.springbeans.example.springbeans.questions.School;
import com.springbeans.example.springbeans.questions.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBeansExampleApplication implements CommandLineRunner {

    @Autowired
    ApplicationContext applicationContext;

    public static void main(String[] args) {

        SpringApplication.run(SpringBeansExampleApplication.class, args);


    }

    @Override
    public void run(String... args)  {
        SampleBean bean = applicationContext.getBean(SampleBean.class);
        SampleBean bean2 = applicationContext.getBean("sampleBean", SampleBean.class);
        SampleBean bean3=applicationContext.getBean(SampleBean.class);
        System.out.println(bean.hashCode()+" === " + bean2.hashCode() + " === " + bean3.hashCode());

        System.out.println("---------------------Prototype------------------------------");
        PrototypeDemo prototypeDemo = applicationContext.getBean(PrototypeDemo.class);
        PrototypeDemo prototypeDemo2 = applicationContext.getBean(PrototypeDemo.class);
        PrototypeDemo prototypeDemo3 = applicationContext.getBean(PrototypeDemo.class);
        System.out.println(prototypeDemo.hashCode()+" === " + prototypeDemo2.hashCode() + " === " + prototypeDemo3.hashCode());

        System.out.println("---------------------Config dependent Bean------------------------------");
        ConfigDependentBean configDependentBean = applicationContext.getBean(ConfigDependentBean.class);
        ConfigDependentBean configDependentBean2 = applicationContext.getBean(ConfigDependentBean.class);
        ConfigDependentBean configDependentBean3 = applicationContext.getBean(ConfigDependentBean.class);
        System.out.println(configDependentBean.hashCode()+" === " + configDependentBean2.hashCode() + " === " + configDependentBean3.hashCode());

        System.out.println("---------------------Config dependent Prototype Bean------------------------------");
        ConfigDependentPrototypeBean configDependentPrototypeBean = applicationContext.getBean(ConfigDependentPrototypeBean.class);
        ConfigDependentPrototypeBean configDependentPrototypeBean2 = applicationContext.getBean(ConfigDependentPrototypeBean.class);
        ConfigDependentPrototypeBean configDependentPrototypeBean3 = applicationContext.getBean(ConfigDependentPrototypeBean.class);
        System.out.println(configDependentPrototypeBean.hashCode()+" === " + configDependentPrototypeBean2.hashCode() + " === " + configDependentPrototypeBean3.hashCode());

        System.out.println("________________________________Singleton test-------------------------------------");

        Student student=applicationContext.getBean("student",Student.class);
        student.setStudentName("Saurabh");
        System.out.println("student= "+student.toString());
        Student student2=applicationContext.getBean("student",Student.class);
        student2.setStudentName("Pradnya");
        System.out.println("student2= "+student2.toString()+"  "+"student= "+student.toString() );
        System.out.println("\n \t look into prototype...");

        NewStudent newStudent=applicationContext.getBean(NewStudent.class);
        newStudent.setStudentName("Saurabh");
        NewStudent newStudent2=applicationContext.getBean(NewStudent.class);
        newStudent2.setStudentName("Pradnya");
        System.out.println("newStudent= "+student2.toString()+"  "+"student= "+student.toString() );

        System.out.println("________________________________prototype inside Singleton  test-------------------------------------");

        School school=applicationContext.getBean(School.class);
        NewStudent newSchoolStudent1=school.getNewStudent();
        NewStudent newSchoolStudent2=school.getNewStudent();
        NewStudent newSchoolStudent3=school.getNewStudent();
        newSchoolStudent1.setStudentName("Bokya");
        newSchoolStudent2.setStudentName("Rocky");
        newSchoolStudent3.setStudentName("Mickey");
        school.setNewStudent(newSchoolStudent1);
        System.out.println("school students "+newSchoolStudent1.hashCode()+ " "+newSchoolStudent2.hashCode()+ " "+newSchoolStudent3.hashCode() );

        school.getNewStudent().setStudentName("kaka");
        System.out.println(school.toString());

        System.out.println("same student object in all references in school.....");
        System.out.println("How to solve this???");
        System.out.println("proxy objects ");
        System.out.println("add scope=prototype , proxyMode=ScopedProxyMode.TARGET_CLASS in annotation");


        System.out.println("Spring cglib magic.....");
        System.out.println("school students "+school.getStudentSpring().hashCode()+ " " +
                ""+school.getStudentSpring().hashCode());

    }
}
