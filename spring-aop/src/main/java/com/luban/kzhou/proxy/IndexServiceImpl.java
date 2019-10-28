package com.luban.kzhou.proxy;

public class IndexServiceImpl implements IndexService {

    public String query(String id) {
        String name = "kzhou";
        System.out.println("--------target--------");
        return name;
    }

}
