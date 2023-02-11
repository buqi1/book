package com.example.servlet01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ser07")
public class Servlet07 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet07...");
        //获取域对象
        String name = (String) req.getAttribute("name");
        Integer age = (Integer) req.getAttribute("age");
        System.out.println("name:"+name);
        System.out.println("age:"+age);
    }
}
