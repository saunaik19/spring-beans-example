package com.springbeans.example.springbeans.config;

import com.springbeans.example.springbeans.beans.ConfigDependentBean;
import com.springbeans.example.springbeans.beans.ConfigDependentPrototypeBean;
import com.springbeans.example.springbeans.beans.PrototypeDemo;
import com.springbeans.example.springbeans.beans.SampleBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

  /*  @Bean
    public SampleBean createBean(){
        return new SampleBean();
    }
    Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException:
    No qualifying bean of type 'SampleBean'
     available: expected single matching bean but found 2: sampleBean,createBean

   */

    /*
    @Bean
    public SampleBean sampleBean(){
       return new SampleBean();
    }
    Description:

    The bean 'sampleBean', defined in class path resource
     [com/springbeans/example/springbeans/config/AppConfig.class],
      could not be registered. A bean with that name has already been defined in file
       [D:\MyCodeBase\spring-beans-example\target\classes\com\springbeans\example\
       springbeansexample\beans\SampleBean.class] and overriding is disabled.
     */

  //  @Bean No qualifying bean of type 'com.springbeans.example.springbeans.beans.PrototypeDemo'
  //  available: expected single matching bean but found 2:
  //  prototypeDemo,somedifferentBeanProtoType
    public PrototypeDemo somedifferentBeanProtoType(){
        return new PrototypeDemo();
    }

    @Bean
    public ConfigDependentBean configDependentBean(){
        return new ConfigDependentBean();
    }

    @Bean
    @Scope("prototype")
    public ConfigDependentPrototypeBean configDependentPrototypeBean(){
        return new ConfigDependentPrototypeBean();
    }
}
