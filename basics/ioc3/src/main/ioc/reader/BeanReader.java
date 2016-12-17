package ioc.reader;

import org.dom4j.DocumentException;

import java.io.IOException;

/**
 * Created by zyongliu on 16/12/16.
 */
public interface BeanReader {
    void loadBeans(String filename) throws DocumentException, IOException;
}
