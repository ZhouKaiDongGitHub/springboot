package com.luban.dao;

public class UserDaoImpl2 implements UserDao {
    public String query(String id) {
        return "userDao2"+id;
    }
}
