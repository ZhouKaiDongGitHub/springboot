package com.luban.servlet.container.initialzer;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

//@HandlesTypes({WebApplicationInitializer.class})

public class MyServletContainerIntialzer implements ServletContainerInitializer {

    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("一个类仅仅实现了这个接口 servletConatinerInitializer是不会被tomcat执行的");
    }
}
