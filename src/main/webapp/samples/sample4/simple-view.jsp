<%--
  ~ Aleksander Spyra for Software Development Academy, Wroclaw 2018
  --%>

<%--
  Created by IntelliJ IDEA.
  User: x220
  Date: 2018-05-06
  Time: 07:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prosty widok</title>
</head>
<body>

<%
    String[] students = (String[])request.getAttribute("student_list");
    for (String s : students) {
        out.println("<p>" + s + "</p>");
    }
%>

</body>
</html>
