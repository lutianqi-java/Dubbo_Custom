package com.soa.parse;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class ProtocolBeanDefinitionParse implements BeanDefinitionParser {

    private Class<?> beanClass;

    public ProtocolBeanDefinitionParse(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.setBeanClass(beanClass);
        rootBeanDefinition.setLazyInit(false);
        String name = element.getAttribute("name");
        String port = element.getAttribute("port");
        String host = element.getAttribute("host");
        if (name == null || "".equals(name)) {
            throw new RuntimeException("name不能为空");
        }
        if (port == null || "".equals(port)) {
            throw new RuntimeException("port不能为空");
        }
        if (host == null || "".equals(host)) {
            throw new RuntimeException("host不能为空");
        }
        rootBeanDefinition.getPropertyValues().add("name", name);
        rootBeanDefinition.getPropertyValues().add("port", port);
        rootBeanDefinition.getPropertyValues().add("host", host);
        parserContext.getRegistry()
                .registerBeanDefinition("Protocol" + name + port + host, rootBeanDefinition);
        return rootBeanDefinition;
    }
}
