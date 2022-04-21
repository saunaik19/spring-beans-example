package com.springbeans.example.springbeans;

import com.springbeans.example.springbeans.beans.ConfigDependentBean;
import com.springbeans.example.springbeans.beans.ConfigDependentPrototypeBean;
import com.springbeans.example.springbeans.beans.PrototypeDemo;
import com.springbeans.example.springbeans.beans.SampleBean;
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

    }
}
