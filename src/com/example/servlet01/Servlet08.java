package com.example.servlet01;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * //获取响应数据的字符流
 *   resp.getWriter();
 * //获取响应数据的一切数据
 *   resp.getOutputStream();
 *   响应回的数据到客户端被浏览器解析
 *   注意，两者不能同时使用
 */
@WebServlet("/ser08")
public class Servlet08 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取响应数据的字符流
//        PrintWriter writer = resp.getWriter();
//        writer.write("hello");
        //获取响应数据的
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.println("world");
    }
}
