/**
 * 
 */
package com.xpzheng.corsapi.api.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Admin
 *
 */
@Controller
@RequestMapping(path = "/api/file")
public class FileController {
    
    
    @GetMapping(path="{id}")
    public void index(HttpServletResponse resp, @PathVariable("id") String id) throws IOException {
        System.out.println("==================== SDK层 =====================");
        System.out.println("获取的文件id：" + id);
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS");
        resp.addHeader("Access-Control-Allow-Headers", "X-Requested-With,X-PINGOTHER,Content-Type");
        resp.sendRedirect("http://192.168.1.105/1.pdf");
    }

}
