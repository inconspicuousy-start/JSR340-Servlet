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
            // 登录，验证提供的用户名和密码
            // 由Web容器提供的登录机制验证用户名和密码
            req.login("test", "test");
        } catch (ServletException e) {
            System.out.println("登录失败 | errMsg => " + e.getMessage());
        }

        // 获取登录成功的用户的用户名
        String remoteUser = req.getRemoteUser();
        System.out.println("remoteUser = " + remoteUser);

        // 返回当前Servlet容器认证的方式
        String authType = req.getAuthType();
        System.out.println("authType = " + authType);

        // 返回当前认证成功的用户对应的Principal对象
        Principal userPrincipal = req.getUserPrincipal();
        if (Objects.nonNull(userPrincipal)) {
            System.out.println("userPrincipal = " + userPrincipal.getName());
        } else {
            System.out.println("userPrincipal = null");
        }

        // 判断用户是否包含某个角色
        boolean admin = req.isUserInRole("admin");
        System.out.println("admin = " + admin);

        // 判断用户的认证状态
        boolean authenticate = req.authenticate(resp);
        System.out.println("authenticate = " + authenticate);

        // 退出登录
        req.logout();
    }
}
