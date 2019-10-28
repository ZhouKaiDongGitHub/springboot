package com.luban.kzhou.aspect;

import org.springframework.stereotype.Component;

public class PointCut {

    public void save(String name){
        System.out.println("---------前置：切入点：执行save方法-------");
    }
}
