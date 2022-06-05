package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соединения с БД

    private static Connection connection = null;

    private static final String PASSWORD = "qwerty007";
    private static final String USER_NAME = "BD_Admin";
    private static final String URL = "jdbc:mysql://localhost:3306/kata_first";

    public static Connection getMySQLConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                try {
                    connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
