package com.luban.kzhou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private OrderService orderService;

    private UserService(){
        //System.out.println("---------------UserService Constructor ------------");
    }
}
