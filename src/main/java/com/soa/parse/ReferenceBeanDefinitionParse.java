package com.soa.parse;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class ReferenceBeanDefinitionParse implements BeanDefinitionParser {

    private Class<?> beanClass;

    public ReferenceBeanDefinitionParse(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.setBeanClass(beanClass);
        rootBeanDefinition.setLazyInit(false);
        String id = element.getAttribute("id");
        String intf = element.getAttribute("interface");
        String loadbalance = element.getAttribute("loadbalance");
        String protocol = element.getAttribute("protocol");
        if (id == null || "".equals(id)) {
            throw new RuntimeException("id不能为空");
        }
        if (intf == null || "".equals(intf)) {
            throw new RuntimeException("intf不能为空");
        }
        if (loadbalance == null || "".equals(loadbalance)) {
            throw new RuntimeException("loadbalance不能为空");
        }
        if (protocol == null || "".equals(protocol)) {
            throw new RuntimeException("protocol不能为空");
        }
        rootBeanDefinition.getPropertyValues().add("id", id);
        rootBeanDefinition.getPropertyValues().add("intf", intf);
        rootBeanDefinition.getPropertyValues().add("loadbalance", loadbalance);
        rootBeanDefinition.getPropertyValues().add("protocol", protocol);
        parserContext.getRegistry()
                .registerBeanDefinition("Reference" + id , rootBeanDefinition);
        return rootBeanDefinition;
    }
}
