package com.luban.servlet.container.initialzer.typehandle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public interface MyWebApplicationInitializer {

    void onStartup(ServletContext context) throws ServletException;
}
