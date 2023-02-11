package com.example.servlet01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向与请求转发的区别
 *      1.重定向resp.sendRedirect("index.jsp")     重定向是response 从服务器传过来进行处理，是客户端的行为
 *        请求转发req.getRequestDispatcher("index.jsp").forward(req,resp);  请求转发是客户端发送到服务器进行处理，是服务端行为
 *      2.重定向是两次请求，请求转发是一次请求
 *      3.重定向是两次请求，所以他的地址栏发生了变化，请求转发没有
 *      4.重定向第二次请求是一个新的请求，所以数据是还不共享的（不能用第一次请求的数据），请求转发数据可以共享
 *      5.重定向时的地址是任意的，而请求转发的地址是当前站点下的（当前项目存在的地址）
 *    重定向：一个新的任意的地址
 *    请求转发：/servlet/url,在servlet后面加上请求转发的地址
 */
@WebServlet("/ser11")
public class Servlet11 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet11...");
        //获取参数
        String uname = req.getParameter("uname");
        System.out.println("Servlet11 uname"+uname);

        //设置作用域
        req.setAttribute("upwd","123123");

        //请求转发
        //req.getRequestDispatcher("index.jsp").forward(req,resp);

        //重定向
        resp.sendRedirect("index.jsp");
    }
}
