package com.springbeans.example.springbeansexample;

import com.springbeans.example.springbeansexample.beans.SampleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringBeansExampleApplication implements CommandLineRunner {

	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) {

		SpringApplication.run(SpringBeansExampleApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		SampleBean bean=applicationContext.getBean(SampleBean.class);
		SampleBean bean2=applicationContext.getBean("qualifierChiKrupa",SampleBean.class);
		//SampleBean bean1=applicationContext.getBean(SampleBean.class);
		//SampleBean bean3=applicationContext.getBean(SampleBean.class);
		System.out.println(bean.hashCode());System.out.println(bean2.hashCode());
		//System.out.println(bean1.hashCode());System.out.println(bean3.hashCode());

		System.out.println("---------------------------------------------------");


	}
}
