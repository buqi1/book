package com.example.servlet01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet的生命周期分为三步 （创建和实例化->服务阶段->销毁阶段）
 */
@WebServlet("/ser05")
public class Servlet05  extends HttpServlet {
    /**
     * 服务器自动调用，只调用一次
     * 当请求到达容器（服务器），容器会检查该servlet对象是否存在，如果不存在，就创建实例并初始化
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        System.out.println("servlet创建了..");
    }

    /**
     * 可以多次调用（浏览器可以多次访问）
     * 容器调用servlet的service()方法，处理请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet调用了");
    }

    /**
     * 当容器关闭（服务器停止时），会将servlet实例进行销毁
     */
    @Override
    public void destroy() {
        System.out.println("servlet销毁了");
    }
}
