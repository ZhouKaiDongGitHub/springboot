package com.luban.tomcat;

import com.luban.tomcat.impl.MySpringApplication;
import com.luban.tomcat.impl.MySpringBootApplication;

@MySpringBootApplication
public class SpringMVCApplication {

    public static void main(String[] args) {
        MySpringApplication.run(SpringMVCApplication.class,args);
    }
}
