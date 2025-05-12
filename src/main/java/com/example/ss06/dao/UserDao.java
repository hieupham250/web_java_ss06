package com.example.ss06.dao;

import com.example.ss06.model.User;

public interface UserDao {
    public boolean registerUser(String username, String password, String email, String phone);
    public User loginUser(String username, String password);
}
