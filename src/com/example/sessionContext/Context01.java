package com.example.sessionContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * SessionContext对象的获取
 *      1.通过request获取
 *      2.通过session获取
 *      3.通过sessionConfig获取
 *      4.直接获取
 *
 *    常用方法
 *      1.获取服务器版本信息     getServerInfo()
 *      2.获取项目的真实路径     getRealPath()
 */
@WebServlet("/con01")
public class Context01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request获取
        ServletContext servletContext1 = req.getServletContext();

        //通过session获取
        ServletContext servletContext2 = req.getSession().getServletContext();

        //通过sessionConfig获取
        ServletContext servletContext3 = getServletConfig().getServletContext();

        //直接获取
        ServletContext servletContext4 = getServletContext();

        //获取服务器版本信息
        String serverInfo = servletContext1.getServerInfo();
        System.out.println("服务器版本信息:"+serverInfo);
        //获取项目的真实路径
        String contextPath = servletContext1.getRealPath("/");
        System.out.println("项目的真实路径:"+contextPath);
        System.out.println("------------");
    }
}
