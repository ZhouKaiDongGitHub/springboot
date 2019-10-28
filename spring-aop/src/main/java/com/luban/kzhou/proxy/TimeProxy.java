package com.luban.kzhou.proxy;

public class TimeProxy implements IndexService{
    private IndexService indexService;
    public TimeProxy(IndexService indexService){
        this.indexService = indexService;
    }

    public String query(String id) {
        System.out.println("-------------time-------------");
        String name = indexService.query(id);
        return name ;
    }
}
