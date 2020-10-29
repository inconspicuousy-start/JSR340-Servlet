package com.inconspicuousy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解析请求头中 关于请求客户端和服务端的主机名和端口号
 * @author peng.yi
 */
@WebServlet(value = "/request-host")
public class RequestHostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("========获取请求头中关于主机名和端口号的信息=======");

        // 客户端主机名
        String remoteHost = req.getRemoteHost();
        System.out.println("remoteHost = " + remoteHost);

        // 客户端IP地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println("remoteAddr = " + remoteAddr);

        // 客户端端口号
        int remotePort = req.getRemotePort();
        System.out.println("remotePort = " + remotePort);

        // 服务端的IP地址
        String localAddr = req.getLocalAddr();
        System.out.println("localAddr = " + localAddr);

        // 服务端的主机名
        String localName = req.getLocalName();
        System.out.println("localName = " + localName);

        // 服务端的端口号
        int localPort = req.getLocalPort();
        System.out.println("localPort = " + localPort);

        // Host请求头中主机名
        String serverName = req.getServerName();
        System.out.println("serverName = " + serverName);

        // Host请求中端口号
        int serverPort = req.getServerPort();
        System.out.println("serverPort = " + serverPort);

    }
}
