package com.littlezheng.ssedemo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="sseServlet", urlPatterns = "/sse")
public class SseServlet extends HttpServlet {

    private static final long serialVersionUID = -7214263541401591563L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/event-stream");
        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);//注意这里
        System.out.println(Thread.currentThread().getName());
        AsyncContext ac = req.startAsync(req, resp);
        ac.setTimeout(6000);
        ac.addListener(new AsyncListener() {
            
            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                System.out.println("onTimeout");
            }
            
            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
                System.out.println("onStartAsync");
            }
            
            @Override
            public void onError(AsyncEvent event) throws IOException {
                System.out.println("onError");
            }
            
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                System.out.println("onComplete");
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                PrintWriter wt;
                try {
                    Thread.sleep(500);
                    wt = ac.getResponse().getWriter();
                    wt.println("data:" + new Date() + "\r\n");
                    wt.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
