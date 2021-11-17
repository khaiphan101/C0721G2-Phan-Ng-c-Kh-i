<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Converter</title>
  </head>
  <body>
  <form action="/convert" method="post">
      <input type="number" name="usd" value="${usd}" placeholder="$$$"> USD
      <input value="${result}" placeholder="vnd"> VND
      <input type="submit" value="submit">
  </form>
  </body>
</html>
