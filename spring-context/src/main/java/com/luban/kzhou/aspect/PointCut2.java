package com.luban.kzhou.aspect;

public class PointCut2 {

    public String save(String name){
        System.out.println("---------后置：切入点：执行save方法-------");
        return (name = "kzhou");
    }
}
