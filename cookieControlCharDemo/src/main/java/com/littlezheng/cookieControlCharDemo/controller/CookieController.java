package com.littlezheng.cookieControlCharDemo.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CookieController {

    @RequestMapping(path = "cookie")
    public @ResponseBody String setCooke(HttpServletRequest req, HttpServletResponse resp) {
//        Cookie cookie = new Cookie("control", new String(new byte[]{0x01}));
        Cookie cookie = new Cookie("ch", "再来个不一样的，试试刚好将中文解码为了一个控制字符");
        resp.addCookie(cookie);
        
        StringBuilder sb = new StringBuilder();
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie c : cookies){
                sb.append(c.getName()).append("=").append(c.getValue()).append("<hr>");
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "再来个不一样的，试试刚好将中文解码为了一个控制字符";
        byte[] bytes = s.getBytes("ISO-8859-1");
        for(byte b : bytes){
            System.out.println(b);
        }
    }

}
