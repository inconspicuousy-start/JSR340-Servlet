package com.inconspicuousy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @author peng.yi
 */
@WebServlet(value = "/cookie-session-servlet")
public class CookieSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("==========开始处理Session和Cookie==========");
        // 从请求头Cookie中获取到所有的Cookie对象，如果不存在Cookie头不存在则返回null
        Cookie[] cookies = req.getCookies();
        System.out.println("cookies = " + Arrays.toString(cookies));
        if (Objects.nonNull(cookies)) {
            Arrays.stream(cookies).forEach(cookie -> {
                String name = cookie.getName();
                System.out.println("name = " + name);
                String value = cookie.getValue();
                System.out.println("value = " + value);
                // 获取到Cookie的最大生存时间，默认是当浏览器关闭Cookie销毁时返回-1
                int maxAge = cookie.getMaxAge();
                System.out.println("maxAge = " + maxAge);
            });
        }

        // 获取到当前的Session对象， 如果不存在创建Session对象
        // 创建的Session对象会随着响应信息作为Cookie返回给客户端
        HttpSession session = req.getSession();
        System.out.println("session = " + session);
        // Session对象以键值对的形式维护了多个属性和属性值。
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String sessionName = attributeNames.nextElement();
            System.out.println("sessionName = " + sessionName);
            Object sessionValue = session.getAttribute(sessionName);
            System.out.println("sessionValue = " + sessionValue);
        }
        // 设置一组Session的属性和属性值
        session.setAttribute("SESSION_ID", "SESSION_VALUE");

    }
}
