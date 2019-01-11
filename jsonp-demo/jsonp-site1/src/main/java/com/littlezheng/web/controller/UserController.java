package com.littlezheng.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.google.gson.Gson;
import com.littlezheng.bo.User;

@Controller
@RequestMapping(path="/user")
public class UserController {

    /*@RequestMapping(path="/profile/{key}")
    public @ResponseBody User userProfile(@PathVariable("key") String key){
        System.out.println("获取信息");
        User user = null;
        if("1".equals(key)){
            user = new User("老王", 23);
            user.setDescription("喜欢新事物");
        }
        return user;
    }*/
    
    @RequestMapping(path="/profile/{key}")
    public void userProfile(@PathVariable("key") String key,
        String callback, 
        HttpServletResponse resp) throws IOException{
        System.out.println("获取信息");
        User user = null;
        if("1".equals(key)){
            user = new User("老王", 23);
            user.setDescription("喜欢新事物");
        }

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().append(callback + "(" + parse(user) + ")");
    }
    
    public static String parse(Object o){
        return new Gson().toJson(o);
    }
    
}
