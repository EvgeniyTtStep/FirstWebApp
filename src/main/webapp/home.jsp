<%--
  Created by IntelliJ IDEA.
  User: Evgeniy
  Date: 06.04.2021
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Users names</h1>
<p><strong>First:</strong> <% out.println(request.getAttribute("firstUser"));%> </p>
<p><strong>Second:</strong><%= request.getAttribute("secondUser")%></p>
<p><strong>Description:</strong>${desc}</p> <%--description language--%>
</body>
</html>
