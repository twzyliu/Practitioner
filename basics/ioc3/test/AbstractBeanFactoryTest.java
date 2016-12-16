import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 16/12/16.
 */
public class AbstractBeanFactoryTest {

    private static final String HELLO_WORLD_SERVICE = "helloWorldService";
    private AutoWireBeanFactory autoWireBeanFactory;
    private BeanDefinition beanDefinition;

    @Before
    public void setUp() throws Exception {
        autoWireBeanFactory = new AutoWireBeanFactory();
        beanDefinition = new BeanDefinition();
    }

    @Test
    public void should_register_and_get_bean() throws Exception {
        beanDefinition.setBeanClassName("HelloWorldService");
        autoWireBeanFactory.registerBeanDefinition(HELLO_WORLD_SERVICE, beanDefinition);

        HelloWorldService bean = (HelloWorldService) autoWireBeanFactory.getBean(HELLO_WORLD_SERVICE);
        assertThat(bean.hello(), is("Hello World"));
    }
}
