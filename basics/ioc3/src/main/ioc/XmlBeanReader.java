package ioc;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by zyongliu on 16/12/16.
 */
public class XmlBeanReader extends AbstractBeanReader {

    @Override
    public void loadBeans(String filename) throws DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        InputStream inputStream = this.getClass().getResourceAsStream(filename);
        Document document = saxReader.read(inputStream);
        Element rootElement = document.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        while (iterator.hasNext()) {
            BeanDefinition beanDefinition = new BeanDefinition();
            HashMap<String, String> attributeHashMap = new HashMap<>();
            Element nextElement = (Element) iterator.next();
            Iterator attributeIterator = nextElement.attributeIterator();
            while (attributeIterator.hasNext()) {
                Attribute nextAttribute = (Attribute) attributeIterator.next();
                attributeHashMap.put(nextAttribute.getName(), nextAttribute.getValue());
            }
            beanDefinition.setBeanClassName(attributeHashMap.getOrDefault("class", null));
            getBeanHashMap().put(attributeHashMap.getOrDefault("name", null), beanDefinition);
        }
    }
}
