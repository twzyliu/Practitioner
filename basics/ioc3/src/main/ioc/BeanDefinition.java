package ioc;

/**
 * Created by zyongliu on 16/12/16.
 */
public class BeanDefinition {
    private Object bean;
    private Class beanClass;
    private String beanClassName;
    private PropertyValues propertyValues;

    public BeanDefinition() {
    }

    public Object getBean() {
        return bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
