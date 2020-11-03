package com.inconspicuousy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Enumeration;

/**
 * @author peng.yi
 */
@WebServlet(value = "/header")
// 通过MultipartConfig 来配置multipart/form-data的属性， 如果不配置处理Part会抛出异常
@MultipartConfig(maxFileSize = Integer.MAX_VALUE, maxRequestSize = Integer.MAX_VALUE, fileSizeThreshold = Integer.MAX_VALUE)
public class HeaderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("====开始处理普通请求头信息====");

        // 获取请求的MIME类型
        String contentType = req.getContentType();
        System.out.println("contentType = " + contentType);

        // 获取到类型的字节长度
        int contentLength = req.getContentLength();
        System.out.println("contentLength = " + contentLength);

        // 获取请求的编码方式
        String characterEncoding = req.getCharacterEncoding();
        System.out.println("characterEncoding = " + characterEncoding);

        // 获取到所有的请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println("headerName = " + headerName);
            String header = req.getHeader(headerName);
            // 获取到请求头对应的请求头值
            System.out.println("header = " + header);
        }

        Collection<Part> parts = req.getParts();
        parts.forEach(part -> {
            // 得到part的名称
            String name = part.getName();
            System.out.println("part name = " + name);
            // 得到part的MIME类型
            String partContentType = part.getContentType();
            System.out.println("partContentType = " + partContentType);
            // 得到Part的输入流，根据输出入流就可以获取到数据
            try (InputStream is = part.getInputStream()) {
                System.out.println("is = " + is);
            }catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
