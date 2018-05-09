package com.soa.springDemo;

import com.soa.springDemoEntity.School;
import com.soa.springDemoEntity.Student;
import org.springframework.beans.factory.FactoryBean;

/**
 * 所以：FactoryBean的核心就在于通过getObject方法可以获取的是它所生产的对象，所以我们在Proxy创建代理对象的时候就比较方便。还有一些bean，如果通过配置的方式，会显得比较麻烦和复杂，那么这时候适当的采用编码方式在某些场合下还是挺不错的。
 * 我们下面就通过一个简单的例子来体验下getObject方法【讲道理，这里实际意义不多，重在理解方法含义】
 * 假如：我们有个Person对象，里面包含 name，address，age。set、get方法不写了
 * OK，那么这个时候我们getBean("personFactory")得到的就是Person对象而不是PersonFactoryBean对象。具体原理参考上面在IOC的应用，我们通过bean = getObjectForBeanInstance(sharedInstance, name, beanName, null)这个方法，具体调用到了getObject方法，所以结果很明显。
 *
 * 通过上面的小案例的代码，我们可以看到如果一个类实现了FactoryBean接口，那么getBean得到的不是他本身了，而是它所产生的对象，如果我们希望得到它本身，只需要加上&符号即可。至于FactoryBean的实际应用，需要大家去发现理解，后面如果有机会会继续聊聊这个东西。
 */
public class FactoryBeanPojo implements FactoryBean {

    private String type;

    public Object getObject() throws Exception {
        if (type.equalsIgnoreCase("student")) {
            return new Student();
        } else {
            return new School();
        }
    }

    public Class<?> getObjectType() {
        return Student.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
