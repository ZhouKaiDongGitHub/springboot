package com.luban.kzhou.proxy;

public class Test {

    public static void main(String[] args) {
        /*IndexService service = new IndexServiceImpl();
        IndexService logProxy = new LogProxy(service);
        IndexService timeProxy = new TimeProxy(logProxy);
        timeProxy.query("1");*/
        IndexService indexService = new IndexServiceImpl();
        MyInvocationHandler invocationHandler = new IndexServiceMyInvocationHandler();
        IndexService proxy = (IndexService) ProxyUtil.newInstance(indexService,invocationHandler);
        String name = proxy.query("1");
    }
}
