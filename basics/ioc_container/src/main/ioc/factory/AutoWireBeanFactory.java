package ioc.factory;

import ioc.BeanDefinition;
import ioc.property.PropertyValue;

import java.lang.reflect.Field;

/**
 * Created by zyongliu on 16/12/16.
 */
public class AutoWireBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(BeanDefinition beanDefinition) {
        //newInstance后立即setBean再处理property,解决循环依赖。
        try {
            Object instance = beanDefinition.getBeanClass().newInstance();
            beanDefinition.setBean(instance);
            for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()) {
                Field declaredField = instance.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                Object value = propertyValue.getValue();
                if (value instanceof BeanDefinition) {
                    value = getBean(((BeanDefinition)value).getBeanClassName());
                }
                declaredField.set(instance, value);
            }
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
