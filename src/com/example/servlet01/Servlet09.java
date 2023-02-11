package com.example.servlet01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 *      客户端发送请求，通过resp.sendRedirect("url")，客户端会重新向url发送一次请求
 *      所以重定向会导致地址栏发生变化，第一次请求的数据不会传到第二次中
 */
@WebServlet("/ser09")
public class Servlet09 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受参数
        String uname = req.getParameter("uname");
        System.out.println("Servlet09 "+uname);
        resp.sendRedirect("ser10");
    }
}
