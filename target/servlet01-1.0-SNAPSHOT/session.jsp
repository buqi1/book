<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2023/2/9
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--java脚本段--%>
    <%
        //获取session域对象
        String uname = (String) request.getSession().getAttribute("uname");
        String upwd = (String) request.getSession().getAttribute("upwd");
        //获取request域对象
        String name = (String) request.getAttribute("name");

        //在浏览器显示（输出内容）
        ServletOutputStream servletOutputStream = response.getOutputStream();
        servletOutputStream.print("uname:"+uname+",upwd:"+upwd+",name:"+name);
    %>

</body>
</html>
