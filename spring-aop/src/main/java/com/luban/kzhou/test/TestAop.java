package com.luban.kzhou.test;

import com.luban.kzhou.config.AppConfig;
import com.luban.kzhou.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAop {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        IndexDao indexDao = context.getBean(IndexDao.class);
        //System.out.println(indexDao.hashCode());
        indexDao.query();

        IndexDao indexDao1 = context.getBean(IndexDao.class);
        //System.out.println(indexDao1.hashCode());
        indexDao1.query();
        //indexDao.queryList();
    }
}
