package ioc;

import ioc.factory.AutoWireBeanFactory;
import ioc.reader.XmlBeanReader;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static ioc.TestHelper.SERVICE_NAME;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 16/12/16.
 */
public class XmlBeanReaderTest {

    private XmlBeanReader xmlBeanReader;
    private AutoWireBeanFactory autoWireBeanFactory;

    @Before
    public void setUp() throws Exception {
        xmlBeanReader = new XmlBeanReader();
        autoWireBeanFactory = new AutoWireBeanFactory();
    }

    @Test
    public void should_read_bean_from_xml() throws Exception {
        xmlBeanReader.loadBeans(TestHelper.RESOURCES_IOC_XML);
        HashMap<String, BeanDefinition> beanHashMap = xmlBeanReader.getBeanHashMap();
        assertThat(beanHashMap.size() > 0, is(true));
        assertNotNull(beanHashMap.get(SERVICE_NAME).getBeanClass());
    }

    @Test
    public void should_inject_bean_to_bean() throws Exception {
        xmlBeanReader.loadBeans(TestHelper.RESOURCES_IOC_XML);
        autoWireBeanFactory.setBeanDefinitionHashMap(xmlBeanReader.getBeanHashMap());
        for (HashMap.Entry<String, BeanDefinition> beanEntry : xmlBeanReader.getBeanHashMap().entrySet()) {
            autoWireBeanFactory.registerBeanDefinition(beanEntry.getKey(), beanEntry.getValue());
        }
        HiService hiService = (HiService) autoWireBeanFactory.getBean(TestHelper.HI_SERVICE);
        assertThat(hiService.sayHi(), is(TestHelper.HI_SERVICE_OUTPUT));
    }
}
