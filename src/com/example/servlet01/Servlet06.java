package com.example.servlet01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ser06")
public class Servlet06 extends HttpServlet {
    /**
     * //设置域对象内容
     * req.setAttribute("","");
     * //获取域对象内容
     * req.getAttribute("");
     * //删除域对象内容
     * req.removeAttribute("");
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet06...");
        //设置域对象内容
        req.setAttribute("name","admin");
        req.setAttribute("age",18);
        req.getRequestDispatcher("ser07").forward(req,resp);
    }
}
