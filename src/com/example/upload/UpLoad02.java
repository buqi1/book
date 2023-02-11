package com.example.upload;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *后台实现文件的下载
 *      1.通过response.setContentType方法设置Content-type头字段的值，
 *          为浏览器无法使用某种方式或激活某个程序来处理的MIME类型
 *          application/octet-stream或application/x-msdownload
 *      2.通过response.setHeader方法设置Content-Disposition头的值为attachment;filename=文件名
 *      3.读取文件内容，调用response.getOutputStream方法向客户端写入附件内容
 */
@WebServlet("/ul02")
public class UpLoad02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("后台下载文件...");
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //获取前台输入的文件名
        String fileName = req.getParameter("fileName");
        //判断输入的文件名是否为空
        if (fileName == null || "".equals(fileName.trim())) {
            resp.getWriter().write("请重新输入下载的文件名");
            resp.getWriter().close();
            return;
        }
        //得到文件存放的位置（要下载的文件的具体位置）
        String realPath = req.getServletContext().getRealPath("/download/");
        //通过路径得到file对象(拿到了要下载的文件)
        File file = new File(realPath + fileName);
        //判断文件是否存在并且文件是标准文件
        if (file.exists() && file.isFile()) {
            //设置响应类型（浏览器无法使用某种方式或激活某个程序来处理的MIME类型）
            resp.setContentType("application/x-msdownload");
            //设置响应头
            resp.setHeader("Content-Disposition","attachment;filename="+fileName);
            //响应文件
            //得到输入流
            InputStream in = new FileInputStream(file);
            //得到字节输出流
            ServletOutputStream out = resp.getOutputStream();
            //输出资源
            //定义数组
            byte[] bytes = new byte[1024];
            //定义长度
            int len = 0;
            //循环输出
            while ((len = in.read(bytes)) != -1){
                //输出
                out.write(bytes,0,len);
            }
            //关闭资源
            out.close();
            in.close();
        }else {
            resp.getWriter().write("文件不存在，请重新输入");
            resp.getWriter().close();
        }
    }
}
