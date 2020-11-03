package com.inconspicuousy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author inconspicuousy
 * @date 2020/11/3
 */
// include 后置Servlet处理
@WebServlet(value = "/include-post")
public class IncludePostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===开始处理IncludePostServlet");
        System.out.println("调用include方法之后，dispatcherType = " + req.getDispatcherType().name());
        // 包含的Servlet不能更改响应信息，响应信息会被忽略
        resp.setStatus(404);
        PrintWriter writer = resp.getWriter();
        writer.println("IncludePostServlet....");
    }
}
