package com.luban.kzhou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PowerService {

    @Autowired
    private UserService userService;

    public PowerService(){
        //System.out.println("-----------------powerService Constructor---------------");
    }
}
