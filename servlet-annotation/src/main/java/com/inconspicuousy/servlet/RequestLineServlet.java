package com.inconspicuousy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取请求行信息
 *
 * @author peng.yi
 */
@WebServlet(value = {"/request-line", "/request*"})
public class RequestLineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=========利用HttpServletRequest对象获取到请求行信息=======");
        // 获取请求的方法
        String method = req.getMethod();
        System.out.println("method = " + method);

        // 获取请求排除查询参数后的资源路径
        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        // 获取到查询参数
        String queryString = req.getQueryString();
        System.out.println("queryString = " + queryString);

        // 获取到上下文路径
        String contextPath = req.getContextPath();
        System.out.println("contextPath = " + contextPath);

        // 获取servlet名称或者路径
        String servletPath = req.getServletPath();
        System.out.println("servletPath = " + servletPath);

        // 获取请求的协议和版本号
        String protocol = req.getProtocol();
        System.out.println("protocol = " + protocol);

        // 获取不包含查询参数的完整的请求URL
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL = " + requestURL.toString());
    }
}
