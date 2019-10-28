package com.luban.kzhou.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class IndexDao {

    public void query(){
        System.out.println("query");
    }

   /* public void queryList(){
        System.out.println("queryList");
    }*/
}
