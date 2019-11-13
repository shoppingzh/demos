/**
 * 
 */
package com.xpzheng.corsapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Admin
 *
 */
@Controller
@RequestMapping(path = "app")
public class AppController {

    @GetMapping(path = "view")
    public void view(HttpServletResponse resp) throws IOException {
        System.out.println("============== 应用层 view ===================");
        resp.sendRedirect("http://192.168.1.105:8081/api/file/1");
    }

}
