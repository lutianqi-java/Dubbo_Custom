package com.soa.parse;

import com.soa.entity.Registry;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class SOANamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("register", new RegistryBeanDefinitionParse(Registry.class));


    }
}
