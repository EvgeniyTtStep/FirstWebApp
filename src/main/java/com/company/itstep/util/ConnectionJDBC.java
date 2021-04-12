package com.company.itstep.util;

import java.sql.*;

public class ConnectionJDBC {
    public static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/pa812?useUnicode=true&amp;characterEncoding=UTF-8";

    public static Connection connection = null;
    public static Statement statement = null;
    public static PreparedStatement preparedStatement = null;

    public static void getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER_MYSQL);
        connection = DriverManager.getConnection(URL, "root", "root");
        statement = connection.createStatement();
    }

    public static void closePrepared() {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException("prepared statement is not closed");
            }
        }
    }


}
