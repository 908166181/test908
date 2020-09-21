<%@ page import="java.util.List" %>
<%@ page import="entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/5 0005
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<form action="/myWeb/question/answer" method="get">
    <table border="2" align="center">
        <tr>
            <td>编号</td>
            <td>题目</td>
            <td>A</td>
            <td>B</td>
            <td>C</td>
            <td>D</td>

            <td colspan="2" align="center">选项</td>

        </tr>
        <%
            List<Question> list =(List) session.getAttribute("key");
            for (Question question:list) {

        %>
        <tr>
            <td><%=question.getQuetionId()%></td>
            <td><%=question.getTitle()%></td>
            <td><%=question.getOptionA()%></td>
            <td><%=question.getOptionB()%></td>
            <td><%=question.getOptionC()%></td>
            <td><%=question.getOptionD()%></td>
            <td><input type="radio" name="answer_<%=question.getQuetionId()%>" value="A">
                <input type="radio" name="answer_<%=question.getQuetionId()%>" value="B">
                <input type="radio" name="answer_<%=question.getQuetionId()%>" value="C">
                <input type="radio" name="answer_<%=question.getQuetionId()%>" value="D">
            </td>

        </tr>

        <%
            }

        %>

        <tr align="center">
            <td colspan="3"><input type="submit" value="提交"></td>
            <td colspan="4"><input type="reset" value="重做"></td>

        </tr>
    </table>
</form>

</body>
</html>
