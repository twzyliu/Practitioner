package main.orm;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zyongliu on 20/12/16.
 */
public class ActiveRecord {
    private HashMap<String, Object> cache = new HashMap<>();

    private void init() {
        HashMap<String, Object> set = new HashMap<>();
        Class<? extends ActiveRecord> aClass = this.getClass();

        if (cache.containsKey(aClass.getName())) {
            return;
        }
        AREntity annotation = aClass.getAnnotation(AREntity.class);
        Field[] fields = aClass.getFields();
        Arrays.stream(fields).filter((f) -> f.isAnnotationPresent(Id.class)).map((f) -> set.put("id", getColumnName(f)));
        set.put("class", aClass);
        set.put("table", annotation.tableName());
        set.put("fields", fields);
        cache.put(aClass.getName(), set);
    }

    private String getColumnName(Field f) {
        String column = f.getAnnotation(Column.class).column();
        return column.isEmpty() ? f.getName() : column;
    }

    private <T extends ActiveRecord> List<T> getAll() {
        init();
        return null;
    }

}
