package com.company.jdbc_example;

import com.company.itstep.model.User;

import java.sql.*;
import java.time.LocalTime;

import static com.company.itstep.util.ConnectionJDBC.statement;

public class Application {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");//пределяет драйвер СУБД
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pa812?useUnicode=true&amp;characterEncoding=UTF-8", "root", "root");
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);//statement позволяет работать с БД
        //statement.executeUpdate("insert into `user`(name, lastName, email, age) values ('testJava', 'test', 'email', 12)");
        //statement.executeUpdate("insert into `user`(name, lastName, email, age) values ('Даша', 'Машина', 'email@e', 17)");
        //statement.executeUpdate("DELETE FROM user where id_user=4");
        //statement.executeUpdate("update user set `name`='javaName' where id=1");
        //statement.execute("use newschema");

        System.out.println(LocalTime.now());
        ResultSet resultSet = statement.executeQuery("SELECT * from user");

//        ResultSetMetaData metaData = resultSet.getMetaData();
//        for (int i = 1; i < metaData.getColumnCount() + 1; i++) {
//            System.out.println("ColumnName = " + metaData.getColumnName(i) + " ");
//            System.out.println("ColumnType = " + metaData.getColumnType(i) + " ");
//            System.out.println("ColumnLabel = " + metaData.getColumnLabel(i) + " ");
//            System.out.println();
//        }
//
//        while (resultSet.next()) {
//            System.out.print(resultSet.getInt(1) + " ");
//            System.out.print(resultSet.getString("name") + " ");
//            System.out.print(resultSet.getString(2) + " ");
//            System.out.print(resultSet.getString("email") + " ");
//            System.out.print(resultSet.getString("age"));
//            System.out.println();
//        }
//        System.out.println(LocalTime.now());
//
//
//        User user = new User("user4", "lastUser4", "user@email4", 44);
//
//        //save(statement, user);
//
//        //update(statement, user, 2);
        resultSet.next();
        resultSet.next();
        System.out.println(resultSet.getString("name"));
        resultSet.first();
        System.out.println(resultSet.getString("name"));

        System.out.println("Ok");


        PreparedStatement preparedStatement = connection.prepareStatement("insert into `user`(name, lastName, email, age) values (?,?,?,?)");


    }

    private static void update(Statement statement, User user, int id) throws SQLException {
        statement.executeUpdate("update `user` set name = '" + user.getName() + "', lastName = '" + user.getLastName() + "', email = '" + user.getEmail() + "', age = "+user.getAge()+" where id_user = " + id + "");
    }

    private static void save(Statement statement, User user) throws SQLException {
        statement.executeUpdate("insert into `user`(name, lastName, email, age) values ( '" + user.getName() + "', '" + user.getLastName() + "', '" + user.getEmail() + "', 18)");
    }
}
