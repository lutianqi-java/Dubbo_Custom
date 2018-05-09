package com.soa.parse;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class ServiceBeanDefinitionParse implements BeanDefinitionParser {

    private Class<?> beanClass;

    public ServiceBeanDefinitionParse(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.setBeanClass(beanClass);
        rootBeanDefinition.setLazyInit(false);
        String intf = element.getAttribute("intf");
        String ref = element.getAttribute("ref");
        String protocol = element.getAttribute("protocol");
        if (intf == null || "".equals(intf)) {
            throw new RuntimeException("intf不能为空");
        }
        if (ref == null || "".equals(ref)) {
            throw new RuntimeException("ref不能为空");
        }
        if (protocol == null || "".equals(protocol)) {
            throw new RuntimeException("protocol不能为空");
        }
        rootBeanDefinition.getPropertyValues().add("intf", intf);
        rootBeanDefinition.getPropertyValues().add("ref", ref);
        rootBeanDefinition.getPropertyValues().add("protocol", protocol);
        parserContext.getRegistry()
                .registerBeanDefinition("Service" + intf + ref + protocol, rootBeanDefinition);
        return rootBeanDefinition;
    }
}
