<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/8/10
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.post("${pageContext.request.contextPath}/a2", function (data) {
                    console.log(data)
                    //http://localhost:8087/test2.jsp
                    //     [
                    //     {
                    //         "name": "java",
                    //         "age": 10
                    //     },
                    //         {
                    //             "name": "mysql",
                    //             "age": 11
                    //         }
                    //     ]
                    var html = "";
                    for (let i = 0; i < data.length; i++) {
                        html += "<tr>" +
                            "<td>" + data[i].name + "</td>" +
                            "<td>" + data[i].age + "</td>" +
                            "</tr>"
                    }
                    $("#content").html(html);
                });

            })
        });
    </script>
</head>
<body>
<input type="button" value="加载数据" id="btn">
<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
    </tr>
    <tbody id="content">

    </tbody>
</table>

</body>
</html>
