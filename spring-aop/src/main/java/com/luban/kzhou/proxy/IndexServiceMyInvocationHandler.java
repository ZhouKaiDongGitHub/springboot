package com.luban.kzhou.proxy;

public class IndexServiceMyInvocationHandler implements MyInvocationHandler {
    @Override
    public void process() {
        System.out.println("------------time-----------");
    }
}
