<%--
  Created by IntelliJ IDEA.
  User: hhl
  Date: 2021-07-05
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学员信息修改</title>
    <style type="text/css">
        div{
            width: 300px;
            margin: 0 auto;
        }
        #show{
            text-align: center;
            line-height: 60px;
            font-size: large;
        }
        th{
            background-color: aquamarine;
        }
    </style>
</head>
<body>
<div>
    <form action="" method="post">
        <table border="1">
            <tr>
                <th colspan="2" id="show">学员信息修改</th>
            </tr>
            <tr>
                <th>姓名：</th>
                <td><input type="text" name="sname"></td>
            </tr>
            <tr>
                <th>年龄：</th>
                <td><input type="text" name="sage"></td>
            </tr>
            <tr>
                <th>性别：</th>
                <td><input type="text" name="sgender"></td>
            </tr>
            <tr>
                <th>家庭住址：</th>
                <td><input type="text" name="saddress"></td>
            </tr>
            <tr>
                <th>Email：</th>
                <td><input type="text" name="semail"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><button type="submit">修改</button> &nbsp;&nbsp;&nbsp;<button type="reset">重置</button></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
