package com.inconspicuousy.servlet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author peng.yi
 */
@WebServlet(value = "/filter")
public class FilterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FilterServlet 接收到请求");
        DispatcherType dispatcherType = req.getDispatcherType();
        System.out.println("抛出异常前 dispatcherType.name() = " + dispatcherType.name());
        System.out.println("FilterServlet 抛出异常");
        throw new ServletException("==== FilterServlet的异常");
    }
}
