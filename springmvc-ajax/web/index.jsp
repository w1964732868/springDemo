<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/8/9
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

      <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
      <script>
          // $.height
          // jQuery.height

          function a(){
              $.post({
                  url:"${pageContext.request.contextPath}/a1",
                  data:{"name":$("#username").val()},
                  success:function (data,status){
                      alert(data);
                      console.log("data:"+data)
                      console.log("status:"+status)//200成功 300重定向、转发 400客户端错误 500服务器错误
                  }
              })
          }

      </script>
  </head>
  <body>
  <%--失去焦点的时候 发起一个请求到后台--%>
  用户名：<input type="text" id="username" onblur="a()">
  </body>
</html>
