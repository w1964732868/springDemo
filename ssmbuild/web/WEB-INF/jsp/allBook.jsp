<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/8/8
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示页面</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表==========显示所有书籍</small>
                </h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddPaper">新增书籍</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示全部书籍</a>
            </div>
            <div class="col-md-4 colum">
                <%--查询书籍--%>
                <form action="${pageContext.request.contextPath}/book/queryBook" method="post" style="float:right">
                    <input type="text" name="queryBookByName" class="form-cotrol" placeholder="请输入要查询的书籍名称">
                    <input type="submit" value="查询" class="btn btn-primary">
                    <span style="color: red; font-weight: bold">${error}</span>
                </form>
            </div>
        </div>

    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>书籍标号</tr>
                <tr>书籍名称</tr>
                <tr>书籍数量</tr>
                <tr>书籍详情</tr>
                <tr>操作</tr>
                </thead>
            </table>
            <tbody>
            <c:forEach var="book" items="${list}">
                <tr>
                    <td>${book.bookID}</td>
                    <td>${book.bookName}</td>
                    <td>${book.bookCounts}</td>
                    <td>${book.detail}</td>
                    <td>

                        <a href="${pageContext.request.contextPath}/book/toUpdatePaper?id=${book.bookID}">修改</a>
                        &nbsp | &nbsp
                        <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>
                            <%--<a href="${pageContext.request.contextPath}/book/deleteBook?id=${book.bookID}">删除</a>--%>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </div>
    </div>
</div>

</body>
</html>
