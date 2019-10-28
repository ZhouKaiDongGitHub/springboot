package com.luban.kzhou.dao;

import com.luban.kzhou.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;


public class IndexDao {

    private JdbcTemplate jdbcTemplate;


    public void insert(User user){
        String sql = "INSERT INTO USER(NAME,PASSWORD) VALUS (?,?)";
        jdbcTemplate.update(sql,new Object[]{user.getName(),user.getPassword()});
    }

    public void update(User user){
        String sql = "UPDATE USER SET PASSWORD WHERE NAME=?";
        jdbcTemplate.update(sql,new Object[]{user.getName()});
    }

    public User query(String name){
        String sql="SELECT * FROM USER WHERE NAME=?";
        return jdbcTemplate.query(sql, new Object[]{name}, new ResultSetExtractor<User>() {
            public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    User user = new User();
                    user.setName(resultSet.getString("name"));
                    user.setPassword(resultSet.getString("password"));
                    return user;
                }
                return null;
            }
        });
    };

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
