package com.luban.tomcat.impl;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class MySpringApplication {

    public static void run(Class c,String[] args){

        Tomcat tomcat = new Tomcat();

        tomcat.setPort(9080);

        String sourcePath = MySpringApplication.class.getResource("/").getPath();

        //告訴tomcat你的资源文件在哪裏
        Context ctx = tomcat.addWebapp("/",new File("src/main/webapp").getAbsolutePath());
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                sourcePath, "/"));
        ctx.setResources(resources);
        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }
}
