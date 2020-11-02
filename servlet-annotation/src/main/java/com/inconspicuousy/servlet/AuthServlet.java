package com.inconspicuousy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Objects;

/**
 * @author peng.yi
 */
@WebServlet(value = "/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=======开始处理认证相关信息=======");

        try {
            req.login("admin", "admin");
        } catch (ServletException e) {
            System.out.println("登录失败 | errMsg => " + e.getMessage());
        }

        String remoteUser = req.getRemoteUser();
        System.out.println("remoteUser = " + remoteUser);

        String authType = req.getAuthType();
        System.out.println("authType = " + authType);

        Principal userPrincipal = req.getUserPrincipal();
        if (Objects.nonNull(userPrincipal)) {
            System.out.println("userPrincipal = " + userPrincipal.getName());
        } else {
            System.out.println("userPrincipal = null");
        }

        boolean admin = req.isUserInRole("admin");
        System.out.println("admin = " + admin);

        boolean authenticate = req.authenticate(resp);
        System.out.println("authenticate = " + authenticate);

        req.logout();
    }
}
