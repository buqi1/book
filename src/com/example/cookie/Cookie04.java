package com.example.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie的路径
 *      记住：只要访问的路径包含cookie的路径。该请求就要带上这个cookie
 *            不包含就不带上
 */
@WebServlet("/coo04")
public class Cookie04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "name";
        String value = "zhangsan";
        Cookie cookie = new Cookie(name,value);
        //设置cookie的路径
        cookie.setPath("/servlet");
        resp.addCookie(cookie);

    }
}
