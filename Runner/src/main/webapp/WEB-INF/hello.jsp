<%@ page language="java" contentType="text/html; charset=utf-8"

    pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() 
            + ":" + request.getServerPort() + path + "/";
%>
<!-- HTML代码 -->
<!DOCTYPE html>
<html>
<head>
    <base href="<%= basePath %>">
    <meta charset="UTF-8">
    <title>Document title</title>
</head>
<body>
    helloworld
</body>
</html>