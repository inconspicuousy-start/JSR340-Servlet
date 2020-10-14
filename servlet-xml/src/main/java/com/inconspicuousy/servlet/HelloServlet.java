package com.inconspicuousy.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * @author peng.yi
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // HttpServlet 提供的直接获取到ServletContext的方法(本质上还是通过ServletConfig获取到的)
        ServletContext servletContext = this.getServletContext();
        // 获取到所有的初始化参数的名称
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String next = initParameterNames.nextElement();
            // 根据参数名称获取到属性值
            String initParameter = servletContext.getInitParameter(next);
            System.out.println(next + " = " + initParameter);
        }
        resp.getWriter().println("<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>");


        // 这边可以通过ServletConfig对象获取到初始化参数
        ServletConfig servletConfig = this.getServletConfig();
        Enumeration<String> initParameterNames1 = servletConfig.getInitParameterNames();
        while (initParameterNames1.hasMoreElements()) {
            String s = initParameterNames1.nextElement();
            String initParameter = servletConfig.getInitParameter(s);
            System.out.println("initParameter = " + initParameter);
        }
    }
}
