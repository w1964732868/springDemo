<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/8/12
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<%--在web-inf下的所有页面或资源 只能通过controller或servlet进行访问--%>
<body>
<h1>登录页面</h1>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名:<input type="text" name="username">
    密码:<input type="text" name="password">
    <input type="submit" value="提交">
</form>
</body>
</html>
