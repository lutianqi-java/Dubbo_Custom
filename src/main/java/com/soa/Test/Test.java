package com.soa.Test;

import com.soa.entity.Protocol;
import com.soa.entity.Registry;
import com.soa.springDemo.FactoryBeanPojo;
import com.soa.springDemo.TestInitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext(
                "mytest.xml");
        //        TestService tests = app.getBean(TestService.class);
        //        tests.eat("");
//        Registry registry = app.getBean(Registry.class);
//        System.err.println(registry.getAddress());
//        Protocol protocol = app.getBean(Protocol.class);
//        System.err.println(protocol.getHost());
//        TestInitializingBean testInitializingBean = app.getBean(TestInitializingBean.class);

//        Object school=  app.getBean("factoryBeanPojo");
        FactoryBeanPojo factoryBeanPojo= (FactoryBeanPojo) app.getBean("factoryBeanPojo");
//        System.out.println(school.getClass().getName());
        System.out.println(factoryBeanPojo.getClass().getName());

    }
}
