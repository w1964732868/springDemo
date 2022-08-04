<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/8/4
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--http://localhost:8081/addRequestResFul/1/2 请求方法: POST--%>

<%--//http://localhost:8081/addRequestResFul/1/2--%>
<%--//结果为3--%>

<%--报405  请求出问题了
500的错误是代码问题--%>
<form action="/addRequestResFul/1/2" method="post">
    <input type="submit">

</form>
</body>
</html>
