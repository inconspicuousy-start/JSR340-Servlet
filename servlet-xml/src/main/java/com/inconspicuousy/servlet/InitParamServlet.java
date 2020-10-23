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
 * 获取 Servlet 配置的Servlet
 *
 * @author peng.yi
 */

// 通过urlPatterns添加Servlet虚拟路径
@WebServlet(name = "initParam", urlPatterns = {"/init-param"}, initParams = {@WebInitParam(name = "initParamKey", value = "initParamValue")})
public class InitParamServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 用于获取到ServletContext对象
        ServletContext servletContext = config.getServletContext();
        // 获取到ServletContext初始化参数
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String s =  initParameterNames.nextElement();
            System.out.println(s + " = " + servletContext.getInitParameter(s));
        }
        // 返回Servlet的初始化参数
        Enumeration<String> parameterNames = config.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            System.out.println(s + " = " + config.getInitParameter(s));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(getServletInfo());
    }
}
