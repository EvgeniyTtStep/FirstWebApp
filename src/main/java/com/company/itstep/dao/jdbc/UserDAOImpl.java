package com.company.itstep.dao.jdbc;

import com.company.itstep.dao.UserDAO;
import com.company.itstep.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import static com.company.itstep.util.ConnectionJDBC.*;

public class UserDAOImpl implements UserDAO {

    private static final String INSERT = "insert into `user`(id_user,name, lastName, email, age) values (?,?,?,?,?)";
    private static final String UPDATE = "UPDATE `user` set  name = ?, lastName = ?, email=?, age=?";
    private static final String GET_BY_ID = "SELECT * FROM `user` WHERE id_user = ?";
    private static final String DELETE = "DELETE FROM user WHERE id_user = ?";


    public UserDAOImpl() {
        try {
            getConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found...");
        } catch (SQLException e) {
            throw new RuntimeException("Connection failed...");
        }
    }

    @Override
    public void save(User user) {
        try {
            //statement.executeUpdate("insert into `user`(name, lastName, email, age) values ( '" + user.getName() + "', '" + user.getLastName() + "', '" + user.getEmail() + "', 18)");
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, String.valueOf(user.getId()));
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setInt(5, user.getAge());
            preparedStatement.executeUpdate();//нужен для записи в БД
            closePrepared();
        } catch (SQLException throwables) {
            System.out.println("Этот SQL запрос не может быть выполнен");
        }

    }

    @Override
    public void update(User user) {
        try {
            //statement.executeUpdate("insert into `user`(name, lastName, email, age) values ( '" + user.getName() + "', '" + user.getLastName() + "', '" + user.getEmail() + "', 18)");
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.executeUpdate();//нужен для записи в БД
            closePrepared();
        } catch (SQLException throwables) {
            System.out.println("Этот SQL запрос не может быть выполнен");
        }
    }

    @Override
    public void delete(UUID uuid) {
        try {
           preparedStatement = connection.prepareStatement(DELETE);
           preparedStatement.setString(1, String.valueOf(uuid));
           preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("Delete exception");
            throwables.printStackTrace();
        }

    }

    @Override
    public User getById(UUID uuid) {
        User user = new User();
        try {
            preparedStatement = connection.prepareStatement(GET_BY_ID);
            preparedStatement.setString(1, String.valueOf(uuid));

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(UUID.fromString(resultSet.getString(1)));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setAge(resultSet.getInt(5));
            }
/*            if (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
            System.out.println(resultSet.getBoolean(5));
            }*/

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }
}
