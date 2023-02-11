package com.example.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Session域对象
 *      设置域对象   session.setAttribute()
 *      获取域对象   request.getSession().getAttribute()
 *      移除域对象   removeAttribute()
 *
 *      请求转发
 *          一次请求
 *          request作用域有效
 *          session作用域有效
 *      重定向
 *          两次请求
 *          request作用域无效
 *          session作用域有效
 */
@WebServlet("/sess02")
public class Session02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象
        HttpSession session = req.getSession();
        //设置Session域对象
        session.setAttribute("uname", "admin");
        session.setAttribute("upwd", "123456");

        //移除session域对象
        session.removeAttribute("upwd");

        //设置request域对象
        req.setAttribute("name","zhangsan");

        //请求转发
        //req.getRequestDispatcher("session.jsp").forward(req,resp);

        //重定向
        resp.sendRedirect("session.jsp");
    }
}
