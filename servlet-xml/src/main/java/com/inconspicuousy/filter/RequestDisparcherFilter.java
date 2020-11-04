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
 * 对所有的REQUEST请求进行过滤处理
 * @author peng.yi
 */
@WebFilter(value = "/*", dispatcherTypes = DispatcherType.REQUEST)
public class RequestDisparcherFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("RequestDisparcherFilter.doFilter => chain.doFilter => PRE ");
        chain.doFilter(req, res);
        System.out.println("RequestDisparcherFilter.doFilter => chain.doFilter => POST ");
    }
}
