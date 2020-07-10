package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    public static Connection connection = null;
    public static Statement statement = null;
    public static PreparedStatement preparedStatement = null;
    private static final String URL = "jdbc:mysql://localhost:3306/testbase";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public static void connect() throws SQLException {

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