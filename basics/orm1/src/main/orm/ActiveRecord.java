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

    private <T extends ActiveRecord> T getById(int id) throws SQLException, IllegalAccessException, InstantiationException {
        init();
        try {
            ResultSet resultSet = statement.executeQuery("select * from " + table + " where " + this.id + "=" + id);
            return (T) getObject(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert() throws SQLException, IllegalAccessException {
        init();
        try {

            String sql = "insert into " + table + " values(";
            int idCount = 0;
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                String tmp = "";
                if (field.isAnnotationPresent(Column.class)) {
                    if (!field.isAnnotationPresent(Id.class)) {
                        boolean isString = field.getType() == String.class;
                        if (isString) {
                            tmp += "'";
                        }
                        try {
                            tmp += field.get(this).toString();
                            sql += tmp;
                        } catch (Exception e) {
                            sql += "null,";
                            continue;
                        }
                        if (isString) {
                            sql += "'";
                        }
                    } else {
                        idCount = i;
                        sql += "null";
                    }
                    sql += ",";
                }
            }
            statement.executeUpdate(new StringBuilder(sql).deleteCharAt(sql.length() - 1).append(")").toString(), Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            keys.next();
            fields[idCount].set(this, keys.getInt(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private boolean delById(int id) throws SQLException {
        init();
        try {
            String sql = "delete from " + table + " where " + this.id + "=" + id;
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean update() throws SQLException, IllegalAccessException {
        init();
        try {
            String sql = "update " + table + " set ";
            int idCount = 0;
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                String tmp = "";
                if (field.isAnnotationPresent(Column.class)) {
                    if (!field.isAnnotationPresent(Id.class)) {
                        sql += getColumnName(field) + "=";
                        boolean isString = field.getType() == String.class;
                        if (isString) {
                            tmp += "";
                        }
                        try {
                            tmp += field.get(this).toString();
                            sql += tmp;
                        } catch (Exception e) {
                            sql += "null";
                            if (i < fields.length - 1) {
                                sql += ", ";
                            }
                            continue;
                        }
                        if (isString) {
                            sql += "'";
                        }
                        sql += ",";
                    } else {
                        if ((int) field.get(this) == 0) {
                            idCount = i;
                            throw new RuntimeException("Object instance has no id set, or is set to 0");
                        }
                    }
                }
            }
            statement.executeUpdate(String.valueOf(new StringBuilder(sql).deleteCharAt(sql.length() - 1).append(" where " + this.id + "=" + fields[idCount].get(this))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete() throws SQLException, IllegalAccessException {
        init();
        try {
            String sql = "delete from " + table + " where " + this.id + "=";
            for (Field field : fields) {
                if (field.isAnnotationPresent(Id.class) && field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    sql += field.get(this);
                }
            }
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}






















