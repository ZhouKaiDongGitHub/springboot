package com.luban.service;

import com.luban.dao.UserDao;

public class UserServiceImpl2 implements UserService {

    private UserDao userDao;
    public String getNameById(String id) {
        return "Service2" +userDao.query(id);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
