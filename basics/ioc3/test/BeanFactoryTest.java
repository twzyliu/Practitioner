import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 16/12/16.
 */
public class BeanFactoryTest {

    private static final String HELLO_WORLD_SERVICE = "helloWorldService";
    private BeanFactory beanFactory;

    @Before
    public void setUp() throws Exception {
        beanFactory = new BeanFactory();
    }

    @Test
    public void should_register_and_get_bean() throws Exception {
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
        beanFactory.registerBeanDefinition(HELLO_WORLD_SERVICE, beanDefinition);

        HelloWorldService bean = (HelloWorldService) beanFactory.getBean(HELLO_WORLD_SERVICE);
        assertThat(bean.hello(), is("Hello World"));
    }
}
