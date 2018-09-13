package com.littlezheng.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping(path="/")
    public ModelAndView index(){
        System.out.println("hello");
        return new ModelAndView("index");
    }
    
}
