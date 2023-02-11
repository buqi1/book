package com.example.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 设置cookie的到期时间
 *      到期时间：负整数（表示关闭浏览器。cookie才会失效）    默认值
 *      到期时间：正整数（表示cookie存活的时间（30秒）。cookie才会失效）
 *      到期时间：零（表示删除cookie）
 */
@WebServlet("/coo03")
public class Cookie03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //到期时间：负整数（表示关闭浏览器。cookie才会失效）
        Cookie cookie1 = new Cookie("name1", "zhangsan");
        //设置cookie的到期时间
        cookie1.setMaxAge(-1);
        //发送cookie数据
        resp.addCookie(cookie1);

        //到期时间：正整数（表示cookie存活的时间（30秒）。cookie才会失效）
        Cookie cookie2 = new Cookie("name2", "lisi");
        //设置cookie的到期时间
        cookie2.setMaxAge(30);
        //发送cookie数据
        resp.addCookie(cookie2);

        //到期时间：零（表示删除cookie）
        Cookie cookie3 = new Cookie("name3", "wangwu");
        //设置cookie的到期时间
        cookie3.setMaxAge(0);
        //发送cookie数据
        resp.addCookie(cookie3);
    }
}
