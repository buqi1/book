package com.example.servlet01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ser03")
public class Servlet03 extends HttpServlet {
    /**
     * 利用req.getRequestDispatcher("url").forward(req,resp)
     *      可以将请求转发到ser04,login.jsp页面等
     *      但是一个请求只能转发一次
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求传进来的参数
        String uname = req.getParameter("uname");
        System.out.println("Servlet03.uname:"+uname);
        //请求转发跳转到Servlet04
        //req.getRequestDispatcher("ser04").forward(req,resp);
        //请求转发跳转到login.jsp
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
}
