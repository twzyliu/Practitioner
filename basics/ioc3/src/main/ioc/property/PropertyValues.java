package ioc.property;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyongliu on 16/12/16.
 */
public class PropertyValues {
    private List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues() {
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }

    public void add(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }
}
