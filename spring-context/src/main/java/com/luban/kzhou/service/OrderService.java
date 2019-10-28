package com.luban.kzhou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private PowerService powerService;

    public OrderService(){
        //System.out.println("---------------OrderService Constructor---------------");
    }
}
