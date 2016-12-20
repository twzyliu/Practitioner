package main.orm;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by zyongliu on 20/12/16.
 */
public class Connector {
    private Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persistance", "root", "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
