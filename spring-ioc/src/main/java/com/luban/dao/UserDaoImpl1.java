package com.luban.dao;

public class UserDaoImpl1 implements UserDao {
    public String query(String id) {

        return "UserDao1"+id;
    }
}
