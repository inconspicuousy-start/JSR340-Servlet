package com.inconspicuousy.servlet;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * RequestDispatchet include方法
 * @author inconspicuousy
 * @date 2020/11/3
 */
    @WebServlet(value = "/include")
public class IncludeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("=====处理请求包含指定资源的内容====");
        // 获取到请求转发的类型
        DispatcherType dispatcherType = req.getDispatcherType();
        System.out.println("调用include方法之前，dispatcherType = " + dispatcherType.name());

        // 我们这里将 include-post 路径对应的Servlet处理的响应信息包含在当前响应中
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/include-post");
        requestDispatcher.include(req, resp);

        PrintWriter writer = resp.getWriter();
        writer.println("include...");

    }
}
