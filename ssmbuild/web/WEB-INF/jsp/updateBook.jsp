<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/8/9
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <%--修改的 没有id  前端传递隐藏域--%>
        <input type="hidden" name="bookID" value="${Qbooks.bookID}">

        <div class="form-group">
            <label for="name">书籍名称</label>
            <input type="text" name="bookName" class="form-control" id="name" value="${Qbooks.bookName}" required>
        </div>
        <div class="form-group">
            <label for="counts">书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" value="${Qbooks.bookCounts}" id="counts" required>
        </div>
        <div class="form-group">
            <label for="detail">书籍描述</label>
            <input type="text" name="detail" class="form-control" value="${Qbooks.detail}" id="detail" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>
    </form>


</div>
</body>
</html>
