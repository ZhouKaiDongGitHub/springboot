package com.luban.servlet.container.initialzer.typehandle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


public class MyWebApplicationInitializerImpl implements MyWebApplicationInitializer {
    public void onStartup(ServletContext context) throws ServletException {
        System.out.println("---------------------------");
        System.out.println("springMVC中会解析出所有实现了TypeHandle的接口的实现类，并且调用其中的方法进行逐个解析");
    }
}
