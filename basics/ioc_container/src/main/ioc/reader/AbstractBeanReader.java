package ioc.reader;

import ioc.BeanDefinition;

import java.util.HashMap;

/**
 * Created by zyongliu on 16/12/16.
 */
public abstract class AbstractBeanReader implements BeanReader {
    private HashMap<String, BeanDefinition> beanHashMap = new HashMap<>();

    public HashMap<String, BeanDefinition> getBeanHashMap() {
        return beanHashMap;
    }
}
