<%@ page import="entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/5 0005
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Question question =(Question) request.getAttribute("key");
%>

    <form action="/myWeb/question/update" method="get" >
        <table align="center" border="2">
            <tr>
                <td>题目编号:</td>
                <td><input type="text" name="questionId" value="<%=question.getQuetionId()%>" readonly/></td>
            </tr>
            <tr>
                <td>题目:</td>
                <td><input type="text" name="title" value="<%=question.getTitle()%>"/></td>
            </tr>
            <tr>
                <td>A:</td>
                <td><input type="text" name="optionA" value="<%=question.getOptionA()%>"/></td>
            </tr>
            <tr>
                <td>B:</td>
                <td><input type="text" name="optionB" value="<%=question.getOptionB()%>"/></td>
            </tr>
            <tr>
                <td>C:</td>
                <td><input type="text" name="optionC" value="<%=question.getOptionC()%>"/></td>
            </tr>
            <tr>
                <td>D:</td>
                <td><input type="text" name="optionD" value="<%=question.getOptionD()%>"/></td>
            </tr>
            <tr>
                <td>正确答案</td>
                <td><input type="radio" name="answer" value="A"<%="A".equals(question.getAnswer())?"Checked":""%>/>
                    <input type="radio" name="answer" value="B"<%="B".equals(question.getAnswer())?"Checked":""%>/>
                    <input type="radio" name="answer" value="C"<%="C".equals(question.getAnswer())?"Checked":""%>/>
                    <input type="radio" name="answer" value="D"<%="D".equals(question.getAnswer())?"Checked":""%>/>

                </td>
            </tr>
            <tr align="center">
                <td><input type="submit" value="更新"/></td>
                <td><input type="reset" value="重置"/></td>
            </tr>



        </table>



    </form>
</body>
</html>
