package com.inconspicuousy.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 利用Servlet对象获取到RequestDispatcher对象
 * @author peng.yi
 */
@WebServlet(value = "/servlet-dispatcher")
public class ServletDispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // dispatcher 会被解析成 /dispatcher, 因为当前Servlet的路径就是 /servlet-dispatcher, 相对路径的话就是 dispatcher
        // /dispatcher对应的Servlet就是DispatcherServlet
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("dispatcher");
        if (requestDispatcher != null) {
            // 当前请求就会被转发到 DispatcherServlet
            requestDispatcher.forward(req, resp);
        }
    }
}
