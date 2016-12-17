package ioc;

import ioc.reader.XmlBeanReader;
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

    @Test
    public void should_read_bean_from_xml() throws Exception {
        XmlBeanReader xmlBeanReader = new XmlBeanReader();
        xmlBeanReader.loadBeans(TestHelper.RESOURCES_IOC_XML);
        HashMap<String, BeanDefinition> beanHashMap = xmlBeanReader.getBeanHashMap();
        assertThat(beanHashMap.size() > 0, is(true));
        assertNotNull(beanHashMap.get(SERVICE_NAME).getBeanClass());
    }
}
