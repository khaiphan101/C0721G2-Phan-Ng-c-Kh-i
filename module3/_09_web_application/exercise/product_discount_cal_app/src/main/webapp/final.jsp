<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/26/2021
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <label>discount amount</label>
    <h2>
        <%= request.getAttribute("resultFromServlet")%>
    </h2>
    <label>Discount Price</label>
    <h2>
        <%= request.getAttribute("resultFromServlet1")%>
    </h2>
</body>
</html>
