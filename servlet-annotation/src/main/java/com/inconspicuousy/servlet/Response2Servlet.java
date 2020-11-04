package com.inconspicuousy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * @author peng.yi
 */
@WebServlet(value = "/response2")
public class Response2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=======Servlet2接收到GET请求======");
        // 设置状态码
        resp.setStatus(HttpServletResponse.SC_OK);
        // 通过setHeader、addHeader设置头部信息
        resp.setHeader("Self", "inconspicuousy");
        resp.addHeader("Self", "inconspicuousy_add");
        // 设置MIME媒体类型的同时指定编码（指定编码方式为ISO-8859-1，看setCharacterEncoding是否会覆盖该编码）
        resp.setContentType("text/plain;charset=ISO-8859-1");
        // 设置本地化信息的同时，指定相应的编码
        resp.setLocale(Locale.CHINA);
        // 设置编码方式
        resp.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        PrintWriter writer = resp.getWriter();
        writer.println("redirect .... ");
        writer.flush();
        writer.close();
    }
}
