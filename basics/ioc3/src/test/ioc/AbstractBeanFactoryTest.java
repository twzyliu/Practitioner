package ioc;

import ioc.factory.AutoWireBeanFactory;
import ioc.property.PropertyValue;
import ioc.property.PropertyValues;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 16/12/16.
 */
public class AbstractBeanFactoryTest {

    private AutoWireBeanFactory autoWireBeanFactory;
    private BeanDefinition beanDefinition;
    private PropertyValues propertyValues;

    @Before
    public void setUp() throws Exception {
        autoWireBeanFactory = new AutoWireBeanFactory();
        beanDefinition = new BeanDefinition();
        propertyValues = new PropertyValues();
    }

    @Test
    public void should_register_and_get_bean() throws Exception {
        beanDefinition.setBeanClassName(TestHelper.BEAN_CLASS_NAME);
        propertyValues.add(new PropertyValue(TestHelper.PROPERTY_NAME, TestHelper.PROPERTY_VALUE));
        beanDefinition.setPropertyValues(propertyValues);
        autoWireBeanFactory.registerBeanDefinition(TestHelper.SERVICE_NAME, beanDefinition);

        HelloWorldService bean = (HelloWorldService) autoWireBeanFactory.getBean(TestHelper.SERVICE_NAME);
        assertThat(bean.hello(), is(TestHelper.PROPERTY_VALUE));
    }
}
