package com.luban.kzhou.jdkproxy;

import com.luban.kzhou.proxy.IndexService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class IndexServiceInvocationHandler implements InvocationHandler {
    IndexService indexService;
    public IndexServiceInvocationHandler(IndexService indexService){
        this.indexService = indexService;
    }

    /**
     *
     * @param proxy 代理对象
     * @param method  目标对象中的方法
     * @param args 方法的参数
     * @return 代理对象
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---------log/time---------");
        return method.invoke(indexService,args);
    }
}
