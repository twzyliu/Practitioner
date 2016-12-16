/**
 * Created by zyongliu on 16/12/16.
 */
public class AutoWireBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(BeanDefinition beanDefinition) {
        try {
            return beanDefinition.getBeanClass().newInstance();
        } catch (Exception e) {
            System.err.print(e);
        }
        return null;
    }

}
