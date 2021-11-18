<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Config</title>
</head>
<body>
    <h1>Config</h1>
    <p>Language: ${mail.language}</p>
    <p>page_size: ${mail.page_size}</p>
    <p>spams_filter: ${mail.spams_filter}</p>
    <p>signature: ${mail.signature}</p>
    <form:form action="/edit" method="post" modelAttribute="mail">
        <form:input type="hidden" path="language" value="${mail.language}"></form:input>
        <form:input type="hidden" path="page_size" value="${mail.page_size}"></form:input>
        <form:input type="hidden" path="spams_filter" value="${mail.spams_filter}"></form:input>
        <form:input type="hidden" path="signature" value="${mail.signature}"></form:input>
        <input type="submit" value="edit">
    </form:form>
</body>
</html>
