package com.luban.springbootdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 创建一个SpringBoot的项目有三种方式：
 * 1.官网帮忙构建，并且下载下来，导入到自己的IDEA工程中
 * 2.IDEA中maven构建，选择maven项目，然后依赖一个核心包
 * 3.IDEA中现在initializer和对应的组件，会帮忙构建出springboot的应用
 */
@SpringBootApplication
public class SpringbootDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo2Application.class, args);
    }

}
