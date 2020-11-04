package com.inconspicuousy.filter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author peng.yi
 */
@WebFilter(value = "*.jsp", dispatcherTypes = DispatcherType.ERROR)
public class ErrorFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("ErrorFilter.doFilter => chain.doFilter => PRE");
        DispatcherType dispatcherType = req.getDispatcherType();
        System.out.println("抛出异常后 dispatcherType.name() = " + dispatcherType.name());
        chain.doFilter(req, res);
        System.out.println("ErrorFilter.doFilter => chain.doFilter => POST");
    }
}
