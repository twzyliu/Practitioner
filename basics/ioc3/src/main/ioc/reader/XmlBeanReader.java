package ioc.reader;

import ioc.BeanDefinition;
import ioc.property.PropertyValue;
import ioc.property.PropertyValues;
import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by zyongliu on 16/12/16.
 */
public class XmlBeanReader extends AbstractBeanReader {

    @Override
    public void loadBeans(String filename) throws DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        Iterator beanIterator = saxReader.read(this.getClass().getResourceAsStream(filename)).getRootElement().elementIterator();
        while (beanIterator.hasNext()) {
            BeanDefinition beanDefinition = new BeanDefinition();
            HashMap<String, String> beanAttributeHashMap = new HashMap<>();
            PropertyValues propertyValues = new PropertyValues();
            Element beanElement = getAttribute(beanIterator, beanAttributeHashMap);
            Iterator propertyIterator = beanElement.elementIterator();
            while (propertyIterator.hasNext()) {
                HashMap<String, String> propertyAttributeHashMap = new HashMap<>();
                getAttribute(propertyIterator, propertyAttributeHashMap);
                Object value = propertyAttributeHashMap.getOrDefault("value", null);
                String ref = propertyAttributeHashMap.getOrDefault("ref", null);
                if (value == null && ref != null) {
                    BeanDefinition beanProperty = new BeanDefinition();
                    beanProperty.setBeanClassName(ref);
                    value = beanProperty;
                }
                PropertyValue propertyValue = new PropertyValue(propertyAttributeHashMap.getOrDefault("name", null), value);
                propertyValues.add(propertyValue);
            }
            beanDefinition.setPropertyValues(propertyValues);
            beanDefinition.setBeanClassAndName(beanAttributeHashMap.getOrDefault("class", null));
            getBeanHashMap().put(beanAttributeHashMap.getOrDefault("name", null), beanDefinition);
        }
    }

    private Element getAttribute(Iterator beanIterator, HashMap<String, String> beanAttributeHashMap) {
        Element beanElement = (Element) beanIterator.next();
        Iterator beanAttributeIterator = beanElement.attributeIterator();
        while (beanAttributeIterator.hasNext()) {
            Attribute beanAttribute = (Attribute) beanAttributeIterator.next();
            beanAttributeHashMap.put(beanAttribute.getName(), beanAttribute.getValue());
        }
        return beanElement;
    }
}
