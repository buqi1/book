package com.example.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Session对象的到期时间
 *      1.默认到期时间为30分钟（不建议修改）
 *      2.手动修改会话的到期时间（单个会话）     session.setMaxInactiveInterval()
 *      3.立即销毁          session.invalidate();
 *      4.关闭浏览器，session失效
 *          session底层依赖cookie,cookie对象默认只在浏览器的内存中存活，关闭浏览器则失效
 *      5。关闭服务器失效
 */
@WebServlet("/sess03")
public class Session03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象
        HttpSession session = req.getSession();
        //设置session作用域
        session.setAttribute("uname","admin");

        //手动修改
        session.setMaxInactiveInterval(15);//15秒后该会话失效

        //立即销毁
        session.invalidate();

    }
}
