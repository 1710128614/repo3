<%--
  Created by IntelliJ IDEA.
  User: hhl
  Date: 2021-07-05
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学员信息列表</title>
    <style type="text/css">
        div {
            width: 600px;
            margin: 0 auto;
            text-align: center;
        }

        #show {
            line-height: 60px;
            font-size: large;
        }
        p{
            color: red;
            font-weight: bolder;
            font-size: 18px;
        }
    </style>
</head>
<body>
<div>
    <table border="1">
        <tr>
            <th colspan="6" id="show">学员信息列表</th>
        </tr>
        <tr style="background-color: aquamarine">
            <td>编号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>住址</td>
            <td>Email</td>
        </tr>
        <c:if test="${not empty requestScope.infoList}">
            <c:forEach var="list" items="${requestScope.infoList}" varStatus="vs">
                <tr <c:if test="${vs.index%2==1}">style="background-color: cyan"</c:if>>
                    <td><a href="update.jsp">${list.sid}</a></td>
                    <td>${list.sname}</td>
                    <td>${list.sgender}</td>
                    <td>${list.sage}</td>
                    <td>${list.saddress}</td>
                    <td>${list.semail}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <p> zda</p>
</div>
</body>
</html>