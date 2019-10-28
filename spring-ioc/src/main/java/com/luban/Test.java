package com.luban;

import com.luban.service.UserService;
import com.luban.util.BeanFactory;

public class Test {

    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory("application.xml");
        UserService userService = (UserService) beanFactory.getBean("service1");
        System.out.println(userService.getNameById("----test"));
    }
}
