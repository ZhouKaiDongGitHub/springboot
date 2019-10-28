package com.luban.kzhou;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class IndexService {

    /*public IndexService(IndexDao indexDao){
        this.indexDao = indexDao;
    }*/


    @Autowired
    private IndexDao indexDao;

    public IndexService(){
        //System.out.println("-----------constructor-------");
    }
    public void query(){
      indexDao.query();
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        //System.out.println("-----------init-------");
    }

    @PreDestroy
    public void destroy() throws Exception {
        //System.out.println("-----------destory-------");
    }

 /*   public void setIndexDao(IndexDao indexDao) {
        this.indexDao = indexDao;
    }*/
}
