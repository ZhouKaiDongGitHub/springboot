package com.luban.kzhou.aspect;

public class PointCut3 {

    public String save(String name){
        System.out.println("---------环绕：切入点：执行save方法-------");
        return (name = "kzhou");
    }
}
