package com.soa.parse;

import com.soa.entity.Protocol;
import com.soa.entity.Reference;
import com.soa.entity.Registry;
import com.soa.entity.Service;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class SOANamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("registry", new RegistryBeanDefinitionParse(Registry.class));//(节点名称  ，   解析类)
        registerBeanDefinitionParser("protocol", new ProtocolBeanDefinitionParse(Protocol.class));//(节点名称  ，   解析类)
        registerBeanDefinitionParser("reference", new ReferenceBeanDefinitionParse(Reference.class));//(节点名称  ，   解析类)
        registerBeanDefinitionParser("service", new ServiceBeanDefinitionParse(Service.class));//(节点名称  ，   解析类)
    }
}
