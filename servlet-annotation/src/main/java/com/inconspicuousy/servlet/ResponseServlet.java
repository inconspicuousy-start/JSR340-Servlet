package com.inconspicuousy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author peng.yi
 */
@WebServlet(value = "/response")
public class ResponseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=====Servlet1开始处理POST请求====");
        // 不以"/"开头会被解析成相对当前路径的相对路径， 将请求重定向到/response2处理
        // 如果是重定向到Servlet用相对路径比较好，如果是重定向到页面，用绝对路径比较好
        resp.sendRedirect("response2");
    }
}
