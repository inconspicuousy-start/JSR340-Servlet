package com.inconspicuousy.servlet;

import javax.jws.WebService;
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
@WebServlet(value = "/servlet-config-one", initParams = @WebInitParam(name = "key", value = "value"))
public class ServletConfigServlet1 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 打印config对象，判断不同的Servlet初始化是否对应不同的ServletConfig对象
        System.out.println("config = " + config);
        // getServletName获取到Servlet名称， 在未指定Servlet名称时，默认是类名
        String servletName = config.getServletName();
        System.out.println("servletName = " + servletName);
        // getServletContext 获取到ServletContext
        ServletContext servletContext = config.getServletContext();
        System.out.println("servletContext = " + servletContext);

        // 获取到初始化参数名称列表
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String element = initParameterNames.nextElement();
            // getInitParameter 获取到初始化参数值
            System.out.println(element + " = " + config.getInitParameter(element));
        }

        // 获取到null的参数值
        String initParameter = config.getInitParameter(null);
        System.out.println("initParameter = " + initParameter);

        // 这个对比servletcontext获取null参数名对应的参数值的情况
        // 此时会抛出NPE异常
        try {
            String initParameter1 = servletContext.getInitParameter(null);
            System.out.println("initParameter1 = " + initParameter1);
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
