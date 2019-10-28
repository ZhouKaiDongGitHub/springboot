package com.luban.kzhou;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("indexDao")
public class IndexDaoImpl1 implements IndexDao {
    public void query() {
        //System.out.println("IndexDaoImpl1"+this.hashCode());
    }
}
