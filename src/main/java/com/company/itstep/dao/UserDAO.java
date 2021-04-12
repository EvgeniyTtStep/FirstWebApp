package com.company.itstep.dao;

import com.company.itstep.dao.GenericDAO;
import com.company.itstep.model.User;

import java.util.UUID;

public interface UserDAO extends GenericDAO<User, UUID> {
}
