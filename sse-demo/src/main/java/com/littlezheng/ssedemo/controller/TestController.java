package com.littlezheng.ssedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping(value = "/hello")
    public @ResponseBody String hello() {
        System.out.println("我被访问了");
        return "Hello, world!";
    }
    
}
