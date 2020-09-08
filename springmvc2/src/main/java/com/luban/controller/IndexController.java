package com.luban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class IndexController {


    @RequestMapping("/upload")
    public void upload(@RequestPart("luban") MultipartFile multipartResolver){
        System.out.println("aaa");
    }
}
