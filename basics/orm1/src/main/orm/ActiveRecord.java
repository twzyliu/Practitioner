package main.orm;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zyongliu on 20/12/16.
 */
public class ActiveRecord {
    private Statement statement;
    private String id;
    private Class<? extends ActiveRecord> aClass;
    private String table;
    private Field[] fields;


    private void init() throws SQLException {
        Connector connector = new Connector();
        aClass = this.getClass();
        AREntity annotation = aClass.getAnnotation(AREntity.class);
        fields = aClass.getFields();
        table = annotation.tableName();
        Arrays.stream(fields).filter((f) -> f.isAnnotationPresent(Id.class)).map((f) -> id = getColumnName(f));
        statement = connector.getConnection().createStatement();
    }

    private String getColumnName(Field f) {
        String column = f.getAnnotation(Column.class).column();
        return column.isEmpty() ? f.getName() : column;
    }

    private <T extends ActiveRecord> List<T> getAll() throws SQLException, IllegalAccessException, InstantiationException {
        init();
        List<T> out = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select * from " + table);
            while (resultSet.next()) {
                out.add((T) getObject(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }

    private Object getObject(ResultSet resultSet) throws InstantiationException, IllegalAccessException, SQLException {
        Object object = aClass.newInstance();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                String column = field.getAnnotation(Column.class).column();
                field.setAccessible(true);
                String columnLabel = column.isEmpty() ? field.getName() : column;
                if (field.getType() == byte.class) {
                    byte aByte = resultSet.getByte(columnLabel);
                    field.set(object, aByte);
                } else if (field.getType() == short.class) {
                    short aShort = resultSet.getShort(columnLabel);
                    field.set(object, aShort);
                } else {
                    field.set(object, resultSet.getObject(columnLabel, field.getType()));
                }
            }
        }
        return object;
    }

    private <T extends ActiveRecord> T getById() throws SQLException, IllegalAccessException, InstantiationException {
        init();
        try {
            ResultSet resultSet = statement.executeQuery("select * from " + table + " where id=" + id);
            return (T) getObject(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}






















