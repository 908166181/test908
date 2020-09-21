<%@ page import="java.awt.*" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/7 0007
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">

        function one () {
            <%List<String> jsonlist=(List)request.getAttribute("key");
            for (String json:jsonlist){

            %>
            var obj=<%=json%>;

            var tr=document.createElement("tr");
            var td1=document.createElement("td");
            var td2=document.createElement("td");
            var td3=document.createElement("td");
            var td4=document.createElement("td");
            var td5=document.createElement("td");
            td1.innerHTML=obj.sid;
            td2.innerHTML=obj.sname;
            td3.innerHTML=obj.password;
            td4.innerHTML=obj.sex;
            td5.innerHTML=obj.email;
            tr.appendChild(td1)
            tr.appendChild(td2)
            tr.appendChild(td3)
            tr.appendChild(td4)
            tr.appendChild(td5)
            document.getElementById("table").appendChild(tr);


            <%

        }

        %>


        }
    </script>
</head>
<body onload="one()">






<table border="2" align="center" id="table">
    <tr>
        <td>学生编号</td>
        <td>学生姓名</td>
        <td>密码</td>
        <td>性别</td>
        <td>邮箱</td>
    </tr>




</table>
</body>
</html>
