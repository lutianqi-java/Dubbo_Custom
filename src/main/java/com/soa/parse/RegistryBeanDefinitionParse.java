package com.soa.parse;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class RegistryBeanDefinitionParse implements BeanDefinitionParser {

    /**
     * Register  这个类，解析对应的xml  并注册
     */
    private Class<?> beanClass;

    public RegistryBeanDefinitionParse(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.setBeanClass(beanClass);
        rootBeanDefinition.setLazyInit(false);
        String protocol = element.getAttribute("protocol");
        String address = element.getAttribute("address");
        if (protocol == null || "".equals(protocol)) {
            throw new RuntimeException("protocol不能为空");
        }
        if (address == null || "".equals(address)) {
            throw new RuntimeException("address不能为空");
        }
        rootBeanDefinition.getPropertyValues().add("protocol", protocol);
        rootBeanDefinition.getPropertyValues().add("address", address);
        parserContext.getRegistry()
                .registerBeanDefinition("Registry" + address, rootBeanDefinition);
        return rootBeanDefinition;
    }
}
