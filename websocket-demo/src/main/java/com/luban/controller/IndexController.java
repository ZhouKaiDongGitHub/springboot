package com.luban.controller;


import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/update")
    @ResponseBody
    public Map<String,String> update(@RequestParam("value") String value){
        Map<String,String> map = new HashMap<String,String>();
        map.put("v",value);
        return map;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/echarts")
    public String ws(Message message){
        System.out.println("-----------------");
        byte bytes[] = (byte[]) message.getPayload();
        String s = new String(bytes);
        System.out.println(s);
        return "90";
    }
}
