package com.example.ss06.service;

import com.example.ss06.dao.UserDao;
import com.example.ss06.dao.UserDaoImp;
import com.example.ss06.model.User;

public class UserServiceImp implements UserService {
    private final UserDao userDao;

    public UserServiceImp() {
        userDao = new UserDaoImp();
    }

    @Override
    public boolean registerUser(String username, String password, String email, String phone) {
        return userDao.registerUser(username, password, email, phone);
    }

    @Override
    public User loginUser(String username, String password) {
        return userDao.loginUser(username, password);
    }
}
