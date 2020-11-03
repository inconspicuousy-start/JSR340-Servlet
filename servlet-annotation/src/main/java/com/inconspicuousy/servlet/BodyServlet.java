package com.inconspicuousy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author peng.yi
 */
@WebServlet(value = "/body")
public class BodyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("======开始处理请求体信息======");

        System.out.println("==========调用getReader之前");
        // 以Map的形式获取到所有的参数名和参数值
        System.out.println("=====map======");
        Map<String, String[]> parameterMap = req.getParameterMap();
        parameterMap.forEach((key, value) -> {
            System.out.println("key = " + key);
            System.out.println("value = " + Arrays.toString(value));
        });

        // 读取到所有的正文信息
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        reader.lines().forEach(stringBuilder::append);
        System.out.println("==========调用getReader");
        System.out.println("stringBuilder.toString() = " + stringBuilder.toString());

        System.out.println("==========调用getReader之后");

        // 获取到所有的参数名称列表
        System.out.println("======getParameterNames======");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            System.out.println("key = " + key);
            // 获取到参数名对应的参数值
            String parameterValues = req.getParameter(key);
            System.out.println("parameterValues = " + parameterValues);
        }

    }
}
