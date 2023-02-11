package com.example.upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * 文件上传
 *      使用@MultipartConfig将servlet标识为支持文件上传
 *      servlet将multipart/form-data的POST请求封装成Part对象，通过Part对文件上传进行操作
 */
@WebServlet("/ul01")
@MultipartConfig
public class UpLoad01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("文件上传...");
        //设置文件的编码格式
        req.setCharacterEncoding("UTF-8");
        //获取前台传来的参数
        String uname = req.getParameter("uname");
        System.out.println("uname:" + uname);

        //获取Part对象（因为POST请求已经被封装成Part对象）
        Part part = req.getPart("myfile");

        //获取文件名
        String name = part.getSubmittedFileName();
        System.out.println("name:"+ name);

        //获取文件存放的地址
        String realPath = req.getServletContext().getRealPath("/");
        System.out.println("文件存放的地址："+realPath);

        //上传文件到指定目录
        part.write(realPath+"/"+name);
    }
}
