package com.company.itstep.service;

import com.company.itstep.dao.jdbc.UserDAOImpl;
import com.company.itstep.model.User;

public class UserService {
    UserDAOImpl userDAO;

    public void save(User user){
        userDAO.save(user);
    }
}
