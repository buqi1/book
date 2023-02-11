package com.example.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Session对象
 *      获取session               req.getSession()
 *      获取session的id（标识符）   session.getId()
 */
@WebServlet("/sess01")
public class Session01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象(存在session对象就获取，不存在就创建)
        HttpSession session = req.getSession();
        //获取session的id（标识符）
        String id = session.getId();
        System.out.println(id);
    }
}
