package com.luban.initail;

import com.luban.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Tomcat启动的时候会调用所有实现了 ServletContainerInitializer的接口类中方法，并且传入tomcat的context
 * 而SpringMVC中就有这样的一个实现类，并且springmvc扩展了
 */
public class MyWebApplicationInitailzer implements WebApplicationInitializer {

    /**
     * 1. servletContext是tomcat容器持有的上下文对象。需要一个dispatcherServlet,下面会注册给他
     *
     * 2. dispatcherServlet就是springMVC的核心过滤器，dispatcherServlet持有applicationContext的对象
     *      否则这个dispatcherServlet不知道将请求转发到哪一个application的controller层
     *
     * 3. applicationContext是springIOC容器的核心，需要被第一个初始化
     *
     */
    public void onStartup(ServletContext servletContext) throws ServletException {


        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(AppConfig.class);
        ac.refresh();

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app/*");
    }

}
