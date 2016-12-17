package ioc.factory;

import ioc.BeanDefinition;

/**
 * Created by zyongliu on 16/12/16.
 */
public interface BeanFactory {
    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
