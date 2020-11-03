package com.inconspicuousy.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * @author peng.yi
 */
@WebServlet(value = "/named-dispatcher")
public class NamedDispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取到SevletContext上下文对象
        ServletContext servletContext = getServletContext();
        // 获取到Servlet名称(默认Servlet的名称为全类名)
        String servletName = "com.inconspicuousy.servlet.DispatcherServlet";
        // 根据名称获取到Servlet包装的RequestDispatcher对象
        RequestDispatcher namedDispatcher = servletContext.getNamedDispatcher(servletName);
        // 我们将请求转发到DispatcherServlet
        namedDispatcher.forward(req, resp);
    }
}
