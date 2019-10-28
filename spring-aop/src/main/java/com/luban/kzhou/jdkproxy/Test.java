package com.luban.kzhou.jdkproxy;
import com.luban.kzhou.proxy.IndexService;
import com.luban.kzhou.proxy.IndexServiceImpl;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        /**
         * JDK的动态代理：需要三个条件
         * 1.类加载器
         * 2.需要代理的接口类数组
         * 3.代理方法逻辑，实现增强
         */
        IndexService proxy = (IndexService) Proxy.newProxyInstance(Test.class.getClassLoader(),
                new Class[] {IndexService.class},
                new IndexServiceInvocationHandler(new IndexServiceImpl()));
        System.out.println(proxy.query("1"));
    }
}
