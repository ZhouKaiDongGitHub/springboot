package com.luban.servlet.container.initialzer;

import com.luban.servlet.container.initialzer.typehandle.MyWebApplicationInitializer;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@HandlesTypes({MyWebApplicationInitializer.class})

public class MyServletContainerIntialzer2 implements ServletContainerInitializer {

    public void onStartup(Set<Class<?>> mywebAppInitializerClasses, ServletContext servletContext) throws ServletException {


        System.out.println("一个类只有实现了这个接口，并且在META-INF下进行了指明注册才会被tomcat" +
                "启动的时候执行， servletConatinerInitializer");

        List<MyWebApplicationInitializer> initializers = new LinkedList();
        for (Class init:mywebAppInitializerClasses){
            try {
                initializers.add((MyWebApplicationInitializer)init.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        for (MyWebApplicationInitializer myWebApplicationInitializer:initializers){
            myWebApplicationInitializer.onStartup(servletContext);
        }
    }
}
