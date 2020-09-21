<%@ page import="java.util.List" %>
<%@ page import="entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/5 0005
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="2" align="center">
        <tr>
            <td>题目编号</td>
            <td>题目信息</td>
            <td>A</td>
            <td>B</td>
            <td>C</td>
            <td>D</td>
            <td>答案</td>
            <td colspan="2" align="center">操作</td>

        </tr>


        <%
        List<Question> list =(List) request.getAttribute("key");
            for (Question question:list) {

         %>
        <tr>
            <td><%=question.getQuetionId()%></td>
            <td><%=question.getTitle()%></td>
            <td><%=question.getOptionA()%></td>
            <td><%=question.getOptionB()%></td>
            <td><%=question.getOptionC()%></td>
            <td><%=question.getOptionD()%></td>
            <td><%=question.getAnswer()%></td>
            <td><a href="/myWeb/question/findById?questionId=<%=question.getQuetionId()%>">查看详情</a></td>
            <td><a href="/myWeb/question/delete?questionId=<%=question.getQuetionId()%>">删除</a></td>
        </tr>

        <%
            }

        %>
    </table>
</body>
</html>
