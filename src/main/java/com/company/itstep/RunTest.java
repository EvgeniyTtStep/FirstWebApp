package com.company.itstep;

import com.company.itstep.dao.UserDAO;
import com.company.itstep.dao.jdbc.UserDAOImpl;
import com.company.itstep.model.User;

import java.util.UUID;

public class RunTest {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        User userTest = new User(uuid,"TestJava", "TestJava","TestJava", 21, true );

        UserDAO userDAO  = new UserDAOImpl();
        //userDAO.save(userTest);
        //UUID id = userTest.getId();
        //System.out.println("id = " + id);
        UUID uuid1 = UUID.fromString("ef6ad970-0c45-476c-bf1e-1fdae3fa0eb7");
        System.out.println("User = " + userDAO.getById(uuid1));

        userDAO.delete(uuid1);
        System.out.println("Ok");
    }
}
