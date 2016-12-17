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
        return beanDefinitionHashMap.getOrDefault(name, null).getBean();
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        Object bean = createBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionHashMap.put(name, beanDefinition);
    }

    protected abstract Object createBean(BeanDefinition beanDefinition);
}
