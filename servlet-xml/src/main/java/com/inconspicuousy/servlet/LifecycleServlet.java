package com.inconspicuousy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author peng.yi
 */
public class LifecycleServlet extends HttpServlet {

    public LifecycleServlet() {
        super();
        System.out.println("LifecycleServlet.LifecycleServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("LifecycleServlet.doGet");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("LifecycleServlet.service");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("LifecycleServlet.destroy");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("LifecycleServlet.init");
    }
}
