package com.inconspicuousy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author peng.yi
 */
public class LifecycleServlet extends HttpServlet {

    public LifecycleServlet() {
        System.out.println("我是Servlet构造器");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print("每次请求的Servlet对象 => ");
        System.out.println(this);
        System.out.println("执行Service方法转发的doGet方法");
    }

    @Override
    public void destroy() {
        System.out.println("我是Servlet销毁的方法");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("我是Servlet的初始化方法");
    }
}
