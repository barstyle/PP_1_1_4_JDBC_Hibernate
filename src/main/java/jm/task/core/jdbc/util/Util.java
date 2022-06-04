package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соединения с БД
    private static final String PASSWORD = "qwerty007";
    private static final String USER_NAME = "BD_Admin";
    private static final String URL = "jdbc:mysql://localhost:3306/kata_first";

    public static Connection getMySQLConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }
}
