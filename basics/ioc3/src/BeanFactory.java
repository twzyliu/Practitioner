import java.util.HashMap;

/**
 * Created by zyongliu on 16/12/16.
 */
public class BeanFactory {
    private HashMap<String, BeanDefinition> beanDefinitionHashMap = new HashMap<>();

    public Object getBean(String name) {
        return beanDefinitionHashMap.getOrDefault(name, null).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionHashMap.put(name, beanDefinition);
    }

}
