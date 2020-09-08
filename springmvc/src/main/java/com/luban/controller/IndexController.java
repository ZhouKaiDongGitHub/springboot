package com.luban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/upload")
    public void upload(@RequestPart("luban") MultipartFile multipartFile){
        System.out.println("aaa");
    }
}
