<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>主页</title>
    </head>

    <body>
<%--    java脚本段--%>
        <%
            //获取参数
            String uname = request.getParameter("uname");
            //获取域对象内容
            String upwd = (String) request.getAttribute("upwd");

            //字节流输出内容
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.print(uname);
            outputStream.print("--------");
            outputStream.print(upwd);
        %>
    </body>
</html>