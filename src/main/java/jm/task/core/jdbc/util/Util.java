package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД
    public static Connection connection = null;
    public static Statement statement = null;
    private static final String URL = "jdbc:mysql://localhost:3306/testbase";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public static void connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded successfully");

        connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);

        if (!connection.isClosed()) {
            System.out.println("Connected to DB");
        }

        if (connection.isClosed()) {
            System.out.println("Connection closed");
        }

        statement = connection.createStatement();
    }

    public static void disconnect() throws SQLException {
        statement.close();
        connection.close();
    }

}