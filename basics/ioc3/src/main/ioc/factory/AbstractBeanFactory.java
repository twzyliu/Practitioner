package ioc.factory;

import ioc.BeanDefinition;

import java.util.HashMap;

/**
 * Created by zyongliu on 16/12/16.
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    private HashMap<String, BeanDefinition> beanDefinitionHashMap = new HashMap<>();

    @Override
    public Object getBean(String name) {
        BeanDefinition beanDefinition = beanDefinitionHashMap.getOrDefault(name, null);
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = createBean(beanDefinition);
        }
        return bean;
    }

    public void setBeanDefinitionHashMap(HashMap<String, BeanDefinition> beanDefinitionHashMap) {
        this.beanDefinitionHashMap = beanDefinitionHashMap;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        createBean(beanDefinition);
        beanDefinitionHashMap.put(name, beanDefinition);
    }

    protected abstract Object createBean(BeanDefinition beanDefinition);
}
