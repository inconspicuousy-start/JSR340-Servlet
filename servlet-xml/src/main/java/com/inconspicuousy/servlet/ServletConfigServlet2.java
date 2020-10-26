package com.inconspicuousy.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * ServletConfig 类方法演示
 *
 * @author inconspicuousy
 * @date 2020/10/27
 */
@WebServlet(value = "/servlet-config-two", initParams = @WebInitParam(name = "key", value = "value"))
public class ServletConfigServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 打印config对象，判断不同的Servlet初始化是否对应不同的ServletConfig对象
        System.out.println("config = " + config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
