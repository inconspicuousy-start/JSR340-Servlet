package com.inconspicuousy.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Set;

/**
 * @author peng.yi
 */
public class ReourceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取到上下文对象
        ServletContext servletContext = this.getServletContext();
        // 返回Web应用的上下文路径，也就是浏览器访问到项目的相对路径
        String contextPath = servletContext.getContextPath();
        System.out.println("contextPath = " + contextPath);

        // 返回一个Set集合，集合中包含指定资源目录中子目录和文件的路径名称，不包含子目录的下级文件
        // 参数必须以/开始，表示根路径
        System.out.println("servletContext.getResourcePaths(\"/\")");
        Set<String> resourcePaths = servletContext.getResourcePaths("/");
        resourcePaths.forEach(System.out::println);

        System.out.println(" servletContext.getResourcePaths(\"/META-INF\")");
        Set<String> resourcePaths1 = servletContext.getResourcePaths("/META-INF");
        resourcePaths1.forEach(System.out::println);

        // 返回指定的资源文件在服务器文件系统上的真实路径（绝对路径）
        String realPath = servletContext.getRealPath("/");
        System.out.println("realPath = " + realPath);

        // 返回某个资源文件对应的URL对象
        URL resource = servletContext.getResource("/");
        System.out.println("resource = " + resource);

        // 返回某个资源文件对应的 InputStream 输入流
        // 该路径应该指向某个具体的资源文件，这样才能获取到输入流， 否则返回null
        InputStream resourceAsStream = servletContext.getResourceAsStream("/");
        System.out.println("resourceAsStream = " + resourceAsStream);

        InputStream resourceAsStream1 = servletContext.getResourceAsStream("/index.jsp");
        System.out.println(resourceAsStream1);

        // 打印index.jsp
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream1));
        String temp;
        while ((temp = reader.readLine()) != null) {
            System.out.println("temp = " + temp);
        }
    }
}
