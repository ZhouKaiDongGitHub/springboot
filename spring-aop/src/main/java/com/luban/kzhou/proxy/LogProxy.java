package com.luban.kzhou.proxy;

public class LogProxy implements IndexService{
    private IndexService indexService;
    public LogProxy(IndexService indexService){
        this.indexService = indexService;
    }

    public String query(String id) {
        System.out.println("-------------log-------------");
        String name = indexService.query(id);
        return name ;
    }
}
