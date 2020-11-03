package com.inconspicuousy.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发
 *
 * @author peng.yi
 */
@WebServlet(value = "/dispatcher")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取到 ServletContext上下文对象
        ServletContext servletContext = getServletContext();
        // 通过RequestDisPatcher对象对dispatcher.html进行包装
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/dispatcher.html");
        // 利用forward方法实现请求的转发到指定的路径，此时请求会被转发到dispatcher.html上
        requestDispatcher.forward(req, resp);
    }
}
